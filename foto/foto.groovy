import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("foto: enter")
//def process = "raspistill -o status.jpg".execute()
//process.text
logger.info ("foto: taken")

def process = "convert status.jpg -resize 640x640 status-r.jpg".execute()
process.text
logger.info ("foto: resized")

process = "convert status-r.jpg -crop -160 status-c.jpg".execute()
process.text
logger.info ("foto: croped")

new File('status.txt').text = new File("status-c.jpg").bytes.encodeBase64().toString()
logger.info ("foto: decoded")
logger.info ("foto: exit")