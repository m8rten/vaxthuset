import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("ventilation: enter")
new File('status.txt').text = new Random().nextInt(2)
logger.info ("ventilation: exit")