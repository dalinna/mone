package com.xiaomi.testtll2511201723.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final Random random = new Random();

    /**
     * 生成随机数接口
     * @return 返回一个随机整数
     */
    @GetMapping("/random")
    public RandomNumberResponse generateRandomNumber() {
        int randomNumber = random.nextInt(1000); // 生成0-999之间的随机数
        return new RandomNumberResponse(randomNumber);
    }

    /**
     * 生成指定范围内的随机数
     * @param min 最小值
     * @param max 最大值
     * @return 返回指定范围内的随机整数
     */
    @GetMapping("/random/range")
    public RandomNumberResponse generateRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("最小值必须小于最大值");
        }
        int randomNumber = random.nextInt(max - min + 1) + min;
        return new RandomNumberResponse(randomNumber);
    }

    /**
     * 随机数响应类
     */
    public static class RandomNumberResponse {
        private int randomNumber;
        private String message;

        public RandomNumberResponse(int randomNumber) {
            this.randomNumber = randomNumber;
            this.message = "成功生成随机数";
        }

        // Getter 和 Setter 方法
        public int getRandomNumber() {
            return randomNumber;
        }

        public void setRandomNumber(int randomNumber) {
            this.randomNumber = randomNumber;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}