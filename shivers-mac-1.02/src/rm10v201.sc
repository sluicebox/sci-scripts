;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10201)
(include sci.sh)
(use Main)

(public
	rm10v201 0
)

(instance rm10v201 of ShiversRoom
	(properties
		picture 10201
	)

	(method (init)
		(super init: &rest)
		(efPurse init: 0)
		(efUp init: 4)
	)
)

(instance efPurse of ExitFeature
	(properties
		nextRoom 10202
	)

	(method (init)
		(self createPoly: 171 67 125 49 144 20 152 20 187 31 189 38)
		(super init: &rest)
	)
)

(instance efUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 20
		nextRoom 10200
	)

	(method (init)
		(if (== gPrevRoomNum 10190) ; rm10v190
			(= nextRoom 10190)
		)
		(if (== gPrevRoomNum 10200) ; rm10v200
			(= nextRoom 10200)
		)
		(super init: &rest)
	)
)

