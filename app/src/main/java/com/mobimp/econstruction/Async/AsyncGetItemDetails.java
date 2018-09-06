package com.mobimp.econstruction.Async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mobimp.econstruction.ArrayItem.ItemDetails;
import com.mobimp.econstruction.ArrayItem.ItemImageUrl;
import com.mobimp.econstruction.ArrayItem.ProductDetailsItem;

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

public class AsyncGetItemDetails extends AsyncTask<String, String, Boolean> {
	String ServerUrl;
	private ProgressDialog dialog;
	Context context;
	GetItemDetailsTask Task;
	String mInfo;
    List<ProductDetailsItem> mArray;
	public AsyncGetItemDetails(Context c, String Url, GetItemDetailsTask task) {
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
			
			Task.GetItemdetailsTaskSuccess(mArray);
			
			 
		} else {
			
			Task.GetItemdetailsTaskFailed(mInfo);
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
                    List<ProductDetailsItem> mitemArray=new ArrayList<ProductDetailsItem>();
					JSONArray ItemArray = jsonObj.getJSONArray("item");
					for(int i=0;i<ItemArray.length();i++){
						JSONObject cat = ItemArray.optJSONObject(i);
						ProductDetailsItem mItem=new ProductDetailsItem();
						mItem.ItemId=cat.optString("ID");
						mItem.itemCode=cat.optString("itemCode");
						mItem.ItemName=cat.optString("ItemName");
						mItem.ItemDesc=cat.optString("ItemDesc");
						mItem.ItemPrice=cat.optString("ItemPrice");
						mItem.vendorName=cat.optString("vendorName");
						mItem.vendorAbout =cat.optString("vendorAbout");
						mItem.Delivery_Time=cat.optString("Delivery_Time");
						mItem.Handling_Charge=cat.optString("Handling_Charge");

						List<ItemImageUrl> mItemImageArray=new ArrayList<ItemImageUrl> ();
						JSONArray ItemImage = jsonObj.getJSONArray("image");
						for(int j=0;j<ItemImage.length();j++) {
							JSONObject Image = ItemImage.optJSONObject(j);
							ItemImageUrl mItemImage = new ItemImageUrl();
							mItemImage.imageUrl=Image.optString("URL");
							mItemImageArray.add(mItemImage);
						}

						mItem.Images=mItemImageArray;

						ArrayList<ItemDetails> mItemDetailsArray=new ArrayList<ItemDetails>() ;
						JSONArray ItemDetails = jsonObj.getJSONArray("details");
						for(int j=0;j<ItemDetails.length();j++) {
							JSONObject Details = ItemDetails.optJSONObject(j);
							ItemDetails mItemDetails = new ItemDetails();
							mItemDetails.itemtitle=Details.optString("Title");
							mItemDetails.itemdescription=Details.optString("Description");
							mItemDetailsArray.add(mItemDetails);
						}
						mItem.Details=mItemDetailsArray;
						mitemArray.add(mItem);
					}
					mArray=mitemArray;
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
	
	public interface GetItemDetailsTask {
		void GetItemdetailsTaskSuccess(List<ProductDetailsItem> mArray);

		void GetItemdetailsTaskFailed(String info);
	}
}



