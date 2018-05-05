/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.command

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 18:05
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface ICommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: org.bukkit.command.Command, s: String, args: Array<String>?): Boolean

    fun perform(sender: CommandSender, args: Array<String>)

    fun isPlayer(sender: CommandSender, lambda: (Player) -> Unit)

    fun getTarget(sender: CommandSender, player: Player?, lambda: (Player) -> Unit)

    fun getTarget(sender: CommandSender, uuid: UUID, lambda: (Player) -> Unit)

    fun getTarget(sender: CommandSender, name: String, lambda: (Player) -> Unit)

    fun sendUseMessage(sender: CommandSender)
}