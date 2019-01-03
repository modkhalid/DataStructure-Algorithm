person=(name,age)=>{
	this.name;
	this.age;
	this.toString=()=>{
		return name+" "+age;
	}
}
teacher=(name,age,qual)=>{
	person.call(this,name,age);
	this.qual=qual;
	console.log(this.name+" "+this.age+" "+this.qual)
	this.toString=()=>{
		return this.name+" "+this.age+" "+this.qual;
	}

}

t=teacher('khalid',45,'bt')
// console.log(t.toString())