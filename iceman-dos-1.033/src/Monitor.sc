;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 826)
(include sci.sh)
(use Main)
(use Submarine_806)
(use n827)
(use System)

(class Monitor of Code
	(properties
		active 0
		theSelector 0
		value 0
		cycles 0
		variance 0
		count 0
	)

	(method (init param1 param2 param3)
		(if argc
			(= theSelector param1)
			(if (>= argc 2)
				(= value param2)
				(if (>= argc 3)
					(= variance param3)
				)
			)
		)
		(= count 0)
		(= active 1)
	)

	(method (doit)
		(if
			(and
				active
				(not (umod (++ cycles) 50))
				(> (Abs (- value (proc827_0 Submarine theSelector))) variance)
			)
			(if (<= (++ count) 3)
				(if gModelessDialog
					(-- count)
				else
					(self warn:)
				)
			else
				(self die:)
			)
		)
	)

	(method (warn))

	(method (die))
)

