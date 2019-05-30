import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class main {

    public static void main(String[] args) throws Exception
    {
        JDA build = new JDABuilder("TOKEN GOES HERE").build();

        build.addEventListener(new botCommands());
    }

}