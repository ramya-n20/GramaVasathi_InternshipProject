package com.gramavasathi.app.data.repository

import com.gramavasathi.app.data.model.Booking
import com.gramavasathi.app.data.model.FarmStay
import com.gramavasathi.app.data.model.SampleData

class FarmStayRepository {

    fun getFarmStays(): List<FarmStay> {
        return SampleData.farmStays
    }

    fun saveBooking(booking: Booking): Result<Boolean> {
        return Result.success(true)
    }
}