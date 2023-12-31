package network;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// UDP 版本的 回显客户端
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp = null;
    private int serverPort = 0;

    // 一次通信, 需要有两个 ip, 两个端口.
    // 客户端的 ip 是 127.0.0.1 已知.
    // 客户端的 port 是系统自动分配的.
    // 服务器 ip 和 端口 也需要告诉客户端. 才能顺利把消息发个服务器.
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 从控制台读取要发送的数据
            System.out.print("> ");
            String request = scanner.next();
            if (request.equals("exit")) {
                System.out.println("goodbye");
                break;
            }
            // 2. 构造成 UDP 请求, 并发送
            //    构造这个 Packet 的时候, 需要把 serverIp 和 port 都传入过来. 但是此处 IP 地址需要填写的是一个 32位的整数形式.
            //    上述的 IP 地址是一个字符串. 需要使用 InetAddress.getByName 来进行一个转换.
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            // 3. 读取服务器的 UDP 响应, 并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            // 4. 把解析好的结果显示出来.
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        // UdpEchoClient client = new UdpEchoClient("42.192.83.143", 9090);
        client.start();
    }
}
