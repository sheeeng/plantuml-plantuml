package nonreg.simple;

import nonreg.BasicTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/*

Test diagram MUST be put between triple quotes

"""
@startuml
!pragma teoz true

group #ffa Group 1
    Participant_A -> Participant_B
    activate Participant_A
    Participant_A <- Participant_B
    deactivate Participant_A
end

group #ffa Group 2
    Participant_A -> Participant_B++
    Participant_A <- Participant_B--
end

group #ffa Group 3
    Participant_A -> Participant_B++
    activate Participant_A
    Participant_A <- Participant_B--
    deactivate Participant_A
end

group #ffa Group 3b
    Participant_A -> Participant_B++
    activate Participant_A
        Participant_A -> Participant_B++
                Participant_A -> Participant_B++
                        Participant_A -> Participant_B++
                        Participant_A <- Participant_B--
                Participant_A <- Participant_B--
        Participant_A <- Participant_B--
    Participant_A <- Participant_B--
    deactivate Participant_A
end

group #ffa Group 3b2
    Participant_A -> Participant_B++
    activate Participant_A
    Participant_A <- Participant_B
    Participant_A -> Participant_B !!
    deactivate Participant_A
end

group #ffa Group 3b3
    Participant_A -> Participant_B++
    activate Participant_A
    Participant_A <- Participant_B !!
    deactivate Participant_B
end

group #ffa Group 3c
    Participant_A -> Participant_B++
    activate Participant_A
        Participant_B -> Participant_A++
                Participant_B -> Participant_A++
                                Participant_B -> Participant_A++
                                Participant_B <- Participant_A--
                Participant_B <- Participant_A--
        Participant_B <- Participant_A--
    Participant_A <- Participant_B--
    deactivate Participant_A
end


group #ffa Group 4
    Participant_A -> Participant_B
    Participant_A <- Participant_B
end
@enduml
"""

 */
public class TeozTimelineIssues_0009_Test extends BasicTest {

	@Test
	void testIssue1789() throws IOException {
		checkImage("(2 participants)");
	}

}
