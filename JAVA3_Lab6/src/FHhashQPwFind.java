//------------ Class FHhashQPwFind Definition ---------------
import cs_1c.*;
import java.util.*;

public class FHhashQPwFind<KeyType, E extends Comparable<KeyType>>
   extends FHhashQP<E> {

   /**
    * Method to find data by key
    * @param key      target key
    * @return         the object
    */
   public E Find(KeyType key) {
      // find the location
      int pos = findPosKey(key);
      
      // check if the object is deleted
      if (mArray[pos].state != ACTIVE)
         throw new NoSuchElementException();
      
      return mArray[pos].data;
   }
   
   /**
    * Use the key to hash
    * @param key      the key that will be hashed
    * @return         hash result
    */
   protected int myHashKey(KeyType key) {
      int hashVal;

      hashVal = key.hashCode() % mTableSize;
      if(hashVal < 0)
         hashVal += mTableSize;

      return hashVal;
   }
   
   /**
    * Use the key to find the position of object that match the key
    * @param key      target key
    * @return         object position
    */
   protected int findPosKey(KeyType key){
      int kthOddNum = 1;
      int index = myHashKey(key);

      while ( mArray[index].state != EMPTY
         && mArray[index].data.compareTo(key) != 0)
      {
         index += kthOddNum; // k squared = (k-1) squared + kth odd #
         kthOddNum += 2;     // compute next odd #
         if ( index >= mTableSize )
            index -= mTableSize;
      }
      return index;
   }

   /**
    * Method to print out all object
    */
   public void display() {
      for (int i = 0; i < mArray.length; i++) {
         if (mArray[i].data != null) {
            System.out.println("Array[ " + i + " ] " + mArray[i].data);
         }
      }
   }
}
