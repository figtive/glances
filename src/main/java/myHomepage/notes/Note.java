package myHomepage.notes;

public class Note{
    private String nullnote = " ";
    private int id;
    private String note;

    public Note(){ }

    public Note (int id, String note){
        this.note = note;
        this.id = id;
    }
    public void setdescription(String description){
        this.note = description;
    }

    public String getdescription(){
        return note;
    }

    public String editnotes(String desc){
        setdescription(desc);
        //this.note = note + " " + desc;
        return note;
    }

    public String deletenotes(){
        this.note = nullnote;
        return note;
    }
}
