/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.accord;

import data.Dao;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import logic.Accord;
import java.util.List;

/**
 *
 * @author jonathan
 */
@Path("/accord")
public class GetAccord {
    
    	@GET
	@Path("/getfile/{path}")
	@Produces({MediaType.APPLICATION_OCTET_STREAM})
	public Response getFile(@PathParam("path") String path) {
                
           try{ 
		File file = new File(path);
                if(file.exists()){
		Response.ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename="+file.getName());
                response.header("Content-Type", "application/octet-stream");
                response.header("Content-Length", file.length());
		return response.build();
                }
                throw new Exception();
           }
           catch(Exception e){
               throw new NotFoundException();
           }

	}
    
    	@GET
	@Path("/getaccord/{accnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public ToRestAccord getAccord(@PathParam("accnumber") String accnumber ) {
               
           try{ 
              
		Accord a= Dao.getDao().getAccordByAccNumber("CMSPH-45");
               ToRestAccord b= ToRestAccord.toRestAcc(a);
               return b;
           }
           catch(Exception e){
               throw new NotFoundException();
           }

	}
        
        @GET
	@Path("/getaccord/sessiondate/{sessiondate}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordBySessionDate(@PathParam("sessiondate") String sessiondate){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordBySessionDate(format.parse(sessiondate));
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
        
        @GET
	@Path("/getaccord/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordByType(@PathParam("type") char type){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordByType(type);
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
          @GET
	@Path("/getaccord/incordate/{incordate}")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAccordByIncorDate(@PathParam("incordate") String incordate){
            try{
                DateFormat format= new SimpleDateFormat("yyyy-dd-MM");
                
                List<Accord> list= Dao.getDao().searchAccordByIcorporatedDate(format.parse(incordate));
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
       
        
        @GET
	@Path("/getaccord/all")
	@Produces(MediaType.APPLICATION_JSON)
        public List<ToRestAccord> getAllAccords(){
            try{     
                List<Accord> list= Dao.getDao().searchAllAccords();
                List<ToRestAccord> result= new ArrayList();
                for(Accord item: list){
                    result.add(ToRestAccord.toRestAcc(item));
                }
                return result;
            }
            catch(Exception e){
                throw new NotFoundException();
            }
        }
        
    
}