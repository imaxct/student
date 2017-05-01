<%--
  Created by IntelliJ IDEA.
  User: imaxct
  Date: 17-4-30
  Time: 下午6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/student/static/css/jquery.fileupload.css">
<p class="alert alert-info">上传文件类型只能是xls和xlsx</p>
<p class="alert alert-danger">此操作会清除所有用户信息和选课信息!!!</p>
<div id="progress" class="progress">
    <div class="progress-bar progress-bar-success"></div>
</div>
<br>
<br>
<span class="btn btn-success fileinput-button">
    <i class="glyphicon glyphicon-plus"></i>
    <span>添加文件</span>
    <input id="fileupload" type="file" name="file">
</span>
<div id="files" class="files"></div>

<script src="/student/static/js/jquery.ui.widget.js"></script>
<!-- The Load Image plugin is included for the preview images and image resizing functionality -->
<script src="/student/static/js/load-image.all.min.js"></script>
<!-- The Canvas to Blob plugin is included for image resizing functionality -->
<script src="/student/static/js/canvas-to-blob.min.js"></script>
<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
<script src="/student/static/js/jquery.iframe-transport.js"></script>
<!-- The basic File Upload plugin -->
<script src="/student/static/js/jquery.fileupload.js"></script>
<!-- The File Upload processing plugin -->
<script src="/student/static/js/jquery.fileupload-process.js"></script>
<!--
<script src="/student/static/js/jquery.fileupload-image.js"></script>
<script src="/student/static/js/jquery.fileupload-audio.js"></script>
<script src="/student/static/js/jquery.fileupload-video.js"></script>
-->
<!-- The File Upload validation plugin -->
<script src="/student/static/js/jquery.fileupload-validate.js"></script>
<script>
    $(function () {
        'use strict';
        // Change this to the location of your server-side upload handler:
        var url = 'upload',
            uploadButton = $('<button/>')
                .addClass('btn btn-primary')
                .prop('disabled', true)
                .text('Processing...')
                .on('click', function () {
                    var $this = $(this),
                        data = $this.data();
                    $this
                        .off('click')
                        .text('Abort')
                        .on('click', function () {
                            $this.remove();
                            data.abort();
                        });
                    data.submit().always(function () {
                        $this.remove();
                    });
                });
        $('#fileupload').fileupload({
            url: url,
            dataType: 'json',
            autoUpload: false,
            acceptFileTypes: /(\.|\/)(xls|xlsx)$/i,
            maxFileSize: 999000000,
            // Enable image resizing, except for Android and Opera,
            // which actually support image resizing, but fail to
            // send Blob objects via XHR requests:
            disableImageResize: /Android(?!.*Chrome)|Opera/
                .test(window.navigator.userAgent),
            previewMaxWidth: 100,
            previewMaxHeight: 100,
            previewCrop: true
        }).on('fileuploadadd', function (e, data) {
            data.context = $('<div/>').appendTo('#files');
            $.each(data.files, function (index, file) {
                var node = $('<p/>')
                    .append($('<span/>').text(file.name));
                if (!index) {
                    node
                        .append('<br>')
                        .append(uploadButton.clone(true).data(data));
                }
                node.appendTo(data.context);
            });
        }).on('fileuploadprocessalways', function (e, data) {
            var index = data.index,
                file = data.files[index],
                node = $(data.context.children()[index]);
            if (file.preview) {
                node
                    .prepend('<br>')
                    .prepend(file.preview);
            }
            if (file.error) {
                node
                    .append('<br>')
                    .append($('<span class="text-danger"/>').text(file.error));
            }
            if (index + 1 === data.files.length) {
                data.context.find('button')
                    .text('上传')
                    .prop('disabled', !!data.files.error);
            }
        }).on('fileuploadprogressall', function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .progress-bar').css(
                'width',
                progress + '%'
            );
        }).on('fileuploaddone', function (e, data) {
            $.each(data.result.files, function (index, file) {
                if (file.name){
                    $(data.context.children()[index])
                        .append('<p>上传成功</p>')
                        .append('<button class="btn btn-primary" id="selectHead">下一步</button>');
                }
                if (file.url) {
                    var link = $('<a>')
                        .attr('target', '_blank')
                        .prop('href', file.url);
                    $(data.context.children()[index])
                        .wrap(link);
                } else if (file.error) {
                    var error = $('<span class="text-danger"/>').text(file.error);
                    $(data.context.children()[index])
                        .append('<br>')
                        .append(error);
                }
            });
        }).on('fileuploadfail', function (e, data) {
            $.each(data.files, function (index) {
                var error = $('<span class="text-danger"/>').text('文件上传失败.');
                $(data.context.children()[index])
                    .append('<br>')
                    .append(error);
            });
        }).prop('disabled', !$.support.fileInput)
            .parent().addClass($.support.fileInput ? undefined : 'disabled');
    });
</script>
<script>
    $(document).on('click', '#selectHead', function () {
        $('#frame').load('/student/A/selectHead');
    });
</script>