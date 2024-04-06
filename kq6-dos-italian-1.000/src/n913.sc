;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 913)
(include sci.sh)
(use Main)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	NextAct 3
	Face 4
	proc913_5 5
	proc913_6 6
	proc913_7 7
)

(procedure (IsFlag param1)
	(return (& [global137 (/ param1 16)] (>> $8000 (mod param1 16))))
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(|= [global137 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global137 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (NextAct)
	(++ gAct)
	(ClearFlag 27)
	(ClearFlag 28)
	(ClearFlag 18)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x:))
		(= temp2 (param2 y:))
		(if (== argc 3)
			(= temp3 param3)
		)
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4)
			(= temp3 param4)
		)
	)
	(= temp0 (GetAngle (param1 x:) (param1 y:) temp1 temp2))
	(param1 setHeading: temp0 (and (IsObject temp3) temp3))
)

(procedure (proc913_5 param1 param2 param3 param4 param5)
	(return
		(switch (gGame printLang:)
			(49 param1)
			(34 param2)
			(33 param3)
			(39 param4)
			(else param5)
		)
	)
)

(procedure (proc913_6 param1 param2 param3 &tmp [temp0 4])
	(TextSize @[temp0 0] param1 param3 -1 0)
	(return (- param2 (/ (- [temp0 3] [temp0 1]) 2)))
)

(procedure (proc913_7 param1 param2 param3 &tmp [temp0 4])
	(TextSize @[temp0 0] param1 param3 -1 0)
	(return (- param2 (/ (- [temp0 2] [temp0 0]) 2)))
)

