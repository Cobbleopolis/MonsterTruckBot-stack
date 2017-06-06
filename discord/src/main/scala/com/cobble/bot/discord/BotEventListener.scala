package com.cobble.bot.discord

import com.cobble.bot.discord.api.DiscordCommand
import com.cobble.bot.discord.event.CommandExecutionEvent
import sx.blah.discord.api.events.EventSubscriber
import sx.blah.discord.handle.impl.events.ReadyEvent
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent
import sx.blah.discord.handle.obj.IMessage

class BotEventListener {

    val commandPrefix: String = Option(DiscordBot.conf.getString("bot.commandPrefix")).getOrElse("!")

    @EventSubscriber
    def onReadyEvent(event: ReadyEvent): Unit = {
        println("Bot is ready!")
        DiscordBot.client.changeUsername(Option(DiscordBot.conf.getString("bot.discord.username")).getOrElse("Monster Truck Bot"))
        DiscordBot.client.online(Option(DiscordBot.conf.getString("bot.discord.game")).getOrElse("Hap! Hap! Hap!"))
    }

    @EventSubscriber
    def onMessageReceivedEvent(event: MessageReceivedEvent): Unit = {
        implicit val message: IMessage = event.getMessage
        if (!message.getAuthor.isBot)
            if (message.getContent.startsWith(commandPrefix)) {
                val contentSplit: Array[String] = message.getContent.split("\\s")
                DiscordBot.client.getDispatcher.dispatch(new CommandExecutionEvent(
                    message,
                    contentSplit.head.substring(commandPrefix.length),
                    contentSplit.tail,
                    message.getAuthor
                ))
            } else {
                //TODO actually pull filter settings from the database.
//                capsFilter.filterMessage(message, FilterSettings(message.getGuild.getID, capsFilterEnabled = true))
                //TODO figure out what mods want about warnings/bans/things
            }
    }

    @EventSubscriber
    def onCommandExecutionEvent(event: CommandExecutionEvent): Unit = {
        implicit val message: IMessage = event.getMessage
        val commandOpt: Option[DiscordCommand] = DiscordCommandRegistry.commandList.get(event.getCommand)
        if (commandOpt.isDefined)
            commandOpt.get.execute(event)
    }
}
