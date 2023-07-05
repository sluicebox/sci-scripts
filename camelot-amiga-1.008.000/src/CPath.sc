;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 917)
(include sci.sh)
(use Interface)
(use Motion)

(class CPath of MoveTo
	(properties
		index -1
		dir 1
		endOfPath 0
	)

	(method (init param1 param2)
		(= client param1)
		(= caller (if (>= argc 2) param2 else 0))
		(= dir (if (>= dir 0) 1 else -1))
		(= x (client x:))
		(= y (client y:))
		(if (== endOfPath 0)
			(= endOfPath (self findEnd:))
		)
		(if (self atEnd:)
			(self moveDone:)
		else
			(self next:)
			(super init: client x y)
		)
	)

	(method (moveDone)
		(cond
			((not (self atEnd:))
				(self next:)
				(super init: client x y)
			)
			(caller
				(super moveDone:)
			)
			(else
				(= index -1)
				(self init: client)
			)
		)
	)

	(method (next)
		(if (== dir 1)
			(= x (self at: (++ index)))
			(= y (self at: (++ index)))
		else
			(if (<= index 0)
				(= index (self findEnd:))
			)
			(= y (self at: (-- index)))
			(= x (self at: (-- index)))
		)
	)

	(method (atEnd)
		(return (or (== index endOfPath) (== (+ index 1) endOfPath)))
	)

	(method (findEnd &tmp temp0)
		(for ((= temp0 0)) (!= (self at: temp0) -32768) ((++ temp0))
		)
		(return temp0)
	)

	(method (at)
		(Printf 917 0 name) ; "%s needs an 'at:' method."
		(return 0)
	)
)

