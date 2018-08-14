package com.mobimp.econstruction.utility;

import java.util.ArrayList;

/**
 * Created by 06peng on 2015/6/24.
 */
public class ImageUrlUtils {
    static ArrayList<String> wishlistImageUri = new ArrayList<>();
    static ArrayList<String> cartListImageUri = new ArrayList<>();

    public static String[] getImageUrls() {
        String[] urls = new String[] {
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",


        };
        return urls;
    }

    public static String[] getOffersUrls() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",

        };
        return urls;
    }

    public static String[] getHomeApplianceUrls() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",

        };
        return urls;
    }

    public static String[] getElectronicsUrls() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",

        };
        return urls;
    }

    public static String[] getLifeStyleUrls() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",

        };
        return urls;
    }

    public static String[] getBooksUrls() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",

        };
        return urls;
    }

    public static String[] forRent() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTG9jlr6XgqL6RQ90_xF3q9OQQlaClTGpf_quU4oLeXRkjhvpC",
                "https://5.imimg.com/data5/PP/KP/MY-3763192/2dx-backhoe-loader-500x500.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgbbQPKkbIQSw3KAkGsqnAIWr0Sft0vHQuzBP1szwegqUZeKaG",
                "https://www.heavyequipments.in/new/wp-content/uploads/2017/06/LT-Komatsu-PC210Lc-Excavator.jpg",

        };
        return urls;
    }
    public static String[] forsales() {
        String[] urls = new String[]{
                "https://content3.jdmagicbox.com/comp/hyderabad/t4/040pxx40.xx40.100916152716.i4t4/catalogue/sai-ram-steel-and-cement-kapra-secundrabad-hyderabad-cement-dealers-ultratech-33e3g0k.jpg",
                "https://content3.jdmagicbox.com/comp/vadodara/k6/0265px265.x265.120503150755.k5k6/catalogue/ambika-steel-and-cement-ajwa-road-vadodara-tile-dealers-q7h2j.jpg",
                "https://d30jrvx4u4006.cloudfront.net/media/blog/buy_cement-from_xfactory.in-4.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSctls5SXCsZrJMYhNPPxRfoNyVGlsQKOPeTWlEmGSBVafl1pDUig",

        };
        return urls;
    }
    public static String[] forarticle() {
        String[] urls = new String[]{
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnRP6nHbkvDe4-6eM1ScQi-EwSnv8xbNMzPPwjoN1HAywPSdit8A",
                "https://www.robsonforensic.com/upload/articles/Excavation-Vibration-Construction-Expert.jpg",
                "https://static01.nyt.com/images/2017/09/28/nyregion/28construction/28construction-articleLarge.jpg?quality=75&auto=webp&disable=upscale",
                "http://www.digitaljournal.com/img/4/2/9/6/2/6/i/3/7/0/o/Con1_(2).jpg",

        };
        return urls;
    }
    // Methods for Wishlist
    public void addWishlistImageUri(String wishlistImageUri) {
        this.wishlistImageUri.add(0,wishlistImageUri);
    }

    public void removeWishlistImageUri(int position) {
        this.wishlistImageUri.remove(position);
    }

    public ArrayList<String> getWishlistImageUri(){ return this.wishlistImageUri; }

    // Methods for Cart
    public void addCartListImageUri(String wishlistImageUri) {
        this.cartListImageUri.add(0,wishlistImageUri);
    }

    public void removeCartListImageUri(int position) {
        this.cartListImageUri.remove(position);
    }

    public ArrayList<String> getCartListImageUri(){ return this.cartListImageUri; }
}
