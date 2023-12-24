;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Stage)
(use TargActor)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	Index
	waterTime
	[branch 12]
	[branchDeltaX 12] = [-36 -20 -5 2 22 1 44 -60 -37 23 0 -21]
	[branchDeltaY 12] = [-69 -75 -66 -80 -69 -76 -81 -78 -85 -81 -86 -88]
	[branchLoop 12] = [3 3 3 3 4 4 4 3 3 4 4 3]
	plantThanked
	magicDirt
	whichMsg
	objType
	toldJulanarNumTimes = 1
	[pts1 36] = [0 0 319 0 319 149 97 149 97 142 176 142 192 120 215 101 234 101 235 85 197 82 178 88 155 84 132 85 129 89 86 103 39 107 0 117]
	[pts2 8] = [132 163 182 163 182 171 132 171]
	[pts3 20] = [191 189 200 187 253 187 253 183 238 183 202 172 203 168 231 161 318 161 318 189]
	[thrownObj 25] = [130 118 108 98 86 0 125 115 110 108 86 0 123 116 110 99 97 90 86 0 123 116 97 86 0]
	objCount
)

(procedure (CheckFlags)
	(if
		(and
			(IsFlag 77) ; fWaterDown
			(IsFlag 81) ; fPlantName
			(IsFlag 78) ; fHeroStory
			(IsFlag 76) ; fDirtDown
			(IsFlag 79) ; fDirtStory
			(IsFlag 80) ; fPlantHug
			(not (IsFlag 122)) ; fGotFruit
			(!= (gSpareSound number:) 643)
		)
		(gSpareSound number: 643 loop: 1 priority: 8 play:)
	)
)

(procedure (TellSwitch)
	(switch toldJulanarNumTimes
		(1
			(HighPrint 640 0) ; "You find yourself tongue-tied as you try to tell your story. Perhaps you should try again."
		)
		(2
			(HighPrint 640 1) ; "You discover how poor a speaker you are as you listen to yourself. You couldn't convince anyone of anything."
		)
		(3
			(HighPrint 640 2) ; "You stutter as you start to speak and can't think of anything to say. You just haven't talked enough to gain the skill to convince a tree of anything."
		)
		(4
			(HighPrint 640 3) ; "As you begin to speak, you realize you are just saying whatever comes into your head. You need to stop and think for a moment about what you are going to say and how to say it. Then you might start again."
		)
		(5
			(HighPrint 640 4) ; "Forget it! Come back when you've overcome your speech impediment"
		)
	)
	(if (< toldJulanarNumTimes 5)
		(++ toldJulanarNumTimes)
	)
)

(procedure (GetDown)
	(HighPrint 640 5) ; "Get off your saurus first."
)

(procedure (AddBranches)
	(for ((= Index 0)) (< Index 12) ((++ Index))
		(= [branch Index] (aBranch new:))
		([branch Index]
			cel: 3
			palette: (if gNight 2 else 1)
			ignoreActors:
			x: (+ 164 [branchDeltaX Index])
			y: (+ 169 [branchDeltaY Index])
		)
		(InitAddToPics [branch Index])
	)
)

(procedure (turnToEgo)
	(gMiscSound number: 641 loop: 0 priority: 8 play:)
	(SetFlag 123) ; fTreeTurned
	(CheckFlags)
	(julanar setCycle: End self)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance rm640 of Stage
	(properties
		picture 640
		style 7
		east 665
		south 665
		west 665
		bottomFromX 70
		bottomFromY 220
		bottomToX 110
		rightFromX 330
		rightFromY 160
		rightToX 230
		rightToY 160
		leftFromX -40
		leftFromY 160
		leftToX 50
		leftToY 160
	)

	(method (doit)
		(super doit:)
	)

	(method (cue)
		(super cue:)
		(switch whichMsg
			(1
				(HighPrint 640 6) ; "Trees and plants are notoriously uncommunicative."
			)
			(2
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					((not (IsFlag 77)) ; fWaterDown
						(HighPrint 640 7) ; "No matter how hard you try, you seem unable to communicate with the tree about your good deeds."
					)
					((IsFlag 78) ; fHeroStory
						(HighPrint 640 8) ; "Not again! We've heard it before."
					)
					((TrySkill 13 (* 10 (- 6 toldJulanarNumTimes))) ; communication
						(self setScript: tellOfSelf)
					)
					(else
						(TellSwitch)
					)
				)
			)
			(3
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					((not (IsFlag 76)) ; fDirtDown
						(HighPrint 640 9) ; "No matter how hard you try, you seem unable to communicate with the tree about your heroics."
					)
					((IsFlag 79) ; fDirtStory
						(HighPrint 640 10) ; "Please! Not that story again!!!"
					)
					((TrySkill 13 (* 10 (- 6 toldJulanarNumTimes))) ; communication
						(self setScript: tellOfEarth)
					)
					(else
						(TellSwitch)
					)
				)
			)
			(4
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					(
						(or
							(not (IsFlag 77)) ; fWaterDown
							(not (IsFlag 78)) ; fHeroStory
							(not (IsFlag 76)) ; fDirtDown
							(not (IsFlag 79)) ; fDirtStory
						)
						(HighPrint 640 11) ; "The tree shows no sign of recognition."
					)
					(else
						(HighPrint 640 12) ; "Julanar's leaves rustle lightly at the sound of her name."
						(if (not (IsFlag 81)) ; fPlantName
							(SetFlag 81) ; fPlantName
							(TrySkill 13 100) ; communication
							(if (and (IsFlag 80) (not (IsFlag 122))) ; fPlantHug, fGotFruit
								(CheckFlags)
								(self setScript: fruitFall)
							)
						)
					)
				)
			)
		)
		(= whichMsg 0)
	)

	(method (init)
		(LoadMany rsVIEW 22 47 640 645 646)
		(Load rsSOUND 641)
		(InitFeatures wall wall2)
		(self setRegions: 660) ; desertReg
		(NormalEgo)
		(gEgo init:)
		(= gSpellChecker gAllChecker)
		(= global76 1)
		(gCurRoom addObstacle: poly1 poly2 poly3)
		(super init:)
		(gMiscSound number: 645)
		(if (IsFlag 76) ; fDirtDown
			(InitAddToPics dirt)
		)
		(cond
			((IsFlag 124) ; fTreeBloomed
				(julanar cel: 9 palette: (if gNight 2 else 1) init:)
				(AddBranches)
			)
			((IsFlag 123) ; fTreeTurned
				(julanar cel: 9 palette: (if gNight 2 else 1) init:)
			)
			(else
				(gMiscSound number: 640)
				(julanar cel: 0 palette: (if gNight 2 else 1) init:)
			)
		)
		(gMiscSound loop: 0 priority: 8 play:)
		(poly1 points: @pts1 size: 18)
		(poly2 points: @pts2 size: 4)
		(poly3 points: @pts3 size: 10)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'dismount,(climb,climb,get,get<off,down)[/saurii,roget]')
				(if (== (gEgo onControl: 1) 16)
					(HighPrint 640 13) ; "Your saurus needs more room before you can dismount."
				else
					(event claimed: 0)
				)
			)
			((Said 'ask')
				(Face gEgo julanar 0 self)
				(= whichMsg 1)
			)
			((Said 'get,get>')
				(cond
					((Said '/frond,branch,tree,root')
						(HighPrint 640 14) ; "Take nothing from the tree except what may be offered."
					)
					((Said '/fruit')
						(if (IsFlag 122) ; fGotFruit
							(HighPrint 640 15) ; "The tree has provided the fruit you need."
						else
							(HighPrint 640 16) ; "There is no fruit on the tree."
						)
					)
				)
			)
			((Said 'look,look>')
				(cond
					(
						(or
							(Said
								'search,look,look[<at,around][/room,area][/!*]'
							)
							(Said '/alcove')
						)
						(HighPrint 640 17) ; "You have come to a sandy alcove in the mountains. A strange, human-shaped plant seems to have grown out of the sand here."
					)
					((Said '<at/plant,tree')
						(cond
							((IsFlag 123) ; fTreeTurned
								(HighPrint 640 18) ; "The plant resembles a woman very much. It has no leaves or other signs of life."
							)
							((IsFlag 124) ; fTreeBloomed
								(HighPrint 640 19) ; "The plant resembles a woman very much. It has a beautiful canopy of green leaves."
							)
							(else
								(HighPrint 640 20) ; "The plant vaguely resembles a woman. It has no leaves or other signs of life."
							)
						)
					)
					((Said '/frond')
						(HighPrint 640 21) ; "The tree's branches are bare."
					)
				)
			)
			((Said 'rest')
				(cond
					((IsFlag 122) ; fGotFruit
						(HighPrint 640 22) ; "You curl up under Julanar for a brief nap."
						(EgoRests 1)
					)
					(gNight
						(EgoRests 1)
					)
					(else
						(HighPrint 640 23) ; "The blazing desert sun makes it impossible to rest here. The withered tree provides no shade at all."
					)
				)
			)
			((Said 'nap')
				(cond
					((IsFlag 122) ; fGotFruit
						(if gNight
							(EgoSleeps 5 0)
							(HighPrint 640 24) ; "You awaken at dawn."
						else
							(EgoSleeps 20 0)
							(HighPrint 640 25) ; "You awaken just after sunset."
						)
					)
					(gNight
						(EgoSleeps 5 0)
						(HighPrint 640 26) ; "You awaken at dawn, after a fitful sleep full of disturbing dreams."
					)
					(else
						(HighPrint 640 23) ; "The blazing desert sun makes it impossible to rest here. The withered tree provides no shade at all."
					)
				)
			)
			(
				(or
					(Said 'give,pour,offer,use/potion[<disenchant,disenchant]')
					(Said 'give,pour,offer,use//potion[<disenchant,disenchant]')
				)
				(cond
					((not (gEgo has: 21)) ; DispelPotion
						(DontHave)
					)
					((IsFlag 44) ; fHeardPlant
						(HighPrint 640 27) ; "You remember Aziza's story, and you know that the gifts you have given to Julanar are what needed to be done for her. Her shape is by her own choice, and cannot be dispelled."
					)
					(else
						(HighPrint 640 28) ; "You sense that your kind words and deeds are worth more than magic to the tree. Its shape cannot be dispelled."
					)
				)
			)
			(
				(or
					(Said 'pour,give/water')
					(Said 'water/tree,plant,julanar,pomegranate,root')
				)
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					((<= gDrinksLeft 0)
						(HighPrint 640 29) ; "You have no water to give."
					)
					(else
						(SetFlag 77) ; fWaterDown
						(= waterTime 1)
						(SolvePuzzle 652 7)
						(SkillUsed 14 25) ; honor
						(self setScript: giveGift)
					)
				)
			)
			(
				(or
					(Said 'tell//self,me,hero,heroic,adventure,spielburg')
					(Said 'tell/self,me,hero,heroic,adventure,spielburg')
				)
				(SolvePuzzle 651 5)
				(gEgo setMotion: PolyPath 139 172 self)
				(= whichMsg 2)
			)
			((Said 'give,plant,place,(put<down)/dirt,earth,(elemental[<earth])')
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					((gEgo has: 52) ; MagicEarth
						(SetFlag 76) ; fDirtDown
						(= waterTime 0)
						(SolvePuzzle 646 7)
						(SkillUsed 14 50) ; honor
						(self setScript: giveGift)
					)
					((gEgo has: 32) ; PotOfDirt
						(= waterTime 0)
						(self setScript: giveGift)
					)
					(else
						(HighPrint 640 30) ; "You kick a few clods of dirt in the direction of the tree's roots. The tree remains immutable."
					)
				)
			)
			(
				(or
					(Said 'tell//gift,healer,dirt,earth,(elemental[<earth])')
					(Said 'tell/gift,healer,dirt,earth,(elemental[<earth])')
				)
				(if (>= gElementalState 6)
					(SolvePuzzle 649 5)
					(gEgo setMotion: PolyPath 139 172 self)
					(= whichMsg 3)
				else
					(HighPrint 640 31) ; "The tree shivers slightly as you talk, but there is no other response."
				)
			)
			(
				(or
					(Said 'give/hug')
					(Said 'hug/tree,plant,julanar,pomegranate')
					(Said 'kiss/tree,plant,julanar,pomegranate')
					(Said 'show/affection')
				)
				(cond
					((== gEgoGait 3) ; riding
						(GetDown)
					)
					((IsFlag 80) ; fPlantHug
						(HighPrint 640 32) ; "You don't want to push your luck."
					)
					(else
						(SolvePuzzle 648 5)
						(SkillUsed 14 25) ; honor
						(self setScript: hugHer)
					)
				)
			)
			(
				(or
					(Said 'tell,say/identity,julanar,pomegranate')
					(Said 'tell//julanar,pomegranate')
					(Said '/julanar,pomegranate')
				)
				(SolvePuzzle 650 5)
				(SkillUsed 14 50) ; honor
				(Face gEgo julanar 0 self)
				(= whichMsg 4)
			)
			((Said 'thank/julanar,pomegranate,tree,plant')
				(cond
					((not (gEgo has: 36)) ; CompassionFruit
						(HighPrint 640 33) ; "The tree has no idea why you are thanking her, but she nods as in a gentle breeze."
					)
					((not plantThanked)
						(= plantThanked 1)
						(HighPrint 640 34) ; "The plant nods as if in a gentle breeze."
						(TrySkill 13 100) ; communication
						(SkillUsed 14 50) ; honor
					)
					(else
						(HighPrint 640 35) ; "You have thanked her already. Don't get carried away."
					)
				)
			)
			((Said 'tell')
				(HighPrint 640 36) ; "I talk to the trees... but they don't listen to me..."
			)
		)
	)
)

(instance dirt of PicView
	(properties
		x 155
		y 174
		noun '/earth,dirt'
		description {the earth you placed on the ground}
		view 640
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if magicDirt
					(HighPrint 640 37) ; "The earth of the Elemental shimmers at the feet of Julanar."
				else
					(HighPrint 640 38) ; "The earth rests on the ground at the base of the tree."
				)
			)
			(7
				(HighPrint 640 39) ; "Indian Giver!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance julanar of TargActor
	(properties
		x 164
		y 169
		noun '/tree,plant,julanar,pomegranate'
		description {the tree}
		view 645
		signal 16384
		illegalBits 0
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(= objType (whatHurt type:))
		(self setScript: theScreen)
		(gEgo
			view: 646
			loop: (if (> (gEgo x:) (julanar x:)) 1 else 2)
			cel: 0
			setCycle: End
		)
		(return 0)
	)

	(method (openMe)
		(if (IsFlag 122) ; fGotFruit
			(HighPrint 640 40) ; "You have already opened her heart."
		else
			(HighPrint 640 41) ; "Nice try, but you'll have to find a more traditional method of opening her heart."
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cut,carve/initial,tree,plant,julanar,pomegranate')
				(HighPrint 640 42) ; "How unecological. Not to mention rude!"
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((IsFlag 80) ; fPlantHug
						(HighPrint 640 43) ; "You think she likes you."
					)
					((IsFlag 124) ; fTreeBloomed
						(HighPrint 640 44) ; "The plant surely was once a woman."
					)
					((IsFlag 123) ; fTreeTurned
						(HighPrint 640 45) ; "You admire the way she rotates her crops."
					)
					(else
						(HighPrint 640 46) ; "The plant almost looks like a woman."
					)
				)
			)
			(8
				(HighPrint 640 47) ; "How rude!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance branches of View
	(properties
		noun '/branch,twig,branch'
		description {the tree's branches}
		lookStr {The plant's branches reach for the heavens.}
		view 645
		loop 2
	)
)

(instance aBranch of Prop
	(properties
		noun '/branch,twig,branch,frond'
		description {the tree's branches}
		view 645
		loop 3
		priority 14
		signal 16
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 640 48) ; "What lovely foliage she has."
			)
			(7
				(HighPrint 640 49) ; "You dare not defoliate this lovely plant!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theFruit of Actor
	(properties
		noun '/fruit[<compassion]'
		description {the Fruit of Compassion}
		yStep 7
		view 645
		loop 5
		signal 18432
		cycleSpeed 1
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(HighPrint 640 50) ; "It is the Fruit of Compassion, a gift from Julanar."
			)
			(7
				(HighPrint 640 51) ; "Julanar has given you the fruit you need. You need no more."
			)
			(4
				(HighPrint 640 52) ; "It smells like pomegranates."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance giveGift of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(if
			(and
				(IsFlag 79) ; fDirtStory
				(IsFlag 76) ; fDirtDown
				(IsFlag 78) ; fHeroStory
				(IsFlag 77) ; fWaterDown
				(not (IsFlag 124)) ; fTreeBloomed
			)
			(gCurRoom setScript: springTime)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 139 172 self)
			)
			(1
				(gEgo
					view: 47
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) 5)
					y: (+ (gEgo y:) 3)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(if waterTime
					(if (< (-= gDrinksLeft 10) 0)
						(= gDrinksLeft 0)
					)
					(ClearFlag 3) ; fThirsty
					(HighPrint 640 53) ; "The water, as you pour it out on the ground, quickly sinks into the soil and vanishes."
					(= cycles 2)
				else
					(if (gEgo has: 52) ; MagicEarth
						(InitAddToPics dirt)
						(RedrawCast)
						(gEgo use: 52) ; MagicEarth
						(HighPrint 640 54) ; "The Elemental Earth seems to sparkle a bit in the light as it settles down into the soil around the plant."
						(= magicDirt 1)
					else
						(gEgo use: 32) ; PotOfDirt
						(gEgo get: 35) ; EmptyPot
						(HighPrint 640 55) ; "You sprinkle the dirt around the base of the tree."
					)
					(= cycles 2)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					x: (- (gEgo x:) 5)
					y: (- (gEgo y:) 3)
					setHeading: 45
				)
				(NormalEgo)
				(if (and waterTime (IsFlag 78) (not (IsFlag 123))) ; fHeroStory, fTreeTurned
					(turnToEgo)
				else
					(= cycles 4)
				)
			)
			(5
				(CheckFlags)
				(self dispose:)
			)
		)
	)
)

(instance tellOfSelf of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(if (and (IsFlag 76) (IsFlag 79) (IsFlag 77) (not (IsFlag 124))) ; fDirtDown, fDirtStory, fWaterDown, fTreeBloomed
			(gCurRoom setScript: springTime)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== toldJulanarNumTimes 1)
					(HighPrint 640 56 70 290) ; "You start to tell the plant about yourself and your adventures. You mention how much you wish to be a hero, and how hard it has been to become one. You then tell her about your experiences in Spielburg with the Dryad and how you aided her by getting the seed of the Spore Spitting Spirea."
					(HighPrint 640 57 70 290) ; "You tell about how and why you came to Shapeir, about all the friends you have made in this land of Shapeir and all the fun you have had here. Finally, you mention that you are giving her water as a simple act of kindness, that it might ease her thirst."
				else
					(HighPrint 640 58) ; "You tell her how you took the Famous Adventurer's Correspondence Course and journeyed to Spielburg to become a hero. You mention how you came to Shapeir and the things you have done here so far."
				)
				(= toldJulanarNumTimes 1)
				(if (and (IsFlag 77) (not (IsFlag 123))) ; fWaterDown, fTreeTurned
					(turnToEgo)
				else
					(self cue:)
				)
			)
			(1
				(SetFlag 78) ; fHeroStory
				(CheckFlags)
				(self dispose:)
			)
		)
	)
)

(instance tellOfEarth of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(if (and (IsFlag 76) (IsFlag 78) (IsFlag 77) (not (IsFlag 124))) ; fDirtDown, fHeroStory, fWaterDown, fTreeBloomed
			(gCurRoom setScript: springTime)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== toldJulanarNumTimes 1)
					(HighPrint 640 59 70 290) ; "You begin speaking about the problems facing Shapeir and about the menace of the Earth Elemental. You tell how frightened the people of the city were, and how scared you were to face it."
					(HighPrint 640 60 70 290) ; "Even though you were afraid, you knew that you had to protect and save your friends. So you overcame your fear and defeated the monster. Now you are giving the magical earth to her to help remind her that there is still magic in the world and that others still care about her."
				else
					(HighPrint 640 61) ; "You tell about how you fought the Earth Elemental and how hard it was to defeat. You tell how your friends needed you. The Hero business is a dirty business, but someone's got to do it."
				)
				(= toldJulanarNumTimes 1)
				(if (and (IsFlag 76) (not (IsFlag 123))) ; fDirtDown, fTreeTurned
					(turnToEgo)
				else
					(self cue:)
				)
			)
			(1
				(SetFlag 79) ; fDirtStory
				(CheckFlags)
				(self dispose:)
			)
		)
	)
)

(instance hugHer of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(if (and (IsFlag 81) (not (IsFlag 122))) ; fPlantName, fGotFruit
			(gCurRoom setScript: fruitFall)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath (- (julanar x:) 24) (julanar y:) self
				)
			)
			(1
				(gEgo setPri: (+ (julanar priority:) 1) setHeading: 90 self)
			)
			(2
				(gEgo
					view: 646
					loop: 0
					cel: 0
					x: (- (julanar x:) 13)
					setCycle: End self
				)
				(if (and (IsFlag 124) (not (IsFlag 80))) ; fTreeBloomed, fPlantHug
					(branches
						x: 160
						y: 106
						palette: (if gNight 2 else 1)
						init:
					)
					(julanar loop: 1 cel: 0 setCycle: End)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setCycle: Beg self)
				(if (== (julanar loop:) 1)
					(julanar setCycle: Beg)
					(SetFlag 80) ; fPlantHug
					(CheckFlags)
				else
					(HighPrint 640 62) ; "The act of hugging the tree is fruitless."
				)
			)
			(5
				(gEgo
					view: 0
					setCycle: Walk
					x: (- (julanar x:) 24)
					setMotion:
						MoveTo
						(- (gEgo x:) 24)
						(+ (gEgo y:) 12)
						self
				)
				(if (== (julanar loop:) 1)
					(branches dispose:)
					(julanar loop: 0 cel: 9)
				)
			)
			(6
				(NormalEgo)
				(gEgo setHeading: 45 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance springTime of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMiscSound number: 642 loop: 0 priority: 8 play:)
				(= cycles 1)
			)
			(1
				((= [branch Index] (aBranch new:))
					x: (+ 164 [branchDeltaX Index])
					y: (+ 169 [branchDeltaY Index])
					loop: [branchLoop Index]
					palette: (if gNight 2 else 1)
					init:
					setCycle: End
				)
				(++ Index)
				(= cycles (Random 3 7))
			)
			(2
				(if (<= Index 11)
					(self changeState: 1)
				else
					(= cycles 10)
				)
			)
			(3
				(for ((= Index 0)) (< Index 12) ((++ Index))
					([branch Index] signal: -32735)
				)
				(= Index 0)
				(SetFlag 124) ; fTreeBloomed
				(self dispose:)
			)
		)
	)
)

(instance fruitFall of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(CheckFlags)
				(theFruit
					x: 109
					y: 98
					palette: (if gNight 2 else 1)
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo illegalBits: 0 setMotion: PolyPath 94 172 self)
			)
			(2
				(HighPrint 640 63 103) ; "A purple fruit has been created on one branch of the tree."
				(gEgo setHeading: 45)
				(= cycles 15)
			)
			(3
				(cls)
				(theFruit setMotion: MoveTo (theFruit x:) (+ (theFruit y:) 35))
				(gEgo view: 47 loop: 6 cel: 0 setCycle: End)
				(= cycles 10)
			)
			(4
				(HighPrint 640 64 103 self) ; "The "Fruit of Compassion" drops into your hands, Julanar's gift to you for restoring her spirit."
				(SolvePuzzle 647 7)
				(SkillUsed 14 50) ; honor
				(theFruit dispose:)
				(gEgo get: 36 setCycle: Beg) ; CompassionFruit
				(SetFlag 122) ; fGotFruit
			)
			(5
				(HighPrint 640 65) ; "You carefully put the fruit away."
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance thang of Actor
	(properties
		x 160
		y 127
		view 641
		priority 15
		signal 16400
		illegalBits 0
	)
)

(instance theScreen of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch objType
					(4
						(thang loop: 0 y: [thrownObj 0] init:)
					)
					(5
						(thang loop: 1 y: [thrownObj 7] init:)
					)
					(27
						(thang loop: 2 y: [thrownObj 13] init:)
					)
					(25
						(thang loop: 3 y: [thrownObj 21] init:)
					)
				)
				(= cycles 2)
			)
			(1
				(if (!= [thrownObj (+= objCount 1)] 0)
					(thang cel: objCount y: [thrownObj objCount])
					(= cycles 1)
				else
					(self changeState: 3)
				)
			)
			(2
				(self changeState: 1)
			)
			(3
				(if (== objType 5)
					(thang cycleSpeed: 1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(gCast eachElementDo: #stopUpd)
				(= cycles 2)
			)
			(5
				(gCurRoom overlay: 980)
				(HandsOff)
				(= cycles 2)
			)
			(6
				(self setScript: awfulNoise)
				(= seconds 8)
			)
			(7
				(EgoDead 1 640 66 #title {You broke the monitor screen!!!}) ; "Off you go to the computer store for a new monitor. By the way, real Heroes don't throw things at ladies (even rather stiff ones)."
			)
		)
	)
)

(instance awfulNoise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMiscSound number: 602 loop: 0 priority: 13 play:)
				(= cycles 10)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 160
		y 45
		noun '/wall,cliff,face[<boulder,cliff]'
		nsBottom 91
		nsRight 320
		description {the cliffs}
		lookStr {The steep wall of rock protects this alcove from the desert winds and sun.}
	)
)

(instance wall2 of Feature
	(properties
		x 273
		y 140
		noun '/wall,cliff,face[<boulder,cliff]'
		nsTop 92
		nsLeft 227
		nsBottom 189
		nsRight 319
		description {the cliffs}
		lookStr {The steep incline of rock rises rapidly.}
	)
)

