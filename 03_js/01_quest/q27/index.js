// a>b c<d e=100 f=/=100    

window.onload = function () {
    var a = 2;
    var b = 1;
    var c = 3;
    var d = 4;
    var e = 100;
    var f = 100;
        if (
            (a > b && c < d)||(e==100 && f!=100)//true||false로 수렴되어 조건문이 충족됨
            )
        {
            document.write("고양이");
        }
}
