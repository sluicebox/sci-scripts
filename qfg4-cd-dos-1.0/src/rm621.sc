;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 621)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)

(public
	rm621 0
)

(instance rm621 of GloryRm
	(properties
		modNum 620
		picture 620
		north 640
	)

	(method (init)
		(switch gPrevRoomNum
			(640
				(gEgo posn: 88 32)
			)
			(660
				(gEgo posn: 263 152)
			)
			(else
				(gEgo posn: 237 152)
			)
		)
		(gEgo init: setScaler: Scaler 105 32 180 31 normalize:)
		((ScriptID 633 0) init:) ; rm620Code
		(super init: &rest)
		(gGlory handsOn:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 621) ; "You are on a winding stairway near the northeast corner of the castle. Torches line the walls. There are two exits -- doors at the top and bottom of the stairs."
		else
			(super doVerb: theVerb)
		)
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

