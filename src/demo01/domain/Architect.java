package demo01.domain;

public class Architect extends Designer{
    private int stock;//股票

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        if ((getMemberId() + "/" + getId()).length()>3){
            return getMemberId() + "/" + getId() + "\t" +getName() + "\t\t" + getAge() + "\t\t" + getSalary() + "\t架构师\t" + getBonus() + "\t" + getStock();
        }else {
            return getMemberId() + "/" + getId() + "\t\t" +getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t架构师\t" + getBonus() + "\t" + getStock();
        }
    }
}
