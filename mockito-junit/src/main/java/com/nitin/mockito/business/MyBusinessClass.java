package com.nitin.mockito.business;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyBusinessClass {

    public Integer myBusinessMethod(String str){
        if(null != str){
            return str.length();
        }
        return -1;
    }


    public List<String> bringWordListFromNet(Integer total) {
        String url = "";
        if(total == 10000){
            url = getTestableUrl(total);
        }else {
            throw new IllegalArgumentException("Total should be = 10000");
        }

        Scanner s = getScannerFromURL(url);

        //Construct a list of Long Words
        List<String> list = new ArrayList<>();
        while (s.hasNext()) {
            String word = s.nextLine();
            list.add(word);
        }
        s.close();
        return list;
    }

    public String getTestableUrl(Integer total) {
        return "https://www.mit.edu/~ecprice/wordlist." + total.toString();
    }

    private Scanner getScannerFromURL(String URL) {
        //Read Files from the net
        Scanner s = null;
        try {
            //The English word List
            URL url = new URL(URL);
            s = new Scanner(url.openStream());
        } catch (IOException ex) {
            ex.printStackTrace(); // for now, simply output it.
        }
        return s;
    }
}
