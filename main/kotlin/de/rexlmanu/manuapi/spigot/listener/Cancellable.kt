/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.listener

import org.bukkit.event.Cancellable


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 17:00
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface Cancellable {

    fun cancel(cancellable: Cancellable) {
        cancel(cancellable, true)
    }

    fun cancel(cancellable: Cancellable, boolean: Boolean) {
        cancellable.isCancelled = boolean
    }
}