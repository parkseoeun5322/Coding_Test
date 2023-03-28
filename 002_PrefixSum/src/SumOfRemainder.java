import java.util.Scanner;

// 백준 온라인 저지 10986번 / 교재 52페이지

// 문제 : 수 N개 A1, A2, ..., AN이 주어진다. 
//		 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
//		 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

// 입력 : 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 10의 6승, 2 ≤ M ≤ 10의 3승)
//		 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 10의 9승)

// 설명 : 1. (A+B) % C은 ((A % C) + (B % C)) % C와 같음
//		 2. S[i] - S[j]는 원본 배열의 j + 1부터 i까지의 구간 합
//		 3. S[i] % M의 값과 S[j] % M의 값이 같다면 (S[i] - S[j]) % M의 값은 0이다.
//			구간 합 배열의 원소를 M으로 나눈 나머지로 업데이트하고 S[i]와 S[j]가 같은 (i,j)쌍을 찾으면
//			j + 1부터 i까지의 구간 합이 M으로 나누어 떨어진다는 것을 알 수 있다.

public class SumOfRemainder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] S = new long[N+1];	// 합배열
		long[] C = new long[M];		// 같은 나머지의 인덱스를 카운트하는 배열
		long answer = 0;
		for (int i = 1; i <= N; i++) {
			S[i] = S[i-1] + sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int remainder = (int) S[i] % M;
			// 나머지가 0이라는 것은 1부터 i까지의 구간합이 M에 나누어 떨어진다는 의미
			if(remainder == 0) answer++;
			C[remainder]++;
		}
		
		for (int i = 0; i < M; i++) {
			if(C[i] > 1) {
				// 나머지가 같은 인덱스 중 총 2개를 뽑는 경의의 수를 더하기
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}

}
