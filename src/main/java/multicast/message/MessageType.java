package multicast.message;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {
    IntroduceRequest((byte) 0),
    IntroduceResponse((byte) 1);
    private static Map<Byte, MessageType> map = new HashMap<>();

    static {
        map.put((byte) 0, IntroduceRequest);
        map.put((byte) 1, IntroduceResponse);
    }

    private byte type;

    MessageType(byte type) {
        this.type = type;
    }

    public static MessageType deserialize(byte byteCode) {
        return map.get(byteCode);
    }

    public byte serialize() {
        return type;
    }
}

/**
 * package packet.message;
 * <p>
 * import java.util.HashMap;
 * import java.util.Map;
 * <p>
 * public enum MessageType {
 * ingoing((byte) 0),
 * outgoing((byte) 1),
 * message((byte) 2),
 * confirmation((byte) 3);
 * <p>
 * private static Map<Byte, MessageType> map = new HashMap<>();
 * <p>
 * static {
 * map.put((byte) 0, ingoing);
 * map.put((byte) 1, outgoing);
 * map.put((byte) 2, message);
 * map.put((byte) 3, confirmation);
 * }
 * <p>
 * private byte type;
 * <p>
 * MessageType(byte type) {
 * this.type = type;
 * }
 * <p>
 * public static MessageType deserialize(byte byteCode) {
 * return map.get(byteCode);
 * }
 * <p>
 * public byte serialize() {
 * return type;
 * }
 * }
 **/