/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bank;

import dao.bank.Bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A00238100
 */
public enum BankDao {
    
    instance;
    
    private Connection con = null;
    
    private BankDao() throws ClassNotFoundException{
        try{
        System.out.println("loading db driver");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("DB driver loaded");

            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/SOA_DB",
                "billy",
                "1234"
            );
        }
        catch(ClassNotFoundException ex){
            System.err.println("\nClassNotFoundException");
            ex.printStackTrace();

        }catch(SQLException ex){
            System.err.println("\nSQLException");
            ex.printStackTrace();
        }
        
    }
    
        public List<Bank> getStudents(){
        List<Bank> customers = new ArrayList<Bank>();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from bank");
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int branch_code = rs.getInt("branch_code");
                int account_number = rs.getInt("account_number");
                String cust_name = rs.getString("cust_name");
                String cust_address = rs.getString("cust_address");
                Double cust_rating = rs.getDouble("cust_rating");
                Double balance = rs.getDouble("balance");
            }
        }catch(SQLException ex){
            System.err.println("\nSQLException");
            ex.printStackTrace();
        }
        return customers;
    }
    
    public int getNextAccountNumber(String branchCode){
        return -1 if unsuccessful;
    }
		
    public void deleteAllAccounts(){
        
    }

    public int updateBankAccount(BankAccount bankAccount){
        return -1 if unsuccessful, 1 if successful

    }
            
    public int addBankAccount(BankAccount bankAccount){
        return -1 if unsuccessful, 1 if successful

    }
            
    public BankAccount getAccountDetails(String branchCode, String accountNo){
        
    }

    public ArrayList<BankAccount> getAllAccounts(){
        
    }

    public void deleteBankAccount(String branchCode, String accountNo){
        
    }



    
}
