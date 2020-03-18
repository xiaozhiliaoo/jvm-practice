package ch7.heap;

import java.util.List;
import java.util.Vector;

public class Student {
    private int id;
    private String name;
    private List<WebPage> history=new Vector<WebPage>();
    
    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void visit(WebPage w){
        history.add(w);
    }
}
