;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64919)
(include sci.sh)
(use WriteFeature)

(class Rectangle of Obj
	(properties
		left -1
		top -1
		right -1
		bottom -1
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(if (== argc 4)
			(temp0 setRect: &rest)
		)
		(return temp0)
	)

	(method (init)
		(if (== argc 4)
			(self setRect: &rest)
		)
	)

	(method (check)
		(if (or (< right left) (< bottom top))
			(PrintDebug {%s at %d is invalid\n} (self name:) self)
			(Empty self)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 2)
			(= temp0 param1)
			(= temp1 param2)
		else
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		)
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)

	(method (setRect param1 param2 param3 param4)
		(= left param1)
		(= top param2)
		(= right param3)
		(= bottom param4)
		(self check:)
	)
)

