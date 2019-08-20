package sample;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class zeroChanDownloader {

    public static void main(String[]args){

    }

    public static void downloadImages (String url, String filePath){
        Thread thread=new Thread();
        try {
            Document webPage= Jsoup.connect(url).get();
            Elements links=webPage.select("a[href*=https://static]");
            for (Element link:links) {
                String linkAttribute=link.attr("href");
                String fileName=linkAttribute.substring(linkAttribute.length()-11,linkAttribute.length()-4)+".jpg";
                String path=(filePath+"\\"+fileName);
                InputStream in=new URL(linkAttribute).openStream();
                Files.copy(in, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Downloading "+fileName);
            }

        } catch (Exception e){

        }
        thread.start();

    }
}
