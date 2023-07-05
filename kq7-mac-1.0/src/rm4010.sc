;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4010)
(include sci.sh)
(use Main)
(use skipCartoon)
(use eastFeat)

(public
	rm4010 0
)

(instance rm4010 of KQRoom
	(properties
		picture 4010
	)

	(method (init)
		(super init:)
		(myNorthExit init:)
		(mySouthExit init:)
		(myEastExit init:)
		(myWestExit init:)
	)
)

(instance myNorthExit of ExitFeature
	(properties
		nsRight 319
		nsBottom 10
		exitDir 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 4102)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsTop 133
		nsRight 319
		nsBottom 139
		exitDir 3
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 4102)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 309
		nsRight 319
		nsBottom 139
		exitDir 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 4102)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance myWestExit of ExitFeature
	(properties
		nsRight 319
		nsBottom 139
		exitDir 4
	)

	(method (init)
		(super init:)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((and (& (event type:) evMOVE) (self onMe: event))
				(gCurRoom newRoom: 4102)
				(event claimed: 1)
				(return)
			)
			((and scratch (not (event type:)) (self onMe: event))
				(= global311 self)
				((self scratch:) doit:)
				(event claimed: 1)
				(return)
			)
		)
	)
)

