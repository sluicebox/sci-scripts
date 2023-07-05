;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm580 0
)

(instance rm580 of SQRoom
	(properties
		noun 1
		picture 580
	)

	(method (init)
		(Load 140 581) ; WAVE
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 139 274 139 268 131 314 116 257 100 246 100 275 121 219 126 210 111 200 108 196 103 198 99 194 96 188 93 183 90 171 90 137 121 76 121 112 103 90 103 20 122 0 122
					yourself:
				)
		)
		(switch gPrevRoomNum
			(570
				(gEgo
					posn: 0 132
					init:
					normalize:
					setScaler: Scaler 100 35 126 91
					setScript: egoEntersRoom570
				)
			)
			(590
				(gEgo
					init:
					normalize:
					setScaler: Scaler 100 35 126 91
					setScript: egoEntersRoom590
				)
			)
			(else
				(gEgo
					posn: 0 132
					init:
					normalize:
					setScaler: Scaler 100 35 126 91
					setScript: egoEntersRoom570
				)
			)
		)
		(flickerLight1 init: setScript: (blinkABit new:) 0 short)
		(flickerLight2 init: setScript: (blinkABit new:) 0 short2)
		(files1 init:)
		(files2 init:)
		(files3 init:)
		(fireSquirter init:)
		(exitSign init:)
		(pipes1 init:)
		(pipes2 init:)
		(pipes3 init:)
		(paper1 init:)
		(paper2 init:)
		(column1 init:)
		(column2 init:)
		(column3 init:)
		(column4 init:)
		(column5 init:)
		(light1 init:)
		(light2 init:)
		(light3 init:)
		(floor init:)
		(ceiling1 init:)
		(ceiling2 init:)
		(ceiling3 init:)
		(sign1 init:)
		(sign2 init:)
		(sign3 init:)
		(ladder1 init:)
		(ladder2 init:)
		(ladder3 init:)
		(exit570 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(exit590 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(gGSound1 number: 580 loop: -1 play: setVol: 127)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(short stop:)
		(short2 stop:)
		(super dispose: &rest)
	)
)

(instance egoEntersRoom570 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 30 (gEgo y:) self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoEntersRoom590 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global152
					(1
						(gEgo posn: 90 108 setMotion: MoveTo 68 116 self)
					)
					(2
						(gEgo posn: 178 89 setMotion: MoveTo 178 93 self)
					)
					(3
						(gEgo posn: 259 101 setMotion: MoveTo 274 112 self)
					)
				)
			)
			(1
				(= global152 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blinkABit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 180 360))
			)
			(1
				(if register
					(register play: setVol: 127)
				)
				(client setCycle: Fwd)
				(= ticks (Random 60 120))
			)
			(2
				(if register
					(register stop:)
				)
				(client setCycle: 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance flickerLight1 of Prop
	(properties
		noun 9
		sightAngle 40
		x 174
		y 14
		view 580
		cycleSpeed 8
	)
)

(instance flickerLight2 of Prop
	(properties
		noun 9
		sightAngle 40
		x 172
		y 46
		view 580
		loop 1
		cycleSpeed 8
	)
)

(instance files1 of Feature
	(properties
		noun 3
		sightAngle 40
		x 43
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 38 0 87 27 87 102 23 120 0 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance files2 of Feature
	(properties
		noun 3
		sightAngle 40
		x 131
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 0 136 0 175 69 175 81 173 82 128 119 87 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance files3 of Feature
	(properties
		noun 3
		sightAngle 40
		x 224
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 218 0 267 0 266 119 224 119 181 80 181 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fireSquirter of Feature
	(properties
		noun 4
		sightAngle 40
		x 109
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 82 110 80 115 85 112 89 111 90 111 100 104 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitSign of Feature
	(properties
		noun 5
		sightAngle 40
		x 9
		y 63
		z 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 12 18 12 18 24 0 24 yourself:)
		)
		(super init: &rest)
	)
)

(instance pipes1 of Feature
	(properties
		noun 6
		sightAngle 40
		x 167
		y 61
		z 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 82 0 83 6 249 6 249 0 259 0 259 119 249 119 248 13 83 13 78 12 76 9 76 8 75 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pipes2 of Feature
	(properties
		noun 6
		sightAngle 40
		x 301
		y 60
		z 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 296 0 306 0 306 112 296 110
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pipes3 of Feature
	(properties
		noun 6
		sightAngle 40
		x 21
		y 61
		z 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 18 0 24 0 24 120 18 120 yourself:)
		)
		(super init: &rest)
	)
)

(instance paper1 of Feature
	(properties
		noun 7
		sightAngle 40
		x 133
		y 128
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 124 146 128 139 133 133 131 129 133 121 130
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance paper2 of Feature
	(properties
		noun 7
		sightAngle 40
		x 199
		y 117
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 115 193 113 213 113 210 120 203 122 196 119 189 117
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance column1 of Feature
	(properties
		noun 8
		sightAngle 40
		x 283
		y 60
		z 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 0 288 0 288 108 285 107 280 107 279 104
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance column2 of Feature
	(properties
		noun 8
		sightAngle 40
		x 207
		y 60
		z 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 0 211 0 211 107 203 106 202 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance column3 of Feature
	(properties
		noun 8
		sightAngle 40
		x 192
		y 60
		z 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 0 195 0 195 93 191 91
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance column4 of Feature
	(properties
		noun 8
		sightAngle 40
		x 186
		y 60
		z 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 0 188 0 188 86 185 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance column5 of Feature
	(properties
		noun 8
		sightAngle 40
		x 182
		y 60
		z 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 24 183 80 180 80 180 24
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light1 of Feature
	(properties
		noun 9
		sightAngle 40
		x 174
		y 40
		z 33
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 13 167 13 165 18 182 18
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light2 of Feature
	(properties
		noun 9
		sightAngle 40
		x 174
		y 40
		z 11
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 174 24 169 34 179 34 yourself:)
		)
		(super init: &rest)
	)
)

(instance light3 of Feature
	(properties
		noun 9
		sightAngle 40
		x 173
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 45 173 37 170 46 172 62 177 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance floor of Feature
	(properties
		noun 10
		sightAngle 40
		x 160
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 24 120 87 102 87 120 128 120 176 78 180 79 226 120 267 120 267 101 320 116 320 139 0 139 0 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ceiling1 of Feature
	(properties
		noun 11
		sightAngle 40
		x 63
		y 13
	)

	(method (init)
		(self
			setPolygon: ((Polygon new:) type: PTotalAccess init: 38 0 88 0 87 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance ceiling2 of Feature
	(properties
		noun 11
		sightAngle 40
		x 176
		y 35
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 0 217 0 181 70 175 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ceiling3 of Feature
	(properties
		noun 11
		sightAngle 40
		x 293
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 0 320 0 319 5 267 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sign1 of Feature
	(properties
		noun 12
		nsTop 64
		nsRight 13
		nsBottom 76
		sightAngle 40
		x 7
		y 61
		z 61
	)
)

(instance sign2 of Feature
	(properties
		noun 12
		nsLeft 99
		nsTop 63
		nsRight 117
		nsBottom 76
		sightAngle 40
		x 108
		y 60
		z 60
	)
)

(instance sign3 of Feature
	(properties
		noun 12
		nsLeft 230
		nsTop 63
		nsRight 248
		nsBottom 76
		sightAngle 40
		x 239
		y 60
		z 60
	)
)

(instance ladder1 of Feature
	(properties
		noun 2
		sightAngle 40
		x 299
		y 113
		z 25
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 55 319 54 319 38 317 42 317 53 278 128 278 136 292 138 306 139 304 135 320 129 320 124 303 128 288 125 291 116 306 119 309 115 295 112 298 104 313 105 315 101 301 99 307 89 319 91 320 87 312 86 319 75 320 74 320 70 318 70 320 65
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ladder2 of Feature
	(properties
		noun 2
		sightAngle 40
		x 304
		y 109
		z 42
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 35 317 35 289 90 289 95 292 100 293 97 292 93 292 91 318 38 320 38
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ladder3 of Feature
	(properties
		noun 2
		sightAngle 40
		x 304
		y 109
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 91 305 120 289 124 297 127 303 125 301 127 310 126 311 123 320 121 320 117 314 118 320 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit570 of ExitFeature
	(properties
		nsTop 80
		nsRight 7
		nsBottom 138
		approachY 130
		y 110
		z 110
		nextRoom 570
		message 8
	)
)

(class DoubleExit of ExitFeature
	(properties
		leftPoly 0
		midPoly 0
		rtPoly 0
		approachLeft 0
		approachMiddle 0
		approachRight 0
	)

	(method (handleEvent event)
		(cond
			(
				(and
					approachLeft
					leftPoly
					(leftPoly onMe: (event x:) (event y:))
				)
				(= approachX (>> approachLeft $0008))
				(= approachY (>> (<< approachLeft $0008) $0008))
				(= global152 1)
			)
			(
				(and
					approachMiddle
					midPoly
					(midPoly onMe: (event x:) (event y:))
				)
				(= approachX (>> approachMiddle $0008))
				(= approachY (>> (<< approachMiddle $0008) $0008))
				(= global152 2)
			)
			((and approachRight rtPoly (rtPoly onMe: (event x:) (event y:)))
				(= approachX (>> approachRight $0008))
				(= approachY (>> (<< approachRight $0008) $0008))
				(= global152 3)
			)
		)
		(super handleEvent: event &rest)
	)
)

(instance exit590 of DoubleExit
	(properties
		x 177
		y 73
		nextRoom 590
		message 9
		approachLeft 20820
		approachMiddle 45657
		approachRight -176
	)

	(method (init)
		(self
			setPolygon:
				(= leftPoly
					((Polygon new:)
						type: PTotalAccess
						init: 76 57 86 57 86 111 76 111
						yourself:
					)
				)
				(= midPoly
					((Polygon new:)
						type: PTotalAccess
						init: 170 65 184 65 184 82 170 82
						yourself:
					)
				)
				(= rtPoly
					((Polygon new:)
						type: PTotalAccess
						init: 266 56 278 56 278 105 266 105
						yourself:
					)
				)
		)
		(super init: &rest)
	)
)

(instance short of Sound
	(properties
		number 581
		loop 0
	)
)

(instance short2 of Sound
	(properties
		number 581
		loop 0
	)
)

