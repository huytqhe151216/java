package student;
//format source code ALT+SHIFT+F
//move line ALT+SHIFT+UP/DOWN

class Student {

    String id;
    String name;
    boolean gender;
    int age;
    double GPA;

    public Student(String id, String name, boolean gender, int age, double GPA) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.GPA = GPA;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        if(isGender()==true){
            System.out.println("Gender: " + "Nam");
        }else{
             System.out.println("Gender: " + "Nữ");
        }
        System.out.println("Age: " + getAge());
        System.out.println("GPA: " + getGPA());
    }
}

public class student {

    public static void main(String[] args) {
        Student st1 = new Student("HE151216", "to quang huy", true, 19, 4);
        st1.display();

    }
}