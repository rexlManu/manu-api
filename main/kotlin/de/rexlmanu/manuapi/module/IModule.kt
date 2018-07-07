/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.module


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 07.07.2018 / 08:21
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface IModule {

    fun load()

    fun start()

    fun stop()
}