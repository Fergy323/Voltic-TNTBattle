package net.volticmc.tntbattle.game.map;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;

public class TNTMap {

    private String name;
    private Location lobbySpawn;
    private List<Location> spawnLocations;
    private World mapWorld;

    public TNTMap(String name, Location lobbySpawn, List<Location> spawnLocations, World mapWorld){
        this.name = name;
        this.lobbySpawn = lobbySpawn;
        this.spawnLocations = spawnLocations;
        this.mapWorld = mapWorld;
    }

    public String getName() {
        return name;
    }

    public Location getLobbySpawn() {
        return lobbySpawn;
    }

    public List<Location> getSpawnLocations() {
        return spawnLocations;
    }

    public World getMapWorld() {
        return mapWorld;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLobbySpawn(Location lobbySpawn) {
        this.lobbySpawn = lobbySpawn;
    }

    public void setMapWorld(World mapWorld) {
        this.mapWorld = mapWorld;
    }

    public void setSpawnLocations(List<Location> spawnLocations) {
        this.spawnLocations = spawnLocations;
    }
}
