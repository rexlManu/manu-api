/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.builder

import de.rexlmanu.manuapi.kotlin.interfaces.Builder
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 18:07
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

interface IInvetoryBuilder : Builder<Inventory> {

    fun fillGlass()

    fun addItem(itemStack: ItemStack)

    fun replaceWith(itemStack: ItemStack)

    fun setItem(slot: Int, itemStack: ItemStack)

    fun setItem(x: Int, y: Int, itemStack: ItemStack)

    override fun build(): Inventory

    fun openInventory(player: Player)
}