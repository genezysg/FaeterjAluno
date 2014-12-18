package br.com.aluno.faeterj.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.aluno.faeterj.model.entity.Aluno;
import br.com.aluno.faeterj.model.repository.AlunoRepository;

import org.springframework.stereotype.Service;

@Service
public class AlunoRepositoryUserDetailsService implements UserDetailsService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoRepositoryUserDetailsService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String matriculaAluno)
        throws UsernameNotFoundException {
    	Long mat=Long.parseLong(matriculaAluno);
    	Aluno aluno = alunoRepository.findOne(mat);
        if(aluno == null) {
            throw new UsernameNotFoundException("N~ão achou o aluno " + matriculaAluno);
        }
        return new AlunoRepositoryUserDetails(aluno);
    }

    private final static class AlunoRepositoryUserDetails extends Aluno implements UserDetails {

        private AlunoRepositoryUserDetails(Aluno aluno) {
            super(aluno);
           
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        private static final long serialVersionUID = 5639683223516504866L;
    }
}