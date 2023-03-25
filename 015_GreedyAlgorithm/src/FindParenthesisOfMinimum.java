import java.util.Scanner;

// 백준 온라인 저지 1541번 / 교재 211 페이지

// 문제 : 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
//		 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
//		 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
//		 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 
//		 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

// 출력 : 첫째 줄에 정답을 출력한다.

public class FindParenthesisOfMinimum {
	static int answer = 0;		// 정답 변수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.nextLine();
		String[] str = example.split("-");
		for (int i = 0; i < str.length; i++) {
			int temp = mySum(str[i]);
			// 가장 앞 데이터일때는 더함 -> 앞에 -연산이 없는 첫번째 값이기 때문에
			if(i == 0) answer =  answer + temp;
			else answer = answer - temp;
		}
		System.out.println(answer);
	}
	
	private static int mySum(String string) {
		int sum = 0;
		// split 시 에러가 나는 이유는 + 문자열을 인식하지 못하기 때문이다. 
		// 이럴 때는 앞뒤에 각각 []를 붙이면 된다.
		String[] temp = string.split("[+]");
		for (int i = 0; i < temp.length; i++) {
			sum = sum + Integer.parseInt(temp[i]);
		}
		return sum;
	}

}
