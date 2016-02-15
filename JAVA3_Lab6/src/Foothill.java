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
      String searchKey1[] = new String[NUM_RANDOM_INDICES];
      int searchKey2[] = new int[NUM_RANDOM_INDICES];
      EBookEntry tmp = null;
      
      // test the success of the read
      if (book_input.readError()) {
         System.out.println("couldn't open " + book_input.getFileName()
            + " for input.");
         return;
      }

      // populate both hash tables
      for(k = 0; k < NUM_RANDOM_INDICES; k++) {
         tmp = book_input.getBook(
            randomIndices(0, book_input.getNumBooks()));
         searchKey1[k] = tmp.getCreator();
         hashTableString.insert(new EBookCompString(tmp));
         
         tmp = book_input.getBook(
            randomIndices(0, book_input.getNumBooks()));
         searchKey2[k] = tmp.getETextNum();
         hashTableInt.insert(new EBookCompInt(tmp));
      }
      
      // displace string hash table
      System.out.println("Displace the hash table with string key:\n");
      hashTableString.display();
      
      // attempt to find on the selected string key
      System.out.println( "Attempt to find on the selected string key:\n" );
      for (k = 0; k < NUM_RANDOM_INDICES; k++) {
         try {
            bookResult1 = hashTableString.Find(searchKey1[k]);
            System.out.println(String.format("Found item with key %s", searchKey1[k]));
         }
         catch (NoSuchElementException e) {
            System.out.println(String.format("Fail to find book by key %s",searchKey1[k]));
         }
      }
      
      // displace string hash table
      System.out.println("Displace the hash table with integer key:\n");
      hashTableInt.display();
      
      // attempt to find on the selected integer key
      System.out.println( "Attempt to find on the selected integer key:\n" );
      for (k = 0; k < NUM_RANDOM_INDICES; k++) {
         try {
            bookResult2 = hashTableInt.Find(searchKey2[k]);
            System.out.println(String.format("Found item with key %d", searchKey2[k]));
         }
         catch (NoSuchElementException e) {
            System.out.println(String.format("Fail to find book by key %d",searchKey2[k]));
         }
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
   
   static int randomIndices(int min, int max) {
      Random rn = new Random();
      int range = max - min + 1;
      int randomNum =  rn.nextInt(range) + min;
      return randomNum;
   }
}