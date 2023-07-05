;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use System)

(class DialogScript of Script
	(properties)

	(method (handleEvent event param2)
		(switch state
			(0
				(= cycles 10)
			)
			(1
				(= global401 -1)
				(if
					(and
						(< global323 60)
						(== global407 1)
						global408
						(== (global302 worksAt:) global400)
						param2
					)
					(event message: KEY_w)
					(if (-- global408)
						(-- state)
					)
					(= cycles 10)
				)
			)
			(10
				(= global407 0)
				(if
					(and
						(< global323 60)
						(!= global407 1)
						(== (global302 worksAt:) global400)
						global329
						param2
						(global302 dressedForWork:)
					)
					(= global407 1)
					(= global408 3)
					(if global551
						(++ global408)
					)
				)
				(if (and (== global407 1) global408)
					(event message: KEY_w)
					(if (-- global408)
						(-- state)
					)
					(= cycles 10)
				)
			)
			(19
				(= global401 ((ScriptID 300 0) doit: global302)) ; WhereShouldIGo
				(if (and (< global323 60) (== global401 global400))
					(= state 0)
				)
			)
			(20
				(event message: KEY_x)
			)
		)
	)

	(method (cue)
		(++ state)
		(= register 1)
	)
)

