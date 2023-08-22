;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64991)
(include sci.sh)
(use PolyEdit)

(class Prop of View
	(properties
		cycler 0
		cycleSpeed 6
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose: &rest)
	)

	(method (doit)
		(if (and cycler (& signal $0001))
			(cycler doit:)
		)
		(super doit: &rest)
	)

	(method (setCycle param1)
		(if (not argc)
			(PrintDebug {SetCycle for %s(%d) needs parameter(s)\n} name self)
			(SetDebug self)
		)
		(if cycler
			(cycler dispose:)
		)
		(= cycler param1)
		(if cycler
			(if (& (cycler info:) $8000)
				(= cycler (cycler new:))
			)
			(cycler init: self &rest)
		)
	)
)

