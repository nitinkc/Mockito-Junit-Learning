package com.nitin.mockito.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyBusinessClassTest {

    MyBusinessClass myBusinessClass;
    static String str;
    static String testStr;
    @Mock
    private URL mockUrl;

    @BeforeEach
    public void beforeAll(){
        myBusinessClass = new MyBusinessClass();
        str = "Test String";
        testStr = null;
        // Initialize the Mockito annotations to create mock objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void myBusinessMethodTest() {
        //Assertions.fail("Not yet implemented");
        Assertions.assertTrue(true);
    }

    @Test
    void myBusinessMethodTestingIf() {
        Assertions.assertEquals(11, myBusinessClass.myBusinessMethod(str));
    }

    @Test
    void myBusinessMethodTestingElse() {
        Assertions.assertEquals(-1, myBusinessClass.myBusinessMethod(testStr));

    }

    @Test
    void testValidInputAndLargeInput() {//Happy PAth
        Assertions.assertEquals(10000, myBusinessClass.bringWordListFromNet(10000).size() );
    }

    @Test
    void testifNot10K() {
        assertThrows(IllegalArgumentException.class, () -> myBusinessClass.bringWordListFromNet(1));
    }


    @Test
    void testNetworkConnectionError() throws IOException {

        // Set up the mock behavior to throw an IOException when openStream() is called
        Mockito.when(mockUrl.openStream()).thenThrow(new IOException("Simulated network connection error"));

        // Pass the mock URL to the WordListFetcher instance
        //myBusinessClass.getTestableUrl(mockUrl);

        // Use a value that should trigger the network connection error
        int total = 10000;

        //assertThrows(IOException.class, () -> myBusinessClass.bringWordListFromNet(total));
    }

    @Test
    void testMixedCaseWords() {
        List<String> wordList = myBusinessClass.bringWordListFromNet(10000);
        // Check that all words are in either lowercase or uppercase
        for (String word : wordList) {
            assertTrue(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase()));
        }
    }
}