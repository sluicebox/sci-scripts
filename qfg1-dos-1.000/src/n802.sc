;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use User)

(public
	proc802_0 0
	proc802_1 1
	proc802_2 2
)

(procedure (proc802_0 param1)
	(if (or (< param1 65) (> param1 90))
		(return param1)
	else
		(return (+ (- param1 65) 97))
	)
)

(procedure (proc802_1 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (StrLen param2))
	(for
		((= temp0 (- (= temp0 (StrLen param1)) temp1)))
		(>= temp0 0)
		((-- temp0))
		
		(= temp3 0)
		(for ((= temp2 temp0)) (< temp3 temp1) ((++ temp2))
			(if
				(!=
					(proc802_0 (StrAt param2 temp3))
					(proc802_0 (StrAt param1 temp2))
				)
				(break)
			)
			(++ temp3)
		)
		(if (== temp3 temp1)
			(return (+ temp3 1))
		)
	)
	(return 0)
)

(procedure (proc802_2 param1 param2 &tmp temp0 temp1)
	(if
		(and
			(User canInput:)
			(not (param1 claimed:))
			(== (param1 type:) 4)
			(or
				(== (param1 message:) (User echo:))
				(<= 32 (param1 message:) 127)
			)
			(User getInput: param1)
		)
		(param1 claimed: 1)
		(= temp1 (User inputLineAddr:))
		(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
			(if (proc802_1 temp1 [param2 (- temp0 1)])
				(return temp0)
			)
		)
		(param1 type: 128)
		(param1 claimed: 0)
		(Parse temp1 param1)
		(User said: param1)
	)
	(return 0)
)

