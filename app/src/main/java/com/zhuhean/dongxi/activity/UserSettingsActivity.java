package com.zhuhean.dongxi.activity;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import com.zhuhean.dongxi.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by vincent on 14/11/21.
 */
public class UserSettingsActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_preferences);
        Preference checkForUpdatePreference=findPreference("check_for_update");
        checkForUpdatePreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(UserSettingsActivity.this, "已是最新版本", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        Preference clearChachePreference=findPreference("clear_cache");
        clearChachePreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                new SweetAlertDialog(UserSettingsActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("删除缓存")
                        .setContentText("确定删除缓存？")
                        .setConfirmText("确定")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("已删除")
                                        .setContentText("缓存已清除")
                                        .setConfirmText("好的")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                            }
                        })
                        .show();
                //Toast.makeText(UserSettings.this, "缓存已清空", Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

}
