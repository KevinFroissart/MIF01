package fr.univ_lyon1.info.m1.cv_search.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ApplicantBuilder {

    private File file;

    public ApplicantBuilder(File f) {
        this.file = f;
    }

    public ApplicantBuilder(String filename) {
        this.file = new File(filename);
    }

    /**
     * Build the applicant from the Yaml file provided to the constructor.
     */
    public Applicant build() {
        Applicant applicant = new Applicant();
        Yaml yaml = new Yaml();
        Map<String, Object> map;
        try {
            map = yaml.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Error(e);
        }

        applicant.setName((String) map.get("name"));

        // Cast may fail if the Yaml is incorrect. Ideally we should provide
        // clean error messages.
        @SuppressWarnings("unchecked")
        Map<String, Integer> skills = (Map<String, Integer>) map.get("skills");

        @SuppressWarnings("unchecked")
        Map<String, Map<String, Object>> experiences = (Map<String, Map<String, Object>>) map.get("experience");

        for(String company : experiences.keySet()) {
            Experience experience = new Experience();
            experience.setCompany(company);
            experience.setStart(Integer.parseInt(experiences.get(company).get("start").toString()));
            experience.setEnd(Integer.parseInt(experiences.get(company).get("end").toString()));
            experience.setKeywords(new ArrayList<>(Arrays.asList(
                    experiences
                    .get(company)
                    .get("keywords")
                    .toString()
                    .replaceAll("[\\[\\]]", "")
                    .split(", ")
            )));
            applicant.addExperience(experience);
        }

        for (String skill : skills.keySet()) {
            Integer value = skills.get(skill);
            applicant.setSkill(skill, value);
        }

        return applicant;
    }
}
