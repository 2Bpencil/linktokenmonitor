package com.tyf.linktokenmonitor.code.entity;

/**
 * 账户信息
 */
public class AccountInfo {
    private String name;
    private String accountNum;
    private String transTime;
    private String ExpenditureIncomeState;
    private Integer amount;
    private Integer totalAmount;
    private Boolean warn;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean isWarn() {
        return warn;
    }

    public void setWarn(Boolean warn) {
        this.warn = warn;
    }
}
