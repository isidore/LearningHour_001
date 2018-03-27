
#ifndef APPROVALTESTS_CPP_STARTERPROJECT_BOWLING_H
#define APPROVALTESTS_CPP_STARTERPROJECT_BOWLING_H


#include "Exception.h"

class Bowling {
private:
    uint _score = 0;
  public:
    void roll(uint pins) {
        if(10 < pins || (10 < pins + _score)){
            throw new Exception("Bad roll" + pins);
        }
        _score += pins;
    }

    uint score() {
        return _score;
    }
};


#endif //APPROVALTESTS_CPP_STARTERPROJECT_BOWLING_H
