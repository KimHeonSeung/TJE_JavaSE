// ������, �ӽŷ���

package tje.io;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class IO_13_Ex {

	public static void main(String[] args) throws IOException {
		// Java JDK�� ��ġ�� ���丮 ������
		// THIRDPARTYLICENSEREADME.txt ������ �о����.
		// ���� ���ο� ������ �������� ���� �� �ܾ��� ī��Ʈ�� ����ϰ� ���
		// StringTokenizer Ŭ������ ����Ͽ� ���ڿ��� ������ �������� ����
		// HashMap Ŭ������ ����Ͽ� �� �ܾ ī���� ���.
		
		String dirPath = "C:\\Program Files\\Java\\jdk1.8.0_202";
		File dir = new File(dirPath);
		
		
		String fileName = "THIRDPARTYLICENSEREADME.txt";
		File file = new File(dir, fileName);
		
		// ������ �о���� ���� ���� ��Ʈ�� ��ü ����
		// ���ڽ�Ʈ������ ���� ��� ���� ��ǲ��Ʈ������ �ٲ� �ʿ䰡 ����.
		BufferedReader in =
				new BufferedReader(
						new FileReader(file));
		
		HashMap<String, Integer> counter = new HashMap<>();
		
		
		String input;

		while( (input = in.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(input, " /`-;??<>,.=()\"'");
			
			while( st.hasMoreTokens() ) {
				String word = st.nextToken();
				// ��� �����ڸ� �ҹ��ڷ� ����
				word = word.toLowerCase();
				
				int count = 1;
				
				if( counter.containsKey(word) )
					count = counter.get(word) + 1 ;
				
				counter.put(word, count);
			}
			
		}
			
		
		in.close();
		
		for( String key : counter.keySet() )
			System.out.printf("%s : %d\n", key, counter.get(key));

		

	}

}
