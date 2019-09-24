package net.zhaoxuyang.common.current.utilities.e3;

public class Shared {

        private char c;
        private volatile boolean writeable = true;

        synchronized void setSharedChar(char c) {
            while (!writeable) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            this.c = c;
            writeable = false;
            notify();
        }

        synchronized char getSharedChar() {
            while (writeable) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            writeable = true;
            notify();
            return c;

        }
    }