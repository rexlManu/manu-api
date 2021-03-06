/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.builder

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack


/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 16:24
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

class InventoryBuilder(title: String, row: Int) : IInvetoryBuilder {


    private val inventory: Inventory = Bukkit.createInventory(null, row * 9, title)

    override fun fillGlass() {
        this.replaceWith(ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("§r").build())
    }

    override fun addItem(itemStack: ItemStack) {
        this.inventory.addItem(itemStack)
    }

    override fun replaceWith(itemStack: ItemStack) {
        for (i in 0..inventory.size)
            setItem(i, itemStack)
    }

    override fun setItem(slot: Int, itemStack: ItemStack) {
        this.inventory.setItem(slot, itemStack)
    }

    override fun setItem(x: Int, y: Int, itemStack: ItemStack) {
        this.setItem(x * y, itemStack)
    }

    override fun build(): Inventory = inventory

    override fun openInventory(player: Player) {
        player.openInventory(build())
    }
}