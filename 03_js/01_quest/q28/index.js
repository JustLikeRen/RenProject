var r = Math.floor(Math.random() * 10) + 1

// for (i= 1; i <= 10; i=i+1) {
//     document.write(i);
//     if (i==r) {
//     break;        
//     }    
// }

if (r % 2 == 1) {
    document.write("홀수입니다");
} else {
    document.write("짝수입니다");
}