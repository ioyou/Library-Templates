   import java.io.*; 

    class BinaryFileTemplate 
   { 
       public static void main(String args[]) 
      { 
         System.out.println("Starting Binary File Example..."); 
         //Create an integer (i), a double (j), a char (k), a String (l) and 
         //a float (m) with initial and legal values.
      	
      	
      	
      	//Create a variable of each type above that will be assigned a value
      	//later. Call them a, b, c, d and e respectively.
      	
      	
      	
      	 
      	//A FileOutputStream and a DataOutputStream
         FileOutputStream fos; 
         DataOutputStream outFile; 
      
         try 
         { 
            //Constructors to initialize
            fos = new FileOutputStream("binary.bin"); 
            outFile = new DataOutputStream(fos); 
            
          	//Use appropriate methods to write each variable to outFile   
                  
            outFile.close(); 
         } 
             catch (IOException err1) 
            { 
               System.out.println("File ERROR " + err1.toString() ); 
            } 
      
         //A FileInputStream and a DataInputStream
         FileInputStream fis;
         DataInputStream inFile; 
      
         try 
         { 
            //Constructors to initialize
            fis=new FileInputStream("binary.bin"); //reading in from binary.bin
            inFile = new DataInputStream(fis); 
            
         	//Use appropriate methods to read in the values from binary.bin
         	//and store them in a, b, c, d and e
         	
            inFile.close(); 
         	
         	
         	//Printing out values read from file.
         	//They should be the same as the ones you created above.
         	System.out.println("Read the Integer:" + a); 
            System.out.println("Read the Double:" + b); 
            System.out.println("Read the Char:" + c); 
            System.out.println("Read the String:" + d); 
            System.out.println("Read the Float:" + e); 
         } 
             catch (IOException err2) 
            { 
               System.out.println("File ERROR " + err2.toString() ); 
            } 
      } 
   } 

