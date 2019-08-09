import java.awt.Button;
import java.awt.Frame;

import javax.swing.JFrame;

public class day10 {
	
	JFrame frame = new JFrame("じじじ");
	Button button = new Button("せせせ");
	
	public void createFrame() {
		frame.add(button);
		
		frame.setSize(300, 600);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		day10 frame = new day10();
		frame.createFrame();

	}

}
