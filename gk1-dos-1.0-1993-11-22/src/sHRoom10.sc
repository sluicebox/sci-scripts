;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom10 0
)

(instance sHRoom10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 206 113 103 113 83 113 42 137
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 187 115 192 129 95 129 105 115
							yourself:
						)
				)
				((ScriptID 800 2) doit: 870) ; xDrawThePic
				(gGkMusic1
					number: 870
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(keypad init:)
				(snake init: setCycle: Fwd setScript: sSounds1)
				(snakeHead init: setCycle: Fwd)
				(goat init: setCycle: Fwd)
				(goatAgain init: setCycle: Fwd)
				(spider init: setCycle: Fwd)
				(spider2 init: setCycle: Fwd)
				(chicken init: setCycle: Fwd)
				(chicken2 init: setCycle: Fwd)
				(chicken3 init: setCycle: Fwd)
				(hamster init: setCycle: Fwd)
				(hamster2 init: setCycle: Fwd)
				(goat1 init:)
				(goat2 init:)
				(chick1 init:)
				(chick2 init:)
				(chick3 init:)
				(tree init:)
				(door1 init: setCel: 5)
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
				(gGkSound1 stop:)
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

(instance sSounds1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gGkSound1 setLoop: 1 number: (Random 871 873) play:)
				(= seconds 5)
			)
			(2
				(gGkSound1 stop:)
				(self changeState: 0)
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
				(gEgo
					view: 801
					setSpeed: 12
					setCel: 0
					setLoop: 0
					setCycle: CT 3 1 self
				)
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
				(gEgo normalize: 0 setMotion: PolyPath 233 128 self)
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
		x 247
		y 125
		priority 1
		fixPriority 1
		view 871
		signal 16417
	)
)

(instance snake of Prop
	(properties
		noun 1
		modNum 810
		x 144
		y 120
		z 40
		priority 127
		fixPriority 1
		view 870
		loop 9
		cel 1
		signal 20513
		cycleSpeed 24
	)
)

(instance snakeHead of Prop
	(properties
		noun 1
		modNum 810
		x 186
		y 52
		view 870
		loop 10
		cel 2
		cycleSpeed 24
	)
)

(instance goat of Prop
	(properties
		noun 3
		modNum 810
		x 68
		y 101
		view 870
		loop 8
	)
)

(instance goatAgain of Prop
	(properties
		noun 3
		modNum 810
		x 40
		y 95
		view 870
		loop 7
		cel 3
		cycleSpeed 18
	)
)

(instance spider of Prop
	(properties
		noun 4
		modNum 810
		x 46
		y 78
		view 870
		loop 2
		cel 3
		cycleSpeed 20
	)
)

(instance spider2 of Prop
	(properties
		noun 4
		modNum 810
		x 70
		y 70
		view 870
		loop 3
		cycleSpeed 18
	)
)

(instance chicken of Prop
	(properties
		noun 2
		modNum 810
		x 99
		y 75
		view 870
		loop 4
		cel 7
	)
)

(instance chicken2 of Prop
	(properties
		noun 2
		modNum 810
		x 103
		y 107
		view 870
		loop 5
		cel 2
	)
)

(instance chicken3 of Prop
	(properties
		noun 2
		modNum 810
		x 189
		y 90
		view 870
		loop 6
		cel 3
	)
)

(instance hamster of Prop
	(properties
		noun 4
		modNum 810
		x 46
		y 67
		view 870
		cel 9
		cycleSpeed 8
	)
)

(instance hamster2 of Prop
	(properties
		noun 4
		modNum 810
		x 71
		y 79
		view 870
		loop 1
		cel 1
		signal 16384
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
				(sHRoom10 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tree of Feature
	(properties
		noun 5
		modNum 810
		sightAngle 40
		x 170
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 109 33 104 40 119 51 129 53 137 65 160 48 177 56 192 49 201 33 213 33 200 41 197 49 179 60 161 53 142 67 145 81 165 83 150 100 142 116 143 123 129 125 118 122 126 114 130 104 143 94 130 79 125 57 117 55 98 39 100 34
					yourself:
				)
		)
		(super init:)
	)
)

(instance goat1 of Feature
	(properties
		noun 3
		modNum 810
		nsLeft 40
		nsTop 84
		nsRight 56
		nsBottom 123
		sightAngle 40
		approachX 48
		approachY 103
		x 48
		y 103
	)
)

(instance goat2 of Feature
	(properties
		noun 3
		modNum 810
		nsLeft 60
		nsTop 83
		nsRight 79
		nsBottom 113
		sightAngle 40
		approachX 69
		approachY 98
		x 69
		y 98
	)
)

(instance chick1 of Feature
	(properties
		noun 2
		modNum 810
		nsLeft 84
		nsTop 62
		nsRight 120
		nsBottom 75
		sightAngle 40
		approachX 102
		approachY 68
		x 102
		y 111
		z 43
	)
)

(instance chick2 of Feature
	(properties
		noun 2
		modNum 810
		nsLeft 84
		nsTop 94
		nsRight 119
		nsBottom 108
		sightAngle 40
		approachX 101
		approachY 101
		x 101
		y 101
	)
)

(instance chick3 of Feature
	(properties
		noun 2
		modNum 810
		nsLeft 172
		nsTop 77
		nsRight 207
		nsBottom 93
		sightAngle 40
		approachX 189
		approachY 85
		x 189
		y 110
		z 25
	)
)

