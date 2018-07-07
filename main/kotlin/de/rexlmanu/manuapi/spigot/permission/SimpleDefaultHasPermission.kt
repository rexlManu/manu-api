/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.permission

import org.bukkit.command.CommandSender


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 07:41
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface SimpleDefaultHasPermission : SimpleHasPermission {

    val permission: String

    fun hasPermission(sender: CommandSender): Boolean = super.hasPermission(sender, permission)

    fun hasPermission(sender: CommandSender, lambda: () -> Unit) = super.hasPermission(sender, permission, lambda)
}