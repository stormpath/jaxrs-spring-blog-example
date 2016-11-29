package com.stormpath.example.jaxrs;

import com.stormpath.example.common.dao.DefaultStormtrooperDao;
import com.stormpath.example.common.dao.StormtrooperDao;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class JaxrsApp extends ResourceConfig {


    public JaxrsApp() {

        // scan the resources package for our resources
        packages(getClass().getPackage().getName() + ".resources");

        // use @Inject to bind the StormtrooperDao
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(stormtrooperDao()).to(StormtrooperDao.class);
            }
        });
    }

    private StormtrooperDao stormtrooperDao() {
        return new DefaultStormtrooperDao();
    }
}
