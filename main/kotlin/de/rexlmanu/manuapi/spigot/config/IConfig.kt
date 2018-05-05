/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 16:43
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface IConfig {

    fun loadConfig()

    fun saveConfig()

    fun reloadConfig()

    fun getObject(key: String): Any

    fun insertObject(key: String, any: Any)

    fun getString(key: String): String

    fun getBoolean(key: String): Boolean

    fun getNumber(key: String): Number

}