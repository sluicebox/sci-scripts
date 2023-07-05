;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 985)
(include sci.sh)
(use System)

(class Avoid of Obj
	(properties
		size 0
		array 0
	)

	(method (init)
		(if (and size (not array))
			(self setSize: size)
		)
	)

	(method (setSize param1 &tmp temp0 temp1)
		(= temp0 (/ param1 16))
		(if (mod param1 16)
			(++ temp0)
		)
		(= size (* temp0 16))
		(= array (Memory memALLOC_CRIT (* temp0 2)))
		(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
			(Memory memPOKE (+ array (* temp1 2)) 0)
		)
	)

	(method (dispose)
		(if array
			(Memory memFREE array)
			(= array 0)
		)
		(super dispose:)
	)

	(method (set param1 &tmp temp0 temp1)
		(while argc
			(= temp1 (* (/ [param1 (-- argc)] 16) 2))
			(= temp0
				(|
					(= temp0 (Memory memPEEK (+ array temp1)))
					(>> $8000 (mod [param1 argc] 16))
				)
			)
			(Memory memPOKE (+ array temp1) temp0)
		)
	)

	(method (clear param1 &tmp temp0 temp1)
		(while argc
			(= temp1 (* (/ [param1 (-- argc)] 16) 2))
			(= temp0
				(&
					(= temp0 (Memory memPEEK (+ array temp1)))
					(~ (>> $8000 (mod [param1 argc] 16)))
				)
			)
			(Memory memPOKE (+ array temp1) temp0)
		)
	)

	(method (test param1 &tmp temp0 temp1)
		(= temp1 (* (/ param1 16) 2))
		(return
			(& (= temp0 (Memory memPEEK (+ array temp1))) (>> $8000 (mod param1 16)))
		)
	)
)

