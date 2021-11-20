// 랭킹 소스코드들은 결국 이 소스코드로 모인다. 
package ranking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RankingGraphic extends JFrame {
	ArrayList<Object> list = null;

	public RankingGraphic() {

		super("RANK");

		JP panel = new JP();
		JButton btn = new JButton("닫기");

		btn.setLocation(155, 500);
		btn.setSize(90, 30);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panel.setLayout(null);
		panel.add(btn);
		add(panel);

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	class JP extends JPanel {
		public JP() {
			setPreferredSize(new Dimension(420, 550));
			setBackground(Color.gray);

			Collections.sort(Reading.userlist, new UserComparator()); // 작은 순서대로 리스트를 정렬하는 코드
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("휴먼매직", Font.PLAIN, 30));
			g.drawString("PUZZLE RANK", 110, 40);
			g.setFont(new Font("휴먼매직", Font.PLAIN, 20));
			g.setColor(Color.yellow);
			g.drawString(" 순위                유저이름            걸린시간(초)", 8, 80);

			g.setFont(new Font("휴먼엑스포", Font.PLAIN, 17));
			for (int i = 0; i < 10; i++) { // 상위 10명만 출력
				g.setColor(Color.red);
				g.drawString(String.format("%3d", (i + 1)) + "st      ", 10, 110 + 40 * i);
				g.setColor(Color.black);
				g.drawString(String.format("%4s", Reading.userlist.get(i).getName()), 100, 110 + 40 * i);

				g.drawString(String.format("%4s", Reading.userlist.get(i).getScore()), 340, 110 + 40 * i);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * 랭킹 소스코드의 전반을 이해하는데 도움이 되는 소스코드이지만 필요없어서 각주처리해둠
		 * Reading.readFileAddList(Properties.filePath); // 텍스트파일을 읽어온다
		 * Collections.sort(Reading.userlist, new UserComparator()); // 작은 순서대로 리스트를
		 * 정렬하는 코드 System.out.println("main method start"); // 아래의 메소드를 이용해 새 점수를 텍스트파일에
		 * 넣을 수 있다. // Writing.write(); Reading.readFileAddList(Properties.filePath);
		 * Reading.printUserList();
		 * 
		 * System.out.println("정렬 전(텍스트파일에 입력된 순) ->"); Reading.printUserList();
		 * System.out.println("정렬 후(오름차순)->"); Reading.printUserList();
		 * 
		 * // 어레이 리스트의 개별 요소에 접근하고 싶다면 아래를 이용.
		 * System.out.println("가장 점수가 낮은 유저의 데이터는 아래와 같다");
		 * System.out.println(Reading.userlist.get(0).getName());
		 * System.out.println(Reading.userlist.get(0).getScore());
		 * 
		 * System.out.println("main method end");
		 */

		new RankingGraphic();
	}
}