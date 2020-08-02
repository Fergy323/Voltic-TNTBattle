package net.volticmc.tntbattle.player;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private TNTBattle main;
    private int slots;
    private final List<TNTPlayer> players;

    public PlayerManager(TNTBattle tntBattle){
        main = tntBattle;
        players = new ArrayList<>();
        slots = 20;
    }

    public List<TNTPlayer> getPlayers() {
        return players;
    }

    public int getRemainingSlots(){
        return players.size() - slots;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public TNTPlayer getPlayer(Player player){
         for(TNTPlayer tntPlayer : players){
             if(tntPlayer.getName().equals(player.getName())){
                 return tntPlayer;
             }
         }
         return null;
    }

    public void addPlayer(TNTPlayer tntPlayer){
        players.add(tntPlayer);
        Bukkit.broadcastMessage(tntPlayer.getName() + " has joined! (" + getRemainingSlots() + "/" + slots + ")");
    }

    public void removePlayer(TNTPlayer tntPlayer){
        players.remove(tntPlayer);
        Bukkit.broadcastMessage(tntPlayer.getName() + " has left! (" + getRemainingSlots() + "/" + slots + ")");
    }

}
