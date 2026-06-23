package tech.qhuyy.insureinv.command.subcommands

import org.bukkit.command.CommandSender
import tech.qhuyy.insureinv.command.CommandContext
import tech.qhuyy.insureinv.command.SubCommand
import tech.qhuyy.insureinv.utils.PlaceholderUtil

class ReloadCommand : SubCommand {
    override val name = "reload"
    override val permission = "insureinv.admin"
    override val requiresPlayer = false

    override fun execute(context: CommandContext) {
        val sender = context.sender
        val messageManager = context.messageManager
        val configManager = context.configManager
        val storageManager = context.storageManager

        val oldBackend = storageManager.getCurrentBackendName()
        configManager.reload()
        storageManager.reload()
        context.economyManager.initialize()
        messageManager.reload()

        val newBackend = storageManager.getCurrentBackendName()

        messageManager.sendMessage(sender, "reload-complete")

        if (oldBackend != newBackend) {
            messageManager.sendMessage(
                sender, "reload-storage-changed",
                PlaceholderUtil.method(newBackend)
            )
        }
    }

    override fun tabComplete(sender: CommandSender, args: Array<String>): List<String> {
        return emptyList()
    }
}
