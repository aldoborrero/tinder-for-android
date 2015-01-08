package com.aldoborrero.tinder.api.services;

import com.aldoborrero.tinder.api.responses.AuthResponse;
import com.aldoborrero.tinder.api.responses.LikeMomentResponse;
import com.aldoborrero.tinder.api.responses.LikeResponse;
import com.aldoborrero.tinder.api.responses.MomentsResponse;
import com.aldoborrero.tinder.api.responses.PassMomentResponse;
import com.aldoborrero.tinder.api.responses.PassResponse;
import com.aldoborrero.tinder.api.responses.PopularLocationsResponse;
import com.aldoborrero.tinder.api.responses.RecommendationsResponse;
import com.aldoborrero.tinder.api.responses.UpdatesResponse;
import com.aldoborrero.tinder.api.responses.UserInfoResponse;

import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

public interface TinderService {

    @POST("/auth")
    Observable<AuthResponse> auth();

    @GET("/user/recs")
    Observable<RecommendationsResponse> getUserRecommendations();

    @GET("/user/{id}")
    Observable<UserInfoResponse> getUserInfo();

    @GET("/like/{id}")
    Observable<LikeResponse> like();

    @GET("/pass/{id}")
    Observable<PassResponse> pass();

    @POST("/feed/moments")
    Observable<MomentsResponse> postMomentsFeed();

    @POST("/moment/{id}/like")
    Observable<LikeMomentResponse> likeMoment();

    @POST("/moment/{id}/pass")
    Observable<PassMomentResponse> passMoment();

    @GET("/location/popular")
    Observable<PopularLocationsResponse> getPopularLocations();

    @POST("/updates")
    Observable<UpdatesResponse> postUpdates();

    @POST("/profile")
    Observable<UserInfoResponse> updateUserInformation();

}
