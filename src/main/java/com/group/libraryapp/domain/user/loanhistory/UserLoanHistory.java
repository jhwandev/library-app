package com.group.libraryapp.domain.user.loanhistory;


import com.group.libraryapp.domain.user.User;

import javax.persistence.*;


@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    private long userId;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false; // 초기 생성시 대출이니 무조건 false
    }

    protected UserLoanHistory() {
    }

    public void doReturn() {
        isReturn = true;
    }

    public String getBookName() {
        return bookName;
    }
}
