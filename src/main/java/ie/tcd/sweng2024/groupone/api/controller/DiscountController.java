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
    /*
    @GetMapping("/discount")
    public Discount getDiscount(@RequestParam Integer id) {
        Optional<Discount> discount = discountService.getDiscount(id);
        if (discount.isPresent()) {
            return (Discount) discount.get();
        }
        return null;
    }
    */
    @GetMapping("/discount")
    public List<Discount> getDiscount(@RequestParam String type) {
        List<Discount> discounts = discountService.getDiscount(type);
        if (!discounts.isEmpty()) {
            return discounts;
        }
        return null;
    }
}
