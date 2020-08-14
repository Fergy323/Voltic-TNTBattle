package net.volticmc.tntbattle.game.map;

import de.leonhard.storage.Yaml;
import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.utils.FileManager;
import net.volticmc.tntbattle.utils.LocationSerializer;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapManager {

    private final TNTBattle main;

    private final List<TNTMap> maps = new ArrayList<>();

    public MapManager(TNTBattle tntBattle){
        main = tntBattle;
    }

    public TNTMap chooseMap(){
        Random random = new Random();

        int index = random.nextInt(maps.size());

        return maps.get(index);
    }

    public void registerMaps(){
        File directoryPath = new File(FileManager.FileDirectories.MAPS.getPath());
        File[] filesList = directoryPath.listFiles();
        ArrayList<Yaml> mapFiles = new ArrayList<>();
        if(filesList.length > 0){
            for(File file : filesList) {
                String extension = FilenameUtils.getExtension(file.getName());
                if(extension.equals("yml")){
                    mapFiles.add(new Yaml(FilenameUtils.getBaseName(file.getName()), FileManager.FileDirectories.MAPS.getPath()));
                }
            }
            LocationSerializer locSerializer = new LocationSerializer();
            for(Yaml file : mapFiles){
                World world = Bukkit.getServer().getWorld(file.getString("world"));
                Location lobbySpawn = locSerializer.deserializeFromString(file.getString("lobbyLocation"));
                List<Location> spawnLocations = new ArrayList<>();
                for(String s : file.getStringList("spawnLocations")){
                    spawnLocations.add(locSerializer.deserializeFromString(s));
                }

                maps.add(new TNTMap(file.getString("name"), lobbySpawn, spawnLocations, world));
            }
        }
    }
}
