;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	rm355 0
	impoundTalker 1
)

(local
	local0
)

(instance rm355 of Room
	(properties
		noun 14
		picture 355
	)

	(method (init)
		(proc0_4 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 36 154 267 154 281 127 281 115 268 125 182 117 136 111 36 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 112 122 148 122 148 134 112 134
					yourself:
				)
		)
		(super init: &rest)
		(gGlobalSound0 number: 1028 loop: -1 play:)
		(theWindow init: approachVerbs: 2 27) ; Talk, badge
		(topSign init:)
		(bottomSign init:)
		(bBoard1 init:)
		(bBoard2 init:)
		(wallSign init:)
		(wallSign2 init:)
		(wallSign3 init:)
		(wallSign4 init:)
		(opening init:)
		(sidewalk init:)
		(building init:)
		(tree init:)
		(switch gPrevRoomNum
			(360
				(gEgo posn: 245 144 setHeading: 270)
			)
			(else
				(gEgo posn: 70 144 setHeading: 90)
				(gPqFlags clear: 39)
				(gPqFlags clear: 44)
			)
		)
		(gEgo setScaler: Scaler 100 75 147 112)
		(gEgo normalize: 0 init: setScript: playSounds)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((< (gEgo x:) 37)
				(self setScript: comeBack)
			)
			((> (gEgo y:) 153)
				(gGlobalSound0 fade:)
				(self newRoom: 17) ; MapRoom
			)
			(
				(and
					(> (gEgo x:) 278)
					(< (gEgo y:) 123)
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
				)
				(self setScript: dogBarks)
			)
			((and (> (gEgo x:) 278) (< (gEgo y:) 123))
				(self newRoom: 360)
			)
		)
	)

	(method (dispose)
		(gGlobalSound1 client: 0 stop:)
		(super dispose:)
	)
)

(instance dogBarks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dogSound number: 995 loop: 1 play:)
				(= ticks 10)
			)
			(1
				(gEgo
					setSpeed: (if (> (gEgo moveSpeed:) 3) 3 else 0)
					setMotion: PolyPath 235 130 self
				)
			)
			(2
				(gMessager say: 0 78 0 0 self) ; "This place must have a guard dog on duty when they're closed!"
			)
			(3
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance comeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(walkSound number: 905 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(gEgo
					setSpeed: (if (> (gEgo moveSpeed:) 3) 3 else 0)
					setMotion: PolyPath 75 (gEgo y:) self
				)
			)
			(2
				(gMessager say: 14 75 0 0 self) ; "Getting run over wouldn't help your case, Detective."
			)
			(3
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bendWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo view: 5 loop: 8 cel: 0)
				(UpdateScreenItem gEgo)
				(= cycles 1)
			)
			(2
				(if (== register 9356)
					(Load rsVIEW 9356)
				else
					(Load rsVIEW 9355)
				)
				(gEgo
					setSpeed: 6
					view: (if register 9356 else 9355)
					loop: 0
					cel: 0
					x: (- (gEgo x:) 0)
					setCycle: End self
				)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: Osc 2 self)
			)
			(4
				(= cycles 1)
			)
			(5
				(cond
					((gPqFlags test: 44)
						(if local0
							(= cycles 1)
						else
							(gMessager say: 1 2 5 1 self) ; "I'm finished, for now. Thank you..."
						)
					)
					((gPqFlags test: 39)
						(= cycles 1)
					)
					((== gDay 4)
						(gMessager say: 1 2 6 1 self) ; "Hello, I'm Detective Carey, Homicide, LAPD. I'd like to take a look at the patrol car that was brought in."
					)
					(else
						(gMessager say: 1 2 9 1 self) ; "Hello, I'm Detective Carey, Homicide, LAPD. I'd like to take a look at the abandoned car that was brought in."
					)
				)
			)
			(6
				(cond
					(register
						(gMessager
							say:
								1
								27
								(switch gDay
									(4 1)
									(5
										(if (gPqFlags test: 90) 2 else 3)
									)
									(else 1)
								)
								0
								self
						)
					)
					((gPqFlags test: 44)
						(if (not local0)
							(++ local0)
							(gMessager say: 1 2 5 2 self) ; ""Heh, heh, sure, pal... see ya later, heh, heh..."."
						else
							(gMessager sayRandom: 1 2 4 self)
						)
					)
					((gPqFlags test: 39)
						(gMessager sayRandom: 1 2 4 self)
					)
					(else
						(gMessager sayRange: 1 2 6 2 4 self) ; "Heh, heh, I don't recognize you pal. Can't let you in, that car's part of an investigation."
					)
				)
			)
			(7
				(gEgo loop: 0)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(8
				(gEgo x: (+ (gEgo x:) 0) heading: 315 normalize: 0)
				(= register 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 300 480))
			)
			(1
				(gGlobalSound1 number: (+ 900 (Random 5 7)) loop: 1 play: self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance theWindow of Feature
	(properties
		noun 1
		nsLeft 87
		nsTop 45
		nsRight 112
		nsBottom 85
		sightAngle 90
		approachX 115
		approachY 118
		approachDist 10
		x 93
		y 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: 1 2 7 1) ; "There's no one here to talk to. The office is closed."
				else
					(gCurRoom setScript: bendWindow)
				)
			)
			(1 ; Look
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: 1 1 7 1) ; "The window is shut. It appears the office is closed."
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: noun theVerb 7 1) ; "The window is shut. The office is closed."
				else
					(super doVerb: theVerb)
				)
			)
			(47 ; handcuffs
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: noun theVerb 7 1) ; "What are you attempting to do? The office is closed."
				else
					(super doVerb: theVerb)
				)
			)
			(22 ; handgun
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: noun theVerb 7 1) ; "Holster your weapon, this is no way to vent frustration!"
				else
					(super doVerb: theVerb)
				)
			)
			(63 ; casePryBar
				(if
					(or
						(and (gPqFlags test: 165) (== gDay 4))
						(and
							(gPqFlags test: 91)
							(== gDay 5)
							(!= gPrevRoomNum 360)
						)
					)
					(gMessager say: noun theVerb 7 1) ; "That would be breaking and entering. And it would also be criminal."
				else
					(super doVerb: theVerb)
				)
			)
			(27 ; badge
				(cond
					(
						(or
							(and (gPqFlags test: 165) (== gDay 4))
							(and
								(gPqFlags test: 91)
								(== gDay 5)
								(!= gPrevRoomNum 360)
							)
						)
						(gMessager say: 1 1 7 1) ; "The window is shut. It appears the office is closed."
					)
					((gPqFlags test: 39)
						(gMessager say: 1 theVerb 8 0) ; "You've already identified yourself. No need to do it again."
					)
					(else
						(gPqFlags set: 39)
						(switch gDay
							(4
								(gGame points: 2 56)
							)
							(5
								(gGame points: 2 57)
							)
						)
						(gCurRoom setScript: bendWindow 0 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomSign of Feature
	(properties
		noun 8
		nsLeft 87
		nsTop 37
		nsRight 112
		nsBottom 44
		approachX 99
		approachY 40
		x 99
		y 40
	)
)

(instance topSign of Feature
	(properties
		noun 7
		nsLeft 90
		nsTop 86
		nsRight 112
		nsBottom 93
		approachX 101
		approachY 89
		x 101
		y 89
	)
)

(instance bBoard1 of Feature
	(properties
		noun 9
		nsLeft 115
		nsTop 54
		nsRight 123
		nsBottom 92
		approachX 119
		approachY 73
		x 119
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager sayRandom: noun theVerb 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bBoard2 of Feature
	(properties
		noun 9
		nsLeft 128
		nsTop 55
		nsRight 138
		nsBottom 89
		approachX 133
		approachY 72
		x 133
		y 72
	)

	(method (doVerb theVerb)
		(bBoard1 doVerb: theVerb)
	)
)

(instance wallSign4 of Feature
	(properties
		noun 12
		nsLeft 142
		nsTop 60
		nsRight 149
		nsBottom 68
		x 142
		y 68
	)
)

(instance wallSign2 of Feature
	(properties
		noun 10
		nsLeft 150
		nsTop 42
		nsRight 169
		nsBottom 52
		x 160
		y 52
	)
)

(instance wallSign3 of Feature
	(properties
		noun 11
		nsLeft 170
		nsTop 40
		nsRight 184
		nsBottom 51
		x 170
		y 51
	)
)

(instance wallSign of Feature
	(properties
		noun 6
		nsLeft 151
		nsTop 56
		nsRight 181
		nsBottom 77
		x 165
		y 77
	)
)

(instance opening of Feature
	(properties
		noun 13
		nsLeft 267
		nsTop 52
		nsRight 278
		nsBottom 119
		x 267
		y 119
	)
)

(instance building of Feature
	(properties
		noun 2
		x 50
		y 30
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 41 10 207 10 207 16 208 25 204 30 202 35 141 31 137 106 41 122
				yourself:
			)
		)
	)
)

(instance sidewalk of Feature
	(properties
		noun 4
		x 150
		y 147
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 41 122 121 110 121 128 129 128 129 108 136 108 279 121 279 147 41 147
					yourself:
				)
		)
	)
)

(instance tree of Feature
	(properties
		noun 5
		x 215
		y 10
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 239 114 241 103 242 71 243 64 239 60 233 65 227 65 223 60 219 53 214 47 214 41 210 39 209 36 204 36 203 33 212 32 213 27 211 24 210 18 211 14 215 10 279 10 279 36 271 42 254 59 254 65 251 82 249 119 239 119
				yourself:
			)
		)
	)
)

(instance impoundTalker of Narrator
	(properties
		x 10
		y 15
	)
)

(instance walkSound of Sound
	(properties)
)

(instance dogSound of Sound
	(properties)
)

