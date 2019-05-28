import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Handler3 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String name3=e.getActionCommand();
		
		String path3="";
		
		FileReader fr3=null;
		BufferedReader br3=null;
		FileWriter fw3=null;
		BufferedWriter bw3=null;
		
		if(name3.equals("CaesarCipher")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"���Ͽ���",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\"); //���� ���� ��� ����
			fileOpen.setVisible(true); //���� â ���� ���̰� ����
			path3=fileOpen.getDirectory()+fileOpen.getFile(); //������ ��� �� �̸��� ��� ����
			
			
			try {
				fr3=new FileReader(path3);
				br3=new BufferedReader(fr3);
			
				
				String filename3=fileOpen.getFile();
				filename3=filename3.replace("_Encryption(Caesar).txt","_Decryption(Caesar).txt");//���� ���� �̸��� �� ��ȣ�� ���� ���� ����
				File Fi2=new File("D:\\",filename3);
				Fi2.createNewFile();
				
				fw3=new FileWriter(Fi2);//���� ������ ���Ͽ� ��Ʈ�� ��ġ
				bw3=new BufferedWriter(fw3);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ
				
				String line="";
				for(int i=0; (line=br3.readLine())!=null; i++) {
					int offset =546541;
				    String cipher = CaesarCipher.encryptCaesarCipher(line, offset);
					bw3.write(cipher+"\r\n");
				}
				br3.close();//�Է� ��Ʈ�� ����
				bw3.close();//��� ��Ʈ�� ����
			}catch(IOException IE) {}
		}
	}
}