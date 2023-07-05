;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5205)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	humanPlazaRm5 0
)

(instance humanPlazaRm5 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5203 ; humanPlazaRm3
				(self
					addPicObj: facePent faceFork faceCenter faceMantis facePent
				)
			)
			(5210 ; NY_Human_Plaza_10
				(self
					addPicObj:
						faceMantis
						facePent
						faceFork
						faceCenter
						faceMantis
				)
			)
			(5211 ; NY_Human_Plaza_11
				(self
					addPicObj: faceFork faceCenter faceMantis facePent faceFork
				)
			)
			(else
				(self
					addPicObj:
						faceMantis
						facePent
						faceFork
						faceCenter
						faceMantis
				)
			)
		)
	)
)

(instance faceFork of CameraAngle
	(properties
		heading 225
		picture 5219
		edgeS 0
		edgeN 0
	)

	(method (init)
		(gCurRoom exitN: exitToFork)
		(exitToFork init:)
		(walls_225 init:)
		(fork_225 init:)
		(super init: &rest)
	)
)

(instance faceCenter of CameraAngle
	(properties
		heading 315
		picture 5222
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToCenter init:)
		(gCurRoom exitN: exitToCenter)
		(walls_315 init:)
		(super init: &rest)
	)
)

(instance faceMantis of CameraAngle
	(properties
		heading 45
		picture 5221
		edgeS 0
		edgeN 0
	)

	(method (init)
		(gCurRoom exitN: exitToMantis)
		(exitToMantis init:)
		(walls_45 init:)
		(door_45 init:)
		(sensor_45 init:)
		(super init: &rest)
	)
)

(instance facePent of CameraAngle
	(properties
		heading 135
		picture 5220
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_135 init:)
		(pentahedron_135 init:)
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

(instance exitToFork of Feature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 124)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5210) ; NY_Human_Plaza_10
			)
			(124
				(gCurRoom newRoom: 5210) ; NY_Human_Plaza_10
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exitToMantis of Feature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 139)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5211) ; NY_Human_Plaza_11
			)
			(139
				(gCurRoom newRoom: 5211) ; NY_Human_Plaza_11
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls_45 of Feature
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
					init: 0 0 591 1 590 185 539 184 483 183 483 190 461 190 461 203 152 202 152 186 144 186 143 181 0 181
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
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
					init: 291 111 309 112 315 147 309 158 314 158 316 153 321 148 324 159 325 204 273 204 275 149 287 157 291 158 287 147
					yourself:
				)
		)
	)
)

(instance sensor_45 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 330 177 344 177 344 204 330 203
					yourself:
				)
		)
	)
)

(instance pentahedron_135 of Feature
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
					init: 179 -1 404 -3 559 156 441 167 444 208 397 213 398 222 438 223 440 291 151 291 153 224 191 223 192 218 150 206 154 167 23 157
					yourself:
				)
		)
	)
)

(instance walls_135 of Feature
	(properties
		noun 32
		x 297
		y 92
		nsBottom 186
		nsLeft 1
		nsRight 593
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_225 of Feature
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
					init: 0 1 591 1 591 182 441 183 440 202 322 203 155 199 154 192 122 188 122 184 -1 186
					yourself:
				)
		)
	)
)

(instance fork_225 of Feature
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
					init: 288 46 308 45 308 87 313 92 312 96 308 102 308 104 313 108 313 115 309 133 304 144 303 179 309 182 319 191 322 205 272 205 272 197 283 182 295 180 292 171 293 135 286 134 287 120 283 114 284 109 287 106 288 102 282 97 283 92 287 89
					yourself:
				)
		)
	)
)

(instance walls_315 of Feature
	(properties
		noun 32
		x 296
		y 90
		nsBottom 181
		nsLeft 2
		nsRight 590
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

