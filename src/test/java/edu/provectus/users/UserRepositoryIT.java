/*
 * Copyright 2016 EuregJUG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.provectus.users;

import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

import edu.provectus.users.model.User;
import edu.provectus.users.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Michael J. Simons, 2016-08-25
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("it")
public class UserRepositoryIT {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() {

        final String NAME = "Aleksey Ekimtsov";
        final Date BIRTH_DATE = new Calendar.Builder().setDate(1986, 10, 17).build().getTime();
        final String EMAIL = "aleksey.ekimtsov@gmal.com";

        User user = new User();
        user.setName(NAME);
        user.setBirthDate(BIRTH_DATE);
        user.setEmail(EMAIL);

        userRepository.save(user);

        List<User> all = userRepository.findAll();

        Assert.assertTrue(all.size() == 1);
        Assert.assertTrue(all.get(0).getName().equals(NAME));
        Assert.assertTrue(all.get(0).getEmail().equals(EMAIL));
        Assert.assertTrue(all.get(0).getBirthDate().equals(BIRTH_DATE));

////        // data-id.sql creates on registration with id "1"
////        final EventEntity event = this.userRepository.findOne(1).get();
////        final RegistrationEntity savedRegistration = this.registrationRepository.save(new RegistrationEntity(event, "foo@bar.baz", "idGeneratorsShouldWorkWithPostgreSQLAsExpected", null, true));
//        Assert.assertThat(savedRegistration.getId(), is(2));
    }
}