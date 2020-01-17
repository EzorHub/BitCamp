package com.chat.vo;

import java.util.ArrayList;

public class Jumun {
    private String custid;
    private int total;
    ArrayList<JumunDetailVo> jumunList;
    public String getCustid() {
        return custid;
    }
    public void setCustid(String custid) {
        this.custid = custid;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public ArrayList<JumunDetailVo> getJumunList() {
        return jumunList;
    }
    public void setJumunList(ArrayList<JumunDetailVo> jumunList) {
        this.jumunList = jumunList;
    }
    public Jumun(String custid, int total, ArrayList<JumunDetailVo> jumunList) {
        super();
        this.custid = custid;
        this.total = total;
        this.jumunList = jumunList;
    }
    public Jumun() {
        super();
        // TODO Auto-generated constructor stub
    }
}