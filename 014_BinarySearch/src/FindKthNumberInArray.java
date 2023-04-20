import java.util.Scanner;

// 백준 온라인 저지 1300번 / 교재 190페이지

// 문제 : 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 
//		 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
//		 배열 A와 B의 인덱스는 1부터 시작한다.

// 입력 : 첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 
//		 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

// 출력 : B[k]를 출력한다.

public class FindKthNumberInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		// N의 배수로 구성되어 있으므로 K번째 수는 K를 넘지 않음
		long start = 1, end = K;
		long result = 0;
		while (start <= end) {
			long middle = (start + end) / 2;
			long cnt = 0;
			// 중앙값보다 작은 수는 몇 개인지 계산하기
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N);
			}
			if(cnt < K) {
				start = middle + 1;
			} else {
				result = middle;
				end = middle - 1;
			}
		}
		System.out.println(result);
	}

}
