package inheritance.part1;

class Manager extends Employee {
    protected double bonus;

    public Manager(int id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public void work() {
        System.out.println("Managing employees!");
    }
}