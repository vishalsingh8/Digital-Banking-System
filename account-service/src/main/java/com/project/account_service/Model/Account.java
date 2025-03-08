package com.project.account_service.Model;

import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @Column(unique = true, nullable = false, length = 12)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(nullable = false)
    private Double balance;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    public void generateAccountNumber() {
        if (this.accountNumber == null) {
            this.accountNumber = generateRandomAccountNumber();
        }
    }

    private String generateRandomAccountNumber(){
       return String.format("%012d", new Random().nextLong(1_000_000_000_000L));
//        return String.valueOf(ThreadLocalRandom.current().nextLong(100_000_000_000L, 1_000_000_000_000L));
    }

}
