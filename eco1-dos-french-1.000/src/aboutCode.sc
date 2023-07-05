;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 400] [temp401 40] [temp441 40] [temp481 41])
		(proc932_8 99 811 2 @temp1)
		(proc932_8 99 811 3 @temp401)
		(proc932_8 99 811 4 @temp441)
		(proc932_8 99 811 5 @temp481)
		(switch
			(= temp0 (Print @temp1 #button @temp401 1 #button @temp441 0 #button @temp481 2))
			(2
				(if (== (gGame printLang:) 1)
					(gGame printLang: global250)
				else
					(gGame printLang: 1)
				)
				(proc0_8)
			)
			(1
				(proc932_8 99 811 1 @temp1)
				(Printf 810 0 @temp1 gVersion) ; "%s %s"
				(Print (proc932_8 99 810 1 @temp1))
				(Print (proc932_8 99 810 2 @temp1) #icon 105 0 0)
				(Print (proc932_8 99 810 3 @temp1) #icon 105 0 2)
				(Print (proc932_8 99 810 4 @temp1) #icon 105 0 3)
				(Print (proc932_8 99 810 5 @temp1) #icon 105 0 1)
				(Print (proc932_8 99 810 6 @temp1))
				(Print (proc932_8 99 810 7 @temp1))
				(Print (proc932_8 99 810 13 @temp1))
				(Print (proc932_8 99 810 19 @temp1))
				(Print (proc932_8 99 810 28 @temp1))
				(Print (proc932_8 99 810 36 @temp1))
				(Print (proc932_8 99 810 44 @temp1))
				(Print (proc932_8 99 810 49 @temp1))
				(Print (proc932_8 99 810 50 @temp1))
			)
		)
	)
)

