/*
Yuyang Zhang
APCS2 pd01
HW15 -- So So Quick
2017-03-09
*/

/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): It first picks a pivot within the array. After doing so,
   all numbers before this pivot will be less than it and all numbers 
   after it will be greater. We now have to sections. We then chose two new 
   pivots within each section. This process will continue until the entire list 
   is sorted.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 * The worst case would perhaps be the state when the entire array is sorted
   backwards. The pivot would then be the first or last index. This runtime
   would be O(n^2).

 * 2b. Best pivot choice / array state and associated runtime:
 * If the array is already sorted, then this would be the best case.
   O(n) would be the runtime as no numbers will be switched around.

 * 3. Approach to handling duplicate values in array:
 * While I am unsure what the issue would be we may simply
 use the values as pivots. This way duplicates would simply
 be placed next to them. This may be fixed with the use of >= or <=.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

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
     *****************************************************/
    public static void qsort( int[] arr ) 
    { 
	int left = 0;
	int right = arr.length;
	int pivot = (left + right) / 2;

	while (left <= right){
	    while ((arr[left] <= arr[pivot] && left < pivot)){
		left += 1;
	    }
	    while ((arr[right] > arr[pivot])){
		right -= 1;
	    }
	    if (left <= right){
		swap (left, right , arr);
		left += 1;
		right -= 1;
	    }
	}
	if (right > left){
	     qsort(arr);
	}
	if (left < right){
	    qsort(arr);
	}
    }
 
    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.

 public static int partition( int arr[], int left, int right, int pivot)
    {
	int v = arr[pivot];

	swap( pivot, right, arr);
	int stor = left;

	for( int x = left; x < right; x +=1 ) {
	    if ( arr[x] <= v) {
		swap( x, stor, arr );
		stor += 1;}
	}
	swap(stor,right,arr);

	return stor;
    }
    
	 
    //main method for testing
    public static void main( String[] args ) 
    {
	 

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


    }//end main

}//end class QuickSort

