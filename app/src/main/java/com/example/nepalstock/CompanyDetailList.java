package com.example.nepalstock;

public class CompanyDetailList {

    private final String companyName;
    private final String symbol;

    public CompanyDetailList(String companyName, String symbol) {
        this.companyName = companyName;
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSymbol() {
        return symbol;
    }
}

