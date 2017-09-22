import com.Interest;
import com.User;
import com.UserRepository;
import com.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.*;


public class UserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private User user;

    @Mock
    private List<User> userList;

    @Mock
    private UserService userService;

    @Mock
    private ArrayList<String> follow;

    @Mock
    ArrayList<ArrayList<Object>> ListFol;

    @Spy
    private UserService usServ;



    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        userService =new UserService();
        userService.setUserRepository(userRepository);
    }

    @Test
    public void checkUser() {

        User u = mock(User.class);
        Interest in = mock(Interest.class);

        when(in.getId()).thenReturn((long) 1);
        assertEquals(in.getId(), 1);

        when(in.getInterest()).thenReturn("type1");
        assertEquals(in.getInterest(), "type1");

        System.out.println(in);


        when(u.getId()).thenReturn((long) 43);
        assertEquals((long) u.getId(), 43);

        when(u.getUserName()).thenReturn("vini");
        assertEquals(u.getUserName(), "vini");

        when(u.getFirst_name()).thenReturn("vini");
        assertEquals(u.getFirst_name(), "vini");

        when((u.getLast_name())).thenReturn("maheshwari");
        assertEquals(u.getLast_name(), "maheshwari");

        when(u.getEmail()).thenReturn("vinimaheshwari02@gmail.com");
        assertEquals(u.getEmail(), "vinimaheshwari02@gmail.com");

        when(u.getPassword()).thenReturn("12345Z");
        assertEquals(u.getPassword(), "12345Z");

        u.getInterests();
        verify(u).getInterests();

        u.getFollowing();
        verify(u).getFollowing();




    }
    @Test
    public void checkUserRepository() throws Exception{

when(userRepository.findByUserName("vini")).thenReturn(user);
User u1=userService.findByUserNam("vini");
assertThat(u1,is(equalTo(user)));

when(userRepository.findFollowing("vini")).thenReturn(userList);
List<User> userList1=userService.findFollowing("vini");
assertThat(userList1,is(equalTo(userList1)));

when(userRepository.getUserother("vini")).thenReturn(userList);
List<User> userList2=userService.getUserother1("vini");
assertThat(userList2,is(equalTo(userList)));











    }

    @Test(expected=NullPointerException.class)
    public void shouldthrowNullPointer_whengetProductIdiscalled() throws Exception{

    }

}

