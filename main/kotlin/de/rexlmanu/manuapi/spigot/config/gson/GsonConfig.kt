package de.rexlmanu.manuapi.spigot.config.gson

/*
 * Class created by rexlManu
 * Twitter: @rexlManu | Website: rexlManu.de
 * Coded with IntelliJ
 */

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonPrimitive
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files

open class GsonConfig(private val filename: String, dataFolder: File) {

    private val source: File
    var jsonObject: JsonObject? = null
        private set
    private val defaultObject: JsonObject

    init {
        dataFolder.mkdir()
        this.source = File(dataFolder, "$filename.json")
        this.defaultObject = JsonObject()
    }

    fun addDefault(key: String, value: Any): GsonConfig {
        this.defaultObject.add(key, JsonPrimitive(value.toString()))
        return this
    }

    fun load(): GsonConfig {
        when {
            !this.source.exists() -> try {
                this.source.createNewFile()
                this.write(this.source, this.convertToString(this.defaultObject))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        this.read()
        return this
    }

    fun save(): GsonConfig {
        write(this.source, this.convertToString(this.jsonObject))
        return this
    }

    private fun read() = try {
        this.jsonObject = JsonParser().parse(String(Files.readAllBytes(this.source.toPath()))).asJsonObject
    } catch (e: IOException) {
        e.printStackTrace()
    }

    private fun write(file: File, string: String) {
        FileWriter(file).apply {
            write(string)
            flush()
            close()
        }
    }

    fun setString(key: String, value: String) = this.jsonObject!!.addProperty(key, value)

    fun setBoolean(key: String, value: Boolean?) = this.jsonObject!!.addProperty(key, value)

    fun setInteger(key: String, value: Int?) = this.jsonObject!!.addProperty(key, value)

    fun setLong(key: String, value: Long?) = this.jsonObject!!.addProperty(key, value)

    fun setFloat(key: String, value: Float?) = this.jsonObject!!.addProperty(key, value)

    fun setDouble(key: String, value: Double?) = this.jsonObject!!.addProperty(key, value)

    fun setShort(key: String, value: Short?) = this.jsonObject!!.addProperty(key, value)

    fun setByte(key: String, value: Byte?) = this.jsonObject!!.addProperty(key, value)

    fun getInteger(key: String): Int? = this.jsonObject?.get(key)?.asInt

    fun getBoolean(key: String): Boolean? = this.jsonObject?.get(key)?.asBoolean

    fun getString(key: String): String? = this.jsonObject?.get(key)?.asString

    fun getFloat(key: String): Float? = this.jsonObject?.get(key)?.asFloat

    fun getDouble(key: String): Double? = this.jsonObject?.get(key)?.asDouble

    fun getLong(key: String): Long? = this.jsonObject?.get(key)?.asLong

    fun getShort(key: String): Short? = this.jsonObject?.get(key)?.asShort

    fun getByte(key: String): Byte? = this.jsonObject?.get(key)?.asByte

    fun setObject(key: String, value: Any) {
        this.jsonObject?.add(key, JsonPrimitive(value.toString()))
    }

    private fun convertToString(jsonObject: JsonObject?): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(jsonObject)
    }
}
