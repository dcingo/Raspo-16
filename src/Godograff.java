public class Godograff {
    public Godograff(){
    }
    public double GetTimeVoln(double leng,int t){
        int i;
        for(i = 0;TablGod[i][0] <leng;i++ );
        double deltaR =leng-TablGod[i-1][0];
        double k = deltaR/50;
        double deltaT = TablGod[i][t]-TablGod[i-1][t];
        double Dt = deltaT*k;
        return TablGod[i-1][t]+Dt;
    }
    private double latPN=46.9833333;
    private double lonPN=142.7666667;
    private double latSGV=46.9855556;
    private double lonSGV=142.7616667;
    private double Radius = 6372795;
    private double SinRads(double Ugol){
        return Math.sin(Math.toRadians(Ugol));
    }
    private double CosRads(double Ugol){
        return Math.cos(Math.toRadians(Ugol));
    }
    public double lengtPN(double lat, double lon){
        return  Radius*Math.acos(SinRads(latPN)*SinRads(lat)+CosRads(latPN)*CosRads(lat)*CosRads(Math.abs(lonPN-lon)))/1000;
    }
    public double lengtSGV(double lat, double lon){
        return  Radius*Math.acos(SinRads(latSGV)*SinRads(lat)+CosRads(latSGV)*CosRads(lat)*CosRads(Math.abs(lonSGV-lon)))/1000;
    }
    public void setPN(double lat,double lon){
        latPN = lat;
        lonPN = lon;
    }
    public void setSGV(double lat,double lon) {
        latSGV = lat;
        lonSGV = lon;
    }
        public double[][] TablGod = {{0,0,0,0,0},
            {50,13,22,0,0},
            {100,19,33,28,33},
            {150,25.5,44,42,49.5},
            {200,32,55,56,66},
            {250,38.5,67,70.5,82.5},
            {300,45,79,85,99},
            {350,51.5,90,99.5,116},
            {400,58,101,114,133},
            {450,64,112.5,128,149.5},
            {500,70,124,142,166},
            {550,76.5,135,156,183},
            {600,83,146,170,200},
            {650,89.5,157.5,184.5,217},
            {700,96,169,199,234},
            {750,102,180,213.5,250},
            {800,108,191,228,266},
            {850,114.5,202.5,242,282.5},
            {900,121,214,256,299},
            {950,127,225,270,315},
            {1000,133,236,284,331},
            {1050,139.5,247.5,298.5,348.5},
            {1100,146,259,313,366},
            {1150,152.5,270,327,382.5},
            {1200,159,281,341,399},
            {1250,165.5,293,355.5,415.5},
            {1300,172,305,370,432},
            {1350,178,315.5,384.5,448.5},
            {1400,184,326,399,465},
            {1450,189.5,336.5,410.5,481.5},
            {1500,195,347,422,498},
            {1550,201,357.5,435.5,514.5},
            {1600,207,368,449,531},
            {1650,212.5,378,465.5,548},
            {1700,218,389,484,565},
            {1750,224,399.5,499,583},
            {1800,230,410,514,601},
            {1850,236,421,528.5,617},
            {1900,242,432,543,633},
            {1950,247.5,442,557,650},
            {2000,252.9,451.2,569.9,666},
            {2050,258,461.2,584.2,682.7},
            {2100,263,471.3,598.4,699.4},
            {2150,268,481.2,612.7,716},
            {2200,272.9,491.2,627,732.7},
            {2250,277.7,504.8,641.2,748.1},
            {2300,282.6,512.8,655.5,764.7},
            {2350,287.3,520.8,669.8,781.3},
            {2400,292.1,528.8,684,798},
            {2450,296.1,536.7,698.3,814.6},
            {2500,301.4,544.6,712.6,831.2},
            {2550,306,552.4,726.8,847.9},
            {2600,310.5,560.2,741.1,864.5},
            {2650,315.1,567.9,755.4,881.1},
            {2700,319.5,575.6,769.6,897.8},
            {2750,324,583.2,783.9,914.4},
            {2800,328.3,590.9,798.2,931},
            {2850,332.7,598.4,812.5,947.7},
            {2900,337,606,826.7,964.3},
            {2950,341.3,613.5,841,981},
            {3000,345.5,621,855.3,997.6},
            {3050,349.7,628.4,869.5,1014.2},
            {3100,353.9,635.8,883.8,1030.9},
            {3150,358,643.2,898.1,1047.5},
            {3200,362.1,650.5,912.3,1064.1},
            {3250,366.1,657.8,926.6,1080.8},
            {3300,370.2,665.1,940.9,1097.4},
            {3350,374.1,672.3,955.1,1114.1},
            {3400,378.1,679.5,969.1,1130.7},
            {3450,382,686.7,983.7,1147.3},
            {3500,385.9,693.8,997.9,1164},
            {3550,389.7,701,1012.2,1180.6},
            {3600,393.5,708,1026.5,1197.3},
            {3650,397.3,715.1,1040.7,1213.9},
            {3700,401.1,722.2,1055,1230.5},
            {3750,404.8,729.2,1069.3,1247.2},
            {3800,408.5,736.2,1083.6,1263.8},
            {3850,412.1,743.1,1097.8,1280.5},
            {3900,415.4,750,1112.1,1297.1},
            {3950,419.4,757,1126.4,1313.8},
            {4000,423.5,763.8,1140.6,1330.4},
            {4050,427.5,770.7,1154.9,1347},
            {4100,431.5,777.5,1169.2,1363.7},
            {4150,435.5,784.4,1183.4,1380.3},
            {4200,439.5,791.2,1197.7,1397},
            {4250,443.4,797.9,1212,1413.6},
            {4300,447.4,804.7,1226.2,1430.3},
            {4350,451.3,811.4,1240.5,1446.9},
            {4400,455.1,818.1,1254.8,1463.6},
            {4450,459,824.8,1269,1480.2},
            {4500,462.8,831.4,1283.3,1496.9},
            {4550,466.6,838.1,1297.6,1513.5},
            {4600,470.4,844.7,1311.8,1530.2},
            {4650,474.2,851.3,1326.1,1546.8},
            {4700,477.9,857.9,1340.4,1563.5},
            {4750,481.6,864.4,1354.7,1580.1},
            {4800,485.3,871,1368.9,1596.8},
            {4850,489,877.5,1383.2,1613.4},
            {4900,492.7,884,1397.5,1630.1},
            {4950,496.3,890.5,1411.7,1646.7},
            {5000,500,897,1426,1663.4},
            {5050,503.6,903.4,1440.3,1680},
            {5100,507.1,909.8,1454.5,1696.7},
            {5150,510.7,916.3,1468.8,1713.3},
            {5200,514.2,922.6,1483.1,1730},
            {5250,517.8,929,1497.3,1746.6},
            {5300,521.3,935.4,1511.6,1763.3},
            {5350,524.7,941.7,1525.9,1779.9},
            {5400,528.2,948.1,1540.1,1796.6},
            {5450,531.6,954.4,1554.4,1813.2},
            {5500,535.1,960.7,1568.7,1829.9},
            {5550,538.5,966.9,1582.9,1846.5},
            {5600,541.9,973.2,1597.2,1863.2},
            {5650,545.2,979.5,1611.5,1879.9},
            {5700,548.6,985.7,1625.8,1896.5},
            {5750,551.9,991.9,1640,1913.2},
            {5800,555.3,998.1,1654.3,1929.8},
            {5850,558.6,1004.3,1668.6,1946.5},
            {5900,561.8,1010.5,1682.8,1963.1},
            {5950,565.1,1016.6,1697.1,1979.8},
            {6000,568.3,1022.8,1711.4,1996.5},
            {6050,571.6,1028.9,1725.6,2013.1},
            {6100,574.8,1035,1739.9,2029.8},
            {6150,578,1041.1,1754.2,2046.4},
            {6200,581.2,1047.2,1768.4,2063.1},
            {6250,584.3,1053.3,1782.7,2079.8},
            {6300,587.5,1059.3,1797,2096.4},
            {6350,590.6,1065.4,1811.2,2113.1},
            {6400,593.7,1071.4,1825.5,2129.7},
            {6450,596.8,1077.4,1839.8,2146.4},
            {6500,599.9,1083.4,1854,2163.1},
            {6550,603,1089.4,1868.3,2179.7},
            {6600,606,1095.4,1882.6,2196.4},
            {6650,609.1,1101.4,1896.8,2213},
            {6700,612.1,1102.8,1911.1,2229.7},
            {6750,615.1,1108.9,1925.4,2246.4},
            {6800,618.1,1115,1939.7,2263},
            {6850,621.1,1121.1,1953.9,2279.7},
            {6900,624,1127.1,1968.2,2296.4},
            {6950,627,1133,1982.5,2313},
            {7000,629.9,1138.9,1996.7,2329.7},
            {7050,632.8,1144.8,2011,2346.4},
            {7100,635.7,1150.7,2025.3,2363},
            {7150,638.6,1156.4,2039.5,2379.7},
            {7200,641.5,1162.2,2053.8,2396.4},
            {7250,644.3,1167.9,2068.1,2413},
            {7300,647.2,1173.6,2082.3,2429.7},
            {7350,650,1179.2,2096.6,2446.4},
            {7400,652.8,1184.8,2110.9,2463},
            {7450,655.6,1190.4,2125.1,2479.7},
            {7500,658.4,1195.9,2139.4,2496.4},
            {7550,661.2,1201.4,2153.7,2513},
            {7600,664,1206.8,2167.9,2529.7},
            {7650,666.7,1212.2,2182.2,2546.4},
            {7700,669.5,1217.6,2196.5,2563},
            {7750,672.2,1223,2210.8,2579.7},
            {7800,674.9,1228.3,2225,2596.4},
            {7850,677.6,1233.5,2239.3,2613.1},
            {7900,680.3,1238.8,2253.6,2629.7},
            {7950,682.9,1244,2267.8,2646.4},
            {8000,685.6,1249.2,2282.1,2663.1},
            {8050,688.2,1254.3,2296.4,2679.7},
            {8100,690.9,1259.4,2310.6,2696.4},
            {8150,693.5,1264.5,2324.9,2713.1},
            {8200,696.1,1269.6,2339.2,2729.8},
            {8250,698.7,1274.6,2353.4,2746.4},
            {8300,701.3,1279.6,2367.7,2763.1},
            {8350,703.9,1284.5,2382,2779.8},
            {8400,706.4,1289.5,2396.2,2796.5},
            {8450,709,1294.4,2410.5,2813.1},
            {8500,711.5,1299.2,2424.8,2829.8},
            {8550,714,1304.1,2439,2846.5},
            {8600,716.5,1308.9,2453.3,2863.2},
            {8650,719,1313.7,2467.6,2879.8},
            {8700,721.5,1318.4,2481.9,2896.5},
            {8750,724,1323.2,2496.1,2913.2},
            {8800,726.5,1327.9,2510.4,2929.9},
            {8850,728.9,1332.5,2524.7,2946.6},
            {8900,731.4,1337.2,2538.9,2963.2},
            {8950,733.8,1341.8,2553.2,2979.9},
            {9000,736.2,1346.4,2567.5,2996.6},
            {9050,738.6,1351,2581.7,3013.3},
            {9100,741,1355.5,2596,3030},
            {9150,743.4,1360.1,2610.3,3046.6},
            {9200,745.8,1364.5,2624.5,3063.3},
            {9250,748.2,1369,2638.8,3080},
            {9300,750.5,1373.5,2653.1,3096.7},
            {9350,752.9,1377.9,2667.3,3113.4},
            {9400,755.2,1382.3,2681.6,3130},
            {9450,757.5,1386.7,2695.9,3146.7},
            {9500,759.8,1391,2710.1,3163.4},
            {9550,762.1,1395.4,2724.4,3180.1},
            {9600,764.4,1399.7,2738.7,3196.8},
            {9650,766.7,1404,2753,3213.5},
            {9700,769,1408.2,2767.2,3230.1},
            {9750,771.3,1412.5,2781.5,3246.8},
            {9800,773.5,1416.7,2795.8,3263.5},
            {9850,775.8,1420.9,2810,3280.2},
            {9900,778,1425.1,2824.3,3296.9},
            {9950,780.2,1429.2,2838.6,3313.6},
            {10000,782.4,1433.4,2852.8,3330.3},
            {10050,784.6,1437.5,2867.1,3346.9},
            {10100,786.8,1441.6,2881.4,3363.6},
            {10150,789,1445.7,2895.6,3380.3},
            {10200,791.2,1449.7,2909.9,3397},
            {10250,793.4,1453.8,2924.2,3413.7},
            {10300,795.5,1457.8,2938.4,3430.4},
            {10350,797.7,1461.8,2952.7,3447.1},
            {10400,799.8,1465.8,2967,3463.8},
            {10450,802,1469.7,2981.2,3480.5},
            {10500,804.1,1473.7,2995.5,3497.1},
            {10550,806.2,1477.6,3009.8,3513.8},
            {10600,808.3,1481.5,3024.1,3530.5},
            {10650,810.4,1485.4,3038.3,3547.2},
            {10700,812.5,1489.2,3052.6,3563.9},
            {10750,814.6,1493.1,3066.9,3580.6},
            {10800,816.6,1496.9,3081.1,3597.3},
            {10850,818.7,1500.7,3095.4,3614},
            {10900,820.7,1504.5,3109.7,3630.7},
            {10950,822.8,1508.3,3123.9,3647.4},
            {11000,824.8,1512.1,3138.2,3664.1},
            {11050,826.8,1515.8,3152.5,3680.8},
            {11100,828.9,1519.5,3166.7,3697.5},
            {11150,830.8,1523.2,3181,3714.2},
            {11200,832.9,1526.9,3195.3,3730.8},
            {11250,834.9,1530.6,3209.5,3747.5},
            {11300,836.8,1534.3,3223.8,3764.2},
            {11350,838.8,1537.9,3238.1,3780.9},
            {11400,840.8,1541.5,3252.3,3797.6},
            {11450,842.7,1545.2,3266.6,3814.3},
            {11500,844.7,1548.8,3280.9,3831},
            {11550,846.6,1552.3,3295.1,3847.7},
            {11600,848.6,1555.9,3309.4,3864.4},
            {11650,850.5,1559.5,3323.7,3881.1},
            {11700,1104.3,-1,-1,3897.8},
            {11750,1105.1,-1,-1,3914.5},
            {11800,1105.9,-1,-1,3931.2},
            {11850,1106.7,-1,-1,3947.9},
            {11900,1107.5,-1,-1,3964.6},
            {11950,1108.3,-1,-1,3981.3},
            {12000,1109.1,-1,-1,3998},
            {12050,1109.9,-1,-1,4014.7},
            {12100,1110.7,-1,-1,4031.4},
            {12150,1111.5,-1,-1,4048.1},
            {12200,1112.3,-1,-1,4064.8},
            {12250,1113.6,-1,-1,4081.5},
            {12300,1114.5,-1,-1,4098.2},
            {12350,1115.3,-1,-1,4114.9},
            {12400,1116.2,-1,-1,4131.6},
            {12450,1117.1,-1,-1,4148.3},
            {12500,1118,-1,-1,4165},
            {12550,1118.8,-1,-1,4181.8},
            {12600,1119.7,-1,-1,4198.5},
            {12650,1120.6,-1,-1,4215.2},
            {12700,1121.5,-1,-1,4231.9},
            {12750,1122.3,-1,-1,4248.6},
            {12800,1123.2,-1,-1,4265.3},
            {12850,1124.1,-1,-1,4282},
            {12900,1124.9,-1,-1,4298.7},
            {12950,1125.8,-1,-1,4315.4},
            {13000,1126.7,-1,-1,4332.1},
            {13050,1127.6,-1,-1,4348.8},
            {13100,1128.4,-1,-1,4365.5},
            {13150,1129.3,-1,-1,4382.2},
            {13200,1130.2,-1,-1,4398.9},
            {13250,1131.1,-1,-1,4415.7},
            {13300,1131.9,-1,-1,4432.4},
            {13350,1132.8,-1,-1,4449.1},
            {13400,1133.7,-1,-1,4465.8},
            {13450,1134.5,-1,-1,4482.5},
            {13500,1135.4,-1,-1,4499.2},
            {13550,1136.3,-1,-1,4515.9},
            {13600,1137.2,-1,-1,4532.6},
            {13650,1138,-1,-1,4549.3},
            {13700,1138.9,-1,-1,4566.1},
            {13750,1139.8,-1,-1,4582.8},
            {13800,1140.7,-1,-1,4599.5},
            {13850,1141.5,-1,-1,4616.2},
            {13900,1142.4,-1,-1,4632.9},
            {13950,1143.3,-1,-1,4649.6},
            {14000,1144.2,-1,-1,4666.3},
            {14050,1145,-1,-1,4683.1},
            {14100,1145.9,-1,-1,4699.8},
            {14150,1146.7,-1,-1,4716.5},
            {14200,1147.6,-1,-1,4733.2},
            {14250,1148.5,-1,-1,4749.9},
            {14300,1149.3,-1,-1,4766.6},
            {14350,1150.2,-1,-1,4783.4},
            {14400,1151.1,-1,-1,4800.1},
            {14450,1151.9,-1,-1,4816.8},
            {14500,1152.8,-1,-1,4833.5},
            {14550,1153.6,-1,-1,4850.2},
            {14600,1154.5,-1,-1,4867},
            {14650,1155.3,-1,-1,4883.7},
            {14700,1156.2,-1,-1,4900.4},
            {14750,1157,-1,-1,4917.1},
            {14800,1157.8,-1,-1,4933.8},
            {14850,1158.7,-1,-1,4950.6},
            {14900,1159.5,-1,-1,4967.3},
            {14950,1160.3,-1,-1,4984},
            {15000,1161.2,-1,-1,5000.7},
            {15050,1162,-1,-1,5017.4},
            {15100,1162.8,-1,-1,5034.2},
            {15150,1163.6,-1,-1,5050.9},
            {15200,1164.5,-1,-1,5067.6},
            {15250,1165.4,-1,-1,5084.3},
            {15300,1166.3,-1,-1,5101.1},
            {15350,1167.1,-1,-1,5117.8},
            {15400,1167.9,-1,-1,5134.5},
            {15450,1168.7,-1,-1,5151.2},
            {15500,1169.5,-1,-1,5168},
            {15550,1170.3,-1,-1,5184.7},
            {15600,1171.1,-1,-1,5201.4},
            {15650,1171.9,-1,-1,5218.1},
            {15700,1172.7,-1,-1,5234.9},
            {15750,1173.5,-1,-1,5251.6},
            {15800,1174.2,-1,-1,5268.3},
            {15850,1175,-1,-1,5285.1},
            {15900,1175.8,-1,-1,5301.8},
            {15950,1176.5,-1,-1,5318.5},
            {16000,1177.3,-1,-1,5335.2},
            {16050,1178.1,-1,-1,5352},
            {16100,1178.8,-1,-1,5368.7},
            {16150,1179.5,-1,-1,5385.4},
            {16200,1180.3,-1,-1,5402.2},
            {16250,1181,-1,-1,5418.9},
            {16300,1181.7,-1,-1,5435.6},
            {16350,1182.5,-1,-1,5452.4},
            {16400,1183.2,-1,-1,5469.1},
            {16450,1183.9,-1,-1,5485.8},
            {16500,1184.6,-1,-1,5502.6},
            {16550,1185.3,-1,-1,5519.3},
            {16600,1186,-1,-1,5536},
            {16650,1186.7,-1,-1,5552.8},
            {16700,1187.4,-1,-1,5569.5},
            {16750,1188.1,-1,-1,5586.2},
            {16800,1188.8,-1,-1,5603},
            {16850,1189.5,-1,-1,5619.7},
            {16900,1190.1,-1,-1,5636.4},
            {16950,1190.8,-1,-1,5653.2},
            {17000,1191.5,-1,-1,5669.9},
            {17050,1192.2,-1,-1,5686.6},
            {17100,1192.8,-1,-1,5703.4},
            {17150,1193.5,-1,-1,5720.1},
            {17200,1194.1,-1,-1,5736.9},
            {17250,1194.8,-1,-1,5753.6},
            {17300,1195.4,-1,-1,5770.3},
            {17350,1196.1,-1,-1,5787.1},
            {17400,1196.7,-1,-1,5803.8},
            {17450,1197.3,-1,-1,5820.5},
            {17500,1198,-1,-1,5837.3},
            {17550,1198.6,-1,-1,5854},
            {17600,1200.7,-1,-1,5870.8},
            {17650,1201,-1,-1,5887.5},
            {17700,1201.3,-1,-1,5904.3},
            {17750,1201.6,-1,-1,5921},
            {17800,1202,-1,-1,5937.7},
            {17850,1202.3,-1,-1,5954.5},
            {17900,1202.6,-1,-1,5971.2},
            {17950,1202.9,-1,-1,5988},
            {18000,1203.2,-1,-1,6004},
            {18050,1203.5,-1,-1,6021},
            {18100,1203.9,-1,-1,6038},
            {18150,1204.2,-1,-1,6054},
            {18200,1204.5,-1,-1,6071},
            {18250,1204.8,-1,-1,6088},
            {18300,1205.1,-1,-1,6105},
            {18350,1205.4,-1,-1,6121},
            {18400,1205.7,-1,-1,6138},
            {18450,1206,-1,-1,6155},
            {18500,1206.3,-1,-1,6172},
            {18550,1206.6,-1,-1,6188},
            {18600,1206.9,-1,-1,6205},
            {18650,1207.2,-1,-1,6222},
            {18700,1207.4,-1,-1,6239},
            {18750,1207.7,-1,-1,6255},
            {18800,1208,-1,-1,6272},
            {18850,1208.3,-1,-1,6289},
            {18900,1208.6,-1,-1,6306},
            {18950,1208.9,-1,-1,6322},
            {19000,1209.2,-1,-1,6339},
            {19050,1209.4,-1,-1,6356},
            {19100,1209.7,-1,-1,6373},
            {19150,1210,-1,-1,6389},
            {19200,1210.3,-1,-1,6406},
            {19250,1210.5,-1,-1,6423},
            {19300,1210.8,-1,-1,6440},
            {19350,1211.1,-1,-1,6456},
            {19400,1211.3,-1,-1,6473},
            {19450,1211.6,-1,-1,6490},
            {19500,1211.9,-1,-1,6507},
            {19550,1212.1,-1,-1,6523},
            {19600,1212.4,-1,-1,6540},
            {19650,1212.7,-1,-1,6557},
            {19700,1212.9,-1,-1,6574},
            {19750,1213.2,-1,-1,6591},
            {19800,1213.5,-1,-1,6607},
            {19850,1213.7,-1,-1,6624},
            {19900,1214,-1,-1,6641},
            {19950,1214.2,-1,-1,6658}};
}