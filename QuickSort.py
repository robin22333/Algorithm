def quickSort(arr, p, q):
    if p >= q:
        return;
    i = p;
    j = p + 1;
    x = arr[p];
    while j <= q:
        if arr[j] <= x:
            i += 1;
            swap(arr, i, j);
        j += 1;

    swap(arr, i, p);
    quickSort(arr, p, i-1);
    quickSort(arr, i+1, q);

def swap(arr, i, j):
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
quickSort(arr, 0, 9);
for c in arr:
    print c;
