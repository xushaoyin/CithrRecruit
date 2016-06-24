package cn.cithr.jackdraw.cithrrecruit.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.cithr.jackdraw.cithrrecruit.R;

/**
 * Created by xusha on 2016/6/21.
 */
public class EducationFragment extends BaseFragment implements BaseFragment.MyOnClickListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_start_date)
    TextView mTvStartDate;
    @BindView(R.id.ll_start_date)
    LinearLayout mLlStartDate;
    @BindView(R.id.tv_end_date)
    TextView mTvEndDate;
    @BindView(R.id.ll_end_date)
    LinearLayout mLlEndDate;
    @BindView(R.id.et_school_name)
    EditText mEtSchoolName;
    @BindView(R.id.et_major)
    EditText mEtMajor;
    @BindView(R.id.tv_degree)
    TextView mTvDegree;
    @BindView(R.id.ll_degree)
    LinearLayout mLlDegree;

    private String[] mData;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        setMyOnClickListener(this);
        initClick();

        setHasOptionsMenu(true);
        setToolbar(mToolbar, R.string.title_education);
    }

    private void initClick() {
        mLlDegree.setOnClickListener(this);
        mLlStartDate.setOnClickListener(this);
        mLlEndDate.setOnClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.save_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_education;
    }

    @Override
    public void myOnClick(View view) {
        switch (view.getId()) {
            case R.id.ll_start_date:
                showDateSelectDialog(mTvStartDate);
                break;

            case R.id.ll_end_date:
                showDateSelectDialog(mTvEndDate);
                break;

            case R.id.ll_degree:
                mData = new String[]{"大专", "本科", "研究生", "博士"};
                showDialog(mData, mTvDegree);
                break;

            default:
                break;
        }
    }
}
