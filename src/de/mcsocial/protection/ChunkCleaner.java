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
		// TODO Auto-generated method stub
		List <LivingEntity>toRemove = new ArrayList<LivingEntity>();
		
		for (LivingEntity livingEntity : world.getLivingEntities()) {
			Location livingEntityLoc = livingEntity.getLocation();
		    
			if (!livingEntityLoc.getChunk().isLoaded())
				continue;
			if(ChunkHandler.isClaimAble(livingEntityLoc.getChunk()))
				continue;
			
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
			entitiList.add("CraftMushroomCow");
			entitiList.add("CraftOcelot");
			entitiList.add("CraftPigZombie");
			entitiList.add("CraftSheep");
			entitiList.add("CraftSilverfish");
			entitiList.add("CraftSkeleton");
			entitiList.add("CraftSlime");
			entitiList.add("CraftSpider");
			entitiList.add("CraftSquid");
			entitiList.add("CraftWaterMob");
			entitiList.add("CraftWitch");
			entitiList.add("CraftWither");
			entitiList.add("CraftWolf");
			entitiList.add("CraftZombie");
			if(!entitiList.contains(livingEntity.toString()))
				continue;
			toRemove.add(livingEntity);
		}
		
		for(LivingEntity livingEntity :toRemove){
			livingEntity.teleport(new Location(Bukkit.getWorld("world"),0,0,0));
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
