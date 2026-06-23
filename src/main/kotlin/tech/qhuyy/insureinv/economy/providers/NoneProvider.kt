package tech.qhuyy.insureinv.economy.providers

import org.bukkit.OfflinePlayer
import tech.qhuyy.insureinv.economy.EconomyProvider

data object NoneProvider : EconomyProvider {

    override fun isAvailable(): Boolean = false

    override fun getBalance(player: OfflinePlayer): Double = 0.0

    override fun hasBalance(player: OfflinePlayer, amount: Double): Boolean = false

    override fun withdraw(player: OfflinePlayer, amount: Double): Boolean = false

    override fun deposit(player: OfflinePlayer, amount: Double): Boolean = false

    override fun formatAmount(amount: Double): String = String.format("%.2f", amount)
}