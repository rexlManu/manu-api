/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.command

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

/******************************************************************************************
 * Urheberrechtshinweis
 * Copyright © Emmanuel Lampe 2018
 * Erstellt: 05.05.2018 / 16:41
 *
 * Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 * Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 * bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 * Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 * öffentlichen Zugänglichmachung oder andere Nutzung
 * bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 */

@Suppress("MemberVisibilityCanBePrivate", "LeakingThis")
abstract class Command(val javaPlugin: JavaPlugin,
                       val commandName: String,
                       val permission: String = "",
                       val usage: String = "",
                       val minLength: Int = 0,
                       val maxLength: Int = 0,
                       tabCompleter: TabCompleter? = null) : ICommand {

    init {
        val command: PluginCommand? = javaPlugin.getCommand(commandName)
        if (command != null) {
            command.permission = permission
            command.tabCompleter = tabCompleter
            command.executor = this
        }
    }

    override fun onCommand(sender: CommandSender, command: org.bukkit.command.Command, s: String, args: Array<String>?): Boolean {
        if (args == null)
            perform(sender, emptyArray())
        else {
            if (args.size < minLength || args.size > maxLength) {
                sendUseMessage(sender)
                return true
            }
            perform(sender, args)
        }
        return true
    }

    abstract override fun perform(sender: CommandSender, args: Array<String>)

    override fun isPlayer(sender: CommandSender, lambda: (Player) -> Unit) = if (sender is Player) lambda(sender) else sender.sendMessage("Der Command ist nur für Spieler")

    override fun getTarget(sender: CommandSender, player: Player?, lambda: (Player) -> Unit) = if (player != null) lambda(player) else sender.sendMessage("§cDer Spieler ist nicht Online")

    override fun getTarget(sender: CommandSender, uuid: UUID, lambda: (Player) -> Unit) = getTarget(sender, Bukkit.getPlayer(uuid), lambda)

    override fun getTarget(sender: CommandSender, name: String, lambda: (Player) -> Unit) = getTarget(sender, Bukkit.getPlayer(name), lambda)

    override fun sendUseMessage(sender: CommandSender) = sender.sendMessage("§7Nutze: §8/$commandName §7$usage")
}
