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
import Builder.*;
import Elements.*;
import Optimize.Optimizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Optimizee {
    static String data;
    public static int MAX_ROUNDS = 25;
    
    public static void Main(String args) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"), true);
        Scanner scan = new Scanner(System.in);
        scan = new Scanner(args);
        ArrayList<String> lines = new ArrayList<>();
        
        out.println("Input File Content:");
        while(scan.hasNextLine()){
            lines.add(scan.nextLine());
            out.println(lines.get(lines.size()-1));
        }
        
        
        // Convert expressions in 3-Address code (unoptimized)
        ArrayList<Instruction> ins =  ThreeAddressBuilder.Build(lines);
        
        
        // Print unoptimized 3-Address code
        out.println("\n\nUnoptimized 3-Address Code:");
        for(Instruction i : ins){
        out.println(i.toString());
        }
        
        Optimizer op = new Optimizer();
        
        
        // Perform successive round of optimizations
        // Stop when no more reduction in complexity or too many rounds
        boolean optimized = true;
        int i = 1;
        
        while(optimized && i < MAX_ROUNDS){   
            optimized = false;
            
        out.println("\n\nCode after " + i + " optimization round:");
            optimized = op.Optimize(ins);
        out.println(Optimizer.ToText(ins, 1));
            i++;
        }
        
        if(optimized) out.println("\n\nMaximum number of rounds is limited to " + MAX_ROUNDS);
    }
    public static String DATA() throws IOException{
            try (FileInputStream fis = new FileInputStream("output.txt")) {
                int size = fis.available();
                byte ba[] = new byte[size];
                fis.read(ba);
                data = new String(ba);
                }
        return(data);
        }
       
}

