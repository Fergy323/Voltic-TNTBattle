package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.player.TNTPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class GameManager implements Listener {

    private final TNTBattle main;
    private TNTBattleGame game;
    private boolean waiting;

    public GameManager(TNTBattle tntBattle) {
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        main = tntBattle;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(waiting) {
            main.getPlayerManager().addPlayer(new TNTPlayer(event.getPlayer()));
            if (main.getPlayerManager().getPlayers().size() == main.getPlayerManager().getSlots()) {
                BukkitRunnable startRunnable = new BukkitRunnable() {
                    int secondsLeft = 5;

                    @Override
                    public void run() {
                        secondsLeft--;
                        Bukkit.broadcastMessage("§aGame starting in §f" + secondsLeft + " §aseconds!");
                        if (secondsLeft == 0) {
                            game = new TNTBattleGame(main);
                            game.start();
                            this.cancel();
                        }
                    }
                };
                startRunnable.runTaskTimer(main, 0, 20L);
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(waiting) {
            main.getPlayerManager().removePlayer(main.getPlayerManager().getPlayer(e.getPlayer()));
        }
    }
}
