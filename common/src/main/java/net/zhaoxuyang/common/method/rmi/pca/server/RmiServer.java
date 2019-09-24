package net.zhaoxuyang.common.method.rmi.pca.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {

    public static void main(String args[]) {
        try {
            String host;
            int port;
            String name;
            if(args == null || args.length == 0){
                 host = "127.0.0.1";
                 port = 9999;
                 name = "pca";
            } else {
                host = args[0];
                port = Integer.valueOf(args[1]);
                name = args[2];
            }
            
            String bindUrl = String.format("rmi://%s:%d/%s", host, port, name);

            PcaServiceImpl pcaService = new PcaServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind(name, pcaService);
            System.out.printf("[%s]远程对象绑定成功：\n%s\n", pcaService.getClass().getName(), bindUrl);
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常！");
            e.printStackTrace();
        }
    }
}
