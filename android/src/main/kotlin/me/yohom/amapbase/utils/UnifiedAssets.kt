package me.yohom.amapbase.utils

import android.graphics.BitmapFactory
import com.amap.api.maps.model.BitmapDescriptor
import com.amap.api.maps.model.BitmapDescriptorFactory
import me.yohom.amapbase.AMapBasePlugin

object UnifiedAssets {
    private val assetManager = AMapBasePlugin.registrar.context().assets

    /**
     * 获取宿主app的图片
     */
    fun getBitmapDescriptor(asset: String): BitmapDescriptor {
        val assetFileDescriptor = assetManager.openFd(AMapBasePlugin.registrar.lookupKeyForAsset(asset))
        return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeStream(assetFileDescriptor.createInputStream()))
    }

    /**
     * 获取plugin自带的图片
     */
    fun getAMapBitmapDescriptor(asset: String): BitmapDescriptor {
        val assetFileDescriptor = assetManager.openFd(AMapBasePlugin.registrar.lookupKeyForAsset(asset, "amap_base"))
        return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeStream(
                assetFileDescriptor.createInputStream(),
                null,
                BitmapFactory.Options().apply {
                    outHeight = 36
                    outWidth = 36
                }
        ))
    }
}