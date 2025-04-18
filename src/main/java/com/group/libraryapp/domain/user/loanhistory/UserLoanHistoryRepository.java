package com.group.libraryapp.domain.user.loanhistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndIsReturn(String bookName, Boolean isReturn);
//    Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);
}
