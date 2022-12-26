package jrkkrupicki.sheepterrorist;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SheepTerrorist extends JavaPlugin implements Listener {

    private float explosionPower = 4;
    private boolean explosionFire = true;
    private double explosionChance = 30;

    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        config.addDefault("explosionPower", explosionPower);
        config.addDefault("explosionFire", explosionFire);
        config.addDefault("explosionChance", explosionChance);
        config.options().copyDefaults(true);
        saveConfig();
        explosionPower = (float)config.getDouble("explosionPower");
        explosionFire = config.getBoolean("explosionFire");
        explosionChance = config.getDouble("explosionChance");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent event){
        Entity entity = event.getEntity();
        if(!entity.getType().equals(EntityType.SHEEP)) return;
        if(!RandomUtils.getChange(explosionChance)) return;
        entity.getLocation().getWorld().createExplosion(entity.getLocation(), explosionPower, explosionFire);
    }
}
