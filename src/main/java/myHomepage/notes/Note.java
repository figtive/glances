package myHomepage.notes;

import java.io.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "glanse")
public class Note{
    private String nullnote = " ";

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private int id;

    /*@Column (name = "notes")*/
    private String note;

    public Note(){ }

    public Note (int id, String note) {
        this.note = note;
        this.id = id;
    }

  /*  public void setdescription(String description) {
        this.note = description;
    }*/

    public String getDescription() {
        return note;
    }

    public String editnotes(String desc) {
        this.note = desc;
        //this.note = note + " " + desc;
        return note;
    }

    public String deletenotes() {
        this.note = nullnote;
        return note;
    }

    public int getid(){
        return id;
    }

    public void setid(int id){
        this.id = id;
    }

    public void printnote(){
        System.out.println(note);
    }
}

