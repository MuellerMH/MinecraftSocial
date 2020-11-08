package de.mcsocial.trader;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

//import net.minecraft.server.v1_8_R1.World;

//import org.bukkit.Location;
//import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
//import org.bukkit.craftbukkit.v1_8_R1.entity.CraftVillager;
import org.bukkit.entity.Villager;

public class VillagerShop extends CustomVillager {

	private UUID owner;

	public VillagerShop(net.minecraft.server.v1_14_R1.World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

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
	        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
	        ShopData shop = new ShopData();
	        shop.setName(string);
	        shop.setProfession(profession);
	        shop.setLocation(location.getX(), location.getY(),
	                location.getZ());
	        TraderHandler.saveShop(shop);
	        return (Villager) customEntity.getBukkitEntity();
	        */
	}


	public static Villager spawn(Location location, String string, Integer profession, ShopData shop) {


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
		World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final VillagerShop customEntity = new VillagerShop(
                mcWorld);
        customEntity.setName(string);
        customEntity.setLocation(location.getX(), location.getY(),
                location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity())
                .setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);

        shop.setLocation(location.getX(), location.getY(),location.getZ());
        TraderHandler.saveShop(shop);
        return (Villager) customEntity.getBukkitEntity();
        */
	}


	public UUID getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}

	public void setOwner(UUID player) {
		// TODO Auto-generated method stub
		this.owner = player;
	}


	public static void despawn(Villager shop) {
		shop.remove();
	}

}
