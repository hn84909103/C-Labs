public class Rational{
  
  private int numerator, denominator;
  
  Rational(int numerator, int denominator){
    
    if(denominator == 0){
      throw new RationalException("Denominator is 0");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    normalize();
  }
  
  Rational(int numerator){
    this.numerator = numerator;
    this.denominator = 1;
  }
  
  Rational(){
    this.numerator = 0;
    this.denominator = 1;
  }
  
  Rational(Rational r){
    this.numerator = r.getNumerator();
    this.denominator = r.getDenominator();
  }
  
  public int getNumerator(){
    return numerator;
  }  
  
  public int getDenominator(){
    return denominator;
  }
  
  public Rational inverse(){
    return new Rational(denominator, numerator);
  }
  
  public Rational negate(){
    return new Rational(numerator*(-1), denominator);
  }
  
  public void addInPlace(Rational r){
    numerator = numerator * r.getDenominator() + r.getNumerator() * denominator;
    denominator = r.getDenominator() * denominator;
    normalize();
  }
  
  public void subInPlace(Rational r){
    numerator = numerator * r.getDenominator() - r.getNumerator() * denominator;
    denominator = r.getDenominator() * denominator;
    normalize();
  }
  
  public void mulInPlace(Rational r){
    numerator *= r.getNumerator();
    denominator *= r.getDenominator();
    normalize();
  }
  
  public void divInPlace(Rational r){
    this.mulInPlace(r.inverse());
  } 
  
  public Rational add(Rational r){
    Rational rat = new Rational(this);
    rat.addInPlace(r);
    return rat;
  }
  
  public Rational sub(Rational r){
    Rational rat = new Rational(this);
    rat.subInPlace(r);
    return rat;
  }
  
  public Rational mul(Rational r){
    Rational rat = new Rational(this);
    rat.mulInPlace(r);
    return rat;
  }
  
  public Rational div(Rational r){
    Rational rat = new Rational(this);
    rat.divInPlace(r);
    return rat;
  }
  
  public int compareTo(Rational r){
    int num1 = numerator * r.getDenominator();
    int num2 = r.getNumerator() * denominator;
    if(num1 > num2){
      return 1;
    }else if(num1 < num2){
      return -1;
    }else{
      return 0;
    }
  }
  
  public boolean equals(Rational r){
    return this.compareTo(r) == 0;
  }
  
  public String toString(){
    if(denominator == 1){
      return Integer.toString(numerator);
    }else{
      return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
  }
  
  private int gcd(int a, int b){
    if(b==0){
      return a;
    }else{
      return gcd(b, a%b);
    }
  }
  
  private void normalize(){
    int gcd = gcd(numerator, denominator);
    this.numerator /= gcd;
    this.denominator /= gcd; 
  }
  
}
