;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63009)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Room)
(use TextField)

(public
	whereTo 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 (Str newWith: 10 {}))
	(gGame setCursor: gNormalCursor 1)
	(Text 0 (local0 data:) {A} gUserFont 320) ; TextSize
	(= local1 0)
	(= local1 (QuickPrint new: {Whereto?}))
	(if (temp0 size:)
		(= local1 (temp0 asInteger:))
	else
		(switch local1
			(-1
				(= local1 111)
			)
			(64538
				(= gQuit 1)
			)
			(-999
				(gGame restore:)
				(temp0 dispose:)
				(return)
			)
			(else
				(= local1 111)
			)
		)
	)
	(if temp0
		(temp0 dispose:)
	)
	(gCurRoom newRoom: local1)
)

(instance whereTo of Room
	(properties)

	(method (init)
		(= local0 (IntArray with: 0 0 0 0))
		(super init:)
		(localproc_0)
		(local0 dispose:)
	)
)

