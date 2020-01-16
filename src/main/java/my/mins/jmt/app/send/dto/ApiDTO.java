package my.mins.jmt.app.send.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ApiDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Req {
        private String to;
        private String message;
    }

    public static class Res {

    }
}
