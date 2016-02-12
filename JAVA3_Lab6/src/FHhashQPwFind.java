import cs_1c.*;
import java.util.*;

//------------ Class FHhashQPwFind Definition ---------------
public class FHhashQPwFind<KeyType, E extends Comparable<KeyType> >
extends FHhashQP<E> {

   public E Find(KeyType key) {
      int pos = findPosKey(key);
      if (mArray[pos].state == ACTIVE)
         return mArray[pos].data;
      else 
         throw new NoSuchElementException();
   }
   
   // uses the key rather than the object, to hash.
   protected int myHashKey(KeyType key) {
      int hashVal;

      hashVal = key.hashCode() % mTableSize;
      if(hashVal < 0)
         hashVal += mTableSize;

      return hashVal;
   }
   
   // uses the key rather than the object, to get a position.
   protected int findPosKey(KeyType key){
      int kthOddNum = 1;
      int index = myHashKey(key);

      while ( mArray[index].state != EMPTY
         && !mArray[index].data.equals(key) )
      {
         index += kthOddNum; // k squared = (k-1) squared + kth odd #
         kthOddNum += 2;     // compute next odd #
         if ( index >= mTableSize )
            index -= mTableSize;
      }
      return index;
   }

}
