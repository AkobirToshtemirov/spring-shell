package com.akobir.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class UrlShortener {

    private final Map<String, String> shortUrls = new HashMap<>();

    @ShellMethod("Shorten a URL")
    public String shortenUrl(String originalUrl) {
        if (shortUrls.containsKey(originalUrl)) {
            return "URL already shortened.";
        }

        String shortUrl = generateShortUrl(originalUrl);
        shortUrls.put(shortUrl, originalUrl);
        return "Shortened URL: " + shortUrl;
    }

    @ShellMethod("Get the original URL from a short URL")
    public String getUrl(String shortUrl) {
        String originalUrl = shortUrls.get(shortUrl);
        return originalUrl != null ? "Original URL: " + originalUrl : "URL not found.";
    }

    @ShellMethod("Delete a short URL")
    public String deleteUrl(String shortUrl) {
        String originalUrl = shortUrls.remove(shortUrl);
        return originalUrl != null ? "Deleted URL: " + originalUrl : "URL not found.";
    }

    private String generateShortUrl(String originalUrl) {

        if (originalUrl.length() <= 10) {
            return originalUrl;
        }

        return "short-" + originalUrl.hashCode();
    }
}
