package tje.util;

public class String_03 {

	public static void main(String[] args) {
		// StringBuffer / StringBuilder Ŭ����
		// String Ŭ������ �ٸ��� ���ڿ��� �����Ͽ�
		// ������ �� �ִ� Ŭ����

		// StringBuffer / StringBuilder Ŭ������ ������
		// ��Ƽ������ ȯ�濡�� ���� ������ �������� ������ �� �ִ� StringBuffer Ŭ����,
		// ��Ƽ������ ȯ���� �������� �ʴ� StringBuilder Ŭ���� (������ ����ȭ�� ���� ����)

		// �⺻ ������ ����Ͽ� 16 ���ڸ� ������ �� �ִ� ��ü�� ����
		StringBuffer buffer = new StringBuffer();
		StringBuilder builder = new StringBuilder();

		// StringBuffer / StringBuilder Ŭ������ capacity �޼ҵ�
		// ���ڿ��� �ִ� ������ �� �ִ� ũ�Ⱚ�� ��ȯ (�⺻ ���� 16)
		// capacity�� �������� �þ �� �ִ�.
		// (16���� �̻��� �߰��Ǹ� capacity�� Ȯ���� ���ο� ������ �Ҵ�)
		// capacity�� �������� �Ű������� ���� ������ �� �ִ�.
		// new StringBuffer(), new StringBuilder()
		System.out.printf("buffer ��ü�� ��뷮 : %d\n", buffer.capacity());
		System.out.printf("builder ��ü�� ��뷮 : %d\n", builder.capacity());

		// ���ڿ��� �߰��� �� �ִ� append �޼ҵ�
		// (���� ������ ��ġ�� ���ڿ��� �߰�)
		buffer.append("First, ");
		builder.append("First, ");

		System.out.printf("buffer.capacity() : %d, buffer.length : %d\n", buffer.capacity(), buffer.length());
		System.out.printf("builder.capacity() : %d, builder.length : %d\n", builder.capacity(), builder.length());

		buffer.append("Second, ");
		builder.append("Second, ");

		System.out.printf("buffer.capacity() : %d, buffer.length : %d\n", buffer.capacity(), buffer.length());
		System.out.printf("builder.capacity() : %d, builder.length : %d\n", builder.capacity(), builder.length());

		// capacity�� ũ�⸦ ��� ���ڿ��� �߰��ǹǷ�
		// capacity�� Ȯ��� �������� �̵��ϰ� �ȴ�.
		buffer.append("Third, ");
		builder.append("Third, ");

		System.out.printf("buffer.capacity() : %d, buffer.length : %d\n", buffer.capacity(), buffer.length());
		System.out.printf("builder.capacity() : %d, builder.length : %d\n", builder.capacity(), builder.length());

		System.out.println(buffer);
		System.out.println(builder);

		buffer.insert(0, "Zero, ");
		builder.insert(0, "Zero, ");

		System.out.println(buffer);
		System.out.println(builder);

		System.out.printf("Hello's index : %d\n", buffer.indexOf("Hello"));
		System.out.printf("Hello's index : %d\n", buffer.indexOf("Third"));

		System.out.println(buffer);
		System.out.println(builder);

		
		// String Ŭ������ ��ȯ ��, replaceAll �޼ҵ带 ����ϴ� ���
		System.out.println(buffer.toString().replaceAll(", ", "-"));
		
		int search = -1;
		while( (search = builder.indexOf(", ")) != -1 ) {
			// ", "�� ����
			builder.delete(search, search + ", ".length());
			// "-"�� �߰�
			builder.insert(search, "-");
		}
		System.out.println(builder);
		
		// ���� ����� ���ڼ��� capacity�� ���� ����
		buffer.trimToSize();
		builder.trimToSize();
		
		System.out.printf("buffer.capacity() : %d, buffer.length : %d\n", buffer.capacity(), buffer.length());
		System.out.printf("builder.capacity() : %d, builder.length : %d\n", builder.capacity(), builder.length());
		
		
//		���� ���
//		do {
//			buffer.insert(buffer.indexOf(" "), "-");
//			buffer.deleteCharAt(buffer.indexOf(","));
//			buffer.deleteCharAt(buffer.indexOf(" "));
//		} while (buffer.indexOf(" ") != -1 && buffer.indexOf(",") != -1);
		
//		// String Ŭ������ ��ȯ ��, replaceAll �޼ҵ带 ����ϴ� ���
//		System.out.println(buffer.toString().replaceAll(", ", "-"));

//		do {
//			builder.insert(builder.indexOf(" "), "-");
//			builder.deleteCharAt(builder.indexOf(","));
//			builder.deleteCharAt(builder.indexOf(" "));
//		} while (builder.indexOf(" ") != -1 && builder.indexOf(",") != -1);
//
//		System.out.println(buffer);
//		System.out.println(builder);
	}

}
