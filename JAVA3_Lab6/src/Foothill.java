// CIS 1C Assignment #6
// Part A

import cs_1c.*;
import java.util.*;

class EBookCompInt implements Comparable<Integer> {
   EBookEntry data;
   public EBookCompInt (EBookEntry e) { 
     data = e; 
   }
   
   public String toString() { 
     return data.toString(); 
   }

   public int compareTo(Integer key) {
      return data.getETextNum() - key;
   }

   public boolean equals( EBookCompInt rhs ) {
      return data.equals(rhs.data);
   }
    
   public int hashCode() {
      return data.getETextNum();
   } 
}

class EBookCompString implements Comparable<String> {
   EBookEntry data;
   public EBookCompString (EBookEntry e) { 
     data = e; 
   }

   public String toString() { 
     return data.toString(); 
   }

   public int compareTo(String key) {
     return data.getCreator().compareTo(key);
   }

   public boolean equals ( EBookCompString rhs ) {
      return data.equals(rhs.data);
   }
    
   public int hashCode() {
      return data.getCreator().hashCode();
   } 
}

//------------------------------------------------------
public class Foothill {

   public static final int NUM_RANDOM_INDICES = 25;
   
   // -------  main --------------
   public static void main(String[] args) throws Exception {
      int k;
      EBookEntryReader book_input = new EBookEntryReader("catalog-short4.txt");
      FHhashQPwFind<String, EBookCompString> hashTableString
         = new FHhashQPwFind<String, EBookCompString>();
      FHhashQPwFind< Integer, EBookCompInt> hashTableInt
         = new FHhashQPwFind<Integer, EBookCompInt>();
      EBookCompString bookResult1;
      EBookCompInt bookResult2;
      
      // test the success of the read
      if (book_input.readError()) {
         System.out.println("couldn't open " + book_input.getFileName()
            + " for input.");
         return;
      }

      // populate both hash tables
      for(k = 0; k < book_input.getNumBooks(); k++) {
         hashTableString.insert(new EBookCompString(book_input.getBook(k)));
         hashTableInt.insert(new EBookCompInt(book_input.getBook(k)));
      }
      
      // attempt to find on the selected string key
      System.out.println( "Attempt to find on the selected string key:\n" );
      for (k = 0; k < NUM_RANDOM_INDICES; k++) {
         String key = book_input.getBook(
            randomIndices(0, book_input.getNumBooks())).getCreator();
         try {
            bookResult1 = hashTableString.Find(key);
            System.out.println(bookResult1.data.toString());
         }
         catch (NoSuchElementException e) {
            System.out.println(String.format("Fail to find book by key %s",key));
         }
         System.out.println();
      }
      
      // attempt to find on the selected integer key
      System.out.println( "Attempt to find on the selected integer key:\n" );
      for (k = 0; k < NUM_RANDOM_INDICES; k++) {
         int key = book_input.getBook(
            randomIndices(0, book_input.getNumBooks())).getETextNum();
         try {
            bookResult2 = hashTableInt.Find(key);
            System.out.println(bookResult2.data.toString());
         }
         catch (NoSuchElementException e) {
            System.out.println(String.format("Fail to find book by key %d",key));
         }
         System.out.println();
      }
      
      // test known successes failures exceptions:
      try {
          bookResult2 = hashTableInt.Find(-3);
      }
      catch (NoSuchElementException e) {
         System.out.println(String.format("Fail to find book by key %d",-3));
      }
      
      // more failures
      try {
         bookResult1 = hashTableString.Find( "Jack Kerouac" );
      }
      catch (NoSuchElementException e) {
          System.out.println(String.format("Fail to find book by key %s",
             "Jack Kerouac"));
      }
   }
   
   static int randomIndices(int min, int max)
   {
      Random rn = new Random();
      int range = max - min + 1;
      int randomNum =  rn.nextInt(range) + min;
      return randomNum;
   }
}