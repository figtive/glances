package myHomepage.notes;

import java.io.*;

public class Note{
    //private static Note uniqueInstance = new Note();
    private boolean save;
    private String note;

    public Note(){}
    //private Note(){}//
    /*private static Note getInstance(){
        return uniqueInstance;
    }*/
    
    public void setdescription(String description){
        this.note = description;
    }

    public String getdescription(){
        return note;
    }

    /*public boolean savenotes(){
        return save = true;
    }*/

    public String editnotes(String desc){
        this.note = note + " " + desc;
        return note;
    }

    public String deletenotes(){
        this.note = " ";
        return note;
    }
}
