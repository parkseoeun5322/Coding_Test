import java.util.Scanner;

// 백준 온라인 저지 1427번 / 교재 109번

//문제 : 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

// 입력 : 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

// 출력 : 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

public class SortInside {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int A[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i,i+1));
		}
		// 선택 정렬
		for (int i = 0; i < str.length(); i++) {
			int Max = i;	// 내림차순이므로 최댓값을 구함
			for (int j = i+1; j < str.length(); j++) {
				if(A[j] > A[Max]) {
					Max = j;
				}
			}
			// 최댓값이 나왔으면
			if(A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
		// 출력
		for (int i = 0; i < str.length(); i++) {
			System.out.print(A[i]);
			
		}
	}

}
