package com.kikuu.api.kikuu_user.service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kikuu.api.IGenericService;
import com.kikuu.api.kikuu_user.collection.KikuuUserDocument;
import com.kikuu.api.kikuu_user.repository.KikuuRepository;
import com.kikuu.api.utils.security.roles.KikuuRole;
import com.mongodb.MongoException;

@Service
public class KikuuService implements IGenericService<KikuuUserDocument, Integer> {

	@Autowired
	KikuuRepository kikuurepo;
	@Autowired
	PasswordEncoder encoder;
	private final Logger  logger= LoggerFactory.getLogger(KikuuService.class);

	@Override
	public KikuuUserDocument save(KikuuUserDocument kikuu) throws MongoException {
		try {
			//Set user roles
			//save user
			kikuu.setRoles(this.rolesManager(KikuuRole.USER_ROLES));
			kikuu.setPassword(encoder.encode(kikuu.getPassword()));
			KikuuUserDocument sUser = kikuurepo.save(kikuu);
			sUser.setPassword(null);
			logger.debug("new user saved %s @ %s",kikuu.getUsername(), new Date(System.currentTimeMillis()));
			return sUser;
		} catch (Exception e) {
			logger.debug("Error! for %s @ %s",kikuu.getUsername(), new Date(System.currentTimeMillis()));
			throw new MongoException(e.getMessage());
		}
	}

	@Override
	public KikuuUserDocument update(KikuuUserDocument c) throws MongoException {
		return null;
	}

	@Override
	public Integer delete(KikuuUserDocument kikuu) throws MongoException {
		logger.debug("user deleted %s @ %s",kikuu.getUsername(), new Date(System.currentTimeMillis()));
		kikuurepo.delete(kikuu);
		return 1;
	}

	@Override
	public Integer deleteAll(List<KikuuUserDocument> tcs) throws MongoException {
		return null;
	}

	@Override
	public List<KikuuUserDocument> getByPagination(Integer limit, Integer offset) {
		return null;
	}

	@Override
	public List<KikuuUserDocument> getAll() {
		return kikuurepo.findAll();
	}

	@Override
	public KikuuUserDocument get(KikuuUserDocument c) {
		return null;
	}

	public KikuuUserDocument login(String username) {
		return kikuurepo.findByUsername(username);
	}

	public void deleteAll() {
		kikuurepo.deleteAll();
	}

	/**
	 * rolesManager
	 * @param String []roles
	 * @return Set<String> 
	 */
	public Set<String> rolesManager(final String[] roles) {
		Set<String> setRoles = new HashSet<>();
		try {
			if (roles.length < 1){
				logger.debug("Error! roles value provided is empty. @ %s", new Date(System.currentTimeMillis()));
                return null;
			}
			//Add to set	
			Arrays.asList(roles).stream().forEach(x -> setRoles.add(x));
            logger.debug("roles value provided %s @ %s", roles,new Date(System.currentTimeMillis()));
		} catch (Exception e) {
            logger.error("Error! roles value provided is empty. @ %s", new Date(System.currentTimeMillis()));
		}
		return setRoles;
	}
}
