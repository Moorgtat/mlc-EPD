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
            <section>
                <div id="adminboard_intro" class="col-12 text-center" v-if="afficheur === 'AdminBoard'">
                    <h1 class="display-4">{{content}}</h1>
                    <p> Bienvenu dans l'interface pour modifier le Portfolio.</p>
                </div>

                <div id="identityboard" class="col-12 text-center" v-if="afficheur === 'IdentityBoard'">
                    <h1 class="display-4">IdentityBoard</h1>
                    <div v-for="identity in myIdentity" :key="identity.id">
                      <form>
                          <div>
                          <label>Nom:</label>
                          <input v-model="identity.name" :placeholder="identity.name"/>
                          </div>
                          <div>
                          <label>Poste:</label>
                          <input v-model="identity.poste" :placeholder="identity.poste"/>
                          </div>
                          <div>
                          <label>Presentation:</label>
                          <input v-model="identity.presentation" :placeholder="identity.presentation"/>
                          </div>
                          <div>
                          <label>Mail:</label>
                          <input v-model="identity.mail" :placeholder="identity.mail"/>
                          </div>
                          <div>
                          <label>Github:</label>
                          <input v-model="identity.git" :placeholder="identity.git"/>
                          </div>
                          <div>
                          <label>Twitter:</label>
                          <input v-model="identity.twitter" :placeholder="identity.twitter"/>
                          </div>
                          <div>
                              <b-button type="submit" class="is-dark" @click.prevent="updtIdentity(identity)">
                                  Modifier
                              </b-button>
                          </div>
                      </form>
                    </div>
                </div>

                <div id="skillboard" class="col-12 text-center" v-if="afficheur === 'SkillBoard'">
                    <h1 class="display-4">SkillBoard</h1>
                    <div class="addSkill">
                        <form>
                            <input type="text" v-model="skill.titre" placeholder="titre"/>
                            <input type="text" v-model="skill.description" placeholder="description"/>
                            <b-button type="submit" class="is-dark" @click.prevent="addSkill(skill)" > AddSkill </b-button>
                        </form>
                    </div>
                        <div id="les-skills">
                            <div v-for="skill in allSkills" :key="skill.id">
                                <div class="container" id="skill-container">
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
                </div>

                <div id="projektboard" class="col-12 text-center" v-if="afficheur === 'ProjektBoard'">
                    <h1 class="display-4">ProjektBoard</h1>
                    <div class="addProjekt">
                        <form>
                            <input type="text" v-model="projekt.titre" placeholder="titre"/>
                            <input type="text" v-model="projekt.description" placeholder="description"/>
                            <input type="text" v-model="projekt.github" placeholder="github"/>
                            <b-button type="submit" class="is-dark" @click.prevent="addProjekt(projekt)" > AddProjekt </b-button>
                        </form>
                    </div>
                    <div id="les-projekts">
                        <div v-for="projekt in allProjekts" :key="projekt.id">
                            <div class="container" id="projekt-container">
                                <form>
                                    <div>
                                        <label>Titre:</label>
                                        <input v-model="projekt.titre" :placeholder="projekt.titre"/>
                                    </div>
                                    <div>
                                    <label>Description:</label>
                                    <input v-model="projekt.description" :placeholder="projekt.description"/>
                                    </div>
                                    <div>
                                        <label>Github:</label>
                                        <input v-model="projekt.github" :placeholder="projekt.github"/>
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
                    description: ''
                },
                projekts: [],
                projekt: {
                  id: '',
                  titre: '',
                  description: '',
                  github: ''
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
    #adminboard_intro {
        margin-top: 3%;
    }

    #identityboard {
        margin-top: 3%;
    }

    #skillboard {
        margin-top: 3%;
    }

    #projektboard {
        margin-top: 3%;
    }

    #skill-container {
        border-width: 1px;
        border-style: groove;
        border-color: black;
        margin-top: 5px;
        padding: 3px;
    }

    #les-skills {
        margin-bottom: 160px;
    }

    input {
        width: 30%;
    }

    form {
        margin-top: 25px;
    }

    .scroller {
        margin: 0;
        height: 100vh;
        overflow-y: scroll;
        scroll-snap-type: y;
    }
</style>