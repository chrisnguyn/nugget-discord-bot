import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class botCommands extends ListenerAdapter {

    // bot always checking server (guild) messages and storing it to "messageSent". when the bot sees certain words (commands), execute the following, etc.
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        double numberToConvert = 0;
        String[] messageSent = event.getMessage().getContentRaw().split(" "); // if a user enters more than 1 word, turn that message into an array split by a space character.

        /* COMMAND - !NUGGETSHELP. SAMPLE INPUT "!nuggetcommands" */
        if (messageSent[0].equalsIgnoreCase("!nuggetcommands"))
        {
            event.getChannel().sendMessage("**\"!nuggets [number] [pounds, lbs, kilograms, or kg]\"** to calculate a weight in chicken nuggets.\n\n"+
                    "**\"!nuggetamount [number]\"** converts number of chicken nuggets to respective weight in pounds and kilograms.\n\n"+
                    "**\"!cost [number]\"** gives the cost of that number of chicken nuggets.\n\n"+
                    "**\"!math\"** to get a breakdown of the math.").queue();
        }

        /* COMMAND - !NUGGETAMOUNT. SAMPLE INPUT "!nuggetamount 1217" */
        else if (messageSent[0].equalsIgnoreCase("!nuggetamount"))
        {
            numberToConvert = Double.parseDouble(messageSent[1]); // convert this to pounds and kilos now

            int inPounds = (int) (Math.round(numberToConvert / 25.919));
            int inKilos = (int) (Math.round(numberToConvert / 57.142));

            event.getChannel().sendMessage(messageSent[1] + " chicken nuggets is approximately " + inPounds + " pounds, or " + inKilos + " kilograms.").queue();
        }

        /* COMMAND - !NUGGETS. SAMPLE INPUT "!nuggets 120 lbs", "!nuggets 48 kg" */
        else if (messageSent[0].equalsIgnoreCase("!nuggets"))
        {
            if (messageSent[2].equalsIgnoreCase("lbs") || messageSent[2].equalsIgnoreCase("pounds"))
            {
                numberToConvert = Double.parseDouble(messageSent[1]);
                int numNuggets = (int) (Math.round(numberToConvert * 25.919));

                event.getChannel().sendMessage(messageSent[1] + " pounds is equal to approximately " + numNuggets + " chicken nuggets.").queue();
            }

            else if (messageSent[2].equalsIgnoreCase("kg") || messageSent[2].equalsIgnoreCase("kilograms"))
            {
                numberToConvert = Double.parseDouble(messageSent[1]);
                int numNuggets = (int) (Math.round(numberToConvert * 57.142));

                event.getChannel().sendMessage(messageSent[1] + " kilograms is equal to approximately " + numNuggets + " chicken nuggets.").queue();
            }
        }

        /* COMMAND - !COST. SAMPLE INPUT "!cost 3421" */
        else if (messageSent[0].equalsIgnoreCase("!cost"))
        {
            numberToConvert = Double.parseDouble(messageSent[1]);
            double costOfNugget = 0.862;
            double totalCost = numberToConvert * 0.862;

            String toPrint = messageSent[1] + String.format(" chicken nuggets would cost approximately %.2f CAD.", totalCost);
            event.getChannel().sendMessage(toPrint).queue();
        }

        /* COMMAND - !MATH. SAMPLE INPUT "!math" */
        else if (messageSent[0].equalsIgnoreCase("!math"))
        {
            event.getChannel().sendMessage(
                    "There are 17.5 grams in the average chicken nugget from McDonalds.\n\n"+
                            "Since there are 453.592 grams in a pound, this means there are (453.592 / 17.5), about 25.919 chicken nuggets in one pound. Multiplying this by the amount of pounds you weigh gives yours mass in chicken nuggets.\n\n"+
                            "Since there are 1000 grams in a kilogram, this means there are (1000 / 17.5), about 57.142 chicken nuggets in one kilogram. Multiplying this by the amount of kilograms you weigh gives your mass in chicken nuggets.\n\n"+
                            "Upon calling McDonalds and getting the price of 6 nuggets ($6.527 CAD including tax), 10 nuggets ($9.028 CAD including tax), and 20 nuggets ($11.853 CAD including tax), I found the individual price of a chicken nugget to be $1.09, $0.90, and $0.59 respectively. I will be using the average of these three, $0.86, to be the price of a single chicken nugget. Multiplying $0.86 by the number of nuggets gives total cost in CAD."
            ).queue();
        }

        else
        {
            // empty by design.
        }
    }
}