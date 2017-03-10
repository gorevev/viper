package com.gorevev.testapplication.presentation._common;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Created by denischuvasov on 10.02.17.
 */

public abstract class BaseNavigator extends SupportFragmentNavigator {
    private static final String TAG = "BaseNavigator";

    private AppCompatActivity activity;

    public BaseNavigator(AppCompatActivity activity, int containerId) {
        super(activity.getSupportFragmentManager(), containerId);
        this.activity = activity;
    }

    @Override
    public void applyCommand(Command command) {
        Intent intent = createIntent(command);

        if(intent == null) {
            super.applyCommand(command);

        } else if (command instanceof Forward) {
            activity.startActivity(intent);

        } else if(command instanceof Replace) {
            activity.startActivity(intent);
            activity.finish();

        } else {
            Log.e(TAG, "Command " + command.getClass().getSimpleName() + " was not executed!");
        }
    }

    private @Nullable Intent createIntent(Command command) {
        if(command instanceof Replace) {
            return createIntent(activity, ((Replace) command).getScreenKey(), ((Replace) command).getTransitionData());

        } else if(command instanceof Forward) {
            return createIntent(activity, ((Forward) command).getScreenKey(), ((Forward) command).getTransitionData());
        }

        return null;
    }

    @Override
    protected void showSystemMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void exit() {
        activity.finish();
    }

    protected abstract @Nullable Intent createIntent(Context context, String screenName, Object transferData);
}
