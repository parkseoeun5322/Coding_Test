import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 온라인 저지 11724번 / 교재 148페이지 

// 문제 : 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
//		 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

// 출력 : 첫째 줄에 연결 요소의 개수를 출력한다.

public class NumberOfConnectedComponent {
	static ArrayList<Integer>[] A;		//그래프 데이터 저장 인접 리스트
	static boolean visited[];			//방문 기록 저장 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//노드 개수
		int m = Integer.parseInt(st.nextToken());	//에지 개수
		visited = new boolean[n+1];					//0번 인덱스를 사용하지 않으려고 n+1만큼 초기화
		A = new ArrayList[n+1];
		for (int i = 1; i < n+1; i++) {
			A[i] = new ArrayList<Integer>();		//인접 리스트 초기화
		}
		//에지 수에 따라 인접 리스트를 할당
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());	//시작점
			int e = Integer.parseInt(st.nextToken());	//마지막점
			//양방향으로 설정
			A[s].add(e);
			A[e].add(s);	
		}
		int count = 0;	//연결 요소의 개수
		for (int i = 1; i < n+1; i++) {
			//방문하지 않은 노드라면
			if(!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	
	private static void DFS(int v) {
		//현재 노드가 이미 방문한 노드라면
		if(visited[v]) {
			return;
		}
		visited[v] = true;		//방문 기록
		for (int i : A[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}

}
