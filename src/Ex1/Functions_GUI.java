package Ex1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		if (list.addAll(arg0)) return true;

		return false;
	}

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public boolean contains(Object arg0) {
		if(list.contains(arg0)) return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		if(list.containsAll(arg0)) return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		return list.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		if(list.remove(arg0)) return true ;

		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		if(list.removeAll(arg0)) return true; 

		return false;
	}

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
			Gson gson = new Gson();
			JsonReader reader =  new JsonReader (new FileReader(file));
			Functions_GUI tg1 = gson.fromJson(reader, Functions_GUI.class);
			this.list=tg1.list;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void saveToFile(String file) throws IOException {

		//Write JSON to file
		try 
		{
			Gson gson = new Gson();
			String json = gson.toJson(this);
			System.out.println(json);
			String file_name = file+".json";
			PrintWriter pw = new PrintWriter(new File(file_name));
			pw.write(json);
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();

		}

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {

		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenRadius(0.009);
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());


		function p1 = new Polynom("5");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.005);

		//		for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
		//			StdDraw.point(i,p1.f(i));
		//		}

		for (int j = 0; j < list.size(); j++) {
			for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
				if(ry.isIn(list.get(j).f(i))) {
					StdDraw.line(i, list.get(j).f(i), i+1, list.get(j).f(i+1));
				}
			}
		}

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

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

}
