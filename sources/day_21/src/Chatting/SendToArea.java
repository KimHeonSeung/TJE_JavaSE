package Chatting;

import javax.swing.*;

public class SendToArea {
	private JTextField Field;
	private JTextArea Area;
	private String content;
	
	SendToArea(JTextField Field, JTextArea Area) {
		this.Field = Field;
		this.Area = Area;
		content = Field.getText() + "\n";
		Area.append(content);
		
	}

}
