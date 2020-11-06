## Lab 2.3 — A Rational Number Class in Java
Overview
A rational number is one that can be expressed as the ratio of two integers, i.e., a number that can be expressed using a fraction whose numerator and denominator are integers. Examples of rational numbers are 1/2, 3/4 and 2/1. Rational numbers are thus no more than the fractions you've been familiar with since grade school.
Rational numbers can be negated, inverted, added, subtracted, multiplied, and divided in the usual manner:

- The inverse, or reciprocal of a rational is the new rational number you get by swapping the numerator and denominator of the original. Thus, the inverse of 3/4 is 4/3.
- Multiplying two rationals involves multiplying their numerators to produce the numerator of the result, and multiplying the denominators to similarly produce the new denominator.
- Dividing two rationals involves taking the inverse of the divisor (the second number, i.e., the number 'doing' the dividing) and multiplying it with the dividend (the number being divided, i.e., the first number), producing the quotient. (For example, when performing re / r2, r1 is the dividend, r2 is the divisor, and the result r1/r2 is the quotient).
- Adding and subtracting two rationals is a bit more involved, so we're going to take the easy way out:
  - Multiply the denominators to produce the new denominator(this is NOT what you learned in elementary school, where you found and used the lowest common denominator).
  - Multiply each numerator by the other rational's denominator, and add/subtract the two to produce the result's numerator.
  To see why this works: suppose the two rationals were a/b and c/d. Then, the above would produce:
  ```
  ad + cb      ad     cb     a     c
  -------  =   --  +  --  =  -  +  -
    bd         bd     bd     b     d
  ```
  
**Normalization of a Rational**
- The two rational numbers 6/8 and 3/4 actually represent the same value-- they are said to be equivalent. 6/8 is actually 3/4 multiplied by 2/2-- and since 2/2 is nothing more than 1, we have not changed the value of the represented number.
- If the numerator and denominator can be evenly divided by the same number (thus leaving the value unchanged), we say the result is a simpler form of the number, and the process is known as reducing the fraction. The simplest or normal form of the fraction is one which cannot be further reduced and the process is called normalization or reducing to lowest terms.
- The lowest terms of a rational number can thus be obtained by dividing the numerator and denominator by their greatest common divisor (gcd)-- i.e., the largest number that divides them both evenly. For example, given the rational number 16/20, the gcd of 16 and 20 is 4 and dividing 16 and 20 by 4 produces 4 and 5 respectively; thus the simplest form of 16/20 is 4/5.
- The gcd of two numbers can be obtained recursively in the following fashion:
  ```java
  		gcd(a, b) :
  		   if b == 0 return a
	  	   else return gcd(b, a%b) 
  ```		
- Simplest forms are useful for printing, as well as various operations — addition and comparison in particular.

**A Rational Class**
Write a class named Rational that provides basic support for rational numbers. This support consists of the following methods:
- The following constructors:
  - A 2-argument constructor that accepts a pair of integers corresponding to the numerator and denominator of the rational number. Thus passing in a numerator of 3 and a denominator of 4 would create an object representing the rational number 3/4. A denominator of 0 causes a RationalException to be thrown
  - A 1-argument constructor that accepts a single integer, which is used as the numerator of the new rational. The denominator should be set to 1. Thus, passing in 3, would result in the (integer-valued) rational 3/1.
  - A 0-argument constructor that initializes the rational to 0.
  - A copy constructor that accepts a Rational as an argument, which is used to initialize the new rational; i.e., the num of the argument Rational is assigned to the num of the new Rational (the receiver, i.e., the object referred to by this), and similarly for the denom
- Rational-returning methods negate and inverse that return the negation (additive inverse) of the receiver (i.e.,the receiver multiplied by -1), and the inverse/reciprocal of the receiver respectively.
- Four methods: add, sub, mul, div that perform basic arithmetic on rational numbers. These methods take a single Rational parameter corresponding to the second operand (the first operand is the receiver — the Rational operand on whom the method is being invoked) and returns a new Rational containing the result. Thus, if r1 contains 1/2 and r2 contains 1/4, then calling r1.add(r2) should return a Rational containing 6/8 (see above for how the addition should work).
- Four methods addInPlace, subInPlace, mulInPlace, divInPlace that perform the same operations as the four above, but the result is placed into the left operand. Thus, if r1 contains 1/2 and r2 contains 1/4, then calling r1.addInPlace(r2) results in r1 containing 6/8. In other words, add corresponds to +, while addInPlace corresponds to +=.
- A method inverse that returns the inverse (reciprocal) of the rational number.
- A method negate that returns the negation (additive inverse — the value multiplied by -1) of the rational number.
- A method getNumerator that returns the numerator of the rational number.
- A method getDenominator that returns the numerator of the rational number.
- A method compareTo that accepts another Rational and returns -1, 0, or 1 depending on whether the receiver is less-than, equal-to, or greater-than the argument (this is similar to the compareTo method of the String class. While normal form makes it easy to test for equality, you might want to give some thought as to how to check for greater-/less-than.
- A boolean-returning method named equals that accepts a Rational argument and returns whether that argument and the receiver are equal.
- A toString method that returns the string representation of rational number, in the form numerator/denominator. If the denominator is 0 — i.e., the number if an integer, simply print the numerator.
- A private gcd method

**Notes**
- Use this in your overloaded constructors (the first three) to leverage the functionality of initializing the rational from a numerator and denominator.
- Calling gcd, and reducing your Rational in the constructor makes sure that all Rationals you create are reduced from the get-go. (The exception will be if you make in-place changes to a Rational), in which case you have to make sure you reduce the result — we'll discuss this in class.
  - The way to reduce in the constructor is to call the gcd and then divide both numerator and denominator by the result
  - If this is done in EVERY constructor, the all Rationals will be in reduced normal from the moment they're created
    - The only possible exception to this is if you do inPlace operations by directly manipulating the num and denom (as opposed to leveraging the other immutable (non-in-place) operations and copying the result). In that situation, after manipulating the num and denom, yo need to normalize the result (again calling gcd and dividing). If your implementation does this, you may want to write a normalize method that does that for you.
- Leverage the functionality of the corresponding arithmetic operators (i.e., add and addInPlace) to maintain semantic consistency. As will be discussed in class you can go in either direction — e.g., first code addInPlace, and then use it to implement add or vice-versa (C++ uses the former approach; we'll explain why when we get to that point). If you code add first, you will need a copy method — we will discuss this in class as well.
- In addition, you can use other leveraging of functionality; e.g., subtraction of rationals can be defined in terms of addition, division in terms of multiplication (think back to doing these operations on fractions); and finally negate and inverse can benefit/contribute to this leveraging as well.
- You should also leverage the functionality of your compareTo method when implementing equals. This will prove good practice for when you code this class in C++ and add all the relational operators (e.g. >, !=, etc).
- I've supplied you with a minimal RationalException class to be used when an exception need to be thrown. I am simply checking the presence or absence of an exception, so you do not have to worry about exact wording of the exception message.
- I am also supplying you with the RationalTest class that will be used to test your class in CodeLab … we will go over it briefly in class, and I would suggest you use it in your own IDE before submitting to CodeLab, but even before that, it would be a good idea if you wrote a simple test class to check the basic functionality of your class. You will understand your own tests better than mine, and it's good test-writing practice.
