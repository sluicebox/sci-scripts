;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64967)
(include sci.sh)
(use DIcon)
(use Motion)

(class DCIcon of DIcon
	(properties
		cycler 0
		cycleSpeed 6
	)

	(method (init)
		(if (not cycler)
			((= cycler (Fwd new:)) init: self)
		)
		(super init: &rest)
	)

	(method (cycle &tmp oldCel)
		(if cycler
			(= oldCel cel)
			(cycler doit:)
			(if (!= cel oldCel)
				(UpdateScreenItem self)
			)
		)
	)

	(method (dispose)
		(if cycler
			(cycler dispose:)
		)
		(super dispose:)
	)
)

