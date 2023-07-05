;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom7 0
)

(instance sHRoom7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 229 125 70 125 38 137
							yourself:
						)
				)
				((ScriptID 800 2) doit: 890) ; xDrawThePic
				(gGkMusic1
					number: 226
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(door1 init:)
				(gWalkHandler add: door1)
				(bags init:)
				(boxes init:)
				(barrels init:)
				(cans init:)
				(cond
					((and (not (gEgo has: 76)) (not (gEgo has: 79))) ; WolfMask, WolfGuise
						(masks cel: 0 init:)
					)
					((and (not (gEgo has: 74)) (not (gEgo has: 78))) ; BoarMask, BoarGuise
						(masks cel: 1 init:)
					)
					(else 0)
				)
				(robes init:)
				(gEgo
					normalize: 1
					posn: 230 126
					init:
					setMotion: MoveTo 220 126
				)
				(gGame handsOn:)
			)
			(1
				(gGkMusic1 fade:)
				(gWalkHandler delete: door1)
				(self dispose:)
			)
		)
	)
)

(instance sExitToHounfour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 235 126 self)
			)
			(1
				(client cue:)
			)
		)
	)
)

(instance sGetRobes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 122 124 self)
			)
			(1
				(gEgo
					view: 885
					setSpeed: 12
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
				(switch register
					(1
						(gMessager say: 2 12 4 0 0 807) ; "(TO HIMSELF AS HE PICKS UP DISGUISE)A robe for me."
					)
					(2
						(gMessager say: 2 12 5 0 0 807) ; "A robe for prosterity."
					)
				)
			)
			(2
				(gEgo normalize: 7)
				(gGame handsOn:)
			)
		)
	)
)

(instance sGetMasks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(1
						(gEgo setMotion: PolyPath 168 131 self)
					)
					(2
						(gEgo setMotion: PolyPath 158 131 self)
					)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(Face gEgo masks self)
			)
			(3
				(= cycles 2)
			)
			(4
				(switch register
					(1
						(gMessager say: 3 12 1 0 self 807) ; "(TALKING TO HIMSELF AS HE PICKS UP DISGUISE)I think I'll take this wolf mask for me."
					)
					(2
						(gMessager say: 3 12 2 0 self 807) ; "(SLIGHTLY SARCASTIC)This boar mask seems appropriate for Mosely--if he ever makes it."
					)
				)
			)
			(5
				(gEgo
					view: 885
					setSpeed: 12
					setCel: 0
					setLoop: 0
					setCycle: CT 3 1 self
				)
			)
			(6
				(switch register
					(1
						(gEgo setCycle: End self)
						(masks setCel: 1)
					)
					(2
						(gEgo setCycle: End self)
						(masks dispose:)
					)
				)
			)
			(7
				(gEgo normalize: 7)
				(gGame handsOn:)
			)
		)
	)
)

(instance door1 of Feature
	(properties
		noun 4
		modNum 800
		nsLeft 227
		nsTop 58
		nsRight 252
		nsBottom 134
		sightAngle 40
		x 238
		y 95
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sHRoom7 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bags of Feature
	(properties
		noun 4
		modNum 807
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 131
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 91 118 98 128 97 128 101 150 102 154 120 97 120 95 99 105 91
					yourself:
				)
		)
		(super init:)
	)
)

(instance barrels of Feature
	(properties
		noun 5
		modNum 807
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 76
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 71 61 75 70 77 90 71 90 96 93 98 93 119 81 122 78 120 73 124 61 123 64 100 56 100
					yourself:
				)
		)
		(super init:)
	)
)

(instance boxes of Feature
	(properties
		noun 1
		modNum 807
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 186
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 120 156 121 155 98 178 99 175 104 208 106
					yourself:
				)
		)
		(super init:)
	)
)

(instance cans of Feature
	(properties
		noun 6
		modNum 807
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 221
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 221 103 230 123 212 123 yourself:)
		)
		(super init:)
	)
)

(instance masks of View
	(properties
		noun 3
		modNum 807
		x 134
		y 99
		view 885
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(cond
					((and (not (gEgo has: 76)) (not (gEgo has: 79))) ; WolfMask, WolfGuise
						(if (gEgo has: 77) ; WolfRobe
							(gEgo put: 77 get: 79) ; WolfRobe, WolfGuise
							(gEgo getPoints: -999 1)
						else
							(gEgo get: 76) ; WolfMask
						)
						(sHRoom7 setScript: sGetMasks 0 1)
					)
					(
						(and
							(or (gEgo has: 76) (gEgo has: 79)) ; WolfMask, WolfGuise
							(not (gEgo has: 74)) ; BoarMask
							(not (gEgo has: 78)) ; BoarGuise
						)
						(if (gEgo has: 75) ; BoarRobe
							(gEgo put: 75 get: 78) ; BoarRobe, BoarGuise
							(gEgo getPoints: -999 1)
						else
							(gEgo get: 74) ; BoarMask
						)
						(sHRoom7 setScript: sGetMasks 0 2)
					)
					(else
						(gMessager say: noun theVerb 3 0 0 807) ; MISSING MESSAGE
					)
				)
				(return 1)
			)
			(7 ; Look
				(if (and (not (gEgo has: 76)) (not (gEgo has: 79))) ; WolfMask, WolfGuise
					(gMessager say: noun theVerb 8 0 0 807) ; "Those two masks remind Gabriel of the ones used at the Bayou ritual."
				else
					(gMessager say: noun theVerb 7 0 0 807) ; "There's still one mask left."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robes of Feature
	(properties
		noun 2
		modNum 807
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 109
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 59 116 92 102 92 104 81 91 82 92 60
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(cond
					((and (not (gEgo has: 77)) (not (gEgo has: 79))) ; WolfRobe, WolfGuise
						(if (gEgo has: 76) ; WolfMask
							(gEgo put: 76 get: 79) ; WolfMask, WolfGuise
							(gEgo getPoints: -999 1)
						else
							(gEgo get: 77) ; WolfRobe
						)
						(sHRoom7 setScript: sGetRobes 0 1)
					)
					(
						(and
							(or (gEgo has: 77) (gEgo has: 79)) ; WolfRobe, WolfGuise
							(not (gEgo has: 75)) ; BoarRobe
							(not (gEgo has: 78)) ; BoarGuise
						)
						(if (gEgo has: 74) ; BoarMask
							(gEgo put: 74 get: 78) ; BoarMask, BoarGuise
							(gEgo getPoints: -999 1)
						else
							(gEgo get: 75) ; BoarRobe
						)
						(sHRoom7 setScript: sGetRobes 0 2)
					)
					(else
						(gMessager say: noun theVerb 6 0 0 807) ; "Gabriel has enough robes."
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

