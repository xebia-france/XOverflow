package fr.xebia.xoverflow.model;

import java.io.Serializable;

import static java.util.Objects.requireNonNull;

public class UserLight implements Serializable {

    private final String id;

    private final String username;

    public UserLight(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLight userLight = (UserLight) o;

        if (id != null ? !id.equals(userLight.id) : userLight.id != null) return false;
        return username.equals(userLight.username);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + username.hashCode();
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(UserLight userLightToCopy) {
        return new Builder(userLightToCopy);
    }

    public static class Builder implements IdBuilder<UserLight> {

        protected String id;

        protected String username;

        protected Builder() {
            //  Nothing to do.
        }

        protected Builder(UserLight userLightToCopy) {
            requireNonNull(userLightToCopy, "m must be defined.");
            this.id = userLightToCopy.id;
            this.username = userLightToCopy.username;
        }

        @Override
        public UserLight build() {
            return new UserLight(id, username);
        }

        public void setId(String id) {
            this.id = id;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }
    }
}