package net.zhaoxuyang.demo.rmi.pca;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PcaService  extends Remote{
    public double[][] pca(double [][] datas,Double threshold) throws RemoteException;
}
