package scraping;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class FindUrl {

	/* String itemCat = null; 
	 String itemId = null; 
     String wantColor= null;
	*/
	 String fullUrl;
	
	//this finds and returns the full url given the item color, Id, and color
	//TODO: the id is currently set to keywords need to change based off the 
	// kind of bot the user decides to make
	public String FindUrl(String itemCat,String itemId,String wantColor) throws IOException {
	
		//sets the base connection for where we will start looking for elemnets 
		String base = "https://www.supremenewyork.com/shop/all/"+ itemCat; 
        Document document = Jsoup.connect(base).get();
		System.out.printf(base);
        
        String item=null; 
        String rest = null;
        
        int size = 10;
        int keep;
        
        
       //this isnt doing anything inside the for loop 
       //TODO: fix this broken for
        for(int i=1;i<size;i++) {
        	Elements gen = document.select("article"); 

        	if(gen.isEmpty() != true) {
        	item = gen.eachText().get(i);
        	size = gen.size();
        	}
        	
        	//lets change this to the h1 instead if it is in the article
        	 if(item.contains(itemId)) {
        		 keep = i;
        		 if(gen.get(keep).select("p").select("a").text().equals(wantColor)) {
            		 System.out.printf("Purchased%n");
            		 rest = gen.get(keep).select("a").attr("href");
                	}
        		 if(gen.get(keep).select("a").select("div").text() == "sold out") {
               		 System.out.print("Not Purchased: Sold Out");
               		 System.exit(0);
                	}
        	 }
        		
      	 	}
     
       return( fullUrl = "https://www.supremenewyork.com"+rest);
	}
	
}
