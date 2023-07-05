;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom9 0
)

(instance sHRoom9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 249 137 204 112 168 112 168 119 70 119 38 137
							yourself:
						)
				)
				((ScriptID 800 2) doit: 850) ; xDrawThePic
				(gGkMusic1
					number: 490
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(bed init:)
				(light init:)
				(wallPanel init:)
				(lightBar init:)
				(keypad init:)
				(keypad2 init:)
				(door2 init:)
				(door1 init: setCel: 5)
				(wallThingie init:)
				(self setScript: sEnter)
				(gEgo
					setScaler: Scaler 100 85 120 111
					normalize: 1
					posn: 230 126
					init:
					setMotion: MoveTo 215 126 script
				)
			)
			(1
				(gGkMusic1 fade:)
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
				(door1 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenBathroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 201 113 self)
			)
			(1
				(gGkSound1 number: 811 play:)
				(door2 setCycle: End self)
			)
			(2
				(Face gEgo 201 0 self)
			)
			(3
				(if register
					(gMessager say: 20 8 29 0 self 800) ; "Another bathroom."
				else
					(gMessager say: 20 8 28 0 self 800) ; "(SARCASTIC)A bathroom. How human of them."
				)
			)
			(4
				(gGkSound1 number: 812 play:)
				(door2 setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
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
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 219 126 self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
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
				(gEgo normalize: 0 setMotion: PolyPath 234 128 self)
			)
			(5
				(if (not (Random 0 2))
					(gEgo
						view: 802
						setSpeed: 12
						setCel: 0
						setLoop: 1
						setCycle: End self
					)
				else
					(= cycles 1)
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
		noun 4
		modNum 800
		x 250
		y 128
		priority 1
		fixPriority 1
		view 855
		loop 1
		signal 16417
	)
)

(instance door2 of Prop
	(properties
		noun 2
		modNum 809
		x 169
		y 108
		priority 1
		fixPriority 1
		view 855
		signal 16417
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 228
		nsTop 80
		nsRight 237
		nsBottom 92
		sightAngle 40
		approachX 232
		approachY 86
		x 232
		y 129
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom9 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keypad2 of Feature
	(properties
		noun 20
		nsLeft 200
		nsTop 77
		nsRight 207
		nsBottom 86
		sightAngle 40
		approachX 201
		approachY 113
		x 203
		y 111
		z 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(123 ; hounfourKey
				(gMessager say: noun theVerb 15) ; "This door isn't locked."
				(return 1)
			)
			(8 ; Operate
				(cond
					((not (IsFlag 338))
						(SetFlag 338)
						(SetFlag 340)
						(sHRoom9 setScript: sOpenBathroom)
					)
					((and (IsFlag 338) (not (IsFlag 340)))
						(SetFlag 340)
						(sHRoom9 setScript: sOpenBathroom 0 1)
					)
					(else
						(gMessager say: noun theVerb 30) ; "There's nothing of interest in the bathroom."
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

(instance wallThingie of View
	(properties
		noun 18
		modNum 800
		x 132
		y 58
		view 845
	)
)

(instance bed of Feature
	(properties
		noun 1
		modNum 809
		sightAngle 40
		x 70
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 96 77 91 109 95 151 95 156 100 157 114 71 113
					yourself:
				)
		)
		(super init:)
	)
)

(instance light of Feature
	(properties
		noun 16
		modNum 800
		sightAngle 40
		x 255
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 75 244 65 263 65 255 75 255 135 251 135
					yourself:
				)
		)
		(super init:)
	)
)

(instance lightBar of Feature
	(properties
		noun 17
		modNum 800
		sightAngle 40
		x 70
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 54 86 58 88 61 78 63 60 58 60 54
					yourself:
				)
		)
		(super init:)
	)
)

(instance wallPanel of Feature
	(properties
		noun 19
		nsLeft 80
		nsTop 69
		nsRight 123
		nsBottom 86
		sightAngle 40
		approachX 101
		approachY 77
		x 101
		y 110
		z 33
	)
)

