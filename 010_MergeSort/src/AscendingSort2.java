import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 온라인 2751번 / 교재 128페이지

// 문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 
//		 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

// 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

public class AscendingSort2 {
	public static int[] A;
	public static int[] tmp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		merge_sort("A", 0, N-1);
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void merge_sort(String str, int s, int e) {
		if(e - s < 1) return;
		int m = (s + e) / 2;
//		System.out.println("===================================== " + str + ". s = " + s + " / m = " + m + " / e = " + e);
		merge_sort("B", s , m);
		merge_sort("C", m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
//				System.out.print("1. index1("+index1+") <= m("+m+") && index2("+index2+") <= e("+e+") / "+tmp[index1]+" > "+tmp[index2]+"  ->  k = "+k+", A[k] = " + A[k]);
				k++;
				index2++;
//				System.out.println("  결과 ==>  k = " + k + ", index2 = " + index2);
			} else {
				A[k] = tmp[index1];
//				System.out.print("2. index1("+index1+") <= m("+m+") && index2("+index2+") <= e("+e+") / "+tmp[index1]+" <= "+tmp[index2]+"  ->  k = "+k+", A[k] = " + A[k]);
				k++;
				index1++;
//				System.out.println(" ||  결과 ==>  k = " + k + ", index1 = " + index1);
			}
		}
		while(index1 <= m) {
			A[k] = tmp[index1];
//			System.out.print("3. index1("+index1+") <= m("+m+")  ->  k = "+k+", A[k] = " + A[k]);
			k++;
			index1++;			
//			System.out.println(" ||  결과 ==>  k = " + k + ", index1 = " + index1);
		}
		while(index2 <= e) {
//			System.out.print("4. index2("+index2+") <= e("+e+")  ->  k = "+k+", A[k] = " + A[k]);
			A[k] = tmp[index2];
			k++;
			index2++;			
//			System.out.println(" ||  결과 ==>  k = " + k + ", index2 = " + index2);
		}
//		for (int i = 0; i < A.length; i++) {
//			System.out.print(A[i] + " | ");
//		}
//		System.out.println();
	}
}
