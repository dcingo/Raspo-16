import java.io.*;
import java.util.Vector;

public class SearchLog {
    private String fileLog = "D://monitoring.log";

    public String getFileLog() {
        return fileLog;
    }
    public void setFileLog(String fileLog) {
        this.fileLog = fileLog;
    }

    public Vector<String> getDOI(char metod){
        Vector<String> result = new Vector<String>();
        String str="";
        try
        {
            FileReader fr = new FileReader(fileLog);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready())
            {
                str = br.readLine();
                if(str.lastIndexOf("))</telegram>")>0){
                    str = str.substring(str.lastIndexOf("<telegram>")+10,str.lastIndexOf("</telegram>"));
                    if (str.length() < 18) continue;
                    if(str.charAt(16) == metod){
                        result.insertElementAt(str,0);
                        System.out.println(str);
                    }

                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return result;
    }
    public String[] GetDOI12(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI13(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI15(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI13n(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public Vector<String> GetDOI22(String nomer, String date, long t1, long t2, String nPlace, String Ndoi){
        Vector<String> result = new Vector<String>();
        result = getDOI('2');

        return result;
    }
    public String[] GetDOI24(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI25(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI26n(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI32(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI34(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI36n(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI47(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }
    public String[] GetDOI46n(String nomer, String date, long t1, long t2, String nPlace,String Ndoi){
        String[] result = new String[70];
        return result;
    }

    private Vector<String>  readlog(){
        Vector<String> list = new Vector<String>();
        try
        {
            FileReader fr = new FileReader(fileLog);
            String str="";
            BufferedReader br = new BufferedReader(fr);
            while(br.ready())
            {
                str = br.readLine();
                if(str.lastIndexOf("222222</telegram>")>0){
                    str = str.substring(str.lastIndexOf("<telegram>")+10,str.lastIndexOf("</telegram>"));
                    list.add(str);
                }
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return list;

    }
}
