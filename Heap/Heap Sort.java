void buildHeap(int arr[], int n)
{
    //Build heap in reverse order
    for(int i=n/2-1; i>=0; i--)
    {
        heapify(arr, n, i);
    }
    
    //Now we have the largest element at index 0 
    //The remaining elements may not be in sorted order but we need just root element
    //Swap this with last index and heapify on reduced heap
    
    // for(int i=n-1; i>=0; i--)
    // {
    //     int temp = arr[0];
    //     arr[0] = arr[i];
    //     arr[i] = temp;
        
    //     heapify(arr, i, 0);
    // }
    
}

// To heapify a subtree rooted with node i which is
// an index in arr[]. n is size of heap
void heapify(int arr[], int n, int i)
{
    //Index for tracking largest element in sub heap
    int largest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;
    
    //If left child is greater, set  largest at that index
    if(left < n && arr[left] > arr[largest])
    {
        largest = left;
    }
    
    //If right child is greater
    if(right < n && arr[right] > arr[largest])
    {
        largest = right;
    }
    
    //If largest index is not the root (starting) index
    if(largest != i)
    {
        //Then swap the values at root and largest
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
        
        //After swapping, ensure that affected subtree is heapify'd again
        //Since heap is built in reverse order from end of array
        heapify(arr, n, largest);
    }
}