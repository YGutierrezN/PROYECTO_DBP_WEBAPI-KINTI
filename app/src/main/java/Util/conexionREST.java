package Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class conexionREST
{
    //para no crear una instancia de la clase
    //patron de diseño singleton
    private static final String URL = "http://dbpygn.somee.com/api/" ;//end ponithttp://www.dbpygn.somee.com/api/
    private static Retrofit retrofit=null;

    public static Retrofit getConnection()
    {
        if (retrofit == null)
        {
                retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return retrofit;
    }

}
