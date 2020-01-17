function Student(name, kor, eng, math, sci) {
	this.이름 = name;
	this.국어 = kor;
	this.영어 = eng;
	this.수학 = math;
	this.과학 = sci;
	
	this.getSum = function() {
		return this.국어+this.영어+this.수학+this.과학;
	}
	
	this.getAvg = function() {
		return this.getSum()/4;
	}
	this.toString = function() {
		return this.이름+"\t"+this.getSum()+"\t"+this.getAvg();
		
		
	}
}