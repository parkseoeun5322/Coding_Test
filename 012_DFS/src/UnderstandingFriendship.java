import java.util.ArrayList;
import java.util.Scanner;

// 백준 온라인 저지 13023번 / 교재 157페이지

// 문제 : BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
//		 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
//			A는 B와 친구다.
//			B는 C와 친구다.
//			C는 D와 친구다.
//			D는 E와 친구다.
//		 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//		 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 
//		 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

// 출력 : 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.

public class UnderstandingFriendship {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arrive = false;
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i = 0; i < N; i++) {
//			System.out.println("================================== 시작!");
			DFS(i, 1);
			if(arrive) break;
		}
		// 5의 깊이가 있다면 1 출력, 없다면 0 출력
		if(arrive) System.out.println("1");
		else System.out.println("0");
	}

	public static void DFS(int now, int depth) {
//		System.out.println("------------------------------------");
//		System.out.println("now : " + now + " / depth : " + depth);
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		visited[now] = true;
//		System.out.println("1.visited["+now+"] : " + visited[now]);
		for (int i : A[now]) {
//			System.out.println("i : " + i + "(now : " + now + ")");
			if(!visited[i]) {
				DFS(i, depth+1);
			}
		}
		visited[now] = false;
//		System.out.println("2.visited["+now+"] : " + visited[now]);
	}
}
