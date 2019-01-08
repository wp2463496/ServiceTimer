package com.example.testservice;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	private Timer mTimer = new Timer(true);//��ʱ��
	private TimerTask mTimerTask;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onDestroy() {// �رշ���
		while(!mTimerTask.cancel());
		mTimer.cancel();
	}

	@Override
	public void onStart(Intent intent, int startid) {// ��������
		mTimerTask = new TimerTask()
		{
			public void run()
			{
				Log.v("TEST", "3��");
			}
		};
		mTimer.schedule(mTimerTask, 3000,3000);
	}
}