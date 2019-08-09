package tje.util;


// ���ڿ��� ������ �� �ִ� ����� �����ϴ� Ŭ����
import java.util.StringTokenizer;

public class StringTokenizer_02 {

	public static void main(String[] args) {
		// ; �� �������� ������ ����� ���ڿ� ����
		String subjects = "KOR;ENG;MATH";
		String scores = "100,97#95";

		// StringTokenizer Ŭ������ ����Ͽ� ���� ���ڿ� ������ �Ľ��� ��,
		// �Ʒ��� ���� ����ϼ���
		// KOR  : 100 ��
		// ENG  :  90 ��
		// MATH :  95 ��
		// tot  : 285 ��
		// avg  : 95.00 ��
		
		String [] subject_list ;
		int [] score_list;
		
		
		
		
//		int a;
//		int tot = 0;
//		double avg;
		
		
		StringTokenizer st2 = new StringTokenizer(scores, ",#");
		StringTokenizer st1 = new StringTokenizer(subjects, ";");
		
		subject_list = new String[st1.countTokens()];
		score_list = new int [st2.countTokens()];
		
		int index = 0;
		int tot = 0;
		
		while( st1.hasMoreTokens() ) {
			subject_list[index] = st1.nextToken();
			score_list[index] = Integer.parseInt(st2.nextToken());
			tot += score_list[index];
			
			System.out.printf("%5s : %3d\n", subject_list[index], score_list[index]);
		}
		double avg = (double)tot / score_list.length;
		
		System.out.printf("%5s : %d ��\n","TOT", tot);
		System.out.printf("%5s : %.2f ��\n","AVG", avg);
		
		
		
		
		
//		while ( stSubjects.hasMoreTokens() ) {
//			System.out.printf("%5s : %6s ��\n", stSubjects.nextToken(), stScores.nextToken());
//			a = Integer.parseInt(stScores.nextToken());
//			tot += a;
//					
//		}
//		avg = (double)tot/3;
//		
//		System.out.printf("���� : %d\n ��� : %.2f", tot, avg);
	}

}
