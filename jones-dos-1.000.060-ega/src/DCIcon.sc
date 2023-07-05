;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 967)
(include sci.sh)
(use Interface)

(public
	DCIcon 0
)

(class DCIcon of DIcon
	(properties
		cycler 0
		cycleSpeed 6
		signal 0
		ticksToDo 0
	)

	(method (cycle &tmp temp0 temp1)
		(if cycler
			(= temp0 cel)
			(= temp1 loop)
			(cycler doit:)
			(if (or (!= cel temp0) (!= loop temp1))
				(self draw:)
			)
		)
	)

	(method (dispose)
		(if cycler
			(cycler dispose:)
			(= cycler 0)
		)
		(super dispose:)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)

	(method (draw)
		(self setPort:)
		(DrawControl self)
		(self resetPort:)
	)

	(method (cue)
		(return self)
	)

	(method (setCycle param1 param2)
		(if cycler
			(cycler dispose:)
		)
		(= cycler 0)
		(if param1
			(= cycler (param1 new:))
			(cycler init: self param2 &rest)
		)
	)

	(method (motionCue)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)
)

