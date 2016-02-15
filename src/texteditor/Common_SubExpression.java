/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

/**
 *
 * @author natashadutta
 */
import java.io.*;
import java.util.*;

public class Common_SubExpression
{       String data;
	Common_SubExpression(String Input) throws IOException
	{
		BufferedReader br=new BufferedReader(new StringReader(Input));     // Read Input file
		PrintWriter pw=new PrintWriter(new FileOutputStream(new File("output.txt")),true);                 // Prepare Output file
		Vector L = new Vector();
		
		String s;
		Boolean flag=false;
	
		while((s=br.readLine())!=null)
		{
			flag=false;
			String r=s.substring(s.indexOf("=")+1); //Evaluate Right-Hand Side of Expression
			
			for(int i=0;i < L.size();i++)
			{
				if((L.elementAt(i)).equals(r))	
					flag=true; //If Expression already present in Vector do nothing
					
			}			
			if(!flag)
			{
				L.addElement(r);	// If Expression not present in Vector, Add it inside Vector and Print it to output file
				pw.println(s);
			}
		}
		
	}
        public String dataaa() throws IOException{
            try (FileInputStream fis = new FileInputStream("output.txt")) {
                int size = fis.available();
                byte ba[] = new byte[size];
                fis.read(ba);
                data = new String(ba);
                }
        return(data);
        }

        public static void main(String args[]){  
	Common_SubExpression CSE = new Common_SubExpression();  
        }

 
    private Common_SubExpression() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}