import java.util.Arrays;
import java.lang.Comparable;

/**
 * Storage object for Loadshedding data. Takes the key value pair from a given line, storing key as schedule and value under zones.
 */
public class LSObj implements Comparable<LSObj> {
    private String schedule;
    private String zones;
    
    public LSObj(String sched, String zones){
        this.schedule = sched;
        this.zones = zones;
    }

    public int compareTo(LSObj other){
        return this.schedule.compareTo(other.schedule);
      }
    
    public String getSched(){
        return this.schedule;
    }
    
    public String getZones(){
        return "Zones to be loadshed: " + this.zones;
    }

    public String toString(){
        return Arrays.toString(schedule.split("_")) + " " + this.zones;
    }
}