;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12300)
(include sci.sh)
(use Main)

(public
	rm12v30 0
)

(instance rm12v30 of ShiversRoom
	(properties
		picture 12300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efOrgan init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12290
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 0 22 0 22 143 0 143 0 0)
		(if (== gPrevRoomNum 12290) ; rm12v29
			(= nextRoom 12290)
		)
		(if (== gPrevRoomNum 12330) ; rm12v33
			(= nextRoom 12330)
		)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12310
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12390
	)

	(method (init)
		(self
			createPoly: 226 143 201 122 205 88 193 55 126 55 131 99 111 110 75 122 49 144
		)
		(super init: &rest)
	)
)

(instance efOrgan of ExitFeature
	(properties
		nextRoom 12370
	)

	(method (init)
		(self createPoly: 229 144 202 123 206 87 236 87 234 69 243 47 243 144)
		(super init: &rest)
	)
)

