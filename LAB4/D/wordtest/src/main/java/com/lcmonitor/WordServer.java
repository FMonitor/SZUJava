package com.lcmonitor;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WordServer {
    private static List<Word> words;
    private static int currentIndex = -1;
    private static int correctCount = 0;
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        loadWords();
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("服务器已启动，等待客户端连接...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

                    System.out.println("客户端已连接");

                    scheduler.scheduleAtFixedRate(() -> {
                        try {
                            if (currentIndex < words.size()-1) {
                                currentIndex++;
                                Word word = words.get(currentIndex);
                                sendWord(out, word);
                                sendResult(out);
                                System.out.println("已发送题目：" + word.word);
                                
                                if (currentIndex == 0) {
                                    in.readLine();
                                    in.readLine();
                                }

                                String userAnswer = in.readLine();
                                System.out.println("用户答案：" + userAnswer+ " 正确答案：" + word.correct);
                                if (userAnswer != null && userAnswer.equalsIgnoreCase(String.valueOf(word.correct))) {
                                    correctCount++;
                                }
                                

                            } else {
                                out.println("END");
                                out.println("总题目数量: " + words.size() + "，答对数量: " + correctCount);
                                scheduler.shutdown();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }, 0, 1, TimeUnit.SECONDS);

                    while (!scheduler.isTerminated()) {
                        // 保持主线程运行，直到定时任务完成
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadWords() {
        ClassLoader classLoader = WordServer.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("words.json");

        if (inputStream == null) {
            System.out.println("文件未找到！");
            return;
        }

        Gson gson = new Gson();
        try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            Type wordListType = new TypeToken<List<Word>>() {}.getType();
            words = gson.fromJson(reader, wordListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendWord(PrintWriter out, Word word) {
        out.println(word.word);
        out.println(word.selectionA);
        out.println(word.selectionB);
        out.println(word.selectionC);
        out.println(word.selectionD);
    }

    private static void sendResult(PrintWriter out) {
        out.println("已给出题目数量: " + (currentIndex+1) + "，答对数量: " + correctCount);
    }
}