class Employee extends Person{
  
  private int id;
  private Date hireDate;
  
  public Employee(Name name, int age, int id, Date hireDate){   //constructor
    super(name, age);
    this.id = id;
    this.hireDate = hireDate;
  }
  public Employee(String first, String last, int age, int id, int year, int month, int dom){  //constructoor
    super(new Name(first,last) ,age);
    this.id = id;
    this.hireDate = new Date(year, month, dom);

  }
  public String toString(){
    return super.toString() + " #" + id + " "+ hireDate.toString();
  }
  
}
