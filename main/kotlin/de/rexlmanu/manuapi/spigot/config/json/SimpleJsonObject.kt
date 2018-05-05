/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config.json

import org.json.simple.JSONObject


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 17:23
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class SimpleJsonObject(private val jsonObject: JSONObject) : JSONObject(jsonObject.toMap()) {

    fun getString(key: String): String = getObject(key) as String
    fun getBoolean(key: String): Boolean = getObject(key) as Boolean
    fun getNumber(key: String): Number = getObject(key) as Number
    fun getDouble(key: String): Double = getObject(key) as Double
    fun getFloat(key: String): Float = getObject(key) as Float
    fun getShort(key: String): Short = getObject(key) as Short
    fun getByte(key: String): Byte = getObject(key) as Byte
    fun getInt(key: String): Int = getObject(key) as Int
    fun getLong(key: String): Long = getObject(key) as Long

    fun getObject(key: String): Any? = this.jsonObject[key]
}