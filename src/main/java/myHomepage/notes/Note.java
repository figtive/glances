package myHomepage.notes;

public class Note{
    private static Note uniqueInstance = new Note();
    private boolean save;
    private String description;

    private Note(){}

    public static Note getInstance(){
        return uniqueInstance;
    }

    public void setdescription(String description){
        this.description = description;
    }

    public String getdescription(){
        return description;
    }

    public boolean savenotes(){
        return save = true;
    }

    public String editnotes(String description){
        return description;
    }

    public void deletenotes(){
        this.description = null;
    }
}
