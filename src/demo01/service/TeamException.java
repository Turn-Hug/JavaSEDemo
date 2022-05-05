package demo01.service;
/**
* @Description: 自定义异常类
* @Author: Hequan
* @Version:
* @Date: 2022/4/25 16:37
*/
public class TeamException extends  Exception{
//    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
        super();
    }

    public TeamException(String message) {
        super(message);
    }
}
