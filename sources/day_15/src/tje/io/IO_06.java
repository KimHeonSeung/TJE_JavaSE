package tje.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_06 {
	public static void main(String[] args) throws IOException {
		// �ڹ��� ����� Ŭ�������� �ٸ� ��Ʈ�� ��ü�� �������� �Ű�������
		// ���޹޾� �ش� ��Ʈ�� ��ü�� ����� �߰��� �� �ִ�.
		// ���ڷ��̼� ���� ( �⺻ ��ü�� �ٸ� Ŭ������ ����� �߰��Ͽ� ����ϴ� ���� )
		
		// Ű����κ��� �����͸� �о�� �� �ִ� InputStream ��ü��
		// ���ڸ� ���� �� �ֵ��� ������ ��, ���۸� ����Ͽ� �����͸�
		// �о�� �� �ֵ��� ��ȯ
		
		// 1. ����Ʈ ��Ʈ���� ���� ��Ʈ������ ��ȯ
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2. �Ϲ� ���� ��Ʈ���� ������ ����� �߰�
		// ���� : ���α׷��� ����� ������ ����Ű�� ���� ���Ǵ� �޸�
		// ���۸� ����Ͽ� READ/WRITE ������ ����ų �� �ִ�.
		BufferedReader br = new BufferedReader(isr);
		
		System.out.printf("�޼����� �Է��ϼ��� : ");
		String msg = br.readLine();
		
		System.out.printf("�Էµ� �޼����� %s �Դϴ�.", msg);
		
		// ��Ʈ���� �޸� ���� ������ �����ϱ� ���ؼ�
		// �ݵ�� close �޼ҵ带 ȣ���Ͽ� ���Ḧ �ؾ���
		// �ϳ��� ��Ʈ���� �������� ��Ʈ�� Ŭ������ ����Ǵ� ���
		// ���� �������� ������(���� �ٱ����� ��ü) ��ü�� close�մϴ�.
		// (���������� close�� �ǹǷ� ���� �ٱ����� �ݱ⸸ �ϸ� �ȴ�.)
		br.close();
		
	}
}
