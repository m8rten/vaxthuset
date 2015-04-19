import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("temperatur: enter")
new File('status.txt').text = new Random().nextInt(32)
logger.info ("temperatur: exit")