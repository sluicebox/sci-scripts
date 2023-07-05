;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2007)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Feature)
(use Actor)

(public
	baseCampBasket 0
)

(local
	local0
)

(instance baseCampBasket of CloseupLocation
	(properties)

	(method (init)
		(self heading: 180)
		(super init: 2022)
		(mp_L11y init:)
		(mp_L21z init:)
		(mp_L22x init:)
		(mp_L32z init:)
		(mp_B11x init:)
		(mp_B21z init:)
		(map_Pieces init:)
		(tray init:)
		(lighter init:)
	)
)

(instance mp_L11y of View
	(properties
		x 183
		y 176
		loop 4
		view 2100
	)

	(method (init)
		(if (== (proc70_9 65) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 65)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L21z of View
	(properties
		x 240
		y 199
		loop 5
		view 2100
	)

	(method (init)
		(if (== (proc70_9 69) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 69)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L22x of View
	(properties
		x 297
		y 172
		loop 6
		view 2100
	)

	(method (init)
		(if (== (proc70_9 70) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 70)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L32z of View
	(properties
		x 477
		y 175
		loop 10
		view 2100
	)

	(method (init)
		(if (== (proc70_9 78) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 78)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B11x of View
	(properties
		x 422
		y 204
		loop 8
		view 2100
	)

	(method (init)
		(if (== (proc70_9 49) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 49)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B21z of View
	(properties
		x 383
		y 160
		loop 9
		view 2100
	)

	(method (init)
		(if (== (proc70_9 54) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 54)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance map_Pieces of View
	(properties
		view 2100
	)

	(method (init)
		(= local0 0)
		(if (== (proc70_9 84) 2007)
			(++ local0)
		)
		(if (== (proc70_9 88) 2007)
			(++ local0)
		)
		(if (== (proc70_9 12) 2007)
			(++ local0)
		)
		(switch local0
			(1
				(= loop 1)
				(= x 168)
				(= y 117)
			)
			(2
				(= loop 2)
				(= x 153)
				(= y 129)
			)
			(3
				(= loop 3)
				(= x 150)
				(= y 139)
			)
		)
		(if local0
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switch local0
					(1
						(self deleteHotspot:)
						(self hide:)
					)
					(2
						(= loop 1)
						(= x 168)
						(= y 117)
						(FrameOut)
					)
					(3
						(= loop 2)
						(= x 153)
						(= y 129)
						(FrameOut)
					)
				)
				(cond
					((== (proc70_9 84) 2007)
						(proc70_1 84)
					)
					((== (proc70_9 88) 2007)
						(proc70_1 88)
					)
					((== (proc70_9 12) 2007)
						(proc70_1 12)
					)
				)
				(-- local0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lighter of View
	(properties
		x 203
		y 160
		loop 11
		view 2100
	)

	(method (init)
		(if (== (proc70_9 9) 2007)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 9)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tray of Feature
	(properties
		nsBottom 206
		nsLeft 205
		nsRight 510
		nsTop 107
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 52)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52
				(proc70_3)
				(proc70_10 9 2007)
				(lighter init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

