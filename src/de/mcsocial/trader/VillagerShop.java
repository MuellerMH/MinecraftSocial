package de.mcsocial.trader;

import java.util.UUID;

<<<<<<< HEAD
import net.minecraft.server.v1_8_R1.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
=======
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

//import net.minecraft.server.v1_8_R1.World;

//import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Villager;
>>>>>>> b4ade11... add new directory

public class VillagerShop extends CustomVillager {

	private UUID owner;

<<<<<<< HEAD
	public VillagerShop(World world) {
=======
	public VillagerShop(net.minecraft.server.v1_14_R1.World world) {
>>>>>>> b4ade11... add new directory
		super(world);
		// TODO Auto-generated constructor stub
	}
	
<<<<<<< HEAD

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

	public static Villager spawn(Location location, String string, Integer profession) {
		// TODO Auto-generated method stub
		 World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
	        final VillagerShop customEntity = new VillagerShop(
	                mcWorld);
	        customEntity.setName(string);	 
	        customEntity.setLocation(location.getX(), location.getY(),
	                location.getZ(), location.getYaw(), location.getPitch());
	        ((CraftLivingEntity) customEntity.getBukkitEntity())
	                .setRemoveWhenFarAway(false);	        
=======
/*
	public VillagerShop(net.minecraft.server.v1_14_R1.World world, int i) {
		super(world, i);
		// TODO Auto-generated constructor stub
	}
	*/
	
    public static Villager spawn(Location location) {
    	World world = location.getWorld();
    	Villager shop = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
    	shop.setAI(false);
		shop.setInvulnerable(true);
		shop.setCanPickupItems(false);
		shop.setSilent(false);
		shop.setGravity(false);
		shop.setRemoveWhenFarAway(false);
		
		shop.setCustomNameVisible(true);
		
		return shop;
		/*
        World mcWorld = location.getWorld();
        final VillagerShop customEntity = new VillagerShop(mcWorld);
        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
        return (CraftVillager) customEntity.getBukkitEntity();
        */
    }

	public static Villager spawn(Location location, String string, Integer profession) {
		
		World world = location.getWorld();
    	Villager shop = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
    	shop.setAI(false);
		shop.setInvulnerable(true);
		shop.setCanPickupItems(false);
		shop.setSilent(false);
		shop.setGravity(false);
		shop.setRemoveWhenFarAway(false);
		shop.setCustomName(string);
		shop.setProfession(TraderHandler.getProfession(profession));
		shop.setCustomNameVisible(true);
		
		return shop;
		
		/*
		// TODO Auto-generated method stub
		 World mcWorld = location.getWorld();
	        final VillagerShop customEntity = new VillagerShop(mcWorld);
	        customEntity.setName(string);	 
	        customEntity.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
	        ((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);	        
>>>>>>> b4ade11... add new directory
	        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
	        ShopData shop = new ShopData();
	        shop.setName(string);	
	        shop.setProfession(profession);
	        shop.setLocation(location.getX(), location.getY(),
	                location.getZ());
	        TraderHandler.saveShop(shop);
	        return (Villager) customEntity.getBukkitEntity();
<<<<<<< HEAD
=======
	        */
>>>>>>> b4ade11... add new directory
	}


	public static Villager spawn(Location location, String string, Integer profession, ShopData shop) {
<<<<<<< HEAD
=======
		
		
		World world = location.getWorld();
    	Villager shop1 = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
    	shop1.setAI(false);
		shop1.setInvulnerable(true);
		shop1.setCanPickupItems(false);
		shop1.setSilent(false);
		shop1.setGravity(false);
		shop1.setRemoveWhenFarAway(false);
		shop1.setCustomName(string);
		shop1.setProfession(TraderHandler.getProfession(profession));
		shop1.setCustomNameVisible(true);
		
		shop.setLocation(location.getX(), location.getY(),location.getZ());
        TraderHandler.saveShop(shop);
		
		return shop1;
		
		/*
>>>>>>> b4ade11... add new directory
		World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final VillagerShop customEntity = new VillagerShop(
                mcWorld);
        customEntity.setName(string);	 
        customEntity.setLocation(location.getX(), location.getY(),
                location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity())
                .setRemoveWhenFarAway(false);	        
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
        
<<<<<<< HEAD
        shop.setLocation(location.getX(), location.getY(),
                location.getZ());
        
        TraderHandler.saveShop(shop);
        return (Villager) customEntity.getBukkitEntity();
=======
        shop.setLocation(location.getX(), location.getY(),location.getZ());
        TraderHandler.saveShop(shop);
        return (Villager) customEntity.getBukkitEntity();
        */
>>>>>>> b4ade11... add new directory
	}


	public UUID getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}
	
	public void setOwner(UUID player) {
		// TODO Auto-generated method stub
		this.owner = player;
	}


<<<<<<< HEAD
	@SuppressWarnings("deprecation")
	public static void despawn(Villager shop) {
		shop.setHealth(0);
		shop.damage(100);
=======
	public static void despawn(Villager shop) {
		shop.remove();
>>>>>>> b4ade11... add new directory
	}
	
}
