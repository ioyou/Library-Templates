   import java.io.*; 

    class BinaryFileCreator 
   { 
       public static void main(String args[]) 
      { 
         FileOutputStream fos; 
         DataOutputStream outFile; 
         final long FIELD_SIZE = 20;
      
         try 
         { 
            //Constructors to initialize
            fos = new FileOutputStream("records.bin"); 
            outFile = new DataOutputStream(fos); 
            
          	//Use appropriate methods to write each variable to outFile  
            for(int i = 0; i < 6; i++)
            {	
               String a = "Jeni";
               String b = "Van Kesteren";
               int c = 4207216;
            
            	outFile.writeInt(c);
            	
            	//outFile.writeInt( a.length() );
               for( int j = 0; j < FIELD_SIZE; j++ )
               {
                  if(j < a.length())
                  {
                 		outFile.writeChar( a.charAt( j ) );
               	}	
               	else
               	{
               
               		outFile.writeChar(' ');
               		}
               }
            
               //outFile.writeInt( b.length() );
                for( int j = 0; j < FIELD_SIZE; j++ )
               {
                  if(j < b.length())
                     outFile.writeChar( b.charAt( j ) );
               	else
               		outFile.writeChar(' ');
               }
              }	
         	
                  
            outFile.close(); 
         } 
             catch (IOException err1) 
            { 
               System.out.println("File ERROR " + err1.toString() ); 
            } 
      
         
      } 
   
   }