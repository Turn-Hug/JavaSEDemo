package demo01.service;

import demo01.domain.*;

import static demo01.service.Data.*;
/**
* @Description:
* @Author: Hequan
* @Version: 1.0
* @Date: 2022/4/25 15:55
*/
/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供操作Employee[]的方法
 */
public class NameListService {
    private Employee[] employees;

    public NameListService(){
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取Employee的基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creteEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creteEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = creteEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }
    /**
    * @Description: 获取指定index上的员工设备
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/25 16:12
    */
    private Equipment creteEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        switch (type){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(model,display);
            case PRINTER:
                return new Printer(model,EQUIPMENTS[index][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);
        }
        return null;
    }
    /**
    * @Description: 获取当前所有的员工
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/25 16:33
    */
    public Employee[] getAllEmployees(){
        return employees;
    }
    /**
    * @Description: 获取指定ID的员工
    * @Author: Hequan
    * @Version:
    * @Date: 2022/4/25 16:34
    */
    public Employee getEmployee(int id) throws TeamException {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
