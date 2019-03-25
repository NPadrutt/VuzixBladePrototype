package ch.hslu.ninopadrutt.vuzibladeprototype

import com.vuzix.hud.resources.DynamicThemeApplication

class BaseApplication : DynamicThemeApplication() {

    override fun getNormalThemeResId(): Int {
        return R.style.AppTheme
    }

    override fun getLightThemeResId(): Int {
        return R.style.AppTheme_Light
    }
}