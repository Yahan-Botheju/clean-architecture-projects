package lk.clean.architecture.digital_library_management_system.modules.users.domain.models;

import lk.clean.architecture.digital_library_management_system.modules.books.domain.enums.BookStatus;
import lk.clean.architecture.digital_library_management_system.modules.books.domain.models.Book;
import lk.clean.architecture.digital_library_management_system.modules.users.domain.enums.UserStatus;

import java.util.UUID;

public class User {
    private final UUID userId;
    private String userName;
    private String email;
    private UserStatus status;

    public User(UUID userId, String userName, String email, UserStatus status) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.status = status;
    }


    /* __GETTERS__ */

    public UUID getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public UserStatus getStatus() { return status; }


    /* __DOMAIN_LOGICS__ */


    //suspended user cannot borrow book
    public void borrowBook(Book book) {
        if(this.status == UserStatus.SUSPENDED){
            throw new IllegalStateException("User has been suspended");
        }
        book.borrowBook(this.userId);
    }


}

