;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
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
	sHRoom6 0
)

(instance sHRoom6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 209 116 75 116 38 137
							yourself:
						)
				)
				(gGkMusic1
					number: 550
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				((ScriptID 800 2) doit: 800) ; xDrawThePic
				(door1 setCel: 0 init:)
				(door2 init:)
				(keyPad1 init:)
				(keyPad2 init:)
				(mural init:)
				(lightL init:)
				(lightR init:)
				(if register
					(self setScript: sEnterFromElevator)
				else
					(door2 setCel: 5)
					(self setScript: sEnter)
					(gEgo
						normalize: 1
						posn: 230 126
						init:
						setMotion: MoveTo 220 126 script
					)
				)
			)
			(1
				(gGkSound2 stop:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gGkSound1 number: 812 play:)
				(door2 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGkSound1 number: 811 play:)
				(door1 setCycle: End self)
			)
			(2
				(gEgo
					view: 802
					setSpeed: 12
					setLoop: 0
					setCel: 0
					posn: 73 126
					init:
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 0
					posn: 73 126
					setMotion: MoveTo 85 126 self
				)
			)
			(4
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(5
				(if (not (IsFlag 429))
					(SetFlag 429)
					(gMessager say: 3 0 1 0 self 806) ; "The elevator stops at a room underneath the cathedral!"
				else
					(= cycles 1)
				)
			)
			(6
				(if (and (IsFlag 280) (IsFlag 281) (not (IsFlag 351)))
					(SetFlag 351)
					(Face gEgo door1)
					(gMessager say: 3 0 2 1 self 806) ; "The elevator returns to the cathedral. Gabriel's stuck now!"
				else
					(= cycles 1)
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 125 self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 802 play:)
			)
			(3
				(door1 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 811 play:)
			)
			(4
				(gEgo normalize: 1 setMotion: MoveTo 0 125 self)
			)
			(5
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(6
				((ScriptID 800 0) BackToElevator: 1) ; Hounfour
				(client cue:)
			)
		)
	)
)

(instance sExitToHounfour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 222 125 self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 802 play:)
			)
			(3
				(door2 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 811 play:)
			)
			(4
				(gEgo normalize: 0 setMotion: PolyPath 238 128 self)
			)
			(5
				(gEgo
					view: 802
					setSpeed: 12
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(gGame handsOn:)
				(client cue:)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		noun 1
		modNum 806
		x 50
		y 58
		view 803
	)
)

(instance door2 of Prop
	(properties
		noun 4
		modNum 800
		x 251
		y 59
		view 803
		loop 1
	)
)

(instance mural of Feature
	(properties
		noun 2
		modNum 806
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 145
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 143 63 170 68 176 67 181 71 181 82 177 86 119 90 112 84 112 68
					yourself:
				)
		)
		(super init:)
	)
)

(instance lightL of Feature
	(properties
		noun 16
		modNum 800
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 93
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 111 92 69 88 61 93 60 101 62 95 70 95 111 98 114 90 114
					yourself:
				)
		)
		(super init:)
	)
)

(instance lightR of Feature
	(properties
		noun 16
		modNum 800
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 202
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 111 200 70 194 62 201 60 208 62 203 71 203 110 206 114 198 114
					yourself:
				)
		)
		(super init:)
	)
)

(instance keyPad1 of Feature
	(properties
		noun 4
		modNum 806
		nsLeft 64
		nsTop 81
		nsRight 74
		nsBottom 91
		sightAngle 40
		approachX 69
		approachY 86
		x 69
		y 119
		z 33
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (IsFlag 351)
					(gMessager say: noun theVerb 8 0 0 806) ; "(RRCC)The elevator has returned to the cathedral. Gabriel's stuck now!"
				else
					(sHRoom6 setScript: sExitToElevator)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyPad2 of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 231
		nsTop 79
		nsRight 242
		nsBottom 92
		sightAngle 40
		approachX 236
		approachY 85
		x 236
		y 124
		z 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom6 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

