#include "ApprovalTests.hpp"
#include "Catch.hpp"
#include "Bowling.h"
/**
 * In clion, you can run this with ctrl+r
 * You might need to add a Catch Runtime to see it in the unit test window
 * Run > edit configurations > + > Catch > Target=Playground_Tests
 */
TEST_CASE("Hit1Pin") {
    // start bowling
    Bowling b;
    // hit 1 pin
    b.roll(1);
    // verify 1 point
    REQUIRE(b.score() == 1);
}
TEST_CASE("Rol12") {
    Bowling b;
    b.roll(1);
    b.roll(2);
    REQUIRE(b.score() == 3);
}
void require(bool b){
}

void betterName(int a, int b) {
 // ... some code
}
void stupidName(int a, int b)
{
    betterName(a,b);

    // cout << "betterName( "<< a
}
TEST_CASE("Rol00") {
    Bowling b;
    b.roll(0);
    b.roll(0);
    REQUIRE(b.score() == 1);
    require(b.score() == 1);
}
void assertBadRolls(std::vector<uint> pins) {
    bool error = false;
    try {
        Bowling b;
        for (auto p : pins) {
          b.roll(p);
        }
    }catch (...){
        error = true;
    }
    REQUIRE(error == true);
}
void assertBadRoll(uint pins) {
    assertBadRolls({pins});
}
TEST_CASE("Hit2Pin") {
    Bowling b;
    b.roll(2);
    REQUIRE(b.score() == 2);
}
TEST_CASE("11IsNotValid") {
   assertBadRoll(11);
}
TEST_CASE("12IsNotValid"){
    assertBadRoll(12);
}
TEST_CASE("13IsNotValid"){
    assertBadRoll(13);
}
TEST_CASE("5,6IsNotValid"){
    assertBadRolls({5,6});
}
TEST_CASE("6,6IsNotValid"){
    assertBadRolls({6,6});
}





