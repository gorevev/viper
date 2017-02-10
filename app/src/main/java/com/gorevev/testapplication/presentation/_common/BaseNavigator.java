package com.gorevev.testapplication.presentation._common;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Created by denischuvasov on 10.02.17.
 */

public abstract class BaseNavigator implements Navigator {

    protected final AppCompatActivity activity;
    private Navigator innerNavigator;

    public BaseNavigator(AppCompatActivity activity, @IdRes int container) {
        this.activity = activity;
        this.innerNavigator = new SupportFragmentNavigator(activity.getSupportFragmentManager(), container) {

            @Override
            protected Fragment createFragment(String screenKey, Object data) {
                return BaseNavigator.this.createFragment(screenKey, data);
            }

            @Override
            protected void showSystemMessage(String message) {
                BaseNavigator.this.showSystemMessage(message);
            }

            @Override
            protected void exit() {
                activity.finish();
            }
        };
    }

    @Override
    public void applyCommand(Command command) {
        if (!handleCommand(command)) {
            innerNavigator.applyCommand(command);
        }
    }

    private boolean handleCommand(Command command) {
        if (command instanceof Replace)
            return replace((Replace) command);

        return command instanceof Forward && forward(((Forward) command));
    }

    private boolean forward(Forward command) {
        Intent intent = createIntent(command.getScreenKey(), command.getTransitionData());
        if (intent != null) {
            activity.startActivity(intent);
            return true;
        }

        return false;
    }

    private boolean replace(Replace command) {
        if(forward(new Forward(command.getScreenKey(), command.getTransitionData()))) {
            activity.finish();
            return true;
        }

        return false;
    }

    protected abstract Intent createIntent(String screenName, Object transferData);

    protected abstract Fragment createFragment(String screenKey, Object data);

    protected void showSystemMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

}
