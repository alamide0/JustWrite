package club.justwrite.java.base.rmi;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("create World clock remote service...");
        // 实例化一个WorldClock:
        // 将此服务转换为远程服务接口:
        // 将RMI服务注册到1099端口:
        // 注册此服务，服务名为"WorldClock":
        if (System.getSecurityManager() == null) {
            System.out.println("args = " + Arrays.toString(args));
            System.setSecurityManager(new SecurityManager());
        }
        try {
            WorldClock worldClock = new WorldClockService();
            WorldClock stub =
                    (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);
            Registry registry = LocateRegistry.getRegistry("localhost");
            registry.rebind("WorldClock", stub);
            System.out.println("WorldClock bound");
        } catch (Exception e) {
            System.err.println("WorldClock exception:");
            e.printStackTrace();
        }
    }
}
