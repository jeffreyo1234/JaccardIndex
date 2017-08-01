package io.ciscoapp.CiscoApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.util.Elements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;

import io.ciscoapp.CiscoApp.model.JaccardModel;

@SpringBootApplication
public class JaccardIndex {

	/**
     * @param args the command line arguments
     * @return
     */
   	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SpringApplication.run(JaccardIndex.class,args);
	}
	
}
