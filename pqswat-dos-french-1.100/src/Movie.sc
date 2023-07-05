;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class Movie of Obj
	(properties
		number 1
		x 0
		y 0
		startFrame 0
		curFrame -1
		endFrame 0
		modeless 0
		caller 0
		inited 0
		error 0
	)

	(method (init param1)
		(= inited 1)
		(if modeless
			(gTheDoits add: self)
		)
		(if (and argc param1)
			(= name param1)
		)
		(self open:)
	)

	(method (doit &tmp temp0)
		(if (= temp0 (self getStatus:))
			(= curFrame (ShowMovie number 9))
			(if (and modeless (== temp0 5))
				(self close:)
			)
		)
	)

	(method (open param1)
		(if (and argc param1)
			(= name param1)
		)
		(if (not inited)
			(self init:)
		)
		(= error (ShowMovie number 0 name))
		(self displayError:)
		(= endFrame (ShowMovie number 8))
	)

	(method (play param1)
		(if (and argc param1)
			(= name param1)
		)
		(if (not inited)
			(self open:)
		)
		(= error (ShowMovie number 2 startFrame endFrame 2 modeless))
		(self displayError:)
	)

	(method (close)
		(if inited
			(ShowMovie number 6)
			(if modeless
				(gTheDoits delete: self)
			)
			(= inited 0)
			(if caller
				(if (not gCuees)
					(= gCuees (Set new:))
				)
				(gCuees add: ((Cue new:) cuee: caller yourself:))
				(= caller 0)
			)
		)
	)

	(method (posn param1 &tmp temp0 temp1)
		(= x [param1 0])
		(= y [param1 1])
		(= temp0 (= temp1 0))
		(if (> argc 2)
			(= temp0 [param1 2])
			(if (> argc 3)
				(= temp1 [param1 3])
			)
		)
		(= error (ShowMovie number 1 x y temp0 temp1))
		(self displayError:)
	)

	(method (setPalette)
		(= error (ShowMovie number 7))
		(self displayError:)
	)

	(method (pause param1)
		(if (and argc (not param1))
			(= error (ShowMovie number 5))
		else
			(= error (ShowMovie number 4))
		)
		(self displayError:)
	)

	(method (resume)
		(self pause: 0)
	)

	(method (cueUp param1)
		(= error (ShowMovie number 11 param1))
		(self displayError:)
	)

	(method (stop)
		(self pause:)
	)

	(method (setModeless param1)
		(= modeless (or (not argc) param1))
	)

	(method (seek param1)
		(ShowMovie number 12 param1)
	)

	(method (displayError)
		(if (and error global102)
			(Printf {Movie Error: %d} error)
		)
	)

	(method (getStatus)
		(ShowMovie number 10)
	)
)

