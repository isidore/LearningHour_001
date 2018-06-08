#include <iostream>
#include "Catch.hpp"

#include "Shapes.h"

using namespace std;


class Circle : public Shape {
public:
    static void printMe(Shape& self,int value) {
        std::cout << "Hello I'm a circle "  << self.lower << " to " << value;
    };

    Circle() {
        lower = 5;
        printVirtual = printMe;
    }

};


void setupShapes() {
    registerShape(Circle());
}



TEST_CASE("1st Test") {
    setupShapes();
    printByValue();


}
