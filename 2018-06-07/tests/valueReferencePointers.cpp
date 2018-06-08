#include <iostream>
#include "Catch.hpp"

using namespace std;

class Circle:  public Shape{
public:
    Circle(){
        number = 5;
    }

    virtual void print()  {
        std::cout << "Hello I'm a circle " << number;
    }
};
void printByValue(Shape s){
    s.print();
}
void printByReference(Shape& s){
    s.print();
}
void printByPointer(Shape* s){
    s->print();
}
Shape getShape()
{
    return Circle();
}
Shape& getShapeByReference()
{
    auto c = new Circle();
    return *(c);
}
Circle circle;
Shape* getShapeByPointer()
{
    return &circle;
}

TEST_CASE("1st Test") {

    getShapeByPointer()->print();

}
