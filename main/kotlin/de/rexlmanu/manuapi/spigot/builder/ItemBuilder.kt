/*
 * © Copyright - Emmanuel Lampe aka. rexlManu 2018.
 */
package de.rexlmanu.manuapi.spigot.builder

import de.rexlmanu.manuapi.kotlin.interfaces.Builder;
import org.bukkit.inventory.ItemStack
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.setItemMeta
import java.util.UUID
import com.mojang.authlib.GameProfile
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.getItemMeta
import org.bukkit.inventory.meta.ItemMeta
import java.nio.file.Files.setOwner
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionEffect
import org.bukkit.inventory.meta.MapMeta
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.inventory.meta.FireworkMeta
import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkEffectMeta
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.BlockStateMeta
import org.apache.commons.lang3.StringUtils.removePattern
import org.bukkit.inventory.meta.BannerMeta
import org.bukkit.DyeColor
import org.bukkit.inventory.ItemFlag
import java.util.Collections.singletonList



/******************************************************************************************
 *    Urheberrechtshinweis
 *    Copyright © Emmanuel Lampe 2018
 *    Erstellt: 05.05.2018 / 14:32
 *
 *    Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.
 *    Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet,
 *    bei Emmanuel Lampe. Alle Rechte vorbehalten.
 *
 *    Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,
 *    öffentlichen Zugänglichmachung oder andere Nutzung
 *    bedarf der ausdrücklichen, schriftlichen Zustimmung von Emmanuel Lampe.
 ******************************************************************************************/

@Getter
class ItemBuilder : Builder<ItemStack> {
    private val itemStack: ItemStack

    /*CREATE*/
    constructor(itemStack: ItemStack) {
        this.itemStack = itemStack
    }

    constructor(@NonNull material: Material) {
        this.itemStack = ItemStack(material)
    }

    constructor(@NonNull material: Material, amount: Int) {
        this.itemStack = ItemStack(material, amount)
    }

    constructor(@NonNull material: Material, damage: Short) {
        this.itemStack = ItemStack(material, 1, damage)
    }

    constructor(@NonNull material: Material, amount: Int, damage: Short) {
        this.itemStack = ItemStack(material, amount, damage)
    }
    /*CREATE*/

    /*ItemStack Setter*/
    fun setMaterial(material: Material): ItemBuilder {
        getItemStack().setType(material)
        return this
    }

    fun setType(material: Material): ItemBuilder {
        getItemStack().setType(material)
        return this
    }

    fun setAmount(amount: Int): ItemBuilder {
        getItemStack().setAmount(amount)
        return this
    }

    fun setDamage(damage: Short): ItemBuilder {
        getItemStack().setDurability(damage)
        return this
    }

    fun setDurability(durability: Short): ItemBuilder {
        getItemStack().setDurability(durability)
        return this
    }
    /*ItemStack Setter*/

    /*ItemStack Add*/
    fun addEnchantment(enchantment: Enchantment, level: Int): ItemBuilder {
        getItemStack().addEnchantment(enchantment, level)
        return this
    }

    fun addEnchantments(enchantments: Map<Enchantment, Int>): ItemBuilder {
        getItemStack().addEnchantments(enchantments)
        return this
    }

    fun addUnsafeEnchantment(enchantment: Enchantment, level: Int): ItemBuilder {
        getItemStack().addUnsafeEnchantment(enchantment, level)
        return this
    }

    fun addUnsafeEnchantments(enchantments: Map<Enchantment, Int>): ItemBuilder {
        getItemStack().addUnsafeEnchantments(enchantments)
        return this
    }

    fun addLore(lore: List<String>): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().addAll(lore)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun addLore(i: Int, lore: List<String>): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().addAll(i, lore)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun addLore(lore: String): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().add(lore)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun addLore(i: Int, lore: String): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().add(i, lore)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*ItemStack Add*/

    /*ItemStack Remove*/
    fun removeEnchantment(enchantment: Enchantment): ItemBuilder {
        getItemStack().removeEnchantment(enchantment)
        return this
    }

    fun removeLore(lore: List<String>): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().removeAll(lore)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun removeLore(i: Int): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getLore().removeAt(i)
        itemMeta.setLore(itemMeta.getLore())
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*ItemStack Remove*/

    /*
     *ItemMeta Setter
     */
    fun setLore(lore: List<String>): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.setLore(lore)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun setLore(lore: String): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.setLore(Collections.singletonList(lore))
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun setName(name: String): ItemBuilder {
        return setDisplayName(name)
    }

    fun setDisplayName(displayName: String): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.setDisplayName(displayName)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun setBreakable(): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.spigot().setUnbreakable(false)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun setUnbreakable(): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.spigot().setUnbreakable(true)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun setUnbreakable(unbreakable: Boolean): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.spigot().setUnbreakable(unbreakable)
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*
     *ItemMeta Setter
     */

    /*
     *ItemMeta Add
     */
    fun addEnchant(enchantment: Enchantment, level: Int): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.addEnchant(enchantment, level, true)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun addEnchant(enchantment: Enchantment, level: Int, ignoreLevelRestriction: Boolean): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun addItemFlags(vararg itemFlags: ItemFlag): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.addItemFlags(*itemFlags)
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*
     *ItemMeta Add
     */

    /*
     *ItemMeta Remove
     */
    fun removeEnchant(enchantment: Enchantment): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.removeEnchant(enchantment)
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun removeItemFlags(vararg itemFlags: ItemFlag): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.removeItemFlags(*itemFlags)
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*
     *ItemMeta Remove
     */

    /*
     *ItemMeta Clear
     */
    fun clearEnchants(): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getEnchants().clear()
        getItemStack().setItemMeta(itemMeta)
        return this
    }

    fun clearItemFlags(): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.getItemFlags().clear()
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*
     *ItemMeta Clear
     */

    /*
     *ItemMeta Hide
     */
    fun hideItemFlags(): ItemBuilder {
        val itemMeta = getItemStack().getItemMeta()
        itemMeta.addItemFlags(*ItemFlag.values())
        getItemStack().setItemMeta(itemMeta)
        return this
    }
    /*
     *ItemMeta Hide
     */

    /*
     *BannerMeta Setter
     */
    fun setBaseColor(dyeColor: DyeColor): ItemBuilder {
        try {
            val bannerMeta = getItemStack().getItemMeta() as BannerMeta
            bannerMeta.baseColor = dyeColor
            getItemStack().setItemMeta(bannerMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPatterns(patterns: List<Pattern>): ItemBuilder {
        try {
            val bannerMeta = getItemStack().getItemMeta() as BannerMeta
            bannerMeta.patterns = patterns
            getItemStack().setItemMeta(bannerMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPattern(i: Int, pattern: Pattern): ItemBuilder {
        try {
            val bannerMeta = getItemStack().getItemMeta() as BannerMeta
            bannerMeta.setPattern(i, pattern)
            getItemStack().setItemMeta(bannerMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BannerMeta Setter
     */

    /*
     *BannerMeta Add
     */
    fun addPattern(pattern: Pattern): ItemBuilder {
        try {
            val bannerMeta = getItemStack().getItemMeta() as BannerMeta
            bannerMeta.addPattern(pattern)
            getItemStack().setItemMeta(bannerMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BannerMeta Add
     */

    /*
     *BannerMeta Remove
     */
    fun removePattern(i: Int): ItemBuilder {
        try {
            val bannerMeta = getItemStack().getItemMeta() as BannerMeta
            bannerMeta.removePattern(i)
            getItemStack().setItemMeta(bannerMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BannerMeta Remove
     */

    /*
     *BlockStateMeta Setter
     */
    fun setBlockState(blockState: BlockState): ItemBuilder {
        try {
            val blockStateMeta = getItemStack().getItemMeta() as BlockStateMeta
            blockStateMeta.blockState = blockState
            getItemStack().setItemMeta(blockStateMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BlockStateMeta Setter
     */

    /*
     *BookMeta Setter
     */
    fun setTitle(title: String): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.title = title
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setAuthor(author: String): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.author = author
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPage(i: Int, page: String): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.setPage(i, page)
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPages(pages: List<String>): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.pages = pages
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPages(vararg pages: String): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.setPages(*pages)
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BookMeta Setter
     */

    /*
     *BookMeta Add
     */
    fun addPage(vararg page: String): ItemBuilder {
        try {
            val bookMeta = getItemStack().getItemMeta() as BookMeta
            bookMeta.addPage(*page)
            getItemStack().setItemMeta(bookMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *BookMeta Add
     */

    /*
     *FireworkEffectMeta Setter
     */
    fun setFireworkEffectMetaEffect(fireworkEffect: FireworkEffect): ItemBuilder {
        try {
            val fireworkEffectMeta = getItemStack().getItemMeta() as FireworkEffectMeta
            fireworkEffectMeta.effect = fireworkEffect
            getItemStack().setItemMeta(fireworkEffectMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *FireworkEffectMeta Setter
     */

    /*
     *FireworkMeta Setter
     */
    fun setFireworkMetaEffect(fireworkEffect: FireworkEffect): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.addEffect(fireworkEffect)
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setFireworkMetaEffect(vararg fireworkEffect: FireworkEffect): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.addEffects(*fireworkEffect)
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setFireworkMetaEffect(fireworkEffect: Iterable<FireworkEffect>): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.addEffects(fireworkEffect)
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    fun setPower(power: Int): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.power = power
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *FireworkMeta Setter
     */

    /*
     *FireworkMeta Remove
     */
    fun removeEffect(effect: Int): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.removeEffect(effect)
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *FireworkMeta Remove
     */

    /*
     *FireworkMeta Clear
     */
    fun clearEffects(): ItemBuilder {
        try {
            val fireworkMeta = getItemStack().getItemMeta() as FireworkMeta
            fireworkMeta.clearEffects()
            getItemStack().setItemMeta(fireworkMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *FireworkMeta Clear
     */

    /*
     *LeatherArmorMeta Setter
     */
    fun setColor(color: Color): ItemBuilder {
        try {
            val leatherArmorMeta = getItemStack().getItemMeta() as LeatherArmorMeta
            leatherArmorMeta.color = color
            getItemStack().setItemMeta(leatherArmorMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *LeatherArmorMeta Setter
     */

    /*
     *MapMeta Setter
     */
    fun setScaling(value: Boolean): ItemBuilder {
        try {
            val mapMeta = getItemStack().getItemMeta() as MapMeta
            mapMeta.isScaling = value
            getItemStack().setItemMeta(mapMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *MapMeta Setter
     */

    /*
     *PotionMeta Setter
     */
    fun setMainEffect(potionEffectType: PotionEffectType): ItemBuilder {
        try {
            val potionMeta = getItemStack().getItemMeta() as PotionMeta
            potionMeta.setMainEffect(potionEffectType)
            getItemStack().setItemMeta(potionMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *PotionMeta Setter
     */

    /*
     *PotionMeta Add
     */
    fun addCustomEffect(potionEffect: PotionEffect, overwrite: Boolean): ItemBuilder {
        try {
            val potionMeta = getItemStack().getItemMeta() as PotionMeta
            potionMeta.addCustomEffect(potionEffect, overwrite)
            getItemStack().setItemMeta(potionMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *PotionMeta Add
     */

    /*
     *PotionMeta Remove
     */
    fun removeCustomEffect(potionEffectType: PotionEffectType): ItemBuilder {
        try {
            val potionMeta = getItemStack().getItemMeta() as PotionMeta
            potionMeta.removeCustomEffect(potionEffectType)
            getItemStack().setItemMeta(potionMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *PotionMeta Remove
     */

    /*
     *PotionMeta Clear
     */
    fun clearCustomEffects(): ItemBuilder {
        try {
            val potionMeta = getItemStack().getItemMeta() as PotionMeta
            potionMeta.clearCustomEffects()
            getItemStack().setItemMeta(potionMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *PotionMeta Clear
     */

    /*
     *SkullMeta Setter
     */
    fun setOwner(owner: String): ItemBuilder {
        try {
            val skullMeta = getItemStack().getItemMeta() as SkullMeta
            skullMeta.owner = owner
            getItemStack().setItemMeta(skullMeta)
        } catch (ignored: ClassCastException) {
        }

        return this
    }
    /*
     *SkullMeta Setter
     */

    fun setOwnerFromURL(@NonNull url: String, @NonNull name: String): ItemBuilder {
        try {
            if (!url.isEmpty()) {
                val itemMeta = getItemStack().getItemMeta()
                val gameProfile = GameProfile(UUID.randomUUID(), name)
                gameProfile.properties.put("textures", Property("textures", String(Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).toByteArray()))))
                ReflectUtils.setValue(itemMeta, "profile", gameProfile)
                getItemStack().setItemMeta(itemMeta)
            }
        } catch (ignored: ClassCastException) {
        }

        return this
    }

    /*
     *Extras
     */
    fun clone(): ItemBuilder {
        return ItemBuilder(getItemStack().clone())
    }

    fun build(): ItemStack {
        return getItemStack()
    }
    /*
     *Extras
     */
}