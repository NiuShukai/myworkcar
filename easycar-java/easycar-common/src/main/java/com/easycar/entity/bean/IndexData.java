package com.easycar.entity.bean;

public class IndexData {
    private String staticname;
    private Integer count;

    public IndexData(String staticname, Integer count) {
        this.staticname = staticname;
        this.count = count;
    }

    public IndexData() {
    }

    public String getStaticname() {
        return staticname;
    }

    public void setStaticname(String staticname) {
        this.staticname = staticname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
