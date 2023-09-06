import org.springframework.stereotype.Service;

import com.sacral.bfsi.model.Eligibility;
import com.sacral.bfsi.repository.EligibilityRepository;

@Service
public class EligibilityService {
    private EligibilityRepository eligibilityRepository;

    public EligibilityService(EligibilityRepository eligibilityRepository) {
        this.eligibilityRepository = eligibilityRepository;
    }

    public Eligibility getEligibility(double annualIncome, int creditScore) {
        return eligibilityRepository.findEligibilityByIncomeAndScore(annualIncome, creditScore);
    }

    public void determineEligibility(double annualIncome, int creditScore) {
        Eligibility eligibility = getEligibility(annualIncome, creditScore);
        if (eligibility != null) {
            if (eligibility.getAnnualIncome() >= 30000 && eligibility.getCreditScore() >= 700) {
                System.out.println("Congratulations! You are eligible for a credit card with a high limit.");
            } else if (eligibility.getAnnualIncome() >= 20000 && eligibility.getCreditScore() >= 600) {
                System.out.println("You are eligible for a credit card with a moderate limit.");
            }
        } else {
            System.out.println("Sorry, you are not eligible for a credit card at this time.");
        }
    }
}