;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 967)
(include sci.sh)
(use Interface)
(use Motion)

(class DCIcon of DIcon
	(properties
		cycler 0
		cycleSpeed 16
		signal 0
		count -1
		talker 0
		loops 0
	)

	(method (init)
		(cond
			((== cycler -1)
				(= cycler 0)
			)
			(cycler
				((= cycler (cycler new:)) init: self)
			)
			(else
				((= cycler (Fwd new:)) init: self)
			)
		)
		(= loops 0)
	)

	(method (cycle &tmp oldCel)
		(if cycler
			(= oldCel cel)
			(cycler doit:)
			(if (!= cel oldCel)
				(if (and (!= count -1) (> loops count))
					(if talker
						(= loop (= cel 0))
					else
						(= cel (self lastCel:))
					)
				)
				(self draw:)
				(if
					(and
						(!= count -1)
						(== cel (self lastCel:))
						(<= loops count)
					)
					(++ loops)
					(if
						(and
							talker
							(> (NumLoops self) 1)
							(or loop (< (Random 1 100) 51))
						)
						(^= loop $0001)
					)
				)
			)
		)
	)

	(method (setCel))

	(method (startUpd))

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

