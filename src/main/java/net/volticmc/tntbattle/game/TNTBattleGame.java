package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.player.TNTPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TNTBattleGame implements Listener {

    private TNTBattle main;
    //private TNTMap map;

    public TNTBattleGame(TNTBattle tntBattle){
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        main = tntBattle;
    }

    public void start(){
        //TODO Add logic for starting game
        Bukkit.broadcastMessage("Game has started");
        TNTState.setState(TNTState.IN_GAME);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        }
    }

    public void stop(){
        //TODO Add logic for stopping game
        Bukkit.broadcastMessage("Game has stopped");
        TNTState.setState(TNTState.STOPPING);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        }
    }

}
