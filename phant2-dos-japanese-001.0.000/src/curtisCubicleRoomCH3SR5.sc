;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4053)
(include sci.sh)
(use Main)
(use n63002)
(use WynIniFile)
(use PolyEdit)

(public
	curtisCubicleRoomCH3SR5 0
)

(local
	local0
	local1
	local2
	local3
)

(instance telview of View
	(properties
		x 130
		y 298
		view 44002
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance curtisCubicleRoomCH3SR5 of WynDocuStore
	(properties
		exitRoom 4023
		postalWareRm 4063
	)

	(method (init)
		(= local0 (gWynNet findItem: 6301 3 0 34 2))
		(= local1 (gWynNet findItem: 6301 22 0 106 1))
		(= local2 (gWynNet findItem: 6301 22 0 105 1))
		(= local3 (gWynNet findItem: 6301 22 0 70 1))
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (handleEvent event param2 &tmp temp0)
		(if (and (== event curDoco) (== curDoco local0))
			(telview init:)
			(proc63002_11 4000 0 0 58 1)
			(telview dispose:)
		else
			(super handleEvent: event param2 &rest)
			(cond
				((== curDoco local1)
					(SetFlag 409)
				)
				((== curDoco local2)
					(SetFlag 408)
				)
				((== curDoco local3)
					(SetFlag 410)
				)
			)
		)
	)

	(method (refresh)
		(super refresh:)
		(if (and (== curDoco local0) docoTextPlane)
			(docoTextPlane scratch: 1)
		)
	)
)

