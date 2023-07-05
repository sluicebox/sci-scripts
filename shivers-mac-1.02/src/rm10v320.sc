;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10320)
(include sci.sh)
(use Main)

(public
	rm10v320 0
)

(instance rm10v320 of ShiversRoom
	(properties
		picture 10320
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10330
	)

	(method (init)
		(self
			createPoly:
				80
				134
				102
				105
				90
				90
				83
				67
				88
				53
				104
				40
				117
				32
				150
				32
				169
				44
				180
				62
				181
				83
				174
				97
				164
				105
				183
				132
		)
		(super init: &rest)
	)
)

