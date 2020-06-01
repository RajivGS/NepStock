package com.example;

public class TradeDetailList {
    private String companyName;
    private String symbol;
    private String securityName;
    private String status;
    private String companyEmail;
    private String website;
    private String sectorName;
    private String regulartoryBody;
    private String instrumentType;


    public TradeDetailList(String companyName,
                           String symbol,
                           String securityName,
                           String status,
                           String companyEmail,
                           String website,
                           String sectorName,
                           String regulatoryBody,
                           String instrumentType) {
        this.companyName = companyName;
        this.symbol = symbol;
        this.securityName = securityName;
        this.status = status;
        this.companyEmail = companyEmail;
        this.website = website;
        this.sectorName = sectorName;
        this.regulartoryBody = regulatoryBody;
        this.instrumentType = instrumentType;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getSecurityName() {
        return securityName;
    }
    public String getStatus() {
        return status;
    }
    public String getCompanyEmail() {
        return companyEmail;
    }
    public String getWebsite() {
        return website;
    }
    public String getSectorName() {
        return sectorName;
    }
    public String getRegulatoryBody() {
        return regulartoryBody;
    }
    public String getInstrumentType() {
        return instrumentType;
    }
}
