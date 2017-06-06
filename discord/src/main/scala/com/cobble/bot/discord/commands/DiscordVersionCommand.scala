package com.cobble.bot.discord.commands

import buildinfo.BuildInfo
import com.cobble.bot.common.api.commands.VersionCommand
import com.cobble.bot.discord.api.DiscordCommand
import com.cobble.bot.discord.event.CommandExecutionEvent

class DiscordVersionCommand extends DiscordCommand with VersionCommand {

    override def execute(implicit event: CommandExecutionEvent): Unit = event.reply(BuildInfo.version)

}