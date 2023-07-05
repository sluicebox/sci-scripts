;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5206)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	humanPlazaRm6 0
)

(instance humanPlazaRm6 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5203 ; humanPlazaRm3
				(self
					addPicObj:
						faceControls
						faceMaze
						faceCenter
						facePent
						faceControls
				)
			)
			(5212 ; humanPlazaRm12
				(self
					addPicObj:
						faceCenter
						facePent
						faceControls
						faceMaze
						faceCenter
				)
			)
			(else
				(self
					addPicObj:
						faceCenter
						facePent
						faceControls
						faceMaze
						faceCenter
				)
			)
		)
	)
)

(instance faceControls of CameraAngle
	(properties
		heading 180
		picture 5224
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToControls init:)
		(walls_180 init:)
		(alley_180 init:)
		(super init: &rest)
	)
)

(instance faceCenter of CameraAngle
	(properties
		picture 5226
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToCenter init:)
		(walls_0 init:)
		(exit_0 init:)
		(super init: &rest)
	)
)

(instance faceMaze of CameraAngle
	(properties
		heading 270
		picture 5223
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance facePent of CameraAngle
	(properties
		heading 90
		picture 5225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_90 init:)
		(subDoor_90 init:)
		(pentahedron_90 init:)
		(super init: &rest)
	)
)

(instance exitToCenter of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5203
	)
)

(instance exitToControls of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5212
	)
)

(instance walls_0 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -1 591 0 589 180 -1 180
					yourself:
				)
		)
	)
)

(instance exit_0 of Feature
	(properties
		noun 28
		x 298
		y 90
		nsBottom 180
		nsLeft 281
		nsRight 316
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_90 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 590 -1 590 215 565 208 563 196 391 184 238 182 238 181 163 181 116 179 116 181 74 180 22 180 -1 180
					yourself:
				)
		)
	)
)

(instance subDoor_90 of Feature
	(properties
		noun 1
	)

	(method (init)
		(= case (if (IsFlag 308) 2 else 1))
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 168 101 168 102 181 90 181
					yourself:
				)
		)
	)
)

(instance pentahedron_90 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 165 152 164 176 146 176 yourself:)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 590 0 590 191 374 192 238 193 232 202 197 213 95 220 -1 226
					yourself:
				)
		)
	)
)

(instance alley_180 of Feature
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
					init: 242 -1 370 0 372 193 239 193
					yourself:
				)
		)
	)
)

(instance walls_270 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 -1 591 0 590 181 369 180 369 183 320 184 319 187 -1 193
					yourself:
				)
		)
	)
)

