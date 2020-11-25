package com.alpha.client.Client.model;

import com.alpha.client.Portfolio.Portfolio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="clientId")
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="emailaddress")
    private String emailAddress;

    @Column(name="bankbalance")
    private double bankBalance;



    @Embedded
    private List<Portfolio> clientPortfolio;

    public Client() {
    }

    public Client(String firstName, String lastName, double bankBalance) {
    }

    public Client(String firstName, String lastName,String password,String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailAddress = emailAddress;

        this.bankBalance = new Random().nextDouble() * 5000; //generate bank balance from 1-5000

        this.clientPortfolio = new ArrayList<Portfolio>();
    }

    @Override
    public String toString() {
        return String.format("Client[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName, password, emailAddress,bankBalance);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void getClientPortfolio() {
    }

    public void setClientPortfolio(List<Portfolio> clientPortfolio) {
        this.clientPortfolio = clientPortfolio;
    }


    public void addPortfolio(Portfolio portfolio){
        this.clientPortfolio.add(portfolio);
    }

    public void removePortfolio(Portfolio portfolio){
        this.clientPortfolio.remove(portfolio);
    }



}