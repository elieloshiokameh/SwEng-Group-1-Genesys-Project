package ie.tcd.SwEng2024.GroupOne.API;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("https://www.myunidays.com/IE/en-IE/category/technology_all-technology-offers/").get();
            System.out.println(doc.body().toString());
        } catch (IOException e) {
            System.out.println("Could not fetch website!");
        }
    }
}