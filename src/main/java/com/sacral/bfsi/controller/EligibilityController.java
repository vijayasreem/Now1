import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sacral.bfsi.model.Eligibility;
import com.sacral.bfsi.service.EligibilityService;

@RestController
public class EligibilityController {
    @Autowired
    private EligibilityService eligibilityService;

    @GetMapping("/determineEligibility")
    public String determineEligibility(@RequestParam double annualIncome, @RequestParam int creditScore) {
        Eligibility eligibility = eligibilityService.getEligibility(annualIncome, creditScore);
        if (eligibility != null) {
            if (eligibility.getAnnualIncome() >= 30000 && eligibility.getCreditScore() >= 700) {
                return "Congratulations! You are eligible for a credit card with a high limit.";
            } else if (eligibility.getAnnualIncome() >= 20000 && eligibility.getCreditScore() >= 600) {
                return "You are eligible for a credit card with a moderate limit.";
            }
        } 
        return "Sorry, you are not eligible for a credit card at this time.";
    }
}