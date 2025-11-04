package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Test
    void hash() throws NoSuchAlgorithmException {
        String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        // ✅ Chuyển byte[] sang hex string mà không cần DatatypeConverter
        String md5Hash = bytesToHex(digest);
        log.info("MD5 round 1: {}", md5Hash);

        // Lặp lại lần 2
        md.update(password.getBytes());
        digest = md.digest();
        md5Hash = bytesToHex(digest);
        log.info("MD5 round 2: {}", md5Hash);

        // BCrypt
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        log.info("BCrypt round 1: {}", passwordEncoder.encode(password));
        log.info("BCrypt round 2: {}", passwordEncoder.encode(password));
    }

    // ✅ Hàm tự viết để thay thế DatatypeConverter.printHexBinary()
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b)); // 2 ký tự hex in hoa
        }
        return sb.toString();
    }
}
