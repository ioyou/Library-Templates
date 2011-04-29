package mylibrary.myio.myfiles;
import mylibrary.mydatastructures.*;


/**
* Interface for file access classes
* 
* @author E.F. Teevan
* @version April 20, 2006
*/ 

  

  
public interface DataFile
{ 

 	public String getNext();
  	public void prepareInputFile ();
   public void prepareOutputFile ();
   public void writeNext(String field);
   public StudentRecord getNextRecord();
   public void writeNextRecord(StudentRecord record);
   public void close(); 

 


}// close interface 
