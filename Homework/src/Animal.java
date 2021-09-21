public class Animal {
    private String typeAimal;
    private String name;

    public Animal(String typeAimal, String name) {
        this.typeAimal = typeAimal;
        this.name = name;
    }

    public String getTypeAimal() {
        return typeAimal;
    }

    public void setTypeAimal(String typeAimal) {
        this.typeAimal = typeAimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "typeAimal='" + typeAimal + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
