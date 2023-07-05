;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 401])
		(GetMessage 99 811 1 @temp0)
		(Printf 810 0 @temp0 gVersion) ; "%s %s"
		(Print (GetMessage 99 810 1 @temp0))
		(Print (GetMessage 99 810 2 @temp0) #icon 105 0 0)
		(Print (GetMessage 99 810 3 @temp0) #icon 105 0 2)
		(Print (GetMessage 99 810 4 @temp0) #icon 105 0 3)
		(Print (GetMessage 99 810 5 @temp0) #icon 105 0 1)
		(Print (GetMessage 99 810 6 @temp0))
		(Print (GetMessage 99 810 7 @temp0))
		(Print (GetMessage 99 810 13 @temp0))
		(Print (GetMessage 99 810 19 @temp0))
		(Print (GetMessage 99 810 28 @temp0))
		(Print (GetMessage 99 810 36 @temp0))
		(Print (GetMessage 99 810 44 @temp0))
		(Print (GetMessage 99 810 49 @temp0))
		(Print (GetMessage 99 810 50 @temp0))
	)
)

