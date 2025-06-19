package com.example.Trainingmanagement.service;

import com.example.Trainingmanagement.entity.User;
import com.example.Trainingmanagement.form.UserForm;
import com.example.Trainingmanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void createUser(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getUsername());
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);
        userRepository.insertUser(user);
    }
    /* 
    // ユーザー名の重複をチェックするメソッド
    public boolean isUsernameTaken(String username) {
        // ユーザー名が重複しているかをチェック
        logger.debug("isUsernameTaken_username:" + username); // ユーザー名をログ出力
        Optional<User> existingUser = userRepository.findByUsername(username); // 既存のユーザーを取得
        logger.debug("isUsernameTaken_existingUser:" + existingUser); // 既存のユーザーをログ出力
        return existingUser.isPresent(); // 既存のユーザーが存在するかを返す
    }
    */
}
