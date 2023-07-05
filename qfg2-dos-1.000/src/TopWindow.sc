;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Save)

(class TopWindow of SysWindow
	(properties)

	(method (open &tmp vdiff)
		(= vdiff (- top 2))
		(-= top vdiff)
		(-= bottom vdiff)
		(super open:)
	)
)

(class BotWindow of SysWindow
	(properties)

	(method (open &tmp vdiff)
		(= vdiff (- 188 bottom))
		(+= top vdiff)
		(+= bottom vdiff)
		(super open:)
	)
)

(class MidWindow of SysWindow
	(properties)

	(method (open &tmp vdiff)
		(super open:)
		(= vdiff (/ (- 188 bottom) 2))
		(+= top vdiff)
		(+= bottom vdiff)
	)
)

