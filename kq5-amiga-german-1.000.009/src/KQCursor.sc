;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 768)
(include sci.sh)
(use Cursor)

(class KQCursor of Cursor
	(properties
		number 0
	)

	(method (init)
		(cond
			(number
				(SetCursor number &rest)
			)
			(view
				(SetCursor
					view
					loop
					cel
					x
					y
					(if (and skipOne (!= skipOne 0)) skipOne else 900)
					(if (and skipTwo (!= skipTwo 0)) skipTwo else 900)
					(if (and skipThree (!= skipThree 0)) skipThree else 900)
					(if (and skipFour (!= skipFour 0)) skipFour else 900)
				)
				(if (or curPosnX curPosnY)
					(MoveCursor curPosnX curPosnY)
					(= curPosnX (= curPosnY 0))
				)
			)
		)
	)
)

