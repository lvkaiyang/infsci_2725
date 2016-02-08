db.ratings.mapReduce(
      function () {emit(this.MovieID, new NumberInt(this.Rating))}, //mapFunction
      (key, values)=>{return Array.avg(values)},//reduceFunction
      {
          out: 'result',
      }).find({value:5}).count()/db.movies.count()