;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm800 0
)

(instance rm800 of Room
	(properties
		picture 800
		horizon 103
		north 810
	)

	(method (init)
		(if (!= gPrevRoomNum 17) ; MapRoom
			(= style 0)
		else
			(= style 9)
		)
		(super init: &rest)
		(leftPalm init:)
		(centerPalm init:)
		(rightPalm init:)
		(sidePlants init:)
		(house init:)
		(mountain init:)
		(plants init:)
		(leftLawn init:)
		(rightLawn init:)
		(sky init:)
		(if (== gPrevRoomNum 17) ; MapRoom
			(if
				(or
					(> gDay 3)
					(and (gPqFlags test: 139) (gPqFlags test: 92))
				)
				(gPqFlags clear: 143)
			else
				(gPqFlags set: 143)
			)
		)
		(if (gPqFlags test: 143)
			(car init:)
		)
		(door init: approachVerbs: 4) ; Do
		(if (<= 3 gDay 8)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 252 154 318 156 264 138 296 117 295 111 267 106 242 114 220 129 167 117 149 112 147 107 156 104 165 104 164 98 147 98 154 101 154 103 134 106 128 108 131 111 174 122 220 136 242 146
						yourself:
					)
			)
			(if (== gDay 3)
				(tape init:)
			)
			(scene init:)
			(chalk init:)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 251 158 319 154 157 114 148 112 147 109 150 105 161 105 161 102 155 102 129 107 124 109 133 112 168 120 222 138
						yourself:
					)
			)
		)
		(switch gPrevRoomNum
			(810
				(gEgo
					setHeading: 225
					normalize: 0
					posn: 143 108 0
					setScaler: Scaler 82 28 159 99
					init:
					setMotion: PolyPath 140 120
				)
			)
			(860
				(gEgo
					setHeading: 225
					normalize: 0
					x: 143
					y: 108
					setScaler: Scaler 82 28 159 99
					init:
					setMotion: PolyPath 140 120
				)
			)
			(else
				(gEgo
					setHeading: 315
					normalize: 0
					posn: 287 150 0
					setScaler: Scaler 82 28 159 99
					init:
					setMotion: PolyPath 222 135
				)
			)
		)
		(puzzle init: approachVerbs: 1) ; Look
		(if (not (OneOf gPrevRoomNum 810 860))
			(gGlobalSound0 number: 801 setLoop: -1 play: setVol: 0 fade: 127 2 2 0)
		)
		(gGame handsOn:)
		(gTheIconBar show: 0)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (> (gEgo y:) 151))
			(self setScript: goToMap)
		)
	)
)

(instance leftPalm of Feature
	(properties
		noun 11
		nsLeft 93
		nsTop 104
		nsRight 104
		nsBottom 109
		sightAngle 40
		approachX 98
		approachY 106
		approachDist 0
		x 98
		y 106
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 109 93 56 85 59 76 56 69 60 67 54 74 43 64 41 69 21 103 16 115 22 110 32 119 29 127 42 115 55 100 60 99 88 103 109
					yourself:
				)
		)
	)
)

(instance centerPalm of Feature
	(properties
		noun 11
		nsLeft 139
		nsTop 99
		nsRight 148
		nsBottom 102
		sightAngle 40
		approachX 143
		approachY 100
		approachDist 0
		x 143
		y 100
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 138 103 140 46 128 43 122 29 115 21 140 10 161 17 158 26 170 28 167 38 144 45 145 85 146 103
					yourself:
				)
		)
	)
)

(instance sidePlants of Feature
	(properties
		noun 6
		sightAngle 40
		approachX 143
		approachY 100
		approachDist 0
		x 43
		y 120
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 107 32 112 40 112 45 107 46 112 62 108 68 112 71 112 79 117 81 119 86 119 90 125 82 128 66 128 61 131 47 131 21 129 0 123
					yourself:
				)
		)
	)
)

(instance rightPalm of Feature
	(properties
		noun 11
		nsLeft 279
		nsTop 92
		nsRight 288
		nsBottom 96
		sightAngle 40
		approachX 283
		approachY 94
		approachDist 0
		x 283
		y 94
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 95 280 66 259 55 265 50 257 41 267 40 267 38 261 32 267 32 270 27 279 28 289 25 296 30 294 36 305 36 304 54 294 58 294 63 286 64 288 95
					yourself:
				)
		)
	)
)

(instance house of Feature
	(properties
		noun 3
		nsLeft 145
		nsTop 91
		nsRight 159
		nsBottom 100
		sightAngle 40
		approachX 152
		approachY 95
		approachDist 0
		x 152
		y 85
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 93 127 103 6 103 6 50 3 51 4 48 8 46 8 16 18 16 18 38 60 21 102 21 130 9 209 30 228 28 238 38 234 41 234 48 279 63
					yourself:
				)
		)
	)
)

(instance mountain of Feature
	(properties
		noun 12
		nsLeft 298
		nsTop 84
		nsRight 307
		nsBottom 90
		sightAngle 40
		approachX 302
		approachY 87
		approachDist 0
		x 302
		y 87
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 76 301 65 319 67 319 90 278 90
					yourself:
				)
		)
	)
)

(instance plants of Feature
	(properties
		noun 5
		nsLeft 195
		nsTop 102
		nsRight 201
		nsBottom 106
		sightAngle 40
		approachX 198
		approachY 104
		approachDist 0
		x 198
		y 104
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 105 165 103 243 92 244 96 224 104 198 108
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; caseGlassJar
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2) ; "If you suspect hidden evidence, you'll need to look"
				)
			)
			(52 ; notebook
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2) ; "What about the flower bed deserves notation?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftLawn of Feature
	(properties
		noun 7
		nsLeft 71
		nsTop 126
		nsRight 78
		nsBottom 129
		sightAngle 40
		approachX 74
		approachY 127
		approachDist 0
		x 74
		y 119
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 105 121 108 124 112 164 123 214 140 237 153 0 153 0 82 24 81 26 104 129 104
					yourself:
				)
		)
	)
)

(instance rightLawn of Feature
	(properties
		noun 7
		nsLeft 261
		nsTop 113
		nsRight 273
		nsBottom 119
		sightAngle 40
		approachX 267
		approachY 116
		approachDist 0
		x 267
		y 115
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 146 158 113 151 110 151 108 155 106 163 106 194 109 226 104 249 95 319 99
					yourself:
				)
		)
	)
)

(instance scene of Feature
	(properties
		noun 2
		nsLeft 261
		nsTop 113
		nsRight 273
		nsBottom 119
		sightAngle 40
		approachX 267
		approachY 116
		approachDist 0
		x 267
		y 116
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 126 237 101 269 94 308 96 312 115 311 130 260 134
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; notebook
			(if (gPqPointFlags test: 36)
				(gMessager say: noun theVerb 3 0) ; "The information has already been notated."
			else
				(gCurRoom setScript: noteSceneScr)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sky of Feature
	(properties
		noun 8
		nsRight 319
		nsBottom 74
		sightAngle 40
		approachX 159
		approachY 37
		approachDist 0
		x 159
		y 37
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 120
		nsTop 71
		nsRight 133
		nsBottom 99
		sightAngle 40
		approachX 150
		approachY 105
		approachDist 0
		x 126
		y 95
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gPqFlags set: 46)
				(gCurRoom newRoom: 810)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tape of Prop
	(properties
		noun 9
		x 225
		y 116
		z 12
		priority 20
		fixPriority 1
		view 801
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; notebook
			(if (gPqPointFlags test: 36)
				(gMessager say: 2 theVerb 3 0) ; "The information has already been notated."
			else
				(gCurRoom setScript: noteSceneScr)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance chalk of View
	(properties
		noun 10
		x 282
		y 121
		priority 20
		fixPriority 1
		view 801
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 52) ; notebook
			(if (gPqPointFlags test: 36)
				(gMessager say: 2 theVerb 3 0) ; "The information has already been notated."
			else
				(gCurRoom setScript: noteSceneScr)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance car of View
	(properties
		noun 4
		x 266
		y 93
		priority 10
		fixPriority 1
		view 800
	)
)

(instance puzzle of Feature
	(properties
		noun 5
		nsLeft 186
		nsTop 84
		nsRight 203
		nsBottom 100
		sightAngle 40
		approachX 161
		approachY 105
		approachDist 0
		x 194
		y 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; caseGlassJar
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2) ; "If you suspect hidden evidence, you'll need to look"
				)
			)
			(52 ; notebook
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2) ; "What about the flower bed deserves notation?"
				)
			)
			(1 ; Look
				(gCurRoom setInset: (ScriptID 20 0)) ; shoeInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance goToMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 165 self)
			)
			(1
				(gCurRoom newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance noteSceneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 2 36)
				((ScriptID 39 0) init: self) ; NotebookOut
			)
			(1
				(gMessager say: 2 52 0 0 self) ; "Notating the crime scene's relationship to the house"
			)
			(2
				((ScriptID 39 1) init: self) ; NotebookIn
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

