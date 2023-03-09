import java.util.Scanner;

// 백준 온라인 저지 2018번 / 교재 56페이지

// 문제 : 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 
//		 당신은 어떤 자연수 N(1 <= N 10,000,000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
//		 이때 사용하는 자연수는 N이어야 한다. 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5이다.
//		 반면, 10을 나타내는 방법은 10, 1+2+3+4이다. 
//		 N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.

// 입력 : 1번째 줄에 정수 N이 주어진다.

// 출력 : 입력된 자연수 N을 연속된 자연수의 합으로 나타내는 가짓수를 출력한다.

// 설명 : sum(=1)  < 15 : end_index를 +1하고 이 end_index(=2)를 sum에 더함
// 		 sum(=3)  < 15 : end_index를 +1하고 이 end_index(=3)를 sum에 더함
// 		 sum(=6)  < 15 : end_index를 +1하고 이 end_index(=4)를 sum에 더함
// 		 sum(=10) < 15 : end_index를 +1하고 이 end_index(=5)를 sum에 더함
// 		 sum(=15) = 15 : count에 +1, end_index를 +1하고 이 end_index(=6)를 sum에 더함
// 		 sum(=21) > 15 : sum을 start_index(=1)만큼 빼고 start_index를 +1함(=2)
// 		 sum(=20) > 15 : sum을 start_index(=2)만큼 빼고 start_index를 +1함(=3)
// 		 sum(=18) > 15 : sum을 start_index(=3)만큼 빼고 start_index를 +1함(=4)
// 		 sum(=15) = 15 : count에 +1, end_index를 +1하고 이 end_index(=7)를 sum에 더함
// 		 sum(=22) > 15 : sum을 start_index(=4)만큼 빼고 start_index를 +1함(=5)
// 		 sum(=18) > 15 : sum을 start_index(=5)만큼 빼고 start_index를 +1함(=6)
// 		 sum(=13) < 15 : end_index를 +1하고 이 end_index(=8)를 sum에 더함
// 		 sum(=21) > 15 : sum을 start_index(=6)만큼 빼고 start_index를 +1함(=7)
// 		 sum(=15) = 15 : count에 +1, end_index를 +1하고 이 end_index(=9)를 sum에 더함
// 		 ...

public class SumOfNaturalNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		
		while(end_index != N) {
			if(sum == N) {
				count++;
				end_index++;
				sum = sum + end_index;
			} else if(sum > N) {
				sum = sum - start_index;
				start_index++;
			} else {
				end_index++;
				sum = sum + end_index;
			}
		}
		System.out.println(count);
	}

}
