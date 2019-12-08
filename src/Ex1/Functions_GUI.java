package Ex1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;


public class Functions_GUI implements functions, Serializable {

	@SerializedName("FunctionArry")
	ArrayList<function> list = new ArrayList<function>();

/**
 * adding a function to the Draw list array;
 */
	@Override
	public boolean add(function arg0) {
		try {
			list.add(arg0);
			return true;
		}
		catch (Exception e) {
			throw new RuntimeException("Unable to add " + arg0.toString());
		}
	}
	
/**
 * add all the functions in a collection to Draw list array;
 * returns true if all the collections is successfully transfer into the Draw list array; 
 */
	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		if (list.addAll(arg0)) return true;

		return false;
	}
/**
 * clear the Draw list array; 
 */
	@Override
	public void clear() {
		list.clear();

	}
/**
 * check if an function is contained in the Draw list array; 
 * return true if function in Draw list; 
 */
	@Override
	public boolean contains(Object arg0) {
		if(list.contains(arg0)) return true;
		return false;
	}
/**
 * check if all the collection is contain within the Draw list array; 
 * return true if contain;
 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		if(list.containsAll(arg0)) return true;
		return false;
	}
/**
 * check if the Draw list array is empty; 
 * return true if the list is empty;
 */
	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

/**
 * Draw list iterator; 
 * return the list array iterator; 
 */
	@Override
	public Iterator<function> iterator() {
		return list.iterator();
	}
/**
 * Removing an object from Draw list array; 
 * return true if the object successfully removed.
 */
	@Override
	public boolean remove(Object arg0) {
		try {
		if(list.remove(arg0)) return true ;
		}catch (Exception e) {
			throw new RuntimeException("the object does not on list.");
		}
		return false;
	}
/**
 * remove all the input collection functions from the Draw list array; 
 * return true if the object successfully removed.
 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		if(list.removeAll(arg0)) return true; 

		return false;
	}
/**
 * removes from this collection all of its elements that are not contained in the specified collection; 
 * return true if successfully retain. 
 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		if(list.retainAll(arg0)) return true; 

		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return list.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {

		try {
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);
			ArrayList <function> list_temp =new ArrayList<function>();
			String readline;
			readline=buffer.readLine();
			while(readline!=null) 
			{
				list_temp.add(new ComplexFunction(readline));
				readline=buffer.readLine();
			}
			this.list=list_temp;
			buffer.close();
			reader.close();
		}catch (Exception e) {
			throw new IOException();
		}
	}

	@Override
	public void saveToFile(String file) throws IOException {
		try {
			FileWriter f_writer = new FileWriter(file);
			PrintWriter p_writer = new PrintWriter(f_writer);
			for(int i=0;i<list.size();i++) 
				p_writer.println(list.get(i).toString());
			p_writer.close(); 
			f_writer.close();
		}catch (Exception e) {
			throw new IOException();
		}
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {


		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());

		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		
		for (int i = (int) rx.get_min(); i < rx.get_max(); i++) {

			StdDraw.line(i,(int) ry.get_max(), i,(int) ry.get_min());
			
		}
		for (int i =(int) ry.get_min() ; i < ry.get_max(); i++) {
			StdDraw.line((int)rx.get_max(), i, (int) rx.get_min(), i);
			
		}

		StdDraw.setPenRadius(0.00000001);
		StdDraw.setPenColor(Color.BLACK);
		for (int i = (int) Math.min(rx.get_min(), ry.get_min()); i <(int)  Math.max(rx.get_max(), ry.get_max()); i++) {
			StdDraw.text(i, -0.5, ""+i);
			if (i==0) {}
			else
				StdDraw.text(0.5, i, ""+i);

		}

		StdDraw.setPenRadius(0.004);
		
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());


		
		StdDraw.setPenRadius(0.002);

		for (int j = 0; j < list.size(); j++) {
			int r= (int) (Math.random()*244);
			int g= (int) (Math.random()*244);
			int b= (int) (Math.random()*244);

			System.out.println(r+" "+g+ " "+b);

			for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
				StdDraw.setPenColor(r, g, b);
				try {
					if(ry.isIn(list.get(j).f(i)) ||ry.isIn(list.get(j).f(i+0.1)) ) {
						StdDraw.line(i, list.get(j).f(i), i+0.1, list.get(j).f(i+0.1));
					}
				}catch (Exception e) {

				}
			}
		}

	}

	@Override
	public void drawFunctions(String json_file) {

		Gson gson = new Gson();

		try 
		{
			FileReader reader = new FileReader(json_file);
			GUI_Window window = gson.fromJson(reader,GUI_Window.class);
			Range rx=new Range(window.Range_X[0],window.Range_X[1]);
			Range ry=new Range(window.Range_Y[0],window.Range_Y[1]);
			this.drawFunctions(window.Width, window.Height, rx, ry, window.Resolution);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void drawFunctions() {

		int width = 1024;
		int height = 1024;
		Range rx = new Range(-25,25);
		Range ry = new Range(-25,25);
		int resolution = 2000;
		StdDraw.setCanvasSize(width,height);


		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());

		StdDraw.setPenRadius(0.001);
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = -99; i < 99; i++) {

			StdDraw.line(i, 100, i, -100);
			StdDraw.line(100, i, -100, i);

		}

		StdDraw.setPenRadius(0.00000001);
		StdDraw.setPenColor(Color.BLACK);
		for (int i = -99; i < 99; i++) {
			StdDraw.text(i, -1, ""+i);
			if (i==0) {}
			else
				StdDraw.text(1, i, ""+i);

		}

		StdDraw.setPenRadius(0.004);
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());


		function p1 = new Polynom("5");
		StdDraw.setPenRadius(0.002);

		for (int j = 0; j < list.size(); j++) {
			int r= (int) (Math.random()*244);
			int g= (int) (Math.random()*244);
			int b= (int) (Math.random()*244);

			System.out.println(r+" "+g+ " "+b);

			for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
				StdDraw.setPenColor(r, g, b);
				if(ry.isIn(list.get(j).f(i)) ||ry.isIn(list.get(j).f(i+0.5)) ) {
					StdDraw.line(i, list.get(j).f(i), i+0.5, list.get(j).f(i+0.5));
				}
			}
		}

	}

	public ComplexFunction get(int i) {
		try {
			if (list.get(i) instanceof Polynom_able || list.get(i) instanceof Monom ) {
				ComplexFunction cf = new ComplexFunction(list.get(i));
				return cf;
			}else if ( list.get(i) instanceof ComplexFunction) {
				ComplexFunction cf = new ComplexFunction(list.get(i));
				return cf;
			}
		}catch (Exception e) {
			throw new RuntimeException("Index out of bound!");
		}
		return null;
	}

	public class GUI_Window 
	{

		public int Width;
		public int Height;
		public int Resolution;
		public double []Range_X;
		public double []Range_Y;

		public GUI_Window(int width,int height,int resolution,double []Range_X,double []Range_Y)
		{
			Range_Y=new double[2];
			for (int i = 0; i < 3; i++) {
				this.Range_X[i]=Range_X[i];
				this.Range_Y[i]=Range_Y[i];
			}
			//			this.Range_X[0]=Range_X[0];
			//			this.Range_X[1]=Range_X[1];
			//			this.Range_Y[0]=Range_Y[0];
			//			this.Range_Y[1]=Range_Y[1];
			this.Height=height;
			this.Width=width;
			this.Resolution=resolution;
		}

	}

}
