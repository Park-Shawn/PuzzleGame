import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberJoin {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		File file = new File("C:\\Users\\h\\Desktop\\MemberDB.txt");//����� ���� ��ġ
		try {
			FileWriter filewriter = new FileWriter(file, true);
			if(file.isFile() && file.canWrite()) {
				System.out.println("ȸ�������� ���� ID�� PW�� �Է��ϼ���.");
				System.out.println("ID �Է�: ");
				filewriter.append(scan.nextLine());
				filewriter.append("\t");
				System.out.println("PW �Է�: ");
				filewriter.append(scan.nextLine());
				filewriter.append("\r");
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
			}
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
