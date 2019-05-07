package myHomepage.notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public class NoteSim {
    Note internalNote;
    @RequestMapping(value = "/Note")
    public ResponseEntity<String> NoteOut(){
        internalNote.printnote();
        return new ResponseEntity<>(internalNote.getDescription(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Note/Delete")
    public ResponseEntity<String> NoteDel(){
        internalNote.printnote();
        return new ResponseEntity<>(internalNote.getDescription(), HttpStatus.OK);
    }
    @RequestMapping(value = "/Note/Edit")
    public void NoteEdit(String updatedDescription){
        internalNote.editnotes(updatedDescription);
        System.out.println("Updated!");
    }
}
