;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 981)
(include sci.sh)
(use System)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority 15
		window 0
		type 0
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		eraseOnly 0
	)

	(method (open)
		(= window
			(NewWindow
				top
				left
				bottom
				right
				lsTop
				lsLeft
				lsBottom
				lsRight
				title
				type
				priority
				color
				back
			)
		)
	)

	(method (dispose)
		(if window
			(DisposeWindow window eraseOnly)
			(= window 0)
		)
		(super dispose:)
	)
)

(class Window of SysWindow
	(properties
		priority -1
		underBits 0
	)

	(method (center)
		(self
			moveTo:
				(/ (- (- brRight left) (- right left)) 2)
				(/ (- (- brBottom top) (- bottom top)) 2)
		)
	)

	(method (move h v)
		(+= left h)
		(+= right v)
		(+= right h)
		(+= bottom v)
	)

	(method (moveTo h v)
		(self move: (- h left) (- v top))
	)

	(method (inset h v)
		(+= top v)
		(+= left h)
		(-= bottom v)
		(-= right h)
	)

	(method (setMapSet &tmp mapSet)
		(= mapSet 0)
		(if (!= -1 color)
			(|= mapSet $0001)
		)
		(if (!= -1 priority)
			(|= mapSet $0002)
		)
		(return mapSet)
	)

	(method (show)
		(Graph grUPDATE_BOX top left bottom right (self setMapSet:))
	)

	(method (draw v p)
		(if (>= argc 1)
			(= color v)
		)
		(if (>= argc 2)
			(= priority p)
		)
		(Graph grFILL_BOX top left bottom right (self setMapSet:) color priority)
	)

	(method (save)
		(= underBits (Graph grSAVE_BOX top left bottom right (self setMapSet:)))
	)

	(method (restore)
		(if underBits
			(Graph grRESTORE_BOX underBits)
		)
	)

	(method (doit))

	(method (handleEvent)
		(return 0)
	)

	(method (dispose)
		(self restore:)
		(if window
			(DisposeWindow window)
			(= window 0)
		)
		(super dispose:)
	)

	(method (erase)
		(self draw: back -1)
	)
)

