package day01;

/**
 * 接口的应用：代理模式
 */
public class Proxy {
    public static void main(String[] args) {

        NetWork work = new Server();
        ProxyServer proxyServer = new ProxyServer(work);
        proxyServer.browse();

    }
}


interface NetWork{
    public void browse();
}

class Server implements NetWork{
    @Override
    public void browse() {
        System.out.println("访问服务器");
    }
}
class ProxyServer implements NetWork{

    private NetWork work;

    public ProxyServer(NetWork work){
        this.work = work;
    }

    public void check(){
        System.out.println("联网前的检查");
    }
    @Override
    public void browse() {
        check();

        work.browse();
    }
}