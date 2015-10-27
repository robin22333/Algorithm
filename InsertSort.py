def insertSort(arr):
    i = 1;
    length = len(arr);
    while i < length:
        insertval = arr[i];
        index = i-1;
        while index >=0 and insertval < arr[index]:
            arr[index + 1] = arr[index];
            index -= 1;
        arr[index + 1] = insertval;
        i += 1;

arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
insertSort(arr);
print arr;
