;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 967)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)

(class DCIcon of DIcon
	(properties
		cycler 0
		cycleSpeed 16
		signal 0
		count -1
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)

	(method (cycle &tmp temp0 temp1)
		(if cycler
			(= temp0 cel)
			(cycler doit:)
			(if (!= cel temp0)
				(if (and (!= count -1) (> temp1 count)) ; UNINIT
					(if global213
						(= cel 0)
					else
						(= cel (- (NumCels self) 1))
					)
				)
				(self draw:)
				(if (and (!= count -1) (== cel (- (NumCels self) 1)))
					(++ temp1) ; UNINIT
					(if
						(and
							global213
							(> (NumLoops self) 1)
							(or loop (< (Random 1 100) 51))
						)
						(^= loop $0001)
					)
				)
			)
		)
	)

	(method (dispose)
		(if cycler
			(cycler dispose:)
		)
		(super dispose:)
	)

	(method (lastCel)
		(return (- (NumCels self) 1))
	)
)

