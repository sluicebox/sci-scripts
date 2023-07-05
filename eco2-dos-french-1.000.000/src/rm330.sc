;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Village)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm330 of Eco2Room
	(properties
		noun 10
		picture 330
		style 10
		horizon 48
		east 360
		west 300
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 103 0 0 319 0 319 102 293 112 293 132 249 132 240 126 225 131 225 155 185 162 164 158 125 151 125 140 84 140 0 140
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 187 224 187 319 164 319 189 0 189
					yourself:
				)
		)
		(if (gEgo has: 10)
			(LoadMany rsVIEW 81 330 336 340 350 351 352 362)
		else
			(Load rsSCRIPT 16)
		)
		(gEgo init: normalize: setScale: 0)
		(switch gPrevRoomNum
			(360
				(if (gEgo has: 10)
					(gGameSound1 setVol: 127)
				else
					(gGameSound1 setVol: 127)
				)
				(= style 11)
				(super init:)
				(self setScript: walkIn)
			)
			(300
				(gEgo y: 140)
				(= style 12)
				(super init:)
			)
			(else
				(gEgo posn: 129 165)
				(super init:)
			)
		)
		(if (gCurrentRegionFlags test: 4)
			(butterfly init:)
		)
		(if (gEgo has: 10)
			(hag1 init: approachVerbs: 13 4 2 63) ; amulet, Do, Talk, roots
			(hag3 init: approachVerbs: 13 4 2 63 20) ; amulet, Do, Talk, roots, pods
			(hag2 init: approachVerbs: 13 4 2 63 setScript: hag2Script) ; amulet, Do, Talk, roots
			(if (or (gEgo has: 18) (gCurrentRegionFlags test: 2))
				(hag2 stopUpd: setScript: cooking)
				(hag3 setLoop: 1 cel: 2 stopUpd:)
			else
				(hag1 setScript: hag1Script)
				(hag3 setScript: hag3Script)
			)
			(hunter1 init: cue: approachVerbs: 2 4) ; Talk, Do
			(hunter2 init: approachVerbs: 2 4) ; Talk, Do
			(fire setCycle: Fwd init:)
			(if (gCurrentRegionFlags test: 1)
				(suiter init:)
			)
			(if (gCurrentRegionFlags test: 7)
				(sulky init: approachVerbs: 2 4 cue:) ; Talk, Do
			)
			(weaver
				init:
				approachVerbs: 4 2 21 23 20 63 56 ; Do, Talk, charm, machete, pods, roots, mazeNecklace
				setScript: weaverScript
			)
			(gardener init: approachVerbs: 4 2 23 56 20 63) ; Do, Talk, machete, mazeNecklace, pods, roots
			(pot init:)
		else
			((View new:)
				view: 330
				loop: 6
				x: 252
				y: 127
				noun: 8
				signal: 16384
				init:
				addToPic:
			)
		)
		(exiteast init:)
		(exitwest init:)
		(longHouse init: setOnMeCheck: 1 256)
		(drum init:)
		(hole init:)
		(grove init: setOnMeCheck: 1 32)
		(foliage init: setOnMeCheck: 1 16384)
		(garden init:)
		(drumstand init:)
		(drumscore init: setOnMeCheck: 1 64)
		(pots init: setOnMeCheck: 1 2)
		(weaving init:)
		(fDrum init: setOnMeCheck: 1 512)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(gEgo x: 136)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(DisposeScript 16)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (gEgo has: 10)
				(gMessager say: noun theVerb 10) ; "The busy life of the village continues here. Every space is used for something!"
			else
				(gMessager say: noun theVerb 9) ; "The village is quiet here. However, Adam hears rustling sounds and there is no wind."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 270 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance flyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(butterfly setMotion: MoveTo 25 100 self)
			)
			(1
				(butterfly cue:)
				(self dispose:)
			)
		)
	)
)

(instance cooking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(hag3 setLoop: 4 cel: 0 setCycle: End self)
			)
			(2
				(hag3 stopUpd:)
				(hag1 setLoop: 3 cel: 2 setCycle: End self)
			)
			(3
				(hag1 setCycle: CT 3 -1 self)
			)
			(4
				(hag1 stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance getDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 4 setLoop: 7 setCycle: CT 2 1 self)
			)
			(2
				(drum hide:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 9 normalize: 0 6)
				(gCurrentRegionFlags clear: 39)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurrentRegionFlags set: 39)
				(= cycles 3)
			)
			(1
				(gMessager say: 4 17 0 1 self) ; "Adam sets the drum down on the drum stand. It seems the perfect partner for the other drum."
			)
			(2
				(gEgo view: 4 setLoop: 7 setCycle: CT 2 1 self)
			)
			(3
				(drum show:)
				(gEgo setCycle: End self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo put: 9 normalize: 0 6)
				(gCurRoom setInset: (ScriptID 16)) ; inDrums
				(self dispose:)
			)
		)
	)
)

(instance giveCharm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(weaver setScript: 0)
				(= cycles 3)
			)
			(1
				(gEgo view: 5 setLoop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(weaver setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 7 21 0 0 self) ; "Oh, how beautiful! But I can't take my sister's necklace."
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(weaver setLoop: 0 cel: 0 setScript: weaverScript)
				(gEgo put: 13 get: 8 normalize: 0)
				(= local5 1)
				(gCurrentRegionFlags set: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveMachete of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gardener setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 9 23 0 0 self) ; "Adam hands the machete to Sumac."
			)
			(4
				(Village points: 5)
				(gEgo setCycle: End self)
			)
			(5
				(gardener setLoop: 2 setCycle: ForwardCounter 5 self)
			)
			(6
				(gardener setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(7
				(gEgo cel: 0 setCycle: CT 2 1 self)
			)
			(8
				(gMessager say: 9 3 6 0 self) ; "Adam takes the tough roots."
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(gEgo put: 14 get: 17 normalize: 0)
				(gardener cue:)
				(gCurrentRegionFlags set: 32)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveRoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 4 setLoop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(cond
					((and (gCurrentRegionFlags test: 44) (gCurrentRegionFlags test: 43))
						(gMessager say: 20 24 13) ; "Ah, I shall fill Musqui's lovely cup full! Enjoy our sweet drink."
						(gEgo get: 18)
					)
					((gCurrentRegionFlags test: 43)
						(gMessager say: 20 24 6) ; "That is a lovely cup. Until I have roots, I cannot give you anything to drink! But I will keep this cup until the drink is ready!"
					)
					((gCurrentRegionFlags test: 44)
						(gMessager say: 20 63) ; "Ah, the roots! Finally. I shall put them in the pot."
					)
				)
				(self cue:)
			)
			(3
				(gCurrentRegionFlags set: 2)
				(hag1 setScript: 0)
				(hag2 setScript: 0)
				(hag3 setScript: 0)
				(gEgo setCycle: End self)
			)
			(4
				(hag2 setCycle: 0 cel: 0 stopUpd:)
				(hag3 setLoop: 4 cel: 0 setCycle: End)
				(hag1 setLoop: 3 cel: 2 setCycle: End self)
			)
			(5
				(gGame handsOn:)
				(gEgo normalize: 0 6)
				(hag1 setCycle: CT 2 -1)
				(hag2 setScript: cooking)
				(self dispose:)
			)
		)
	)
)

(instance butterfly of Actor
	(properties
		x -20
		y 100
		noun 13
		yStep 3
		view 81
		loop 5
		priority 15
		signal 24592
		maxScale 1
		cycleSpeed 3
		illegalBits 0
		xStep 5
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setScript: flyIn)
	)

	(method (setHeading param1)
		(if (not (& signal $0800))
			(super setHeading: param1 &rest)
			(= loop
				(switch loop
					(0 0)
					(1 1)
					(2 3)
					(3 2)
					(6 0)
					(4 0)
					(5 1)
					(7 1)
				)
			)
		)
	)

	(method (cue &tmp temp0 temp1)
		(if maxScale
			(= maxScale 1)
			(self cycleSpeed: 4 setCycle: Walk)
		)
		(cond
			((< x -5)
				(= temp0 (Random 5 20))
			)
			((> x 330)
				(= temp0 (- 0 (Random 5 20)))
			)
			(else
				(= temp0 (- (Random 10 40) 25))
			)
		)
		(cond
			((< y 60)
				(= temp1 (Random 5 20))
			)
			((> y 190)
				(= temp1 (- 0 (Random 5 20)))
			)
			(else
				(= temp1 (- (Random 5 25) 15))
			)
		)
		(self setMotion: MoveTo (+ x temp0) (+ y temp1) self)
	)
)

(instance hag2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hag2 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(hag2 stopUpd:)
				(= seconds (Random 3 6))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance hag2 of Prop
	(properties
		x 38
		y 126
		noun 19
		approachX 33
		approachY 142
		view 336
		cel 3
		signal 16384
		cycleSpeed 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(Village points: 1 50)
				(cond
					((gCurrentRegionFlags test: 35)
						(gMessager say: noun theVerb 3) ; "You must do as the shaman asks and enter his hut. It is so."
					)
					((gCurrentRegionFlags test: 2)
						(if local2
							(gMessager say: noun theVerb 2) ; "This is Apu's favorite. He is a good leader, too. It is so."
						else
							(= local2 1)
							(gMessager say: noun theVerb 7) ; "A very good drink. Alichina is clever. It is so."
						)
					)
					(local1
						(gMessager say: noun theVerb 1) ; "No roots, no drink. It is so."
					)
					(else
						(= local1 1)
						(gMessager say: noun theVerb 0) ; "We are waiting for roots from that lazy woman."
					)
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun theVerb 7) ; "Cuirana approves of the way the drink is being made."
				else
					(gMessager say: noun theVerb 0) ; "An old woman whose hair is still black sits near the cooking pot."
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb 0) ; "Touching the villagers would be a mark of rudeness."
			)
			(19 ; barkCup
				(Village points: 1 68)
				(gMessager say: noun theVerb) ; "The shaman is a wise man. It is so."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hag3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurrentRegionFlags test: 2)
					(hag3 setLoop: 4 cel: 0 setCycle: End self)
				else
					(hag3 setLoop: 1 cel: 2 setCycle: CT 0 -1 self)
				)
			)
			(1
				(hag3 stopUpd:)
				(= seconds (Random 3 7))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance hag3 of Prop
	(properties
		x 12
		y 129
		noun 14
		approachX 33
		approachY 142
		view 336
		loop 1
		priority 10
		signal 16400
		maxScale 1
		cycleSpeed 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(Village points: 1 51)
				(cond
					((gCurrentRegionFlags test: 35)
						(gMessager say: noun theVerb 3) ; "We have work to do here, boy. Go see the shaman."
					)
					((gCurrentRegionFlags test: 2)
						(gMessager say: noun theVerb 7) ; "I stir just as Alichina directs me."
					)
					(local1
						(gMessager say: noun theVerb 1) ; "If that lazy woman would gather roots, we could do our work."
					)
					(else
						(= local1 1)
						(gMessager say: noun theVerb 0) ; "Ah, the lazy woman, she is a curse to us!"
					)
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb 0) ; "Touching the Grove People would be a mark of rudeness."
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun theVerb 7) ; "Sabiru is happily stirring the sweet drink."
				else
					(gMessager say: noun theVerb 0) ; "A white-haired woman stares glumly at the cooking pot."
				)
			)
			(19 ; barkCup
				(Village points: 1 68)
				(gMessager say: noun theVerb) ; "The shaman is so forgetful some times. You must give that to him!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hag1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurrentRegionFlags test: 2)
					(hag1 setLoop: 3 cel: 0 setCycle: End self)
				else
					(hag1 setLoop: 2 cel: 4 setCycle: CT 2 -1 self)
				)
			)
			(1
				(hag1 stopUpd:)
				(= seconds (Random 3 7))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance hag1 of Prop
	(properties
		x 61
		y 129
		noun 20
		approachX 33
		approachY 142
		view 336
		loop 2
		cel 5
		priority 10
		signal 16400
		cycleSpeed 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(Village points: 1 49)
				(cond
					((gCurrentRegionFlags test: 35)
						(gMessager say: noun theVerb 3) ; "So you have found the shaman! You must enter his hut now."
					)
					((gCurrentRegionFlags test: 2)
						(if local2
							(gMessager say: noun theVerb 2) ; "We are busy now, child. You must talk to others."
						else
							(= local2 1)
							(gMessager say: noun theVerb 7) ; "It is a drink of remarkable sweetness."
						)
					)
					(else
						(gMessager say: noun theVerb 0) ; "Ah, just look, just look, boy! All is in readiness. We could make Apu's drink if we had the roots."
					)
				)
			)
			(4 ; Do
				(gMessager say: noun theVerb 0) ; "Touching the villagers would be a mark of rudeness."
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 2)
					(gMessager say: noun theVerb 7) ; "Alichina is watching the boiling drink carefully. It must be cooked only so much to remove the poison."
				else
					(gMessager say: noun theVerb 0) ; "An old woman with wild, gray hair stares angrily at the cooking pot."
				)
			)
			(63 ; roots
				(gCurrentRegionFlags set: 44)
				(gEgo put: 17)
				(Village points: 5)
				(gCurRoom setScript: giveRoots 0 theVerb)
			)
			(24 ; clayCup
				(gCurrentRegionFlags set: 43)
				(gEgo put: 15)
				(Village points: 5)
				(gCurRoom setScript: giveRoots 0 theVerb)
			)
			(19 ; barkCup
				(Village points: 1 68)
				(gMessager say: noun theVerb) ; "Our shaman prepares his own medicines with that. He does not use the cooking pot."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suiter of Prop
	(properties
		x 80
		y 122
		noun 15
		approachX 70
		approachY 140
		view 351
		loop 1
		priority 1
		signal 16400
		maxScale 1
		cycleSpeed 20
		detailLevel 2
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4 2 23 56 63 cue:) ; Do, Talk, machete, mazeNecklace, roots
	)

	(method (cue)
		(if maxScale
			(= maxScale 0)
			(self cel: 0 setCycle: End self)
		else
			(= maxScale 1)
			(self stopUpd:)
			((Timer new:) setReal: self (Random 5 9))
		)
	)
)

(instance weaverScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurrentRegionFlags test: 1)
					(weaver setLoop: 0 cel: 0 setCycle: End self)
				else
					(weaver setLoop: 2 cel: 4 setCycle: End self)
				)
			)
			(1
				(weaver cel: 0 stopUpd:)
				(= seconds (Random 5 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance weaver of Prop
	(properties
		x 147
		y 126
		noun 7
		approachX 126
		approachY 148
		view 350
		loop 1
		cycleSpeed 24
	)

	(method (cue)
		(if local0
			(gMessager say: 7 2 1 0) ; "Llusti is angry with me. It makes me so upset. And when my heart aches, the pattern of my cloth suffers."
		else
			(= local0 1)
			(gMessager say: 7 2 0 0) ; "Oh, please leave me alone with my sorrow."
		)
		(self setScript: weaverScript)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; charm
				(if (gCurrentRegionFlags test: 11)
					(Village points: 5)
					(gCurRoom setScript: giveCharm)
				else
					(gMessager say: 7 21 5) ; "A love charm necklace! Perhaps Llusti would apologize if I had one."
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 1)
					(gMessager say: noun theVerb 7) ; "The weaver swings the shuttle back and forth and hums while she works. From time to time she touches the love charm."
				else
					(gMessager say: noun theVerb) ; "The weaver is sitting by her loom. She looks upset."
				)
			)
			(2 ; Talk
				(Village points: 1 52)
				(cond
					(local5
						(gMessager say: noun theVerb 14) ; "I am sure this will draw Llusti back to me! I think I'll work on my cloth!"
					)
					((gCurrentRegionFlags test: 1)
						(gMessager say: noun theVerb 7) ; "Isn't it wonderful? We have made up our quarrel."
					)
					(else
						(gGame handsOff:)
						(self setScript: 0 cel: 0 setCycle: CT 4 1 self)
					)
				)
			)
			(23 ; machete
				(if (gCurrentRegionFlags test: 1)
					(gMessager say: noun theVerb 7) ; "Churana doesn't need a machete."
				else
					(super doVerb: theVerb)
				)
			)
			(19 ; barkCup
				(Village points: 1 70)
				(gMessager say: noun theVerb) ; "The shaman's cup! He uses it for medicine."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gardener of Prop
	(properties
		x 252
		y 127
		noun 9
		approachX 231
		approachY 132
		view 340
		signal 16384
		cycleSpeed 20
		detailLevel 3
	)

	(method (init)
		(plant init:)
		(if (gCurrentRegionFlags test: 32)
			(self cue:)
			(super init:)
		else
			(self setCycle: (randCycle new:))
			(super init:)
		)
	)

	(method (cue)
		(if maxScale
			(= maxScale 0)
			(self setLoop: 2 cel: 0 setCycle: End self)
		else
			(= maxScale 1)
			(self stopUpd:)
			((Timer new:) setReal: self (Random 3 7))
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 62))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 62))
			(switch theVerb
				(2 ; Talk
					(Village points: 1 53)
					(if (gCurrentRegionFlags test: 32)
						(gMessager say: noun theVerb 7) ; "I can't stop now, Adam. There is so much to do!"
					else
						(gMessager say: noun theVerb 0) ; "I can't help it that I'm not working!"
					)
				)
				(4 ; Do
					(if (gCurrentRegionFlags test: 32)
						(gMessager say: noun theVerb 7) ; "Sumac is too busy to play."
					else
						(gMessager say: noun theVerb 0) ; "Pushing Sumac would probably make her angry."
					)
				)
				(1 ; Look
					(if (gCurrentRegionFlags test: 32)
						(gMessager say: noun theVerb 7) ; "Sumac is harvesting thick roots with the sharp machete."
					else
						(gMessager say: noun theVerb 0) ; "A young woman is sitting near the garden. She looks discouraged and, from time to time, she gazes at the hunters."
					)
				)
				(23 ; machete
					(gCurRoom setScript: giveMachete)
				)
				(19 ; barkCup
					(Village points: 1 69)
					(gMessager say: noun theVerb) ; "You must be special. The shaman doesn't lend his medicine cup to most."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance sulky of Prop
	(properties
		x 193
		y 152
		noun 17
		approachX 218
		approachY 159
		view 330
		loop 5
		priority 11
		signal 16400
		maxScale 1
	)

	(method (init)
		(super init:)
		((View new:) view: 330 loop: 7 cel: 0 x: 164 y: 113 init: addToPic:)
	)

	(method (doit)
		(super doit:)
		(if (and local4 (> (gGame _detailLevel:) 1))
			(= local4 0)
			(self cue:)
		)
	)

	(method (cue)
		(if (> (gGame _detailLevel:) 1)
			(if maxScale
				(= maxScale 0)
				(self cel: 0 setCycle: End self)
			else
				(= maxScale 1)
				(self stopUpd:)
				((Timer new:) setReal: self (Random 2 5))
			)
		else
			(= local4 1)
		)
	)
)

(instance hunter1 of Prop
	(properties
		x 269
		y 188
		noun 18
		approachX 228
		approachY 172
		view 352
		loop 1
		priority 14
		signal 16400
		maxScale 1
		cycleSpeed 30
		detailLevel 3
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 63))
			(self perform: gCheckEcorderIcon self)
		)
		(if (and local3 (> (gGame _detailLevel:) 1))
			(= local3 0)
			(self cue:)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 63))
			(super doVerb: theVerb)
		)
	)

	(method (cue)
		(if (> (gGame _detailLevel:) 1)
			(if maxScale
				(hunter2 stopUpd:)
				(-- maxScale)
				(self setLoop: 1 cel: 0 setCycle: End self)
			else
				(++ maxScale)
				(self stopUpd:)
				((Timer new:) setReal: hunter2 (Random 4 8))
			)
		else
			(= local3 1)
		)
	)
)

(instance hunter2 of Prop
	(properties
		x 239
		y 189
		noun 18
		approachX 228
		approachY 172
		view 352
		priority 14
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 63))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 63))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (cue)
		(self setLoop: 0 cel: 0 setCycle: End hunter1)
	)
)

(instance fire of Prop
	(properties
		x 34
		y 132
		noun 24
		view 330
		loop 3
		signal 16384
		cycleSpeed 12
		detailLevel 3
	)
)

(instance pot of View
	(properties
		x 35
		y 135
		noun 25
		approachX 33
		approachY 142
		view 330
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 63 4 stopUpd:) ; roots, Do
	)

	(method (doit)
		(if (not (IsEcorderFlag 60))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 60))
			(if (== theVerb 63) ; roots
				(hag1 doVerb: theVerb)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drum of View
	(properties
		x 175
		y 119
		approachX 177
		approachY 161
		view 330
		signal 16384
	)

	(method (init)
		(if (gCurrentRegionFlags test: 7)
			(super init:)
		else
			(super init:)
			(if (not (gCurrentRegionFlags test: 39))
				(self hide:)
			)
		)
		(self stopUpd: approachVerbs: 4 1) ; Do, Look
	)

	(method (doit)
		(if (not (IsEcorderFlag 64))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((gCurrentRegionFlags test: 7)
				(sulky doVerb: theVerb)
			)
			((not (self perform: gWriteEcorderData theVerb 64))
				(switch theVerb
					(4 ; Do
						(if (gCurrentRegionFlags test: 39)
							(Village points: 1 58)
							(gCurRoom setScript: getDrum)
						else
							(super doVerb: theVerb)
						)
					)
					(1 ; Look
						(gCurRoom setInset: (ScriptID 16)) ; inDrums
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 92
		nsLeft 308
		nsBottom 146
		nsRight 319
		cursor 11
		exitDir 2
	)
)

(instance exitwest of ExitFeature
	(properties
		nsTop 120
		nsBottom 160
		nsRight 14
		cursor 12
		exitDir 4
	)
)

(instance pots of Feature
	(properties
		x 146
		y 14
		noun 23
		onMeCheck 2
	)
)

(instance weaving of Feature
	(properties
		x 117
		y 103
		noun 21
		nsTop 77
		nsLeft 103
		nsBottom 134
		nsRight 120
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 61))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 61))
			(super doVerb: theVerb)
		)
	)
)

(instance longHouse of Feature
	(properties
		x 99
		y 98
		noun 1
		onMeCheck 256
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 58))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 58))
			(super doVerb: theVerb)
		)
	)
)

(instance hole of Feature
	(properties
		x 33
		y 17
		noun 2
		nsTop 10
		nsBottom 25
		nsRight 66
	)
)

(instance grove of Feature
	(properties
		x 146
		y 24
		noun 3
		onMeCheck 32
	)
)

(instance foliage of Feature
	(properties
		x 146
		y 10
		noun 26
		onMeCheck 16384
	)
)

(instance garden of Feature
	(properties
		x 251
		y 40
		noun 8
		nsTop 66
		nsLeft 221
		nsBottom 115
		nsRight 281
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 62))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 62))
			(super doVerb: theVerb)
		)
	)
)

(instance drumstand of Feature
	(properties
		x 191
		y 107
		noun 4
		nsTop 125
		nsLeft 171
		nsBottom 149
		nsRight 211
		approachX 177
		approachY 161
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self approachVerbs: 17) ; drum
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 64))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 64))
			(switch theVerb
				(4 ; Do
					(if (gCurrentRegionFlags test: 33)
						(Village points: 1 58)
						(gCurRoom setScript: getDrum)
					else
						(super doVerb: theVerb)
					)
				)
				(17 ; drum
					(if (gEgo has: 10)
						(gMessager say: noun theVerb 0 2) ; "Adam has already opened the door. There is no need to play the drum now."
					else
						(Village points: 5 59)
						(gCurRoom setScript: putDrum)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance drumscore of Feature
	(properties
		x 164
		y 103
		noun 5
		onMeCheck 64
		approachX 177
		approachY 161
	)

	(method (init)
		(super init:)
		(self approachVerbs: 17) ; drum
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(drumstand doVerb: theVerb)
			)
			(17 ; drum
				(drumstand doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fDrum of Feature
	(properties
		x 209
		y 134
		noun 16
		onMeCheck 512
		approachX 177
		approachY 161
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self approachVerbs: 17) ; drum
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 64))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 64))
			(switch theVerb
				(4 ; Do
					(drumstand doVerb: theVerb)
				)
				(17 ; drum
					(drumstand doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 278
		y 118
		noun 28
		nsTop 110
		nsLeft 267
		nsBottom 127
		nsRight 290
	)
)

(instance randCycle of Fwd
	(properties)

	(method (doit &tmp temp0)
		(cond
			((> (= temp0 (self nextCel:)) (client lastCel:))
				(self cycleDone:)
			)
			((not (Random 0 4))
				(client cel: temp0)
			)
		)
	)
)

