import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("foto: enter")
def process = "raspistill -n -o foto.jpg".execute()
process.waitForOrKill(100000)
logger.info ("foto: taken")

def process = "convert foto.jpg -resize 960x640 instagram/instagram-r.jpg".execute()
process.text
logger.info ("foto: resized")

process = "convert instagram/instagram-r.jpg -crop 640 instagram/instagram-c.jpg".execute()
process.text
logger.info ("foto: croped")

process = "convert foto.jpg -resize 900x300 foto-r.jpg".execute()
process.text
logger.info ("foto: resized")

process = "convert foto-r.jpg -crop -213 foto-c.jpg".execute()
process.text
logger.info ("foto: croped")

new File('foto.txt').text = new File("foto-c.jpg").bytes.encodeBase64().toString()
logger.info ("foto: decoded")

logger.info ("foto: exit")