package com.amaizing.crudtemplate;

import com.amaizing.crudtemplate.controllers.AchievementController;
import com.amaizing.crudtemplate.models.Achievement;
import com.amaizing.crudtemplate.repositories.AchievementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
public class AchievementsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AchievementRepository repository;

    @InjectMocks
    private AchievementController controller;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllAchievements() throws Exception {
        List<Achievement> achievements = new ArrayList<>();
        achievements.add(new Achievement(1L, "Achievement 1", "Description 1", "Game 1"));
        achievements.add(new Achievement(2L, "Achievement 2", "Description 2", "Game 2"));

        when(repository.findAllByOrderByIdAsc()).thenReturn(achievements);

        mockMvc.perform(get("/achievements"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Achievement 1"))
                .andExpect(jsonPath("$[1].name").value("Achievement 2"));

        verify(repository, times(1)).findAllByOrderByIdAsc();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testCreateAchievement() throws Exception {
        Achievement achievement = new Achievement(1L, "New Achievement", "New Description", "New Game");

        when(repository.save(any(Achievement.class))).thenReturn(achievement);

        mockMvc.perform(post("/achievements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"New Achievement\", \"description\": \"New Description\", \"gameName\": \"New Game\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("New Achievement"))
                .andExpect(jsonPath("$.description").value("New Description"))
                .andExpect(jsonPath("$.gameName").value("New Game"));

        verify(repository, times(1)).save(any(Achievement.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUpdateAchievement() throws Exception {
        Achievement existingAchievement = new Achievement(1L, "Existing Achievement", "Existing Description", "Existing Game");
        Achievement updatedAchievement = new Achievement(1L, "Updated Achievement", "Updated Description", "Updated Game");

        when(repository.findById(1L)).thenReturn(Optional.of(existingAchievement));
        when(repository.save(any(Achievement.class))).thenReturn(updatedAchievement);

        mockMvc.perform(post("/achievements/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"Updated Achievement\", \"description\": \"Updated Description\", \"gameName\": \"Updated Game\" }"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Updated Achievement"))
                .andExpect(jsonPath("$.description").value("Updated Description"))
                .andExpect(jsonPath("$.gameName").value("Updated Game"));

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(any(Achievement.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testDeleteAchievement() throws Exception {
        mockMvc.perform(delete("/achievements/1"))
                .andExpect(status().isOk());

        verify(repository, times(1)).deleteById(1L);
        verifyNoMoreInteractions(repository);
    }
}