;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5022)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use newYorkRegion)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian22 0
)

(instance NYAvian22 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(proc201_1 38)
		(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 5074
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(perches_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 5073
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 5075
		edgeS 0
		edgeN 0
	)

	(method (init)
		(switch ((ScriptID 201 0) curAPRampPosition:) ; newYorkRegion
			(1
				(= picture 5123)
			)
			(2
				(= picture 5124)
			)
			(3
				(= picture 5160)
			)
			(4
				(= picture 5150)
			)
			(5
				(= picture 5150)
			)
		)
		(super init: &rest)
		(perchStool init:)
		(window_225 init:)
		(perches_225 init:)
		(pillar_225 init:)
		(ramp_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 5090
		edgeS 0
		edgeN 0
	)

	(method (init)
		(loc17Exit init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(jack init:)
		(pillar_315 init:)
		(perches_315 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance loc17Exit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 5 137 338 190 345 235 8 226
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5017) ; NYAvian17
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance perchStool of View
	(properties
		noun 28
		x 157
		y 223
		loop 7
		view 5002
	)

	(method (init)
		(if (== (proc70_9 111) 5022)
			(super init: global117 &rest)
			(self setHotspot: 2 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 111)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jack of View
	(properties
		x 339
		y 223
		loop 11
		view 5002
	)

	(method (init)
		(if (== (proc70_9 38) 5018)
			(super init: global117 &rest)
			(self setHotspot: 2)
		)
	)
)

(instance window_225 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 66 309 27 344 28 401 66 399 93 365 125 355 129 352 118 297 117 297 128 286 129 251 92
					yourself:
				)
		)
	)
)

(instance perches_225 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 384 234 412 209 448 236 460 266 450 287 389 290
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 329 152 338 143 349 150 355 164 346 164 336 161
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 331 174 347 195 336 196 328 179
					yourself:
				)
		)
	)
)

(instance pillar_225 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 93 435 156 509 193 586 228 588 288 490 291 446 273 450 249 405 210 378 242 360 244 226 95
					yourself:
				)
		)
	)
)

(instance ramp_225 of Feature
	(properties
		noun 23
		x 529
		y 174
		nsBottom 222
		nsLeft 468
		nsRight 591
		nsTop 126
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance perches_315 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 200 46 194 47 222 59 284 46 292 1 288
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 169 198 277 201 271 279 265 291 182 289 176 253 167 200
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 418 199 523 200 524 254 496 290 432 293 410 276 410 217 415 196
					yourself:
				)
		)
	)
)

(instance pillar_315 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 152 341 199 356 223 359 238 345 241 294 233 272 241 276 200 231 199 233 210 256 211 256 218 192 217 189 213 216 209 215 201 172 200 172 210 177 214 182 229 35 241 48 227 46 217 38 216 30 199 -2 197
					yourself:
				)
		)
	)
)

(instance perches_45 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 170 209 175 214 216 166 292 66 284 63 252 177 168
					yourself:
				)
		)
	)
)

