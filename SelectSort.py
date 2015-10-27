a = [1, 4, 5, 7, 9, 10, 2, 3, 6, 8];
i = 0;
while i < 10:
    k = i;
    j = i+1;    
    while j < 10:
        if (a[j] < a[k]):
            k = j;
        j += 1;
    if k != i:
        b = a[i];
        a[i] = a[k];
        a[k] = b;
    i += 1;

for c in a:
    print c
