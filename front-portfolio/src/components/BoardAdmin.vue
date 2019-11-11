<template>
    <div id="admin-board">

        <div id="menu" class="text-center">
            <b-button id="identity_button" @click="afficheur = 'IdentityBoard'"> IdentityllBoard</b-button>
            <b-button id="skills_button" @click="afficheur = 'SkillBoard'"> SkillBoard</b-button>
            <b-button id="projekts_button"  @click="afficheur = 'ProjektBoard'"> ProjektBoard</b-button>
        </div>

        <div id="adminboard_intro" class="col-12 text-center" v-if="afficheur === 'AdminBoard'">
            <h1 class="display-4">{{content}}</h1>
            <p> Bienvenu dans l'interface pour modifier le Portfolio.</p>
        </div>
        <div id="identityboard" class="col-12 text-center" v-if="afficheur === 'IdentityBoard'">
            <h1 class="display-4">IdentityBoard</h1>
        </div>
        <div id="skillboard" class="col-12 text-center" v-if="afficheur === 'SkillBoard'">
            <h1 class="display-4">SkillBoard</h1>

            <div id="newSkill">
            <form>
                <input placeholder="Titre"/>
                <input placeholder="Description"/>
                <button class="btn btn-secondary" type="submit">Créer un Skill</button>
            </form>
            </div>

            <div id="skillrow" class="row">
            <div id="myskills" class="col-4 text-center" v-for="skill in skills" :key="skill.id">
                <div class="card">
                    <div class="card-header">
                        <p>{{skill.titre}}</p>
                        <input v-model="Titre" placeholder="nouveau titre"/>
                    </div>
                    <div class="card-body">
                        <p class="card-text">{{skill.description}}</p>
                        <input v-model="Description" placeholder="nouvelle description"/>
                    </div>
                    <div class="card-footer">
                        <div class="text-center">
                        <button class="btn btn-secondary">Modifier ce Skill</button>
                        <button class="btn btn-secondary">Supprimer ce Skill</button>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </div>
        <div id="projektboard" class="col-12 text-center" v-if="afficheur === 'ProjektBoard'">
            <h1 class="display-4">ProjektBoard</h1>
        </div>
    </div>
</template>

<script>
    import UserService from '../services/user.service'

    export default {
        name: "admin",
        data() {
            return {
                afficheur: 'AdminBoard',
                skills: [],
                Titre: '',
                Description: '',
                content: ''
            }
        },
        mounted() {
            UserService.getAdminBoard().then(
                response => {
                    this.content = response.data;
                },
                error => {
                    this.content = error.response.data.message;
                }
            ),
                UserService.getSkills().then(
                    response => {
                        this.skills = response.data;
                    },
                    error => {
                        this.skills = error.response.data.message;
                    }
                )
        }
    }
</script>

<style scoped>
#adminboard_intro{
   margin-top: 5%;
}
#identityboard{
    margin-top: 5%;
}
#skillboard{
    margin-top: 5%;
}
#projektboard{
    margin-top: 5%;
}
#skillrow{
    margin-top: 5%;
}

</style>