import java.util.Scanner;

// 백준 온라인 저지 1929번 / 교재 217페이지

// 문제 : M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오. 

// 입력 : 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) 
//		M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

// 출력 : 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

public class FindPrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] A = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			A[i] = i;
		}
		
		// 1은 소수가 아니므로 2부터 시작
		for (int i = 2; i < Math.sqrt(N); i++) {
			// 소수가 아니면 넘어감 -> 소수가 아닌 경우에 값을 0으로 초기화해주기 때문에
			if(A[i] == 0) continue;
			// 소수의 배수 값을 N까지 반복
			for (int j = i+i; j <= N; j=j+i) {
				A[j] = 0;	//소수가 아니라는 것을 표시
			}
		}
		
		for (int i = M; i <= N; i++) {
			// 소수 값만 출력
			if(A[i] != 0) System.out.println(A[i]);
		}
	}

}
