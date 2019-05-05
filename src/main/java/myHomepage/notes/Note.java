package myHomepage.notes;

import java.io.*;

import com.sun.javafx.beans.IDProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

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

    @RequestMapping(value = "/Note")
    public ResponseEntity<String> NoteOut(){
        this.printnote();
        return new ResponseEntity<>(this.getDescription(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Note/Delete")
    public ResponseEntity<String> NoteDel(){
        this.printnote();
        return new ResponseEntity<>(this.getDescription(), HttpStatus.OK);
    }
}
