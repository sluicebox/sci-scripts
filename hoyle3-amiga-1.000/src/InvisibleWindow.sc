;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Window)

(class InvisibleWindow of SysWindow
	(properties)

	(method (open)
		(SetPort 0)
		(Graph grUPDATE_BOX (- top 1) (- left 1) bottom right 1)
		(= lsTop top)
		(= lsBottom (+ bottom 1))
		(= lsRight (+ right 1))
		(= lsLeft (- left 1))
		(|= type $0080)
		(super open:)
	)
)

