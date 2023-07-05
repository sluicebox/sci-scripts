;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 974)
(include sci.sh)
(use System)

(public
	NameFind 0
)

(procedure (NameFind theNearName theList) ; UNUSED
	(theList firstTrue: #perform NC theNearName)
)

(instance NC of Code
	(properties)

	(method (doit theObj theName)
		(return (== 0 (StrCmp (theObj name:) theName)))
	)
)

