import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 온라인저지 2751번 / 교재 128페이지

// 문제 : N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 
//		 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.
//		 버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 
//		 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 
//		 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 
//		 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.

// 입력 : 첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 
//		 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 
//		 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다.

// 출력 : 첫째 줄에 Swap 횟수를 출력한다

public class BubbleSortProgram2 {
	public static int A[];
	public static int tmp[];
	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		tmp = new int[N];
		result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(0, N-1);
		System.out.println(result);
	}

	public static void merge_sort(int s, int e) {
		if(e - s < 1) return;
		int m = (s + e) / 2;
		merge_sort(s, m);
		merge_sort(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + (index2 - k);
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
