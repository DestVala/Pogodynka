package multicast.message;

public class IntroduceRequest extends BaseMessage {
    public IntroduceRequest(){
        super.messageType=MessageType.IntroduceRequest;
    }

}
