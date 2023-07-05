;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5204)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	humanPlazaRm4 0
)

(instance humanPlazaRm4 of Location
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
						faceMaze
						faceArthurAlley
						faceCenter
						faceHumanLair
						faceMaze
				)
			)
			(5207 ; humanPlazaRm7
				(self
					addPicObj:
						faceArthurAlley
						faceCenter
						faceHumanLair
						faceMaze
						faceArthurAlley
				)
			)
			(else
				(self
					addPicObj:
						faceCenter
						faceHumanLair
						faceMaze
						faceArthurAlley
						faceCenter
				)
			)
		)
	)
)

(instance faceCenter of CameraAngle
	(properties
		heading 180
		picture 5218
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToCenter init:)
		(walls_180 init:)
		(alley_180 init:)
		(super init: &rest)
	)
)

(instance faceMaze of CameraAngle
	(properties
		picture 5216
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMaze init:)
		(walls_0 init:)
		(exit_0 init:)
		(super init: &rest)
	)
)

(instance faceHumanLair of CameraAngle
	(properties
		heading 270
		picture 5217
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToHumanLair init:)
		(walls_270 init:)
		(lairDoor_270 init:)
		(super init: &rest)
	)
)

(instance faceArthurAlley of CameraAngle
	(properties
		heading 90
		picture 5215
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_90 init:)
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

(instance exitToMaze of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5523
		exitStyle 256
	)
)

(instance exitToHumanLair of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5207
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
					init: 1 -1 592 0 592 191 510 192 414 186 398 189 335 180 199 184 183 186 89 189 1 189
					yourself:
				)
		)
	)
)

(instance exit_0 of Feature
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 1 334 1 336 181 196 183
					yourself:
				)
		)
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
					init: 0 0 590 2 591 180 539 180 540 187 476 189 322 184 301 185 230 182 172 182 171 186 115 193 -1 193
					yourself:
				)
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
					init: 1 1 590 2 591 183 -1 181
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
					init: 243 142 256 144 257 180 243 180
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
					init: 0 0 591 0 590 187 321 184 268 185 172 190 110 190 -2 195
					yourself:
				)
		)
	)
)

(instance lairDoor_270 of Feature
	(properties
		noun 10
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 172 299 172 301 186 282 187
					yourself:
				)
		)
	)
)

