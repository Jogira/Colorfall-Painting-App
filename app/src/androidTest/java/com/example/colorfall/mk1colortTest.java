package com.example.colorfall;

import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class mk1colortTest {

//    @Rule
//    public ActivityTestRule<MainActivity> mActivityTestRule =
//            new ActivityTestRule<>(MainActivity.class);
//    public ActivityTestRule<drawActivity> activityTestRule =
//            new ActivityTestRule<>(drawActivity.class);


//    @Test
//    public void mk1colortTest() {
//        ViewInteraction appCompatButton = onView(
//                allOf(withId(R.id.drawBtn), withText("Draw"), isDisplayed()));
//        appCompatButton.perform(click());
//
//        ViewInteraction appCompatImageButton = onView(
//                allOf(withId(R.id.greenColor), withContentDescription("pixel"), isDisplayed()));
//        appCompatImageButton.perform(click());
//
//        drawActivity activity = activityTestRule.getActivity();
//        onView(withText("color now blue")).
//                inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).
//                check(matches(isDisplayed()));
//
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }
}
