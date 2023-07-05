;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Array)
(use System)

(public
	HotSpot 0
)

(class HotSpot of Obj
	(properties
		_respondVerbs 0
		theVerb 0
	)

	(method (setProps param1)
		(= theVerb [param1 0])
		(if (> argc 1)
			(self respondVerbs: &rest)
		)
	)

	(method (doit)
		(cond
			((or (not (gUser useHotspots:)) (== gTheCursor gWaitCursor))
				(return)
			)
			(global161
				(if (!= global193 1)
					(gTheCursor
						view: (global161 hiliteView:)
						loop: (global161 loop:)
						setCel: (global161 cel:)
					)
					(= global193 1)
				)
				(gUser message: (global161 verb:))
			)
			((not (global118 respondsTo: #exitDir))
				(if (!= global193 2)
					(gTheCursor loop: 0 setCel: 0)
					(= global193 2)
				)
				(gUser message: theVerb)
			)
			(else
				(if
					(or
						(!= global193 3)
						(and
							(== global193 3)
							(!= (gTheCursor loop:) (+ (global118 exitDir:) 1))
						)
					)
					(gTheCursor
						view: 9960
						loop: (+ (global118 exitDir:) 1)
						setCel: 0
					)
					(= global193 3)
				)
				(gUser message: theVerb)
			)
		)
		(= global192 gTheCursor)
	)

	(method (respondVerbs param1 &tmp temp0)
		(if _respondVerbs
			(_respondVerbs dispose:)
			(= _respondVerbs 0)
		)
		(if (and argc [param1 0])
			(= _respondVerbs (ByteArray new: 3))
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(_respondVerbs at: temp0 [param1 temp0])
			)
		)
	)

	(method (respondsTo param1 &tmp temp0 temp1)
		(if global161
			(= temp1 (global161 verb:))
		else
			(= temp1 param1)
		)
		(for ((= temp0 0)) (< temp0 (_respondVerbs size:)) ((++ temp0))
			(if (== (_respondVerbs at: temp0) temp1)
				(return 1)
			)
		)
		(return 0)
	)

	(method (dispose)
		(if _respondVerbs
			(_respondVerbs dispose:)
			(= _respondVerbs 0)
		)
		(super dispose:)
	)
)

