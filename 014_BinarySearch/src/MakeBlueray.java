import java.util.Scanner;

// 백준 온라인 저지 2343번 / 교재 186페이지

// 문제 : 강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다. 
//		 블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다. 
//		 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다. 
//		 즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.
//		 강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다. 
//		 오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다. 
//		 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다. 단, M개의 블루레이는 모두 같은 크기이어야 한다.
//		 강토의 각 강의의 길이가 분 단위(자연수)로 주어진다. 이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다. 
//		 다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다. 
//		 각 강의의 길이는 10,000분을 넘지 않는다.

// 출력 : 첫째 줄에 가능한 블루레이 크기중 최소를 출력한다.

public class MakeBlueray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if(start < A[i]) start = A[i];	// 레슨 시간의 최댓값을 시작 인덱스로 저장
			end = end + A[i];				// 모든 레슨 시간의 총합을 종료 인덱스로 저장
		}
		while(start <= end) {
			int middle = (start + end) / 2;
			int sum = 0;
			int count = 0;
			// 중앙값(middle)으로 모든 레슨을 저장할 수 있는 지 확인
			for (int i = 0; i < N; i++) {
				if(sum + A[i] > middle) {
					count++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			// 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요하므로
			if(sum != 0) count++;
			if(count > M) {		// 블루레이 개수가 초과한 경우
				// 시작 인덱스(블루레이 크기 시작 인덱스)를 늘림
				start = middle + 1;
			} else {
				// 종료 인덱스를 줄임
				end = middle - 1;
			}
		}
		System.out.println(start);
	}

}
