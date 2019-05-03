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
import org.springframework.stereotype.Controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class NoteSim{
   static Note noteapp = new Note();
   public static void main (String[]args) {
       while (true) {
           try {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               String instruction = br.readLine();

               if (instruction.equals("deletenote")) {
                   noteapp.deletenotes();
                   noteapp.getdescription();
                   //noteapp.printnote();
               } else if (instruction.equals("editnote")) {
                   String notelines = br.readLine();
                   noteapp.editnotes(notelines);
                   noteapp.getdescription();
                   //noteapp.printnote();
               } else if (instruction.equals("seenote")){
                   noteapp.printnote();
               }
               else if (instruction.equals("exit")){
                   break;
               }
           } catch (Exception e) {
               System.out.println(e);
           }
       }
   }
}