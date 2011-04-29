   import java.util.*;
/**
@author E. Teevan
 A class to simplify keyboard input even further than the Scanner
 class already does.  The Keyboard class is a set of static methods
 for reading from the keyboard.
*/
    public class Keyboard
   {
      static Scanner keyboard = new Scanner (System.in);
   
      static String inputText = "";
   
       public static String readString ()
      {
         return keyboard.nextLine ();
      }
   
   
       public static int readInt ()
      {
         return keyboard.nextInt ();
      }
   
   
       public static double readDouble ()
      {
         return keyboard.nextDouble ();
      }
   
   
       public static long readLong ()
      {
      
         return keyboard.nextLong ();
      }
   
   
       public static boolean readBoolean ()
      {
      
         return keyboard.nextBoolean ();
      }
   } // class


