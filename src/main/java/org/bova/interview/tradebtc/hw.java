package org.bova.interview.tradebtc;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
https://www.binance.com/en/trade/BTC_USDT

https://binance-docs.github.io/apidocs/spot/en/#diff-depth-stream

Diff. Depth Stream




{
  "e": "depthUpdate", // Event type
  "E": 123456789,     // Event time
  "s": "BNBBTC",      // Symbol
  "U": 157,           // First update ID in event
  "u": 160,           // Final update ID in event
  "b": [              // Bids to be updated
    [
      "0.0024",       // Price level to be updated
      "10"            // Quantity
    ]
  ],
  "a": [              // Asks to be updated
    [
      "0.0026",       // Price level to be updated
      "100"           // Quantity
    ]
  ]
}

 */
public class hw {

    static Map<BigDecimal,BigDecimal> offers = new TreeMap<>();

    static Map<BigDecimal,BigDecimal> bids = new TreeMap<>();

    public static void main(String[] args) {

        String json =
                "{\n" +
                        "  \"e\": \"depthUpdate\",\n" +
                        "  \"E\": 123456789,\n" +
                        "  \"s\": \"BNBBTC\",   \n" +
                        "  \"U\": 157,      \n" +
                        "  \"u\": 160,      \n" +
                        "  \"b\": [         \n" +
                        "    [\n" +
                        "      \"0.0024\",   \n" +
                        "      \"10\"       \n" +
                        "    ],\n" +
                        "    [\n" +
                        "      \"0.0084\",   \n" +
                        "      \"11\"       \n" +
                        "    ],\n" +
                        "    [\n" +
                        "      \"0.0044\",   \n" +
                        "      \"3\"       \n" +
                        "    ],\n" +
                        "    [\n" +
                        "      \"0.0074\",   \n" +
                        "      \"0\"       \n" +
                        "    ]\n" +
                        "  ],\n" +
                        "  \"a\": [         \n" +
                        "    [\n" +
                        "      \"0.0026\",   \n" +
                        "      \"100\"      \n" +
                        "    ]\n" +
                        "  ]\n" +
                        "}";

        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        DepthUpdate depthUpdate = gson.fromJson(json, DepthUpdate.class);

        // fill bids
        // multiple party computation
        // cqrs

        for(List<String> bid : depthUpdate.b) {
            BigDecimal total = new BigDecimal(bid.get(1));
            BigDecimal price = new BigDecimal(bid.get(0));

            if(total.compareTo(BigDecimal.ZERO) == 0) {
                bids.remove(price);
            } else {
                bids.put(price, total);
            }
        }

        System.out.println("Hello World!");
    }



}
