;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use System)

(class ExitArrow of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		exitDir 0
		turnedOn 0
		exitCur 0
	)

	(method (onMe param1 param2)
		(return (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom)))
	)

	(method (init)
		(if (not exitCur)
			(= exitCur
				(switch exitDir
					(1 985)
					(3 986)
					(2 987)
					(4 988)
				)
			)
		)
		(gTheDoits add: self)
	)

	(method (doit &tmp temp0)
		(cond
			((self onMe: gMouseX gMouseY)
				(cond
					((== (gTheCursor view:) 991)
						(gTheCursor view: exitCur)
						(gGame setCursor: gTheCursor 1)
						(= turnedOn 1)
					)
					((== (gTheCursor view:) exitCur) 0)
					(else
						(if (!= ((= temp0 (ScriptID 25 1)) view:) 991) ; walkCursor
							(temp0 view: 991)
						)
						(= turnedOn 0)
					)
				)
			)
			(turnedOn
				(if (== (gTheCursor view:) exitCur)
					(gTheCursor view: 991)
					(gGame setCursor: gTheCursor 1)
				)
				(= turnedOn 0)
			)
		)
	)

	(method (dispose)
		(if turnedOn
			(gTheCursor view: 991)
		)
		(super dispose:)
	)
)

