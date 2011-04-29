import java.io.*;
import java.util.*;
/**
* HourlyEmployee class is an employee record object with four fields: 

* name, employee number,hourly pay and hours worked. 



* @author R. Parteno 
* @version April 2002 

*/ 


    public class HourlyEmployee 
   
   {
   
      private String name;                 // employee's name
      private long empNum;                 // employee/record number
      private double hourlyRate;           // wage
      private double hoursWorked;          // hours worked in week
      private double regularPay;           // amount earned for regular hours
      private double overtimePay;          // amount earned for hours over 40 
   
   
      private final long RECLEN = 80;      // size of each record in bytes 
   
   
   
   /**
   * Class constructor for empty fields.
   */ 
   
       public HourlyEmployee() 
      { 
      
      // Sets fields 
      
         name = "";
         empNum = 0;
         hourlyRate = 0;
         hoursWorked = 0; 
      
      } 
   
   /**
   * Class constructor specifying each field. 
   
   * 
   
   * @param name        the employee's name 
   
   * @param empNum      the record number 
   
   * @param hourlyRate  employee's pay rate 
   
   * @param hoursWorked week's hours worked
   */ 
   
       public HourlyEmployee(String name, long empNum, double hourlyRate, double hoursWorked) 
      { 
      
      // Sets fields 
      
         this.name = name;
         this.empNum = empNum;
         this.hourlyRate = hourlyRate;
         this.hoursWorked = hoursWorked;
         calcPay ();                 // sets overtimePay and regularPay fields 
      
      }
   
   
       public void setName (String name)
      {
      
      
         this.name = name;
      
      
      }
   
   
   
       public void setEmpNum (long empNum)
      {
      
      
         this.empNum = empNum;
      
      
      
      } 
       public void setHourlyRate (double hourlyRate)
      {
      
      
         this.hourlyRate = hourlyRate;
      
      
      
      } 
       public void setHoursWorked (double hoursWorked)
      {
      
      
         this.hoursWorked = hoursWorked;
      
      
      } 
       public void calcPay ()
      {
      
      
                 
         
            regularPay = hoursWorked * hourlyRate;
         
         
            overtimePay = 0;
         
         
        
      
      
      } 
       public String getName ()
      {
      
      
         return name;
      
      
      }
   
   
       public long getEmpNum ()
      {
      
      
         return empNum;
      
      
      }
   
   
       public double getHourlyRate ()
      {
      
      
         return hourlyRate;
      
      
      }
   
   
       public double getHoursWorked ()
      {
      
      
         return hoursWorked;
      
      
      }
   
   
       public double getRegularPay ()
      {
      
      
         return regularPay;
      
      
      }
   
   
       public double getOvertimePay ()
      {
      
      
         return overtimePay;
      
      
      }
   
   
   // method to write one record of information to a random access file
   // provided as a parameter
       public void writeRec (RandomAccessFile raf) throws IOException
      {
      
         final int FIELD_SIZE = 20;
      
         int padLen = 0; // padding needed to keep 20 bytes in name spot
         int nameLen = name.length (); // length of employee's name
      
      
      // calculate the number of blanks that need to be added to
      // maintain a length of 20
         if (nameLen > FIELD_SIZE)
         
         
            nameLen = FIELD_SIZE;
         
         
         else
         
         
            padLen = FIELD_SIZE - nameLen;
      
      
      
      /* Sets the file-pointer offset, measured from the beginning of this file, at which the next read or write occurs. In other words, it marks the position, in bytes, where to start writing the next time.*/
         raf.seek (empNum * RECLEN ); 
      
      
      
      // write the name to the file, character by character (i.e., byte by byte)
         for (int i = 0 ; i < nameLen ; i++)
         
         
            raf.writeChar (name.charAt (i)); 
      
      
      
      // write the extra blanks 
      
         if (padLen > 0)
         {
         
         
            for (int i = 0 ; i < padLen ; i++) 
            
               raf.writeChar (' ');
         
         
         }
      
      
      
      // write the int and double to the file
         raf.writeLong (empNum);
         raf.writeDouble (hourlyRate);
         raf.writeDouble (hoursWorked);
         raf.writeDouble (regularPay);
         raf.writeDouble (overtimePay);
      
      
      }
   
   
       public void readRec (RandomAccessFile raf, long recNum) throws IOException
      {
      
      
         final int FIELD_SIZE = 20; 
      
         raf.seek (recNum * RECLEN ); // set pointer to next record
         StringBuffer sb = new StringBuffer (""); // a java object to allow String building
      
      // build the String character by character
         for (int ctr = 0 ; ctr < FIELD_SIZE ; ctr++)
         
         
            sb.append (raf.readChar ());
      
      
      
      // convert the StringBuffer to String and trim white space from both ends of the String
         name = sb.toString ().trim ();
      
      // read the long and doubles from the file
         empNum = raf.readLong ();
         hourlyRate = raf.readDouble ();
         hoursWorked = raf.readDouble ();
         regularPay = raf.readDouble ();
         overtimePay = raf.readDouble ();
      
      
      } // close method 
   
   }// close HourlyEmployee class

