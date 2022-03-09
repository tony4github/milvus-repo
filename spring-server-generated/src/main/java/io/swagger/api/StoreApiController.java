package io.swagger.api;

import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-08T21:06:51.858Z[GMT]")
@RestController
public class StoreApiController implements StoreApi {

    private static final Logger log = LoggerFactory.getLogger(StoreApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StoreApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteOrder(@Parameter(in = ParameterIn.PATH, description = "ID of the order that needs to be deleted", required=true, schema=@Schema()) @PathVariable("orderId") Long orderId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Map<String, Integer>> getInventory() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Map<String, Integer>>(objectMapper.readValue("{\n  \"key\" : 0\n}", Map.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Map<String, Integer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Map<String, Integer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> getOrderById(@Parameter(in = ParameterIn.PATH, description = "ID of order that needs to be fetched", required=true, schema=@Schema()) @PathVariable("orderId") Long orderId) {
        String lob = request.getHeader("x-lob");
        if(orderId.intValue() == 5 && !"AMG".equalsIgnoreCase(lob)){
            log.error("Pre-condition check triggered by Order id = 5. The check failed : 'x-lob' header is not found");
            return new ResponseEntity<Order>(new Order().id(0L).petId(0L).quantity(0).complete(false).status(Order.StatusEnum.PLACED), HttpStatus.PRECONDITION_REQUIRED );
        }
        
        String accept = request.getHeader("Accept");
        log.info("orderId: "+orderId );

        if (accept != null && accept.contains("application/json")) {
            try {
                ResponseEntity resp = null;
                switch (orderId.intValue()) {
                    case 5: resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 555,\n  \"quantity\" : 51,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.OK);
                        break;
                    case 6: resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 666,\n  \"quantity\" : 60,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.OK);
                        break;
                    case 7: resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 77,\n  \"quantity\" : 70,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.OK);
                        break;
                    case 8: resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 8000,\n  \"quantity\" : 88,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.OK);
                        break;
                    case 9: resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 999,\n  \"quantity\" : 9,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.OK);
                        break;
                   default : resp =  new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 198772,\n  \"quantity\" : 10,\n  \"id\" : "+orderId+",\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : false,\n  \"status\" : \"placed\"\n}", Order.class), HttpStatus.NOT_FOUND);
                }
                return resp;
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(new Order().id(0L).petId(0L).quantity(0).complete(false).status(Order.StatusEnum.PLACED), HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> placeOrder(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Order body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue("{\n  \"petId\" : 198772,\n  \"quantity\" : 7,\n  \"id\" : 10,\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

}
