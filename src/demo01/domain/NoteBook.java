package demo01.domain;

public class NoteBook implements Equipment {
    private String model;//机器型号
    private Double price;//价格

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public NoteBook() {
        super();
    }

    public NoteBook(String model, Double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String text(int id,String name,int age){
        return id+name+age;
    }
}
