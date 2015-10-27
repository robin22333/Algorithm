def heapSort(arr, size):
    bulidHeap(arr, size);
    i = size;
    while i >= 0:
        swap(arr, 0, i);
        heapAdjust(arr, 0, i-1);
        i -= 1;

def bulidHeap(arr, size):
    #heapAdjust(arr, 0, size);
    i = size / 2;
    while i >= 0:
       heapAdjust(arr, i, size);
       i -= 1;

def heapAdjust(arr, i, size):
    leftChild = 2 * i + 1;
    rightChild = 2 * i + 2;
    maxval = i;
    if i <= size / 2:
        if leftChild <= size and arr[leftChild] > arr[maxval]:
            maxval = leftChild;
        if rightChild <= size and arr[rightChild] > arr[maxval]:
            maxval = rightChild;
        if maxval != i:
            swap(arr, i, maxval);
            heapAdjust(arr, maxval, size);

def swap(arr, i, j):
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
heapSort(arr, len(arr)-1);
print arr;
