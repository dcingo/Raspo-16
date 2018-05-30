import java.util.Calendar;
import java.util.Date;

public class ClassDT {
    private Date date;
    //private Calendar calendar;
    private int mcSec;

    public ClassDT(int year,int moth,int day, int hour, int min, int sec, int msec,int mcsec){
        date = new Date(year,moth,day,hour,min,sec);
        date.setTime(date.getTime()+msec);
        mcSec = mcsec;
    }

    @Deprecated
    public ClassDT(){
        date = new Date();
        mcSec=0;
    }
    @Deprecated
    public ClassDT(long dat,int mcsec){
        date = new Date(dat);
        mcSec=mcsec;
    }

    public String toString1metod(){
        return Integer.toString(date.getDate())+"."+Integer.toString(date.getMonth())+"   "+Integer.toString(date.getHours())+" ч "+Integer.toString(date.getMinutes())+" м "+Integer.toString(date.getSeconds())+" c "+Long.toString(date.getTime()%1000)+" мс "+Integer.toString(mcSec)+" мкс";
    }

    public String toString234metod() {
        int doli = (int)(date.getTime()%1000)/100;
        return Integer.toString(date.getDate())+"."+Integer.toString(date.getMonth())+"   "+Integer.toString(date.getHours())+" ч "+Integer.toString(date.getMinutes())+" м "+Integer.toString(date.getSeconds())+","+Integer.toString(doli)+" c ";
    }
    public ClassDT add(int year,int moth,int day, int hour, int min, double sec, double msec,double mcsec){
        double dd = msec%1*1000;
        int mcSec1=(int)(mcSec+mcsec+dd);
        long mSec =  (long) (mcSec/1000 +msec);
        mcSec1 = mcSec1%1000;
        return new ClassDT(date.getTime()+(int)(mSec+sec*1000+min*60*1000+hour*60*60*1000+day*24*60*60*1000),mcSec1);
    }

    public long getTime(){
        return date.getTime();
    }
    public int getTimemcSec(){
        return mcSec;
    }

    public int Compare(ClassDT date2){
        long  result= date.getTime()-date2.getTime();
        if(result == 0){
            result=mcSec - date2.getTimemcSec();
        }
        return (int)result;
    }
}
