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

    public Optional<Discount> getDiscount(Integer id) {
        Optional optional = Optional.empty();
        for (Discount discount : techDiscounts) {
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
        for (Discount discount : techDiscounts) {
            if (discount.getType().equals(type)) {
                discounts.add(discount);
            }
        }
        Random random = new Random();
        int index = random.nextInt(0, discounts.size());
        optional = Optional.of(discounts.get(index));
        return optional;
    }

    public List<Discount> getDiscounts(String type) {
        List<Discount> discounts = new ArrayList<>();
        for (Discount discount : techDiscounts) {
            if (discount.getType().equals(type)) {
                discounts.add(discount);
            }
        }
        return discounts;
    }

    private List<Discount> techDiscounts;
    private List<Discount> fashionDiscounts;
    private List<Discount> beautyDiscounts;
    private List<Discount> lifestyleDiscounts;
    private List<Discount> foodAndDrinkDiscounts;
    private List<Discount> healthAndFitnessDiscounts;
    private List<Discount> sportsAndMediaDiscounts;
    private List<Discount> educationDiscounts;

    public DiscountService() {
        techDiscounts = new ArrayList<Discount>();
        Document doc;
        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/technology_all-technology-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    techDiscounts.add(new Discount(techDiscounts.size(), companyName, "Technology", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        fashionDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/fashion_all-fashion").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    fashionDiscounts.add(new Discount(fashionDiscounts.size(), companyName, "Fashion", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        beautyDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/beauty_all-beauty-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    beautyDiscounts.add(new Discount(beautyDiscounts.size(), companyName, "Beauty", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        lifestyleDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/lifestyle_all-lifestyle-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    lifestyleDiscounts.add(new Discount(lifestyleDiscounts.size(), companyName, "Lifestyle", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        foodAndDrinkDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/food-and-drink_all-food-and-drink-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    foodAndDrinkDiscounts.add(new Discount(foodAndDrinkDiscounts.size(), companyName, "Food & Drink", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        healthAndFitnessDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/health-and-fitness_all-health-and-fitness-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    healthAndFitnessDiscounts.add(new Discount(healthAndFitnessDiscounts.size(), companyName, "Health & Fitness", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sportsAndMediaDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/sports-and-media_sports-and-media").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    sportsAndMediaDiscounts.add(new Discount(sportsAndMediaDiscounts.size(), companyName, "Sports and Fitness", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        educationDiscounts = new ArrayList<Discount>();

        try {
            doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/education_all-education-offers").get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Title: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    educationDiscounts.add(new Discount(educationDiscounts.size(), companyName, "Education", link.text()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
