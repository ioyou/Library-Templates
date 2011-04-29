   package mylibrary.myio.myfiles;
/**
 * Class which creates text files and methods to read and write single Strings
 * from and to them.
 *
 * @author E.F. Teevan
 * @version March 21, 2003
 */


   import java.io.*;
   import mylibrary.mydatastructures.*;

    public class AsciiFile implements DataFile
   { // Instance variables
      private BufferedReader br;
      private PrintWriter pw;
      private String fileName;                                        // name of text file
   
    // Constructor
       public AsciiFile (String fileName)
      {
         this.fileName = fileName;
      }
   
   
    /************************************************************
    /*  prepareInputFile Method                                 */
    /************************************************************
     *
     * Creates the FileReader and instantiates the BufferedReader
     * instance variable which are needed to read a text file.
     */
       public void prepareInputFile ()
      {
         FileReader fr;                                  // create a file input object
         try
         {
            fr = new FileReader (fileName);         // Create a new file input stream that is connected to fileName
            br = new BufferedReader (fr);           // Connect DataInputStream to the file input object
         }
             catch (FileNotFoundException e)
            {
               System.out.println ("Error - this ASCII input file does not exist");
            }
      
      } // close prepareInputFile method
   
   
    /************************************************************
    /*  prepareOutputFile Method                                */
    /************************************************************
     *
     * Creates the FileWriter and instantiates the BufferedWriter
     * instance variable which are needed to write to a text file.
     */
       public void prepareOutputFile ()
      {
         FileOutputStream fos;                                 // create a file output object
         try
         {
            fos = new FileOutputStream (fileName);              // Create a new file output stream that is connected to fileName
            pw = new PrintWriter (fos);                     // Connect DataOutputStream to the file output object
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
     * and last name, from a text file.
     */
       public StudentRecord getNextRecord ()
      {
         StudentRecord newRecord = new StudentRecord ();
         newRecord.setStudentNumber (Integer.parseInt (getNext ()));
         if (newRecord.getStudentNumber () == -1)
         {
            newRecord.setNull ();
            return newRecord;
         }
         newRecord.setFirstName (getNext ());
         newRecord.setLastName (getNext ());
      
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
         writeNext ("" + record.getStudentNumber ());
         writeNext (record.getFirstName ());
         writeNext (record.getLastName ());
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
         String field = "-1";                                            // text read from file
         try
         { /* Read next line if there is something to read */
            if (br.ready ())
            {
               field = br.readLine ();
            } // close if
         } // close try
         
             catch (IOException e)
            {
               System.out.println ("error=" + e.toString ());
            } // close catch
      
         return field;
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
         pw.println (field);                           // Write String to file
      } // close writeNext method
   
   
    /************************************************************
    /*  close Method                                            */
    /************************************************************
     *
     * Closes the AsciiFile. Without this method, the file will be blank.
     */
       public void close ()
      {
         pw.close ();
      }
      
} // close AsciiFile class

