;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8060)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm8v060 0
)

(instance rm8v060 of ShiversRoom
	(properties)

	(method (init)
		(ClearFlag 43)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 34)
			(= picture 8060)
		else
			(= picture 8070)
		)
		(if (IsFlag 40)
			(vStatue init:)
		)
		(super init: &rest)
	)
)

(instance vStatue of View
	(properties
		priority 20
		fixPriority 1
		view 8061
	)

	(method (init)
		(if (IsFlag 34)
			(= view 8061)
		else
			(= view 8071)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8020
	)

	(method (init)
		(self
			createPoly:
				98
				142
				97
				71
				151
				71
				150
				93
				160
				115
				184
				115
				186
				122
				187
				141
		)
		(super init: &rest)
	)
)

