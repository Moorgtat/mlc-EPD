<template>
    <div id="admin-board">
        <article class="scroller">

            <section>
                <div id="menu" class="text-center">
                    <b-button id="identity_button" @click="afficheur = 'IdentityBoard', getIdentity()"> Mon identité</b-button>
                    <b-button id="skills_button" @click="afficheur = 'SkillBoard', getSkills()"> Mes compétences</b-button>
                    <b-button id="projekts_button" @click="afficheur = 'ProjektBoard', getProjekts()"> Mes Projets</b-button>
                </div>
            </section>

            <div id="adminboard_intro" class="col-12 text-center" v-if="afficheur === 'AdminBoard'">
                <h1 class="display-4">{{content}}</h1>
                <p> Bienvenu dans l'interface pour modifier le Portfolio.</p>
            </div>

            <section id="admin-container">
                <div id="identity-container" v-if="afficheur === 'IdentityBoard'">
                    <div id="identity-titre"><h1 class="is-size-2">IdentityBoard</h1></div>
                    <div>
                    <form id="identity-form" v-for="identity in myIdentity" :key="identity.id">
                          <div class="form-group">
                          <label>Nom:</label>
                          <input v-model="identity.name" class="form-control" :placeholder="identity.name"/>
                          </div>
                          <div class="form-group">
                          <label>Poste:</label>
                          <input v-model="identity.poste" class="form-control" :placeholder="identity.poste"/>
                          </div>
                          <div class="form-group">
                          <label>Presentation:</label>
                              <textarea class="form-control" rows="6" v-model="identity.presentation"
                                        :placeholder="identity.presentation"></textarea>
                          </div>
                          <div class="form-group">
                          <label>Mail:</label>
                          <input v-model="identity.mail" class="form-control" :placeholder="identity.mail"/>
                          </div>
                          <div class="form-group">
                          <label>Github:</label>
                          <input v-model="identity.git" class="form-control" :placeholder="identity.git"/>
                          </div>
                          <div class="form-group">
                          <label>Twitter:</label>
                          <input v-model="identity.twitter" class="form-control" :placeholder="identity.twitter"/>
                          </div>
                          <div>
                              <b-button type="submit" class="is-dark" @click.prevent="updtIdentity(identity)" expanded>
                                  Modifier
                              </b-button>
                          </div>
                    </form>
                    </div>
                </div>

                <div id="skill-container" v-if="afficheur === 'SkillBoard'">
                    <h1 class="display-4">SkillBoard</h1>
                    <div id="addSkill">
                        <form>
                            <input type="text" v-model="skill.titre" placeholder="titre"/>
                            <input type="text" v-model="skill.description" placeholder="description"/>
                            <input type="text" v-model="skill.type" placeholder="type"/>
                            <input type="text" v-model="skill.logo" placeholder="logo"/>
                            <b-button type="submit" class="is-dark" @click.prevent="addSkill(skill)" > AddSkill </b-button>
                        </form>
                    </div>
                        <div id="les-skills">
                            <div id="skill-forms" v-for="skill in allSkills" :key="skill.id">
                                    <form>
                                        <div>
                                            <label>Titre:</label>
                                            <input v-model="skill.titre" :placeholder="skill.titre"/>
                                        </div>
                                        <div>
                                            <label>Description:</label>
                                            <input v-model="skill.description" :placeholder="skill.description"/>
                                        </div>
                                        <div>
                                            <label>Type:</label>
                                            <input v-model="skill.type" :placeholder="skill.type"/>
                                        </div>
                                        <div>
                                            <label>Logo:</label>
                                            <input v-model="skill.logo" :placeholder="skill.logo"/>
                                        </div>
                                            <div>
                                                <b-button type="submit" class="is-dark" @click.prevent="updtSkill(skill)">
                                               Modifier
                                                </b-button>
                                                <b-button class="is-dark" @click="deleteSkill(skill.id)">
                                               Supprimer
                                                </b-button>
                                            </div>
                                    </form>
                            </div>
                        </div>
                </div>

                <div id="projektboard" v-if="afficheur === 'ProjektBoard'">
                    <h1 class="display-4">ProjektBoard</h1>
                    <div id="addProjekt">
                        <form>
                            <div class="form-group">
                                <label>Titre:</label>
                                <input type="text" v-model="projekt.titre" placeholder="titre"/>
                            </div>
                            <div class="form-group">
                                <label>Description:</label>
                                <textarea class="form-control" rows="4" v-model="projekt.description"
                                          :placeholder="projekt.description"></textarea>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="projekt.github" placeholder="github"/>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="projekt.slide_1" placeholder="slide 1"/>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="projekt.slide_2" placeholder="slide 2"/>
                            </div>
                            <div class="form-group">
                                <input type="text" v-model="projekt.slide_3" placeholder="slide 3"/>
                            </div>
                            <b-button type="submit" class="is-dark" @click.prevent="addProjekt(projekt)"> AddProjekt
                            </b-button>
                        </form>
                    </div>
                    <div id="les-projekts">
                        <div v-for="projekt in allProjekts" :key="projekt.id">
                            <div class="container" id="projekt-container">
                                <form>
                                    <div class="form-group">
                                        <label>Titre:</label>
                                        <input type="text" v-model="projekt.titre" placeholder="titre"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Description:</label>
                                        <textarea class="form-control" rows="4" v-model="projekt.description"
                                                  :placeholder="projekt.description"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" v-model="projekt.github" placeholder="github"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" v-model="projekt.slide_1" placeholder="slide 1"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" v-model="projekt.slide_2" placeholder="slide 2"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" v-model="projekt.slide_3" placeholder="slide 3"/>
                                    </div>
                                    <div>
                                        <b-button type="submit" class="is-dark" @click.prevent="updtProjekt(projekt)">
                                            Modifier
                                        </b-button>
                                        <b-button class="is-dark" @click="deleteProjekt(projekt.id)">
                                            Supprimer
                                        </b-button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
        </article>
    </div>
</template>

<script>
    import UserService from '../services/user.service'
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name: "admin",
        data() {
            return {
                afficheur: 'AdminBoard',
                identities: [],
                identity: {
                    id: '',
                    name: '',
                    poste: '',
                    presentation: '',
                    mail: '',
                    git: '',
                    twitter: ''
                },
                skills: [],
                skill: {
                    id: '',
                    titre: '',
                    description: '',
                    type: '',
                    logo: ''
                },
                projekts: [],
                projekt: {
                  id: '',
                  titre: '',
                  description: '',
                  github: '',
                  slide_1: '',
                  slide_2: '',
                  slide_3: ''
                },
                content: ''
            }
        },
        methods: {
            ...mapActions(['fetchSkills']),
            ...mapActions(['addSkill']),
            ...mapActions(['deleteSkill']),
            ...mapActions(['updtSkill']),
            ...mapActions(['fetchProjekts']),
            ...mapActions(['addProjekt']),
            ...mapActions(['deleteProjekt']),
            ...mapActions(['updtProjekt']),
            ...mapActions(['fetchIdentity']),
            ...mapActions(['updtIdentity']),
            getSkills() {
                this.fetchSkills();
            },
            getIdentity() {
                this.fetchIdentity();
            },
            getProjekts(){
                this.fetchProjekts();
            }
        },
        computed: {
        ...mapGetters(['allSkills']),
        ...mapGetters(['myIdentity']),
        ...mapGetters(['allProjekts'])
    },
        mounted() {
            UserService.getAdminBoard().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content = error.response.data.message;
                }
            )
        }
    }
</script>

<style scoped>
    /*Général*/
    .scroller {
        margin: 0;
        height: 100vh;
        overflow-y: scroll;
        scroll-snap-type: y;
    }
    #admin-container{
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    #adminboard_intro {
        margin-top: 3%;
    }

    /*Board Identity*/
    #identity-container{
        height: 90vh;
        width: 800px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin-bottom: 120px;
    }
    #identity-titre{
        font-family: "Calibri Light";
        padding-bottom: 10px;
    }
    #identity-form{
        width: 500px;
    }

    /*skills*/
    #skill-container {
        margin-bottom: 120px;
    }
    #les-skills {
        background-color: white;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: space-evenly;
        align-items: center;
    }
    #skill-forms{
        width: 400px;
    }
    @media (max-width: 817px) {
         #skill-container{
             height: 1300px;
    }
    }
    /*projekts*/
    #projektboard {
        margin-top: 3%;
    }

    #les-projekts{
        margin-bottom: 160px;
    }

</style>