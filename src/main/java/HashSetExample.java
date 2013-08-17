
public class HashSetExample {
    private final String name;
    private final Integer age;

    public HashSetExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        HashSetExample other = (HashSetExample) o;
        if (this.age == other.getAge() && this.name.equals(other.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        result = (name == null ? 0 : name.hashCode());
        result = 37 * result + (age == null ? 0 : age.hashCode());
        return result;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
