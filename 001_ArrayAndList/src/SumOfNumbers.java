import java.util.Scanner;

// 백준 온라인 저지 11720번
// 문제 : N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.

// 입력 : 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
// 출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.

public class SumOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 자리수 입력받기
		
		// 입력 값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		// 숫자의 누적합을 저장할 변수
		int sum = 0;
		
		for(int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0';	//cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
		}
		
		System.out.println(sum);
	}

}
