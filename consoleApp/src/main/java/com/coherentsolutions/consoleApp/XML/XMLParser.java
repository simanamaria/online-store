package com.coherentsolutions.consoleApp.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {
        private static final String FILE = "consoleApp/src/main/resources/config.xml";

    public Map<String, String> getMap() {
        Map<String, String> stringStringMap = new LinkedHashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(FILE));
            document.getDocumentElement().normalize();

            if (document.getFirstChild().hasChildNodes()){
            NodeList nodeList = document.getFirstChild().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++){
                Node nodeItem = nodeList.item(i);

                if (nodeItem.getNodeType() == Node.ELEMENT_NODE){
                    stringStringMap.put(nodeItem.getNodeName(), nodeItem.getTextContent());
                        }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return stringStringMap;
    }
    }

