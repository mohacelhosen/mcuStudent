package com.mcu.student;


class Student{
    int id;
    String name;
    double CGPA;

    public Student(int id, String name, double CGPA){this.id=id; this.name=name; this.CGPA=CGPA;}

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

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", CGPA=" + CGPA +
                '}';
    }
}
class StudentTest3 {
    static int i = 10;
    public static void main(String [] args){
        String str = "First Message";
        Student s1 =new Student (296,"Sulaiman",1.3);
        Student s2 =new Student (29,"Ismail",3.1);
        System.out.println("i="+(++i));
        System.out.println("str="+str);
        System.out.println("Student:"+s1);
        System.out.println("Student:"+s2);
        mixUp(i,str,s1,s2);
        System.out.println("i="+i);
        System.out.println("str="+str);
        System.out.println("Student1:"+s1);
        System.out.println("Student2:"+s2);

    }

    static void mixUp(int i,String str,Student s1,Student s2){
    i++;
    str = "Second Message";
    s2 = s1;
    s2.setCGPA(3.4);
    s2.setName("Abdulrahman");}

}
