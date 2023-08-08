<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
	margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:960px;
}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3" v-for="vo in goods_list">
	      <div class="thumbnail">
	        <a :href="'detail.do?no='+vo.no" target="_blank">
	          <img :src="vo.poster" :title="vo.title" style="width:100%">
	          <div class="caption">
	            <p style="font-size: 9px">{{vo.price}}</p>
	          </div>
	        </a>
	      </div>
	    </div>
	</div>
	<div style="height: 10px"></div>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
			  <li v-if="startPage>1"><a href="#" v-on:click="prev()">&lt;&lt;</a></li>
			  <li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''"><a href="#" v-on:click="selectPage(i)">{{i}}</a></li>
			  <li v-if="endPage<totalpage"><a href="#" v-on:click="next()">&gt;&gt;</a></li>
			</ul>
		</div>
	</div>
	<h3>최근 방문 상품</h3>
	<hr>
	<div class="row">
	
	</div>
</div>
<script>
	new Vue({
		el:'.container-fluid',
		data:{
			goods_list:[],
			curpage:1,
			totalpage:0,
			startPage:0,
			endPage:0,
			goods_cookie:[]
		},
		// 자동 호출
		mounted:function(){
			this.send()
		},
		// 사용자 정의 함수 =>사용자가 반드시 호출해줘야 한다
		methods:{
			// 서버와 통신하는 함수 
			send:function(){
				let _this=this;
				// axios.get() => @GetMapping , axios.post() => @PostMapping
				// 412 , 400, 500, 404
				axios.get("http://localhost/web/goods/list_vue.do",{
					// 전송데이터
					params:{
						page:this.curpage
					}
				}).then(function(response){
					console.log(response.data)
					_this.goods_list=response.data
					_this.curpage=response.data[0].curpage;
					_this.totalpage=response.data[0].totalpage;
					_this.startPage=response.data[0].startPage;
					_this.endPage=response.data[0].endPage;					
				})
			},
			range:function(start,end){
				let arr=[];
				let length =end-start
				for(let i=0;i<=length;i++)
				{
					arr[i]=start
					start++
				}
				return arr;
			},
			prev:function(){
				this.curpage=this.startPage-1;
				this.send()
			},
			next:function(){
				this.curpage=this.endPage+1;
				this.send()
			},
			selectPage:function(page){
				this.curpage=page;
				this.send();
			}
			
		}
	})
</script>
</body>
</html>