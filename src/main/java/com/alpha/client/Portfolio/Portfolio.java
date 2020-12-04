package com.alpha.client.Portfolio;


import javax.persistence.*;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long portfolioId;

    @Column(name="portfolioName")
    private String portfolioName;

}

