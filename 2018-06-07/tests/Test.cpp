#include <iostream>
#include "Catch.hpp"

using namespace std;
typedef  void (*printFunction)();
class Shape {
public:
    int number;
    printFunction print;

    Shape() {
        print = []() {
            std::cout << "Hello I'm a shape " ;
        };
    }
};

class Circle : public Shape {
public:
    static void printMe() {
        std::cout << "Hello I'm a circle ";
    };
    Circle() {
        number = 5;
        print = printMe;
    }

};

void printByValue(Shape s) {
    s.print();
}

void printByReference(Shape &s) {
    s.print();
}

void printByPointer(Shape *s) {
    s->print();
}

Shape getShape() {
    return Circle();
}

Shape &getShapeByReference() {
    auto c = new Circle();
    return *(c);
}

Circle circle;

Shape *getShapeByPointer() {
    return &circle;
}

TEST_CASE("1st Test") {
 Shape s;
 Circle c;
 s = c;
 s.print();

}
