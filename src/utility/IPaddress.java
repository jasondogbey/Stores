package utility;
import java.io.*;
public class IPaddress {
    static String sIP="";
    static File f, ff;
    
    public IPaddress(){}
    public static String getAddress(){
        //Accessing IP Address from text file
        try{
            f = new File("IPaddress.txt").getAbsoluteFile();
            BufferedReader in = new BufferedReader(
                    new FileReader(f));
            sIP = in.readLine();
            System.out.println(sIP);
            in.close();
        }catch(Exception e){
            sIP = "127.0.0.1";
            System.out.println(e.getMessage());
        }
        return sIP;
    }
     public static void saveAddress(String sMes){
        //Saves new IP address
        try{
            if (!new File("IPaddress.txt").getAbsoluteFile().
                    exists()){
                new File("IPaddress.txt").createNewFile();
            }
            ff = new File("IPaddress.txt").getAbsoluteFile();
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(ff, false)));
            out.print(sMes);
            out.close();
        }catch(Exception e){}
    }
}
