package cn.stylefeng.guns.modular;

import cn.stylefeng.guns.core.context.login.LoginContextHolder;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 新增和修改数据时自动填充用户ID
 * @author dam.feng
 */
@Component
public class CurrentUserAuditor implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        Long id = LoginContextHolder.me().getSysLoginUserId();
        return Optional.of(id);
    }
}
