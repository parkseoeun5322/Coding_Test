import java.util.Scanner;

public class P015_1541 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String example = sc.nextLine();
		 String[] str = example.split("-");
		 int result = 0;
		 for (int i = 0; i < str.length; i++) {
			 int temp = mySum(str[i]);
			 if(i == 0) result = result + temp;
			 else result = result - temp;
		 }
		 System.out.println(result);
	}

	public static int mySum(String a) {
		int sum = 0;
		String[] temp = a.split("[+]");
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
