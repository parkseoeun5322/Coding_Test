import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 온라인 저지 11004번 / 교재 121페이지

// 문제 : 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
//		 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

// 출력 : A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

public class KthNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N-1, K-1);
		/*
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " | ");
		}
		*/
		System.out.println(A[K-1]);
	}
	
	// 퀵소트 실행하는 함수
	public static void quickSort(int[] A, int S, int E, int K) {
		if(S < E) {
			int pivot = partition(A, S, E);
			if(pivot == K)
				return;
			else if(K < pivot) 
				quickSort(A, S, pivot - 1, K);
			else 
				quickSort(A, pivot + 1, E, K);
		}
	}
	
	// pivot 구하는 함수
	public static int partition(int[] A, int S, int E) {
		if(S + 1 == E) {
			if(A[S] > A[E]) swap(A, S, E);
			return E;
		}
		int M = (S + E) / 2;
		swap(A, S, M);			// 중앙값을 첫번째로 swap
		int pivot = A[S];		// swap한 첫번째 값을 pivot으로 저장
		int i = S + 1, j = E;	// 첫번째 값을 제외한 나머지 범위 설정
		while(i <= j) {
			while(pivot < A[j] && j > 0) {
				//.out.print("1. pivot ("+pivot+") < A[j] ("+A[j] + ")");
				j--;
				//System.out.println(" → j = " + j);
			}
			
			while(pivot > A[i] && i < A.length-1) {
				//System.out.print("2. pivot ("+pivot+") > A[i] ("+A[i] + ")");
				i++;
				//System.out.println(" → i = " + i);
			}
			if(i <= j) {
				// 후위 연산자 주의! swap이 이뤄진 후에 연산된다.
				swap(A, i++, j--);
				//System.out.println("3. i = " + i + " / j = " + j);
			}
		}
		//System.out.println("4. A[S] = " + A[S] + " / A[j] = " + A[j] + " / pivot = " + pivot);
		A[S] = A[j];
		A[j] = pivot;
		//System.out.println("5. A[S] = " + A[S] + " / A[j] = " + A[j] + " / pivot = " + pivot);
		//System.out.println("================= partition 끝");
		return j;
	}
	
	// swap 함수
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		//System.out.println("swap =>  A["+i+"] = " + A[i] + " / A["+j+"] = " + A[j]);
	}

}
