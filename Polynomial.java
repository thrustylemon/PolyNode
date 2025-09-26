
class Polynomial { 

    private PolyNode head; 

 

    public Polynomial() { 

        head = null; 

    } 

 

    public void insert(int coefficient, int exponent) { 

        if (coefficient == 0) return; // Ignore zero coefficient terms 

        PolyNode newNode = new PolyNode(coefficient, exponent); 

        if (head == null || head.getExponent() < exponent) { 

            newNode.setNext(head); 

            head = newNode; 

        } else { 

            PolyNode current = head; 

            PolyNode prev = null; 

            while (current != null && current.getExponent() > exponent) { 

                prev = current; 

                current = current.getNext(); 

            } 

            if (current != null && current.getExponent() == exponent) { 

                current.setCoefficient(current.getCoefficient() + coefficient); 

                if (current.getCoefficient() == 0) { 

                    if (prev != null) { 

                        prev.setNext(current.getNext()); 

                    } else { 

                        head = current.getNext(); 

                    } 

                } 

            } else { 

                newNode.setNext(current); 

                if (prev != null) { 

                    prev.setNext(newNode); 

                } else { 

                    head = newNode; 

                } 

            } 

        } 

    } 

 

    public void display() { 

        if (head == null) { 

            System.out.println("0"); 

            return; 

        } 

        PolyNode current = head; 

        while (current != null) { 

            System.out.print(current.getCoefficient() + "x^" + current.getExponent()); 

            if (current.getNext() != null) { 

                System.out.print(" + "); 

            } 

            current = current.getNext(); 

        } 

        System.out.println(); 

    } 

 

    public Polynomial add(Polynomial other) { 

        Polynomial result = new Polynomial(); 

        PolyNode p1 = this.head, p2 = other.head; 

        while (p1 != null || p2 != null) { 

            if (p1 != null && (p2 == null || p1.getExponent() > p2.getExponent())) { 

                result.insert(p1.getCoefficient(), p1.getExponent()); 

                p1 = p1.getNext(); 

            } else if (p2 != null && (p1 == null || p2.getExponent() > p1.getExponent())) { 

                result.insert(p2.getCoefficient(), p2.getExponent()); 

                p2 = p2.getNext(); 

            } else { 

                int sumCoeff = p1.getCoefficient() + p2.getCoefficient(); 

                if (sumCoeff != 0) { 

                    result.insert(sumCoeff, p1.getExponent()); 

                } 

                p1 = p1.getNext(); 

                p2 = p2.getNext(); 

            } 

        } 

        return result; 

    } 

} 

 

public class PolynomialDemo { 

    public static void main(String[] args) { 

        Polynomial poly1 = new Polynomial(); 

        poly1.insert(4, 3); 

        poly1.insert(3, 2); 

        poly1.insert(-5, 0); 

        System.out.println("Polynomial 1:"); 

        poly1.display(); 

 

        Polynomial poly2 = new Polynomial(); 

        poly2.insert(2, 3); 

        poly2.insert(1, 1); 

        poly2.insert(5, 0); 

        System.out.println("Polynomial 2:"); 

        poly2.display(); 

 

        Polynomial resultPoly = poly1.add(poly2); 

        System.out.println("Sum of polynomials:"); 

        resultPoly.display(); 

    } 

} 
