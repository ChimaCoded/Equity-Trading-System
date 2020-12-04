package com.alpha.client.Order.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

private static final long serialVersionUID = -2343243243242432341L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="orderId")
private String orderId;

@Column(name = "clientId")
private String clientId;

@Column(name="portfolioId")
private String portfolioId;

@Column(name="ticker")
private String ticker;

@Column(name="side")
private String side;

@Column(name="quantity")
private int quantity;

@Column(name="price")
private double price;

@Column(name="timeStamp")
private LocalDateTime timeStamp;


    public Order() {
    }

    public Order(String clientId, String portfolioId, String ticker, String side, int quantity, LocalDateTime timeStamp) {
        this.orderId = "h3h4";
        this.clientId = clientId;
        this.portfolioId = portfolioId;
        this.ticker = ticker;
        this.side = side;
        this.quantity = quantity;
        this.timeStamp = LocalDateTime.now();
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
