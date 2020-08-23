package net.volticmc.tntbattle.player;

import net.volticmc.tntbattle.items.TNTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TNTPlayer {

    //TODO Potion effects on respawn

    private final String name;
    private final UUID uuid;
    private int kills;
    private int deaths;
    private int xpGained;

    public TNTPlayer(Player player){
        this.name = player.getName();
        this.uuid = player.getUniqueId();
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }


    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public Player getPlayer(){
        return Bukkit.getServer().getPlayerExact(name);
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void addKill(){
        kills++;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeath(){
        deaths++;
    }

    public void give(TNTItem item){
        item.addToInventory(getPlayer().getInventory());
    }


}
