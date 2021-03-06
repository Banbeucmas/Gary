package me.piggypiglet.gary.core.tasks;

import com.google.inject.Inject;
import me.piggypiglet.gary.chatreaction.tasks.WordChanger;
import net.dv8tion.jda.core.JDA;

import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

// ------------------------------
// Copyright (c) PiggyPiglet 2018
// https://www.piggypiglet.me
// ------------------------------
public final class RunTasks {
    @Inject private ChannelClearing cc;
    @Inject private WordChanger wc;

    public void setup(JDA jda) {
        cc.setup(jda);
        wc.setup(jda);
    }

    public void runTasks() {
        Timer timer = new Timer();

        System.out.println("Task - Request, offer and rms service cleaning started");
        long timeCC = TimeUnit.DAYS.toMillis(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        timer.schedule(cc, timeCC, timeCC);

        System.out.println("Task - ChatReaction started");
        long timeAF = TimeUnit.MINUTES.toMillis(5);
        timer.schedule(wc, TimeUnit.SECONDS.toMillis(1), timeAF);
    }
}
