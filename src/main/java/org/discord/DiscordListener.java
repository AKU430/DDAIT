package org.discord;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class DiscordListener implements EventListener {
    @Override
    public void onEvent(@NotNull GenericEvent e) {
        if (e instanceof SlashCommandInteractionEvent event) {
            if (event.getName().equals("와사바리")) {
                event.reply("씨발").queue();
                return;
            }
            if (event.getName().equals("대가리")) {
                event.reply("아잇!").queue();
                return;
            }
            event.reply("이 명령어는 없는 명령어입니다!").queue();
        } else if (e instanceof MessageReceivedEvent event) {
            if (event.getAuthor().isBot() || event.getAuthor().isSystem()) return;
            if (event.getAuthor().getId().equals("814843572695334963")) {
                if (event.getMessage().getContentRaw().equals("궶둟뤲쉢")) {
                    event.getMessage().addReaction(Emoji.fromUnicode("✅")).queue();
                    event.getMessage().reply("니애미 따라가라!").mentionRepliedUser(false).queue();
                    e.getJDA().shutdown();
                }
            }
        }
    }
}
