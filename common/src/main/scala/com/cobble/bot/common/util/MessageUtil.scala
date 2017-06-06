package com.cobble.bot.common.util

import java.text.MessageFormat

import com.typesafe.config.{Config, ConfigFactory}

object MessageUtil {

    val arrowChar: Char = '\u21D2'

    private val messages: Config = ConfigFactory.load("messages.conf")

    def localizeMessage(messageKey: String, args: Any*): String = {
        if (messages.hasPathOrNull(messageKey))
            MessageFormat.format(messages.getString(messageKey), args.map(_.asInstanceOf[Object]): _*)
        else
            messageKey
    }

    def formatMessage(userMention: String, messageKey: String, args: Any*): String = s"$userMention $arrowChar ${localizeMessage(messageKey, args)}"

}
