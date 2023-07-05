;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6607)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	avianSchool08 0
)

(instance avianSchool08 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6610 ; avianSchool11
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceSE
						(southEastMural init: global117)
					)
					(faceSW
						(rightSouthWestMural init: global117)
						(leftSouthWestMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceSE
						(southEastMural dispose:)
					)
					(faceSW
						(rightSouthWestMural dispose:)
						(leftSouthWestMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 180
		picture 6627
		edgeS 0
		edgeN 0
	)

	(method (init &tmp temp0)
		(= picture
			(switch (= temp0 [global235 1])
				(0 6647)
				(1 6648)
				(2 6649)
				(3 6650)
			)
		)
		(if (OneOf temp0 3 2)
			(rampExit init:)
			(gCurRoom exitN: rampExit)
		)
		(super init:)
		(podium_180 init:)
		(ramp_180 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6629
		edgeS 0
		edgeN 0
	)

	(method (init)
		(muralExit init:)
		(gCurRoom exitN: muralExit)
		(super init:)
		(mural_0 init:)
		(desks_0 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 90
		picture 6630
		edgeS 0
		edgeN 0
	)

	(method (init)
		(projectorExit init:)
		(gCurRoom exitN: projectorExit)
		(super init:)
		(murals_90 init:)
		(desks_90 init:)
		(projector_90 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 270
		picture 6628
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(desks_270 init:)
	)
)

(instance rightSouthWestMural of View
	(properties
		x 362
		y 177
		loop 2
		cel 2
		view 6626
	)
)

(instance leftSouthWestMural of View
	(properties
		x 50
		y 172
		loop 2
		cel 1
		view 6626
	)
)

(instance southEastMural of View
	(properties
		x 269
		y 155
		loop 2
		view 6626
	)
)

(instance rampExit of ExitFeature
	(properties
		nsBottom 220
		nsLeft 234
		nsRight 400
		nsTop 60
		nextRoom 6610
	)
)

(instance projectorExit of ExitFeature
	(properties
		nsBottom 243
		nsLeft 218
		nsRight 411
		nsTop 82
		nextRoom 6602
	)
)

(instance muralExit of ExitFeature
	(properties
		nsBottom 172
		nsLeft 203
		nsRight 465
		nsTop 21
		nextRoom 6608
	)
)

(instance podium_180 of Feature
	(properties
		noun 42
		x 162
		y 36
		nsBottom 62
		nsLeft 116
		nsRight 208
		nsTop 11
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ramp_180 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 62 268 65 326 122 354 154 460 265 394 274 300 152 271 121 213 117 216 57
					yourself:
				)
		)
	)
)

(instance projector_90 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 165 302 133 368 120 415 126 373 156 345 168 339 168 333 191 307 198 287 187
					yourself:
				)
		)
	)
)

(instance murals_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 103 54 97 148 105 159 117 160 148 153 154 60 156 40 149
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 359 122 354 108 360 104 455 98 467 107 450 120 418 129 389 117 347 121
					yourself:
				)
		)
	)
)

(instance desks_90 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 249 52 231 49 206 94 191 128 188 102 211 83 248 58 259 11 255 1 261
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 231 176 281 158 274 185 259 190 234 187
					yourself:
				)
		)
	)
)

(instance mural_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 211 47 223 30 461 48 470 61 449 157 423 172 219 176 206 168
					yourself:
				)
		)
	)
)

(instance desks_0 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 269 311 263 320 289 259 292
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 385 269 452 263 454 296 382 291
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 521 268 592 266 589 291 533 293
					yourself:
				)
		)
	)
)

(instance desks_270 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 218 283 217 364 244 383 282 333 291 313 291 240 229
					yourself:
				)
		)
	)
)

