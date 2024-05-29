package config;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Audit {
    private static Audit instance = null;
    private FileWriter fw;

    private Audit(){
        try{
            fw = new FileWriter("audit.csv");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static Audit getInstance(){
        if(instance == null){
            instance = new Audit();
        }
        return instance;
    }

    private String getTime(){
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        int ore, minute, secunde;
        ore = now.getHour();
        minute = now.getMinute();
        secunde = now.getSecond();

        return String.format("%02d:%02d:%02d", ore, minute, secunde);
    }

    public void write(String action, String message){
        try{
            fw.write(action + "," + getTime() + "," + message + "\n");
            fw.flush();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
