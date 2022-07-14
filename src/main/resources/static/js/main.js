console.log("main.js 연동 완료!")
function deletePost(id){
    $.ajax({
        type: "DELETE",
        url: `/posts/${id}`,
        contentType: "application/json",
        data: {},
        success: function (response) {
            if(response == 0){
                alert('삭제 실패!');
                return;
            } else {
                alert('포스트 삭제에 성공하였습니다.');
                window.location.replace("/posts");
            }
        }
    })
}

function editPost(id){
    showEdits(id);
    let contents = $(`#${id}-contents`).text().trim();
    $(`#${id}-textarea`).val(contents);
}

function showEdits(id) {
    $(`#${id}-editarea`).show();
    $(`#${id}-submit`).show();
    $(`#${id}-delete`).show();
    $(`#${id}-inputPassword`).show();

    $(`#${id}-contents`).hide();
    $(`#${id}-edit`).hide();
}

function submitEdit(id) {
    let title =  $(`#${id}-title`).val().trim();
    let contents = $(`#${id}-textarea`).val().trim();
    if (isValidContents(contents) === false) {
        return;
    }
    let data = {'contents': contents, 'title':title};

    $.ajax({
        type: "PUT",
        url: `/posts/${id}`,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            if(response == 0){
                alert('수정 실패');
                return;
            } else {
                alert('수정 성공!');
                window.location.reload();
            }
        }
    });
}

function isValidContents(contents) {
    if (contents === '') {
        alert('내용을 입력해주세요');
        return false;
    }
    if (contents.trim().length > 140) {
        alert('공백 포함 140자 이하로 입력해주세요');
        return false;
    }
    return true;
}