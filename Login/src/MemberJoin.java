import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemberJoin {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		File file = new File("C:\\Users\\h\\Desktop\\MemberDB.txt");//입출력 파일 위치
		System.out.println("회원가입을 위해 ID와 PW를 입력하세요.");
		
		while(true) {
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			FileWriter filewriter = new FileWriter(file, true);
			if(file.isFile() && file.canWrite()) {				
				System.out.println("ID 입력: ");
				String id =scan.nextLine();
				int overlap = 0;
				String line = "";
				while((line=bufReader.readLine()) != null) {
					int checkId = line.indexOf(id);
						
					if(checkId != -1 ) {
						System.out.println("중복된 아이디가 있습니다.");
						overlap++;	}			
						}
					
				bufReader.close();
				if (overlap != 0) {continue;}
				filewriter.append(id);
				filewriter.append("\t");
				System.out.println("PW 입력: ");
				filewriter.append(scan.nextLine());
				filewriter.append("\r");
				System.out.println("회원가입이 완료되었습니다.");
				
			}
			filewriter.close();
			break;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
}
