   import java.io.*;

   import java.util.*;
   
   import mylibrary.myio.*;


/**
* Using Random Access Binary Files 

  

* The following program accesses a binary file and demonstrates features 

* such as the length() method used to determine the number of records in a file.

* @author R. Parteno (April 2002)
* @author E.F. Teevan (modified)
* @autor J. Van Kesteren (modified)
* @version April, 2011 */ 


    public class UseHourlyEmployee 
   
   {
   
   // Main method
       public static void main(String[] args) throws IOException 
      { 
      
      /*For RandomAccessFiles, include the name of the file, and r, for read,or rw, for read and write.*/ 
      
         RandomAccessFile raf = new RandomAccessFile ("binary.bin", "rw"); 
      
      
      // records for 3 employees 
      
         HourlyEmployee hrEmp [] = new HourlyEmployee [3];
         long numRecords;                     // number of saved records
         long menuChoice;                     // choose add, delete
         double totalPay;                     // employee's pay for week
         final long RECLEN = 80;              // length in bytes for a record
      
      
         
      // Creates and writes three records to binary.bin
         for (int ctr = 0 ; ctr < 3 ; ctr++)
         { 
         
         // Gets record info
            hrEmp [ctr] = new HourlyEmployee ();
         	System.out.print ("Enter an employee name: ");
            String name = Keyboard.readString();
            
            if(ctr == 0)
            {  
              hrEmp[ctr].setName(name);
            }
            else{
               System.out.print("Enter an employee name: ");
               name = Keyboard.readString();

               hrEmp[ctr].setName(name);
            }
         		
            System.out.print ("Enter an employee number: ");
            hrEmp [ctr].setEmpNum (Keyboard.readLong ());
            System.out.print ("Enter hours worked: ");
            hrEmp [ctr].setHoursWorked (Keyboard.readDouble ());
            System.out.print ("Enter hourly rate: ");
            hrEmp [ctr].setHourlyRate (Keyboard.readDouble ());
         	
         
         
                  
         // Calculates and outputs pay to screen.
            hrEmp [ctr].calcPay ();
            System.out.println ("The regular pay for " + hrEmp [ctr].getName () + " is " + hrEmp [ctr].getRegularPay ());
            System.out.println ("The overtime pay for " + hrEmp [ctr].getName () + " is " + hrEmp [ctr].getOvertimePay ());
         	
         
         // Saves the record to the file.
            hrEmp [ctr].writeRec (raf);
         
         
         
         
                 
         } 
      
      
      
      // Outputs file size and menu for choosing record to output to screen.
         numRecords = raf.length () / RECLEN ;
         System.out.println ("The length is " + raf.length ());
         System.out.println ("The # of records is " + numRecords);
         System.out.println (""); 
      
         System.out.print ("Enter a menu choice from 0 to " + (numRecords - 1) + ", or -1 to Exit: ");
         menuChoice = Keyboard.readLong (); 
      
      
      
      // Gets user-chosen records from file until user chooses -1 to quit.
         while (menuChoice > -1)
         { 
         
            HourlyEmployee temp = new HourlyEmployee ();
            if (menuChoice < (numRecords))
            { 
            
               temp.readRec (raf, menuChoice);
               System.out.println ("The employee name is " + temp.getName ());
               totalPay = temp.getRegularPay () + temp.getOvertimePay ();
               System.out.println ("The total pay is " + totalPay); 
            
            }
            else
            { 
            
               System.out.println ("You entered an invalid employee #"); 
            
            }
            System.out.print ("Enter a menu choice from 0 to " + (numRecords - 1) + ", or -1 to Exit: ");
            menuChoice = Keyboard.readLong (); 
         
         }
         System.out.println ("Thank you for using this amazing program!");
         raf.close (); 
      
      } // close main 
   
   }// close class








