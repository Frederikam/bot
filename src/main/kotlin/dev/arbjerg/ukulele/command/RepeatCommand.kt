package dev.arbjerg.ukulele.command

import dev.arbjerg.ukulele.features.HelpContext
import dev.arbjerg.ukulele.jda.Command
import dev.arbjerg.ukulele.jda.CommandContext
import org.springframework.stereotype.Component

@Component
class RepeatCommand : Command ("repeat", "r", "repeatone", "ro") {
   override suspend fun CommandContext.invoke() {
       if (argumentText.isBlank()) {
           player.toggleRepeatOne()
       } else {
           player.repeatOne = argumentText.toBoolean()
       }
       
       if (player.repeatOne) return reply("The current track will be repeated until toggled off or skipped.")
       reply("Repeat (one) has been turned off and the queue will proceed as normal.")
   }

   override fun HelpContext.provideHelp() {
       addUsage("")
       addDescription("Toggles the Repeat (one) setting for the player.")
       addUsage("false (or any non true value)")
       addDescription("Turns Repeat (one) off.")
       addUsage("true")
       addDescription("Turns Repeat (one) on.")
   }
}
