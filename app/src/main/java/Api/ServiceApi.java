package Api;

import java.util.List;

import Model.Comida;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceApi

{
    @GET("comida")
    public abstract Call<List<Comida>> listComids();
    @POST("comida/agregar")
    public abstract Call<Comida> addComida(@Body Comida objcomida);

}
