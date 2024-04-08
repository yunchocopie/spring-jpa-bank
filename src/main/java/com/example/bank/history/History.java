package com.example.bank.history;

import com.example.bank.account.Account;
import com.example.bank.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "history_tb")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // select * from history_tb where sender = 1111 or receiver = 1111;
    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender; // 보낸이 (1)

    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver; // 받는이 (2)

    @Column(nullable = false)
    private Long amount; // 이체 금액

    @Column(nullable = false)
    private Long senderBalance; // 보낸이 잔액

    @Column(nullable = false)
    private Long receiverBalance; // 받는이 잔액

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public History(Long id, Account sender, Account receiver, Long amount, Long senderBalance, Long receiverBalance, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.senderBalance = senderBalance;
        this.receiverBalance = receiverBalance;
        this.createdAt = createdAt;
    }
}