package org.bova.interview.shortener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/*
    Video - https://www.youtube.com/watch?v=9L-S1TslVwY
 */
public class Shortener {

    /*
        <ShortenedURL, originalURL>
     */
    static Map<String, String> urlMap = new HashMap<>();

    /*
        <SEO word, SEO word couner>
     */
    static Map<String, Integer> urlCountersMap = new HashMap<>();


    static Set<String> randomStringsSet = new HashSet<>();

    static final String SHORTENER_SITE = "https://short.en";

    /*
        <originalURL, ShortenedURL>
     */
    static Map<String, String> urlMapShortened = new HashMap<>();


    /**
     * 1. Shortening of original URL by using provided SEO keyword. Keyword should be at max 20 symbols
     *
     *   Input:
     *   Original URL: https://blog.mysite.com/cool-article
     *   Keyword: BEST-ARTICLE
     *   Output:
     *   https://short.en/BEST-ARTICLE
     *
     *   https://short.en/1/BEST-ARTICLE
     *
     *       https://short.en/0/BEST-ARTICLE
     *
     *   ?? Many URL w the same SEO word?
     *
     *   prefix / postfix
     *
     *   https://short.en/BEST-ARTICLE/0
     *
     *   https://short.en/0/BEST-ARTICLE/
     *   https://short.en/999/BEST-ARTICLE/
     *
     *   https://short.en/<int url_id>/BEST-ARTICLE/
     *
     */
    public static String shorten(String originalURL, String seoWord) {
        StringBuffer shortenURL = new StringBuffer();

        // https://short.en
        shortenURL.append(SHORTENER_SITE);

        // https://short.en/
        shortenURL.append('/');

        // https://short.en/0
        Integer seoWordCounter = urlCountersMap.get(seoWord);
        if(seoWordCounter == null) {
            seoWordCounter = 0;
        } else {
            seoWordCounter++;
        }
        urlCountersMap.put(seoWord, seoWordCounter);
        shortenURL.append(seoWordCounter);

        // https://short.en/0/
        shortenURL.append('/');

        // https://short.en/1/BEST-ARTICLE
        shortenURL.append(seoWord);

        String shortenURLString = shortenURL.toString();

        urlMap.put(shortenURLString, originalURL);

        return shortenURLString;
    }

    /*
        TODO: add corner cases checks
     */
    public static String shorten(String originalURLString) {

        if(urlMapShortened.get(originalURLString) != null) {
            return urlMapShortened.get(originalURLString);
        }

        StringBuffer shortenURL = new StringBuffer();

        // https://short.en
        shortenURL.append(SHORTENER_SITE);

        // https://short.en/
        shortenURL.append('/');

        // https://short.en/oppoj
        String generatedString = generateRandomString();
        while(randomStringsSet.contains(generatedString)) {
            generatedString = generateRandomString();
        }
        randomStringsSet.add(generatedString);
        shortenURL.append(generatedString);

        String shortenURLString = shortenURL.toString();
        urlMapShortened.put(originalURLString, shortenURLString);
        urlMap.put(shortenURLString, originalURLString);

        return shortenURLString;
    }

    public static String unshorten(String shortenURL) {

        return urlMap.get(shortenURL);
    }

    /**
     *   https://www.baeldung.com/java-random-string
     */
    public static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static void main(String[] args) {

        // TODO: create JUnit test
        String originalString1 = "https://blog.mysite.com/cool-article";
        String seoWord = "BEST-ARTICLE";
        String shortenedURL = shorten(originalString1, seoWord);
        System.out.println("originalString1="+originalString1);
        System.out.println("seoWord="+seoWord);
        System.out.println("shortenedURL="+shortenedURL);

        String originalString2 = "https://blog.mysite2.com/cool-article";
        String shortenedURL2 = shorten(originalString2, seoWord);
        System.out.println("originalString2="+originalString2);
        System.out.println("seoWord="+seoWord);
        System.out.println("shortenedURL="+shortenedURL2);

        String unshortenURL = unshorten(shortenedURL);
        System.out.println("shortenedURL="+shortenedURL);
        System.out.println("unshortenURL="+unshortenURL);

        if(originalString1 != unshortenURL) {
            throw new Error();
        }

        String randomString = generateRandomString();
        System.out.println("randomString="+randomString);

        String originalString3 = "https://blog.mysite.com/cool-article";
        String shortenedURL3 = shorten(originalString3);
        System.out.println("originalString3="+originalString3);
        System.out.println("shortenedURL3="+shortenedURL3);

        String shortenedURL4 = shorten(originalString3);
        System.out.println("originalString3="+originalString3);
        String shortenedURL32 = shorten(originalString3);
        System.out.println("shortenedURL3.2="+shortenedURL32);
    }
}
