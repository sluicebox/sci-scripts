;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use Teller)
(use System)

(public
	innKeepTeller 0
)

(instance innKeepTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(= talker (ScriptID 98 0)) ; innkeeperTalker
		(super
			init:
				param2
				param3
				11
				146
				(switch param1
					(1 3)
					(2 4)
					(4 2)
					(5 1)
					(6 7)
					(7 8)
					(8 10)
					(9 5)
					(10 6)
					(11 10)
					(12 9)
				)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 162)
			(if
				(and
					(IsFlag 127)
					(>= gDay 3)
					(OneOf gTime 4 5)
					(not (IsFlag 129))
					(not (IsFlag 130))
				)
				(gMessager say: 12 6 14 0 0 321) ; "Hey, what are you trying to do -- ruin my act? Give me a chance at it first. So sit down so I can get started."
				(return 1)
			else
				(gMessager say: 12 6 15 0 0 321) ; "Hey, I've been looking high and low for you, and I obviously wasn't looking low enough. You trying to upstage me or something?"
				(return 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

