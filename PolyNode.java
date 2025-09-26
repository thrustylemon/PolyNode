class PolyNode { 

    private int coefficient; 

    private int exponent; 

    private PolyNode next; 

 

    public PolyNode() { 

        this(0, 0, null); 

    } 

 

    public PolyNode(int coefficient, int exponent) { 

        this(coefficient, exponent, null); 

    } 

 

    public PolyNode(int coefficient, int exponent, PolyNode next) { 

        this.coefficient = coefficient; 

        this.exponent = exponent; 

        this.next = next; 

    } 

 

    public void setCoefficient(int coefficient) { 

        this.coefficient = coefficient; 

    } 

 

    public void setExponent(int exponent) { 

        this.exponent = exponent; 

    } 

 

    public void setNext(PolyNode next) { 

        this.next = next; 

    } 

 

    public int getCoefficient() { 

        return coefficient; 

    } 

 

    public int getExponent() { 

        return exponent; 

    } 

 

    public PolyNode getNext() { 

        return next; 

    } 

} 

 

