package com.cobble.bot.discord.commands

import com.cobble.bot.common.api.commands.PingCommand
import com.cobble.bot.discord.api.DiscordCommand
import com.cobble.bot.discord.event.CommandExecutionEvent

class DiscordPingCommand extends DiscordCommand with PingCommand {

    override def execute(implicit event: CommandExecutionEvent): Unit = event.reply("ping")

}
