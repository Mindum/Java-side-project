import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlockGame {

	
	static class MyFrame extends JFrame{
		
		
		//constant
		static int BALL_WIDTH =20;
		static int BALL_HEIGHT =20;
		static int BLOCK_ROWS = 5 ;
		static int BLOCK_COLUMNS = 10;
		static int BLOCK_WIDTH = 40;
		static int BLOCK_HEIGHT = 20;
		static int BLOCK_GAP =3 ;
		static int BAR_WIDTH = 80;
		static int BAR_HEIGHT = 20;
		static int CANVAS_WIDTH = 400 + (BLOCK_GAP * BLOCK_COLUMNS)- BLOCK_GAP;
		static int CANVAS_HEIGHT = 600;
		
		//variable
		static MyPanel myPanel = null;
		static int score = 0;
		static Timer timer = null;
		static Block[][]blocks  = new Block [BLOCK_ROWS][BLOCK_COLUMNS];
		static Bar bar = new Bar();
		static Ball ball  = new Ball();
		static int barXTarget = bar.x;// 바는 interpolation
		static int dir = 0;//0 : 위-오른쪽 1: 아래-오른쪽  2: 위-왼쪽 3 : 아래-왼쪽 
		static int ballSpeed = 5;
		
		static class Ball{
			int x = CANVAS_WIDTH / 2 - BALL_WIDTH / 2;
			int y = CANVAS_HEIGHT / 2 - BALL_HEIGHT / 2;
			int width = BALL_WIDTH;
			int height = BALL_HEIGHT;
			
		}
		static class Bar {
			int x= CANVAS_WIDTH / 2 - BAR_WIDTH / 2;
			int y = CANVAS_HEIGHT - 100;
			int width = BAR_WIDTH;
			int height = BAR_HEIGHT;
			
		}
		
		static class Block{
			int x = 0;
			int y = 0;
			int width = BLOCK_WIDTH;
			int height = BLOCK_HEIGHT;
			int color = 0; // 0:화이트(10점) 1:노랑(20점) 2:블루(30점) 3:마젠타(40점) 4:빨강(50점);
			boolean isHidden = false;//충돌 후에 블록이 사라지게 하는 것
		}
		static class MyPanel extends JPanel {//VANVAS for Draw!
			
		}
		public MyFrame(String title) {
			super(title);
			this.setVisible(true);
			this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
			this.setLocation(400,300);
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			initData();
			
			myPanel = new MyPanel();
			this.add("Center",myPanel);
			
			setKeyListener();
			startTimer();
		}
		public void initData() {
			for(int i = 0; i<BLOCK_ROWS;i++) {
				for(int j=0; j<BLOCK_COLUMNS; j++) {
					blocks[i][j] = new Block();
					blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP*j;
					blocks[i][j].y = 100 + i*BLOCK_HEIGHT * i + BLOCK_GAP * i;
					blocks[i][j].width = BLOCK_WIDTH;
					blocks[i][j].height = BLOCK_HEIGHT;
					blocks[i][j].color = 4 - i;
					blocks[i][j].isHidden = false;
				}
			}
		}
		public void startTimer() {
			
		}
		
		public void setKeyListener() {
			
		}
	}
	public static void main(String[] args) {	
		new MyFrame("블록 게임");
		
	}

}
