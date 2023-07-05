;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5015)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian15 0
)

(instance NYAvian15 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceSE faceNW faceSE)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5053
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(mazeCard init:)
		(mazePiston init:)
		(mazeLights init:)
		(mazeController init:)
		(super init: &rest)
		(mazeController_135 init:)
		(mazeMap_135 init:)
		(cardSlot_135 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5055
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc10Exit init:)
		(super init: &rest)
	)
)

(instance loc10Exit of ExitFeature
	(properties
		nextRoom 5010
	)
)

(instance mazeController of Feature
	(properties
		nsLeft 160
		nsTop 132
		nsRight 424
		nsBottom 279
	)

	(method (init)
		(super init:)
		(self setHotspot: 2 46)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5016) ; NYAvian16
			)
			(46
				(gCurRoom newRoom: 5016) ; NYAvian16
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mazeCard of View
	(properties
		x 283
		y 243
		view 5002
		loop 15
		cel 5
	)

	(method (init)
		(if (not (== (proc70_9 47) 5016))
			(return)
		)
		(super init: global117 &rest)
	)
)

(instance mazePiston of View
	(properties
		x 253
		y 218
		view 5002
		loop 14
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		y 200
		view 5002
		loop 15
	)

	(method (init)
		(if (not (== (proc70_9 47) 5016))
			(return)
		)
		(switch (= cel global256)
			(0
				(self x: 238)
			)
			(1
				(self x: 259)
			)
			(2
				(self x: 281)
			)
			(3
				(self x: 302)
			)
			(4
				(self x: 323)
			)
		)
		(super init: global117 &rest)
	)
)

(instance mazeController_135 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 194 199 188 224 137 289 115 348 125 394 187 426 191 436 257 440 288 152 278 154 246 153 203 188 184
					yourself:
				)
		)
	)
)

(instance mazeMap_135 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 164 48 184 20 214 22 243 2 344 5 366 28 401 30 410 57 388 74 344 96 246 98 198 78 158 52
					yourself:
				)
		)
	)
)

(instance cardSlot_135 of Feature
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
					init: 283 230 301 230 306 245 276 244
					yourself:
				)
		)
	)
)

