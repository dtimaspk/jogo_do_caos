import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.awt.event.*;

public class Game extends App{
	private int[][] vertices = new int[3][2];
	private ArrayList<int[]> pontos = new ArrayList<int[]>();
	private int contador = 0;
	public void setup(){
		setFps(60);
		setLargura(300);
		setAltura(300);
		vertices[0][0] = 150;
		vertices[0][1] = 10;
		vertices[1][0] = 10;
		vertices[1][1] = 290;
		vertices[2][0] = 290;
		vertices[2][1] = 290;
		int[] aux = new int[2];
		aux[0] = 90;
		aux[1] = 200;
		pontos.add(contador,aux);
	}
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getLargura(),getAltura());
		g.setColor(Color.WHITE);
		for (int[] v: vertices) {
			g.fillOval(v[0]-4,v[1]-4,8,8);
		}
		g.setColor(Color.GRAY);
		for (int[] p: pontos) {
			g.fillOval(p[0]-1,p[1]-1,2,2);
		}
	}
	public void update(){
		if(contador < 5000){
			Random r = new Random();
			int rand_v = r.nextInt(3);
			int[] p_aux = new int[2];
			p_aux = pontos.get(contador);
			int[] p_novo = new int[2];
			p_novo[0] = p_aux[0] + ((vertices[rand_v][0] - p_aux[0])/2);
			p_novo[1] = p_aux[1] + ((vertices[rand_v][1] - p_aux[1])/2);
			contador++;
			pontos.add(contador,p_novo);
		}
	}
	public void checkInput(){ 
	}
}