import java.util.Scanner;

public class P1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		long max = 0;
		long sum = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if(max < A[i]) max = A[i];
			sum += A[i];
		}
		
		System.out.println(sum * 100.0 / max / N);
	}

}
