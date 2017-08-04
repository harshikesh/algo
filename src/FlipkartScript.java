import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by harshikesh.kumar on 02/03/17.
 */
public class FlipkartScript {

    static String url = "https://flipkart.com";

    public static void main(String[] args) {
        findAllPhoto(url);
    }

    private static void findAllPhoto(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://flipkart.com/").get();
        } catch (IOException e) {

        }
        Elements img = doc.getElementsByTag("img");
        for (Element el : img) {
            String src = el.absUrl("src");
            System.out.println("Image Found! src attribute is : "+src);
        }

        if(doc.text().contains(".jpg")){
            System.out.println(url);
        }

        Elements questions = doc.select("a[href]");
        for(Element link: questions){
            if(link.attr("href").contains("flipkart.com"))
                findAllPhoto(link.attr("abs:href"));
        }

    }

}
