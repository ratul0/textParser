/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectData;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author yousufkhan
 */
public class SinglePage {
    
    public static String getArticle(String url){
        Document doc;
        String linkText = "";
        try {
            doc = Jsoup.connect(url).timeout(0).get();
            
            Elements contents = doc.getElementsByAttributeValue("itemprop", "articleBody");
            
            for (Element data : contents) {
              
              linkText = data.text();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SinglePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linkText;
        
    }
    
}
