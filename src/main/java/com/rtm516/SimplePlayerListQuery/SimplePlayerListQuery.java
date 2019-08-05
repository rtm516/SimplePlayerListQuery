package com.rtm516.SimplePlayerListQuery;

import org.bstats.bungeecord.Metrics;

import net.md_5.bungee.api.plugin.Plugin;

public class SimplePlayerListQuery extends Plugin {
	public static SimplePlayerListQuery instance;
	
    @Override
    public void onEnable() {
    	instance = this;
    	
		new Metrics(this);
    	
    	new QueryEvent();
    }
    
    @Override
    public void onDisable() {
    	
    }    
}
