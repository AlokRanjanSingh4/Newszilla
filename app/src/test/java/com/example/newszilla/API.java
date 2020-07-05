package com.example.newszilla;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class API {
    @Test
    public void testAvailability() throws Exception {
        URLConnection connection = new URL("http://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=06ca633b24624e66b4fa0a689a2c70fa").openConnection();
        InputStream response = connection.getInputStream();

        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response, Charset.defaultCharset()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                buffer.append(line);
            }
        }

        assert buffer.length() > 0;
    }
}
