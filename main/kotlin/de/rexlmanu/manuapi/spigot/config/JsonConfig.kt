/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.config

import com.google.gson.GsonBuilder
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.File
import java.io.FileWriter
import java.nio.file.Files

/******************************************************************************************
 * Urheberrechtshinweis
 * Copyright © Emmanuel Lampe 2018
 * Erstellt: 05.05.2018 / 16:48
 *
 * Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 * Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 * bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 * Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 * öffentlichen Zugänglichmachung oder andere Nutzung
 * bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 */

class JsonConfig(directory: File, fileName: String) : IConfig {

    constructor(directory: String, fileName: String) : this(File(directory), fileName)

    private val source: File = File(directory, fileName)
    private var jsonObject: JSONObject = JSONObject()


    override fun loadConfig() {
        this.jsonObject = JSONParser().parse(String(Files.readAllBytes(source.toPath()))) as JSONObject
    }

    override fun saveConfig() {
        val fileWriter = FileWriter(source)
        fileWriter.write(formatJson(this.jsonObject.toString()))
        fileWriter.flush()
        fileWriter.close()
    }

    private fun formatJson(jsonContent: String): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(jsonContent)
    }

    override fun reloadConfig() {
        loadConfig()
    }

    override fun getObject(key: String): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertObject(key: String, any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getString(key: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBoolean(key: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNumber(key: String): Number {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
