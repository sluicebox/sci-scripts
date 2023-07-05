;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	sBinoc 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
)

(instance sBinoc of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local4
			(binocL posn: gMouseX (- gMouseY 10))
			(binocR posn: gMouseX (- gMouseY 10))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(if (not register)
					(gMouseDownHandler add: gCurRoom)
					(gKeyDownHandler add: gCurRoom)
					(gDirectionHandler add: gCurRoom)
				)
				(binocL init: ignoreActors: 1 setPri: 30000)
				(binocR init: ignoreActors: 1 setPri: 30000)
				(= local5 (GK keepBar:))
				(GK keepBar: 0)
				(gTheIconBar disable: erase:)
				(= local2 gTheCursor)
				(= local3 (ScriptID 0 1)) ; globeCursor
				(local3 view: 996)
				(= cycles 2)
			)
			(1
				(gGame setCursor: local3 1 160 90)
				(= cycles 1)
			)
			(2
				(SetCursor 107 86 212 106)
				(= cycles 1)
			)
			(3
				(= gMouseX 160)
				(= gMouseY 90)
				(= local4 1)
			)
			(4
				(if (not register)
					(gMouseDownHandler delete: gCurRoom)
					(gKeyDownHandler delete: gCurRoom)
					(gDirectionHandler delete: gCurRoom)
				)
				(gTheIconBar enable:)
				(GK keepBar: local5)
				(gGame setCursor: local2 1)
				(SetCursor 0 0 319 155)
				(gCurRoom newRoom: 400)
				(self dispose:)
			)
		)
	)
)

(instance binocL of View
	(properties
		x 160
		y 90
		priority 2000
		fixPriority 1
		view 4100
	)
)

(instance binocR of View
	(properties
		x 160
		y 90
		priority 2000
		fixPriority 1
		view 4100
		loop 1
	)
)

