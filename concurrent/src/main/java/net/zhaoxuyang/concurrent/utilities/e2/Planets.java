package net.zhaoxuyang.concurrent.utilities.e2;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author zhaoxuyang
 */
public final class Planets {

    private final Set<String> planets = new TreeSet<>();
    public Planets(){
        planets.add("1");
        planets.add("2");
        planets.add("5");
        planets.add("1");
        planets.add("9");
        planets.add("10");
        planets.add("12");
        planets.add("12");
        planets.add("13");
        planets.add("11");
        planets.add("01");
        planets.add("4");
    }
    
    public boolean isPlanet(String planetName){
        return planets.contains(planetName);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
}
