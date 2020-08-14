package net.volticmc.tntbattle.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationSerializer {

    public LocationSerializer(){}

    public String serializeToString(Location location){
        if(location == null){
            throw new NullPointerException("Location is null");
        }
        return location.getWorld().getName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch() ;
    }

    public Location deserializeFromString(String s){
        if(s == null){
            throw new NullPointerException("String is null");
        }
        if(s.trim().equals("")){
            throw new IllegalArgumentException();
        }

        String[] locations = s.split(":");
        if(locations.length == 6){
            World world = Bukkit.getServer().getWorld(locations[0]);
            double x = Double.parseDouble(locations[1]);
            double y = Double.parseDouble(locations[2]);
            double z = Double.parseDouble(locations[3]);
            float yaw = Float.parseFloat(locations[4]);
            float pitch = Float.parseFloat(locations[5]);

            return new Location(world, x, y, z, yaw, pitch);
        }
        return null;
    }

}
