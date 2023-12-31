package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

// 对于 DictServer 来说, 和 EchoServer 相比, 大部分的东西都是一样的.
// 主要是 "根据请求计算相应" 这个步骤不太一样.
public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        // 给这个 dict 设置内容
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("fuck", "卧槽");
        // 当然, 这里可以无限多的设置键值对.....
    }

    @Override
    public String process(String request) {
        // 查词典的过程.
        return dict.getOrDefault(request, "当前单词没有查到结果!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
