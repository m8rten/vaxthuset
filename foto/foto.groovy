import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("foto: enter")
def process = "raspistill -rot 270 -n -o foto.jpg".execute()
process.waitForOrKill(100000)
process = "convert foto.jpg -resize 900x300 foto-r.jpg".execute()
process.waitForOrKill(100000)
logger.info ("foto: resized")
process = "convert foto-r.jpg -crop 300 foto-c.jpg".execute()
process.waitForOrKill(100000)
logger.info ("foto: croped")
new File('foto.txt').text = new File("foto-c-0.jpg").bytes.encodeBase64().toString()
logger.info ("foto: decoded")
logger.info ("foto: exit")