package myHomepage.notes;

public class Note{
    private String nullnote = " ";
    private String note;

    public Note(){}
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
