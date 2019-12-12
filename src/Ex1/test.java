package Ex1;
import java.io.IOException;

import Ex1.ComplexFunction;
public class test {
	public static void main(String[] args) {

	
		Functions_GUI data = FunctionsFactory();
		Polynom P=new Polynom("3x^2+3");
	
		int w=1000, h=600, res=200;
		Range rx = new Range(-10,10);
		Range ry = new Range(-5,15);
		//data.drawFunctions(w,h,rx,ry,res);
		
			

		Functions_GUI ans =new Functions_GUI();
		ans.add(new Polynom("3x^5+7"));
		ans.add(new ComplexFunction("Plus",new Polynom ("4x^5+3"),new Monom("24x")));
		ans.add(new Polynom("x^5+x^4+x^3+x^2+x"));
		Functions_GUI data1 =new Functions_GUI();
		try {
			ans.saveToFile("C:\\Users\\Medhat\\Desktop\\FuGUITst\\FuGUI.txt");
			data1.initFromFile("C:\\Users\\Medhat\\Desktop\\FuGUITst\\FuGUI.txt");
			System.out.println(ans.toString());
			System.out.println(data1.toString());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

				

	}
		public static Functions_GUI FunctionsFactory() {
			Functions_GUI ans = new Functions_GUI();
			String s1 = "3.1 +2.4x^2 -x^4";
			String s2 = "5 +2x -3.3x +0.1x^5";
			String[] s3 = {"x +3","x -2", "x -4"};
			Polynom p1 = new Polynom(s1);
			Polynom p2 = new Polynom(s2);
			Polynom p3 = new Polynom(s3[0]);
			ComplexFunction cf3 = new ComplexFunction(p3);
			for(int i=1;i<s3.length;i++) {
				cf3.mul(new Polynom(s3[i]));
			}
			
			ComplexFunction cf = new ComplexFunction("Plus", p1,p2);
			ComplexFunction cf4 = new ComplexFunction("Divid", new Polynom("x +1"),cf3);
			cf4.plus(new Monom("2"));
			ans.add(cf.copy());
			ans.add(cf4.copy());
			cf.div(p1);
			ans.add(cf.copy());
			String s = cf.toString();
			function cf5 = cf4.initFromString(s1);
			function cf6 = cf4.initFromString(s2);
			ans.add(cf5.copy());
			ans.add(cf6.copy());
			ComplexFunction max = new ComplexFunction(ans.get(0).copy());
			ComplexFunction min = new ComplexFunction(ans.get(0).copy());
			System.out.println("Max:"+max);
			System.out.println( "Min:"+min);
			System.out.println(ans.size());
			for(int i=1;i<ans.size();i++) {
				max.max(ans.get(i));
				min.min(ans.get(i));
				System.out.println("Interation "+i+ "-Max:"+max);
				System.out.println( "Interation "+i+ "-Min:"+min);
			}
			
			ans.add(max);
			ans.add(min);
			System.out.println(ans.size());
			return ans;
		}
	
	

}