;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5401)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Subway_1 0
)

(instance NY_Subway_1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5211 ; NY_Human_Plaza_11
				(self
					addPicObj:
						faceSubway
						faceWall
						faceRoom
						facePuzzle
						faceSubway
				)
			)
			(5402 ; NY_Subway_2
				(self
					addPicObj: faceRoom facePuzzle faceSubway faceWall faceRoom
				)
			)
			(else
				(self
					addPicObj:
						faceSubway
						faceWall
						faceRoom
						facePuzzle
						faceSubway
				)
			)
		)
	)
)

(instance facePuzzle of CameraAngle
	(properties
		picture 5404
		edgeS 0
		edgeN 0
	)
)

(instance faceSubway of CameraAngle
	(properties
		heading 90
		picture 5402
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom5 init:)
		(map_90 init:)
		(machinery_90 init:)
		(chair_90 init:)
		(super init: &rest)
		(if (not (IsFlag 256))
			(SetFlag 256)
			(proc1111_31 37 9)
		)
	)
)

(instance faceWall of CameraAngle
	(properties
		heading 180
		picture 5407
		edgeS 0
		edgeN 0
	)
)

(instance faceRoom of CameraAngle
	(properties
		heading 270
		picture 5405
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPlaza init:)
		(pent_270 init:)
		(fork_270 init:)
		(doorMechanism_270 init:)
		(super init: &rest)
	)
)

(instance exitToPlaza of ExitFeature
	(properties
		nextRoom 5211
		exitStyle 256
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 33 186 178 199 190 199 225 187 236 186 258 405 258 405 237 394 225 393 190 406 179 405 41 370 34 342 66 249 66 220 32
					yourself:
				)
		)
	)
)

(instance exitToRoom5 of ExitFeature
	(properties
		nsBottom 260
		nsLeft 244
		nsRight 336
		nsTop 100
		nextRoom 5402
	)
)

(instance map_90 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 111 175 133 173 162 166 163 126 163 122 159 120 132
					yourself:
				)
		)
	)
)

(instance machinery_90 of Feature
	(properties
		noun 19
		case 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 175 204 173 234 179 236 187 237 254 220 292 -3 292 -1 250 62 179
					yourself:
				)
		)
	)
)

(instance chair_90 of Feature
	(properties
		noun 18
		case 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 124 307 122 304 153 312 156 312 165 305 167 315 194 306 197 305 219 277 219 278 201 267 196 267 192 269 176 275 176 280 166 271 166 272 157 280 155
					yourself:
				)
		)
	)
)

(instance doorMechanism_270 of Feature
	(properties
		noun 19
		case 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 431 97 507 98 508 154 502 165 435 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 438 178 460 173 493 180 559 269 563 291 483 291 434 263
					yourself:
				)
		)
	)
)

(instance pent_270 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 160 264 205 197 210 197 192 183 180
					yourself:
				)
		)
	)
)

(instance fork_270 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 105 295 105 297 130 297 141 296 156 293 155 292 176 296 178 299 182 302 188 290 190 275 189 275 186 279 180 286 177 287 155 283 155 284 144 282 129 283 127
					yourself:
				)
		)
	)
)

