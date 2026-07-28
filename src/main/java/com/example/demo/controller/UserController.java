package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    // ==========================================
    // 查詢所有會員
    // GET /api/users
    // ==========================================

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);  // 200 OK
    }

    
    // ==========================================
    // 2. 查詢特定會員
    // GET /api/users/{id}
    // ==========================================
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            // 404 Not Found：資源不存在
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // 200 OK：找到資源
        return ResponseEntity.ok(user);
    }

    // ==========================================
    // 3. 新增會員
    // POST /api/users
    // ==========================================
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        // 201 Created：資源成功建立
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    

    // ==========================================
    // 4. 完整更新會員
    // PUT /api/users/{id}
    // ==========================================
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable String id, 
            @RequestBody User userDetails) {
        
        // 檢查資源是否存在
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        }
        
        // 將前端傳入的資料覆蓋到既有物件
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        
        // 儲存更新後的資料
        User updatedUser = userService.saveUser(existingUser);
        return ResponseEntity.ok(updatedUser);  // 200 OK
    }

    // ==========================================
    // 5. 刪除會員
    // DELETE /api/users/{id}
    // ==========================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        // 檢查資源是否存在
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404
        }
        
        userService.deleteUserById(id);
        // 204 No Content：成功刪除，無需回傳內容
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}


    

