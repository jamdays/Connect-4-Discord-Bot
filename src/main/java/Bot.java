import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    private ConnectFour cFour = new ConnectFour(true);
    private Mancala mancala = new Mancala();
    private Othello o;

    private Filler filler = new Filler();

    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createDefault(/*token*/"abc123")
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new Bot())
                .setActivity(Activity.competing("creation competition concerning" +
                        " carefully conserving contemporary connect 4 confederation collectables"))
                .build();

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String player;
        if (cFour.isRed()) {
            player = "red";
        } else {
            player = "blue";
        }
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("!help")) {
            event.getChannel().sendMessage("**CONNECT 4** \n!reset- reset board \n" +
                    "!board - display board \n" +
                    "!play *col* - play the col specified (1-7)" +
                    "\n**MANCALA**\n!Mplay *spot* - play the beads in specified spot on your side (1-6) \n" +
                    "!Mreset - reset mancala board \n" +
                    "**OTHELLO**\n" +
                    "!O new - start a new game of othello\n" +
                    "!O play *row, col* - play piece (if legal) at specified row and column (0,0 - 7,7) \n" +
                            "!O save game- save the game (the bot will send a message containing the save)\n" +
                            "!O continue [save] - [save] is the game ID that the bot sent after using the save game command\n" +
                            "**FILLER**\n" +
                            "!Filler - for instructions")
                    .queue();
        }
        if (msg.getContentRaw().equals("!reset")) {
            cFour = new ConnectFour(true);
        }
        if (msg.getContentRaw().equals("!board")) {
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 1")) {
            cFour.play(1);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 2")) {
            cFour.play(2);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 3")) {
            cFour.play(3);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 4")) {
            cFour.play(4);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 5")) {
            cFour.play(5);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 6")) {
            cFour.play(6);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!play 7")) {
            cFour.play(7);
            event.getChannel().sendMessage(cFour + "")
                    .queue();
            if (cFour.isDone()) {
                event.getChannel().sendMessage(player + " won (or it is a draw but im lazy rn)")
                        .queue();
            }
        }
        //MANCALA START


        if (msg.getContentRaw().equals("!Mreset")) {
            mancala = new Mancala();
        }
        if (msg.getContentRaw().equals("!Mboard")) {
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!Mplay 1")) {
            mancala.play(1);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }

        } else if (msg.getContentRaw().equals("!Mplay 2")) {
            mancala.play(2);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }
        } else if (msg.getContentRaw().equals("!Mplay 3")) {
            mancala.play(3);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }
        } else if (msg.getContentRaw().equals("!Mplay 4")) {
            mancala.play(4);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }
        } else if (msg.getContentRaw().equals("!Mplay 5")) {
            mancala.play(5);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }
        } else if (msg.getContentRaw().equals("!Mplay 6")) {
            mancala.play(6);
            event.getChannel().sendMessage(mancala + "")
                    .queue();
            if (mancala.isWon()) {
                event.getChannel().sendMessage("player" + mancala.getWinner() + " won (player 0 means a draw)")
                        .queue();
            }
        }
        //MANCALA END


        //OTHELLO START
        if (msg.getContentRaw().equals("!O new")) {
            o = new Othello();
            event.getChannel().sendMessage(o.toString())
                    .queue();
        }
        if (msg.getContentRaw().indexOf("!O play") == 0) {
            String message = msg.getContentRaw().substring(7);
            int c = -1;
            int r = -1;
            for (int i = 0; i < message.length(); i++) {
                if (Character.isDigit(message.charAt(i))) {
                    if (c == -1) {
                        c = Integer.parseInt(String.valueOf(message.charAt(i)));
                    } else {
                        r = Integer.parseInt(String.valueOf(message.charAt(i)));
                        break;
                    }
                }
            }
            System.out.println(c + " " + r);
            o.play(r, c);
            event.getChannel().sendMessage(o.toString())
                    .queue();
            if (o.isWon()) {
                event.getChannel().sendMessage("Game finished \n Black:" + o.getbScore() +
                        "\n White: " + o.getwScore())
                        .queue();
            }
        }
        if (msg.getContentRaw().equals("!O save game")) {
            event.getChannel().sendMessage(o.generateSave()).queue();
        }
        if (msg.getContentRaw().indexOf("!O continue") == 0) {
            try {
                o = new Othello(msg.getContentRaw().substring(12));
                event.getChannel().sendMessage(o.toString())
                        .queue();
            } catch (java.lang.NumberFormatException numberFormatException) {
                event.getChannel().sendMessage("Invalid format or key").queue();
            }
        }

        //OTHELLO END
        //FILLER START
        if (msg.getContentRaw().equalsIgnoreCase("!Filler")) {
            event.getChannel().sendMessage("" +filler + "\nWelcome to Filler, \nThe object of the game is to capture as many " +
                    "squares as possible \nyou capture an adjacent square by changing to that color " +
                    "\nthe captured square will join your blob change color with you \n!F [color] to change to a color \n!F new for a new game \n " +
                    "player one starts at the bottom left & player two at the top right\nyou cannot change to the color you are already or the other player's color\n" +
                    "!F custom {y,x}- makes a custom board with y rows and x columns, y limit is 54, x limit is 14, the formatting is very specific so don't include extra spaces or sus things" +
                    "").queue();
        }
        else if (msg.getContentRaw().indexOf("!F ") == 0) {
            if (msg.getContentRaw().toLowerCase().contains("red")){
                filler.play(0);
            }
            else if (msg.getContentRaw().toLowerCase().contains("green")){
                filler.play(1);
            }
            else if (msg.getContentRaw().toLowerCase().contains("blue")){
                filler.play(2);
            }
            else if (msg.getContentRaw().toLowerCase().contains("purple")){
                filler.play(3);
            }
            else if (msg.getContentRaw().toLowerCase().contains("orange")){
                filler.play(4);
            }
            else if (msg.getContentRaw().toLowerCase().contains("yellow")){
                filler.play(5);
            }
            else if (msg.getContentRaw().toLowerCase().contains("new")){
                filler = new Filler();

            } else if(msg.getContentRaw().toLowerCase().contains("custom") &&
                    msg.getContentRaw().contains("{") &&
                    msg.getContentRaw().contains("}") && msg.getContentRaw().indexOf("{") < msg.getContentRaw().indexOf("}") &&
                    msg.getContentRaw().indexOf(",") > msg.getContentRaw().indexOf("{") && msg.getContentRaw().indexOf(",") < msg.getContentRaw().indexOf("}")){
                int x = 0;
                int y = 0;
                try{
                     x = Integer.parseInt(msg.getContentRaw().substring(msg.getContentRaw().indexOf("{") + 1, msg.getContentRaw().indexOf(",")));
                     y = Integer.parseInt(msg.getContentRaw().substring(msg.getContentRaw().indexOf(",") + 1, msg.getContentRaw().indexOf("}")));
                }catch(Exception NumberFormatException){
                    event.getChannel().sendMessage("format correctly please").queue();
                }
                if(x > 0 && y > 0 && x < 55 && y < 15){
                    filler = new Filler(x, y);
                } else{
                    filler = new Filler();
                }
            }
            else{
                event.getChannel().sendMessage("learn to spell, just kidding, actually probably do").queue();
                return;
            }
            if(filler.isWon()){
                int[] win = filler.winner();
                event.getChannel().sendMessage(win[0] + " has won, player One: " + win[1] + " player Two: " + win[2]).queue();
            }
            if(filler.dimension() > 9){
                for(String s: filler.bigToString()){
                    event.getChannel().sendMessage(s).queue();
                }
            } else{
                event.getChannel().sendMessage("" +filler).queue();
            }
        }
    }
}
