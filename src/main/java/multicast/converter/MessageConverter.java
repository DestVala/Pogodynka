package multicast.converter;


import com.fasterxml.jackson.databind.ObjectMapper;
import multicast.message.BaseMessage;
import multicast.message.IntroduceRequest;
import multicast.message.IntroduceResponce;
import multicast.message.MessageType;
import multicast.network.UdpPacket;


import java.io.IOException;

public class MessageConverter {



    private ObjectMapper objectMapper;

    public MessageConverter() {
        objectMapper = new ObjectMapper();
    }

    public BaseMessage deserialize(UdpPacket data) {
        switch (data.getType()) {
            case IntroduceRequest:
                break;
            case IntroduceResponse:
                break;
        }
        return null;
    }

    public UdpPacket serialize(BaseMessage message) {
        String jsonString = null;
        MessageType msgType = null;
        int length;
        // Check type and assign to byte
        if (message instanceof IntroduceRequest) {
            msgType = MessageType.IntroduceRequest;
        } else if (message instanceof IntroduceResponce) {
            msgType = MessageType.IntroduceResponse;
        }

        // convert message to json
        try {
            jsonString = objectMapper.writeValueAsString(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // convert json to byte array
        byte[] jsonByte = jsonString.getBytes();
        // check message byte array length
        length = jsonByte.length;
        // return new UdpPacket(msgType,);

        return new UdpPacket(msgType,length,jsonByte);
    }
}
