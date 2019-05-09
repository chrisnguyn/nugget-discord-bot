import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class main {

    public static void main(String[] args) throws Exception
    {
        JDA build = new JDABuilder("NTc1MjkyOTQ3MDk2OTI4MjU3.XNSGRA.hW_w75qk0ut7_A8bpvLpBdLYK_I").build();

        build.addEventListener(new botCommands());
    }

}