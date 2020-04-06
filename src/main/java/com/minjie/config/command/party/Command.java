package com.minjie.config.command.party;

/**
 * Created by Gavin on 2017/3/14.
 */
public interface Command {
    void execute();

    void undo();
}
