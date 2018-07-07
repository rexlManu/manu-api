/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.listener

import org.bukkit.Bukkit
import org.bukkit.event.HandlerList
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

/******************************************************************************************
 * Urheberrechtshinweis
 * Copyright © Emmanuel Lampe 2018
 * Erstellt: 05.05.2018 / 16:38
 *
 * Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 * Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 * bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 * Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 * öffentlichen Zugänglichmachung oder andere Nutzung
 * bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 */

open class Listener(private val javaPlugin: JavaPlugin, private val pluginManager: PluginManager = Bukkit.getPluginManager()) : IListener {

    init {
        @Suppress("LeakingThis")
        init()
        register()
    }

    override fun init() {
    }

    final override fun register() {
        this.pluginManager.registerEvents(this, javaPlugin)
    }

    final override fun unregister() {
        HandlerList.unregisterAll(this)
    }

    final override fun reload() {
        unregister()
        register()
    }

}
