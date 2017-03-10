

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * 1. If bounds overlap stop.
 * 2. pick a random pivot point to create a partition about.
 * 3. call quick sort on two halves from the partition
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *     max number of comparisons
 *     pivot is the largest or smallest in the list O(n^2).
 *
 * 2b. Best pivot choice / array state and associated runtime:
 *     pivot is the median of the elements O(nlogn).
 *
 * 3. Approach to handling duplicate values in array:
 *    No Approach. this is already handled by partition.
 *
 *****************************************************/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     * Precond: input array isn't empty
     * Postcond: input array sorted nothing returned
     *****************************************************/
    public static void qsort( int[] d ) { 
	qsort(d, 0, d.length-1);
    }

    /*****************************************************
     * void qsort(int[],int,int)
     * @param d -- array of ints to be sorted in place
     * @param left -- left bound
     * @param right -- right bound
     * Precond: input array isn't empty
     * Postcond: input array sorted from left and right bound.
     *****************************************************/
    public static void qsort( int[] d, int left, int right ) {
	//random pivot since there is no efficient way of picking a good pivot (median)
	if (left < right) {  
	    int pivot = partition(d, left, right, (int)(Math.random() * (right-left) + left)); 
	    qsort(d, left, pivot-1);
	    qsort(d, pivot+1, right);
	}
    }

    /******************************************************
     * int partition(int[] arr,int left,int right,int pvtPos)
     * Precond:  Input array isn't empty,
     * integer inputs within bounds of input array
     * Postcond: Input array modified such that
     * values smaller then number at pvtPos are to the left of pvtPos,
     * and values larger are to the right of pvtPos,
     * index at pvtPos is now at its final resting place.
     * new index of pvtPos returned
     ******************************************************/
    public static int partition (int[] arr, int left, int right, int pvtPos) {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, right, arr);
	int storVal = left;
		
	for (int i = left; i < right; i++) {
	    if (arr[i] <= pvtVal) {
		swap(i, storVal, arr);
		storVal++;
	    }
	}
	swap(storVal, right, arr);
		
	return storVal;
    }//end partition()

    public static long timeApp(int batchSize, int arrLen){
       
	long beg = System.currentTimeMillis();
  
      	for(int i=0;i<batchSize;i++){
	    
	    qsort(buildArray(arrLen,10000));
	
	}
	long end = System.currentTimeMillis();
	long timeElap = end-beg;
	return timeElap;
    }
    //main method for testing
    public static void main( String[] args ) 
    {
	///*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	///*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*
	System.out.println(timeApp(10000000,10)); // 7669
	System.out.println(timeApp(10000000,1)); //449
	System.out.println(timeApp(10000000,5)); //3371
	System.out.println(timeApp(10000000,15)); //12161
	*/
	System.out.println(timeApp(1000000,20)); //1698
	System.out.println(timeApp(100000,50)); //481 -> 4810
	System.out.println(timeApp(100000,100)); // 981 -> 9810
	System.out.println(timeApp(10000,500)); // 548 -> 54800
	System.out.println(timeApp(1000,1000)); // 118 -> 118000

	
    }//end main

	
}//end class QuickSort
