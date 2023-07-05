;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use Main)
(use Teller)
(use Feature)
(use System)

(public
	gnomeTeller 0
	peasantTeller 1
)

(instance gnomeTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(= talker (ScriptID 67 0)) ; gnomeTalker
		(super
			init:
				param2
				param3
				10
				149
				(switch param1
					(4 2)
					(5 1)
				)
		)
	)
)

(instance peasantTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(= talker (ScriptID 77 0)) ; franzTalker
		(super
			init:
				param2
				param3
				10
				147
				(switch param1
					(1 3)
					(2 4)
					(4 2)
					(5 1)
					(6 6)
					(7 7)
					(10 5)
					(11 9)
					(12 8)
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 162)
					(if
						(and
							(IsFlag 127)
							(>= gDay 3)
							(OneOf gTime 4 5)
							(not (IsFlag 129))
							(not (IsFlag 130))
						)
						(gMessager say: 11 6 15 0 0 322) ; "Hey, what are you trying to do -- ruin my act? Give me a chance at it first. Go sit down so I can get started."
						(return 1)
					else
						(gMessager say: 11 6 16 0 0 322) ; "Hey, I've been looking high and low for you, and I obviously wasn't looking low enough. You trying to upstage me or something?"
						(return 1)
					)
				else
					(switch ((CueObj client:) loop:)
						(0
							(= talker (ScriptID 77 0)) ; franzTalker
						)
						(6
							(= talker (ScriptID 76 0)) ; hansTalker
						)
						(else
							(= talker (ScriptID 78 0)) ; ivanTalker
						)
					)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

