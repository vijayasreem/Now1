package com.sacral.bfsi.model;

import javax.persistence.*;

@Entity
@Table(name = "eligibility")
public class Eligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "annual_income")
    private double annualIncome;

    @Column(name = "credit_score")
    private int creditScore;

    public Eligibility() {
    }

    public Eligibility(double annualIncome, int creditScore) {
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}