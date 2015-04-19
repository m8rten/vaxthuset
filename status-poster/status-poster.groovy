@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON
import java.util.logging.Logger

Logger logger = Logger.getLogger("")

logger.info ("status-poster: enter")


while(true){
    
    def mongolabApiKey = System.getenv('MONGOLAB_API_KEY') 

	/*
	 * Post current sensor status
	 */
	def http = new HTTPBuilder("https://api.mongolab.com/api/1/databases/vaxthuset/collections/status?apiKey=$mongolabApiKey")
	def currentDate = new Date()
	http.post(body: [temperature: new File('../temperatur/status.txt').text.toDouble(),
	 				ventilation: new File('../ventilation/status.txt').text.toInteger(),
					date: currentDate.format("MM/dd/yyyy'T'HH:mm:00.000'Z'"),
					hour: currentDate.getHours(),
					minute: currentDate.getMinutes()],
			 requestContentType: JSON ) { resp ->
		logger.info ("status-poster: posted sensor data")
	}

	/*
	 * Update latest photo
	 */
	http = new HTTPBuilder("https://api.mongolab.com/api/1/databases/vaxthuset/collections/bilder?apiKey=$mongolabApiKey")
	http.post(body: [_id:"foto",
					 base64: new File('../foto/status.txt').text],
			 requestContentType: JSON ) { resp ->
		logger.info ("status-poster: posted photo")
	}

    sleep(1000)
}
