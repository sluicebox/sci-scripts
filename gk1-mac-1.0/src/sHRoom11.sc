;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom11 0
)

(instance sHRoom11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 228 123 172 126 138 127 136 133 60 133 60 137 129 137
							yourself:
						)
				)
				((ScriptID 800 2) doit: 860) ; xDrawThePic
				(gGkMusic1
					number: 860
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(keypad init:)
				(faces init:)
				(bucket init:)
				(drawers init:)
				(jars init:)
				(counter init:)
				(gurney init:)
				(limbs init:)
				(saw1 init:)
				(table init:)
				(saw2 init:)
				(bodies init:)
				(lights init:)
				(door1 init: setCel: 5)
				(self setScript: sEnter)
				(gEgo
					normalize: 1
					posn: 230 126
					init:
					setMotion: MoveTo 215 126 script
				)
			)
			(1
				(RemapColors 0) ; Off
				(breath setCycle: 0)
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
				(breath init: setCycle: Fwd)
				(RemapColors 2 254 125 0) ; ByPercent
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
				(gEgo normalize: 0 setMotion: PolyPath 233 128 self)
			)
			(5
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
		view 860
		loop 4
		signal 16417
	)
)

(instance breath of Prop
	(properties
		view 860
		signal 16417
		cycleSpeed 12
	)

	(method (doit)
		(super doit:)
		(cond
			((and (gTalkers size:) (== global180 1))
				(switch loop
					(0
						(self setCel: 0 setLoop: 2)
					)
					(1
						(self setCel: 0 setLoop: 3)
					)
				)
			)
			((== (gEgo loop:) 8)
				(switch (gEgo cel:)
					(0
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 5) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(1
						(self
							setLoop: 1
							posn: (- (gEgo x:) 5) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(2
						(self
							setLoop: 0
							posn: (gEgo x:) (- (gEgo y:) 44)
							setPri: (+ (gEgo priority:) 1)
						)
					)
					(3
						(self
							setLoop: 0
							posn: (gEgo x:) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(4
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 3) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(5
						(self
							setLoop: 1
							posn: (- (gEgo x:) 3) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(6
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 4) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(7
						(self
							setLoop: 1
							posn: (- (gEgo x:) 4) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
				)
			)
			(else
				(switch (gEgo loop:)
					(0
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 6) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(1
						(self
							setLoop: 1
							posn: (- (gEgo x:) 6) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(2
						(self
							setLoop: 0
							posn: (gEgo x:) (- (gEgo y:) 44)
							setPri: (+ (gEgo priority:) 1)
						)
					)
					(3
						(self
							setLoop: 0
							posn: (gEgo x:) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(4
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 3) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(5
						(self
							setLoop: 1
							posn: (- (gEgo x:) 3) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(6
						(self
							setLoop: 0
							posn: (+ (gEgo x:) 4) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
					(7
						(self
							setLoop: 1
							posn: (- (gEgo x:) 4) (- (gEgo y:) 44)
							setPri: (gEgo priority:)
						)
					)
				)
			)
		)
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
				(sHRoom11 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faces of Feature
	(properties
		noun 3
		modNum 811
		nsLeft 43
		nsTop 49
		nsRight 64
		nsBottom 65
		sightAngle 40
		approachX 53
		approachY 57
		x 53
		y 124
		z 67
	)
)

(instance bucket of Feature
	(properties
		noun 6
		modNum 811
		sightAngle 20
		x 160
		y 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 110 170 122 164 124 157 122 157 110
					yourself:
				)
		)
		(super init:)
	)
)

(instance drawers of Feature
	(properties
		noun 8
		modNum 811
		sightAngle 20
		x 20
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 95 93 99 49 117 49 112
					yourself:
				)
		)
		(super init:)
	)
)

(instance jars of Feature
	(properties
		noun 9
		modNum 811
		sightAngle 20
		x 20
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 90 74 96 48 101 41 101 41 95
					yourself:
				)
		)
		(super init:)
	)
)

(instance counter of Feature
	(properties
		noun 7
		modNum 811
		sightAngle 20
		x 20
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 104 72 93 92 93 92 110 48 135 39 135
					yourself:
				)
		)
		(super init:)
	)
)

(instance gurney of Feature
	(properties
		noun 1
		modNum 811
		sightAngle 20
		x 120
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 126 84 106 94 102 96 94 98 99 105 93 112 93 121 93 121 97 134 97 134 114 131 117 131 110 122 117 120 130 117 130 116 111 108 110 105 119 103 119 104 110 90 117 89 130 84 129
					yourself:
				)
		)
		(super init:)
	)
)

(instance limbs of Feature
	(properties
		noun 10
		modNum 811
		sightAngle 20
		x 37
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 55 79 62 79 65 74 69 74 61 70 59 72 66 70 71 68 68 68 55 72 57
					yourself:
				)
		)
		(super init:)
	)
)

(instance saw1 of Feature
	(properties
		noun 4
		modNum 811
		sightAngle 20
		x 20
		y 140
		z 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 68 51 65 51 47 39 48 38 42 52 42 52 34 55 34 56 43 58 43 58 47 56 48 58 63 62 70 53 74 39 78
					yourself:
				)
		)
		(super init:)
	)
)

(instance saw2 of Feature
	(properties
		noun 4
		modNum 811
		sightAngle 20
		x 211
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 28 235 36 245 35 242 27 248 27 271 50 267 55 251 39 240 42 253 68 264 61 275 54 284 60 283 72 275 65 262 74 284 93 283 106 252 83 230 54 227 31 213 29 213 46 221 48 215 48 219 73 211 90 199 73 209 72 203 62 203 53 204 48 204 31
					yourself:
				)
		)
		(super init:)
	)
)

(instance table of Feature
	(properties
		noun 11
		modNum 811
		sightAngle 20
		x 140
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 155 98 156 116 151 123 135 123 135 103 142 98
					yourself:
				)
		)
		(super init:)
	)
)

(instance lights of Feature
	(properties
		noun 2
		modNum 811
		sightAngle 20
		x 133
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 41 94 46 115 56 104 61 107 67 117 68 122 75 135 75 143 68 129 57 143 42 141 28 153 28 153 54 145 53 136 58 151 67 137 80 137 85 131 90 121 79 116 81 100 75 104 68 96 62 88 62 86 41
					yourself:
				)
		)
		(super init:)
	)
)

(instance bodies of Feature
	(properties
		noun 5
		modNum 811
		nsLeft 88
		nsTop 68
		nsRight 204
		nsBottom 108
		sightAngle 40
		x 146
		y 88
	)
)

