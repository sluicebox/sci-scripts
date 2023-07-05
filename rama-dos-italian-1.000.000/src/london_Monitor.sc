;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3070)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Actor)
(use System)

(public
	london_Monitor 0
)

(instance london_Monitor of CloseupLocation
	(properties
		noun 30
		heading 180
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(super init: 3324)
		(= plane global116)
		(monitor init:)
	)
)

(instance monitor of View
	(properties
		x 151
		y 274
		view 3324
	)

	(method (init)
		(if global297
			(super init: global117)
			(monitorPic init:)
			(buttonA init:)
			(buttonB init:)
			(mazeController init:)
			(ladder init:)
			(self setPri: 0)
		)
	)
)

(instance monitorPic of View
	(properties
		x 284
		y 224
		loop 1
		view 3324
	)

	(method (init)
		(switch global201
			(1
				(= cel 3)
			)
			(3
				(= cel 4)
			)
			(else
				(return)
			)
		)
		(super init: global117)
		(mazeController init:)
		(ladder init:)
		(self setPri: 1)
	)
)

(instance buttonA of View
	(properties
		x 279
		y 259
		loop 1
		cel 1
		view 3324
	)

	(method (init)
		(if (== global201 1)
			(super init: global117)
			(self setPri: 2)
		)
	)
)

(instance buttonB of View
	(properties
		x 300
		y 264
		loop 1
		cel 2
		view 3324
	)

	(method (init)
		(if (OneOf global201 3 2)
			(super init: global117)
			(self setPri: 2)
		)
	)
)

(instance mazeController of View
	(properties
		x 341
		y 71
		loop 1
		view 3324
	)

	(method (init)
		(if (== (proc70_9 47) 2039)
			(super init: global117)
			(self setPri: 2)
		)
	)
)

(instance ladder of View
	(properties
		x 195
		y 380
		cel 3
		view 3324
	)

	(method (init)
		(if (== (proc70_9 46) 2027)
			(super init: global117)
			(self setPri: 2)
		)
	)
)

