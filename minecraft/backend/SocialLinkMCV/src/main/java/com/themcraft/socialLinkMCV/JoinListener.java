package com.themcraft.socialLinkMCV;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class JoinListener implements Listener {
    @EventHandler
    public void onPostLogin(PostLoginEvent event) throws IOException {
        String hostname = event.getPlayer().getPendingConnection().getVirtualHost().getHostName();
        String token = hostname.split("\\.")[0];
        String uuid = event.getPlayer().getUniqueId().toString();
        String feedback = new Scanner(new URL("https://minergames.net/sociallink/api/minecraft/verify.php?token=" + token + "&uuid=" + uuid).openStream()).next();
        ProxyServer.getInstance().getLogger().info("Player " + event.getPlayer().getName() + " connected to " + hostname + " " + feedback);
        event.getPlayer().disconnect(feedback);
    }
}
