arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
length = len(arr) - 1;
i = length;
while i >= 1:
    j = length - 1;
    while j >= length - i:
        if arr[j+1] < arr[j]:
            temp = arr[j+1];
            arr[j+1] = arr[j];
            arr[j] = temp;
        j -= 1;
    i -= 1;

for c in arr:
    print c;
