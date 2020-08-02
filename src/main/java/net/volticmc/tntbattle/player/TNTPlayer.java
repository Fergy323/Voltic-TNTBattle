package net.volticmc.tntbattle.player;

import net.volticmc.tntbattle.game.items.GameItem;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TNTPlayer {

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

    public void give(GameItem gameItem){
    }

}
