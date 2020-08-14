package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TNTJoinListener extends TNTListener {


    public TNTJoinListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(TNTState.getState() == TNTState.WAITING) {
            event.getPlayer().teleport(getMain().getGame().getMap().getLobbySpawn());
            getMain().getPlayerManager().addPlayer(event.getPlayer());
            if (getMain().getPlayerManager().getPlayers().size() == getMain().getPlayerManager().getSlots()) {
                BukkitRunnable startRunnable = new BukkitRunnable() {
                    int secondsLeft = 5;

                    @Override
                    public void run() {
                        if(getMain().getPlayerManager().getPlayers().size() < getMain().getPlayerManager().getSlots()){
                            Bukkit.broadcastMessage("§cNot enough players! Waiting for more.");
                            TNTState.setState(TNTState.WAITING);
                            this.cancel();
                        }
                        TNTState.setState(TNTState.STARTING);
                        secondsLeft--;
                        if (secondsLeft == 0) {
                            getMain().getGame().start();
                            this.cancel();
                        }
                        Bukkit.broadcastMessage("§aGame starting in §f" + secondsLeft + " §aseconds!");
                    }
                };
                startRunnable.runTaskTimer(getMain(), 0, 20L);
            }
        }
    }
}