import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int pass = 0;
		System.out.println("LogIn�� ���� ID�� PW�� �Է��ϼ���.");
		System.out.println("ID �Է� : ");
		String id =scan.nextLine();
		System.out.println("PW �Է� : ");
		String pw = scan.nextLine();
		File file = new File("C:\\Users\\h\\Desktop\\MemberDB.txt");//����� ���� ��ġ
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			try {
				while((line=bufReader.readLine()) != null) {
					int passId = line.indexOf(id);
					int passPw = line.indexOf(pw);
					if(passId != -1 && passPw != -1) {
						System.out.println("�α��� ����");
						pass = 1;	}			
					}
				if(pass==0) { System.out.println("�α��ν���"); }
				bufReader.close();
			} catch (IOException e) { e.printStackTrace();	}	
		} catch (FileNotFoundException e) {	e.printStackTrace();}
	}

}
