package com.sacral.bfsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sacral.bfsi.model.Eligibility;

public interface EligibilityRepository extends JpaRepository<Eligibility, Long> {

    @Query(value = "SELECT * FROM Eligibility WHERE annual_income >= :annualIncome AND credit_score >= :creditScore", nativeQuery = true)
    Eligibility findEligibilityByIncomeAndScore(double annualIncome, int creditScore);

}