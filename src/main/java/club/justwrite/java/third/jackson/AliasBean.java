package club.justwrite.java.third.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AliasBean {

    @JsonAlias({"first_name", "f_name"})
    private String firstName;

    private String lastName;

//    public AliasBean(){
//
//    }

//    @JsonCreator
//    public AliasBean(@JsonProperty("firstName") String firstName, @JsonProperty("lastName")String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "AliasBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
