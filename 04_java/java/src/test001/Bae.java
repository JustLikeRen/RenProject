package test001;

public class Bae {
	public static void main(String[] args) {
		int n[] = new int[2];
		System.out.println(n[1]);
		
		n[0]=1;
		n[1]=2;
		
		System.out.print(n[0]);
		System.out.println(n[1]);

		String s[] = new String[2];
		System.out.println(s[1]);
		s[0]="개";
		s[1]="괭이";
		System.out.print(s[0]);
		System.out.println(s[1]);

		//배열 선언 법 - 2.바로 값도 주는 선언(방식1)
		int m[] = new int[] {1,2};

		System.out.print(m[0]);
		System.out.println(m[1]);

		//배열 선언 법 - 3.바로 값도 주는 선언(방식2)
		int x[] = {1,2};

		System.out.print(x[0]);
		System.out.print(x[1]);
	}
}
