package com.mobimp.econstruction.utility;


public class DataUrl {
    private static  String Server="http://w2w.hol.es/";
    public static final String GET_CATEGORY=Server+"api_controller/get_category";
    public static final String GET_ITEM=Server+"api_controller/get_item?mc=";
    public static final String GET_ITEM_DETAIL=Server+"api_controller/get_item_detail?id=";
    public static final String GET_ARTICLE=Server+"api_controller/get_article?p=";
    public static final String SEARCH_ITEM=Server+"api_controller/search_item?q=";
    public static final String GET_ADVERTISEMENT=Server+"api_controller/get_advertisement";
    public static final String SET_SIGNIN=Server+"api_controller/signin_with?n=";
    public static final String SET_DATA_CART=Server+"api_controller/addtocart?uid=";
    public static final String SET_WISH_LIST=Server+"api_controller/addtowishlist?uid=&pid=&token=";
    public static final String REMOVE_ITEM_FROM_CART=Server+"api_controller/remove_item_cart?uid=";
    public static final String UPDATE_SHIPPING=Server+"api_controller/shippingAddressUpdate?id=1&n=nengkhoiba%20chungkham&a=brahmapur%20chungkham%20leikai&s=Manipur&c=Imphal&p=795001&m=9774180184&u=111&token=m1lnnk01kj1kn03n62nl441126m2n1";
    public static final String DELETE_SHIPPING=Server+"api_controller/deleteShipping?uid=111&sid=1&token=m1lnnk01kj1kn03n62nl441126m2n1";
    public static final String GET_CART_LIST=Server+"api_controller/get_cart_item?uid=";
    public static final String GET_WISH_LIST=Server+"api_controller/get_wishlist_item?uid=111&token=m1lnnk01kj1kn03n62nl441126m2n1";
    public static final String GET_SHIPPING_ADDRESS=Server+"api_controller/get_shipping_address?uid=111&token=m1lnnk01kj1kn03n62nl441126m2n1";
}
