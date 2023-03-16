import java.util.Scanner;

// 백준 온라인 저지 2750번 / 교재 101페이지

// 문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
//		 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
//		 수는 중복되지 않는다.

// 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

public class AscendingSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		// 버블 정렬을 구현하는 영역
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-1-i; j++) {
				if(A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
				
			}
			
		}
		
		// 정렬된 배열 출력
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

}
