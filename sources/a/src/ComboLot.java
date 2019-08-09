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

	// 수량
	String num;
	int selNum;

	// 수 개수
	String count;
	int coNum;

	// 범위
	String range;
	int rangeNum;

	// String [] number = {"1","2","3","4","5","6","7","8","9","10"};

	String[] numbers = new String[10];
	String[] max = new String[45];

	ComboLot() {
		setTitle("e");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 가장 바깥쪽 팬
		contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(2, 1, 5, 0));

		selPane.setLayout(new GridLayout(4, 1, 2, 2));

		// 상단의 선택 팬1 (수량정보)
		upperselPane1.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.toString(i + 1);
		}
		numbersCombo = new JComboBox(numbers);
		JLabel howMany = new JLabel("몇 개를 구입하시겠습니까 ?");
		howMany.setFont(new Font("볼드체", Font.BOLD, 40));
		upperselPane1.add(howMany);
		numbersCombo.setFont(new Font("볼드체", Font.BOLD, 30));
		upperselPane1.add(numbersCombo);
		selPane.add(upperselPane1);

		// 선택된 수량 가져오기 !! 여기서 가져오면 안되고 확인버튼이 눌렸을때 가져와서 저장해야하기 때문에 버튼액션리스너로 간다.
//		num = numbersCombo.getSelectedItem().toString();
//		selNum = Integer.parseInt(num);

		// 상단의 선택 팬2 (숫자 개수정보)
		upperselPane2.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 10; i++) {
			numbers[i] = Integer.toString(i + 1);
		}
		countCombo = new JComboBox(numbers);
		JLabel counts = new JLabel("몇 개의 숫자를 출력하시겠습니까 ?");
		counts.setFont(new Font("볼드체", Font.BOLD, 40));
		upperselPane2.add(counts);
		countCombo.setFont(new Font("볼드체", Font.BOLD, 30));
		upperselPane2.add(countCombo);
		selPane.add(upperselPane2);

		// 선택된 갯수 가져오기 !! 여기서 가져오면 안되고 확인버튼이 눌렸을때 가져와서 저장해야하기 때문에 버튼액션리스너로 간다.
//		count = countCombo.getSelectedItem().toString();
//		coNum = Integer.parseInt(count);

		// 상단의 선택팬 3 (범위정보)
		upperselPane3.setLayout(new GridLayout(1, 2, 3, 3));
		for (int i = 0; i < 45; i++) {
			max[i] = Integer.toString(i + 1);
		}
		maxCombo = new JComboBox(max);
		JLabel raNum = new JLabel("숫자의 범위는 ? (1 부터)");
		raNum.setFont(new Font("고딕체", Font.BOLD, 40));
		upperselPane3.add(raNum);
		maxCombo.setFont(new Font("볼드체", Font.BOLD, 30));
		upperselPane3.add(maxCombo);
		selPane.add(upperselPane3);

		// 선택된 범위 가져오기 !! 여기서 가져오면 안되고 확인버튼이 눌렸을때 가져와서 저장해야하기 때문에 버튼액션리스너로 간다.
//		range = maxCombo.getSelectedItem().toString();
//		rangeNum = Integer.parseInt(range);

		// 상단의 선택팬 4 확인버튼
		JButton ok = new JButton("확인");
		ok.setFont(new Font("볼드체", Font.BOLD, 40));
		ok.addActionListener(new MyActionListener());
		selPane.add(ok);

		contentPane.add(selPane);

		// 하단의 출력영역
		result.setFont(new Font("볼드체", Font.BOLD, 40));

		contentPane.add(result);

		setSize(1300, 800);
		setVisible(true);
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 입력된 숫자정보를 가져오기.
			selNum = Integer.parseInt(countCombo.getSelectedItem().toString()); // 구매 개수
			coNum = Integer.parseInt(numbersCombo.getSelectedItem().toString()); // 몇개의 숫자
			rangeNum = Integer.parseInt(maxCombo.getSelectedItem().toString()); // 범위

			result.setText(null);
			int[] arr = new int[coNum];

			// 구매 개수만큼 수 배열을 생성하여 ArrayList에 추가
			for (int k = 0; k < selNum; k++) {
				// 선택한 숫자만큼의 숫자 배열을 생성
				out: for (int i = 0; i < arr.length; i++) {
					arr[i] = (int) ((Math.random() * rangeNum) + 1);

					// 중복된 숫자를 제거
					for (int j = 0; j < i; j++) {
						if (arr[i] == arr[j]) {
							i--;
							continue out;
						}
					}
				}
				// 오름차순으로 정렬(버블정렬)
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
				
//				// TextArea에 추가
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
