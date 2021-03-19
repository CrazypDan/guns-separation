
package cn.stylefeng.guns.modular.module1.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.log.Log;
import cn.stylefeng.guns.core.exception.ServiceException;
import cn.stylefeng.guns.core.exception.enums.ServerExceptionEnum;
import cn.stylefeng.guns.modular.module1.entity.Demo;
import cn.stylefeng.guns.modular.module1.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 一个service实现
 *
 * @author stylefeng
 * @date 2020/4/9 18:11
 */
@Service
public class DemoService {

    private static final Log log = Log.get();

    @Autowired
    private DemoRepository demoRepository;

    public Page<Demo> findPage(Demo demo, Pageable pageable){
        Example<Demo> example = Example.of(demo);
        return demoRepository.findAll(example, pageable);
    }

    public Demo findById(Long id){
        return demoRepository.findById(id).orElse(null);
    }

    public List<Demo> findByTitle(String title){
        return demoRepository.findAllByTitleLike(title);
    }

    public void add(Demo demo){
        demo.setId(null);
        demoRepository.save(demo);
    }

    public void edit(Demo demo){
        Optional<Demo> exist = demoRepository.findById(demo.getId());
        if(!exist.isPresent()){
            log.warn("不存在的Demo,id:{}",demo.getId());
            throw new ServiceException(ServerExceptionEnum.DATA_NOT_EXIST);
        }
        Demo updater = exist.get();
        BeanUtil.copyProperties(demo, updater, CopyOptions.create().ignoreNullValue());
        demoRepository.save(updater);
    }

    public void delete(Long id){
        demoRepository.deleteById(id);
    }
}
