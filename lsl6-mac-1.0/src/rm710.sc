;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use LarryRoom)
(use PolyFeature)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	local0
	local1
	local2
)

(instance rm710 of LarryRoom
	(properties
		noun 1
		picture 710
		horizon 0
		east 700
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 139 319 139 319 72 271 72 185 57 114 57 46 69 18 60 0 64 0 69 26 65 30 70 0 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 128 68 162 68 176 75 176 84 163 91 128 91 115 83 115 75
					yourself:
				)
		)
		(gGame handsOn:)
		(super init: &rest)
		(gEgo normalize: init: setScale: Scaler 100 80 78 57 posn: 325 75)
		(if (== gPrevRoomNum 720)
			(= local2 1)
			(gGame handsOn:)
			(gEgo posn: (shamra approachX:) (shamra approachY:))
			(gGlobalSound1 number: 700 loop: -1 play: 50 fade: 127 10 10 0)
		else
			(self setScript: walkEgoInScr)
		)
		(chimney init:)
		(fishTank init:)
		(wallFlower init:)
		(roses init:)
		(shamra setCycle: Fwd init: approachVerbs: 4 1 2 5 6 13 cycleSpeed: 12) ; Do, Look, Talk, Take, Zipper, orchid
		(if (>= (gGame detailLevel:) 3)
			(fish1 init: setCycle: Fwd setScript: (fishScr new:))
			(fish2 init: setCycle: Fwd setScript: (fishScr new:) 0 1)
			(fish3 init: setCycle: Fwd setScript: (fishScr new:))
			(fish4 init: setCycle: Fwd setScript: (fishScr new:) 0 1)
			(fish5 init: setCycle: Fwd setScript: fishScr 0 1)
		)
		(fire setCycle: Fwd init: approachVerbs: 42) ; match
		(balconyPoly init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((AvoidPath (gEgo x:) (gEgo y:) balconyPoly)
				(if (not local2)
					(self setScript: toShamra)
				)
			)
			(local2
				(= local2 0)
				(gEgo setPri: -1)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(self setScript: turnAndTalkScr)
			(return 1)
		else
			(return (super doVerb: theVerb))
		)
	)

	(method (edgeToRoom param1)
		(if (== param1 2)
			(self setScript: toPenthouseScr)
		)
		(return 0)
	)

	(method (dispose)
		(gNarrator y: -1)
		(balconyPoly dispose:)
		(super dispose:)
	)
)

(instance turnAndTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(shamra x:)
							(shamra y:)
						)
						self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 1 2 0 0 self) ; "Hi, babe! Can you hear me?"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toPenthouseScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 700)
			)
		)
	)
)

(instance toShamra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setPri: 1
					setMotion:
						PolyPath
						(shamra approachX:)
						(shamra approachY:)
						self
				)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance walkEgoInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 312 79 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roses of PolyFeature
	(properties
		y 141
		noun 5
		sightAngle 40
		variableX 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 109 122 123 117 138 110 138 104 123 104 108 110 104
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 148 101 154 101 161 121 155 138 151 138 145 121 145 108
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 207 118 204 128 196 138 186 122 198 105 210 111
					yourself:
				)
		)
	)
)

(instance chimney of Feature
	(properties
		x 147
		y 81
		noun 3
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 159 0 149 50 152 59 139 59 144 49 136 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fishTank of Feature
	(properties
		x 226
		y 58
		noun 4
		sightAngle 40
		approachX 220
		approachY 64
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 257 33 256 53 202 47 202 29 yourself:)
			approachVerbs: 4 ; Do
		)
		(super init: &rest)
	)
)

(instance wallFlower of Feature
	(properties
		x 291
		y 63
		noun 2
		sightAngle 40
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 302 39 295 53 288 53 281 37 291 24
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance shamra of Prop
	(properties
		x 41
		y 63
		sightAngle 40
		approachX 17
		approachY 63
		view 710
		cel 5
		priority 1
		signal 16
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 720)
	)
)

(instance fishScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(client posn: (+ 203 (Random 0 51)) (+ 33 (Random 0 14)))
				(= cycles 2)
			)
			(1
				(= local0 (+ 203 (Random 0 51)))
				(= local1 (+ 33 (Random 0 14)))
				(= temp1 100)
				(repeat
					(breakif
						(or
							(not
								(or
									(>
										(= temp0
											(GetAngle
												(client x:)
												(client y:)
												local0
												local1
											)
										)
										330
									)
									(< (Abs (- temp0 180)) 30)
									(< temp0 30)
								)
							)
							(not (-- temp1))
						)
					)
				)
				(cond
					((>= temp0 180)
						(if (< (client heading:) 180)
							(client loop: (+ (client loop:) 1))
						)
					)
					((>= (client heading:) 180)
						(client loop: (- (client loop:) 1))
					)
				)
				(client setMotion: MoveTo local0 local1 self)
			)
			(2
				(= state 0)
				(if register
					(= ticks (Random 20 80))
				else
					(= cycles 2)
				)
			)
		)
	)
)

(instance lightMatchScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 901 loop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gGame changeScore: 12 157)
				((gInventory at: 25) ; match
					message: 43
					noun: 21
					view: 41
					setCursor: 41 0 0
					yourself:
				)
				(gInventory show:)
				(gNarrator y: 97)
				(gMessager say: 9 42) ; "You stick the match in the fireplace, being careful to keep it just above the water."
				(= cycles 2)
			)
			(3
				(gNarrator y: -1)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 900 8 1 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fish1 of Actor
	(properties
		y -1
		heading 90
		view 712
		signal 18448
		cycleSpeed 25
		moveSpeed 25
	)
)

(instance fish2 of Actor
	(properties
		y -1
		heading 90
		view 712
		loop 2
		signal 18448
		cycleSpeed 20
		moveSpeed 20
	)
)

(instance fish3 of Actor
	(properties
		y -1
		heading 90
		view 712
		loop 4
		signal 18448
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance fish4 of Actor
	(properties
		y -1
		heading 90
		view 712
		loop 6
		signal 18448
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance fish5 of Actor
	(properties
		y -1
		heading 90
		view 712
		loop 8
		signal 18448
		cycleSpeed 5
		moveSpeed 5
	)
)

(instance fire of Prop
	(properties
		x 144
		y 87
		noun 9
		approachX 114
		approachY 82
		view 713
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 42) ; match
			(self setScript: lightMatchScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance balconyPoly of Polygon
	(properties)

	(method (init)
		(super init: 14 54 44 66 28 69 0 73 0 60)
	)
)

