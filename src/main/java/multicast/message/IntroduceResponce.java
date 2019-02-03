package multicast.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntroduceResponce extends BaseMessage {
    private String name;
    private String ip;
    private int port;

    public IntroduceResponce() {
        super.messageType = MessageType.IntroduceResponse;
    }
}
