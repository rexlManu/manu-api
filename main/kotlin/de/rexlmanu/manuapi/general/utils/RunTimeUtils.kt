/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.general.utils

import java.io.File
import java.net.URL
import java.net.URLClassLoader


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 09:50
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class RunTimeUtils {

    companion object {
        fun importJar(file: File) {
            val addURL = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java)
            addURL.isAccessible = true
            addURL.invoke(URLClassLoader.getSystemClassLoader(), *arrayOf<Any>(file.toURI().toURL()))
        }
    }
}