import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준 온라인 저지 10989번 / 교재 139페이지

// 문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

// 출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

public class AscendingSort3 {
	public static int A[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		// 10,000보다 작거나 같은 자연수가 오기 때문에 최대 자릿수 5를 두번째 인자에 넣음
		Radix_Sort(A, 5);
		// 출력
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void Radix_Sort(int[] A, int max_size) {
		int[] output = new int[A.length];
		int jarisu = 1;
		int count = 0;
		while (count != max_size) {
			int[] bucket = new int[10];
			// 일의 자리부터 시작
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++;	
			}
			// 합배열을 이용해 index 계산하기
//			System.out.println("합배열을 이용해 index 계산하기");
//			System.out.print("bucket[] =>  ");
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
//				if(i == 1) System.out.print(bucket[0] + " | ");
//				System.out.print(bucket[i] + " | ");
			}
//			System.out.println();
//			System.out.println("현재 자릿수를 기준으로 정렬하기");
//			System.out.print("output[] =>  ");
			for (int i = A.length - 1; i >= 0; i--) {
				output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
//				System.out.print("A[i] = " + A[i] + " / ");
//				System.out.println("bucket["+(A[i] / jarisu % 10)+"] - 1 = " + (bucket[(A[i] / jarisu % 10)] - 1));
				bucket[(A[i] / jarisu % 10)]--;
			}
//			
//			System.out.println("다음 자릿수를 이용하기 위해 현재 자릿수 기준 정렬 데이터 저장하기");
//			System.out.print("A[] =>  ");
			for (int i = 0; i < A.length; i++) {
				A[i] = output[i];
//				System.out.print(A[i] + " | ");
			}
			jarisu = jarisu * 10;
			count++;
//			System.out.println();
//			System.out.println("count = " + count);
//			System.out.println("======================================== 끝");
		}
	}

}
