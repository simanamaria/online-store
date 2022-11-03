package com.coherentsolutions.consoleApp.XML;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import com.coherentsolutions.store.Store;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductComparator {
    public List<Product> productsToSort(Store onlineStore) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Category category : onlineStore.getCategoryList()) {
            categoryProducts.addAll(category.getProductList());
        }
        return categoryProducts;
    }
    private static final Map<String, Comparator<Product>> COMPARATOR_MAP = new LinkedHashMap<String, Comparator<Product>>() {{
        put("name", Comparator.comparing(Product::getName));
        put("price", Comparator.comparing(Product::getPrice));
        put("rate", Comparator.comparing(Product::getRate));
    }};

    private Comparator<Product> ascDescComparator(Map.Entry<String, String> entry) {
        String comparatorName = entry.getKey();
        Comparator<Product> comparator = COMPARATOR_MAP.getOrDefault(comparatorName, null);

        if (entry.getValue().equals(WaysToSort.DESC.toString()) && Objects.nonNull(comparator)) {
            comparator = comparator.reversed();
        }
        return comparator;
    }

    private Comparator<Product> buildComparator(Map<String, String> comparatorConfig) throws Exception {
        return comparatorConfig.entrySet().stream()
                .map(this::ascDescComparator)
                .filter(Objects::nonNull)
                .reduce(Comparator::thenComparing)
                .orElseThrow(Exception::new);
    }

    private Stream<Product> productStream(Store onlineStore, Comparator<Product> comparator) {
        return productsToSort(onlineStore)
                .stream()
                .sorted(comparator);
    }

    public void sortProducts(Store onlineStore) throws Exception {
        XMLParser xmlParserObject = new XMLParser();
        Map<String, String> parserMap = xmlParserObject.getMap();
        Comparator<Product> productComparator = buildComparator(parserMap);
        Stream<Product> sortStream = productStream(onlineStore, productComparator);
        List<Product> products = sortStream.collect(Collectors.toList());
        for (Product product : products) {
            System.out.println(product);
        }
    }


    public void mostExpensive (Store onlineStore) {
        List<Product> topProductList = productsToSort(onlineStore);
        topProductList.sort((Comparator.comparing(Product::getPrice).reversed()));
        for (Product mostExpensiveProducts : topProductList.subList(0,5)){
            System.out.println(mostExpensiveProducts);
        }
    }};
