import java.util.ArrayList;
import java.util.Random;

public class Toy {

    @Override
    public String toString() {
        return "Toy [id=" + id + ", name=" + name + ", quantity=" + quantity + ", weight=" + weight + "]";
    }
    public Integer id;
    public String name;
    public int quantity;
    public float weight;
    
    public Toy(Integer id, String name, int quantity2, Float weight2) {
        this.id = id;
        this.name = name;
        this.quantity = quantity2;
        this.weight = weight2;
    }
    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    
}