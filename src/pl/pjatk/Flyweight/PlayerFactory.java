package pl.pjatk.Flyweight;

import java.util.HashMap;

public class PlayerFactory {
    private static HashMap<String, Player> hm = new HashMap<>();

    public static Player getPlayer(String type){
        Player p = null;

        if(hm.containsKey(type))
            p = hm.get(type);
        else{
            switch(type){
                case "Terrorist":
                    System.out.println("Terrorist created");
                    p = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("CounterTerrorist created");
                    p = new CounterTerrorist();
                    break;
                default:
                    System.out.println("Unreachable code!");
            }
            hm.put(type,p);
        }
        return p;
    }
}
