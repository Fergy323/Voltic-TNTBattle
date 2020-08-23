package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.map.TNTMap;
import net.volticmc.tntbattle.items.Items;
import net.volticmc.tntbattle.player.TNTPlayer;
import net.volticmc.tntbattle.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TNTBattleGame {

    private final TNTBattle main;
    private TNTMap map;

    public TNTBattleGame(TNTBattle tntBattle){
        main = tntBattle;
    }

    public TNTMap getMap() {
        return map;
    }

    public void setMap(TNTMap map) {
        this.map = map;
    }

    public void startCountdown(){
        BukkitRunnable startRunnable = new BukkitRunnable() {
            int secondsLeft = 5;

            @Override
            public void run() {
                if(main.getPlayerManager().getPlayers().size() < main.getPlayerManager().getSlots()){
                    Bukkit.broadcastMessage("§cNot enough players! Waiting for more.");
                    TNTState.setState(TNTState.WAITING);
                    this.cancel();
                    return;
                }
                TNTState.setState(TNTState.STARTING);
                secondsLeft--;
                if (secondsLeft == 0) {
                    start();
                    this.cancel();
                }
                Bukkit.broadcastMessage("§aGame starting in §f" + secondsLeft + " §aseconds!");
            }
        };
        startRunnable.runTaskTimer(main, 0, 20L);
    }


    public void start(){
        if(!TNTState.isState(TNTState.WAITING)) return;
        //TODO Add logic for starting game
        Bukkit.broadcastMessage("§a═══════════════════════════════════");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(ChatUtils.centerMessage("§a§lTNT BATTLE"));
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage(ChatUtils.centerMessage("§aBlow up as many enemies as you can by placing TNT near them!"));
        Bukkit.broadcastMessage(ChatUtils.centerMessage("§aHave the most kills by the end of the game to win!"));
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§a═══════════════════════════════════");
        TNTState.setState(TNTState.IN_GAME);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
            player.give(Items.FAST_FUSE.getItem());
        }
    }

    public void stop(){
        //TODO Add logic for stopping game
        if(TNTState.getState() != TNTState.IN_GAME) return;
        Bukkit.broadcastMessage("Game has stopped");
        TNTState.setState(TNTState.STOPPING);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        }
    }

    public void restart(){
        //TODO Add full restart logic
        if(TNTState.getState().nextState() != TNTState.RESTARTING) return;
        TNTState.setState(TNTState.getState().nextState());

        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().kickPlayer(null);
        }

        setMap(main.getMapManager().chooseMap());
        TNTState.setState(TNTState.WAITING);
    }

}
