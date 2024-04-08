package com.example.bank.account;

import com.example.bank.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "account_tb")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(unique = true, nullable = false, length = 4)
    private Integer number; // 1111, 2222

    @Column(nullable = false, length = 4)
    private String password;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private Boolean status; // true, false

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public Account(Long id, User user, Integer number, String password, Long balance, Boolean status, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }
}