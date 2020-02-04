package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Menu {

    Menu() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
    }

    public int inputMonsterCount() throws IOException {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public int inputAttemptCount() throws IOException {
        System.out.println("시도할 회수는 몇 회 인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public void showResult(int[] result) {
        System.out.println("실행결과");
        Arrays.stream(result).forEach(value -> {
            for (int i = 0; i < value; i++) {
                String s = "-";
                System.out.print(s);
            }
            System.out.println();
        });
    }
}
