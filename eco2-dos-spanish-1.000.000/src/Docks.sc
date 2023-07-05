;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 199)
(include sci.sh)
(use Main)
(use Flags)
(use Game)
(use System)

(public
	Docks 0
	dockFlags 1
)

(local
	local0
)

(class Docks of Rgn
	(properties
		keep 1
		docksTimer 0
	)

	(method (init)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		(gEgo get: 0 get: 1) ; buckazoid, passport
		(super init:)
		(= gCurrentRegionFlags dockFlags)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 160 100))
			(gGameSound1 fade:)
			(gGameSound2 fade:)
			(self keep: 0)
			(dockFlags dispose:)
		)
	)

	(method (doit)
		(if (!= local0 (GetTime 1)) ; SysTime12
			(= local0 (GetTime 1)) ; SysTime12
			(if (== (-- docksTimer) 1)
				(gCurRoom notify:)
			)
		)
		(super doit:)
	)
)

(instance dockFlags of Flags
	(properties
		size 36
	)
)

