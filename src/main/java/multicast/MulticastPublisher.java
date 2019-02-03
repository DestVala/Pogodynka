package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastPublisher {
    Message message= new Message();
    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;

    public void multicast(String multicastMessage) throws IOException {
        socket = new DatagramSocket();
        group = InetAddress.getByName(message.getIp());
        buf = multicastMessage.getBytes();

        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, group, message.getPort());
        socket.send(packet);
        socket.close();
    }
}
