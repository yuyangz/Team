# Team

1. Summary of QuickSort:
  As the array is split into two sections based on the pivot, by running multiple resursive calls, we are able to split the array down more. As the bounds (left and right) meet each other, the array will be worted.
  
2. Best Case:
    The best case would be when the median is the pivot point. The array be divided into half and the run time would have to be O(nlogn).
    
3. Worst Case: 
  The worst case would be when the greatest of smallest number is chosen as the pivot. The array would not be divided evenly. This runtime would be O(n^2).

4. Average: 
  This sorting algorithm should still maintain its O(nlogn) as extreme pivots will be quite rare.
  
5. Methology:
  We first had a method that would help generate random arrays of certain lengths. We had various arrays ranging from size 1 to 100000. After doing so, we ran quicksort on each array 10000 times. The 10000 times were then averaged up to give the average runtime.
  
6. Runtimes

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
      
7. How pivot selection and data arrangement affect execution time:
  The median value of the unsorted array is used as the pivot. However, if the median index is the least value, this will end up being the worst case (same for biggest).If the array is already sorted, the sort will run logn.
  
Graph:
https://docs.google.com/document/d/1TN7-v5kxcpJ0hcb5RdbljY71c8PWsUdG3gz2OeE4wQo/pub
