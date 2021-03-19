
package cn.stylefeng.guns.modular.module1.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.annotation.Add;
import cn.stylefeng.guns.annotation.Edit;
import cn.stylefeng.guns.core.pojo.page.PageResult;
import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.modular.module1.dto.DemoDTO;
import cn.stylefeng.guns.modular.module1.dto.DemoPageDTO;
import cn.stylefeng.guns.modular.module1.entity.Demo;
import cn.stylefeng.guns.modular.module1.service.DemoService;
import cn.stylefeng.guns.modular.module1.vo.DemoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/**
 * 案例接口
 *
 * @author stylefeng
 * @date 2020/4/9 18:09
 */
@Api(tags = "案例")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;



    @ApiOperation(value = "分页查询案例")
    @PostMapping("/page")
    public ResponseData<PageResult<DemoVO>> findPage(@RequestBody DemoPageDTO dto) {
        Page<Demo> page = demoService.findPage(BeanUtil.toBean(dto, Demo.class), PageRequest.of(dto.getPageNo(), dto.getPageSize()));
        return ResponseData.success(PageResult.covert(page, DemoVO.class));
    }

    @ApiOperation(value = "根据id查询案例")
    @GetMapping("/info/{id}")
    public ResponseData<DemoVO> findById(@PathVariable("id") @NotNull Long id) {
        Demo demo = demoService.findById(id);
        DemoVO demoVO = BeanUtil.toBean(demo, DemoVO.class);
        return ResponseData.success(demoVO);
    }

    @ApiOperation(value = "新增案例")
    @PostMapping("/info")
    public ResponseData<String> add(@RequestBody @Validated(Add.class) DemoDTO dto) {
        Demo demo = BeanUtil.toBean(dto, Demo.class);
        demoService.add(demo);
        return ResponseData.success();
    }

    @ApiOperation(value = "修改案例")
    @PutMapping("/info")
    public ResponseData<String> edit(@RequestBody @Validated(Edit.class) DemoDTO dto) {
        Demo demo = BeanUtil.toBean(dto, Demo.class);
        demoService.edit(demo);
        return ResponseData.success();
    }

    @ApiOperation(value = "删除案例")
    @DeleteMapping("/info/{id}")
    public ResponseData<String> delete(@PathVariable("id") @NotNull Long id) {
        demoService.delete(id);
        return ResponseData.success();
    }

}
