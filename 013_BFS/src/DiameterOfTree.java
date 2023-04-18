import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 온라인 저지 1167번 / 교재 174페이지

// 문제 : 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 
//		 트리의 지름을 구하는 프로그램을 작성하시오.

// 입력 : 트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)
//		 둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.
//		 먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 
//		 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 
//		 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

// 출력 : 첫째 줄에 트리의 지름을 출력한다.

public class DiameterOfTree {
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			while(true) {
				int E = sc.nextInt();
				if(E == -1) break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(1);
		int Max = 1;
		// distance 배열에서 가장 큰 값으로 다시 시작점 설정
		for (int i = 2; i <= N; i++) {
			if(distance[Max] < distance[i]) {
				Max = i;
			}
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		BFS(Max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}

	public static void BFS(int index) {
		System.out.println("--------------------------");
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.println("now : " + now);
			for (Edge i : A[now]) {
				int e = i.e;
				int v = i.value;
				System.out.println("e : " + e + " / v : " + v);
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
					// 거리 배열 업데이트 하기
					System.out.println("distance["+e+"] = " + distance[now] + " + " + v);
					distance[e] = distance[now] + v;
				}
			}
		}
	}

}

class Edge {
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
