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
		view 60000
		loop 9
	)
)

(instance oExitCUCursor of Cursor
	(properties
		view 60000
		loop 10
	)
)

(instance oRotLCursor of Cursor
	(properties
		view 60000
		loop 12
	)
)

(instance oRotRCursor of Cursor
	(properties
		view 60000
		loop 11
	)
)

(instance oMapCursor of Cursor
	(properties
		view 60000
		loop 13
	)
)

(instance oEastCursor of Cursor
	(properties
		view 60000
		loop 2
	)
)

(instance oWestCursor of Cursor
	(properties
		view 60000
		loop 4
	)
)

(instance oNorthCursor of Cursor
	(properties
		view 60000
		loop 1
	)
)

(instance oSouthCursor of Cursor
	(properties
		view 60000
		loop 3
	)
)

(instance oNorthEastCursor of Cursor
	(properties
		view 60000
		loop 6
	)
)

(instance oNorthWestCursor of Cursor
	(properties
		view 60000
		loop 5
	)
)

(instance oSouthEastCursor of Cursor
	(properties
		view 60000
		loop 7
	)
)

(instance oSouthWestCursor of Cursor
	(properties
		view 60000
		loop 8
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

