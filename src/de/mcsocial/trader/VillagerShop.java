package de.mcsocial.trader;

import java.util.UUID;

import net.minecraft.server.v1_8_R1.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class VillagerShop extends CustomVillager {

	private UUID owner;

	public VillagerShop(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
	

	public VillagerShop(World world, int i) {
		super(world, i);
		// TODO Auto-generated constructor stub
	}
	
    public static Villager spawn(Location location) {
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final VillagerShop customEntity = new VillagerShop(
                mcWorld);
        customEntity.setLocation(location.getX(), location.getY(),
                location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity())
                .setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
        return (CraftVillager) customEntity.getBukkitEntity();
    }

	public static Villager spawn(Location location, String string) {
		// TODO Auto-generated method stub
		 World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
	        final VillagerShop customEntity = new VillagerShop(
	                mcWorld);
	        customEntity.setName(string);	 
	        customEntity.setLocation(location.getX(), location.getY(),
	                location.getZ(), location.getYaw(), location.getPitch());
	        ((CraftLivingEntity) customEntity.getBukkitEntity())
	                .setRemoveWhenFarAway(false);	        
	        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
	        ShopData shop = new ShopData();
	        shop.setName(string);	
	        shop.setProfession(customEntity.getProfession());
	        shop.setLocation(location.getX(), location.getY(),
	                location.getZ());
	        TraderHandler.saveShop(shop);
	        return (Villager) customEntity.getBukkitEntity();
	}


	public UUID getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}
	
	public void setOwner(UUID player) {
		// TODO Auto-generated method stub
		this.owner = player;
	}
	
}
