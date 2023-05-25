package com.kusitms.ovengers.retrofit


import com.kusitms.ovengers.data.*

import com.kusitms.ovengers.data.PointRequestBody
import com.kusitms.ovengers.data.RequestMakeCarrier
import com.kusitms.ovengers.data.RequestSignUp
import com.kusitms.ovengers.data.ResponseAlarms
import com.kusitms.ovengers.data.ResponseCarrierInfo
import com.kusitms.ovengers.data.ResponseGetMemo
import com.kusitms.ovengers.data.ResponseGetPoint
import com.kusitms.ovengers.data.ResponseGetTicket
import com.kusitms.ovengers.data.ResponseGoogleSignup
import com.kusitms.ovengers.data.ResponseMakeCarrier
import com.kusitms.ovengers.data.ResponseNewToken
import com.kusitms.ovengers.data.ResponsePostMemo
import com.kusitms.ovengers.data.ResponseSetPoint
import com.kusitms.ovengers.data.ResponseSignUp
import com.kusitms.ovengers.data.ResponseStorageCarrier
import com.kusitms.ovengers.data.ResponseTicketExist
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Path
import retrofit2.http.Query


interface APIS {

    // 회원가입 | 구글 로그인 | 유정
    @GET("/v1/user/oauth/google")
    fun oauthGoogle(
        @Header("Authorization") Authorization: String
    ) : Call<ResponseGoogleSignup>

    // 회원가입 | 추가 정보 수집 | 승균
    @POST("/v1/user/signUp")
    fun signUp(
        @Header("Authorization") Authorization: String,
        @Body signUp: RequestSignUp
    ) : Call<ResponseSignUp>

    // 스토어 | 포인트 조회 | 유정
    @GET("/v1/myStore/selectPoint")
    fun getPoint(
        @Header("Authorization") Authorization: String
    ) : Call<ResponseGetPoint>

    // 스토어 | 포인트 차감 | 유정
    @PUT("/v1/myStore/updatePoint")
    fun setPoint(
        @Header("Authorization") Authorization: String,
        @Body PointRequestBody: PointRequestBody
    ) : Call<ResponseSetPoint>

    // accessToken 재발급 | 유정
    @GET("/v1/user/reissue")
    fun newToken(
        @Header("Authorization") Authorization: String,
    ) : Call<ResponseNewToken>

    // 캐리어 추가 | 승균
    @POST("/v1/myCarrier/addCarrier")
    fun addCarrier(
        @Header("Authorization") Authorization: String,
        @Body RequestMakeCarrier: RequestMakeCarrier
    ) : Call<ResponseMakeCarrier>

    // 알림 | 알림 조회 | 유정
    @GET("/v1/myAlarm/selectAllAlarms")
    fun getAlarms(
        @Header("Authorization") Authorization: String
    ) : Call<ResponseAlarms>

    // 보관함 | 사용자 캐리어 조회 | 유정
    @GET("/v1/storage")
    fun getCarrier(
        @Header("Authorization") Authorization: String
    ) : Call<ResponseStorageCarrier>

    // 보관함 | 캐리어 선택 > 정보 | 유정
    @GET("/v1/myCarrier/getInfo")
    fun getCarrierInfo(
        @Header("Authorization") Authorization: String,
        @Query("id") id : String
    ) : Call<ResponseCarrierInfo>

    // 보관함 | 캐리어 선택 > 티켓 리스트 | 유정
    @GET("/v1/myCarrier/selectTicketAll")
    fun getTicket(
        @Header("Authorization") Authorization: String,
        @Query("id") id : String
    ) : Call<ResponseGetTicket>

    // 보관함 | 티켓 선택 > 티켓 기록 존재 여부 조회 | 유정
    @GET("/v1/ticket/memo/checkExist/{carrierId}")
    fun getTicketExist(
        @Header("Authorization") Authorization: String,
        @Path("carrierId") carrierId : String,
        @Query("id") id : String,
    ) : Call<ResponseTicketExist>

    //캐리어 이름 변경 ㅣ 승균
    @PUT("/v1/myCarrier/editCarrierName")
    fun editCarrierName(
        @Header("Authorization") Authorization: String,
        @Body RequestEditCarrierName: RequestEditCarrierName
    ) : Call<ResponseEditCarrierName>

    //캐리어 날짜 변경 ㅣ 승균
    @PUT("/v1/myCarrier/editCarrierPeriod")
    fun editCarrierPeriod(
        @Header("Authorization") Authorization: String,
        @Body RequestEditCarrierPeriod: RequestEditCarrierPeriod
    ) : Call<ResponseEditCarrierPeriod>

    //캐리어 국가 변경 ㅣ 승균
    @PUT("/v1/myCarrier/editCarrierCountry")
    fun editCarrierCountry(
        @Header("Authorization") Authorization: String,
        @Body RequestEditCarrierCountry: RequestEditCarrierCountry
    ) : Call<ResponseEditCarrierCountry>


    //캐리어 삭제하기 ㅣ 승균
    @PUT("/v1/myCarrier/deleteCarrier")
    fun deleteCarrier(
        @Header("Authorization") Authorization: String,
        @Body RequestDeleteCarrier: RequestDeleteCarrier
    ) : Call<ResponseDeleteCarrier>


    //캐리어 가져오기 ㅣ 승균
    @GET("/v1/myCarrier/selectAll")
    fun getCarrierList(
        @Header("Authorization") Authorization: String
    ) : Call<ResponseGetCarrier>


    //링크 업로드 ㅣ 승균
    @POST("/v1/myCarrier/addTicket/url")
    fun postLinkUrl(
        @Header("Authorization") Authorization: String,
        @Body RequestPostLinkUrl : RequestPostLinkUrl
    ) : Call<ResponsePostLinkUrl>

    // 보관함 | 티켓 선택 > 기록 O > 조회 | 유정
    @GET("/v1/ticket/memo/{carrierId}")
    fun getMemo(
        @Header("Authorization") Authorization: String,
        @Path("carrierId") carrierId : String,
        @Query("id") id : String,
    ): Call<ResponseGetMemo>

    // 보관함 | 티켓 선택 > 기록 X > 작성 | 유정
    @Multipart
    @POST("/v1/ticket/memo")
    fun postMemo(
        @Header("Authorization") Authorization: String,
        @Part file: MultipartBody.Part,
        @Part("dto") dto: RequestBody
    ): Call<ResponsePostMemo>

    // 보관함 | 티켓 기록 삭제 | 유정
    @DELETE("/v1/ticket/memo/{carrierId}")
    fun deleteMemo(
        @Header("Authorization") Authorization: String,
        @Path("carrierId") carrierId : String,
        @Query("id") id : String,
    ): Call<ResponseGetMemo>


}