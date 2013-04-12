package com.segoviagroup.realstate;

import android.os.AsyncTask;

public class DataType {

	public String id;
	public String location;

	public void StartDownload(final ProcessListener pListener) {
		
		AsyncTask<DataType, Integer, Void> task = new AsyncTask<DataType, Integer, Void>() {

			@Override
			protected Void doInBackground(DataType... params) {

				params[0].OnDownload(pListener);
				return null;
			}
		};
		task.execute(this);
	}

	protected void OnDownload(ProcessListener pListener) {}

	public void StartUpload(final ProcessListener pListener) {
		
		AsyncTask<DataType, Integer, Void> task = new AsyncTask<DataType, Integer, Void>() {

			@Override
			protected Void doInBackground(DataType... params) {

				params[0].OnUpload(pListener);
				return null;
			}
		};
		task.execute(this);
	}

	protected void OnUpload( ProcessListener pListener) {}

	public String ToString() {
		return "";
	}
}