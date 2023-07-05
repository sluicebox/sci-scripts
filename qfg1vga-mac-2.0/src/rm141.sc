;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm141 0
	baronTalker 1
	bernieTalker 2
)

(local
	[local0 6] = [0 10 -11 8 -9 999]
	[local6 5] = [0 7 -12 15 999]
	[local11 3] = [0 -16 999]
	[local14 4] = [0 18 14 999]
	[local18 4] = [0 13 17 999]
	[local22 6] = [0 22 20 21 19 999]
	[local28 7]
	[local35 4]
	[local39 2] = [0 999]
	[local41 7] = [0 -11 -9 -12 -16 999 0]
	local48
	[local49 2]
	local51
)

(instance rm141 of Rm
	(properties
		noun 10
		picture 141
		style 8
	)

	(method (dispose)
		(= gUseSortedFeatures local51)
		(= global425 0)
		(super dispose:)
	)

	(method (init)
		(= [local28 0] @local0)
		(= [local28 1] @local6)
		(= [local28 2] @local11)
		(= [local28 3] @local14)
		(= [local28 4] @local18)
		(= [local28 5] 999)
		(= [local35 0] @local22)
		(Load rsVIEW 141)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 272 189 0 189 0 0 319 0 319 166 312 166 303 159 300 147 290 140 280 139 265 141 259 150 253 156 242 158 232 156 226 149 225 142 222 145 214 146 93 125 10 154 137 188 272 188
					yourself:
				)
		)
		(super init:)
		(gEgo hide:)
		(= local51 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(|= global425 $0006)
		(EgoGait 0 0) ; walking
		(SolvePuzzle 663 10)
		(SL enable:)
		(guard1 addToPic:)
		(guard2 addToPic:)
		(tapestry init: setOnMeCheck: 1 2)
		(alcove init: setOnMeCheck: 1 4)
		(crest init: setOnMeCheck: 1 8)
		(pillars init: setOnMeCheck: 1 16)
		(stainedGlass init: setOnMeCheck: 1 32)
		(couch init: setOnMeCheck: 1 64)
		(vase init: setOnMeCheck: 1 128)
		(brasier init: setOnMeCheck: 1 256)
		(piglet init: setOnMeCheck: 1 1024)
		(wine init: setOnMeCheck: 1 2048)
		(table init: setOnMeCheck: 1 4096)
		(throne init: setOnMeCheck: 1 8192)
		(guard3 init: setPri: 4 stopUpd:)
		(baronTeller init: baron @local0 @local28 @local41)
		(baron setPri: 5 actions: baronTeller init:)
		(bernardTeller init: son @local22 @local35 @local39)
		(son setPri: 4 actions: bernardTeller init: stopUpd:)
		(if (or (== gEgoGait 2) (== gEgoGait 1)) ; sneaking, running
			(EgoGait 0 1) ; walking
		)
		(= gFreeMeals 1)
		(self setScript: egoEnters)
	)

	(method (doit)
		(if (and (& (gEgo onControl: 1) $4000) (not (gEgo script:)))
			(gEgo setScript: guardBlocks)
		else
			(super doit:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(77 ; triggerSpell or Pickup Inventory
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(78 ; dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(20 ; rock
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(16 ; dagger
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(51 ; openSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(80 ; calmSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(50 ; detectMagicSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(82 ; fetchSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(79 ; zapSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(52 ; Sleep
				(gCurRoom setScript: leaveRoom)
			)
			(1 ; Look
				(gMessager say: 10 1) ; "The Great Hall of Spielburg Castle is not very impressive. The room is plain, with scuffed floors and grimy plastered walls."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1 25) ; "You are less than awed by Baron von Spielburg's Great Hall. You'd think a Baron could keep his home a little cleaner. You try to hide your disappointment."
			)
			(4 ; Do
				(gMessager say: 10 4 25) ; "You straighten your clothing. The presence of all this nobility makes you slightly uncomfortable."
			)
			(2 ; Talk
				(gMessager say: 10 2 25) ; "You rehearse your award acceptance speech."
			)
			(else
				(return 0)
			)
		)
	)
)

(instance baron of Actor
	(properties
		x 51
		y 130
		noun 2
		view 141
		loop 2
		illegalBits 0
	)

	(method (init)
		(self setStep: 2 2 signal: 24592)
		(super init:)
	)
)

(instance baronTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(2 ; Talk
				(if local48
					(gCurRoom setScript: leaveRoom)
				else
					(SolvePuzzle 664 3)
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(gMessager say: 2 1) ; "The Baron von Spielburg looks like he was once a strong man, but sorrow has aged him greatly."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance son of Actor
	(properties
		x 91
		y 122
		noun 3
		view 141
		loop 4
		illegalBits 0
	)

	(method (init)
		(self setStep: 2 2 signal: 24592)
		(super init:)
	)
)

(instance bernardTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(gMessager say: 3 1) ; "The Baronet looks his usual haughty self, although his clothes are a little neater than the last time you saw him."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
		(return 1)
	)
)

(instance tapestry of Feature
	(properties
		noun 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 13 1) ; "The tapestry on the back wall seems to depict some great battle of the past."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance alcove of Feature
	(properties
		noun 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 1 1) ; "Behind the velvet curtains is an alcove leading to the offices of the Baron."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance crest of Feature
	(properties
		noun 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 6 1) ; "The von Spielburg coat of arms: Twin Saurus guarding, Winged Chevron, on a field Azure."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance pillars of Feature
	(properties
		noun 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 9 1) ; "The Baron collected these pillars on an ocean quest for an undersea kingdom."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance stainedGlass of Feature
	(properties
		noun 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 11 1) ; "The Baron grabbed these windows on crusades to Tangiers."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance couch of Feature
	(properties
		noun 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 5 1) ; "The couch must be a precious heirloom; why else would the Baron keep such an uncomfortable-looking piece of furniture around?"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance vase of Feature
	(properties
		noun 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 15 1) ; "A vase from the Ding Dynasty. (So named because their stoneware makes a pleasant bell-like sound when tapped with a fingernail.)"
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance brasier of Feature
	(properties
		noun 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 4 1) ; "A brazier stands ready for the evenings coals."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance piglet of Feature
	(properties
		noun 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 8 1) ; "A roast pig waits on the sideboard to be your supper."
			)
			(4 ; Do
				(gMessager say: 12 4) ; "The table is filled to overflowing."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance wine of Feature
	(properties
		noun 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 16 1) ; "A wine of the rarest vintage from Raseir stands ready for dinner."
			)
			(4 ; Do
				(gMessager say: 12 4) ; "The table is filled to overflowing."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		noun 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 12 1) ; "The table is prepared for dinner. Do you have timing or what?"
			)
			(4 ; Do
				(gMessager say: 12 4) ; "The table is filled to overflowing."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance throne of Feature
	(properties
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 14 1) ; "The throne of the Baron is an unimpressive wooden highback chair."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance guard3 of Prop
	(properties
		x 296
		y 151
		noun 7
		view 141
		loop 6
		cel 1
	)

	(method (doVerb theVerb)
		(guard1 doVerb: theVerb &rest)
	)
)

(instance guard1 of View
	(properties
		x 20
		y 141
		noun 7
		view 141
		loop 1
		priority 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 81 77 78) ; flameDartSpell, triggerSpell or Pickup Inventory, dazzleSpell
				(gMessager say: 10 81) ; "You realize, of course, that such actions will not only have you grabbed by guards, dragged to the dungeon, and brutally tortured, but that you probably won't be able to win this game if you perform them."
			)
			(1 ; Look
				(gMessager say: 7 1) ; "The guards stand stiffly at attention."
			)
			(2 ; Talk
				(gMessager say: 7 2) ; "The guards are not free to speak."
			)
			(else
				(gCurRoom doVerb: theVerb &rest)
			)
		)
	)
)

(instance guard2 of View
	(properties
		x 136
		y 118
		noun 7
		view 141
		loop 1
		cel 1
		priority 3
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 0)
				(= cycles 1)
			)
			(1
				(gEgo posn: 299 184 actions: egoActions init: show:)
				(= temp0 (gEgo cycleSpeed:))
				(= ticks 10)
			)
			(2
				(gEgo setMotion: MoveTo 155 162 self)
			)
			(3
				(Face gEgo baron)
				(= seconds 2)
			)
			(4
				(gEgo
					view: 508
					loop: 0
					cel: 0
					forceUpd:
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(NormalEgo 7 4)
				(= cycles 1)
			)
			(6
				(gEgo cycleSpeed: temp0) ; UNINIT
				(= seconds 2)
			)
			(7
				(client setScript: openingSpeech)
			)
		)
	)
)

(instance openingSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 1141)
				(baron setCycle: CT 7 1 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(baron stopUpd:)
				(gMessager say: 2 0 3 0 self) ; "Words cannot express the gratitude I have towards you."
			)
			(3
				(Load rsVIEW 1317)
				(son setCycle: End self)
			)
			(4
				(= seconds 1)
			)
			(5
				(son stopUpd:)
				(gMessager say: 3 0 3 0 self) ; "We, er, that is, I, am appreciative of your efforts upon my behalf."
			)
			(6
				(Load rsVIEW 1141)
				(= seconds 2)
			)
			(7
				(if (IsFlag 150)
					(gMessager say: 2 0 6 0 self) ; "Furthermore, I understand you have rid our valley of a dangerous Kobold Magic User in order to free the Baronet von Spielburg."
				else
					(self cue:)
				)
			)
			(8
				(if (IsFlag 150)
					(self cue:)
				else
					(client setScript: becomeHero)
				)
			)
			(9
				(= seconds 2)
			)
			(10
				(gMessager say: 2 0 3 4 self) ; "Barnard."
			)
			(11
				(Load rsVIEW 1317)
				(= ticks 120)
			)
			(12
				(gMessager say: 3 0 6 1 self) ; "I'm pleased you managed to kill the Kobold."
			)
			(13
				(client setScript: becomeHero)
			)
		)
	)
)

(instance becomeHero of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 1141)
				(= seconds 2)
			)
			(1
				(gMessager say: 2 0 1 0 self) ; "I sincerely hope you will continue your valiant adventures in our land. If anyone can rid the land of brigands, it will be you."
			)
			(2
				(= seconds 2)
			)
			(3
				(gMessager say: 2 0 3 4 self) ; "Barnard."
			)
			(4
				(Load rsVIEW 1317)
				(= ticks 120)
			)
			(5
				(gMessager say: 3 0 1 1 self) ; "It would be nice if someone could finally defeat the brigands and claim the title."
			)
			(6
				(Load rsVIEW 1141)
				(= seconds 1)
			)
			(7
				(gMessager say: 2 0 2 0 self) ; "As you leave the castle tomorrow, you will receive the reward money I long ago posted for the safe return of my son, as a token of my thanks."
			)
			(8
				(gLongSong fade:)
				(= seconds 2)
			)
			(9
				(gMessager say: 2 0 4 1 self) ; "Do you have any questions?"
			)
			(10
				(client setScript: answerQs)
			)
		)
	)
)

(instance answerQs of Script
	(properties)

	(method (init)
		(HandsOn)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $0200)
			(client setScript: leaveRoom)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 6)
			)
			(1
				(if (not local48)
					(self changeState: 0)
				else
					(client setScript: leaveRoom)
				)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: 38 50) ; gold
				(HandsOff)
				(gEgo setCycle: 0 setMotion: 0)
				(= ticks 24)
			)
			(1
				(NormalEgo 1 4)
				(= ticks 12)
			)
			(2
				(Face gEgo baron self)
			)
			(3
				(gMessager say: 2 0 5 1 self) ; "A servant is awaiting you outside to show you to your quarters. We will see you at supper later."
			)
			(4
				(gEgo setMotion: MoveTo 350 188 self)
			)
			(5
				(NextDay)
				(FixTime 5)
				(= [gEgoStats 15] (MaxStamina)) ; stamina
				(TakeDamage -16)
				(UseMana -16)
				(= ticks 100)
			)
			(6
				(if (and (IsFlag 326) (not (IsObject gFastCast)))
					(HandsOff)
					(gMessager say: 10 0 24 0 self) ; "Suddenly, you hear voices, seeming to come from everywhere at once. They all sound like Baba Yaga, and they all say:"
				else
					(self cue:)
				)
			)
			(7
				(if (and (IsFlag 326) (not (IsObject gFastCast)))
					(ClearFlag 326)
					(EgoDead 118 119) ; "Because you failed to meet Baba Yaga's DEADline, her curse turns you into a frog on the spot, and you are forced to live out your years dodging Sauruses (Saurii?) with large feet."
				else
					(self cue:)
				)
			)
			(8
				(gCurRoom newRoom: 41)
			)
		)
	)
)

(instance guardBlocks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: 0 setMotion: 0)
				(guard3 startUpd:)
				(= ticks 6)
			)
			(1
				(guard3 setCycle: End self)
			)
			(2
				(gMessager say: 10 0 23 1 self) ; "You'd better stay in the main hall. It wouldn't be wise to offend the Baron."
			)
			(3
				(guard3 setCycle: Beg)
				(gEgo
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(4
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance baronTalker of Talker
	(properties
		x 10
		y 10
		view 1141
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: baronBust baronEye baronMouth &rest)
	)
)

(instance baronBust of Prop
	(properties
		view 1141
	)
)

(instance baronMouth of Prop
	(properties
		nsTop 44
		nsLeft 42
		view 1141
		loop 1
	)
)

(instance baronEye of Prop
	(properties
		nsTop 26
		nsLeft 46
		view 1141
		loop 3
	)
)

(instance bernieTalker of Talker
	(properties
		x 10
		y 10
		view 1317
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: bernieBust bernieEye bernieMouth &rest)
	)
)

(instance bernieBust of Prop
	(properties
		view 1317
	)
)

(instance bernieEye of Prop
	(properties
		nsTop 33
		nsLeft 47
		view 1317
		loop 2
	)
)

(instance bernieMouth of Prop
	(properties
		nsTop 53
		nsLeft 46
		view 1317
		loop 1
	)
)

