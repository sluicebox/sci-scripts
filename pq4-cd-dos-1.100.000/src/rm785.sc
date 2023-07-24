;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 785)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm785 0
)

(local
	local0
	local1
)

(instance rm785 of Room
	(properties
		picture 785
		style 0
	)

	(method (init)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 103 140 130 140 130 128 103 128
					yourself:
				)
		)
		(if (or (!= gPrevRoomNum 780) (not (gGlobalSound2 handle:)))
			(gGlobalSound2 number: 1028 loop: -1 signal: 5 play:)
		)
		(backGrnd init: signal: (| (backGrnd signal:) $4000))
		(door init: signal: (| (door signal:) $4000))
		(house init:)
		(flowers0 init:)
		(flowers1 init:)
		(flowers2 init:)
		(rightWindow init:)
		(leftWindow init:)
		(if (gPqFlags test: 29)
			(= local1 1)
			(PalVary 8 785) ; PalVaryNewSource
		)
		(switch gPrevRoomNum
			(790
				(gEgo
					normalize: 0
					setHeading: 180
					posn: 119 134 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					scaleSignal: 0
					init:
				)
			)
			(else
				(gEgo
					normalize: 0
					setHeading: 0
					posn: 119 134 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					scaleSignal: 0
					init:
				)
				(if (gPqFlags test: 4)
					(gPqFlags clear: 4)
					(gGame handsOff:)
					(switch gDay
						(2
							(if (gPqFlags test: 6)
								(self setScript: knockDoor4Scr)
							else
								(self setScript: knockDoor1Scr)
							)
						)
						(3
							(if
								(or
									(> gDay 3)
									(and
										(== gDay 3)
										(or
											(gPqFlags test: 7)
											(not (gEgo has: 0)) ; funeralMemo
											(not (gPqPointFlags test: 32))
											(not (gPqFlags test: 105))
											(not (gPqFlags test: 92))
										)
									)
								)
								(self setScript: knockDoor2Scr)
							else
								(self setScript: knockDoor3Scr)
							)
						)
						(else
							(self setScript: knockDoor2Scr)
						)
					)
				else
					(gGame handsOn:)
				)
			)
		)
		(gTheIconBar show: 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 780)
			(gGlobalSound2 number: 0 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if local1
			(PalVary 3) ; PalVaryKill
		)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo y:) 136)
			(gCurRoom newRoom: 780)
		)
	)
)

(instance sndFx of Sound
	(properties)
)

(instance rightWindow of Feature
	(properties
		noun 12
		x 240
		y 95
	)

	(method (init)
		(self createPoly: 205 25 278 25 278 95 205 95)
		(super init: &rest)
	)
)

(instance leftWindow of Feature
	(properties
		noun 12
		x 90
		y 98
	)

	(method (init)
		(self createPoly: 24 22 152 22 52 98 24 98)
		(super init: &rest)
	)
)

(instance flowers0 of Feature
	(properties
		noun 9
		sightAngle 180
		y 20
	)

	(method (init)
		(self createPoly: 27 120 32 117 41 124 56 114 75 127 75 136 25 137)
		(super init: &rest)
	)
)

(instance flowers1 of Feature
	(properties
		noun 9
		sightAngle 180
		y 20
	)

	(method (init)
		(self
			createPoly: 147 134 149 124 154 120 190 126 212 118 226 118 237 127 244 119 294 119 295 136 152 135
		)
		(super init: &rest)
	)
)

(instance flowers2 of Feature
	(properties
		noun 9
		sightAngle 180
		y 20
	)

	(method (init)
		(self
			createPoly: 203 91 214 80 228 77 244 85 256 78 271 81 281 92 279 97 266 98 264 103 255 102 251 96 230 97 227 103 219 103 216 97 206 96
		)
		(super init: &rest)
	)
)

(instance house of Feature
	(properties
		noun 4
		sightAngle 180
		y 10
	)

	(method (init)
		(self createPoly: 25 9 296 10 297 135 25 136)
		(super init: &rest)
	)
)

(instance backGrnd of View
	(properties
		x 124
		y 127
		priority 1
		fixPriority 1
		view 7894
	)

	(method (doVerb theVerb)
		(door doVerb: theVerb)
	)
)

(instance door of Prop
	(properties
		noun 1
		sightAngle 360
		x 101
		y 23
		priority 2
		fixPriority 1
		view 7892
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (not cel)
					(gGame handsOff:)
					(switch gDay
						(2
							(if (gPqFlags test: 6)
								(self setScript: knockDoor4Scr)
							else
								(self setScript: knockDoor1Scr)
							)
						)
						(3
							(if
								(or
									(> gDay 3)
									(and
										(== gDay 3)
										(or
											(gPqFlags test: 7)
											(not (gEgo has: 0)) ; funeralMemo
											(not (gPqPointFlags test: 32))
											(not (gPqFlags test: 105))
											(not (gPqFlags test: 92))
										)
									)
								)
								(self setScript: knockDoor2Scr)
							else
								(self setScript: knockDoor3Scr)
							)
						)
						(else
							(self setScript: knockDoor2Scr)
						)
					)
				)
			)
			(
				(and
					(== theVerb 14 52 1 2) ; hickmanStuff, notebook, Look, Talk
					(or
						(> gDay 3)
						(and
							(== gDay 3)
							(or
								(gPqFlags test: 7)
								(not (gEgo has: 0)) ; funeralMemo
								(not (gPqPointFlags test: 32))
								(not (gPqFlags test: 105))
								(not (gPqFlags test: 92))
							)
						)
					)
				)
				(gMessager say: noun theVerb 2 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kath of Prop
	(properties
		sightAngle 180
		x 131
		y 124
		priority 6
		fixPriority 1
		view 786
	)
)

(instance val of Prop
	(properties
		noun 10
		sightAngle 180
		x 126
		y 129
		priority 6
		fixPriority 1
		view 7890
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(val setScript: 0 setCycle: 0)
				(gTheIconBar enable: 0)
				(gGame handsOff:)
				(gGame points: 3 89)
				(gCurRoom setScript: enterScr)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local0)
						(gMessager say: 10 22 8) ; "Holster your weapon! She's an innocent child!"
						(++ local0)
					)
					(((ScriptID 32 0) doit: 10 22 9 1 785) ; ShootHandgun
						(val setScript: 0)
						0
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knockDoor1Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: knockSubScr self)
			)
			(1
				(sndFx number: 978 play:)
				(door cel: 1)
				(= cycles 3)
			)
			(2
				(door cel: 2)
				(= cycles 3)
			)
			(3
				(door cel: 3)
				(val init: show: setScaler: Scaler 90 101 121 93 cel: 1)
				(= cycles 3)
			)
			(4
				(door cel: 4)
				(val cel: 3)
				(= cycles 3)
			)
			(5
				(door cel: 5)
				(val cel: 5)
				(= cycles 3)
			)
			(6
				(door cel: 6)
				(val cel: 8)
				(= cycles 3)
			)
			(7
				(door cel: 7)
				(val cel: 12)
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(gMessager say: 1 0 4 0) ; "What a cute kid Valerie is!"
				(gTheIconBar disable: 0)
				(val setScript: waitScr)
				(self dispose:)
			)
		)
	)
)

(instance waitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(gGame handsOff:)
				(door cel: 6)
				(val cel: 8)
				(= cycles 3)
			)
			(2
				(door cel: 5)
				(val cel: 5)
				(= cycles 3)
			)
			(3
				(door cel: 4)
				(val cel: 3)
				(= cycles 3)
			)
			(4
				(door cel: 3)
				(val cel: 1)
				(= cycles 3)
			)
			(5
				(door cel: 2)
				(val hide:)
				(= cycles 3)
			)
			(6
				(sndFx number: 979 play:)
				(door setCycle: Beg self)
			)
			(7
				(= cycles 1)
			)
			(8
				(gGame handsOn:)
				(gTheIconBar enable: 0)
				(val dispose:)
				(self dispose:)
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 2 1 0 self) ; "Hi Valerie. How you doing?"
			)
			(1
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance knockDoor2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: knockSubScr self)
			)
			(1
				(gMessager say: 1 4 2 0) ; "It appears no one is home at this time."
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockDoor3Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: knockSubScr self)
			)
			(1
				(= seconds 3)
			)
			(2
				(sndFx number: 978 play:)
				(door cel: 1)
				(= cycles 3)
			)
			(3
				(door cel: 2)
				(kath init: setScaler: Scaler 88 88 127 99 cel: 1)
				(= cycles 3)
			)
			(4
				(door cel: 3)
				(= cycles 3)
			)
			(5
				(door cel: 4)
				(kath cel: 2)
				(= cycles 3)
			)
			(6
				(door cel: 5)
				(kath cel: 4)
				(= cycles 3)
			)
			(7
				(door cel: 6)
				(kath cel: 6)
				(= cycles 3)
			)
			(8
				(door cel: 7)
				(kath cel: 11)
				(= cycles 3)
			)
			(9
				(gMessager say: 14 2 11 0 self) ; "Hello, John. Won't you come in."
			)
			(10
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance knockDoor4Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: knockSubScr self)
			)
			(1
				(sndFx number: 978 play:)
				(door cel: 1)
				(= cycles 3)
			)
			(2
				(door cel: 2)
				(= cycles 3)
			)
			(3
				(door cel: 3)
				(val init: setScaler: Scaler 90 101 121 93 cel: 1)
				(= cycles 3)
			)
			(4
				(door cel: 4)
				(val cel: 3)
				(= cycles 3)
			)
			(5
				(door cel: 5)
				(val cel: 5)
				(= cycles 3)
			)
			(6
				(door cel: 6)
				(val cel: 8)
				(= cycles 3)
			)
			(7
				(door cel: 7)
				(val cel: 12)
				(= cycles 3)
			)
			(8
				(gMessager say: 10 0 3 0) ; "My mommy's sick. She said no visitors."
				(door cel: 6)
				(val cel: 8)
				(= cycles 3)
			)
			(9
				(door cel: 5)
				(val cel: 5)
				(= cycles 3)
			)
			(10
				(door cel: 4)
				(val cel: 3)
				(= cycles 3)
			)
			(11
				(door cel: 3)
				(val cel: 1)
				(= cycles 3)
			)
			(12
				(door cel: 2)
				(val hide:)
				(= cycles 3)
			)
			(13
				(sndFx number: 979 play:)
				(door setCycle: Beg self)
			)
			(14
				(= cycles 1)
			)
			(15
				(val dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockSubScr of Script
	(properties)

	(method (doit)
		(if (and (== (gEgo view:) 9008) (OneOf (gEgo cel:) 5 8 11))
			(sndFx play:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sndFx number: 998)
				(= cycles 2)
			)
			(1
				(if (or (!= (gEgo x:) 119) (!= (gEgo y:) 134))
					(gEgo setMotion: PolyPath 119 134 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(gMessager say: 1 4 0 1 self) ; "Knocking seems less intrusive than ringing the doorbell."
			)
			(4
				(gEgo view: 9008 setLoop: 0 cel: 0 setCycle: End self)
				(= register
					((Prop new:)
						view: 9008
						loop: 1
						posn: (gEgo x:) (gEgo y:) 0
						init:
						yourself:
					)
				)
			)
			(5
				(gEgo cel: 3 setCycle: Beg self)
			)
			(6
				(= cycles 1)
			)
			(7
				(gEgo normalize: 0)
				(register dispose:)
				(= seconds 2)
			)
			(8
				(self dispose:)
			)
		)
	)
)

