package com.example.basicLayout;

import lombok.Data;

public class Manager extends User{
    private String account;
    private String password;


    public Manager(String account, String password, String account1, String password1) {
        super(account, password);
        this.account = account1;
        this.password = password1;
    }

    public Manager(){
        super(3);
    }

    public Manager(String account, String password) {
        super(3);
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
