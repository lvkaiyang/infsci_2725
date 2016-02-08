//Q6.1
db.ratings.insert({
	"UserID" : "36",
	"MovieID" : "1020",
	"Rating" : "4",
	"Timestamp" : "1049772929"
})
//Q6.2
db.ratings.find({UserID: '36', MovieID:'1020'}) 
//Q6.3
db.ratings.remove({UserID: '36', MovieID:'1020'})