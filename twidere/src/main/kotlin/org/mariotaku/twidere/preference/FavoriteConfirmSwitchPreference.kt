/*
 *             Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2017 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.preference

import android.content.Context
import android.support.v7.preference.PreferenceManager
import android.support.v7.preference.SwitchPreferenceCompat
import android.util.AttributeSet
import org.mariotaku.kpreferences.get
import org.mariotaku.twidere.R
import org.mariotaku.twidere.constant.iWantMyStarsBackKey

/**
 * Changes title to "Favorite/Like" confirmation respect to user settings
 *
 * Created by mariotaku on 2017/4/12.
 */
class FavoriteConfirmSwitchPreference(context: Context, attrs: AttributeSet? = null) :
        SwitchPreferenceCompat(context, attrs) {

    override fun onAttachedToHierarchy(preferenceManager: PreferenceManager) {
        super.onAttachedToHierarchy(preferenceManager)
        if (preferenceManager.sharedPreferences[iWantMyStarsBackKey]) {
            setTitle(R.string.preference_title_favorite_confirmation)
            setSummary(R.string.preference_summary_favorite_confirmation)
        } else {
            setTitle(R.string.preference_title_like_confirmation)
            setSummary(R.string.preference_summary_like_confirmation)
        }
    }
}