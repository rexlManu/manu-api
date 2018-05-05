/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config.properties

import de.rexlmanu.manuapi.spigot.config.IConfig
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 17:43
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class PropertiesConfig(directory: File, fileName: String) : IConfig, Properties() {
    constructor(directory: String, fileName: String) : this(File(directory), fileName)

    private val source: File = File(directory, fileName)

    override fun loadConfig() {
        this.load(java.io.StringReader(String(java.nio.file.Files.readAllBytes(source.toPath()))))
    }

    override fun saveConfig() {
        try {
            this.store(FileOutputStream(this.source), null)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun reloadConfig() {
        loadConfig()
    }

    override fun getObject(key: String): Any = this[key]!!

    override fun insertObject(key: String, any: Any) {
        setProperty(key, any.toString())
    }

    override fun getString(key: String): String = getObject(key) as String

    override fun getBoolean(key: String): Boolean = getObject(key) as Boolean

    override fun getNumber(key: String): Number = getObject(key) as Number


}
