;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	local0
)

(instance rm390 of Rm
	(properties
		noun 3
		picture 390
		horizon 65
	)

	(method (cue)
		(self setScript: runeAppears)
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable: 9)
		(gEgo
			x: 190
			y: 250
			setScale: Scaler 100 65 128 50
			actions: egoActions
			init:
			normalize:
		)
		(super init:)
		(gLongSong number: 390 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 155 140 179 143 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 147 290 149 229 133 148 138 122 127 81 115 78 104 58 92 100 89 214 86 283 87 277 91 248 97 286 107 319 104
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 62 319 88 306 86 289 81 280 72 229 69 232 62
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 164 76 148 81 100 85 64 83 52 89 0 99 0 67 162 67
					yourself:
				)
		)
		(gLongSong3 number: 391 setLoop: -1 play: 127)
		(peacePool init:)
		(mountains init:)
		(trees init:)
		(rocks init:)
		(fountain setCycle: Fwd init:)
		(leftRip setCycle: Fwd init:)
		(rightRip setCycle: Fwd init:)
		(theMoon init: setPri: 1)
		(if (not gNight)
			(cheetahBody init: approachVerbs: 4 addToPic:) ; Do
			(cheetahHead init: approachVerbs: 4) ; Do
			(cheetahTail
				setCycle: OccasionalCycle self 1 20 200
				init:
				approachVerbs: 4 ; Do
			)
		)
		(gEgo setScript: egoEnters)
		(if (and (not gNight) (not (IsFlag 98)))
			(gCurRoom setScript: impalaDrinks)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(88 ; lightningBallSpell
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(83 ; forceBoltSpell
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(20 ; theDaggers
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(11 ; theSword
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(12 ; theFineDagger
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(56 ; theMagicSpear
				(gMessager say: 4 6 1) ; "A feeling of peace fills you, and you relax."
			)
			(76 ; detectMagicSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 12 0) self 76) ; castAreaScript
				else
					(gMessager say: 4 6 9) ; "Your attention is on other things at the moment."
				)
			)
			(74 ; Sleep
				(if (not (gCurRoom script:))
					(gEgo code: 0)
					(self setScript: goToBed)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gLongSong3 stop:)
		(super dispose:)
	)
)

(instance runeAppears of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 3 76 0 0 self) ; "There is a strong aura of magic here, particularly near the large rock."
			)
			(1
				(rune init: setPri: 14 cycleSpeed: 4 setCycle: Fwd)
				(HandsOn)
				(gLongSong3 number: 391 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 179 168 self)
			)
			(1
				(gEgo view: 35 loop: 0 cel: 0 x: 198 setCycle: End self)
			)
			(2
				(if (= temp0 (PalVary pvGET_CURRENT_STEP))
					(if (< temp0 64)
						(PalVary pvCHANGE_TICKS 3)
						(= seconds 5)
					else
						(self cue:)
					)
				else
					(PalVary pvINIT 310 3)
					(SetFlag 81)
					(= seconds 5)
				)
			)
			(3
				(theMoon moveSpeed: 4 setMotion: MoveTo 335 15 self)
			)
			(4
				(PalVary pvREVERSE 3)
				(ClearFlag 81)
				(= seconds 4)
			)
			(5
				((ScriptID 7 7) init: 5 40) ; egoSleeps
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					normalize: 6
					cel: 6
					x: 179
					changeGait: 0 ; walking
					code: outCheck
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 92 119 self)
			)
			(1
				(gEgo view: 4 loop: 0 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(2
				(switch local0
					(0
						(gMessager say: 1 4) ; "You drink from the cold, clear water. It has a slightly sweet taste, and tingles in your mouth."
						(= [gEgoStats 17] (gEgo maxStamina:)) ; stamina
					)
					(1
						(gMessager say: 1 25) ; "You fill your waterskin from the pool."
						(gEgo get: 37 drop: 15 1 solvePuzzle: 258 3) ; thePeaceWater, theWaterskin
					)
					(2
						(if gNight
							(if (not (IsFlag 259))
								(gMessager say: 1 50 5) ; "As you dip the orchid in the water, it starts to glow with an azure light."
								((gInventory at: 39) state: 1 cel: 7) ; theOrchid
								(Cursor cel: 7)
							)
							(gEgo solvePuzzle: 259 6 2)
						else
							(gMessager say: 1 50 6) ; "You get the orchid wet, but nothing much happens. Are you doing this right?"
						)
					)
				)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(gLongSong3 number: 391 setLoop: -1 play:)
				(= local0 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 190 y: 250 init: setMotion: MoveTo 190 180 self)
			)
			(1
				(gMessager say: 4 6 4 0 self) ; "As you approach this pool of bubbling water, you feel a sense of serenity and peace."
			)
			(2
				(if gNight
					(gMessager say: 4 6 8 0 self) ; "The moon on the waters of the pool creates a shimmering effect."
				else
					(self cue:)
				)
			)
			(3
				(gEgo code: outCheck)
				(gTheIconBar enable: 9)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance impalaDrinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 98)
				(impala init:)
				(= seconds 6)
			)
			(1
				(impala loop: 1 setCycle: End)
				(= seconds 7)
			)
			(2
				(impala setLoop: 3 setCycle: Fwd setMotion: MoveTo 330 90 self)
			)
			(3
				(impala dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theMoon of Actor
	(properties
		x -10
		y 15
		noun 10
		view 393
		signal 24576
	)
)

(instance impala of Actor
	(properties
		x 255
		y 92
		noun 8
		view 392
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance cheetahBody of View
	(properties
		x 116
		y 62
		noun 7
		approachX 111
		approachY 85
		view 391
		loop 1
		priority 4
		signal 16405
	)
)

(instance cheetahHead of Prop
	(properties
		x 114
		y 62
		noun 7
		approachX 111
		approachY 85
		view 391
		priority 4
		signal 16
	)

	(method (doit)
		(cond
			((< (gEgo x:) 106)
				(self cel: 0)
			)
			((< (gEgo x:) 212)
				(self cel: 1)
			)
			(else
				(self cel: 2)
			)
		)
		(super doit: &rest)
	)
)

(instance cheetahTail of Prop
	(properties
		x 104
		y 58
		noun 7
		approachX 111
		approachY 85
		view 391
		loop 2
		priority 4
		signal 16
		detailLevel 3
	)
)

(instance fountain of Prop
	(properties
		x 163
		y 113
		noun 1
		view 390
		loop 2
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb)
		(peacePool doVerb: theVerb)
	)
)

(instance rune of Prop
	(properties
		x 81
		y 49
		noun 5
		view 393
		loop 3
		signal 16384
	)
)

(instance leftRip of Prop
	(properties
		x 129
		y 106
		noun 1
		view 390
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb)
		(peacePool doVerb: theVerb)
	)
)

(instance rightRip of Prop
	(properties
		x 193
		y 105
		noun 1
		view 390
		loop 1
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb)
		(peacePool doVerb: theVerb)
	)
)

(instance mountains of Feature
	(properties
		x 164
		y 30
		noun 2
		nsTop 24
		nsLeft 126
		nsBottom 37
		nsRight 203
		sightAngle 180
	)
)

(instance rocks of Feature
	(properties
		x 84
		y 58
		noun 9
		nsTop 41
		nsLeft 60
		nsBottom 76
		nsRight 109
		sightAngle 180
	)
)

(instance trees of Feature
	(properties
		x 32
		y 88
		noun 6
		nsBottom 177
		nsRight 65
		sightAngle 180
	)
)

(instance peacePool of Feature
	(properties
		x 180
		y 18
		noun 1
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; theWaterskin
				(= local0 1)
				(gEgo setScript: getWater)
			)
			(50 ; theOrchid
				(= local0 2)
				(gEgo setScript: getWater)
			)
			(4 ; Do
				(= local0 0)
				(gEgo setScript: getWater)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance outCheck of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(if (GameIsRestarting)
			(gLongSong3 number: 391 setLoop: -1 play:)
		)
		(= temp0 gDay)
		(if (or (!= gTimeOfDay 6) (> gClock 500))
			(++ temp0)
		)
		(if
			(or
				(and (< (= temp2 gClock) 601) (> temp2 -1))
				(and (> temp2 2999) (< temp2 3601))
			)
			(if (and (< temp2 601) (> temp2 -1))
				(theMoon x: (+ 180 (/ temp2 5)))
			else
				(theMoon x: (+ 60 (/ (- temp2 3000) 5)))
			)
		else
			(theMoon x: -50)
		)
		(if (gEgo edgeHit:)
			(gCurRoom newRoom: 160)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

