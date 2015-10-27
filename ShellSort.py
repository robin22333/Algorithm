def shellSort(arr, d):
    d = d / 2;
    while d >= 1:
        i = d;
        length = len(arr);
        while i < length:
            insertval = arr[i];
            index = i - d;
            while index >= 0 and insertval < arr[index]:
                arr[index + d] = arr[index];
                index -= d;
            arr[index + d] = insertval;
            i += 1;
        d = d / 2;

arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
shellSort(arr, len(arr));
print arr;
