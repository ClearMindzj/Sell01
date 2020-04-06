package com.minjie.config.command.undo;

/**
 * Created by Gavin on 2017/3/14.
 */
public class LightOnCommand implements Command {
    Light light;
    int level;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        level = light.getLevel();
        light.on();
    }

    public void undo() {
        light.dim(level);
    }
}
