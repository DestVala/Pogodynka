package multicast;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Message {
    private String name="Pogodynka v1.0";
    private String ip="224.0.0.0";
    private int port=8090;

    public Message(){
    }
}