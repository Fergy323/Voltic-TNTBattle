package net.volticmc.tntbattle.utils;

import de.leonhard.storage.Yaml;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class FileManager {


    public enum FileDirectories{

        DATA_FOLDER("plugins/VolticTNT"), MAPS("plugins/VolticTNT/maps");

        private String path;

        FileDirectories(String path) {
            this.path = path;
        }

        public String getPath(){
            return path;
        }
    }

    public void setMaps(){
        Yaml yaml = new Yaml("example_map", FileDirectories.MAPS.getPath());

        Location location = new Location(Bukkit.getServer().getWorld("world"), -36.69, 104.00, -128.21, 94, -19);

        LocationSerializer locationSerializer = new LocationSerializer();

        List<String> locations = new ArrayList<>();
        locations.add(locationSerializer.serializeToString(location));

        yaml.set("name", "example");
        yaml.set("world", "world");
        yaml.set("lobbyLocation", "world:-36.69:104.00:-128.21:94:-19");
        yaml.set("spawnLocations", locations);
    }

}
