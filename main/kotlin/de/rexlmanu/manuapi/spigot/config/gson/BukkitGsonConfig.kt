/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config.gson

import com.google.gson.JsonObject
import org.bukkit.Bukkit
import org.bukkit.Location
import java.io.File

/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 08:11
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class BukkitGsonConfig(filename: String, dataFolder: File) : GsonConfig(filename, dataFolder) {

    fun setLocation(key: String, location: Location) {
        val locationObject = JsonObject()
        locationObject.addProperty("World", location.world.name)
        locationObject.addProperty("X", location.x)
        locationObject.addProperty("Y", location.y)
        locationObject.addProperty("Z", location.z)
        locationObject.addProperty("Yaw", location.yaw)
        locationObject.addProperty("Pitch", location.pitch)
        jsonObject?.add(key, locationObject)
    }

    fun getLocation(key: String): Location? {
        val locationObject = jsonObject?.get(key)?.asJsonObject
        return Location(Bukkit.getWorld(locationObject?.get("World")?.asString), locationObject?.get("X")!!.asDouble, locationObject.get("Y").asDouble, locationObject.get("Z").asDouble, locationObject.get("Yaw").asFloat, locationObject.get("Pitch").asFloat)
    }

}