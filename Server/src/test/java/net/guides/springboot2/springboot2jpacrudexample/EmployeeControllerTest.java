package net.guides.springboot2.springboot2jpacrudexample;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository mockRepository;

    /*
        {
            "timestamp":"2021-07-20T11:50:58.743+00:00",
            "status":400,
            "errors":["First Name cannot be empty","Date is not Valid.","Last Name cannot be empty","Email is not allowed."]
        }
     */
    @Test
    public void save_emptyAuthor_emptyPrice_400() throws Exception {

        String employeeInJson = "{\"name\":\"\",\"lastName\":\"\",\"emailId\":\"\",\"dateOfJoining\":\"\"}";

        mockMvc.perform(post("/employees")
                .content(employeeInJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.timestamp", is(notNullValue())))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors", hasSize(4)))
                .andExpect(jsonPath("$.errors", hasItem("Email is not allowed.")))
                .andExpect(jsonPath("$.errors", hasItem("Date is not Valid.")))
                .andExpect(jsonPath("$.errors", hasItem("Last Name cannot be empty")))
                .andExpect(jsonPath("$.errors", hasItem("First Name cannot be empty")));

    }

}
