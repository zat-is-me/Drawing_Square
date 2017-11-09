import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import chapman.graphics.JPlot2D;//External jar file

public class Square {
	public static void main(String[] args) 
	{
		//<<<<<<<<<<<< Starting objects
		MySquare sq1 = new MySquare(8);
		
		//<<<<<<<<<<< setting the position
		sq1.setPosition(4,4);
		
		//<<<<<<<<<< Displaying the graph		
		sq1.Display(); 	
		
	}
}
//<<<<<<<< The shape class >>>>>>>>>
class MySquare {
	private static double[] x = new double[361];
	private static double[] y = new double[361];
	private double s; // This is length of side
	private int px =0,py = 0;
	
	// constructor
	MySquare(double s) {
		this.s = s;
		
		JPlot2D graph = new JPlot2D();
		JFrame myframe = new JFrame();
		
		myframe.setSize(1000, 1000);
		myframe.getContentPane().add(graph, BorderLayout.CENTER);
		myframe.setVisible(true);
		
		graph.setTitle("Plot of y(x)");
		graph.setXLabel("x axis");
		graph.setYLabel("y axis");
			
		graph.addCurve(x,y);
		graph.setGridState(JPlot2D.GRID_ON);
		graph.setLineColor(Color.red);
		graph.setLineWidth(10.0f);

		}
	//Center of the square
	public void setPosition(int sx, int sy) {
		px = sx;
		py = sy;
	}
	public int getPositionx(int gx) {
		return px;
	}
	public int getPositiony(int gy) {
		return py;
	}
	// <<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>
	public void Display() {
		int px = 0;
		int py = 0;
		double t;
		
		for (int j = 0; j <= 360; j++) {
			//changing number in to angle
			t = Math.toRadians(j);
			
			//When the Ry become positive the value of
			//Y will adjust positive which the y value 
			//starts draws from center value half up the square side
			double Ry = Math.sin(t);
			if (Ry > 0)
				y[j] = getPositiony(py) + s / 2;
			
			//When the Ry become negative the value of
			//Y will adjust negative which the y value 
			//starts draws from center value half down the square side
			else if (Ry <= 0)
			y[j] = getPositiony(py) - s / 2;
			
			//When the Rx become positive the value of
			//x will adjust to the right which the x value 
			//starts draws from center value half to right the square side
			double Rx = Math.cos(t);
			if (Rx > 0)
				x[j] = getPositionx(px) + s / 2;
			
			//When the Rx become negative the value of
			//x will adjust to the left which the x value 
			//starts draws from center value half  to the left the square side
			else if (Rx <= 0)
				x[j] = getPositionx(px) - s / 2;
		}
	}
}
