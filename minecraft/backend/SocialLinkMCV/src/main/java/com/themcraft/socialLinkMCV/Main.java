package com.themcraft.socialLinkMCV;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new JoinListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
