package ctx.cortexcore.PunishSystem.Units;

import java.util.ArrayList;
import java.util.List;

public enum MuteUnit {
    SECOND("Second(s)", 1, "sec"),
    MINUTE("Minute(s)", 60, "min"),
    HOUR("Hour(s)", 60*60, "hour"),
    DAY("Day(s)", 24*60*60, "day"),
    WEEK("Week(s)", 7*24*60*60, "week"),
    MONTH("Month(1)", 4*7*24*60*60, "Month"),
    YEAR("Year(s)", 12*4*7*24*60*60, "year");


    private final String  length;
    private final int    seconds;
    private final String   alias;


    MuteUnit(String length, int seconds, String alias) {
        this.length  = length;
        this.seconds = seconds;
        this.alias   = alias;
    }
    public String getAlias(){
        return alias;
    }
    public int getSeconds(){
        return seconds;
    }
    public String getLength(){
        return length;
    }
    public static List<String> getUnitAsString(){
        List<String> units = new ArrayList<>();
        for(MuteUnit unit : MuteUnit.values()){
            units.add(unit.alias.toLowerCase());
        }
        return units;
    }
    public static MuteUnit getBanUnit(String unit){
        for (MuteUnit units : MuteUnit.values()){
            if(units.alias.toLowerCase().equals(unit.toLowerCase())) {
                return units;
            }
        }
        return null;
    }
}
