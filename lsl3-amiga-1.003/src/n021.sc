;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)

(public
	ShowState 1
)

(procedure (ShowState whatScript newState where color &tmp [str 33])
	(if (and gDebugging (not (TestFlag 14)))
		(if (< argc 2)
			(= where 1)
		)
		(if (< argc 3)
			(= color 7)
		)
		(Display
			(Format @str 21 0 (whatScript name:) (whatScript state:) newState) ; "%s was state %d; is now state %d."
			dsCOORD
			1
			(- (* 8 where) 7)
			dsFONT
			999
			dsCOLOR
			color
			dsBACKGROUND
			0
		)
	)
)

