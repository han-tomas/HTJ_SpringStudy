<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
<div class="container">
	<h3>믿고보는 맛집 리스트</h3>
	<hr>
		<category1 v-bind:cate1="cate_list1"></category1>
	<div style="height: 20px"></div>
	<h3>지역별 맛집 리스트</h3>
	<hr>
		<category2 v-bind:cate2="cate_list2"></category2>
	<div style="height: 20px"></div>
	<h3>메뉴별 맛집 리스트</h3>
	<hr>
		<category3 v-bind:cate3="cate_list3"></category3>
</div>
<script>
	Vue.component('category1',{ // new Vue에 의해 제어된다
		props:['cate1'],//받을 변수
		template:'<div class="row"><div class="col-md-3" v-for="vo in cate1">'
			+'<div class="img-thumbnail">'
			+'<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'<div class="caption">'
			+'<p style="font-size: 9px">{{vo.title }}</p>'
			+'</div>'
			+'</div>'
			+'</div></div>'
	})
	Vue.component('category2',{ // new Vue에 의해 제어된다
		props:['cate2'],//받을 변수
		template:'<div class="row"><div class="col-md-4" v-for="vo in cate2">'
			+'<div class="img-thumbnail">'
			+'<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'<div class="caption">'
			+'<p style="font-size: 9px">{{vo.title }}</p>'
			+'</div>'
			+'</div>'
			+'</div></div>'
	})
	Vue.component('category3',{ // new Vue에 의해 제어된다
		props:['cate3'],//받을 변수
		template:'<div class="row"><div class="col-md-3" v-for="vo in cate3">'
			+'<div class="img-thumbnail">'
			+'<img :src="vo.poster" alt="Lights" style="width:100%">'
			+'<div class="caption">'
			+'<p style="font-size: 9px">{{vo.title }}</p>'
			+'</div>'
			+'</div>'
			+'</div></div>'
	})
	new Vue({
		el:'.container',
		data:{
			cate_list1:[],
			cate_list2:[],
			cate_list3:[]
		},
		mounted:function(){
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:1
				}
			}).then(response=>{
				console.log(response.data)
				this.cate_list1=response.data;
			})
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:2
				}
			}).then(response=>{
				console.log(response.data)
				this.cate_list2=response.data;
			})
			axios.get('http://localhost/web/food/category.do',{
				params:{
					cno:3
				}
			}).then(response=>{
				console.log(response.data)
				this.cate_list3=response.data;
			})
		}
	})
</script>
</body>
</html>