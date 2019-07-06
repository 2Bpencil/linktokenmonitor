package com.tyf.linktokenmonitor.code.entity;

/**
 * 账户信息
 */
public class AccountInfo {
    private String name;
    private String accountNum;
    private String transTime;
    private String ExpenditureIncomeState;
    private String amount;
    private String totalAmount;
    private String warn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getExpenditureIncomeState() {
        return ExpenditureIncomeState;
    }

    public void setExpenditureIncomeState(String expenditureIncomeState) {
        ExpenditureIncomeState = expenditureIncomeState;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }
}
