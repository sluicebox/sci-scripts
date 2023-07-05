;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64006)
(include sci.sh)
(use Main)
(use Cursor)
(use Actor)
(use System)

(public
	oSysCursor 0
	oNorthCursor 1
	oSouthCursor 2
	oEastCursor 3
	oWestCursor 4
	oNorthEastCursor 5
	oNorthWestCursor 6
	oSouthEastCursor 7
	oSouthWestCursor 8
	oArrowView 9
	oExitCUCursor 10
	oRotLCursor 11
	oRotRCursor 12
	oMapCursor 13
)

(instance oSysCursor of Cursor
	(properties
		loop 9
		view 60000
	)
)

(instance oExitCUCursor of Cursor
	(properties
		loop 10
		view 60000
	)
)

(instance oRotLCursor of Cursor
	(properties
		loop 12
		view 60000
	)
)

(instance oRotRCursor of Cursor
	(properties
		loop 11
		view 60000
	)
)

(instance oMapCursor of Cursor
	(properties
		loop 13
		view 60000
	)
)

(instance oEastCursor of Cursor
	(properties
		loop 2
		view 60000
	)
)

(instance oWestCursor of Cursor
	(properties
		loop 4
		view 60000
	)
)

(instance oNorthCursor of Cursor
	(properties
		loop 1
		view 60000
	)
)

(instance oSouthCursor of Cursor
	(properties
		loop 3
		view 60000
	)
)

(instance oNorthEastCursor of Cursor
	(properties
		loop 6
		view 60000
	)
)

(instance oNorthWestCursor of Cursor
	(properties
		loop 5
		view 60000
	)
)

(instance oSouthEastCursor of Cursor
	(properties
		loop 7
		view 60000
	)
)

(instance oSouthWestCursor of Cursor
	(properties
		loop 8
		view 60000
	)
)

(instance oArrowView of View
	(properties
		view 60001
	)

	(method (init)
		(super init: &rest)
		(self setPri: 30000)
		(gCurRoom setScript: oArrowViewDisposer)
	)

	(method (dispose)
		(oArrowViewDisposer dispose:)
		(super dispose: &rest)
	)
)

(instance oArrowViewDisposer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(oArrowView dispose:)
			)
		)
	)
)

