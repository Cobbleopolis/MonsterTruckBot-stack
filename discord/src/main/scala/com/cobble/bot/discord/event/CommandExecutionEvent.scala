package com.cobble.bot.discord.event

import com.cobble.bot.common.util.MessageUtil
import sx.blah.discord.api.events.Event
import sx.blah.discord.handle.obj.{IMessage, IUser}

class CommandExecutionEvent(message: IMessage, command: String, args: Array[String], user: IUser) extends Event {

    def getMessage: IMessage = message

    def getCommand: String = command

    def getArgs: Array[String] = args

    def getUser: IUser = user

    def isCommand(commandName: String): Boolean = command.equalsIgnoreCase(command)

    def reply(messageKey: String, params: Any*): Unit = message.getChannel.sendMessage(MessageUtil.formatMessage(user.mention(), messageKey, params))

    def replyDM(messageKey: String, params: Any*): Unit = user.getOrCreatePMChannel().sendMessage(MessageUtil.localizeMessage(messageKey, params))

}
