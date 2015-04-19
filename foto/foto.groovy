import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("temperatur: enter")
logger.info ("temperatur: take foto")
def process = "raspistill -o status.jpg".execute()
process.text
logger.info ("temperatur: foto taken")
logger.info ("temperatur: decode")
new File('status.txt').text = new File("status.jpg").bytes.encodeBase64().toString()
logger.info ("temperatur: decode done")
logger.info ("temperatur: exit")