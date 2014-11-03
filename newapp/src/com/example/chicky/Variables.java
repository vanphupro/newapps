package com.example.chicky;

import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import com.example.models.RssItem;
import com.example.newapp.R;

/**
 * @author clark
 * 
 */
public class Variables {
	public static final String[] PAPERS = { "Vietnamnet.vn", "Ngoisao.com",
			"Baomoi.com" };
	public static final int[] ICONS = { R.drawable.vnexpress,
			R.drawable.ngoisao, R.drawable.baomoi };

	public static final String[] VNEXPRESS_CATEGORY = { "Trang chủ", "Dời sống" };
	public static final String[] NGOISAO_CATEGORY = { "Hậu trường", "Thể thao" };
	public static final String[] BAOMOI_CATEGORY = { "Trang chủ", "Tin tức" };
	public static final String[] VNEXPRESS_LINKS = {
			"http://vietnamnet.vn/rss/home.rss",
			"http://vietnamnet.vn/rss/moi-nong.rss" };
	public static final String[] NGOISAO_LINKS = {
			"http://ngoisao.net/rss/hau-truong.rss",
			"http://ngoisao.net/rss/the-thao.rss" };
	public static final String[] BAOMOI_LINKS = {
			"http://www.tinmoi.vn/rss/trang-chu.rss",
			"http://www.tinmoi.vn/rss/Tin-tuc.rss" };

	public static final String[][] LINKS = { VNEXPRESS_LINKS, NGOISAO_LINKS,
			BAOMOI_LINKS };
	public static final String[][] CATEGORIES = { VNEXPRESS_CATEGORY,
			NGOISAO_CATEGORY, BAOMOI_CATEGORY };
	public static final String PAPER = "paper";
	public static final String CATEGORY = "category";
	public static final String LINK = "link";
	public static HashMap<Integer, List<RssItem>> newsMap = new HashMap<Integer, List<RssItem>>();
}
