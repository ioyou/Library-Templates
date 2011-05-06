   import java.io.*;

   import java.util.*;

    public class RandomReader
   {      
    
      final static int FIELD_SIZE = 20;
      
      private static final long RECLEN = 84;

      private static double numRecords;
      	
   
      
       public static void main (String args[]) throws IOException{
         RandomAccessFile raf = new RandomAccessFile("random.bin", "rw");
         numRecords = raf.length()/RECLEN;
         System.out.println("LENGTH: " + raf.length());
         System.out.println("NUM REC: " + numRecords);
      
         for(int i = 0; i < numRecords; i++)
         { 
            try{      
                             
               raf.seek(i * RECLEN); 
               int studentNum = raf.readInt();
            
            
               StringBuffer sb = new StringBuffer("");  
               for(int ctr = 0; ctr < FIELD_SIZE; ctr++)
                  sb.append(raf.readChar());
            
               String firstName =(sb.toString().trim());
            
               sb = new StringBuffer("");
               for(int ctr2 = 0; ctr2 < FIELD_SIZE; ctr2++)
                  sb.append(raf.readChar());	
            	
               String lastName = (sb.toString().trim()); 
            	
            	System.out.println(studentNum);
            	System.out.println(firstName);
            	System.out.println(lastName);
            	
            	
              
            
            }
                catch(IOException e)
               {
                  System.out.println ("error=" + e.toString ());
               
               }
         }//end for 
         raf.close();
         
      
           
      }//end main      
   }//end class