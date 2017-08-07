import java.awt.*;


public class Objects {
	private int x,y;
	private int r=50;
	public int dx,dy;
	
	public Objects(){
		this.x=0;
		this.y=0;
		this.dx=2;
		this.dy=0;
	}
	public Objects(int a, int b, int s){
		this.x=a;
		this.y=b;
		this.dx=s;
		this.dy=0;
	}
	
	public void Vehicles(CrossingRoad c){
			if(((x+dx)+r)>c.getWidth())
				dx=-dx;
			else if(x+dx<0)
				dx=-dx;
			else if(y+dy<0)
				dy=0;
			x+=dx;
			y+=dy;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.darkGray);
		g.fillOval(x, y, r, r);
	}
	public void paint(Graphics g, Color c){
		g.setColor(c);
		g.fillOval(x, y, r, r);
	}
	public void UpMove(){
		if(dy-1>-2)
			dy-=1;
	}
	
	public void DownMove(){
		if(dy+1<2)
			dy+=1;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getR(){
		return r;
	}
	


}
