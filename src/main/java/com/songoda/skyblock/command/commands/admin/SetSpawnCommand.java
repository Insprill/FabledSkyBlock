package com.songoda.skyblock.command.commands.admin;

import com.songoda.core.compatibility.CompatibleSound;
import com.songoda.skyblock.command.SubCommand;
import com.songoda.skyblock.config.FileManager;
import com.songoda.skyblock.config.FileManager.Config;
import com.songoda.skyblock.message.MessageManager;
import com.songoda.skyblock.sound.SoundManager;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class SetSpawnCommand extends SubCommand {

    @Override
    public void onCommandByPlayer(Player player, String[] args) {
        MessageManager messageManager = plugin.getMessageManager();
        SoundManager soundManager = plugin.getSoundManager();
        FileManager fileManager = plugin.getFileManager();

        Config config = fileManager.getConfig(new File(plugin.getDataFolder(), "language.yml"));
        FileConfiguration configLoad = config.getFileConfiguration();

        fileManager.setLocation(fileManager.getConfig(new File(plugin.getDataFolder(), "locations.yml")),
                "Location.Spawn", player.getLocation(), true);
        messageManager.sendMessage(player, configLoad.getString("Command.Island.Admin.SetSpawn.Set.Message"));
        soundManager.playSound(player, CompatibleSound.ENTITY_PLAYER_LEVELUP.getSound(), 1.0F, 1.0F);
    }

    @Override
    public void onCommandByConsole(ConsoleCommandSender sender, String[] args) {
        sender.sendMessage("SkyBlock | Error: You must be a player to perform that command.");
    }

    @Override
    public String getName() {
        return "setspawn";
    }

    @Override
    public String getInfoMessagePath() {
        return "Command.Island.Admin.SetSpawn.Info.Message";
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public String[] getArguments() {
        return new String[0];
    }
}
