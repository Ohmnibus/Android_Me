/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    int selHead = 0;
    int selBody = 0;
    int selLeg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        int part = position / 12;
        switch (part) {
            case 0:
                selHead = position % 12;
                break;
            case 1:
                selBody = position % 12;
                break;
            case 2:
                selLeg = position % 12;
                break;
        }
        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtra(AndroidMeActivity.EXTRA_HEAD, selHead);
        intent.putExtra(AndroidMeActivity.EXTRA_BODY, selBody);
        intent.putExtra(AndroidMeActivity.EXTRA_LEG, selLeg);
        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(intent);
            }
        });
    }

}
