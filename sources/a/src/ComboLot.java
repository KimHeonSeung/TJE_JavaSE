import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ComboLot extends JFrame {
	Container contentPane;
	JPanel selPane = new JPanel();
	JPanel upperselPane1 = new JPanel();
	JPanel upperselPane2 = new JPanel();
	JPanel upperselPane3 = new JPanel();

	JTextArea result = new JTextArea();

	JComboBox numbersCombo;
	JComboBox countCombo;
	JComboBox maxCombo;

	ArrayList<int[]> arrLot = new ArrayList<int[]>();

	// ����
	String num;
	int selNum;

	// �� ����
	String count;
	int coNum;

	// ����
	String range;
	int rangeNum;

	// String [] number = {"1","2","3","4","5","6","7","8","9","10"};

	String[] numbers = new String[10];
	String[] max = new String[45];

	ComboLot() {
		setTitle("e");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ���� �ٱ��� ��
		contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2, 1, 5, 0));

		selPane.setLayout(new GridLayout(4, 1, 2, 2));

		// ����� ���� ��1 (��������)
		upperselPane1.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.toString(i + 1);
		}
		numbersCombo = new JComboBox(numbers);
		JLabel howMany = new JLabel("�� ���� �����Ͻðڽ��ϱ� ?");
		howMany.setFont(new Font("����ü", Font.BOLD, 40));
		upperselPane1.add(howMany);
		numbersCombo.setFont(new Font("����ü", Font.BOLD, 30));
		upperselPane1.add(numbersCombo);
		selPane.add(upperselPane1);

		// ���õ� ���� �������� !! ���⼭ �������� �ȵǰ� Ȯ�ι�ư�� �������� �����ͼ� �����ؾ��ϱ� ������ ��ư�׼Ǹ����ʷ� ����.
//		num = numbersCombo.getSelectedItem().toString();
//		selNum = Integer.parseInt(num);

		// ����� ���� ��2 (���� ��������)
		upperselPane2.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.toString(i + 1);
		}
		countCombo = new JComboBox(numbers);
		JLabel counts = new JLabel("�� ���� ���ڸ� ����Ͻðڽ��ϱ� ?");
		counts.setFont(new Font("����ü", Font.BOLD, 40));
		upperselPane2.add(counts);
		countCombo.setFont(new Font("����ü", Font.BOLD, 30));
		upperselPane2.add(countCombo);
		selPane.add(upperselPane2);

		// ���õ� ���� �������� !! ���⼭ �������� �ȵǰ� Ȯ�ι�ư�� �������� �����ͼ� �����ؾ��ϱ� ������ ��ư�׼Ǹ����ʷ� ����.
//		count = countCombo.getSelectedItem().toString();
//		coNum = Integer.parseInt(count);

		// ����� ������ 3 (��������)
		upperselPane3.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 45; i++) {
			max[i] = Integer.toString(i + 1);
		}
		maxCombo = new JComboBox(max);
		JLabel raNum = new JLabel("������ ������ ? (1 ����)");
		raNum.setFont(new Font("���ü", Font.BOLD, 40));
		upperselPane3.add(raNum);
		maxCombo.setFont(new Font("����ü", Font.BOLD, 30));
		upperselPane3.add(maxCombo);
		selPane.add(upperselPane3);

		// ���õ� ���� �������� !! ���⼭ �������� �ȵǰ� Ȯ�ι�ư�� �������� �����ͼ� �����ؾ��ϱ� ������ ��ư�׼Ǹ����ʷ� ����.
//		range = maxCombo.getSelectedItem().toString();
//		rangeNum = Integer.parseInt(range);

		// ����� ������ 4 Ȯ�ι�ư
		JButton ok = new JButton("Ȯ��");
		ok.setFont(new Font("����ü", Font.BOLD, 40));
		ok.addActionListener(new MyActionListener());
		selPane.add(ok);

		contentPane.add(selPane);

		// �ϴ��� ��¿���
		result.setFont(new Font("����ü", Font.BOLD, 40));

		contentPane.add(result);

		setSize(1300, 800);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �Էµ� ���������� ��������.
			selNum = Integer.parseInt(countCombo.getSelectedItem().toString()); // ���� ����
			coNum = Integer.parseInt(numbersCombo.getSelectedItem().toString()); // ��� ����
			rangeNum = Integer.parseInt(maxCombo.getSelectedItem().toString()); // ����

			result.setText(null);
			int[] arr = new int[coNum];

			// ���� ������ŭ �� �迭�� �����Ͽ� ArrayList�� �߰�
			for (int k = 0; k < selNum; k++) {
				// ������ ���ڸ�ŭ�� ���� �迭�� ����
				out: for (int i = 0; i < arr.length; i++) {
					arr[i] = (int) ((Math.random() * rangeNum) + 1);

					// �ߺ��� ���ڸ� ����
					for (int j = 0; j < i; j++) {
						if (arr[i] == arr[j]) {
							i--;
							continue out;
						}
					}
				}
				// ������������ ����(��������)
				for (int x = 0; x < arr.length - 1; x++) {
					for (int y = x + 1; y < arr.length; y++) {
						if (arr[x] > arr[y]) {
							int temp = arr[y];
							arr[y] = arr[x];
							arr[x] = temp;
						}
					}
				}
				
				for(int z = 0 ; z < arr.length ; z ++) {
					if(arr[z] < 10)
						result.append("  ");
					result.append(Integer.toString(arr[z]));
					result.append("    ");
				}
				result.append("\n");
				
//				// TextArea�� �߰�
//				for (int b = 0; b < arr.length; b++) {
//					result.setText(Integer.toString(arr[b]));
//				}
//				result.setText("\n");
			}

		}
	}

	public static void main(String[] args) {
		new ComboLot();
	}
}
