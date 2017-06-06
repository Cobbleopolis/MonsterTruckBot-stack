package com.cobble.bot.discord

import com.cobble.bot.discord.api.DiscordCommand
import com.cobble.bot.discord.commands.{DiscordPingCommand, DiscordVersionCommand}

object DiscordCommandRegistry {

    val pingCommand: DiscordPingCommand = new DiscordPingCommand()

    val versionCommand: DiscordVersionCommand = new DiscordVersionCommand()

    val commandList: Map[String, DiscordCommand] = Map(
        pingCommand.name -> pingCommand,
        versionCommand.name -> versionCommand
    )

}
