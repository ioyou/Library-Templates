   //import mylibrary.myalgorithms.*;
   import mylibrary.myalgorithms.Search;
   import mylibrary.myalgorithms.Sort;
   import mylibrary.mydatastructures.StudentRecord;
   import mylibrary.myio.*;
   import mylibrary.myio.myfiles.*;
   import java.io.*;


    public class LibraryTest
   {
       public static void main (String[] Args)
      {
         final String ASCII_FILE = "ascii.txt";       // text file of student records
         final String RAF_FILE = "random.bin";           // random access file of records
         final String BIN_FILE = "records.bin";        // binary file of student records
         final String INT_FILE = "integers.txt";		// text file with integers
         final int SIZE = 20;                         // maximum amount of data
         final long REC_LENGTH = 84;                  // size of raf record in bytes
      
      //Make file objects
         AsciiFile aFile = new AsciiFile(ASCII_FILE);
         RandomFile rFile = new RandomFile(RAF_FILE, REC_LENGTH);
         BinaryFile bFile = new BinaryFile(BIN_FILE);
         AsciiFile cFile = new AsciiFile(INT_FILE);
      
      
         aFile.prepareInputFile();
         bFile.prepareInputFile();
         rFile.prepareInputFile();
         cFile.prepareInputFile();
      	
         String firstName;                           // first name for StudentRecord
         String lastName;                            // last name for StudentRecord
         int studentID;                              // student number for StudentRecord
         StudentRecord tempRecord;                   // record to be written to file
      
         int[] data = new int [SIZE];                // array of ints to be sorted
      	
      	//Read in file called integers.txt and save in your array. There will be 20.
         for(int i=0;i <SIZE;i++)
         {
            String temp = cFile.getNext();
            data[i] = Integer.parseInt(temp);
         }
        
      	//Before sorting, search for the number 20 using sequential search.
         int result = Search.sequential(data,20); 
         if(result != -1)
         {
            Screen.print("The number 20 was found at index: " + result);
         }
         else
            Screen.print("The number 20 was not found.");
      	
         int choice = 0;
         Screen.print("\nEnter your choice");
         Screen.print("		1. Bubble Sort");
         Screen.print("		2. Insertion Sort");
         choice = Keyboard.readInt();
      	
         if(choice == 1)
         {
            Sort.bubble(data);
         }
         else if(choice == 2)
         {
            Sort.insertion(data);
         }
         else
         {
            Screen.print("\nEnter your choice");
            Screen.print("		1. Bubble Sort");
            Screen.print("		2. Insertion Sort");
            choice = Keyboard.readInt();
         
         }
    
         //Print sorted array to the screen. Try different sorting algorithms.
      	
      	for(int i =0;i<SIZE;i++)
      	{
      		Screen.print(data[i] + " ");
      	}
      	
      	
      	//Now sorted, try searching for 20 using binary search.
      	
      	 // see choices above ^
      	 
      	 
      	 
      	 
      	 
      	 
      	     
         String[] strData = new String [SIZE];       // array of Strings to be sorted
         
      	//Read in a file called strings.txt and save in your array. There will be 20.
      	
      	
      	
      	
      	//Before sorting, search for "Van Kesteren" using sequential search.
      	
      	
      	
      	
      	
      	//Print sorted array to the screen. Try different sorting algorithms.
      	
      
      
      	
      	//Now sorted, search for "Van Kesteren" using binary search.
      	
      	
      	
      	
         StudentRecord[] stRecData = new StudentRecord[SIZE];
        //Read in a file called students.txt and save in your array. There will be 20.
        //Each record will have three lines, student number, first name then last name.
        
      	
      	
      	
      	
      	//Before sorting, search for the student number 4207216 using sequential search.
      	
      	
      	
      	
      	
      	//Print sorted records to the screen. (Just the last name of each student).
      	// Try different sorting algorithms.
      	
      
      
      	
      	//Now sorted, search for "Van Kesteren" using binary search.
      	
      
      	
      		
         tempRecord = aFile.getNextRecord ();
         Screen.print ("The first name from the text file is " + tempRecord.getFirstName ());
         Screen.print ("Press enter to continue.");
         Keyboard.readString ();
         
      
         tempRecord = rFile.getNextRecord ();
      
      
         Screen.print ("The student number from the random access file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to contine.");
         Keyboard.readString ();
      	
         tempRecord = bFile.getNextRecord ();
         Screen.print ("The student number from the binary file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to continue.");
         Keyboard.readString ();
      	
      				
      	
      	 // Prepares the three kinds of output files
         aFile.prepareOutputFile ();
         rFile.prepareOutputFile ();
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
         bFile.writeNextRecord (tempRecord);
         rFile.writeNextRecord (tempRecord);
      							      
      // Closes the files for writing
         aFile.close ();
         rFile.close ();
         bFile.close ();

      }//end main
   }//end LibraryTest class
