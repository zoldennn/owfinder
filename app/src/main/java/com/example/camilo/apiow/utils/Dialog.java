package com.example.camilo.apiow.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.camilo.apiow.R;

import java.lang.reflect.AccessibleObject;

public class Dialog extends android.app.Dialog{

    public Activity c;

    public Dialog(Activity a) {
        super(a);
        this.c=a;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }
}
