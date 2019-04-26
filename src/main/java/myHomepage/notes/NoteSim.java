package myHomepage.notes;

import java.util.*;
import java.io.*;

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