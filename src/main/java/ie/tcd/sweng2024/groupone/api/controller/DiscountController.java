package ie.tcd.sweng2024.groupone.api.controller;

import ie.tcd.sweng2024.groupone.api.model.Discount;
import ie.tcd.sweng2024.groupone.api.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DiscountController {

    private DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }


    //Returns a specific discount with correlation to the ID
    @GetMapping("/discount")
    public Discount getDiscount(@RequestParam Integer id) {
        Optional<Discount> discount = discountService.getDiscount(id);
        if (discount.isPresent()) {
            return (Discount) discount.get();
        }
        return null;
    }

    //returns a random discount based of the type
    @GetMapping("/randomDiscount")
    public Discount getRandomDiscount(@RequestParam String type) {
        Optional<Discount> discount = discountService.getRandomDiscount(type);
        if (discount.isPresent()) {
            return (Discount) discount.get();
        }
        return null;
    }

    //returns a list of discounts based of the type
    @GetMapping("/discountList")
    public List<Discount> getDiscounts(@RequestParam String type) {
        List<Discount> discounts = discountService.getDiscounts(type);
        if (!discounts.isEmpty()) {
            return discounts;
        }
        return null;
    }
}
