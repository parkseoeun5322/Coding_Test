import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 온라인 저지 17298번 / 교재 86페이지

// 문제 : 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 
//		 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
//		 Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 
//		 그러한 수가 없는 경우에 오큰수는 -1이다.
//		 예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. 
//		 A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

// 입력 : 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
//		 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

// 출력 : 총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.

public class Okunsoo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];	// 수열 배열 생성
		int[] ans = new int[N];	// 정답 배열 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		// 처음에는 항상 스택이 비어있으므로 최초 값을 push해 초기화
		stack.push(0);
		
		for (int i = 1; i < N; i++) {
			// 스택이 비어있지 않고, 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				// 정답 배열에 오큰수를 현재 수열로 저장하기
				ans[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		// 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌때까지
		while(!stack.empty()) {
			// 스택에 남아있는 index에 -1 저장
			ans[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}

}
