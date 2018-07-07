/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config.json

import org.bukkit.Bukkit
import org.bukkit.Location
import org.json.simple.JSONObject
import java.io.File


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 17:18
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/
@Deprecated("")
class BukkitJsonConfig(directory: File, fileName: String) : JsonConfig(directory, fileName) {

    constructor(directory: String, fileName: String) : this(File(directory), fileName)

    fun setLocation(key: String, location: Location) {
        val jsonObject = JSONObject()
        jsonObject["x"] = location.x
        jsonObject["y"] = location.y
        jsonObject["z"] = location.z
        jsonObject["yaw"] = location.yaw
        jsonObject["pitch"] = location.pitch
        jsonObject["world"] = location.world.name
        insertObject(key, jsonObject)
    }

    fun getLocation(key: String): Location {
        val jsonObject = SimpleJsonObject(getObject(key) as JSONObject)
        return Location(Bukkit.getWorld(jsonObject.getString("world")), jsonObject.getDouble("x"), jsonObject.getDouble("y"), jsonObject.getDouble("z"), jsonObject.getFloat("yaw"), jsonObject.getFloat("pitch"))
    }

}