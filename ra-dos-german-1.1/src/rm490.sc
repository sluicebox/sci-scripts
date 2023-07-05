;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use Inset)
(use PChase)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm490 0
)

(local
	local0
	local1
)

(instance rm490 of LBRoom
	(properties
		noun 5
		picture 490
		east 440
		south 440
		west 440
		vanishingX 150
		vanishingY 100
	)

	(method (init)
		(LoadMany rsVIEW 491 424 423 818 426 831)
		(LoadMany rsSOUND 490 1)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 160 40 190 100
		)
		(if (== gAct 5)
			(self setRegions: 94) ; PursuitRgn
			(gCurRoom obstacles: (List new:))
			((ScriptID 2490 0) doit: (gCurRoom obstacles:)) ; poly2490Code
		else
			(self setRegions: 90) ; MuseumRgn
		)
		(switch gPrevRoomNum
			(south
				(self setScript: sEnterSouth)
			)
			(else
				(gEgo posn: 160 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (IsFlag 143)
			(if (IsFlag 37)
				(zHead
					loop: 2
					cel: 1
					x: 231
					y: 133
					approachVerbs: 4 1 8 ; Do, Look, magnifier
					init:
					setPri: 10
					approachX: 213
					approachY: 135
				)
				(self
					addObstacle:
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 252 133 236 143 201 132 227 130
								yourself:
							)
						)
				)
			else
				(zHead approachVerbs: 4 1 8 init:) ; Do, Look, magnifier
			)
		)
		(southExitFeature init:)
		(westExitFeature init:)
		(eastExitFeature init:)
		(genericHead init:)
		(floor init:)
		(if (== gAct 5)
			(oriley init: setCycle: Walk setScale: Scaler 160 40 190 80)
		)
	)

	(method (newRoom)
		(if (IsObject local0)
			((gCurRoom obstacles:) delete: local0)
			(local0 dispose:)
		)
		(super newRoom: &rest)
	)

	(method (dispose)
		(DisposeScript 2490)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(gCurRoom setScript: sExitSouth)
			)
		)
	)

	(method (notify)
		(if (== gAct 5)
			(if (gCurRoom script:)
				((gCurRoom script:) next: sKillHer)
			else
				(gCurRoom setScript: sKillHer)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 320 190
					setHeading: 315
					setMotion: MoveFwd 40 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(cond
					((> (gEgo x:) 310)
						(gEgo setHeading: 90)
					)
					((< (gEgo x:) 20)
						(gEgo setHeading: 270)
					)
					(else
						(gEgo setHeading: 180)
					)
				)
				(gEgo setMotion: MoveFwd 100 self)
			)
			(2
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance sOhNoMurder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (not (TimeCheck $b102)) ; has 11:15 pm occurred?
					((ScriptID 22 0) doit: $b102 self) ; triggerAndClock, 11:15 pm
				else
					(= cycles 1)
				)
			)
			(2
				(WrapMusic pause: 1)
				(sWrapMusic init: -1 1 6)
				(= cycles 3)
			)
			(3
				(gCurRoom setInset: inHead)
				(= seconds 3)
			)
			(4
				(inHead setInset: inReaction)
				(noise number: 82 flags: 5 loop: 1 play: self)
				(= local1 1)
			)
			(5
				(inReaction dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKillHer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 186 150 self)
			)
			(2
				(gGameMusic1 number: 3 loop: 1 flags: 1 play:)
				(oriley
					moveSpeed: 4
					cycleSpeed: 4
					setMotion: PChase gEgo 25 self
				)
			)
			(3
				(Face gEgo oriley)
				(oriley view: 424 cel: 0 setCycle: End self)
			)
			(4
				(noise number: 80 flags: 5 loop: 1 play:)
				(gEgo view: 858 setCycle: End self)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance sGetHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom
					addObstacle:
						(= local0
							((Polygon new:)
								type: PBarredAccess
								init: 252 133 236 143 201 132 227 130
								yourself:
							)
						)
				)
				(zHead loop: 1 setCycle: End self)
			)
			(2
				(zHead setLoop: 2 cel: 2 posn: 211 131 setCycle: End self)
				(noise number: 490 flags: 5 play:)
			)
			(3
				(zHead setCycle: End self setMotion: MoveTo 231 133)
			)
			(4
				(zHead setCycle: CT 1 1 self)
			)
			(5
				(SetFlag 37)
				(zHead approachX: 213 approachY: 135 setCycle: 0 setPri: 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTheyComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sWrapMusic dispose: 1)
				(= cycles 1)
			)
			(1
				(localSound dispose:)
				((ScriptID 32 0) ; aHeimlich
					room: 490
					init:
					view: 814
					x: 253
					y: 240
					setCycle: Walk
					setMotion: MoveTo 249 145 self
				)
				(= register ((ScriptID 90 3) room:)) ; aORiley
				((ScriptID 90 3) ; aORiley
					moveTo: 490
					view: 818
					x: 280
					y: 240
					setMotion: MoveTo 290 141 self
				)
				(gGameMusic2 number: 350 flags: 1 loop: -1 play:)
			)
			(2 0)
			(3
				((ScriptID 32 0) setCycle: StopWalk -1) ; aHeimlich
				((ScriptID 90 3) loop: 7) ; aORiley
				(= cycles 1)
			)
			(4
				(Face gEgo (ScriptID 90 3)) ; aORiley
				(= cycles 5)
			)
			(5
				(gMessager say: 1 0 1 0 self 1490) ; "Was ist going on in here!"
			)
			(6
				((ScriptID 32 0) ; aHeimlich
					setCycle: Walk
					setMotion: PolyPath 275 300 self
				)
				((ScriptID 90 3) setMotion: PolyPath 302 300 self) ; aORiley
			)
			(7
				0
				(gGameMusic2 fade:)
				(WrapMusic pause: 0)
				((ScriptID 90 3) moveTo: register) ; aORiley
				(gGame handsOn:)
				(gGame points: 1 144)
				(SetFlag 36)
				(self dispose:)
			)
		)
	)
)

(instance sExamineHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WrapMusic pause: 1)
				(if (not (== gAct 5))
					(mExamineMusic play:)
				)
				(gCurRoom setInset: inHead self)
			)
			(1
				(mExamineMusic dispose:)
				(WrapMusic pause: 0)
				(self dispose:)
			)
		)
	)
)

(instance oriley of Actor
	(properties
		x 150
		y 300
		view 423
	)
)

(instance zHead of Actor
	(properties
		x 190
		y 87
		noun 1
		approachX 189
		approachY 135
		view 491
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== gAct 5)
			(gMessager say: 36 0 0 0) ; "You don't have time for that now!"
		else
			(switch theVerb
				(1 ; Look
					(if (IsFlag 36)
						(gCurRoom setScript: sExamineHead)
					else
						(gCurRoom setScript: sOhNoMurder)
					)
				)
				(8 ; magnifier
					(self doVerb: 1)
				)
				(4 ; Do
					(cond
						((IsFlag 37)
							(gMessager say: 1 4 1) ; "You don't want to tamper with the evidence, so you leave it where it is."
						)
						((not (IsFlag 36))
							(gMessager say: 1 4 2) ; "You reach for the head, then hesitate. Something is not quite right here. You wonder if you should take a closer look first..."
						)
						(else
							(gCurRoom setScript: sGetHead)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance floor of Feature
	(properties
		onMeCheck 16386
	)
)

(instance inHead of Inset
	(properties
		picture 495
		hideTheCast 1
		disposeNotOnMe 1
		noun 6
	)

	(method (init)
		(gEgo hide:)
		(zHead hide:)
		(super init: &rest)
		(gGame points: 1 144)
		(proc0_8 1)
	)

	(method (dispose)
		(gEgo show:)
		(zHead show:)
		(proc0_8 0)
		(if (not (IsFlag 36))
			(gCurRoom setScript: sTheyComeIn)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(inHead dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inReaction of Inset
	(properties
		picture 555
		hideTheCast 1
		disposeNotOnMe 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 35
	)
)

(instance eastExitFeature of ExitFeature
	(properties
		nsTop 133
		nsLeft 314
		nsBottom 189
		nsRight 319
		cursor 14
		exitDir 2
		noun 35
	)
)

(instance westExitFeature of ExitFeature
	(properties
		nsTop 147
		nsBottom 189
		nsRight 5
		cursor 12
		exitDir 3
		noun 35
	)
)

(instance genericHead of Feature
	(properties
		y 5
		sightAngle 40
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(cond
					((and (<= 59 gMouseX 74) (<= 68 gMouseY 82))
						(= noun 2)
					)
					((and (<= 39 gMouseX 56) (<= 47 gMouseY 65))
						(= noun 9)
					)
					((and (<= 136 gMouseX 147) (<= 87 gMouseY 99))
						(= noun 19)
					)
					((and (<= 152 gMouseX 163) (<= 91 gMouseY 101))
						(= noun 20)
					)
					((and (<= 63 gMouseX 80) (<= 108 gMouseY 125))
						(= noun 14)
					)
					((and (<= 276 gMouseX 294) (<= 74 gMouseY 91))
						(= noun 31)
					)
					((and (<= 182 gMouseX 195) (<= 112 gMouseY 124))
						(= noun 27)
					)
					((and (<= 146 gMouseX 152) (<= 101 gMouseY 113))
						(= noun 3)
					)
					((and (<= 88 gMouseX 102) (<= 107 gMouseY 122))
						(= noun 15)
					)
					((and (<= 133 gMouseX 146) (<= 68 gMouseY 84))
						(= noun 4)
					)
					((and (<= 74 gMouseX 91) (<= 61 gMouseY 76))
						(= noun 16)
					)
					((and (<= 139 gMouseX 150) (<= 113 gMouseY 125))
						(= noun 10)
					)
					((and (<= 177 gMouseX 184) (<= 85 gMouseY 96))
						(= noun 26)
					)
					((and (<= 243 gMouseX 262) (<= 75 gMouseY 93))
						(= noun 30)
					)
					((and (<= 89 gMouseX 101) (<= 53 gMouseY 66))
						(= noun 17)
					)
					((and (<= 165 gMouseX 176) (<= 93 gMouseY 103))
						(= noun 23)
					)
					((and (<= 185 gMouseX 195) (<= 89 gMouseY 99))
						(= noun 25)
					)
					((and (<= 279 gMouseX 294) (<= 102 gMouseY 119))
						(= noun 24)
					)
					((and (<= 153 gMouseX 163) (<= 104 gMouseY 114))
						(= noun 18)
					)
					((and (<= 312 gMouseX 319) (<= 73 gMouseY 88))
						(= noun 29)
					)
					((and (<= 68 gMouseX 88) (<= 88 gMouseY 104))
						(= noun 12)
					)
					((and (<= 245 gMouseX 261) (<= 101 gMouseY 117))
						(= noun 28)
					)
					((and (<= 148 gMouseX 156) (<= 78 gMouseY 89))
						(= noun 21)
					)
					((and (<= 159 gMouseX 169) (<= 81 gMouseY 93))
						(= noun 22)
					)
					((and (<= 134 gMouseX 145) (<= 99 gMouseY 112))
						(= noun 11)
					)
					((and (<= 313 gMouseX 319) (<= 103 gMouseY 118))
						(= noun 33)
					)
					((and (<= 178 gMouseX 188) (<= 97 gMouseY 109))
						(= noun 32)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 13 4) ; "The head is attractive, but you'd never stoop to stealing."
			)
			(8 ; magnifier
				(gMessager say: 13 8) ; "What fine craftsmanship!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance noise of Sound
	(properties
		flags 1
	)
)

(instance mExamineMusic of Sound
	(properties
		flags 1
		number 6
		loop -1
	)
)

(instance sWrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound localSound)
		(super init: &rest)
	)
)

(instance localSound of Sound
	(properties)
)

