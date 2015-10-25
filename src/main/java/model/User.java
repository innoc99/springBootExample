package model;

import com.google.common.base.MoreObjects;

/**
 * Created by illy on 2015. 10. 25..
 */
public class User {
    String id;
    String name;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("password", password)
                .toString();
    }

    public static void main(String[] args){
        System.out.println(new User());
    }
}
