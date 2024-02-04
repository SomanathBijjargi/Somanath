void display(){
	if(top == -1){
		printf("Stack is empty ..");
	}else{
		for(i=0;i<n;i++){
			printf("%d",stack[i]);
		}
	}
}

