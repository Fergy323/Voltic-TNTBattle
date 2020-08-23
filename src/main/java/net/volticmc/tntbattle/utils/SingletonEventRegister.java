package net.volticmc.tntbattle.utils;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.event.Listener;

public class SingletonEventRegister {

    private TNTBattle main;

    public SingletonEventRegister(TNTBattle main){
        this.main = main;
    }

    public void registerEvents(Listener listener){
        main.getServer().getPluginManager().registerEvents(listener, main);
    }

    public TNTBattle getMain() {
        return main;
    }
}
