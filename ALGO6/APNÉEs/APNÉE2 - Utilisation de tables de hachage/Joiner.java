import java.io.*;
import java.util.Scanner;
import java.util.Hashtable;


class Joiner {
    String f1,f2;
    PrintWriter out;

    Joiner(String f1, String f2, String res) {
        this.f1 = f1;
        this.f2 = f2;
        try {
        out = new PrintWriter(new FileOutputStream(res));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ChangeOutput(String res) {
        try {
        out = new PrintWriter(new FileOutputStream(res));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void NestedJoin() {
        Scanner in1, in2;
        String t1,t2 ;
        String [] t2_splited;
        String [] t1_splited;
        
        long startTime = System.currentTimeMillis();
        try {
        in1 = new Scanner(new FileInputStream(f1)) ;
        in2 = new Scanner(new FileInputStream(f2));

        while (in1.hasNext()) {
            t1 = in1.nextLine();
            t1_splited = t1.split("\t");
            while (in2.hasNext()) {
                t2 = in2.nextLine();
                t2_splited = t2.split("\t");
                if (t1_splited[1].equals(t2_splited[0])) {
                    out.print(t1+"\t");
                    out.println(t2);
                }
            }
            in2.reset();
            in2= new Scanner(new FileInputStream(f2));
        }
        in1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        out.close();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Computation time, nested loop join: "+totalTime+" ms");
    }
    
    public void HashJoin() {
        Scanner in1, in2;
        String t1,t2 ;
        String [] t2_splited;
        String [] t1_splited;
        
        Hashtable<String, String> hashed_t2 = new Hashtable<String, String>();

        long startTime = System.currentTimeMillis();
        
        out.println("To be implemented !!");
        System.out.println("To be implemented !!");
        
        
        out.close();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Computation time, hash join: "+totalTime+" ms");
    }
    
}
