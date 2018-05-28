cmake_minimum_required(VERSION 3.8)
set(CMAKE_CXX_STANDARD 17)
project(StarterProject.code CXX)
set(SOURCE_FILES GildedRose.cc GildedRose.h)
add_library(StarterProject.code ${SOURCE_FILES} )

set_target_properties(StarterProject.code PROPERTIES LINKER_LANGUAGE CXX)