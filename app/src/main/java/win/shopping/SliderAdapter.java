package win.shopping;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    private List<SliderModel> slideModelList;

    public SliderAdapter(List<SliderModel> slideModelList) {
        this.slideModelList = slideModelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slider_layout,container,false);
        ConstraintLayout bannerContainer = view.findViewById(R.id.banner_container);
        bannerContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(slideModelList.get(position).getBackgroundColor())));
        ImageView banner = view.findViewById(R.id.banner_slider);
        Glide.with(container.getContext()).load(slideModelList.get(position).getBanner())
                .apply(new RequestOptions().placeholder(R.mipmap.home_icon)).into(banner);

        container.addView(view,0);
        return view;
    }

    @Override
    public int getCount() {
        return slideModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
