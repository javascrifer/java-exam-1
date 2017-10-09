public class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private int id;
    private String group;

    public Student(String firstName, String lastName, int id, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return this.firstName.toUpperCase().substring(0, 3).concat(".")
                + String.format("%-20s", this.lastName.toLowerCase())
                + Integer.toString(this.id).substring(Integer.toString(this.id).length() - 4)
                + " "
                + this.group;
    }

    @Override
    public int compareTo(Student student) {

        String groupA = this.group.split("-")[0].toUpperCase().trim();
        String groupB = student.getGroup().split("-")[0].toUpperCase().trim();

        if (groupA.compareTo(groupB) == 0) {

            if (this.firstName.compareTo(student.getFirstName()) == 0) {
                return this.lastName.compareTo(student.getLastName());
            }

            return this.firstName.compareTo(student.getFirstName());

        }

        return groupA.compareTo(groupB);
    }

}
