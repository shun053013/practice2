$(function(){
	var map = new Map();
	var array = [];
	var countMail = 0;


	$("#phone").on('click',function(){
		if(this.checked){

			var count1 = $('#phoneMail').length;
			var count2 = $('#pcMail').length;
			countMail = count1 + count2 ;
			if(countMail === 0) {
				countMail = 0
			}else{
				countMail = countMail
			}

			//keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys){
				array.push(key);
			}

			//array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをCountMobileの値とする
			for (var value of array){
				if(value === countMail){
					countMail = Math.max.apply(null,array) + 1;
				}else{
					countMail = countMail;
				}
			}

			//mapにセットしている
			map.set(countMail,'countMail');

			var mailAddress = document.getElementById("phone");
			mailAddress.setAttribute("name","mailAddressList["+ countMail + "].mailAddress");

			//<div id="phoneMail">の中に<input>を形成していく
			var parentM = document.getElementById("phoneMail");
			var childM = document.createElement("div");
			childM.setAttribute("id","idM");

			var phone = document.createElement("input");
			phone.setAttribute("type","text");
			phone.setAttribute("placeholder","phoneメールアドレス");
			phone.setAttribute("name","mailAddressList["+ countMail + "].mailAddress");
			phone.setAttribute("class","mail1");

			childM.appendChild(phone);
			parentM.appendChild(childM);

			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","del1");
			del.setAttribute("class","mail1");

			childM.appendChild(del);
			parentM.appendChild(childM);

			$("#del1").on('click',function(){
				$(".mail1").remove();
				map.delete(countMail);
			})


		//チェックが外れたら
		}else {

			$("#idM").remove();

			map.delete(countMail);


		}
	});

     $("#pc").on("click",function(){
    	 if(this.checked){

    	 var count1 = $('#phoneMail').length;
			var count2 = $('#pcMail').length;
			countMail = count1 + count2 ;
			if(countMail === 0) {
				countMail = 0
			}else{
				countMail = countMail
			}

			//keyを取り出してarray[]につめている
			var keys = map.keys();
			for(var key of keys){
				array.push(key);
			}

			//array[]を回して中にある値とcountWaseを比べて、同じだったらarray[]の最大値を取得し、その値に＋１したものをCountMobileの値とする
			for (var value of array){
				if(value === countMail){
					countMail = Math.max.apply(null,array) + 1;
				}else{
					countMail = countMail;
				}
			}

			//mapにセットしている
			map.set(countMail,'countMail');

			var mailAddress = document.getElementById("pc");
			mailAddress.setAttribute("name","mailAddressList["+ countMail + "].mailAddress");

			//<div id="phoneMail">の中に<input>を形成していく
			var parentTue = document.getElementById("pcMail");
			var childTue = document.createElement("div");
			childTue.setAttribute("id","idTue");

			var pc = document.createElement("input");
			pc.setAttribute("type","text");
			pc.setAttribute("placeholder","pcメールアドレス");
			pc.setAttribute("name","mailAddressList["+ countMail + "].mailAddress");
			pc.setAttribute("class","mail2");

			childTue.appendChild(pc);
			parentTue.appendChild(childTue);

			var del = document.createElement("input");
			del.setAttribute("type","button");
			del.setAttribute("value","削除");
			del.setAttribute("id","del1");
			del.setAttribute("class","mail2");

			childTue.appendChild(del);
			parentTue.appendChild(childTue);

			$("#del1").on('click',function(){
				$(".mail2").remove();
				map.delete(countMail);
			})

		//チェックが外れたら
    	 }else{
    		 $("#idTue").remove();
    		 map.delete(countMail);

    	 }

     })
　});
