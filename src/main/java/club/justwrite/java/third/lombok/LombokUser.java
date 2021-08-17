package club.justwrite.java.third.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class LombokUser {

    private int id;

    private String username;

    private String address;

    public static void main(String[] args) {
        LombokUser lombokUser = new LombokUser(1, "alamide", "nanjing");
        System.out.println("lombokUser = " + lombokUser);
        new HashMap<>();
    }
}
