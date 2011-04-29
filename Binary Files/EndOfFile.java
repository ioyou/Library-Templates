   import java.io.*;

    class EndOfFile{
   
      static DataInputStream dis; 
      static FileInputStream fis; 
       
       public static void main(String args[]){
         try	 
         { 
            fis = new FileInputStream ("binary.bin"); // Create a new file input stream that is connected to fileName 
            dis = new DataInputStream (fis); // Connect DataInputStream to the File object 
         } 
             catch (FileNotFoundException e) 
            { 
               System.out.println ("Error - this binary input file does not exist"); 
            } 
         try 
         { 
            if (dis.available()>0) // If there are any bytes still to be read 
               System.out.println(dis.available()); //prints the number of bytes available
         } 
             catch (IOException e) 
            { 
               System.out.println ("error=asdf" + e.toString ()); 
            } // close catch
      
      }//end main
   
   }//end class 
