;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7509)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	octoCisUniformCU 0
)

(instance octoCisUniformCU of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(if (IsFlag 199)
			(= picture 7520)
			(super init: 7520)
			(OPEN_UNIFORM_135 init:)
			(decryptionCard init: global117)
			(dataCube9 init: global117)
			(dataCube10 init: global117)
			(dataCube11 init: global117)
		else
			(= picture 7519)
			(super init: 7519)
			(pocket init: setHotspot: 2)
		)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance pocket of Feature
	(properties
		noun 40
		nsBottom 220
		nsLeft 360
		nsRight 490
		nsTop 145
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 227 291 147 324 137 354 138 432 107 490 124 476 172 448 242 369 275 272 256
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom picture: 7520 drawPic: 7520)
				(decryptionCard init: global117)
				(dataCube9 init: global117)
				(dataCube10 init: global117)
				(dataCube11 init: global117)
				(SetFlag 199)
				(OPEN_UNIFORM_135 init:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance OPEN_UNIFORM_135 of Feature
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
					init: 122 151 176 79 234 61 248 83 349 100 380 124 494 119 494 150 445 240 405 269 296 240 268 228 214 272 129 216 121 161
					yourself:
				)
		)
	)
)

(instance decryptionCard of View
	(properties
		x 283
		y 177
		cel 2
		view 7520
	)

	(method (init)
		(if (and (== (proc70_9 32) 7509) (== (proc70_9 31) 2005))
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 31)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dataCube9 of View
	(properties
		x 245
		y 189
		view 7520
	)

	(method (init)
		(if (== (proc70_9 23) 7509)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 23)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dataCube10 of View
	(properties
		x 267
		y 191
		cel 1
		view 7520
	)

	(method (init)
		(if (== (proc70_9 24) 7509)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 24)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dataCube11 of View
	(properties
		x 319
		y 178
		cel 3
		view 7520
	)

	(method (init)
		(if (== (proc70_9 25) 7509)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 25)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

