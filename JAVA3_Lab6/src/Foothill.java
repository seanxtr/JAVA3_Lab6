// CIS 1C Assignment #5
// Part A

// ----------- wrapper classes -------------

class EBookCompInt implements Comparable<Integer> {
	//TODO:
}

class EBookCompString implements Comparable<String> {
	//TODO:
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
      
      FHhashQPwFind< String, EBookCompString> hashTable 
         = new FHhashQPwFind<String, EBookCompString>();

      //TODO:
  
      // create a QP hash table of EBooks ...
      // generate some random indices into the EBookEntryReader vector ...
      // insert all books into the hash table (if SORT_BY_ID) or fewer (If SORT_BY_CREATOR) ...
      // display NUM_RANDOM_INDICES books from array ...
      
      //TODO:

      // attempt to find on the selected key
      System.out.println( "The same random books from the hash table " );
      for (int k = 0; k < NUM_RANDOM_INDICES; k++)
      {
    		//TODO:
         try
         {
            // bookResult = hashTable.find( 
            //    bookInput.getBook(randomIndices[k]).getCreator() );
            bookResult = hashTable.find( 
               bookInput.getBook(randomIndices[k]).getETextNum() );

         }
         catch (NoSuchElementException e)
         {
        		//TODO:
         }
         System.out.println();
      }
      
      // test known successes failures exceptions:
      try
      {
          // bookResult = hashTable.find( "Jack Kerouac" );
          bookResult = hashTable.find( -3 );
          
      	//TODO:
          
      }
      catch (NoSuchElementException e)
      {
      }
      
      // more failures
      try
      {
      }
      catch (NoSuchElementException e)
      {
      }
      
      try
      {
      }
      catch (NoSuchElementException e)
      {
      }
   } 
}