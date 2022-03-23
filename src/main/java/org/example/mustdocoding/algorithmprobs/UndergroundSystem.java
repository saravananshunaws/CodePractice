package org.example.mustdocoding.algorithmprobs;

import java.util.*;
import java.math.*;
import java.io.*;

public class UndergroundSystem {

    static class TravelRecord{
        public int id;
        public String checkInStation;
        public String checkOutStation;
        public int checkInTime;
        public int checkOutTime;

        public TravelRecord(int id, String checkInStation, int time) {
            this.id = id;
            this.checkInStation = checkInStation;
            this.checkInTime = time;
        }
    }

    Map<Integer, TravelRecord> checkInMap = new HashMap<>();
    Map<Integer, TravelRecord> checkOutMap = new HashMap<>();

    public UndergroundSystem(){

    }

    public void checkIn(int id, String stationName, int t){
        checkInMap.put(id, new TravelRecord(id, stationName,  t));
    }

    public void checkOut(int id, String stationName, int t){
        TravelRecord travelRecord = checkInMap.get(id);
        travelRecord.checkOutStation = stationName;
        travelRecord.checkOutTime = t;
        checkInMap.put(id, travelRecord);
    }

    public double getAverageTime(String startStation, String endStation){

        int tavellerCount = 0;
        int timeTaken =0 ;
        for (Map.Entry<Integer, TravelRecord> entry: checkInMap.entrySet()) {
            if(entry.getValue().checkInStation.equals(startStation) &&
                    entry.getValue().checkOutStation.equals(endStation)){
                tavellerCount++;
                timeTaken +=  entry.getValue().checkOutTime  - entry.getValue().checkInTime;
            }
        }

        System.out.println("Start :: " + startStation + " , End :: " + endStation + " , Average :: " +  (timeTaken / tavellerCount));
        return (timeTaken / tavellerCount);
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
