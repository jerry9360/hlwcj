$(function() {	
	fileUploadNotice();
});


function fileUploadNotice(){
	var uploader = WebUploader.create({
	    auto: true,
	    swf: base + '/assest/js/common/webuploader/Uploader.swf',
	    server: base + '/common/file/News',
	    fileSingleSizeLimit :  20 * 1024 * 1024,    // 5 M
	    fileVal: "upfile",
	    pick: '#fileupload',
	    duplicate:true,	    
	});
	uploader.on( 'uploadSuccess', function( file, response ) {
		var  filename=file.name;
		        	window.location.href=base+"/permgr/personinfo/list?filename="+filename;
	});	
	uploader.on( 'uploadError', function( file ) {
	    alert('上传出错');
	});
	uploader.on( 'error', function( type ) {
	    if ("F_EXCEED_SIZE"== type){    
	       alert('文件大小不能超过20M！');
	       return;
	    }
	    if ("Q_TYPE_DENIED"== type){
	       alert('文件类型不正确！');
	       return;
	    }
	    
	});
}
