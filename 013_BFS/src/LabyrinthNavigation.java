import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 온라인 저지 2178번 / 교재 169페이지

// 문제 : N×M크기의 배열로 표현되는 미로가 있다.

//		1	0	1	1	1	1
//		1	0	1	0	1	0
//		1	0	1	0	1	1
//		1	1	1	0	1	1

//		미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
//		이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
//		한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//		위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

// 입력 : 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
//		 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

// 출력 : 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

public class LabyrinthNavigation {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	// 	0	1	0	-1
	//	1	0	-1	0
	//	↓
	//	x축으로 0만큼 y축으로 1만큼 이동하여 탐색한다는 뜻으로, 쉽게 말하면 아래쪽을 탐색
	//		↓
	//		x축으로 1만큼 y축으로 0만큼 이동하여 탐색한다는 뜻으로, 쉽게 말하면 오른쪽을 탐색
	//			↓
	//			x축으로 0만큼 y축으로 -1만큼 이동하여 탐색한다는 뜻으로, 쉽게 말하면 위쪽을 탐색
	//				↓
	//				x축으로 -1만큼 y축으로 0만큼 이동하여 탐색한다는 뜻으로, 쉽게 말하면 왼쪽을 탐색
	
	static boolean[][] visited;	//방문 기록 저장 배열(2차원 배열)
	static int[][] A;			//데이터를 저장할 2차원 행렬
	static int N,M;				//각각 row, column
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();	//ex)1011010101
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			// 4번을 반복하는 이유? → 상하좌우를 탐색하기 위해
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				// 유효한 좌표인지 판단 → 배열을 넘어서면 안됨(x가 왼쪽, y가 위쪽을 탐색 X, 그리고 N과 M을 넘어서면 X)
				if(x >= 0 && y >= 0 && x < N && y < M) {
					// 0이어서 갈 수 없거나 방문한 배열이 아니어야 함
					if(A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						// 직전의 노드의 depth + 1
						A[x][y] = A[now[0]][now[1]] + 1;
						queue.add(new int[] {x,y});
					}
				}
			}
		}
		
	}

}
