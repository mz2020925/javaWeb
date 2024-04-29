package pojo;

public class Emp {
    private int id;
    private String name;
    private int age;
    private int dep_id;

    public Emp() {
    }

    public Emp(int id, String name, int age, int dep_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dep_id = dep_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dep_id=" + dep_id +
                '}';
    }
}
