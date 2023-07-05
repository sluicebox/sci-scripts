;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12340)
(include sci.sh)
(use Main)

(public
	rm12v34 0
)

(instance rm12v34 of ShiversRoom
	(properties
		picture 12340
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12060
	)

	(method (init)
		(self
			createPoly:
				40
				144
				38
				43
				49
				30
				145
				33
				147
				1
				173
				3
				186
				13
				198
				28
				203
				142
		)
		(super init: &rest)
	)
)

