package com.gubin.api.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TaskTestOne extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===========================定时任务测试（一），开始执行============================");
        System.out.println("        ,----,                                                ,----,                                                                          \n" +
                "      ,/   .`|                                              ,/   .`|                                         ,----..                          \n" +
                "    ,`   .'  :                            ,-.             ,`   .'  :                      ___               /   /   \\                         \n" +
                "  ;    ;     /                        ,--/ /|           ;    ;     /                    ,--.'|_            /   .     :                        \n" +
                ".'___,/    ,'                       ,--. :/ |         .'___,/    ,'                     |  | :,'          .   /   ;.  \\      ,---,            \n" +
                "|    :     |              .--.--.   :  : ' /          |    :     |            .--.--.   :  : ' :         .   ;   /  ` ;  ,-+-. /  |           \n" +
                ";    |.';  ;  ,--.--.    /  /    '  |  '  /           ;    |.';  ;   ,---.   /  /    '.;__,'  /          ;   |  ; \\ ; | ,--.'|'   |   ,---.   \n" +
                "`----'  |  | /       \\  |  :  /`./  '  |  :           `----'  |  |  /     \\ |  :  /`./|  |   |           |   :  | ; | '|   |  ,\"' |  /     \\  \n" +
                "    '   :  ;.--.  .-. | |  :  ;_    |  |   \\              '   :  ; /    /  ||  :  ;_  :__,'| :           .   |  ' ' ' :|   | /  | | /    /  | \n" +
                "    |   |  ' \\__\\/: . .  \\  \\    `. '  : |. \\             |   |  '.    ' / | \\  \\    `. '  : |__         '   ;  \\; /  ||   | |  | |.    ' / | \n" +
                "    '   :  | ,\" .--.; |   `----.   \\|  | ' \\ \\            '   :  |'   ;   /|  `----.   \\|  | '.'|         \\   \\  ',  / |   | |  |/ '   ;   /| \n" +
                "    ;   |.' /  /  ,.  |  /  /`--'  /'  : |--'             ;   |.' '   |  / | /  /`--'  /;  :    ;          ;   :    /  |   | |--'  '   |  / | \n" +
                "    '---'  ;  :   .'   \\'--'.     / ;  |,'                '---'   |   :    |'--'.     / |  ,   /            \\   \\ .'   |   |/      |   :    | \n" +
                "           |  ,     .-./  `--'---'  '--'                           \\   \\  /   `--'---'   ---`-'              `---`     '---'        \\   \\  /  \n" +
                "            `--`---'                                                `----'                                                           `----'   \n" +
                "                                                                                                                                              ");
        System.out.println("===========================定时任务测试（一），执行结束============================");
    }
}
