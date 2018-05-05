/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config.yml

import de.rexlmanu.manuapi.spigot.config.IConfig
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 17:33
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class YamlConfig(directory: File, fileName: String) : IConfig, YamlConfiguration() {

    constructor(directory: String, fileName: String) : this(File(directory), fileName)

    private val source: File = File(directory, fileName)

    override fun loadConfig() =
            load(source)


    override fun saveConfig() =
            save(source)


    override fun reloadConfig() =
            loadConfig()


    override fun insertObject(key: String, any: Any) =
            set(key, any)


    override fun getObject(key: String): Any = this.get(key)

    override fun getNumber(key: String): Number = getObject(key) as Number


}
