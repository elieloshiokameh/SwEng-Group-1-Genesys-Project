package ie.tcd.sweng2024.groupone.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
        //the below code has nothing to do with the API right now, it just tests jsoup scraping
        try {
            Document doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/technology_all-technology-offers/").get();
            System.out.println(doc.body());
        } catch (IOException e) {
            System.out.println("Could not fetch website!");
        }

    }

}
