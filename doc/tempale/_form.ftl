[@spring.showErrors "<br/>"/]
<form action="${webRoot}/{$packagelastname}/{$table.code}/${{$table.code}.id}" method="POST" >
    <table class="table1 table-bordered table-responsive">
        <tbody>
            {$while}
            <tr>
                <td class="bx_left text_right">${message("{$packagelastname}.{$table.code}.{$column.code}")}</td>
                <td class="text_center bx_center">
                <input type="text" id="{$column.code}" name="{$column.code}"
                    value="${{$table.code}.{$column.code}}" class="form-controls1" size="{$column.length}">
                </td>
                <td class="text_left bx_cl_back"><span class="bitian">*</span></td>
            </tr>
            {$whileEnd}
        </tbody>
    </table>

    <input class="button-flat-primary button-large" type="submit" value="${message("form.save")}" />
    <button class="button-flat-primary button-large" onclick="return window.history.back();" >
        ${message("form.cancle")}
    </button>

</form>
