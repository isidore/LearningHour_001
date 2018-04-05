#include "ApprovalTests.hpp"
#include "Catch.hpp"
#include <vector>


static string convert(int i) {


    if(i % 15 == 0)
        return "FizzBuzz";
    else if(i % 3 == 0)
        return "Fizz";
    else if (i % 5 == 0)
        return "Buzz";
    else
        return std::to_string(i);
}

TEST_CASE("FizzBuzzStep1")
{
    REQUIRE(convert(1) == "1");
}

TEST_CASE("FizzBuzzStep3")
{
    REQUIRE(convert(3) == "Fizz");
}

TEST_CASE("FizzBuzzStep5")
{
    REQUIRE(convert(5) == "Buzz");
}

TEST_CASE("FizzBuzzStep6")
{
    REQUIRE(convert(6) == "Fizz");
}

TEST_CASE("FizzBuzzStep9")
{
    REQUIRE(convert(9) == "Fizz");
}

TEST_CASE("FizzBuzzStep10")
{
    REQUIRE(convert(10) == "Buzz");
}

TEST_CASE("FizzBuzzStep15")
{
    REQUIRE(convert(15) == "FizzBuzz");
}
TEST_CASE("FizzBuzz")
{

    std::vector<int> v{1,3,5,6,9,10,15};
    Approvals::verifyAll("FIRST LETTER",v.begin(), v.end(), [](auto s, auto& os){os << s << " => " << convert(s);});
}
