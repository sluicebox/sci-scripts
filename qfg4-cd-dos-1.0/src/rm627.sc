;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 627)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)

(public
	rm627 0
)

(local
	local0
)

(instance rm627 of GloryRm
	(properties
		modNum 620
		picture 620
		north 630
	)

	(method (init &tmp temp0)
		(= local0 (IsFlag 112))
		(switch gPrevRoomNum
			(630
				(gEgo posn: 88 32)
			)
			(662
				(gEgo posn: 276 152)
			)
			(else
				(gEgo posn: 237 152)
			)
		)
		(gEgo init: setScaler: Scaler 105 32 180 31 normalize:)
		((ScriptID 633 0) init:) ; rm620Code
		(super init: &rest)
		(if (and gNight (not (IsFlag 112)))
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 0 1 0 0 0 627) ; "You are on a long, winding stairway. Torches line the walls. The door at the top leads to the castle's Great Hall."
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(if script
			(script dispose:)
		)
		(DisposeScript 633)
		(if local0
			(SetFlag 112)
		else
			(ClearFlag 112)
		)
		(super dispose:)
	)
)

