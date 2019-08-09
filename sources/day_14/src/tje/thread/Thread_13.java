package tje.thread;

// ����ȭ
// �ټ����� �����带 Ȱ���Ͽ� ���α׷����� ó���ϴ� ���
// �ذ��ؾ߸� �ϴ� ����(��Ƽ ������ ȯ��)
// �ѹ��� �ϳ����� ó��

// �ټ����� �����尡 �ϳ��� �����ڿ��� ����ϴ� ��� �߻��ϴ� ����.

// ĥ�� Ŭ����
class WhiteBoardWithSync {
	private int total;

	public WhiteBoardWithSync(int total) {
		this.total = total;
	}

	// ����ȭ�� �����ϰ� �ִ� �޼ҵ� ����
	// �޼ҵ��� ����ο� synchronized Ű���� �����ϸ�
	// �ش� �޼ҵ�� �ϳ��� ������ ��ü�� �����Ͽ� ����� �� �ִ�.
	public synchronized void update() {
		this.total++;
	}

	@Override
	public String toString() {
		return String.format("total = %d", this.total);
	}
}

class StudentWithSync extends Thread {
	private WhiteBoardWithSync board;

	public StudentWithSync(String name, WhiteBoardWithSync board) {
		super(name);
		this.board = board;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			this.board.update();
		}
	}
}

public class Thread_13 {
	public static void main(String[] args) {
		// ����ȭ�� �����ϴ� �����ڿ� ��ü ����
		// �ټ����� �л����� �����ϴ� ĥ���� ����
		WhiteBoardWithSync board = new WhiteBoardWithSync(1);

		// �ϳ��� ĥ���� �����ϰ� �ִ� ������ ��ü
		StudentWithSync s1 = new StudentWithSync("S1", board);
		StudentWithSync s2 = new StudentWithSync("S2", board);
		StudentWithSync s3 = new StudentWithSync("S3", board);
		s1.start();
		s2.start();
		s3.start();
		try {
			s1.join();
			s2.join();
			s3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(board);
		System.out.println("���α׷� ����");

	}
}
