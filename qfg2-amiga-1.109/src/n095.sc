;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use n001)
(use DCIcon)

(public
	djinniPrint 0
)

(procedure (djinniPrint)
	(HighPrint &rest 80 {Djinni:} 82 djinniIcon 70 200)
)

(instance djinniIcon of DCIcon
	(properties
		view 617
		cycleSpeed 10
	)
)

