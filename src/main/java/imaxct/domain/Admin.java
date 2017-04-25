package imaxct.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by imaxct on 17-4-25.
 * student
 */
@Entity
@Table(name = "STU_admin")
public class Admin implements Serializable{
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 30)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
