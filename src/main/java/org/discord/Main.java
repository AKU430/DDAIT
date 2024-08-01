package org.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

public class Main {
    public static JDA jda;
    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(FileUtils.readToken());
        builder.setAutoReconnect(true);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("김찬 패기"));
        builder.addEventListeners(new DiscordListener());
        builder.enableIntents(
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES
        );
        jda = builder.build();
        CommandListUpdateAction commands = jda.updateCommands();
        commands.addCommands(
                new CommandDataImpl("command", "Hello, World!를 출력합니다.")
        );
        commands.queue();
    }
}
