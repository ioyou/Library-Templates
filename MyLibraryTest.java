/**
 * @(#        2.0     04/03/29
 *
 * A program to test the packages created for Assignment 8.  These packages include:
 * myfiles:         AsciiFile, BinaryFile, and RandomFile classes
 * myalgorithms:    Sort and Search classes
 * mylinkedlists:   IntLinkedList, IntNode, StringLinkedList, StrNode classes
 * myio:            Keyboard and Screen classes
 *
 * Use is also made of the StudentRecord class to input and output to the files.
 *
 * NOTE:    Three files should already exist, each containg at least five StudentRecords:
 *          ascii.txt, raf.bin, and binary.dat
 *
 * NOTE:    This file has been commented according to:
 *              http://java.sun.com/j2se/javadoc/writingdoccomments/
 *              http://java.sun.com/docs/codeconv/html/CodeConvTOC.doc.html
 *              http://www.tvdsb.on.ca/oakridge/computers/ics4/style.htm
 *
 * NOTE:    The records for the random access file will contain a last name of 20
 *          characters (max), a first name of 15 characters (max), and a student
 *          number of type long.
 *
 * @author E. Teevan
 * @version March 29, 2004
 *
 */

   import mylibrary.myalgorithms.*;
   import mylibrary.mydatastructures.*;
   import mylibrary.myio.*;
   import mylibrary.myio.myfiles.*;
	import java.io.*;


    public class MyLibraryTest
   {
   
       public static void main (String[] Args)
      {
         final String ASCII_FILE = "ascii.txt";       // text file of student records
         final String RAF_FILE = "raf.bin";           // random access file of records
         final String BIN_FILE = "binary.dat";        // binary file of student records
         final int SIZE = 20;                         // maximum amount of data
         final long REC_LENGTH = 78;                  // size of raf record in bytes
         //TestData.makeAsciiFile();
         ////TestData.makeBinaryFile();
      	//TestData.makeRandomFile(REC_LENGTH);
      // File objects
         AsciiFile aFile = new AsciiFile (ASCII_FILE);
         RandomFile rFile = new RandomFile (RAF_FILE, REC_LENGTH);
        // BinaryFile bFile = new BinaryFile (BIN_FILE);
      
         String firstName;                           // first name for StudentRecord
         String lastName;                            // last name for StudentRecord
         int studentID;                              // student number for StudentRecord
         StudentRecord tempRecord;                   // record to be written to file
      
         int[] data = new int [SIZE];                // array of ints to be sorted
         int[] original = new int [SIZE];            // array to reset data original
      
         String[] strData = new String [SIZE];       // array of Strings to be sorted
         String[] strOriginal = new String [SIZE];   // array to reset strData to original
      
        // StringLinkedList myLL = new StringLinkedList ();  // linked list of Strings
        // IntLinkedList myIntLL = new IntLinkedList ();   // linked list of ints
      
      
      
      // Opens the files for reading
         aFile.prepareInputFile ();
         rFile.prepareInputFile ();
        // bFile.prepareInputFile ();
      
      // Reads and prints a different record from each file
         tempRecord = aFile.getNextRecord ();
         Screen.print ("The first name from the text file is " + tempRecord.getFirstName ());
         Screen.print ("Press enter to contine.");
         Keyboard.readLine ();
      
         tempRecord = rFile.getNextRecord ();
         tempRecord = rFile.getNextRecord ();
         Screen.print ("The second student number from the random access file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to contine.");
         Keyboard.readLine ();
      
         for (int i = 0 ; i < 5 ; i++)
            tempRecord = bFile.getNextRecord ();
         Screen.print ("The fifth student number from the binary file is " + tempRecord.getStudentNumber ());
         Screen.print ("Press enter to contine.");
         Keyboard.readLine ();
      
      // Closes the three files for reading
         aFile.closeInput ();
         rFile.close ();
         bFile.closeInput ();
      
      
      /*
      * Tests text files, binary files, and
      * randomaccessfiles and IO
      */
      
      // Prepares the three kinds of output files
         aFile.prepareOutputFile ();
         rFile.prepareOutputFile ();
         bFile.prepareOutputFile ();
      
      // Creates a student record to write to all three files
         Screen.print ("What is the student's first name?");
         firstName = Keyboard.readLine ();
         Screen.print ("What is the student's last name?");
         lastName = Keyboard.readLine ();
         Screen.print ("What is the student's ID number");
         studentID = Keyboard.readInt ();
         tempRecord = new StudentRecord (firstName, lastName, studentID);
      
      // Writes the student record to all three files
         aFile.writeNextRecord (tempRecord);
         rFile.writeNextRecord (tempRecord);
         bFile.writeNextRecord (tempRecord);
      
      // Closes the files for writing
         aFile.close ();
         rFile.close ();
         bFile.close ();
      
      
      
      
      /*
      * Tests sorting and searching and IO
      *
      */
      
      // Fills data array with random integers and outputs them
         TestData.generate (data, original);
         Screen.print ("Contents of the integer array are:");
         TestData.print (data);
         Screen.print ("");
      
      // Sorts and searches
         Sort.bubble (data);
         Screen.print ("The result of the bubble sort is:");
         TestData. print (data);
         Screen.print ("");
         TestData.restore (data, original);
         Screen.print ("The unsorted data are:");
         TestData. print (data);
         Screen.print ("");
         int location = Search.sequential (data, 1);
         Screen.print ("The value 1 was found at spot #" + location);
         Screen.print ("");
         Sort.insertion (data);
         Screen.print ("The result of the insertion sort is:");
         TestData. print (data);
         Screen.print ("");
         location = Search.binary (data, 1);
         Screen.print ("The value 1 was found at spot #" + location);
         Screen.print ("");
         Screen.print ("Press enter to contine.");
         Keyboard.readLine ();
      
      
      // Fills data array with random Strings and outputs them
         TestData.generate (strData, strOriginal);
         Screen.print ("Contents of the String array are:");
         TestData.print (strData);
         Screen.print ("");
      
      // Sorts and searches
         Sort.bubble (strData);
         Screen.print ("The result of the bubble sort is:");
         TestData.print (strData);
         Screen.print ("");
         TestData.restore (strData, strOriginal);
         Screen.print ("The unsorted data are:");
         TestData.print (strData);
         Screen.print ("");
         location = Search.sequential (strData, "aa");
         Screen.print ("The value aa was found at spot #" + location);
         Screen.print ("");
         Sort.insertion (strData);
         Screen.print ("The result of the insertion sort is:");
         TestData.print (strData);
         Screen.print ("");
         location = Search.binary (strData, "aa");
         Screen.print ("The value aa was found at spot #" + location);
         Screen.print ("");
         Screen.print ("Press enter to contine.");
         Keyboard.readLine ();
      
      
      /* Tests linked lists of Strings and IO
         myLL.addToEnd ("April showers");
         myLL.addToEnd ("Bring");
         myLL.addToEnd ("May flowers");
         myLL.printList ();
         myLL.delete ("Bring");
         Screen.print ("Deleting the middle");
         myLL.printList ();*/
      
      /* Tests linked lists of ints and IO
         myIntLL.addToEnd (5);
         myIntLL.addToEnd (6);
         myIntLL.addToEnd (7);
         myIntLL.printList ();
         myIntLL.delete (6);
         Screen.print ("Deleting the middle");
         myIntLL.printList ();*/
      
      } // close main
   }
