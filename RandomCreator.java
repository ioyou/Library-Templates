   import java.io.*;

   import java.util.*;

    public class RandomCreator
   {      
    
      final static int FIELD_SIZE = 20;
      
       public static void main (String args[]) throws IOException{
         RandomAccessFile raf = new RandomAccessFile("random.bin", "rw");
      
      
         int studentNumber = 13;
      	
         raf.writeInt(studentNumber);
      	
         String firstName = "Jon";
         int nameLen = firstName.length();
         int padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }       
         else
         {        
            padLen = FIELD_SIZE - nameLen;
         
         } 
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (firstName.charAt (i)); 
         
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      
      //Repeat for last name
      
         String lastName = "VK";
         nameLen = lastName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }
         
         else
         {
         
            padLen = FIELD_SIZE - nameLen;
         }
          
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (lastName.charAt (i)); 
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      ////////////////////////////////////////////////////////////////////////
           
        studentNumber = 14;
      	
         raf.writeInt(studentNumber);
      	
         firstName = "Heidi";
         nameLen = firstName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }       
         else
         {        
            padLen = FIELD_SIZE - nameLen;
         
         } 
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (firstName.charAt (i)); 
         
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      
      //Repeat for last name
      
         lastName = "Fouche";
         nameLen = lastName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }
         
         else
         {
         
            padLen = FIELD_SIZE - nameLen;
         }
          
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (lastName.charAt (i)); 
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      //////////////////////////////////////////////////////////////
         studentNumber = 15;
      	
         raf.writeInt(studentNumber);
      	
        firstName = "Marc";
         nameLen = firstName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }       
         else
         {        
            padLen = FIELD_SIZE - nameLen;
         
         } 
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (firstName.charAt (i)); 
         
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      
      //Repeat for last name
      
         lastName = "Jacobs";
         nameLen = lastName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }
         
         else
         {
         
            padLen = FIELD_SIZE - nameLen;
         }
          
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (lastName.charAt (i)); 
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      ///////////////////////////////////////////////
      studentNumber = 16;
      	
         raf.writeInt(studentNumber);
      	firstName = "Chris";
        nameLen = firstName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }       
         else
         {        
            padLen = FIELD_SIZE - nameLen;
         
         } 
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (firstName.charAt (i)); 
         
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
      
      
      //Repeat for last name
      
         lastName = "Niesel";
         nameLen = lastName.length();
         padLen = 0;
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         {
         
            nameLen = FIELD_SIZE;
         }
         
         else
         {
         
            padLen = FIELD_SIZE - nameLen;
         }
          
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         {
         
            raf.writeChar (lastName.charAt (i)); 
         
         }      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            {
               raf.writeChar (' ');
            
            }
         }
           
      }//end main      
        
   
   }//end class