import java.util.Arrays;
import java.util.Scanner;

// 백준 온라인 저지 1920번 / 교재 182페이지

// 문제 : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
//		 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
//		 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
//		 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
//		 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

// 출력 : M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

public class FindSpecificInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);		// 오름차순 정렬
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			boolean find = false;	//찾았는 지의 여부 저장
			int target = sc.nextInt();
			// 이진탐색 시작
			int start = 0;
			int end = A.length - 1;
			while (start <= end) {	// 탐색할 부분이 없을 때까지 반복
				int mid_index = (start + end) / 2;	//중앙값의 인덱스
				int mid_value = A[mid_index];		//중앙값
				if(mid_value > target) {
					end = mid_index - 1;
				} else if (mid_value < target) {
					start = mid_index + 1;
				} else {
					// 타겟과 중앙값이 같을 경우 = 찾은 경우
					find = true;
					break;
				}
			}
			if(find) System.out.println(1);
			else System.out.println(0);
		}
		
	}

}
