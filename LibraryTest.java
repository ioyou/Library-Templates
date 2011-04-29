   import mylibrary.myalgorithms.*;
   import mylibrary.mydatastructures.StudentRecord;
   import mylibrary.myio.*;
   import mylibrary.myio.myfiles.*;
   import java.io.*;


    public class LibraryTest
   {
       public static void main (String[] Args)
      {
         final String ASCII_FILE = "ascii.txt";       // text file of student records
         final String RAF_FILE = "raf.bin";           // random access file of records
         final String BIN_FILE = "records.bin";        // binary file of student records
         final int SIZE = 20;                         // maximum amount of data
         final long REC_LENGTH = 78;                  // size of raf record in bytes
      
      //Make file objects
         AsciiFile aFile = new AsciiFile(ASCII_FILE);
        // RandomFile rFile = new RandomFile(RAF_FILE, REC_LENGTH);
         BinaryFile bFile = new BinaryFile(BIN_FILE);
      
      
         aFile.prepareInputFile();
         bFile.prepareInputFile();
			//rFile.prepareInputFile();
      	
         String firstName;                           // first name for StudentRecord
         String lastName;                            // last name for StudentRecord
         int studentID;                              // student number for StudentRecord
         StudentRecord tempRecord;                   // record to be written to file
      
         int[] data = new int [SIZE];                // array of ints to be sorted
         int[] original = new int [SIZE];            // array to reset data original
      
         String[] strData = new String [SIZE];       // array of Strings to be sorted
         String[] strOriginal = new String [SIZE];   // array to reset strData to original
      
         tempRecord = aFile.getNextRecord ();
         Screen.print ("The first name from the text file is " + tempRecord.getFirstName ());
         Screen.print ("Press enter to contine.");
         Keyboard.readString ();
         
			/*
      	tempRecord = rFile.getNextRecord ();
      	tempRecord = rFile.getNextRecord ();
         Screen.print ("The second student number from the random access file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to contine.");
         Keyboard.readString ();*/
			
			for (int i = 0 ; i < 5 ; i++)
            tempRecord = bFile.getNextRecord ();
         Screen.print ("The fifth student number from the binary file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to contine.");
         Keyboard.readString ();
			
						
			
			 // Prepares the three kinds of output files
         aFile.prepareOutputFile ();
         //rFile.prepareOutputFile ();
         bFile.prepareOutputFile ();
      
      // Creates a student record to write to all three files
         Screen.print ("What is the student's first name?");
         firstName = Keyboard.readString ();
         Screen.print ("What is the student's last name?");
         lastName = Keyboard.readString ();
         Screen.print ("What is the student's ID number");
         studentID = Keyboard.readInt ();
         tempRecord = new StudentRecord (firstName, lastName, studentID);
      
      // Writes the student record to all three files
         aFile.writeNextRecord (tempRecord);
         //rFile.writeNextRecord (tempRecord);
         bFile.writeNextRecord (tempRecord);
      
      // Closes the files for writing
         aFile.close ();
         //rFile.close ();
         bFile.close ();




      
      }//end main
   }//end LibraryTest class
