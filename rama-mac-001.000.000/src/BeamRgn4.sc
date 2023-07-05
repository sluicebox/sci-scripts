;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2043)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use InvInitialize)
(use cplainRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	BeamRgn4 0
)

(instance BeamRgn4 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2041 ; BeamRgn2
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		((ScriptID 200 0) addMigrant: 11 73) ; cplainRegion
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2111
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(beam_0 init:)
		(sea_0 init:)
		(northHCyl_0 init:)
		(canyon_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2114
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 64)
			(= picture 2147)
			(if
				(or
					(IsFlag 67)
					(and
						(== (proc70_9 21) -1)
						(not (proc55_5 22))
						(not (IsFlag 121))
					)
				)
				(lilReggie init: global117 setScript: reggieAtTrashScript)
			)
		)
		(twoExit_90 init:)
		(super init: &rest)
		(lights_90 init:)
		(sea_90 init:)
		(if (IsFlag 64)
			(trashBiot_90 init:)
		else
			(trashDown_90 init:)
		)
	)
)

(instance reggieAtTrashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance lilReggie of Prop
	(properties
		x 309
		y 179
		view 2049
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2113
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(matrixL31x init: global117)
		(artifacts_180 init:)
		(lights_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2112
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 58)
			(= picture 2145)
		)
		(super init: &rest)
		(CPMapPiece_2 init: global117)
		(if (IsFlag 58)
			(mp_B22x_InCube init: global117)
		)
		(if (not (IsFlag 58))
			(waxCube_270 init:)
		)
		(sea_270 init:)
		(lights_270 init:)
		(canyon_270 init:)
	)
)

(instance mp_B22x_InCube of View
	(properties
		x 287
		y 79
		view 2021
		cel 8
	)

	(method (init)
		(if (!= (proc70_9 55) 2043)
			(return)
		)
		(super init: &rest)
		(if (IsFlag 58)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 55 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance CPMapPiece_2 of MigratingView
	(properties
		x 191
		y 279
		view 2021
		cel 5
		invItemID 11
	)
)

(instance matrixL31x of MigratingView
	(properties
		x 449
		y 226
		view 2021
		loop 1
		invItemID 73
	)
)

(instance waxCube_270 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 14 409 15 407 178 374 187 355 224 388 265 353 288 217 269 213 267 220 233 239 223 221 184 188 180
					yourself:
				)
		)
	)
)

(instance sea_270 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 463 3 590 2 588 72 562 76 502 51
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 123 21 183 18 183 32 122 31
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 412 19 466 19 469 33 410 31
					yourself:
				)
		)
	)
)

(instance beam_0 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 127 588 0 591 98 125 191
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 19)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_0 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 2 195 2 187 52 203 97 157 109 95 58
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 396 2 536 2 532 9 397 43 395 22
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 0 393 2 396 43 206 96 187 47
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 7
		nsLeft 124
		nsTop 19
		nsRight 466
		nsBottom 31
		x 295
		y 25
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_90 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 -1 129 0 106 36 54 67 0 85
					yourself:
				)
		)
	)
)

(instance artifacts_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 244 200 346 176 383 209 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 17 130 16 109 36 101 35 123
					yourself:
				)
		)
	)
)

(instance lights_180 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 44 414 0 461 1 378 25 249 59
					yourself:
				)
		)
	)
)

(instance canyon_270 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 188 -2 156 188 150 188 158 183 159 184 182 215 183 224 204 136 198 57 191
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 352 221 363 201 371 201 382 182 410 181 411 165 592 164 592 265 553 256 489 251
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1)
			(144
				(proc1111_31 noun)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canyon_0 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 148 79 146 129 198 300 160 376 164 412 166 509 178 454 183 361 205 115 291 -3 291
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1)
			(144
				(proc1111_31 noun)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trashBiot_90 of Feature
	(properties
		noun 9
		nsLeft 282
		nsTop 131
		nsRight 341
		nsBottom 177
		x 311
		y 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance trashDown_90 of Feature
	(properties
		noun 9
		nsLeft 296
		nsTop 162
		nsRight 340
		nsBottom 175
		x 318
		y 168
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance twoExit_90 of ExitFeature
	(properties
		nsLeft 162
		nsTop 107
		nsRight 452
		nsBottom 223
		x 307
		y 165
		nextRoom 2041
	)
)

