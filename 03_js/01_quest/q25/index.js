var r = Math.floor(Math.random() * 10) + 1

for (i= 1; i <= 10; i=i+1) {
    if (i==r) {
    continue;
    }    
    document.write(i);
}

