/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.module

import de.rexlmanu.manuapi.general.utils.RunTimeUtils
import java.io.File
import java.io.IOException
import java.util.jar.JarFile

/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 08:28
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class ModuleManager {

    private var modules: MutableList<Module> = ArrayList()
    private val sourceFolder = File("./modules/")

    init {
        if (!sourceFolder.exists()) {
            val mkdirs = sourceFolder.mkdirs()
            if (mkdirs.not()) {
                throw IOException("The folders couldnt been created in this runtime.")
            }
        }

        loadModulesFromFolder()
        enableAllModules()
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun enableAllModules() = modules.forEach { it.start() }

    @Suppress("MemberVisibilityCanBePrivate")
    fun disableAllModules() = modules.forEach { it.stop() }

    fun reloadAllModules() {
        disableAllModules()
        enableAllModules()
    }

    fun loadModule(file: File) {
        val classes = findModuleClasses(file)
        for (cls in classes) {
            cls.asSubclass(Module::class.java);
            if (cls.interfaces[0].toString() == "interface de.rexlmanu.manuapi.module.Module") {
                val module = cls.newInstance() as Module
                module.load()
                modules.add(module)
            }
        }
    }

    fun findModuleClasses(file: File): List<Class<*>> {
        val classes = java.util.ArrayList<Class<*>>()
        val jar = JarFile(file)
        val entries = jar.entries()
        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            var name = entry.name
            if (name.endsWith(".class")) {
                name = name.substring(0, name.lastIndexOf('.'))
                val cls = Class.forName(name.replace("/", "."))
                classes.add(cls)
            }
        }
        return classes
    }

    fun enableModule() {

    }

    private fun loadModulesFromFolder() = sourceFolder.listFiles().forEach { RunTimeUtils.importJar(it) }
}
