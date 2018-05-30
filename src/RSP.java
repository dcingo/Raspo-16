import sun.util.calendar.BaseCalendar;

import java.util.Date;

public class RSP {
    private class raion{
        private String name;
        private double lat;
        private double lon;
        private raion(String n, double x, double y){
            name = n;
            lat = x;
            lon = y;
        }
    }
    private raion[] Spisokrajon = new raion[12];
    private String nRSP;
    private ClassDT timeist;
    private Date now;
    private double lengthPN;
    private double peleng;
    public RSP(){
        Spisokrajon[0] = new raion("00",0,0);
        Spisokrajon[1] = new raion("07",37.100,116.017);
        Spisokrajon[2] = new raion("10",41.783,88.483);
        Spisokrajon[3] = new raion("11",21.883,138.900);
        Spisokrajon[4] = new raion("13",51.567,178.967);
        Spisokrajon[5] = new raion("14",30.000,34.833);
        Spisokrajon[6] = new raion("15",29.667,71.500);
        Spisokrajon[7] = new raion("16",28.033,65.100);
        Spisokrajon[8] = new raion("20",27.800,21.533);
        Spisokrajon[9] = new raion("21",26.800,70.233);
        Spisokrajon[10] = new raion("24",49.000,69.000);
        Spisokrajon[11] = new raion("30",41.083,128.967);
        now = new Date();
    }
    public ClassDT[][] AnalizRSP(String Rasporjenie){
        if(Rasporjenie.length() < 10){
            System.out.println("Ошибка в РСП");
            return null;
        }
        ClassDT[][] result = new ClassDT[7][2];
        for(int i =0;i<7;i++){
            result[i][0]=null;
            result[i][1]=null;
        }
        String[] s = Rasporjenie.split("-");
        if(s.length <1){
            System.out.println("Ошибка в РСП");
            return null;
        }
        String vid = s[s.length-1];
        String raionRSP = s[1].substring(0,2);
        if(((raionRSP.compareTo("00") == 0 && s.length != 7 )||(raionRSP.compareTo("00") != 0 && s.length == 7))&& vid.compareTo("222222")==0){
            System.out.println("Ошибка в РСП");
            return null;
        }
        double lat,lon;
        if(raionRSP.compareTo("00")==0) {
            lat = GeotoGrad(s[4]);
            lon = GeotoGrad(s[5]);
        }else{
            double[] d = GetCoordinatsRaion(raionRSP);
            lat =d[0];
            lon=d[1];
        }

        nRSP = s[0].substring(0,2);
        Godograff god = new Godograff();
        double length;
        int vidd = Integer.parseInt(vid);
        switch (vidd){
            case 111111:{

            }
            case 222222:{
                int month = Integer.parseInt(s[1].substring(4));
                int day = Integer.parseInt(s[1].substring(2,4));
                int hour = Integer.parseInt(s[2].substring(0,2));
                int min = Integer.parseInt(s[2].substring(2,4));
                int sec = Integer.parseInt(s[2].substring(4));
                int msec = Integer.parseInt(s[3].substring(0,3));
                int mcsec = Integer.parseInt(s[3].substring(3));
                int yaer = now.getYear();
                timeist = new ClassDT(yaer-((month>now.getMonth())?-1:0),month,day,hour,min,sec,msec,mcsec);
                length = god.lengtPN(lat,lon);
                lengthPN=length;
                peleng =50;
                if(s[0].charAt(2)=='1'){
                    double dt1 = length/300-3;
                    double dt2 = length/300+3;
                    if(length <1000) {
                        dt1 =0;
                        if(length <500){
                            dt2 = 2;
                        }
                    }
                    result[0][0] = timeist.add(0,0,0,0,0,0,dt1,0);//t1
                    result[0][1] = timeist.add(0,0,0,0,0,0,dt2,0);//t2
                }
                if(s[0].charAt(3)=='2'){
                    double length1= god.lengtSGV(lat,lon);
                    double dt1 = god.GetTimeVoln(length1,1)-30;
                    double dt2 = god.GetTimeVoln(length1,1)+30;
                    if(length1 <1000) {
                        dt1 =0;
                        if(length1 <500){
                            dt2 = 180;
                        }
                    }
                    result[1][0] = timeist.add(0,0,0,0,0,dt1,0,0);//t1
                    result[1][1] = timeist.add(0,0,0,0,0,dt2,0,0);//t2
                    dt1 = god.GetTimeVoln(length1,2)-40;
                    dt2 = god.GetTimeVoln(length1,2)+40;
                    if(length1 <1000) {
                        dt1 =0;
                        if(length1 <500){
                            dt2 = 180;
                        }
                    }
                    result[2][0] = timeist.add(0,0,0,0,0,dt1,0,0);//t1
                    result[2][1] = timeist.add(0,0,0,0,0,dt2,0,0);//t2
                    dt1 = god.GetTimeVoln(length1,2)-90;
                    dt2 = god.GetTimeVoln(length1,2)+90;
                    if(length1 <1000) {
                        dt1 =0;
                        if(length1 <500){
                            dt2 = 180;
                        }
                    }
                    result[3][0] = timeist.add(0,0,0,0,0,dt1,0,0);//t1
                    result[3][1] = timeist.add(0,0,0,0,0,dt2,0,0);//t2
                    dt1 = god.GetTimeVoln(length1,2)-110;
                    dt2 = god.GetTimeVoln(length1,2)+110;
                    if(length1 <1000) {
                        dt1 =0;
                        if(length1 <500){
                            dt2 = 180;
                        }
                    }
                    result[4][0] = timeist.add(0,0,0,0,0,dt1,0,0);//t1
                    result[4][1] = timeist.add(0,0,0,0,0,dt2,0,0);//t2
                }
                if(s[0].charAt(4)=='3'){
                    double dt1 = length/20.4-50;
                    double dt2 = length/16.5+50;
                    if(length <1000) {
                        dt1 =0;
                        if(length <500){
                            dt2 = 40;
                        }
                    }
                    result[5][0] = timeist.add(0,0,0,0,0,dt1*60,0,0);//t1
                    result[5][1] = timeist.add(0,0,0,0,0,dt2*60,0,0);//t2
                }
                if(s[0].charAt(5)=='4'){
                    double dt1 = -1;
                    double dt2 = 1;
                    if(length <1000) {
                        dt1 =0;
                    }
                    result[6][0] = timeist.add(0,0,0,0,0,dt1*60,0,0);//t1
                    result[6][1] = timeist.add(0,0,0,0,0,dt2*60,0,0);//t2
                }
            }
        }
        return result;
    }
    public double GeotoGrad(String strCoor){
        double znak=strCoor.charAt(0)==2?-1:1;
        return (Integer.parseInt(strCoor.substring(1,4))+Integer.parseInt(strCoor.substring(4,6))/60.0)*znak;
    }
    private double[] GetCoordinatsRaion(String RaionName){
        double[] result = {-1,-1};
        for (int i =0;i< Spisokrajon.length;i++){
            if( Spisokrajon[i].name.compareTo(RaionName) == 0){
                result[0] = Spisokrajon[i].lat;
                result[1] = Spisokrajon[i].lon;
                break;
            }
        }
        return result;
    }
    public double getLengthPN() {
        return lengthPN;
    }

}
