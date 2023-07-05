;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	local0
)

(instance rm670 of Room
	(properties
		picture 670
	)

	(method (init)
		(if (== gPrevRoomNum 671)
			(gTheIconBar disable:)
		)
		(gGame intensity: 0)
		(gPqFlags set: 118)
		(if (== gPrevRoomNum 671)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 277 122 319 132 319 114 308 112
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 12 97 129 93 319 128 319 117 128 88 12 91
						yourself:
					)
			)
		)
		(leftDoor init: approachVerbs: 4) ; Do
		(rightDoor init: approachVerbs: 4 80) ; Do, skeletonKey
		(screen init:)
		(seats init:)
		(gTheCursor show:)
		(super init: &rest)
		(self setScript: enterScr)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((and (gEgo mover:) (== gPrevRoomNum 671))
				(gCurRoom setScript: exitScript)
			)
			((> (gEgo x:) 302)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance msMitchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global144 2)
				(gPqFlags set: 135)
				(= local0 1)
				(= cycles 2)
			)
			(1
				(msMitch setCycle: Walk setMotion: MoveTo 44 92 self)
			)
			(2
				(gEgo
					setScaler: Scaler 66 30 131 93
					posn: 332 125
					normalize: 0
					init:
					setMotion: MoveTo 302 125 self
				)
				(msMitch setMotion: MoveTo -20 92 self)
			)
			(3
				(gGame handsOn:)
			)
			(4
				(msMitch dispose:)
				(self dispose:)
			)
		)
	)
)

(instance badgeMitchScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(gGame handsOff:)
			)
			(1
				((ScriptID 38 0) init: self) ; BadgeOut
			)
			(2
				(gMessager say: 6 27 3 0 self) ; "Detective Carey, LADP, Halt!"
			)
			(3
				(= cycles 2)
			)
			(4
				((ScriptID 38 1) init: self) ; BadgeIn
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 302 125 self)
			)
			(2
				(if (and (== gDay 6) (not global144))
					(= global144 1)
				)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance startDreamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 257 121 self)
			)
			(2
				(gEgo setMotion: MoveTo 242 121 self)
			)
			(3
				(gEgo setHeading: 315 self)
			)
			(4
				(altEgo
					view: 9058
					loop: 1
					cel: 0
					x: 238
					y: 124
					scaleSignal: 1
					scaleX: 84
					scaleY: 84
					init:
					signal: (| (altEgo signal:) $4000)
					setCycle: End self
				)
				(gEgo z: 1000)
			)
			(5
				(= ticks 180)
			)
			(6
				(movieLight init: setCycle: Fwd)
				(movie cycleSpeed: 3 init: setCycle: End)
				(self setScript: fadeDown self)
				(gGlobalSound0 fade: 0 3 2 1)
			)
			(7
				(movie dispose:)
				(movieLight dispose:)
				(gGame fadeSpeed: 100)
				(gCurRoom newRoom: 671)
			)
		)
	)
)

(instance fadeDown of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 100)
	)

	(method (doit)
		(if register
			(-= register 2)
			(Palette 2 0 239 register) ; PalIntensity
			(FrameOut)
		else
			(self dispose:)
		)
	)
)

(instance movieLight of Prop
	(properties
		x 61
		y 45
		view 6701
		cycleSpeed 0
	)
)

(instance endDreamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: 670 loop: 1 play:)
				(gTheIconBar enable:)
				(= cycles 2)
			)
			(1
				(mitchell setCycle: End self)
			)
			(2
				(mitchell cel: 0 loop: 1 setCycle: CT 13 1 self)
			)
			(3
				(gMessager say: 6 0 1 0 self) ; ""Wa..wa..Wake up! Wa..ke up! Yoo... you f..f.fell a..a..sleep! Ti..time to... to gg..go! Nnn..Now!"
			)
			(4
				(= ticks 120)
			)
			(5
				(altEgo setCycle: Beg self)
			)
			(6
				(gEgo z: 0 normalize: 0)
				(altEgo dispose:)
				(= cycles 2)
			)
			(7
				(gEgo setMotion: MoveTo 257 121 self)
			)
			(8
				(mitchell cel: 0 loop: 2 setCycle: End self)
			)
			(9
				(gEgo setMotion: MoveTo 285 120 self)
			)
			(10
				(gEgo setHeading: 315 self)
			)
			(11
				(mitchell view: 672 loop: 0 cel: 0 setCycle: End self)
			)
			(12
				(gMessager say: 6 2 7 0 self) ; ""G..go! Pl..please le..le..leave! Nnn..now!"
			)
			(13
				(gEgo setMotion: MoveTo 306 130 self)
			)
			(14
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance altEgo of Actor
	(properties)
)

(instance msMitch of Actor
	(properties
		noun 6
		x 64
		y 92
		view 674
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 3 0) ; "It's the woman of your, er, in your dream!"
			)
			(4 ; Do
				(gMessager say: 6 4 3 0) ; "Whomever it was, you were too late and too far away to stop her."
			)
			(22 ; handgun
				(gMessager say: 6 22 3 0) ; "There's no guarantee you'll mark your target given the proximity of the two bodies! Hold your fire!"
			)
			(27 ; badge
				(gCurRoom setScript: badgeMitchScr)
			)
			(2 ; Talk
				(gMessager say: 6 2 3 0) ; "LAPD! Halt!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mitchell of Actor
	(properties
		noun 6
		x 271
		y 119
		view 670
	)
)

(instance leftDoor of Feature
	(properties
		noun 4
		nsLeft 1
		nsTop 59
		nsRight 17
		nsBottom 90
		sightAngle 40
		approachX 11
		approachY 91
		approachDist 21
		x 9
		y 74
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 680)
			)
			(1 ; Look
				(cond
					((and (== gDay 6) (gPqFlags test: 135))
						(gMessager say: 4 1 4 0) ; "They're gone! They must be headed up the ladder."
					)
					((== gDay 6)
						(gMessager say: noun theVerb 6 0) ; "This door leads to the backstage area."
					)
					(else
						(gMessager say: 4 1 5 0) ; "There's a door leading to... who knows where?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightDoor of Feature
	(properties
		noun 5
		nsLeft 111
		nsTop 58
		nsRight 126
		nsBottom 83
		sightAngle 40
		approachX 123
		approachY 88
		approachDist 21
		x 118
		y 70
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; skeletonKey
				(gMessager say: noun theVerb 0 0) ; "The skeleton key fits into the keyhole and unlocks the door."
				(gGame handsOff:)
				(gGame points: 2)
				(gGame fadeSpeed: 1)
				(gCurRoom newRoom: 710)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance screen of Feature
	(properties
		noun 1
		nsLeft 13
		nsTop 12
		nsRight 111
		nsBottom 83
		sightAngle 40
		approachX 69
		approachY 90
		approachDist 46
		x 62
		y 47
	)
)

(instance seats of Feature
	(properties
		noun 2
		nsLeft 9
		nsTop 93
		nsRight 319
		nsBottom 151
		sightAngle 40
		x 164
		y 122
	)

	(method (init)
		(self createPoly: 21 88 131 84 319 106 319 151 20 152 1 142 1 114)
		(super init:)
	)
)

(instance movie of Prop
	(properties
		x 62
		y 44
		view 6702
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 0)
				(cond
					((== gPrevRoomNum 610)
						(cond
							(
								(and
									(gPqFlags test: 128)
									(not (gPqFlags test: 101))
								)
								(gGame handsOff:)
								(gEgo
									setScaler: Scaler 66 30 131 93
									posn: 302 125
									setHeading: 315
									init:
									normalize: 0
								)
								(= next startDreamScript)
								(= cycles 2)
							)
							((and (== gDay 6) (not (gPqFlags test: 135)))
								(msMitch
									scaleSignal: 1
									scaleX: 72
									scaleY: 72
									init:
								)
								(= next msMitchScript)
								(= cycles 2)
							)
							(else
								(gEgo
									setScaler: Scaler 66 30 131 93
									x: 302
									y: 125
									setHeading: 315
									normalize: 0
									init:
								)
								(= cycles 2)
							)
						)
					)
					((== gPrevRoomNum 680)
						(gEgo
							setScaler: Scaler 66 30 131 93
							posn: 11 91
							setHeading: 180
							init:
							normalize: 0
						)
						(= cycles 2)
					)
					((== gPrevRoomNum 671)
						(mitchell
							scaleSignal: 1
							scaleX: 111
							scaleY: 111
							init:
							signal: (| (mitchell signal:) $4000)
						)
						(altEgo
							view: 9058
							loop: 1
							scaleSignal: 1
							scaleX: 84
							scaleY: 84
							x: 238
							y: 124
						)
						(altEgo
							cel: (altEgo lastCel:)
							init:
							signal: (| (altEgo signal:) $4000)
						)
						(gEgo
							setScaler: Scaler 66 30 131 93
							x: 242
							y: 121
							z: 1000
							setHeading: 315
							init:
						)
						(= next endDreamScript)
						(= cycles 2)
					)
				)
			)
			(1
				(gGame intensity: 100 fade: 0 100 (gGame fadeSpeed:))
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

