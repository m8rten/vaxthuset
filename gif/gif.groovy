@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7' )
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON
import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("gif: enter")

def process = "convert ../foto/foto.jpg -resize 900x300 gif-r.jpg".execute()
process.waitForOrKill(100000)
logger.info ("gif: resized")

process = "convert gif-r.jpg -crop 300 gif-c.jpg".execute()
process.waitForOrKill(100000)
logger.info ("gif: croped")

def nextFileNr = new File("singels").listFiles().size() + 1
def nextFileNrZeroPad = sprintf('%06d', nextFileNr)

process = "cp gif-c-0.jpg singels/gif${nextFileNrZeroPad}.jpg".execute()
process.waitForOrKill(100000)
logger.info ("gif: copied to singels/gif${nextFileNrZeroPad}.jpg")

process = "convert -delay 100 -loop 0 singels/gif*.jpg animation.gif".execute()
process.waitForOrKill(100000)
logger.info ("gif: created animation")

new File('animation.txt').text = new File("animation.gif").bytes.encodeBase64().toString()
logger.info ("gif: encode")


/*
 * Update animation
 */
def mongolabApiKey = System.getenv('MONGOLAB_API_KEY') 
http = new HTTPBuilder("https://api.mongolab.com/api/1/databases/vaxthuset/collections/bilder?apiKey=$mongolabApiKey")
def currentDate = new Date()
http.post(body: [_id:"gif",
				 date: currentDate.format("yyyy-MM-dd'T'HH:mm:00'Z'"),
				 base64: new File('animation.txt').text],
		 requestContentType: JSON ) { resp ->
	logger.info ("gif: posted animation")
}

logger.info ("gif: exit")