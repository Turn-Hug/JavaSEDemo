package demo01.service;

import demo01.domain.Architect;
import demo01.domain.Designer;
import demo01.domain.Employee;
import demo01.domain.Programmer;

/**
* @Description: 团队的添加、删除功能
* @Author: Hequan
* @Version:
* @Date: 2022/4/26 10:27
*/
public class TeamService {
    private static int counter = 1;//给memberId赋值用的
    private int MAX_MEMBER = 5;//限制团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录团队中实际人数

    public TeamService() {
        super();
    }
    /**
    * @Description: 获取团队中的所有成员
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/26 10:33
    */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }
    /**
    * @Description: 将指定的员工添加到团队
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/26 10:37
    */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)){
            throw new TeamException("该成员已在团队中");
        }
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该成员已是某团队成员");
        }else if ("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该成员正在休假，无法添加");
        }
        //获取team中已有成员中架构师，设计师，程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else if (team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        if (p instanceof Architect){
            if (numOfArch >= 1){
                throw new TeamException("团队中最多只能有一名架构师");
            }
        }else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中最多只能有两名设计师");
            }
        }else if (p instanceof Programmer){
            if (numOfPro >= 3) {
                throw new TeamException("团队中最多只能有三名程序员");
            }
        }

        //将e添加到现有的team
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }
    /**
    * @Description: 判断指定员工是否已经存在于当前团队
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/26 10:54
    */
    public boolean isExist(Employee e){
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()){
                return true;
            }
        }
        return false;
    }
    /**
    * @Description: 将指定的员工从团队中删除
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/26 10:37
    */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到指定memberId的
        if (i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        //后一个元素覆盖前一个元素，实现删除操作
        for (int j = i + 1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;

    }
}
