def mergeSort(arr):
    if len(arr) == 1:
        return arr;
    mid = len(arr)/2;
    arr1 = arr[:mid];
    arr2 = arr[mid:];

    return merge(mergeSort(arr1), mergeSort(arr2));

def merge(arr1, arr2):
    index1 = 0;
    index2 = 0;
    outindex = 0;
    outarr = [];
    outlen = len(arr1) + len(arr2);
    while outindex < outlen:
        if index1 == len(arr1):
            outarr += [arr2[index2]];
            index2 += 1;
        elif index2 == len(arr2):
            outarr += [arr1[index1]];
            index1 += 1;
        elif arr1[index1] < arr2[index2]:
            outarr += [arr1[index1]];
            index1 += 1;
        elif arr2[index2] < arr1[index1]:
            outarr += [arr2[index2]];
            index2 += 1;
        outindex += 1;
    return outarr;

arr = [1, 3, 4, 6, 9, 8, 2, 7, 5, 10];
outarr = mergeSort(arr);
print outarr;
raw_input("lalala:");

