def process = "raspistill -o status.jpg".execute()
process.text
new File('status.txt').text = new File("status.jpg").bytes.encodeBase64().toString()
