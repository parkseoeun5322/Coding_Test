import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 온라인 저지 1260번 / 교재 164페이지

// 문제 : 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
//		 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
//		 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력 : 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//		 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
//		 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 출력 : 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
//		 V부터 방문된 점을 순서대로 출력하면 된다.

public class DFSAndBFS {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Start = sc.nextInt();
		// 정점의 개수(N)이 1부터 시작하므로
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i]);
		}
		visited = new boolean[N + 1];
		DFS(Start);
		System.out.println();
		visited = new boolean[N + 1];
		BFS(Start);
		System.out.println();
	}
	
	public static void DFS(int Node) {
		System.out.print(Node + " ");
		visited[Node] = true;
		for (int i : A[Node]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}
	public static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int i : A[now]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
