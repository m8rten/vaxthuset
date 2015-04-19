@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON

def mongolabApiKey = System.getenv('MONGOLAB_API_KEY') 

/*
 * Post current sensor status
 */
def http = new HTTPBuilder("https://api.mongolab.com/api/1/databases/vaxthuset/collections/status-test?apiKey=$mongolabApiKey")
def currentDate = new Date()
http.post(body: [temperature: new File('../temperatur/status.txt').text.toDouble(),
 				ventilation: new File('../ventilation/status.txt').text.toInteger(),
				date: currentDate.format("MM/dd/yyyy'T'HH:mm:00.000'Z'"),
				hour: currentDate.getHours(),
				minute: currentDate.getMinutes()],
		 requestContentType: JSON ) { resp ->
}

/*
 * Update latest photo
 */
http = new HTTPBuilder("https://api.mongolab.com/api/1/databases/vaxthuset/collections/bilder-test?apiKey=$mongolabApiKey")
http.post(body: [_id:"foto",
				 base64: new File('../foto/status.txt').text],
		 requestContentType: JSON ) { resp ->
}