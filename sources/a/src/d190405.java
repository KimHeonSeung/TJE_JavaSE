import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class d190405 {

	public static void main(String[] args) throws IOException {

		File dirOri = new File("D:\\dev");
		File Ori = new File(dirOri, "tt.txt");
		File dirTarget = new File("D:\\dev");
		File Target = new File(dirTarget, "tt(1).txt");
		
		BufferedInputStream bis = 
				new BufferedInputStream(
						new FileInputStream(Ori));
		BufferedOutputStream bos = 
				new BufferedOutputStream(
						new FileOutputStream(Target));
		
		int dataOriN;
		byte[] dataOri = new byte[1024];
		

		while( (bis.read(dataOri)) != -1 ) {
			bos.write(dataOri);
		}
			
		bos.flush();
		bos.close();
		bis.close();
		
		

	}

}
