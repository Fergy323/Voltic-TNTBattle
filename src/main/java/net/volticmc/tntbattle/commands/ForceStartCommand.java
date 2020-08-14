package net.volticmc.tntbattle.commands;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTBattleGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ForceStartCommand implements CommandExecutor {

    private TNTBattle main;

    public ForceStartCommand(TNTBattle tntBattle){
        main = tntBattle;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        TNTBattleGame game = main.getGame();

        game.start();

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, game::stop, 1200);

        return true;
    }
}
