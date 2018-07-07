/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.permission

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 07:29
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface SimpleHasPermission : HasPermission {

    val permissionMessage: String

    override fun hasPermission(sender: CommandSender, permission: String): Boolean {
        if (permission.isBlank() || sender.hasPermission(permission)) {
            return true
        } else sender.sendMessage((if (permissionMessage.isBlank()) "${ChatColor.RED}I'm sorry but you do not have permission to perform this command. Please contact the server administrator if you believe that this is in error." else permissionMessage))
        return false
    }

    override fun hasPermission(sender: CommandSender, permission: String, lambda: () -> Unit) {
        if (hasPermission(sender, permission))
            lambda()

    }

}