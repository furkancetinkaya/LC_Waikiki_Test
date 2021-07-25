package com.testinium.lcwaikikitest.operations;

public class LocatorElement {
    public enum SelectBy{
        ID,
        NAME,
        CSS_SELECTOR,
        XPATH,
        CLASS_NAME,
        TAG_NAME,
        LINK_TEXT,
        PARTIAL_LINK_TEXT
    }

    private String key;
    private SelectBy by;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SelectBy getBy() {
        return by;
    }

    public void setBy(SelectBy by) {
        this.by = by;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
