;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)

(public
	proc115_0 0
	proc115_1 1
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= local0 (mod (= temp0 (+ param1 param2 local1)) 10))
	(= local1 (/ temp0 10))
	(return local0)
)

(procedure (proc115_0 param1 param2 &tmp temp0 [temp1 20] [temp21 20] temp41 temp42 temp43 temp44)
	(if (or (not param1) (< param2 0))
		(= temp44 (Format @global275 115 0 param2)) ; "%d"
	else
		(= local1 0)
		(= temp42 0)
		(= temp41 32766)
		(repeat
			(= temp0 (localproc_0 (* (mod temp41 10) param1) (mod param2 10)))
			(/= param2 10)
			(/= temp41 10)
			(StrAt @temp1 temp42 (+ temp0 48))
			(++ temp42)
			(if (== param2 0)
				(if (== temp41 0)
					(if local1
						(= param2 local1)
						(= param1 0)
						(= temp41 0)
						(= local1 0)
						(continue)
					)
				else
					(continue)
				)
			else
				(continue)
			)
			(break)
		)
		(StrAt @temp1 temp42 0)
		(for
			((= temp42 (= temp43 (- (StrLen @temp1) 1))))
			(>= temp42 0)
			((-- temp42))
			
			(= temp0 (StrAt @temp1 temp42))
			(StrAt @temp21 (- temp43 temp42) temp0)
		)
		(StrAt @temp21 (+ temp43 1) 0)
		(StrCpy @global275 @temp21)
		(= temp44 @global275)
	)
	(return temp44)
)

(procedure (proc115_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp3 (= temp4 0))
	(= temp1 0)
	(= temp2 (param1 shares:))
	(for ((= temp0 0)) (< temp0 param2) ((++ temp0))
		(proc0_12 temp3 temp4 temp1 temp2)
		(= temp3 global454)
		(= temp4 global455)
	)
	(= global454 temp3)
	(= global455 temp4)
)

