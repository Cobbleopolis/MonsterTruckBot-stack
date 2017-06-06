package com.cobble.bot.discord.api

import com.cobble.bot.common.api.Command
import com.cobble.bot.discord.event.CommandExecutionEvent

trait DiscordCommand extends Command {

    def execute(implicit event: CommandExecutionEvent)

}
