package ch.appaka.commerce.warehouse.business.domain;

import java.util.Map;

public class StockResponse {
    private boolean success;
    private String key;
    private Map<String, Map<String, Integer>> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Map<String, Integer>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, Integer>> data) {
        this.data = data;
    }
}
