
#ifndef CATCHPLAYGROUND_SHAPES_H
#define CATCHPLAYGROUND_SHAPES_H


#include "Catch.hpp"
#include <iostream>

class Shape;
typedef void (*printFunction)(Shape&, int);

class Shape {
public:
    int lower;
    printFunction printVirtual;
    void print(int value){
        printVirtual(*this, value);
    }
};

class DefaultShape : public Shape{
public:
static void printMe(Shape& self,int value) {
    std::cout << "Hello "  << self.lower  << " I'm a default Shape with inputs of " << value;
};

    DefaultShape() {
    lower = 0;
    printVirtual = printMe;
}
};
Shape globalShape = DefaultShape();

void registerShape(Shape s) {
    globalShape = s;
}

void printByValue() {
    globalShape.print(42);
}

#endif