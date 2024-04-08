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
    private int totalUnidaysDiscounts;

    private List<Discount> techDiscounts;
    private List<Discount> fashionDiscounts;
    private List<Discount> beautyDiscounts;
    private List<Discount> lifestyleDiscounts;
    private List<Discount> foodAndDrinkDiscounts;
    private List<Discount> healthAndFitnessDiscounts;
    private List<Discount> sportsAndMediaDiscounts;
    private List<Discount> educationDiscounts;
    List<Discount> societyDiscounts;
    private List<Discount> lifestyleSocDiscounts;
    private List<Discount> foodAndDrinkSocDiscounts;
    private List<Discount> gamesSocDiscounts;

    public Optional<Discount> getDiscount(Integer id) {
        Optional optional = Optional.empty();
        for (Discount discount : techDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : beautyDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : fashionDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : lifestyleDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : educationDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : sportsAndMediaDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : healthAndFitnessDiscounts) {
            if (id == discount.getId()) {
                optional = Optional.of(discount);
                return optional;
            }
        }
        for (Discount discount : foodAndDrinkDiscounts) {
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
        switch (type) {
            case "Technology":
                discounts = techDiscounts;
                break;
            case "Beauty":
                discounts = beautyDiscounts;
                break;
            case "Fashion":
                discounts = fashionDiscounts;
                break;
            case "Lifestyle":
                discounts = lifestyleDiscounts;
                break;
            case "Education":
                discounts = educationDiscounts;
                break;
            case "Sports-Media":
                discounts = sportsAndMediaDiscounts;
                break;
            case "Health-Fitness":
                discounts = healthAndFitnessDiscounts;
                break;
            case "Food-Drink":
                discounts = foodAndDrinkDiscounts;
                break;
            default:
                break;
        }
        Random random = new Random();
        int index = random.nextInt(0, discounts.size());
        optional = Optional.of(discounts.get(index));
        return optional;
    }

    public Optional<Discount> getRandomSocDiscount(String type) {
        Optional optional = Optional.empty();
        List<Discount> discounts = new ArrayList<>();
        switch (type) {
            case "Lifestyle":
                discounts = lifestyleSocDiscounts;
                break;
            case "Games":
                discounts = gamesSocDiscounts;
                break;
            case "Food-Drink":
                discounts = foodAndDrinkSocDiscounts;
                break;
            case "All":
                discounts = societyDiscounts;
                break;
            default:
                break;
        }
        Random random = new Random();
        int index = random.nextInt(0, discounts.size());
        optional = Optional.of(discounts.get(index));
        return optional;
    }

    public List<Discount> getDiscounts(String type) {
        List<Discount> discounts = new ArrayList<>();
        switch (type) {
            case "Technology":
                discounts = techDiscounts;
                break;
            case "Beauty":
                discounts = beautyDiscounts;
                break;
            case "Fashion":
                discounts = fashionDiscounts;
                break;
            case "Lifestyle":
                discounts = lifestyleDiscounts;
                break;
            case "Education":
                discounts = educationDiscounts;
                break;
            case "Sports-Media":
                discounts = sportsAndMediaDiscounts;
                break;
            case "Health-Fitness":
                discounts = healthAndFitnessDiscounts;
                break;
            case "Food-Drink":
                discounts = foodAndDrinkDiscounts;
                break;
            default:
                break;
        }
        return discounts;
    }

    private String baseUrl = "https://www.myunidays.com";
    public DiscountService() {
        totalUnidaysDiscounts = 0;
        techDiscounts = new ArrayList<Discount>();
        Document doc;
        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/technology_all-technology-offers";
            doc = Jsoup.connect(url).get();


            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println(outputLink);
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    techDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Technology", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        fashionDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/fashion_all-fashion";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    fashionDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Fashion", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        beautyDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/beauty_all-beauty-offers";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    beautyDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Beauty", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        lifestyleDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/lifestyle_all-lifestyle-offers";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    lifestyleDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Lifestyle", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        foodAndDrinkDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/food-and-drink_all-food-and-drink-offers";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    foodAndDrinkDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Food & Drink", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        healthAndFitnessDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/health-and-fitness_all-health-and-fitness-offers";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    healthAndFitnessDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Health & Fitness", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sportsAndMediaDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/sports-and-media_sports-and-media";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    sportsAndMediaDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Sports & Media", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        educationDiscounts = new ArrayList<Discount>();

        try {
            String url = "https://www.myunidays.com/IE/en-IE/category/education_all-education-offers";
            doc = Jsoup.connect(url).get();

            // Get title of the page
            String title = doc.title();
            System.out.println("Now Getting: " + title);

            // Gets all links on the site
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                if (link.text().contains("Off") || link.text().contains("Discount") || link.text().contains("Free") || link.text().contains("FREE") || link.text().contains("Save") || link.text().contains("DISCOUNT") || link.text().contains("Trade") || link.text().contains("Get")) {
                    //System.out.println("\nLink : " + link.attr("href"));
                    String outputLink;
                    if (!link.attr("href").contains("www.")){
                        outputLink = baseUrl+link.attr("href");
                    }
                    else {
                        outputLink = link.attr("href");
                    }
                    //System.out.println("Text : " + link.text());
                    String companyName = link.parent().attr("data-customer-name");
                    //String[] temp = link.attr("href").split("/");
                    educationDiscounts.add(new Discount(totalUnidaysDiscounts, companyName, "Education", link.text(), outputLink));
                    totalUnidaysDiscounts++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Found " + (totalUnidaysDiscounts - 1) + " discounts in total from Unidays. Will now fetch society discounts from DB.");
        DatabaseExtractor extractor = new DatabaseExtractor();
        societyDiscounts = extractor.getSocietyDiscounts();

        foodAndDrinkSocDiscounts = new ArrayList<>();
        lifestyleSocDiscounts = new ArrayList<>();
        gamesSocDiscounts = new ArrayList<>();

        for (int i = 0; i < societyDiscounts.size(); i++) {
            if (societyDiscounts.get(i).getType().equals("Food&Drink"))
                foodAndDrinkSocDiscounts.add(societyDiscounts.get(i));
            else if (societyDiscounts.get(i).getType().equals("Lifestyle"))
                lifestyleSocDiscounts.add(societyDiscounts.get(i));
            else if (societyDiscounts.get(i).getType().equals("Games"))
                gamesSocDiscounts.add(societyDiscounts.get(i));
            else {
                foodAndDrinkSocDiscounts.add(societyDiscounts.get(i));
                lifestyleSocDiscounts.add(societyDiscounts.get(i));
                gamesSocDiscounts.add(societyDiscounts.get(i));
            }
        }
        int totalSocDiscounts = foodAndDrinkSocDiscounts.size() + lifestyleSocDiscounts.size() + gamesSocDiscounts.size();
        System.out.println("Found " + totalSocDiscounts + " society-exclusive discounts!");
    }
}
