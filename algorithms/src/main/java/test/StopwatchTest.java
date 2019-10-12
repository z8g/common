/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import ratelimit.Stopwatch;

/**
 *
 * @author zhaoxuyang
 */
public class StopwatchTest {

    public static void main(String[] args) throws InterruptedException {
        Stopwatch s = new Stopwatch();
        System.out.println("实例化：" + s);
        s.start();
        Thread.sleep(100);
        System.out.println("100ms后：" + s);
        System.out.println("100ms后：" + s.elapsed());

    }
}
