package net.volticmc.tntbattle.player;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
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
        return slots - players.size();
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

    public void addPlayer(Player player){
        TNTPlayer tntPlayer = new TNTPlayer(player);
        players.add(tntPlayer);
        if(TNTState.getState() == TNTState.WAITING) {
            Bukkit.broadcastMessage(tntPlayer.getName() + " §ahas joined! §7(§f" + players.size() + "/" + slots + "§7)");
        }else{
            Bukkit.broadcastMessage(tntPlayer.getName() + "§a has joined!");
        }
    }

    public void removePlayer(Player player){
        TNTPlayer tntPlayer = getPlayer(player);
        players.remove(tntPlayer);
        for(TNTPlayer players : players){
            Bukkit.getLogger().info(players.getName());
        }
        if(TNTState.getState() == TNTState.WAITING) {
            Bukkit.broadcastMessage(tntPlayer.getName() + "§a has left! §7(§f" + players.size() + "/" + slots + "§7)");
        }else{
            Bukkit.broadcastMessage(tntPlayer.getName() + "§a has left!");
        }
    }

    public void savePlayer(TNTPlayer tntPlayer){
        //TODO Add MongoDB class and logic for saving player data
    }

}
