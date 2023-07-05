;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Teller)

(public
	bellaTeller 0
	childTeller 1
)

(instance bellaTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(= talker (ScriptID 93 0)) ; bellaTalker
		(super
			init:
				param2
				param3
				7
				150
				(switch param1
					(7 4)
					(8 1)
					(9 3)
					(11 6)
					(12 5)
				)
		)
	)
)

(instance childTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(= talker (ScriptID 71 0)) ; tanyaTalker
		(super
			init:
				param2
				param3
				7
				151
				(switch param1
					(9 3)
				)
		)
	)
)

