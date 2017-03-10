public class QuickSortTester{
    /*
      We first had a method that would be used to generate random arrays of certain 
      lengths. We had various arrays ranging from size 1 to 100000. After doing so,
      we ran quicksort on each array 10000 times. We then took the 10000 times and 
      averaged them up to get the average runtime for each array.

      Averages
      Array Length of 1: 229
      Array Length of 5: 319
      Array Length of 10: 503
      Array Length of 50: 2925
      Array Length of 100: 5526
      Array Length of 500: 30794
      Array Length of 1000: 58866
      Array Length of 5000: 331088
      Array Length of 10000: 610985
      Array Length of 50000: 3255880
      Array Length of 100000: 6767340
    */
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    public static long average (long[] arr){
	long sum = 0;
	for (int x = 0 ; x < arr.length; x +=1){
	    sum += arr[x];
	}
	return sum / (arr.length - 1);
    }

    public static long timer (int[] arr){
	long startTime = System.nanoTime();
	QuickSort.qsort(arr);
	long end = System.nanoTime();
	return end - startTime;
    }
    public static void main(String[] args){
	int[] test1 = buildArray(1, 5);
	int[] test2 = buildArray(5, 5);
        int[] test3 = buildArray(10, 50);
	int[] test4 = buildArray(50, 50);
	int[] test5 = buildArray(100, 500);
	int[] test6 = buildArray(500, 500);
	int[] test7 = buildArray(1000, 5000);
	int[] test8 = buildArray(5000, 5000);
	int[] test9 = buildArray(10000, 500000);
	int[] test10 = buildArray(50000, 500000);
	int[] test11 = buildArray(100000, 500000);

	int batchsize = 10000;
	
        long[] res1 = new long[batchsize];
	long[] res2 = new long[batchsize];
	long[] res3 = new long[batchsize];
	long[] res4 = new long[batchsize];
	long[] res5 = new long[batchsize];
	long[] res6 = new long[batchsize];
	long[] res7 = new long[batchsize];
	long[] res8 = new long[batchsize];
        long[] res9 = new long[batchsize];
	long[] res10 = new long[batchsize];
	long[] res11 = new long[batchsize];

	for (int x = 0 ; x  < batchsize; x += 1){
	    res1[x] = timer(test1);
	    res2[x] = timer(test2);
	    res3[x] = timer(test3);
	    res4[x] = timer(test4);
	    res5[x] = timer(test5);
	    res6[x] = timer(test6);
	    res7[x] = timer(test7);
	    res8[x] = timer(test8);
	    res9[x] = timer(test9);
	    res10[x] = timer(test10);
	    res11[x] = timer(test11);
	}

	System.out.println("Averages");
	System.out.println("Array Length of 1: " + average(res1));
	System.out.println("Array Length of 5: " + average(res2));
	System.out.println("Array Length of 10: " + average(res3));
	System.out.println("Array Length of 50: " + average(res4));
	System.out.println("Array Length of 100: " + average(res5));
	System.out.println("Array Length of 500: " + average(res6));
	System.out.println("Array Length of 1000: " + average(res7));
	System.out.println("Array Length of 5000: " + average(res8));
	System.out.println("Array Length of 10000: " + average(res9));
	System.out.println("Array Length of 50000: " + average(res10));
	System.out.println("Array Length of 100000: " + average(res11));
	   
    }
}


					       
	
