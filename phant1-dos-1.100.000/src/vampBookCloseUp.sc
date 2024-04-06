;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use RotProp)

(public
	vampBookCloseUp 0
)

(instance vampBookCloseUp of RotProp
	(properties
		noun 8
		modNum 1
		view 9710
		baseView 9710
	)

	(method (init param1 param2 param3 param4)
		(self setHotspot: 4 3) ; Do, Move
		(super init: param1 param2 param3 param4)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== view 9850)
				(self view: 9710 baseView: 9710)
			else
				(self view: 9850 baseView: 9850)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

