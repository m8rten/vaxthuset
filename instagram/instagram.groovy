import java.util.logging.Logger
Logger logger = Logger.getLogger("")
logger.info ("instagram: enter")
def process = "convert ../foto/foto.jpg -resize 960x640 instagram-r.jpg".execute()
process.waitForOrKill(100000)
logger.info ("instagram: resized")

process = "convert instagram-r.jpg -crop 640 instagram-c.jpg".execute()
process.waitForOrKill(100000)
logger.info ("instagram: croped")

process = "convert -strip instagram-c-0.jpg instagram.jpg".execute()
process.waitForOrKill(100000)
logger.info ("instagram: stripped")

process = "php post.php".execute()
<<<<<<< HEAD
def text = process.text
logger.info ("instagram: posted")
logger.info ("text: " + text)
=======
process.waitForOrKill(100000)
logger.info ("instagram: posted")

>>>>>>> b9a068b74843072e99799fd18d19794a089eff90
process = "cp cookie.txt ../../bkp/".execute()
process.waitForOrKill(100000)
logger.info ("instagram: copy cookie")

<<<<<<< HEAD
logger.info ("instagram: exit")
=======
logger.info ("instagram: exit")
>>>>>>> b9a068b74843072e99799fd18d19794a089eff90
