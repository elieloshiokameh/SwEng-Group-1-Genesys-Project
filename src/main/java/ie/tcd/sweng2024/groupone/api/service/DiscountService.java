package ie.tcd.sweng2024.groupone.api.service;

import ie.tcd.sweng2024.groupone.api.model.Discount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class DiscountService {

    private List<Discount> exampleDiscounts;

    public DiscountService() {

        Document doc;
        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/technology_all-technology-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")){
                    System.out.println("\nLink : " + link.attr("href"));
                    System.out.println("Text : " + link.text());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




        /*
        exampleDiscounts = new ArrayList<Discount>();
        Discount discount1 = new Discount(1, "Samsung", "Technology", "20% off products");
        Discount discount2 = new Discount(2, "48", "Technology", "Student Contract");

        exampleDiscounts.add(discount1);
        exampleDiscounts.add(discount2);
         */

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
    public Optional<Discount> getRandomDiscount(String type) {
        Optional optional = Optional.empty();
        List<Discount> discounts = new ArrayList<>();
        for (Discount discount : exampleDiscounts) {
            if (discount.getType().equals(type)) {
                discounts.add(discount);
            }
        }
        Random random = new Random();
        int index = random.nextInt(0, discounts.size());
        optional = Optional.of(discounts.get(index));
        return optional;
    }
}
