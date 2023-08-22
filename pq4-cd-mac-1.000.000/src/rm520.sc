;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	local0
	local1
	local2
)

(instance rm520 of Room
	(properties
		noun 8
		picture 520
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(buttons init: approachVerbs: 4) ; Do
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 152 246 152 284 165 266 152 251 147 213 147 113 124 0 137
					yourself:
				)
		)
		(ashtray init: approachVerbs: 4) ; Do
		(vending init: approachVerbs: 4 29) ; Do, coins
		(if (IsHiRes)
			(hiResAshTray init:)
			(hiResCandy init:)
		)
		(elevator init:)
		(doors init:)
		(wall init:)
		(theSign init:)
		(otherElevator init:)
		(otherElevLight init:)
		(elevLight init:)
		(map init:)
		(super init: &rest)
		(self setScript: sEnter)
	)

	(method (newRoom newRoomNumber)
		(gEgo stopView: 5)
		(if (== newRoomNumber 510)
			(if (!= (gGlobalSound0 number:) 983)
				(gGlobalSound0 number: 983 loop: -1 play:)
			)
			(gGlobalSound1 stop:)
		)
		(if (== newRoomNumber 17) ; MapRoom
			(gEgo get: 43) ; parkerID
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if (and (!= script sEnter) (<= (gEgo x:) 5))
			(gCurRoom newRoom: 510)
			(return)
		)
	)
)

(instance elevator of Feature
	(properties
		noun 11
		nsLeft 252
		nsTop 33
		nsRight 288
		nsBottom 148
		sightAngle 40
		approachX 270
		approachY 90
		approachDist 0
		x 270
		y 90
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 252 147 253 138 253 33 288 29 287 145 267 152
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 22) ; Do, handgun
			(if (doors cel:)
				(gMessager say: noun theVerb 9 0)
			else
				(gMessager say: noun theVerb 0 0)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance otherElevator of Feature
	(properties
		noun 4
		nsLeft 154
		nsTop 42
		nsRight 172
		nsBottom 124
		x 161
		y 124
	)
)

(instance otherElevLight of Feature
	(properties
		noun 10
		nsLeft 148
		nsTop 22
		nsRight 155
		nsBottom 31
		x 151
		y 31
	)
)

(instance buttons of Feature
	(properties
		noun 3
		nsLeft 192
		nsTop 79
		nsRight 199
		nsBottom 94
		sightAngle 40
		approachX 194
		approachY 140
		approachDist 0
		x 195
		y 86
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local0 0)
				(if (!= (gCurRoom script:) doElevator)
					(= local0 1)
					(gMessager say: noun theVerb 0 0) ; "You press the button to call the elevator."
					(gCurRoom setScript: doElevator)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vending of Feature
	(properties
		noun 1
		nsLeft 39
		nsTop 59
		nsRight 84
		nsBottom 115
		sightAngle 40
		approachX 70
		approachY 130
		approachDist 0
		x 61
		y 87
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29 ; coins
				(if local1
					(gMessager say: 1 29 3) ; "Carey, you already deposited sixty-five cents."
				else
					(gEgo setScript: putTheMoneyIn)
				)
			)
			(4 ; Do
				(if local1
					(if (not (gEgo has: 48)) ; candyBar
						(sFx number: 1004 loop: 1 play:)
						(gEgo get: 48) ; candyBar
						(= local1 0)
						(gMessager say: 1 4 1) ; "Getting candy out of a machine is a little like winning a prize."
					else
						(gMessager say: 1 4 2) ; "Damn! The candy bar is stuck!"
					)
				else
					(super doVerb: theVerb)
				)
			)
			(22 ; handgun
				(if (not local2)
					(= local2 1)
					(gMessager say: 1 22 7) ; "Destroying Department and City property is punishable by dismissal."
				else
					((ScriptID 32 0) doit: 1 22 6 1 520) ; ShootHandgun, "Your actions are not in keeping with department policy. You're dismissed."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		noun 2
		nsLeft 299
		nsTop 98
		nsRight 319
		nsBottom 110
		sightAngle 40
		approachX 277
		approachY 162
		approachDist 0
		x 309
		y 154
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (>= gDay 4) (not (gEgo has: 31))) ; matches
						(gEgo get: 31) ; matches
						(gGame points: 3)
						(gMessager say: 2 4 5 0) ; "Someone has left a pack of matches. Never knowing when you'll need a light, you pocket them."
					)
					((gEgo has: 31) ; matches
						(gMessager say: noun theVerb 8 0) ; "A disgusting mess today, cigarette butts and candy wrappers."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(cond
					((and (>= gDay 4) (not (gEgo has: 31))) ; matches
						(gMessager say: noun theVerb 5 0) ; "There appears to be a full pack of matches in the ashtray."
					)
					((gEgo has: 31) ; matches
						(gMessager say: noun theVerb 8 0) ; "There's nothing but cigarette butts and candy wrappers."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		noun 7
		nsLeft 5
		nsTop 54
		nsRight 24
		nsBottom 62
		x 15
		y 62
	)
)

(instance doors of Prop
	(properties
		noun 4
		x 251
		y 139
		priority 145
		fixPriority 1
		view 520
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if cel
					(gMessager say: 11 theVerb 0 0) ; "What are you reaching for? Step in if you want a lift."
				else
					(gMessager say: noun theVerb 0 0) ; "Maybe if you had the strength of Arnold you could pry the doors open."
				)
			)
			(22 ; handgun
				(if cel
					(gMessager say: noun theVerb 9 0) ; "Holster your weapon! Your life is not being threatened."
				else
					(gMessager say: noun theVerb 0 0) ; "Holster your weapon and wait for the elevator like everyone else."
				)
			)
			(1 ; Look
				(if cel
					(gMessager say: 11 theVerb 0 0) ; "The elevator is void of passengers."
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if cel
					(gMessager say: 11 theVerb 0 0) ; "There's no one in the elevator to talk to, Detective."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light of View
	(properties
		noun 10
		x 251
		y 8
		view 520
		loop 1
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance elevLight of Feature
	(properties
		noun 10
		nsLeft 244
		nsTop 2
		nsRight 254
		nsBottom 16
		sightAngle 40
		x 249
		y 3
	)
)

(instance map of Feature
	(properties
		noun 9
		nsLeft 189
		nsTop 39
		nsRight 203
		nsBottom 56
		sightAngle 40
		x 196
		y 47
	)
)

(instance wall of Feature
	(properties
		noun 6
		x 100
		y 1
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 152 286 152 239 141 223 143 173 132 173 125 152 122 140 124 102 115 0 127
					yourself:
				)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 510)
					(gEgo stopView: 9125)
					(gEgo
						normalize: 9120
						x: -10
						y: 140
						setScaler: Scaler 98 67 153 122
						setMotion: MoveTo 10 140 self
						init:
					)
					(= local0 0)
				else
					(gEgo stopView: 9125)
					(gEgo
						heading: 240
						normalize: 9120
						x: 284
						y: 140
						setPri: 50
						setScaler: Scaler 98 67 153 122
						init:
					)
					(= local0 1)
					(self setScript: elevatorArrive self)
				)
			)
			(1
				(if (== gPrevRoomNum 510)
					(gGame handsOn:)
					(self dispose:)
				else
					(if (gPqFlags test: 32)
						(proc0_4 0)
					)
					(gEgo setMotion: MoveTo 237 150 self)
				)
			)
			(2
				(gEgo setPri: -1)
				(= local0 0)
				(self setScript: elevatorLeave self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 253 149 self)
			)
			(1
				(gEgo setHeading: 45)
				(self setScript: elevatorArrive self)
				(proc0_4 1)
			)
			(2
				(self setScript: getInElevator self)
			)
			(3
				(gCurRoom setInset: (ScriptID 31)) ; panelInset
			)
			(4
				(if register
					(= local0 0)
					(gGame handsOff:)
					(gEgo setMotion: MoveTo 237 150 self)
					(if (gPqFlags test: 32)
						(proc0_4 0)
					)
				else
					(self setScript: elevatorLeave self)
				)
			)
			(5
				(if register
					(= local0 (= register 0))
					(self setScript: elevatorLeave self)
					(gGame handsOn:)
					(if (gPqFlags test: 32)
						(proc0_4 0)
					)
				else
					(self dispose:)
				)
			)
			(6
				(gGlobalSound0 number: 983 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance elevatorArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(doors setPri: 145)
				else
					(doors setPri: 0)
				)
				(if 1
					(gGlobalSound1 number: 940 loop: -1 play:)
				)
				(= ticks (Random 200 400))
			)
			(1
				(light init:)
				(= cycles 2)
			)
			(2
				(gGlobalSound1 number: 0 stop:)
				(sFx number: 942 loop: 1 play: self)
			)
			(3
				(doors setCycle: End self)
				(if (not (OneOf (gGlobalSound0 number:) 520 521 522))
					(gGlobalSound0
						number: (Random 520 522)
						loop: -1
						play:
						setVol: 0
						fade: 127 4 2 0
					)
				)
				(sFx number: 939 loop: 1 play: self)
			)
			(4)
			(5
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 152 245 152 278 164 266 152 292 135 275 132 251 147 213 147 113 124 0 137
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance getInElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 50 setMotion: PolyPath 284 140 self)
			)
			(1
				(gEgo setHeading: 200 self)
			)
			(2
				(= cycles 10)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance putTheMoneyIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 9033
					setLoop: 0
					setCel: 0
					setCycle: ROsc 1 0 5 self
				)
			)
			(1
				(= local1 1)
				(sFx number: 1005 loop: 1 play: self)
			)
			(2
				(gMessager say: 1 29 4 0 self) ; "You drop sixty-five cents into the slot."
			)
			(3
				(gEgo normalize: 9120 setScaler: Scaler 98 67 153 122)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hiResCandy of View
	(properties
		x 3
		y 48
		view 521
	)
)

(instance hiResAshTray of View
	(properties
		noun 2
		x 287
		y 86
		view 521
		loop 1
	)
)

(instance sFx of Sound
	(properties
		flags 5
	)
)

(instance elevatorLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local0)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 152 246 152 284 165 266 152 251 147 213 147 113 124 0 137
								yourself:
							)
					)
					(gGame handsOn:)
				else
					(proc0_4 1)
					(gGame handsOff:)
				)
				(= cycles 3)
			)
			(1
				(doors setPri: (if local0 145 else 0) setCycle: Beg self)
				(if (not local0)
					(gGlobalSound0 fade: 0 2 1 1)
				)
				(sFx number: 938 loop: 1 play: self)
			)
			(2)
			(3
				(light dispose:)
				(if 1
					(gGlobalSound1 number: 940 loop: -1 play:)
				)
				(if (not local0)
					(gGlobalSound0 stop: number: 0)
					(gGame handsOn:)
					(= ticks 150)
				else
					(= ticks 150)
				)
			)
			(4
				(if (not local0)
					(gGlobalSound0 number: 983 loop: -1 play:)
					(gGlobalSound1 stop:)
				)
				(self dispose:)
			)
		)
	)
)

