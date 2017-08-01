package io.ciscoapp.CiscoApp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import io.ciscoapp.CiscoApp.model.JaccardModel;

@Service
public class JaccardServices {
	 JaccardModel jaccardModel=new JaccardModel();
	
	 public List<String> getAuBIntersection( List<String> aUbList, List<String> listA,List<String> listB) {
	        //add list A to getAuNIntersection list
	        for(int i=0;i<listA.size();i++){
	        	
	            aUbList.add(listA.get(i));
	        }
	        boolean isThere = true;
	        for (int x = 0; x < aUbList.size(); x++) {
	            for (int y = 0; y < listB.size(); y++) {
	                isThere =  aUbList.get(y).equals(listB.get(x));
	                if (isThere) {
	                    break;
	                }
	                if (y == aUbList.size() - 1 && isThere == false) {
	                	aUbList.add(listB.get(x));
	                }
	            }
	        }
	        return aUbList;
	    }

	    public List<String> getAnBIntersection(List<String> listA,List<String> listB, List<String> aNbList) {
	        for (int x = 0; x < aNbList.size(); x++) {
	            for (int y = 0; y < listB.size(); y++) {
	                if (aNbList.get(x).equals(listB.get(y))) {
	                    aNbList.add(listA.get(x));
	                }
	            }
	        }
	        return aNbList;
	    }

	    
	    public int getJaccardIndex(URL urlA,URL urlB) {
	    	
	    	List<String> aUbList = new ArrayList<>();
	    	List<String> aNbList = new ArrayList<>();
	    	List<String> listA= new ArrayList<>();
	    	List<String> listB= new ArrayList<>();
	        setListA(listA, urlA);
	        setListB(listB, urlB);
	        jaccardModel.setaUbList(getAuBIntersection(aUbList, listA,listB));
	        jaccardModel.setaNbList(getAnBIntersection(listA,listB, aNbList));
	        int jIndex = (aUbList.size() - aNbList.size()) / aUbList.size();
	        return jIndex;
	    }
	    
	    public void setListA( List<String> listA, URL urlA) {
	         listA= new ArrayList<>();
	        InputStream is = null;
	        BufferedReader br;
	        String line;

	        try {
	            urlA = new URL("http://www.thenewboston.org/list.php?cat=49");
	            is = urlA.openStream();  // throws an IOException
	            br = new BufferedReader(new InputStreamReader(is));
	                
	            while ((line = br.readLine()) != null) {                
	                Document doc = Jsoup.parse(line); 
	                Jsoup.clean(doc.text(), Whitelist.none());
	                doc.select("script, style, .hidden").remove();                  
	                Elements all = doc.select("*");
	                for (Element el : all) { 
	                  for (Attribute attr : el.attributes()) { 
	                    String attrKey = attr.getKey();
	                    if (attrKey.equals("style") || attrKey.startsWith("on")) { 
	                      el.removeAttr(attrKey);
	                    } 
	                  }
	                }                    
	                if(doc.text().equals("")){                    
	                }else{   
	                listA.add(doc.text());                  
	                }                              
	            }
	   
	        } catch (MalformedURLException mue) {
	        } catch (IOException ioe) {
	        } finally {
	            try {
	                if (is != null) {
	                    is.close();
	                }
	            } catch (IOException ioe) {
	                // nothing to see here
	            }
	        }
	     }
	    
	        public void setListB( List<String> listB,URL urlB) {
	        listB= new ArrayList<>();
	        InputStream is = null;
	        BufferedReader br;
	        String line;

	        try {
	            urlB = new URL("http://www.google.com");
	            is = urlB.openStream();  // throws an IOException
	            br = new BufferedReader(new InputStreamReader(is));
	                
	            while ((line = br.readLine()) != null) {                
	                Document doc = Jsoup.parse(line); 
	                Jsoup.clean(doc.text(), Whitelist.none());
	                doc.select("script, style, .hidden").remove();                  
	                Elements all = doc.select("*");
	                for (Element el : all) { 
	                  for (Attribute attr : el.attributes()) { 
	                    String attrKey = attr.getKey();
	                    if (attrKey.equals("style") || attrKey.startsWith("on")) { 
	                      el.removeAttr(attrKey);
	                    } 
	                  }
	                }                    
	                if(doc.text().equals("")){                    
	                }else{   
	                listB.add(doc.text());                  
	                }                              
	            }
	   
	        } catch (MalformedURLException mue) {
	        } catch (IOException ioe) {
	        } finally {
	            try {
	                if (is != null) {
	                    is.close();
	                }
	            } catch (IOException ioe) {
	                // nothing to see here
	            }
	        }
	     }
	    
	
	
}
