/**
 * Created by SK on 2018/6/12.
 */

layui.use(['layer','lmfEvent','lmfTable'], function () {
    var $ = layui.$;
    var layer = layui.layer;
    var clickEvent = layui.lmfEvent;
    var lmfTable = layui.lmfTable;


    clickEvent('list-data-permission', function () {
        var role_uid = $(this).attr("value");
        var tableConfig = {
            elem: '#user-view-table',
            url: '/businessProgram/listProgramByUserRole',
            tableFilter: 'user-view-table',
            searchFilter: 'user-view-search',
            height: 400,
            where: {
                sort_order: 'desc',
                sort_key: 'created_at',
                user_uid: userInfo.userUid,
                role_uid: role_uid
            },
            page: true,
            cols: [[
                {
                    field: 'business_code',
                    title: '项目编号'
                },
                {
                    field: 'program_name',
                    title: '项目名称'
                },
                {
                    field: 'company_name',
                    title: '商管公司'
                },
                {
                    field: 'attribution_area',
                    title: '归属区域'
                },
                {
                    field: 'program_type',
                    title: '项目类型'
                },
                {
                    field: 'open_at',
                    title: '开业时间'
                }
            ]]
        };

        layer.open({
            type: 1,
            area: ['800px', '525px'],
            title: ['查看数据权限'],
            move: false,
            resize: false,
            scrollbar: false,
            shadeClose: false,
            shade: [0.3, '#000'],
            content: layui.laytpl($('#tplPermission').html()).render({role_uid:role_uid}),
            success: function () {
                layui.use(['form'], function () {
                    var dialogForm = layui.form;
                    dialogForm.render();

                    lmfTable(tableConfig, {});
                    // $('#role-uid').attr("value", roleUid);
                });
            }
        });

    });

});