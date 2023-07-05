;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64907)
(include sci.sh)
(use Plane)
(use System)

(class ScrollableWindow of Obj
	(properties
		plane 0
		fore 255
		back 0
		font 0
		mode 0
		borderColor 255
		nsLeft 75
		nsTop 50
		nsRight 275
		nsBottom 150
		maxItems 20
		kWindow 0
	)

	(method (init param1)
		(if argc
			(if (== argc 1)
				(= maxItems param1)
			else
				(= nsLeft [param1 0])
				(= nsTop [param1 1])
				(= nsRight [param1 2])
				(= nsBottom [param1 3])
				(if (> argc 4)
					(= maxItems [param1 4])
				)
			)
		)
		(if (not plane)
			(= plane (Plane new:))
		)
		(= kWindow (ScrollWindow 0 self maxItems)) ; ScrollCreate
	)

	(method (show)
		(ScrollWindow 16 kWindow) ; ScrollShow
	)

	(method (hide)
		(ScrollWindow 15 kWindow) ; ScrollHide
	)

	(method (addString param1)
		(ScrollWindow 1 kWindow param1 &rest) ; ScrollAdd
	)

	(method (modifyString param1)
		(ScrollWindow 14 kWindow param1 &rest) ; ScrollModify
	)

	(method (insertString param1)
		(ScrollWindow 12 kWindow param1 &rest) ; ScrollInsert
	)

	(method (erase)
		(ScrollWindow 2 kWindow) ; ScrollClear
	)

	(method (scrollTo param1 param2 param3)
		(switch param1
			(0
				(ScrollWindow 7 kWindow) ; ScrollHome
			)
			(1
				(ScrollWindow 3 kWindow) ; ScrollPageUp
			)
			(2
				(ScrollWindow 5 kWindow) ; ScrollUpArrow
			)
			(3
				(ScrollWindow 11 kWindow param2 param3) ; ScrollGo
			)
			(4
				(ScrollWindow 6 kWindow) ; ScrollDownArrow
			)
			(5
				(ScrollWindow 4 kWindow) ; ScrollPageDown
			)
			(6
				(ScrollWindow 8 kWindow) ; ScrollEnd
			)
		)
	)

	(method (move param1 param2 param3)
		(if (and (> argc 2) param3)
			(+= nsLeft param1)
			(+= nsRight param1)
			(+= nsTop param2)
			(+= nsBottom param2)
		else
			(+= nsRight (- param1 nsLeft))
			(+= nsBottom (- param2 nsTop))
			(= nsLeft param1)
			(= nsTop param2)
		)
		(ScrollWindow 9 kWindow self) ; ScrollResize
	)

	(method (resize param1 param2 param3)
		(if (and (> argc 2) param3)
			(+= nsRight param1)
			(+= nsBottom param2)
		else
			(= nsRight (+ nsLeft param1 -1))
			(= nsBottom (+ nsTop param2 -1))
		)
		(ScrollWindow 9 kWindow self) ; ScrollResize
	)

	(method (where param1)
		(ScrollWindow 10 kWindow param1) ; ScrollWhere
	)

	(method (dispose)
		(ScrollWindow 17 kWindow) ; ScrollDestroy
		(super dispose:)
	)
)

