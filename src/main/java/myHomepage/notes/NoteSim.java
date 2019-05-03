package myHomepage.notes;

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