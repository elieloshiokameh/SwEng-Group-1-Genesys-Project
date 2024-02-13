package ie.tcd.sweng2024.groupone.api.service;

import ie.tcd.sweng2024.groupone.api.model.Discount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountService {

    private List<Discount> exampleDiscounts;

    public DiscountService() {
        exampleDiscounts = new ArrayList<Discount>();
        Discount discount1 = new Discount(1, "Samsung", "Technology", "20% off products");
        Discount discount2 = new Discount(2, "48", "Technology", "Student Contract");

        exampleDiscounts.add(discount1);
        exampleDiscounts.add(discount2);
    }
    public Optional<Discount> getDiscount(Integer id) {
        Optional optional = Optional.empty();
        for (Discount discount : exampleDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        return optional;
    }
    public List<Discount> getDiscount(String type) {
        List<Discount> output = new ArrayList<>();
        for (Discount discount : exampleDiscounts) {
            if (discount.getType().equals(type)) {
                output.add(discount);
            }
        }
        return output;
    }
}
