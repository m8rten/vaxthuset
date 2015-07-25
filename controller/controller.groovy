@GrabResolver(name="netty snapshots", root="http://clinker.netty.io/nexus/content/repositories/snapshots")
@GrabResolver(name="OJO", root="https://oss.jfrog.org/artifactory/repo")
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
@Grab("io.ratpack:ratpack-groovy:0.9.13")
@Grab("io.ratpack:ratpack-jackson:0.9.13")   
import static ratpack.groovy.Groovy.ratpack
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder
import groovy.time.TimeCategory
import ratpack.jackson.JacksonModule          
import static ratpack.jackson.Jackson.jsonNode
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON

/*
 * Loads configuration
 */
def vaxthusetAdminKey = System.getenv('VAXTHUSET_ADMIN_KEY') 


/*
 * Defines handlers
 */
ratpack {
    bindings {                                  
        add new JacksonModule()                   
    } 
    handlers {

        post("api/controller") {                             
            def controller = parse jsonNode()
	    println "CONTROLLER: recived request" 
            if (controller.key.toString() == "\"$vaxthusetAdminKey\"") {
		println "CONTROLLER: do watering for ${controller.time.toString()} sec"
                "/bin/bash /home/pi/vaxthuset/bevattning/bevattning.sh ${controller.time.toString()}".execute() 
		render "success"
            } else {
                render "fail"
            }
        }   
    }
}
