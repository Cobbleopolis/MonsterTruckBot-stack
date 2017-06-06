package com.cobble.bot.discord

import com.cobble.bot.discord.api.DiscordCommand
import com.cobble.bot.discord.commands.DiscordPingCommand

object DiscordCommandRegistry {

    val pingCommand: DiscordPingCommand = new DiscordPingCommand()

    val commandList: Map[String, DiscordCommand] = Map(
        pingCommand.name -> pingCommand
    )

}
