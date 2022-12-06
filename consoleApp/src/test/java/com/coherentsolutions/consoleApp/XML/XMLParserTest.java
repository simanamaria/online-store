package com.coherentsolutions.consoleApp.XML;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class XMLParserTest {

    @Test
    void testGetMap() {
        assertThrows(RuntimeException.class, () -> (new XMLParser()).getMap());
    }
}

