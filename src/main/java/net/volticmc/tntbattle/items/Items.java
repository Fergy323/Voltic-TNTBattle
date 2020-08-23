package net.volticmc.tntbattle.items;

import net.volticmc.tntbattle.TNTBattle;

public enum Items {

    FAST_FUSE(new FastFuse(TNTBattle.getEventRegister()));

    private final TNTItem item;

    Items(TNTItem item){
        this.item = item;
    }

    public TNTItem getItem() {
        return item;
    }
}
