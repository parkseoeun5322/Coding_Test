import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 온라인 저지 12891번 / 교재 67페이지

// 문제 : 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. 
//		 DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 
//		 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 
//		 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
//		 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 
//		 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 
//		 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
//		 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 
//		 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 
//		 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 
//		 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
//		 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 
//		 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 
//		 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 
//		 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.


// 입력 : 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
//		 두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
//		 세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 
//		 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.

// 출력 : 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.

// 설명 : 부분 문자열 길이를 범위(Window)로 지정하고 해당 범위안에 있는 문자열의 조건이 충족하는지 검사한다.
//		 그 다음 범위를 한칸씩 이동할 때 제거될 문자열과 새로 추가될 문자열만 가지고 조건을 다시 검사하는 방식으로 진행한다.

public class DNAPassword {
	static int myArr[];			// 현재 상태 배열
	static int checkArr[];		// 비밀번호 조건 배열
	static int checkSercret;	// 요건 충족 갯수 -> 4개이면 비밀번호가 요건에 충족됨
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int result = 0;					// 요건에 충족한 비밀번호의 갯수
		checkArr = new int[4];
		myArr = new int[4];
		char A[] = new char[S];			// 현재 비밀번호 범위 배열
		checkSercret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			// 0이라는 의미는 해당 문자열은 없어도 상관없는 문자열이므로(이미 충족된 조건이므로) checkSercret에 1씩 더한다.
			if(checkArr[i] == 0) {
				checkSercret++;
			}
		}
		
		for (int i = 0; i < P; i++) {	// 부분 문자열 처음 받을 때 세팅
			Add(A[i]);
		}
		if(checkSercret == 4) result++;
		
		// 슬라이딩 윈도우 시작
		for (int i = P; i < S; i++) {
			int j = i - P;	// 여기서 j는 범위에서 맨 왼쪽 인덱스, i는 범위에서 맨 오른쪽 인덱스
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
