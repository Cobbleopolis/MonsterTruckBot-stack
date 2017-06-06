package com.cobble.bot.discord

import com.typesafe.config.{Config, ConfigFactory}
import sx.blah.discord.api.events.EventDispatcher
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}

object DiscordBot {

    private val clientBuilder: ClientBuilder = new ClientBuilder()

    lazy val client: IDiscordClient = clientBuilder.login()

    val conf: Config = ConfigFactory.load()

    def main(args: Array[String]): Unit = {
        clientBuilder.withToken(conf.getString("bot.discord.token"))
        val dispatcher: EventDispatcher = client.getDispatcher
        dispatcher.registerListener(new BotEventListener)
        scala.sys.addShutdownHook {
            println("Monster Truck Bot Discord logging out...")
            client.logout()
            println("Monster Truck Bot Discord logged out")
        }
    }

}
