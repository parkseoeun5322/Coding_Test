import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 온라인 저지 11003번 / 교재 74페이지

// 문제 : N개의 수 A1, A2, ..., AN과 L이 주어진다.
//		 Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 
//		 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

// 입력 : 첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
//		 둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)

// 출력 : 첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.

public class FindMinimum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 출력을 버퍼에 넣고 한 번에 출력하기 위해 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<Node> mydeque = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			// 새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(i, now));
			// 범위에 벗어난 값은 제거
			if(mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {
		public int index;
		public int value;
		
		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}
