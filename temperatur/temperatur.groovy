import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("temperatur: enter")
def temp = Integer.parseInt(new File("/sys/bus/w1/devices/28-0004551ab4ff/w1_slave").text.split("t=")[1].trim())/1000
new File('status.txt').text = temp
logger.info ("temperatur: exit")