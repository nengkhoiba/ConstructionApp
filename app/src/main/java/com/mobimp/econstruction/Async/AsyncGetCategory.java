package com.mobimp.econstruction.Async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mobimp.econstruction.ArrayItem.CategoryItem;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AsyncGetCategory extends AsyncTask<String, String, Boolean> {
	String ServerUrl;
	private ProgressDialog dialog;
	Context context;
	GetCategoryTask Task;
	String mInfo;
    List<CategoryItem> mArray;
	public AsyncGetCategory(Context c, String Url, GetCategoryTask task) {
		super();
		ServerUrl = Url;

		context = c;
		Task=task;

	}

	@Override
	protected void onPostExecute(Boolean result) {
		if (dialog != null && dialog.isShowing()) {
			dialog.dismiss();
		}

		if (result) {
			
			Task.GetCategoryTaskSuccess(mArray);
			
			 
		} else {
			
			Task.GetCategoryTaskFailed(mInfo);
		}
	}

	@Override
	protected Boolean doInBackground(String... params) {
		// TODO doInBackground
		Boolean rtrn = false;
	
		String jsonStr = getJSONResponse(ServerUrl);
		System.out.println("------------------" + jsonStr);
		if (jsonStr != null) {
			try {
				JSONObject jsonObj = new JSONObject(jsonStr);
				// Getting JSON Array nodel
				String status = jsonObj.getString("success");
				//JSONArray classNameArray = jsonObj.getJSONArray("sectionName");
				if(status.equals("true"))
				{
                    List<CategoryItem> mCatArray=new ArrayList<CategoryItem>();
					JSONArray CategoryArray = jsonObj.getJSONArray("output");
					for(int i=0;i<CategoryArray.length();i++){
						JSONObject cat = CategoryArray.optJSONObject(i);
						CategoryItem mItem=new CategoryItem();
						mItem.CategoryName=cat.optString("Description");
						mItem.MasterCategory=cat.optString("MasterCat");
						mItem.ImageUrl=cat.optString("Image");
						mCatArray.add(mItem);
					}
					mArray=mCatArray;
					rtrn=true;

				}else{

					rtrn=false;
				}
				
			
				
				
				
			} catch (JSONException e) {
				e.printStackTrace();

				rtrn=false;
			}
		} else {
			rtrn=false;
			Log.e("ServiceHandler", "Couldn't get any data from the url");
		}
		return rtrn;
	}

	protected void onPreExecute() {
		
		//dialog = ProgressDialog.show(context, null, "Loading data...", true, false);
	 
	}
	public static String getJSONResponse(String Url) {

		StringBuffer sb = new StringBuffer();
		String Json_search_to_server;
		try {
			URL url;
			HttpURLConnection urlConn;
			DataOutputStream printout;
			// http://192.168.1.8:8080/zcnbroker/registerWithZCN.d
			url = new URL(Url);
			Log.d("ZCN", url.toString());
			urlConn = (HttpURLConnection) url.openConnection();

			urlConn.setConnectTimeout(1000);
			urlConn.setDoOutput(true);
			// Specify the content type.
			urlConn.setRequestProperty("Content-Type", "application/json");
			// Send POST output.
			printout = new DataOutputStream(urlConn.getOutputStream());

			Json_search_to_server = "";
			Log.d("HOSTAS", Json_search_to_server);

			printout.writeBytes(Json_search_to_server);

			printout.flush();

			printout.close();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));

			String line;

			while ((line = rd.readLine()) != null) {

				sb.append(line);

			}

			rd.close();

			System.out.println("Response.........:" + sb.toString());
			if (!sb.toString().matches("")) {

				return sb.toString();
			} else {
				return null;
			}

		}

		catch (ConnectTimeoutException e) {

			e.printStackTrace();
			return null;
		}

		catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public interface GetCategoryTask {
		void GetCategoryTaskSuccess(List<CategoryItem> mArray);

		void GetCategoryTaskFailed(String info);
	}
}



