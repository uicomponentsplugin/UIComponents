package ui.components;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    public ScreenSlidePagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.newInstance(position);
    }

    /* @NonNull
     @Override
     public Fragment createFragment(int position) {
         return ViewPagerFragment.newInstance(position);
     }

     @Override
     public int getItemCount() {
         return 10;
     }
 */
    @Override
    public int getCount() {
        return 10;
    }
}
