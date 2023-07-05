;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2110)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm2110 0
)

(instance rm2110 of KQRoom
	(properties
		picture 2110
	)

	(method (init)
		(super init:)
		(proc11_6 2100)
		(if (IsFlag 55)
			((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
			(steam init: setCycle: Fwd)
		)
		(self setScript: musicScript)
	)

	(method (dispose)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(super dispose: &rest)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= cycles 2)
			)
			(1
				(= ticks 90)
			)
			(2
				(gKqSound1 number: 2101 setLoop: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance steam of Prop
	(properties
		x 158
		y 73
		view 2111
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10) ; Exit, Exit
	)

	(method (doVerb)
		(gMessager say: 0 0 0 1) ; "Oh, that's odd. Where's that smoke coming from?"
		(self setHotspot: 0)
	)
)

