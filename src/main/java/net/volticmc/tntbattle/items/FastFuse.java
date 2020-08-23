package net.volticmc.tntbattle.items;

import net.volticmc.tntbattle.utils.SingletonEventRegister;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

public class FastFuse extends TNTItem {

    public FastFuse(SingletonEventRegister eventRegister) {
        super(eventRegister);
    }

    @Override
    public String getName() {
        return "§cFast Fuse";
    }

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.TNT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(getName());
        item.setItemMeta(meta);

        return item;
    }

    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getItemInHand().getItemMeta().getDisplayName().equals(getName())){
            TNTPrimed tntPrimed = (TNTPrimed) event.getPlayer().getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
            tntPrimed.setFuseTicks(10);
            tntPrimed.setMetadata(event.getPlayer().getName(), new FixedMetadataValue(getEventRegister().getMain(), event.getPlayer().getName()));
        }
    }
}
