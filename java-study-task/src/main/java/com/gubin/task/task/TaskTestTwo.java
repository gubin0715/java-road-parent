package com.gubin.task.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TaskTestTwo extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===========================定时任务测试（二），开始执行============================");
        System.out.println("        ,----,                                                ,----,                                             ,----,                       \n" +
                "      ,/   .`|                                              ,/   .`|                                           ,/   .`|                       \n" +
                "    ,`   .'  :                            ,-.             ,`   .'  :                      ___                ,`   .'  :                       \n" +
                "  ;    ;     /                        ,--/ /|           ;    ;     /                    ,--.'|_            ;    ;     /                       \n" +
                ".'___,/    ,'                       ,--. :/ |         .'___,/    ,'                     |  | :,'         .'___,/    ,'        .---.   ,---.   \n" +
                "|    :     |              .--.--.   :  : ' /          |    :     |            .--.--.   :  : ' :         |    :     |        /. ./|  '   ,'\\  \n" +
                ";    |.';  ;  ,--.--.    /  /    '  |  '  /           ;    |.';  ;   ,---.   /  /    '.;__,'  /          ;    |.';  ;     .-'-. ' | /   /   | \n" +
                "`----'  |  | /       \\  |  :  /`./  '  |  :           `----'  |  |  /     \\ |  :  /`./|  |   |           `----'  |  |    /___/ \\: |.   ; ,. : \n" +
                "    '   :  ;.--.  .-. | |  :  ;_    |  |   \\              '   :  ; /    /  ||  :  ;_  :__,'| :               '   :  ; .-'.. '   ' .'   | |: : \n" +
                "    |   |  ' \\__\\/: . .  \\  \\    `. '  : |. \\             |   |  '.    ' / | \\  \\    `. '  : |__             |   |  '/___/ \\:     ''   | .; : \n" +
                "    '   :  | ,\" .--.; |   `----.   \\|  | ' \\ \\            '   :  |'   ;   /|  `----.   \\|  | '.'|            '   :  |.   \\  ' .\\   |   :    | \n" +
                "    ;   |.' /  /  ,.  |  /  /`--'  /'  : |--'             ;   |.' '   |  / | /  /`--'  /;  :    ;            ;   |.'  \\   \\   ' \\ | \\   \\  /  \n" +
                "    '---'  ;  :   .'   \\'--'.     / ;  |,'                '---'   |   :    |'--'.     / |  ,   /             '---'     \\   \\  |--\"   `----'   \n" +
                "           |  ,     .-./  `--'---'  '--'                           \\   \\  /   `--'---'   ---`-'                         \\   \\ |               \n" +
                "            `--`---'                                                `----'                                               '---\"                \n" +
                "                                                                                                                                              ");
        System.out.println("===========================定时任务测试（二），执行结束============================");
    }
}
