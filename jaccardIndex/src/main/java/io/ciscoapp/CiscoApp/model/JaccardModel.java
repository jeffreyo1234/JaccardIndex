package io.ciscoapp.CiscoApp.model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

public class JaccardModel {
	private List<String> listA = new ArrayList<>();
    private List<String> listB = new ArrayList<>();
    private List<String> aUbList = new ArrayList<>();
    private List<String> aNbList = new ArrayList<>();
 
    public List<String> getaUbList() {
        return aUbList;
    }

    public void setaUbList(List<String> aUbList) {
        this.aUbList = aUbList;
    }
    
    public List<String> getaNbList() {
        return aNbList;
    }

    public void setaNbList(List<String> aNbList) {
        this.aNbList = aNbList;
    }

    public List<String> getListA() {
        return listA;
    }

    public void setListA(List<String> listA) {
        this.listA = listA;
    }

    public List<String> getListB() {
        return listB;
    }

    public void setListB(List<String> listB) {
        this.listB = listB;
    }	
    
}
