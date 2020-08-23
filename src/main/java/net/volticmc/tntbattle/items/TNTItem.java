package net.volticmc.tntbattle.items;

import net.volticmc.tntbattle.utils.SingletonEventRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class TNTItem implements Listener {

    private SingletonEventRegister eventRegister;

    public TNTItem(SingletonEventRegister eventRegister){
        this.eventRegister = eventRegister;
        eventRegister.registerEvents(this);
    }

    public abstract String getName();

    public abstract ItemStack getItem();

    @EventHandler
    public abstract void onBlockPlace(BlockPlaceEvent event);

    public void addToInventory(Inventory inventory){
        inventory.setItem(0, getItem());
    }

    public SingletonEventRegister getEventRegister() {
        return eventRegister;
    }
}
