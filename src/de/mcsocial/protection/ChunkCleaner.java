package de.mcsocial.protection;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

public class ChunkCleaner {

	public void run() {
		World world = Bukkit.getWorld("world");
		List<LivingEntity> toRemove = new ArrayList<LivingEntity>();
		List<String> entitiList = new ArrayList<String>();
		entitiList.add("CraftAgeable");
		entitiList.add("CraftBat");
		entitiList.add("CraftBlaze");
		entitiList.add("CraftCaveSpider");
		entitiList.add("CraftComplexLivingEntity");
		entitiList.add("CraftCreature");
		entitiList.add("CraftCreeper");
		entitiList.add("CraftEnderDragon");
		entitiList.add("CraftEnderman");
		entitiList.add("CraftGhast");
		entitiList.add("CraftGiant");
		entitiList.add("CraftMagmaCube");
		entitiList.add("CraftMonster");
		entitiList.add("CraftPigZombie");
		entitiList.add("CraftSilverfish");
		entitiList.add("CraftSkeleton");
		entitiList.add("CraftSlime");
		entitiList.add("CraftSpider");
		entitiList.add("CraftSquid");
		entitiList.add("CraftWaterMob");
		entitiList.add("CraftWitch");
		entitiList.add("CraftWither");
		entitiList.add("CraftZombie");
		entitiList.add("Bat");
		entitiList.add("Blaze");
		entitiList.add("Boss");
		entitiList.add("Cat");
		entitiList.add("CaveSpider");
		entitiList.add("Cod");
		entitiList.add("Creeper");
		entitiList.add("Dolphin");
		entitiList.add("Donkey");
		entitiList.add("DragonFireball");
		entitiList.add("ElderGuardian");
		entitiList.add("EnderCrystal");
		entitiList.add("EnderDragon");
		entitiList.add("EnderDragonPart");
		entitiList.add("Enderman");
		entitiList.add("Endermite");
		entitiList.add("EnderPearl");
		entitiList.add("EnderSignal");
		entitiList.add("Evoker");
		entitiList.add("EvokerFangs");
		entitiList.add("ExperienceOrb");
		entitiList.add("Explosive");
		entitiList.add("Fireball");
		entitiList.add("Ghast");
		entitiList.add("Giant");
		entitiList.add("Guardian");
		entitiList.add("Hoglin");
		entitiList.add("Husk");
		entitiList.add("LargeFireball");
		entitiList.add("LeashHitch");
		entitiList.add("LightningStrike");
		entitiList.add("LingeringPotion");
		entitiList.add("MagmaCube");
		entitiList.add("Monster");
		entitiList.add("Panda");
		entitiList.add("Parrot");
		entitiList.add("Phantom");
		entitiList.add("Piglin");
		entitiList.add("PiglinAbstract");
		entitiList.add("PiglinBrute");
		entitiList.add("PigZombie");
		entitiList.add("Pillager");
		entitiList.add("Raider");
		entitiList.add("Ravager");
		entitiList.add("Salmon");
		entitiList.add("Shulker");
		entitiList.add("ShulkerBullet");
		entitiList.add("Silverfish");
		entitiList.add("SizedFireball");
		entitiList.add("Skeleton");
		entitiList.add("SkeletonHorse");
		entitiList.add("Slime");
		entitiList.add("SmallFireball");
		entitiList.add("Spellcaster");
		entitiList.add("Spider");
		entitiList.add("Squid");
		entitiList.add("Stray");
		entitiList.add("Strider");
		entitiList.add("TNTPrimed");
		entitiList.add("Trident");
		entitiList.add("Vex");
		entitiList.add("Vindicator");
		entitiList.add("WaterMob");
		entitiList.add("Witch");
		entitiList.add("Wither");
		entitiList.add("WitherSkeleton");
		entitiList.add("WitherSkull");
		entitiList.add("Wolf");
		entitiList.add("Zoglin");
		entitiList.add("Zombie");
		entitiList.add("ZombieHorse");
		entitiList.add("ZombieVillager");
		entitiList.add("CraftBat");
		entitiList.add("CraftBlaze");
		entitiList.add("CraftBoss");
		entitiList.add("CraftCat");
		entitiList.add("CraftCaveSpider");
		entitiList.add("CraftCod");
		entitiList.add("CraftCreeper");
		entitiList.add("CraftDolphin");
		entitiList.add("CraftDonkey");
		entitiList.add("CraftDragonFireball");
		entitiList.add("CraftElderGuardian");
		entitiList.add("CraftEnderCrystal");
		entitiList.add("CraftEnderDragon");
		entitiList.add("CraftEnderDragonPart");
		entitiList.add("CraftEnderman");
		entitiList.add("CraftEndermite");
		entitiList.add("CraftEnderPearl");
		entitiList.add("CraftEnderSignal");
		entitiList.add("CraftEvoker");
		entitiList.add("CraftEvokerFangs");
		entitiList.add("CraftExperienceOrb");
		entitiList.add("CraftExplosive");
		entitiList.add("CraftFireball");
		entitiList.add("CraftGhast");
		entitiList.add("CraftGiant");
		entitiList.add("CraftGuardian");
		entitiList.add("CraftHoglin");
		entitiList.add("CraftHusk");
		entitiList.add("CraftLargeFireball");
		entitiList.add("CraftLeashHitch");
		entitiList.add("CraftLightningStrike");
		entitiList.add("CraftLingeringPotion");
		entitiList.add("CraftMagmaCube");
		entitiList.add("CraftMonster");
		entitiList.add("CraftPanda");
		entitiList.add("CraftParrot");
		entitiList.add("CraftPhantom");
		entitiList.add("CraftPiglin");
		entitiList.add("CraftPiglinAbstract");
		entitiList.add("CraftPiglinBrute");
		entitiList.add("CraftPigZombie");
		entitiList.add("CraftPillager");
		entitiList.add("CraftRaider");
		entitiList.add("CraftRavager");
		entitiList.add("CraftSalmon");
		entitiList.add("CraftShulker");
		entitiList.add("CraftShulkerBullet");
		entitiList.add("CraftSilverfish");
		entitiList.add("CraftSizedFireball");
		entitiList.add("CraftSkeleton");
		entitiList.add("CraftSkeletonHorse");
		entitiList.add("CraftSlime");
		entitiList.add("CraftSmallFireball");
		entitiList.add("CraftSpellcaster");
		entitiList.add("CraftSpider");
		entitiList.add("CraftSquid");
		entitiList.add("CraftStray");
		entitiList.add("CraftStrider");
		entitiList.add("CraftTNTPrimed");
		entitiList.add("CraftTrident");
		entitiList.add("CraftVex");
		entitiList.add("CraftVindicator");
		entitiList.add("CraftWaterMob");
		entitiList.add("CraftWitch");
		entitiList.add("CraftWither");
		entitiList.add("CraftWitherSkeleton");
		entitiList.add("CraftWitherSkull");
		entitiList.add("CraftWolf");
		entitiList.add("CraftZoglin");
		entitiList.add("CraftZombie");
		entitiList.add("CraftZombieHorse");
		entitiList.add("CraftZombieVillager");

		for (LivingEntity livingEntity : world.getLivingEntities()) {
			Location livingEntityLoc = livingEntity.getLocation();

			if (!livingEntityLoc.getChunk().isLoaded())
				continue;
			if (ChunkHandler.isClaimAble(livingEntityLoc.getChunk()))
				continue;
			if (!entitiList.contains(livingEntity.toString()))
				continue;
			toRemove.add(livingEntity);
		}

		for (LivingEntity livingEntity : toRemove) {
			livingEntity.teleport(new Location(Bukkit.getWorld("world"), 0, 0, 0));
			world.getLivingEntities().remove(livingEntity);
		}
		toRemove.clear();
	}

	public static boolean isSubInterface(Class<?> sup, Class<?> sub) {
		if (sup.isInterface() && sub.isInterface()) {
			if (sup.equals(sub))
				return true;
			for (Class<?> c : sub.getInterfaces())
				if (isSubInterface(sup, c))
					return true;
		}
		return false;
	}

}
