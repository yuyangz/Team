public class QuickSortTester{

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
	    long start = System.nanoTime();
	    QuickSort.qsort(test1);
	    long time = System.nanoTime() - start;
	    res1[x] = time;
	}
    }
}

					       
	
