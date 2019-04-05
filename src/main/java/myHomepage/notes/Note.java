package myHomepage.notes;

public class Note{
    private int id;
    private boolean save;
    private String description;

    public Note(){}

    public void setdescription(String description){
        this.description = description;
    }

    public String getdescription(){
        return description;
    }

    public boolean savenotes(){
        return save;
    }

    public void searchnotes(int id){
    }

    public String editnotes(){
        return description;
    }

    public void deletenotes(){
    }

}
