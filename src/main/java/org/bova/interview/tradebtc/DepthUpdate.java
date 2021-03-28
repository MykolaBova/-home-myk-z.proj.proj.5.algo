package org.bova.interview.tradebtc;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DepthUpdate {
    public String e;
    @JsonProperty("E")
    public int E;
    public String s;
    @JsonProperty("U")
    public int U;
    public int u;
    public List<List<String>> b;
    public List<List<String>> a;
}
