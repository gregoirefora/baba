/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 *
 */

package no.rutebanken.baba.organisation.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import no.rutebanken.baba.BabaTestApp;
import no.rutebanken.baba.organisation.model.CodeSpace;
import no.rutebanken.baba.organisation.model.organisation.Authority;
import no.rutebanken.baba.organisation.model.organisation.Organisation;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.StringWriter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = BabaTestApp.class)
@Transactional
public abstract class BaseIntegrationTest {

	@Autowired
	protected CodeSpaceRepository codeSpaceRepository;

	@Autowired
	protected OrganisationRepository organisationRepository;


	protected Organisation defaultOrganisation;

	protected CodeSpace defaultCodeSpace;

	@Before
	public void setUp() {
		CodeSpace codeSpace = new CodeSpace("nsr", "NSR", "http://www.rutebanken.org/ns/nsr");
		defaultCodeSpace = codeSpaceRepository.saveAndFlush(codeSpace);

		Authority authority = new Authority();
		authority.setCodeSpace(defaultCodeSpace);
		authority.setName("Test Org");
		authority.setPrivateCode("testOrg");
		defaultOrganisation = organisationRepository.saveAndFlush(authority);
	}

}
