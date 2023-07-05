;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Cursor)

(class AnimatingCursor of Cursor
	(properties
		cycleSpeed 5
		cycler 0
	)

	(method (doit &tmp temp0)
		(if cycler
			(= temp0 cel)
			(cycler doit:)
			(if (!= temp0 cel)
				(SetCursor view loop cel)
			)
		)
	)

	(method (setCycle param1)
		(if cycler
			(cycler dispose:)
			(= cycler 0)
		)
		(if (and argc param1)
			(= cycler
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(cycler init: self &rest)
		)
	)
)

