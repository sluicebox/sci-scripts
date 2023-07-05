;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Cursor)
(use Motion)

(public
	AniCursor 0
)

(class AniCursor of Cursor
	(properties
		cycleSpeed 11
		cycler 0
	)

	(method (setCycle param1)
		(if cycler
			(cycler dispose:)
		)
		(if param1
			(if (== param1 Fwd)
				(= param1 wandForward)
			)
			(= cycler
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(cycler init: self &rest)
			(gTheDoits addToFront: self)
		else
			(= cycler 0)
			(gTheDoits delete: self)
		)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
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

	(method (cue))

	(method (dispose)
		(gTheDoits delete: self)
		(self setCycle: 0)
		(super dispose:)
	)
)

(instance wandForward of Fwd
	(properties)

	(method (cycleDone)
		(client cel: 1)
	)
)

