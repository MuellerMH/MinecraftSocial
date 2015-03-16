package de.mcsocial.trader;


import net.minecraft.server.v1_8_R1.EntityVillager;
import net.minecraft.server.v1_8_R1.World;

import org.bukkit.util.Vector;



public class CustomVillager extends EntityVillager {
	
	@SuppressWarnings("unused")
	private String name = null;

	public CustomVillager(World world) {
		super(world);
	}

	public CustomVillager(World world, int i) {
		super(world, i);
	}
	
	
    @Override
    public void move(double x, double y, double z) {
    	if(!this.hasCustomName()){
    		super.move(x,y,z);
    		return;
    	}
        return;
    }
        
    @Override
    public void die() {
    	if(!this.hasCustomName()){
    		super.die();
    		return;
    	}
        return;
    }
    
    protected void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		this.setCustomName(name);
		this.setCustomNameVisible(true);
	}

	@Override
    public void g(double x, double y, double z) {
    	if(!this.hasCustomName()){
    		super.g(x,y,z);
    		return;
    	}
        Vector vector = this.getBukkitEntity().getVelocity();
        super.g(vector.getX(), vector.getY(), vector.getZ());
    }

    
} 