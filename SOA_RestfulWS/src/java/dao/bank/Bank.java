/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bank;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author A00238100
 */
@XmlRootElement(name="bank")
@XmlType(propOrder={"branch_code", "account_number", "cust_name", "cust_address" , "cust_rating", "balance"})
public class Bank {
    private int branch_code;
    private int account_number;
    private String cust_name;
    private String cust_address;
    private Double cust_rating;
    private Double balance;
    
    public Bank(int branch_code, int account_number, String cust_name, String cust_address, Double cust_rating, Double balance){
        
    }

    public int getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(int branch_code) {
        this.branch_code = branch_code;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public Double getCust_rating() {
        return cust_rating;
    }

    public void setCust_rating(Double cust_rating) {
        this.cust_rating = cust_rating;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    
    
}
