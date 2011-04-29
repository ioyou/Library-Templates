   package mylibrary.myio.myfiles;


   import java.io.*;
   import mylibrary.mydatastructures.StudentRecord;

// The "BinaryFile" class.
    public class BinaryFile implements DataFile
   {
      private FileInputStream fis;
      private DataInputStream inFile; 
      private FileOutputStream fos;  
      private DataOutputStream outFile;
   
      private String fileName; 
      final long FIELD_SIZE = 20; //the size we will allot for a String name
      
   	 
   
   // Constructor
       public BinaryFile (String fn)
      {
         this.fileName = fn;
      }
      
   	 /************************************************************
    /*  prepareInputFile Method                                 */
    /************************************************************
     *
     * Creates the FileInputStream and DataInputStream 
     * instance variables which are needed to read a binary file.
     */
       public void prepareInputFile ()
      {
                                           // create a file input object
         try
         {
            fis=new FileInputStream(fileName); 
            inFile = new DataInputStream(fis);          // Connect DataInputStream to the file input object
         }
             catch (FileNotFoundException e)
            {
               System.out.println ("Error - this binary input file does not exist");
            }
      
      } // close prepareInputFile method
   	
   	
   	 /************************************************************
    /*  prepareOutputFile Method                                */
    /************************************************************
     *
     * Creates the FileOutputStream and DataOutputStream
     * instance variables which are needed to write to a binary file.
     */
       public void prepareOutputFile ()
      {
                                        // create a file output object
         try
         {
            fos = new FileOutputStream (fileName); 
            outFile = new DataOutputStream(fos);  
         }
             catch (IOException e)
            {
               System.out.println ("error=" + e.toString ());
            } // close catch
      } // close prepareOutputFile method
   
   
    /************************************************************
    /*  getNextRecord Method                                    */
    /************************************************************
     *
     * Reads a StudentRecord, including student number, first name
     * and last name, from a binary file.
     */
       public StudentRecord getNextRecord ()
      {
         StudentRecord newRecord = new StudentRecord ();
                 
              
         try 
         { 
             
         
            newRecord.setStudentNumber(inFile.readInt());
         	
            //String Buffers allow String building
            StringBuffer fn = new StringBuffer ("");
            String firstName;
          
            StringBuffer ln = new StringBuffer ("");
            String lastName;
         
         	//Read in first name one char at a time
            for(int i = 0; i < FIELD_SIZE; i++)
               fn.append(inFile.readChar());
         	
            //Trims any blank space if there are empty characters
            firstName = fn.toString ().trim ();
         
         
         	//Read in last name one char at a time
            for(int i = 0; i < FIELD_SIZE; i++)
               ln.append(inFile.readChar());
         	
            lastName = ln.toString ().trim ();
         
            newRecord.setFirstName(firstName);
            newRecord.setLastName(lastName);
         
            
         
            inFile.close(); 
         
           
         } 
             catch (IOException e)
            {
               System.out.println ("error=" + e.toString ());
            } // close catch
      
         return newRecord;
      }
   
   
       public StudentRecord getNextRecord (long recordNumber)
      {
         StudentRecord newRecord = new StudentRecord ();
         return newRecord;
      }
   
   
       public void writeNextRecord (StudentRecord record, long recordNumber)
      {
      }
   
   
    /************************************************************
    /*  writeNextRecord Method                                    */
    /************************************************************
     *
     * Writes a StudentRecord, including student number, first name
     * and last name, to a text file.
     */
       public void writeNextRecord (StudentRecord record)
      {
         try
         {
          	//Write the student number
            outFile.writeInt(record.getStudentNumber());
         
            StringBuffer fn = new StringBuffer ("");
         
            String firstName = record.getFirstName();
            for( int j = 0; j < FIELD_SIZE; j++ )
            {
               if(j < firstName.length())
               {
                  outFile.writeChar( firstName.charAt( j ) );
               }	
               else
               {
               
                  outFile.writeChar(' ');
               }
            }//end for
         
            StringBuffer ln = new StringBuffer ("");
         
            String lastName = record.getLastName();
            for( int j = 0; j < FIELD_SIZE; j++ )
            {
               if(j < lastName.length())
               {
                  outFile.writeChar( lastName.charAt( j ) );
               }	
               else
               {
               
                  outFile.writeChar(' ');
               }
            
            }//end for
         }//end try
         
             catch (IOException e)
            {
               System.out.println ("error=" + e.toString ());
            } // close catch
      
      
         	
      
      }
   
   
    /*************************************************************/
    /*  getNext Method                                           */
    /*************************************************************
     *
     * Reads current line from text file.
     *
     * @return     String read or "-1"
     */
       public String getNext ()
      {
            return "";
         
      } // close getNext method
   
   
    /************************************************************
    /*  writeNext Method                                          */
    /************************************************************
     *
     * Writes String field to class variable PrintWriter pw.
     *
     * @param field String to be written to the BufferedWriter
     */
       public void writeNext (String field)
      {
      } // close writeNext method
   
   
    /************************************************************
    /*  close Method                                            */
    /************************************************************
     *
     * Closes the AsciiFile. Without this method, the file will be blank.
     */
       public void close ()
      {
         try
         {
            outFile.close();
         }             
             catch (IOException e)
            {
               System.out.println ("error=" + e.toString ());
            } // close catch
      
      }
      
   	
        
       public void closeInput()throws IOException {
         inFile.close();
      }
    
   
   
   
   } // BinaryFile class
