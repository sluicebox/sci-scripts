;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 624)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)

(public
	rm624 0
)

(instance rm624 of GloryRm
	(properties
		picture 620
		style 1024
		north 642
	)

	(method (init)
		(switch gPrevRoomNum
			(642
				(gEgo posn: 228 31)
			)
			(643
				(gEgo posn: 54 157)
			)
			(else
				(gEgo posn: 228 31)
			)
		)
		(gEgo
			init:
			setScaler: Scaler 105 32 180 31
			normalize: (if (== gPrevRoomNum 643) 2 else 3)
		)
		((ScriptID 633 0) init:) ; rm620Code
		(super init: &rest)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(DisposeScript 633)
		(super dispose:)
	)
)

