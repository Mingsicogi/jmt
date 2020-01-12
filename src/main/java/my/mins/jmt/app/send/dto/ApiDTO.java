package my.mins.jmt.app.send.dto;

import lombok.Getter;
import lombok.Setter;

public class ApiDTO {

    @Getter
    @Setter
    public static class Req {

        private String message;
    }

    public static class Res {

    }
}
