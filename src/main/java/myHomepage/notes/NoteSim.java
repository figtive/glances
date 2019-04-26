package myHomepage.notes;

import java.util.*;
import java.io.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NoteSim{
   String outputStream = " ";
   static Note noteapp = new Note();
   public static void main (String[]args){
      try {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //BufferedWriter bw = new BufferedWriter();
         String instruction = br.readLine();

        /* switch (instruction){
            case "newnote":
            case "deletenote":
            case "modifynote":

         }*/
        if(instruction.equals("deletenote")){
           noteapp.deletenotes();
        }
        else if (instruction.equals("editnote")){
           String notelines = br.readLine();
           noteapp.editnotes(notelines);
        }
      }
      catch(Exception e){
         System.out.println(e);
      }
   }
}