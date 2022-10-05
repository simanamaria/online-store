package com.coherentsolutions.store;

import com.coherentsolutions.domain.Category;
import com.coherentsolutions.domain.Product;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StoreHelper {

    Store store;

    public StoreHelper(Store store) { this.store = store; }

    public  void  populateStore() {

        RandomStorePopulator random = new RandomStorePopulator();
        Map<Category, Integer> categoryMap = createCategoryMap();

        for (Map.Entry<Category, Integer> entry : categoryMap.entrySet()) {
            Random random1 = new Random();
            int nr = random1.nextInt(9) + 1;
            for (int i = 0; i < nr; i++) {

                Product product = new Product(
                        random.getProductName(entry.getKey().getName()),
                        random.getProductRate(),
                        random.getProductPrice());
                entry.getKey().addProduct(product);
            }
            this.store.addCategory(entry.getKey());
        }
    }
    private static Map<Category, Integer> createCategoryMap() {
        Map<Category, Integer> categoryIntegerMap = new HashMap<>();

        Reflections reflections = new Reflections("com.coherentsolutions.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends  Category> type : subTypes) {
            try {
                Random random = new Random();
                categoryIntegerMap.put(type.getConstructor().newInstance(), random.nextInt(10));
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryIntegerMap;


    }
}




