import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P004_12891 {
	static int myArr[];
	static int checkArr[];
	static int checkSercret;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;
		checkArr = new int[4];
		myArr = new int[4];
		char A[] = new char[S];
		checkSercret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0) {
				checkSercret++;
			}
		}
		
		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}
		if(checkSercret == 4) result++;
		
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if(checkSercret == 4) result++;
		}
		System.out.println(result);
		br.close();
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0] == checkArr[0]) checkSercret--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) checkSercret--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) checkSercret--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) checkSercret--;
			myArr[3]--;
			break;
		}		
	}

	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) checkSercret++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) checkSercret++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) checkSercret++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) checkSercret++;
			break;
		}
	}

}
