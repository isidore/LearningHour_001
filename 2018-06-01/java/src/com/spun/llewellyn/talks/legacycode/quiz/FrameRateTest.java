package com.spun.llewellyn.talks.legacycode.quiz;

import org.junit.Test;

import com.spun.llewellyn.talks.legacycode.examples.tests.MockUtils;
import com.spun.llewellyn.talks.legacycode.required.VideoMaker;

public class FrameRateTest
{
  @Test
  public void test()
  {
    VideoMaker maker = MockUtils.createStrictMock(VideoMaker.class);
    MockUtils.expectVoid(maker.createFrame("null"));
    MockUtils.finalizeExpectations(maker);
    new FrameRate().countDown2(maker, "ntsc");
  }
}
