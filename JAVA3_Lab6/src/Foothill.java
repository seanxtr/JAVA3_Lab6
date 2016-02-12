// CIS 1C Assignment #5
// Part A

// https://github.com/ivadenis/DataStructures-and-Algorithms/blob/master/Quadratic%20Probing/src/Client.java

import cs_1c.*;

class EBookCompInt implements Comparable<Integer> {
   int data;
   
   public EBookCompInt(int e){
      data = e;
   }
   
   public String toString() {
	   return String.format("%d", data);
   }
   
   public int compareTo(Integer key) {
      return data - key;
   }
   
   public boolean equals(EBookCompInt rhs) {
      return data == rhs.data;
   }

   public int hashCode() { 
      return data;
   } 
}

class EBookCompString implements Comparable<String> {
   String data;
   
   public EBookCompString(String e){
      data = e;
   }
   
   public String toString() {
      return data;
   }
   
   public int compareTo(String key) {
      return data == key ? 1 : 0;
   }
   
   public boolean equals(EBookCompString rhs) {
      return data == rhs.data;
   }

   public int hashCode() { 
      return data.hashCode();
   } 
}

//------------------------------------------------------
public class Foothill
{

   public static final int NUM_RANDOM_INDICES = 25;
   
   // -------  main --------------
   public static void main(String[] args) throws Exception
   {
      
      // FHhashQPwFind< Integer, EBookCompInt> hashTable 
      //    = new FHhashQPwFind<Integer, EBookCompInt>();
      
      FHhashQPwFind<String, EBookCompString> hashTable 
         = new FHhashQPwFind<String, EBookCompString>();

      
      // create a QP hash table of EBooks ...
      // generate some random indices into the EBookEntryReader vector ...
      // insert all books into the hash table (if SORT_BY_ID) or fewer (If SORT_BY_CREATOR) ...
      // display NUM_RANDOM_INDICES books from array ...
      
      EBookEntryReader book_input = new EBookEntryReader("catalog-short4.txt");

      int array_size, k;
      // how we test the success of the read:
      if (book_input.readError()) {
         System.out.println("couldn't open " + book_input.getFileName()
            + " for input.");
         return;
      }

      // attempt to find on the selected key
      System.out.println( "The same random books from the hash table " );
      for (int k = 0; k < NUM_RANDOM_INDICES; k++) {
    		//TODO:
         try {
            // bookResult = hashTable.find( 
            //    bookInput.getBook(randomIndices[k]).getCreator() );
            bookResult = hashTable.find( 
               bookInput.getBook(randomIndices[k]).getETextNum() );
         }
         catch (NoSuchElementException e) {
        		//TODO:
         }
         System.out.println();
      }
      
      // test known successes failures exceptions:
      try {
          // bookResult = hashTable.find( "Jack Kerouac" );
          bookResult = hashTable.find( -3 );
          
      	//TODO:
      }
      catch (NoSuchElementException e) {
      }
      
      // more failures
      try {
    	  
      }
      catch (NoSuchElementException e) {
    	  
      }
      
      try {
      }
      catch (NoSuchElementException e) {
      }
   } 
}