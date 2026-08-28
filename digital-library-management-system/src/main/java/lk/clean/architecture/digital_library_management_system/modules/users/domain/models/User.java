package lk.clean.architecture.digital_library_management_system.modules.users.domain.models;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.enums.UserStatus;

import java.util.UUID;

public class User {

    //max book borrow count
    private static final int MAX_BOOK_BORROW_COUNT = 5;

    private final UUID userId;
    private String userName;
    private String email;
    private UserStatus status;
    private int activeBookCount;

    public User(UUID userId, String userName, String email, UserStatus status, int activeBookCount) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.status = status;
        this.activeBookCount = activeBookCount;
    }


    /* __GETTERS__ */


    public UUID getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public UserStatus getStatus() { return status; }
    public int getActiveBookCount() { return activeBookCount; }


    /* __DOMAIN_LOGICS__ */


    //user suspending and book limit check
    public void borrowBook(Book book, int currentBookBorrowCount) {
        if(this.status == UserStatus.SUSPENDED){
            throw new IllegalStateException("User has been suspended");
        }
        if(currentBookBorrowCount >= MAX_BOOK_BORROW_COUNT) {
            throw new IllegalStateException("User has been reached book borrow limit");
        }
    }

    //check user activation
    public void checkUserActivation() {
        if(this.status != UserStatus.ACTIVE){
            throw new IllegalStateException("User has not been activated");
        }
    }

}

