;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7615)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)
(use Actor)

(public
	octoCircle4CU 0
)

(instance octoCircle4CU of CloseupLocation
	(properties
		picture 7625
		heading 180
	)

	(method (init)
		(super init: 7625)
		(digit1 init: global117)
		(digit2 init: global117)
		(digit3 init: global117)
		(digit4 init: global117)
		(self edgeW: 0 edgeE: 0)
		(QBOMB_180 init:)
		(if (proc1111_24 214)
			(proc1111_31 33)
			(SetFlag 214)
		)
	)
)

(instance QBOMB_180 of Feature
	(properties
		noun 46
		nsLeft 32
		nsTop 36
		nsRight 578
		nsBottom 274
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 155)
			(= case 16)
		else
			(= case 15)
		)
		(self setHotspot: 144)
	)
)

(instance digit1 of View
	(properties
		x 460
		y 110
		view 7604
	)

	(method (init)
		(= cel (mod (/ global184 10) 10))
		(super init: &rest)
	)
)

(instance digit2 of View
	(properties
		x 479
		y 110
		view 7604
	)

	(method (init)
		(= cel (mod global184 10))
		(super init: &rest)
	)
)

(instance digit3 of View
	(properties
		x 499
		y 110
		view 7604
	)

	(method (init)
		(= cel (mod (/ global185 1000) 10))
		(super init: &rest)
	)
)

(instance digit4 of View
	(properties
		x 518
		y 110
		view 7604
	)

	(method (init)
		(= cel (mod (/ global185 100) 10))
		(super init: &rest)
	)
)

