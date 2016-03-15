package com.android.codechallenge.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import butterknife.Bind;
import com.android.codechallenge.R;
import com.android.codechallenge.model.DataPoint;
import com.common.android.utils.interfaces.ICallback;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.android.codechallenge.network.RequestProvider.get30days;
import static com.android.codechallenge.utils.ChartUtils.getDate;

/**
 * Created by greymatter on 14/03/16.
 */
public class BitcoinGraphFragment extends BaseFragment {
    @NonNull
    @Bind(R.id.line_view)
    LineView lineView;

    public int randomint = 9;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_All);
        get30days(new ICallback<List<DataPoint>>() {
            @Override
            public void onSuccess(List<DataPoint> dataPoints) {
                randomSet(lineView, dataPoints);
            }
        });
    }

    @NotNull
    private ArrayList<String> timestampsToDates(final List<DataPoint> dataPoints) {
        ArrayList<String> test = new ArrayList<>();
        for (int i = 0; i < dataPoints.size(); i++) {
            test.add(getDate(((dataPoints.get(i).x) * 1000L), "dd/MM/yyyy"));
        }
        return test;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_graph;
    }

    @NotNull
    @Override
    public String tag() {
        return BitcoinGraphFragment.class.getSimpleName();
    }

    private void randomSet(LineView lineView, List<DataPoint> dataPoints) {
        ArrayList<Integer> dataList = new ArrayList<>();
        int random = (int) (Math.random() * dataPoints.size() + 1);
        for (int i = 0; i < randomint; i++) {
            dataList.add((int) (Math.random() * random));
        }
        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
        dataLists.add(dataList);
        lineView.setBottomTextList(timestampsToDates(dataPoints));
        lineView.setDataList(dataLists);
    }
}
