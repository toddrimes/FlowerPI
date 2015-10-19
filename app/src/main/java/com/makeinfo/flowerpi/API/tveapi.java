package com.makeinfo.flowerpi.API;

import com.makeinfo.flowerpi.model.PageModel;
import com.makeinfo.flowerpi.model.VideoModel;
import com.makeinfo.flowerpi.model.ProgramModel;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;


public interface tveapi {

    @Headers("api_key: 684haamcphfa2qhnja93tuxp")
    @GET("/apps/{appId}/pages/{alias}")
    public void getPage(@Path("appId") String appId, @Path("alias") String alias, Callback<PageModel> response);

    @GET("/apps/{appId}/pages/programs/{programId}")
    public void getProgram(@Path("appId") String appId, @Path("programId") String programId, Callback<ProgramModel> response);

    @GET("/apps/{appId}/pages/videos/{videoId}")
    public void getVideo(@Path("appId") String appId, @Path("videoId") String videoId, Callback<VideoModel> response);

    @GET("/apps/{appId}/pages/player/{videoId}")
    public void getPlayer(@Path("appId") String appId, @Path("videoId") String videoId, Callback<VideoModel> response);

}
