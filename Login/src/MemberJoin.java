import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberJoin {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		File file = new File("C:\\Users\\h\\Desktop\\MemberDB.txt");//����� ���� ��ġ
		System.out.println("ȸ�������� ���� ID�� PW�� �Է��ϼ���.");
		
		while(true) {
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			FileWriter filewriter = new FileWriter(file, true);
			if(file.isFile() && file.canWrite()) {				
				System.out.println("ID �Է�: ");
				String id =scan.nextLine();
				int overlap = 0;
				String line = "";
				while((line=bufReader.readLine()) != null) {
					int checkId = line.indexOf(id);
						
					if(checkId != -1 ) {
						System.out.println("�ߺ��� ���̵� �ֽ��ϴ�.");
						overlap++;	}			
						}
					
				bufReader.close();
				if (overlap != 0) {continue;}
				filewriter.append(id);
				filewriter.append("\t");
				System.out.println("PW �Է�: ");
				filewriter.append(scan.nextLine());
				filewriter.append("\r");
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				
			}
			filewriter.close();
			break;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
}
