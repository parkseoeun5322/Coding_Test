import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준 온라인 저지 11286번 / 교재 94페이지

// 문제 : 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
//		 1. 배열에 정수 x (x ≠ 0)를 넣는다.
//		 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
//		 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
//		 프로그램은 처음에 비어있는 배열에서 시작하게 된다.

// 입력 : 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 
//		 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
//		 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
//		 x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
//		 입력되는 정수는 -231보다 크고, 231보다 작다.

// 출력 : 입력에서 0이 주어진 회수만큼 답을 출력한다. 
//		 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

// 설명 : 절댓값과 관련된 정렬이 필요하므로 우선순위 큐를 사용해야한다.(단, 정렬 기준은 커스터마이징해야함)
//		 정수 x가 0일 때  →  큐가 비어있을 때는 0 출력, 비어있지 않을 때는 절댓값이 최소인 값을 출력(절댓값이 같은 경우에는 음수 출력)
//		 정수가 x가 0이 아닐 때  →  새로운 값을 추가하고 절대값이 최소인 기준으로 정렬한다.
public class AbsoluteHeap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 정렬 기준을 만들기 위해 비교 객체 o1, o2를 선언
		// o1을 우선순위를 주고 싶다면 음수 반환, o2를 우선순위를 주고 싶다면 양수 반환
		PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>((o1,o2)-> {
			// Math.abs() → 절댓값을 반환해주는 함수
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			// 절댓값이 같은 경우 음수를 우선
			if(first_abs == second_abs) {
				return o1 > o2 ? 1 : -1;
			}
			// 절댓값 작은 데이터 우선
			return first_abs - second_abs;
		});
		
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(myQueue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(myQueue.poll());
				}
			} else {
				myQueue.add(request);
			}
		}

	}

}
