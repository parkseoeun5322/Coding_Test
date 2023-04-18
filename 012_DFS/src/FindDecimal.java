import java.util.Scanner;

// 백준 온라인 저지 2023번 / 교재 153페이지

// 문제 : 수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 
//	     요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
//		 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 
//		 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 
//		 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다. 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. 
//		 N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.

// 입력 : 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

// 출력 : N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.

public class FindDecimal {
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	public static void DFS(int number, int jarisu) {
		if(jarisu == N) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for (int i = 1; i < 10 ; i++) {
			if(i % 2 == 0) {
				continue;
			}
			if(isPrime(number * 10 + i)) {
				DFS(number * 10 + i, jarisu + 1);
			}
		}
	}
	
	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if(number % i == 0) return false;
		}
		return true;
	}

}
