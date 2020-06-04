package com.mark.view.markselectdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mark.view.markselectdialogdemo.bean.MarkItemChildBean;
import com.mark.view.markselectdialogdemo.bean.MarkSelectBean;
import com.mark.view.markselectdialogdemo.view.FlowPopWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBack;
    private TextView tvFlow;

    private FlowPopWindow flowPopWindow;
    private List<MarkSelectBean> dictList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initParam();
        initView();
    }

    private void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvFlow = (TextView) findViewById(R.id.tv_flow);
        tvFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flowPopWindow = new FlowPopWindow(MainActivity.this, dictList);
                flowPopWindow.showAsDropDown(ivBack);
                flowPopWindow.setOnConfirmClickListener(new FlowPopWindow.OnConfirmClickListener() {
                    @Override
                    public void onConfirmClick() {
                        StringBuilder sb = new StringBuilder();
                        for (MarkSelectBean fb : dictList) {
                            List<MarkItemChildBean> cdList = fb.getChildBeanList();
                            for (int x = 0; x < cdList.size(); x++) {
                                MarkItemChildBean children = cdList.get(x);
                                if ( children.isSelected())
                                    sb.append(fb.getTypeName() + ":" + children.getValue() + "；");
                            }
                        }
                        if (!TextUtils.isEmpty(sb.toString()))
                            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }


    //这些是假数据，真实项目中直接接口获取添加进来，FiltrateBean对象可根据自己需求更改
    private void initParam() {
        String[] colors = {"全部分类", "送货服务", "维修服务", "拆装服务","维修服务", "拆装服务","维修服务", "拆装服务"};
        String[] company = {"全部分类", "已接单", "已签到", "待审核", "转单中","已签到", "待审核", "转单中"};

        MarkSelectBean fb2 = new MarkSelectBean();
        fb2.setTypeName("选择分类");
        List<MarkItemChildBean> childrenList2 = new ArrayList<>();
        for (int x = 0; x < colors.length; x++) {
            MarkItemChildBean cd = new MarkItemChildBean();
            cd.setValue(colors[x]);
            if (x == 0){
                cd.setSelected(true);
            }
            childrenList2.add(cd);
        }
        fb2.setChildBeanList(childrenList2);

        MarkSelectBean fb3 = new MarkSelectBean();
        fb3.setTypeName("选择状态");
        List<MarkItemChildBean> childrenList3 = new ArrayList<>();
        for (int x = 0; x < company.length; x++) {
            MarkItemChildBean cd = new MarkItemChildBean();
            cd.setValue(company[x]);
            if (x == 0){
                cd.setSelected(true);
            }
            childrenList3.add(cd);
        }
        fb3.setChildBeanList(childrenList3);

        dictList.add(fb2);
        dictList.add(fb3);
    }
}
