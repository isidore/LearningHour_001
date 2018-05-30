[GildedRose Kata](https://github.com/omgzergrush/GildedRose.cpp.ApprovalTests)


``` cpp
Item doStuff(std::string name, int sellIn, int quality)
{
        Item item(name, sellIn, quality);
    std::vector<Item> vector_item = { item };
    GildedRose rose({ vector_item });
    rose.updateQuality();
       return  rose.items[0];
}

TEST_CASE("ApprovingText")
{
    std::vector<std::string> names{ "foo" };
    std::vector<int> sellins{ 0};
    std::vector<int> qualities{0 };
    //Approvals::verify(doStuff("foo",0,0));
    CombinationApprovals::verifyAllCombinations
    <std::vector<std::string>, std::vector<int>, std::vector<int>, Item>
    ([](std::string n, int s, int q) {return doStuff(n, s, q);},
        names, sellins, qualities);

}
```
