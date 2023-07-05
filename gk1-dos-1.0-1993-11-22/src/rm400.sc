;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use System)

(public
	rm400 0
)

(instance rm400 of Room
	(properties
		noun 1
		picture 400
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(gGkMusic1
			number: 442
			setLoop: -1
			stop:
			play:
			setVol: 0
			fade: 127 5 10 0
		)
		(self setRegions: 401) ; JacksonSq
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 145 319 145 319 137 307 133 301 126 284 126 282 128 269 128 263 126 220 126 217 128 207 128 202 126 156 126 152 128 140 128 136 126 94 126 86 128 76 128 71 126 0 126
					yourself:
				)
		)
		(railing init:)
		(binoc1 init: approachVerbs: 8) ; Operate
		(binoc2 init: approachVerbs: 8) ; Operate
		(binoc3 init: approachVerbs: 8) ; Operate
		(binoc4 init: approachVerbs: 8) ; Operate
		(plant init:)
		(sky init:)
		(redBuilding init:)
		(church init:)
		(sidewalk init:)
		(pontalba init:)
		(southExit init:)
		(gWalkHandler add: leftExit)
		(gWalkHandler add: rightExit)
		(leftExit init: approachVerbs: 13) ; Walk
		(rightExit init: approachVerbs: 13) ; Walk
		(gCurRoom setScript: sBackFromBinocs)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gWalkHandler delete: leftExit)
		(gWalkHandler delete: rightExit)
		(DisposeScript 21)
		(super dispose:)
	)
)

(instance sLookThroughBinocs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 400
					setLoop:
						(switch register
							(410 0)
							(420 3)
							(430 1)
							(440 2)
						)
					setCycle: End self
				)
			)
			(1
				(gGame setCursor: gTheCursor 1 160 90)
				(SetCursor 107 86 212 106)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance sBackFromBinocs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gPrevRoomNum
					(410 ; neJackson
						(gEgo
							view: 400
							setCel: 8
							setLoop: 0
							init:
							posn: 65 129
							state: 2
							setScale: 0
							setCycle: Beg self
						)
						(= register 6)
						(if (and (IsFlag 314) (not (IsFlag 418)))
							(SetFlag 418)
							(gMessager say: 21 0 3) ; "!!!Blank msg"
						)
					)
					(420 ; nwJackson
						(gEgo
							view: 400
							setCel: 5
							setLoop: 3
							init:
							posn: 294 129
							setScale: 0
							state: 2
							setCycle: Beg self
						)
						(= register 7)
					)
					(430 ; seJackson
						(gEgo
							view: 400
							setCel: 7
							setLoop: 1
							init:
							posn: 148 129
							setScale: 0
							state: 2
							setCycle: Beg self
						)
						(= register 3)
					)
					(440 ; swJackson
						(gEgo
							view: 400
							setCel: 5
							setLoop: 2
							init:
							posn: 228 129
							state: 2
							setScale: 0
							setCycle: Beg self
						)
						(= register 7)
					)
					(else
						(gEgo
							normalize: 3
							init:
							posn: 160 170
							state: 2
							setCycle: StopWalk -1
							setScale: 0
							setMotion: MoveTo 160 140 self
						)
						(= register 3)
					)
				)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
			)
			(1
				(gGame handsOn:)
				(gCurRoom south: 200)
				(gEgo normalize: register)
				(self dispose:)
			)
		)
	)
)

(instance railing of Feature
	(properties
		noun 2
		nsTop 97
		nsRight 319
		nsBottom 128
		sightAngle 40
		approachX 159
		approachY 112
		x 159
		y 112
	)
)

(instance binoc1 of Feature
	(properties
		noun 12
		sightAngle 20
		approachX 65
		approachY 128
		x 81
		y 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gCurRoom setScript: sLookThroughBinocs 0 410)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 126 80 86 77 86 76 81 75 80 75 77 83 77 89 79 91 81 88 82 88 86 83 86 83 125 88 128 84 130 78 130 73 126
					yourself:
				)
		)
		(super init:)
	)
)

(instance binoc2 of Feature
	(properties
		noun 13
		sightAngle 20
		approachX 148
		approachY 128
		x 147
		y 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gCurRoom setScript: sLookThroughBinocs 0 430)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 145 125 145 86 140 86 139 80 141 78 151 78 153 79 153 86 148 86 148 124 150 124 154 126 149 128 144 128 138 126 141 125
					yourself:
				)
		)
		(super init:)
	)
)

(instance binoc3 of Feature
	(properties
		noun 14
		sightAngle 20
		approachX 228
		approachY 128
		x 212
		y 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gCurRoom setScript: sLookThroughBinocs 0 440)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 88 206 87 205 82 202 82 204 78 222 78 222 81 217 81 217 86 213 87 213 124 218 124 218 127 211 128 205 127 206 124 210 124
					yourself:
				)
		)
		(super init:)
	)
)

(instance binoc4 of Feature
	(properties
		noun 15
		sightAngle 20
		approachX 294
		approachY 127
		x 275
		y 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(gCurRoom setScript: sLookThroughBinocs 0 420)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 88 269 87 268 82 262 80 265 78 281 78 280 83 277 86 277 124 282 125 280 128 270 128 267 126 274 124
					yourself:
				)
		)
		(super init:)
	)
)

(instance plant of Feature
	(properties
		noun 18
		sightAngle 20
		approachX 248
		approachY 124
		x 311
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 130 309 128 304 107 315 104 314 74 296 63 267 40 269 30 289 41 277 21 295 22 313 39 305 21 319 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance church of Feature
	(properties
		noun 3
		sightAngle 20
		x 129
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 81 58 65 68 57 72 57 72 42 78 21 84 42 84 56 88 50 92 58 92 43 99 43 99 25 101 21 118 21 121 26 121 43 129 43 129 59 133 50 137 59 137 42 144 23 149 44 149 75 139 76 135 82 130 77 123 75 119 72 112 79 116 84 108 86 99 81 91 81 87 77 75 77 76 83 79 87 67 87 68 81 64 77
					yourself:
				)
		)
		(super init:)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 140
		nsLeft 9
		nsBottom 145
		nsRight 231
		cursor 964
		exitDir 3
	)
)

(instance sky of Feature
	(properties
		noun 19
		nsTop 21
		nsRight 319
		nsBottom 57
		sightAngle 40
		approachX 159
		approachY 39
		x 159
		y 79
	)
)

(instance redBuilding of Feature
	(properties
		noun 20
		nsLeft 228
		nsTop 65
		nsRight 314
		nsBottom 86
		sightAngle 40
		approachX 271
		approachY 75
		x 271
		y 80
	)
)

(instance sidewalk of Feature
	(properties
		noun 16
		nsLeft 159
		nsTop 95
		nsRight 232
		nsBottom 111
		sightAngle 40
		approachX 195
		approachY 103
		x 195
		y 113
	)
)

(instance pontalba of Feature
	(properties
		noun 17
		nsLeft 153
		nsTop 63
		nsRight 199
		nsBottom 87
		sightAngle 40
		approachX 176
		approachY 75
		x 176
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 76 153 69 160 65 190 65 197 72 197 75 189 76 188 83 181 87 169 85 165 82 156 81
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftExit of Feature
	(properties
		nsTop 21
		nsRight 11
		nsBottom 154
		sightAngle 40
		approachX 12
		approachY 134
		x 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gMessager say: 1 13 4) ; "(GK-AM2)There's nothing of interest in that direction."
				(return 1)
			)
		)
	)
)

(instance rightExit of Feature
	(properties
		nsLeft 302
		nsTop 21
		nsRight 319
		nsBottom 151
		sightAngle 40
		approachX 304
		approachY 136
		x 310
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gMessager say: 1 13 4) ; "(GK-AM2)There's nothing of interest in that direction."
				(return 1)
			)
		)
	)
)

