import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 온라인 저지 11659번 / 교재 44페이지

// 문제 : 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.

// 입력 : 1번째 줄에 수의 개수 N (1 <= N <= 100,000), 합을 구해야하는 횟수 M (1 <= M <= 100,000),
//		 2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다.
//		 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.

// 출력 : 총 M개의 줄에 입력으로 주어진 i번째 수에서 j번재 수까지의 합을 출력한다.

// 설명 : 합배열과 구간합을 구하는 공식을 이용해서 풀어야 한다.
//		 합배열 공식  →  S[i] = S[i-1] + A[i]
//		 구간합 공식  →  S[j] - S[i-1]

public class PrefixSum_1 {

	public static void main(String[] args) throws IOException {
		// 입력받는 수가 100,000개까지 되므로 Scanner보다는 속도면에서 성능이 좋은 BufferedReader를 사용
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열의 크기가 100,000일 경우 한 줄에 많은 데이터가 들어오게 되므로 일일이 int형으로 받기가 어려울 때 사용
		// 이때 StringTokenizer는 토큰을 기준으로 값을 분리시켜줌
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int suNo = Integer.parseInt(stringTokenizer.nextToken());	// 수의 개수(배열의 크기)
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());	// 질의 개수
		
		long[] S = new long[suNo + 1];		// 합배열 선언
		
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= suNo; i++) {
			// 합배열 생성하기
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		
		for (int q = 0; q < quizNo; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			// 구간합 출력하기
			System.out.println(S[j] - S[i-1]);
		}	
	}

}
