package ua.bobocode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity implements Comparable<User> {
    private String first_name;
    private String last_name;

    @Override
    public int compareTo(User userToCompareWith) {
        return this.first_name.compareTo(userToCompareWith.getFirst_name());
    }
}
