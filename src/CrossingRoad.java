import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class CrossingRoad extends Applet implements Runnable, KeyListener {
	
	String str="YOU WIN!!";
	Objects[] ob=new Objects[9];
	Objects main;
	Font strf=new Font("Sanserif",Font.PLAIN,60);
	AudioClip a;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(800, 600);
		addKeyListener(this);
		a=getAudioClip(getDocumentBase(),"Football.wav");
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		main=new Objects(375,550,0);
		ob[0]=new Objects();
		ob[1]=new Objects(0,60,4);
		ob[2]=new Objects(750,120,3);
		ob[3]=new Objects(0,180,1);
		ob[4]=new Objects(750,240,7);
		ob[5]=new Objects(750,300,3);
		ob[6]=new Objects(0,360,6);
		ob[7]=new Objects(750,420,2);
		ob[8]=new Objects(0,480,4);
		Thread t1=new Thread(this);
		t1.start();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		setBackground(Color.YELLOW);
		for(int i=0;i<9;i++)
			ob[i].paint(g);
		main.paint(g,Color.RED);
		if(main.getY()<50){
			g.setFont(strf);
			g.setColor(Color.BLUE);
			g.drawString(str, 200, 250);
			a.play();
			stop();
		}
		else if(CheckforCollision(main,ob)){
			g.setFont(strf);
			g.drawString("YOU LOSE", 200, 250);
			a.play();
			stop();
		}
		
	}

	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			for(int i=0;i<9;i++)
				ob[i].Vehicles(this);
			main.Vehicles(this);
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case 38:{
			main.UpMove();
			break;
		}
		case 40:{
			main.DownMove();
			break;
		}
		}
		
		
	}
	
	public boolean CheckforCollision(Objects a, Objects[] ob){
		for(int i=8;i>0;i--){
		if((a.getY()>ob[i].getY())&&a.getY()<(ob[i].getY()+ob[i].getR())&&(a.getX()<ob[i].getX()+ob[i].getR())&&a.getX()>(ob[i].getX()-ob[i].getR()))
			return true;
		}
			return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
