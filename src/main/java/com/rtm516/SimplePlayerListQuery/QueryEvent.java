package com.rtm516.SimplePlayerListQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class QueryEvent implements Listener {
	public QueryEvent() {
	    SimplePlayerListQuery.instance.getProxy().getPluginManager().registerListener(SimplePlayerListQuery.instance, this);
  }
	
	@EventHandler(priority = 32)
	public void onServerPing(ProxyPingEvent e) {
		Collection<ProxiedPlayer> players = ProxyServer.getInstance().getPlayers();
		
		if (players.size() == 0) {
			e.getResponse().getPlayers().setSample(null);
		}

		ServerPing.PlayerInfo[] playerInfo = new ServerPing.PlayerInfo[players.size()];
	    for (int i = 0; i < playerInfo.length; i++) {
	    	ProxiedPlayer player = (ProxiedPlayer) players.toArray()[i];
	    	playerInfo[i] = new ServerPing.PlayerInfo(player.getDisplayName(), player.getUniqueId());
	    }
		e.getResponse().getPlayers().setSample(playerInfo);
	}
}
