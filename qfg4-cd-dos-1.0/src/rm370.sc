;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm370 0
)

(local
	local0 = 125
	local1 = 180
	local2
	local3
	local4
	local5
	local6
)

(instance rm370 of GloryRm
	(properties
		picture 370
		west 380
		leftY 179
	)

	(method (init)
		(= local2
			(cond
				((== global430 0) 1)
				((and (== global431 gDay) (== global430 1)) 2)
				((and (== global430 1) (not (== global431 gDay))) 3)
				((and (== global431 gDay) (== global430 2)) 4)
				((and (not (== global431 gDay)) (== global430 2)) 5)
				((and (== global431 gDay) (== global430 3)) 6)
				((and (not (== global431 gDay)) (== global430 3)) 7)
				((and (== global431 gDay) (== global430 4)) 8)
				((and (not (== global431 gDay)) (== global430 4)) 9)
				((and (== global431 gDay) (== global430 5)) 10)
				((and (not (== global431 gDay)) (== global430 5)) 11)
				((and (== global431 gDay) (== global430 6)) 12)
				((or (not (== global431 gDay)) (>= global430 6)) 13)
			)
		)
		(gLongSong number: 370 setLoop: -1 play:)
		(gEgo init: normalize: setScaler: Scaler 122 50 189 87)
		(gEgo posn: -15 180)
		(onceIncidental init: posn: 1000 1000)
		(seqIncidental init: posn: 1000 1000)
		(cranium init:)
		(cond
			((OneOf local2 4 7 8 10)
				(cranium posn: 111 171)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 244 184 244 164 177 180 87 180 87 175 60 175 -300 175 -300 -300 619 -300 619 489 -300 489 -300 184
							yourself:
						)
				)
			)
			((== local2 9)
				(cranium posn: 111 171 loop: 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 244 184 244 164 177 180 87 180 87 175 60 175 -300 175 -300 -300 619 -300 619 489 -300 489 -300 184
							yourself:
						)
				)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 244 184 244 165 177 180 66 180 66 174 110 161 139 161 139 157 110 157 38 175 -300 175 -300 -300 619 -300 619 489 -300 489 -300 184
							yourself:
						)
				)
			)
		)
		(slab init: cel: (and (OneOf local2 4 7 8 9 10) 1))
		(fire setCycle: Fwd init:)
		(table init: approachVerbs: 4) ; Do
		(skull init: approachVerbs: 4) ; Do
		(books init: approachVerbs: 4) ; Do
		(rayGun init: approachVerbs: 4) ; Do
		(boiler init: approachVerbs: 4) ; Do
		(boilerChain init: approachVerbs: 4) ; Do
		(eyeBeaker init: approachVerbs: 4) ; Do
		(hearth init: approachVerbs: 4) ; Do
		(tower init: approachVerbs: 4) ; Do
		(bottles init: approachVerbs: 4) ; Do
		(experiment init: approachVerbs: 4) ; Do
		(globes init: approachVerbs: 4) ; Do
		(still init: approachVerbs: 4) ; Do
		(gargoyle init: approachVerbs: 4) ; Do
		(super init: &rest)
		(onceIncidental setScript: onceAnim)
		(seqIncidental setScript: seqAnim)
		(self setScript: sEnterScr)
	)

	(method (newRoom)
		(gLongSong fade: 0)
		(super newRoom: &rest)
	)

	(method (leaveRoom)
		(if (OneOf local2 1 3 5 7 9 11 13)
			(++ global430)
			(= global431 gDay)
		)
		(switch local2
			(1
				(gMessager say: 1 6 3) ; "Come back and visit again."
			)
			(3
				(gMessager say: 1 6 12) ; "Perhaps I should wait a day or two before resuming my Frankie experiment. It is very important that the right person stay in charge here."
			)
			(5
				(gMessager say: 1 6 13) ; "Rehydration may prove to be a crucial step on the way to an even more important discovery -- instant water!"
			)
			(7
				(gMessager say: 1 6 14) ; "I am looking forward to the successful completion of my Frankie experiment. My first attempt was with a bush I dug up in the forest garden. The operation was a great success!"
			)
			(9
				(gMessager say: 1 6 15) ; "Do not be concerned if you should be unable to reach me during the next few days. Frankie and I shall be engaged in some very important and engrossing scientific research!"
			)
			(11
				(gMessager say: 1 6 16) ; "Perhaps I should keep the results of the Frankie experiment to myself. I am not sure if the world is quite ready for infinitely agreeable artificial women."
			)
			(12
				(proc0_17 1 6 17)
			)
			(else
				(proc0_17 1 6 19)
			)
		)
	)

	(method (dispose)
		(if gCuees
			(gCuees dispose:)
			(= gCuees 0)
		)
		(super dispose:)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(if (OneOf local2 4 7 8 9 10)
					(= local0 89)
				)
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(2
				(heroTeller
					init:
						gEgo
						370
						24
						128
						(switch local2
							(1 16)
							(2 16)
							(3 18)
							(4 18)
							(5 19)
							(6 19)
							(7 20)
							(8 20)
							(9 21)
							(10 21)
							(11 22)
							(12 22)
							(13 23)
						)
				)
				(if (== local2 9)
					(= cycles 1)
				else
					(cranium setCycle: End self)
				)
			)
			(3
				(switch local2
					(1
						(gEgo solvePuzzle: 410 6)
						(gMessager say: 1 6 2 0 self) ; "Quickly, Igor, the fluid! I must have the fluid!"
					)
					(3
						(gMessager say: 1 6 7 0 self) ; "Ah, you are just in time to witness a magnificent scientific experiment! I have managed to harness the very primal force of lightning at my beck and call. Now I shall use it to create life itself!"
					)
					(5
						(gMessager say: 1 6 8 0 self) ; "I believe I am on the verge of a major discovery! It came to me last night -- I believe that there is a formula which can be used to create a Rehydration Solution!"
					)
					(7
						(gMessager say: 1 6 9 0 self) ; "I have made substantial progress with my Frankie since your last visit. With the M.E.S.S. recalibrated, I was able to focus the initial stimulation and have achieved the first traces of independent muscular coordination."
					)
					(9
						(gMessager say: 1 6 10 0 self) ; "I have done it! The world shall not soon forget the genius of Dr. Cranium! The experiment is a success! Behold... Frankie!"
					)
					(11
						(gMessager say: 1 6 11 0 self) ; "I have been preparing a research report to tell the world about my process for reanimating dead tissue. It is proving very difficult. I must omit no detail or the more skeptical of my fellows will doubt my results."
					)
					(13
						(proc0_17 1 6 18 self)
					)
					(else
						(proc0_17 1 6 1 self)
					)
				)
			)
			(4
				(switch local2
					(3
						(client setScript: sCraniumZapped)
					)
					(7
						(client setScript: sFrankieAlive)
					)
					(9
						(client setScript: sFrankieReveal)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCraniumZapped of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 1)
			)
			(1
				(gLongSong2 number: 371 play:)
				(craniumZap init: setCycle: CT 13 1 self)
			)
			(2
				(++ local3)
				(craniumZap setCycle: CT 9 -1 self)
			)
			(3
				(craniumZap setCycle: CT 13 1 self)
			)
			(4
				(if (not (>= local3 3))
					(-= state 3)
				)
				(= cycles 1)
			)
			(5
				(craniumZap hide:)
				(= seconds 3)
			)
			(6
				(gMessager say: 1 6 63 0 self) ; "Hmm, that was not quite the experimental result I expected. But never mind that! It is merely a momentary setback in the annals of SCIENCE! I shall readjust the Magnetic Electrical Stimulation System and try again another day!"
			)
			(7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrankieAlive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 10)
			)
			(1
				(handWave init: setCycle: Fwd)
				(= cycles 72)
			)
			(2
				(gMessager say: 1 6 64 0 self) ; "It is not often that ordinary people such as yourself have the opportunity to witness True Genius! I expect that you are feeling especially honored just now."
			)
			(3
				(= cycles 10)
			)
			(4
				(handWave hide:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrankieReveal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(cranium
					posn: 166 148
					loop: 7
					cel: 0
					setPri: 172
					setCycle: End self
				)
				(slab hide:)
			)
			(1
				(gMessager say: 1 6 6 0 self) ; "Ah, a very nice Frankie, I am sure you will agree! Just as I planned. I believe she has all the assets necessary to become a premier scientific laboratory assistant!"
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance onceAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= cycles (Random 1 120))
			)
			(1
				1
				(= state (Random 1 5))
				(= cycles 1)
			)
			(2
				2
				(+= register 1)
				(onceIncidental
					view: 370
					loop: 0
					cel: 0
					posn: 212 188
					cycleSpeed: 6
					setPri: 200
				)
				(= state 6)
				(= cycles 1)
			)
			(3
				3
				(+= register 1)
				(onceIncidental
					view: 370
					loop: 1
					cel: 0
					posn: 212 188
					cycleSpeed: 8
					setPri: 200
				)
				(= state 6)
				(= cycles 1)
			)
			(4
				4
				(+= register 1)
				(onceIncidental
					view: 370
					loop: 2
					cel: 1
					posn: 307 124
					cycleSpeed: 6
				)
				(= state 6)
				(= seconds 2)
			)
			(5
				5
				(+= register 2)
				(onceIncidental
					view: 370
					loop: 6
					cel: 0
					posn: 248 134
					cycleSpeed: 8
					setPri: 100
				)
				(= state 6)
				(= cycles 1)
			)
			(6
				6
				(+= register 2)
				(onceIncidental
					view: 377
					loop: 0
					cel: 0
					posn: 49 169
					cycleSpeed: 6
					setPri: 200
				)
				(= state 6)
				(= cycles 1)
			)
			(7
				7
				(if (>= register 3)
					(= register 0)
					(onceIncidental setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(8
				8
				(onceIncidental setPri: -1 posn: 1000 1000)
				(self changeState: 0)
			)
		)
	)
)

(instance seqAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= seconds (Random 1 3))
			)
			(1
				1
				(= state
					(switch (Random 1 5)
						(1 1)
						(2 4)
						(3 7)
						(4 9)
						(5 12)
					)
				)
				(= cycles 1)
			)
			(2
				2
				(seqIncidental
					view: 377
					loop: 4
					cel: 0
					posn: 15 58
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				3
				(seqIncidental
					view: 377
					loop: 5
					cel: 0
					posn: 15 58
					setCycle: End self
				)
			)
			(4
				4
				(= state 14)
				(seqIncidental
					view: 377
					loop: 6
					cel: 0
					posn: 22 2
					setCycle: End self
				)
			)
			(5
				5
				(seqIncidental
					view: 370
					loop: 3
					cel: 0
					posn: 305 50
					setCycle: End self
				)
			)
			(6
				6
				(seqIncidental
					view: 370
					loop: 4
					cel: 0
					posn: 304 24
					setCycle: End self
				)
			)
			(7
				7
				(= state 14)
				(seqIncidental
					view: 370
					loop: 5
					cel: 0
					posn: 278 14
					setCycle: End self
				)
			)
			(8
				8
				(seqIncidental
					view: 377
					loop: 2
					cel: 0
					posn: 219 119
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(9
				9
				(= state 14)
				(seqIncidental
					view: 377
					loop: 3
					cel: 0
					posn: 219 119
					setCycle: End self
				)
			)
			(10
				10
				(seqIncidental
					view: 372
					loop: 0
					cel: 0
					posn: 74 74
					setPri: 200
					setCycle: End self
				)
			)
			(11
				11
				(seqIncidental
					view: 372
					loop: 1
					cel: 0
					posn: 74 74
					setCycle: End self
				)
			)
			(12
				12
				(= state 14)
				(seqIncidental
					view: 372
					loop: 2
					cel: 0
					posn: 74 74
					setCycle: End self
				)
			)
			(13
				13
				(seqIncidental
					view: 373
					loop: 0
					cel: 0
					posn: 107 34
					setCycle: End self
				)
			)
			(14
				(= state 14)
				(seqIncidental
					view: 373
					loop: 1
					cel: 0
					posn: 107 34
					setCycle: End self
				)
			)
			(15
				15
				(seqIncidental posn: 1000 1000 setPri: -1 cycleSpeed: 6)
				(self changeState: 0)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties)
)

(instance craniumTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 69 0)) ; craniumTalker
	)

	(method (showCases)
		(super
			showCases:
				99 ; Old Man
				(not (IsFlag 45))
				23 ; Magic
				(and [gEgoStats 12] (not [gEgoStats 40])) ; magic, glideSpell
				44 ; Healing Potions
				(not (IsFlag 184))
				46 ; Healing Potions
				(and (IsFlag 184) (IsFlag 193) (!= global446 gDay))
				45 ; Healing Potions
				(and (IsFlag 184) (not (IsFlag 193)) (== global446 gDay))
				47 ; Healing Potions
				(and (IsFlag 184) (not (IsFlag 193)) (!= gDay global446))
				48 ; Poison Cure
				(not (IsFlag 197))
				50 ; Poison Cure
				(and (IsFlag 197) (IsFlag 194) (!= global447 gDay))
				49 ; Poison Cure
				(and (IsFlag 197) (not (IsFlag 194)) (== gDay global447))
				51 ; Poison Cure
				(and (IsFlag 197) (not (IsFlag 194)) (!= gDay global447))
				52 ; Rehydration Solution
				(IsFlag 196)
				53 ; Rehydration Solution
				(and
					(>= local2 5)
					(not (IsFlag 198))
					(not (gEgo has: 32)) ; theRehydrator
					(not ((gInventory at: 32) chestAmout:)) ; theRehydrator
					(not (IsFlag 440))
					(not (IsFlag 196))
					(not (IsFlag 195))
				)
				54 ; Rehydration Solution
				(and (IsFlag 195) (not (IsFlag 198)))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(23 ; Magic
				(gEgo learn: 40 100 solvePuzzle: 498 2 2) ; glideSpell
				(SetFlag 498)
			)
			(44 ; Healing Potions
				(SetFlag 184)
				(= global446 gDay)
				(= local4 global434)
			)
			(46 ; Healing Potions
				(gEgo get: 3 1) ; theHeals
				(= global446 gDay)
			)
			(47 ; Healing Potions
				(= global446 gDay)
				(= local4 global434)
			)
			(48 ; Poison Cure
				(SetFlag 197)
				(= global447 gDay)
				(= local4 global435)
			)
			(50 ; Poison Cure
				(gEgo get: 2 1) ; theCures
				(= global447 gDay)
			)
			(51 ; Poison Cure
				(= global447 gDay)
				(= local4 global435)
			)
			(53 ; Rehydration Solution
				(= local4 global436)
			)
			(52 ; Rehydration Solution
				(= local4 global436)
			)
			(58 ; Empty Flasks
				(gEgo get: 9) ; theFlask
			)
		)
		(super sayMessage: &rest)
	)

	(method (cue)
		(if (not (gCurRoom script:))
			(if (OneOf iconValue 44 47 48 51 53 52)
				(talker hide:)
				(gCurRoom setScript: delayMsg)
			else
				(super cue:)
			)
		else
			(= local4 0)
			((gCurRoom script:) dispose:)
			(DisposeScript 88)
			(super cue:)
		)
	)
)

(instance delayMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 88 0) init: local4 show: dispose:) ; protection
					(= register 1)
				else
					(= register 0)
				)
				((craniumTeller talker:) showAgain:)
				(= cycles 1)
			)
			(1
				(if register
					(cond
						((OneOf (craniumTeller iconValue:) 44 47)
							(gEgo get: 3 1) ; theHeals
							(SetFlag 193)
							(gEgo solvePuzzle: 411 2)
							(gMessager say: 25 6 55 0 craniumTeller) ; "Thank you! With that information, I am sure I shall be able to create some sensational scientific solutions."
						)
						((OneOf (craniumTeller iconValue:) 48 51)
							(gEgo get: 2 1) ; theCures
							(SetFlag 194)
							(gEgo solvePuzzle: 412 2)
							(gMessager say: 25 6 55 0 craniumTeller) ; "Thank you! With that information, I am sure I shall be able to create some sensational scientific solutions."
						)
						((OneOf (craniumTeller iconValue:) 53 52)
							(SetFlag 195)
							(ClearFlag 196)
							(gEgo solvePuzzle: 413 2)
							(gMessager say: 25 6 106 0 craniumTeller) ; "Yes, that sounds just right!"
						)
						(else
							(craniumTeller cue:)
						)
					)
				else
					(if (OneOf (craniumTeller iconValue:) 53 52)
						(SetFlag 196)
					)
					(gMessager say: 25 6 107 0 craniumTeller) ; "Somehow, that doesn't seem quite right. Maybe you'd better check your manual and try again tomorrow."
				)
			)
		)
	)
)

(instance slab of View
	(properties
		noun 2
		x 166
		y 148
		priority 172
		fixPriority 1
		view 374
		signal 16384
	)

	(method (doVerb theVerb)
		(table doVerb: theVerb)
	)
)

(instance handWave of Prop
	(properties
		noun 2
		x 166
		y 148
		priority 174
		fixPriority 1
		view 374
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(table doVerb: theVerb)
	)
)

(instance cranium of Prop
	(properties
		noun 1
		x 165
		y 164
		priority 165
		fixPriority 1
		view 375
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(craniumTeller
			init:
				self
				370
				24
				158
				(switch local2
					(1 16)
					(2 16)
					(3 18)
					(4 18)
					(5 19)
					(6 19)
					(7 20)
					(8 20)
					(9 21)
					(10 21)
					(11 22)
					(12 22)
					(13 23)
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (== loop 7) (> gMouseX 119))
			(table doVerb: theVerb)
		else
			(switch theVerb
				(26 ; theGruegoo
					(gEgo use: 11 1) ; theGruegoo
					(if (and (IsFlag 195) (not (IsFlag 198)))
						(SetFlag 198)
						(gEgo get: 32) ; theRehydrator
						(gMessager say: 1 26 54) ; "That is terrific! This is just what I need for my experiments!"
					else
						(gMessager say: 1 26 56) ; "That is wonderful! I can always use Grue Goo in my experiments! Thank you!"
					)
				)
				(24 ; theFlask
					(gEgo use: 9 1) ; theFlask
					(super doVerb: theVerb &rest)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance craniumZap of Prop
	(properties
		x 171
		y 137
		priority 166
		fixPriority 1
		view 378
		signal 16385
	)
)

(instance onceIncidental of Prop
	(properties
		fixPriority 1
		view 370
		signal 16385
	)
)

(instance seqIncidental of Prop
	(properties
		fixPriority 1
		view 370
		signal 16385
	)
)

(instance fire of Prop
	(properties
		noun 9
		x 95
		y 157
		fixPriority 1
		view 370
		loop 7
		signal 16385
		cycleSpeed 10
		detailLevel 2
	)
)

(instance table of Feature
	(properties
		noun 2
		nsLeft 124
		nsTop 134
		nsRight 179
		nsBottom 173
		sightAngle 180
		x 151
		y 173
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (== (slab cel:) 1)) ; Look
			(gMessager say: 2 1 89) ; "Could it be? Has Dr. Cranium at last succeeded in the ancient dream of bringing back life to the dead?"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance skull of Feature
	(properties
		noun 3
		nsLeft 205
		nsTop 166
		nsRight 250
		nsBottom 189
		sightAngle 180
		x 227
		y 189
	)
)

(instance books of Feature
	(properties
		noun 4
		nsLeft 228
		nsTop 145
		nsRight 289
		nsBottom 189
		sightAngle 180
		x 258
		y 189
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (& gMsgType $0001)
					(= local5 1)
				else
					(|= gMsgType $0001)
				)
				(if (& gMsgType $0002)
					(^= gMsgType $0002)
					(= local6 1)
				)
				(proc0_17 4 1 0 0)
				(if (not local5)
					(^= gMsgType $0001)
				)
				(if local6
					(|= gMsgType $0002)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rayGun of Feature
	(properties
		noun 5
		nsLeft 84
		nsTop 5
		nsRight 148
		nsBottom 89
		sightAngle 180
		x 116
		y 89
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 100 30 116 28 127 31 135 43 147 89 139 91 122 70 111 67 107 57 94 51 91 40 94 35
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance boiler of Feature
	(properties
		noun 6
		nsLeft 197
		nsTop 8
		nsRight 251
		nsBottom 70
		sightAngle 180
		x 224
		y 70
	)
)

(instance boilerChain of Feature
	(properties
		noun 7
		nsLeft 191
		nsTop 29
		nsRight 204
		nsBottom 106
		sightAngle 180
		x 197
		y 106
	)
)

(instance eyeBeaker of Feature
	(properties
		noun 8
		nsLeft 291
		nsTop 95
		nsRight 319
		nsBottom 146
		sightAngle 180
		x 305
		y 146
	)
)

(instance hearth of Feature
	(properties
		noun 9
		nsLeft 70
		nsTop 119
		nsRight 92
		nsBottom 161
		sightAngle 180
		x 81
		y 161
	)
)

(instance tower of Feature
	(properties
		nsLeft 35
		nsTop 46
		nsRight 71
		nsBottom 148
		sightAngle 180
		x 53
		y 148
	)
)

(instance bottles of Feature
	(properties
		noun 11
		nsLeft 155
		nsTop 80
		nsRight 185
		nsBottom 93
		sightAngle 180
		x 170
		y 93
	)
)

(instance experiment of Feature
	(properties
		noun 12
		nsLeft 209
		nsTop 87
		nsRight 285
		nsBottom 136
		sightAngle 180
		x 247
		y 136
	)
)

(instance globes of Feature
	(properties
		noun 13
		nsLeft 262
		nsRight 319
		nsBottom 73
		sightAngle 180
		x 290
		y 73
	)
)

(instance still of Feature
	(properties
		noun 14
		nsLeft 2
		nsRight 115
		nsBottom 189
		sightAngle 180
		x 58
		y 189
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 40 0 39 11 17 31 19 55 28 65 33 132 82 160 81 154 91 152 102 175 110 178 117 189 0 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance gargoyle of Feature
	(properties
		noun 15
		nsLeft 147
		nsTop 102
		nsRight 190
		nsBottom 122
		sightAngle 180
		x 168
		y 122
	)
)

