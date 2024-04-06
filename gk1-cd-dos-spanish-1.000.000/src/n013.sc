;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Print)

(public
	IsFlag 0
	SetFlag 1
	ClearFlag 2
	Face 3
	Fade 4
	SkipSceneDialog 5
	proc13_6 6
)

(procedure (IsFlag param1 param2 &tmp temp0)
	(= temp0 (& [global127 (/ param1 16)] (>> $8000 (mod param1 16))))
	(if (not param2)
		(return temp0)
	else
		(return temp0)
	)
)

(procedure (SetFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1 1))
	(|= [global127 (/ param1 16)] (>> $8000 (mod param1 16)))
	(return temp0)
)

(procedure (ClearFlag param1 &tmp temp0)
	(= temp0 (IsFlag param1))
	(&= [global127 (/ param1 16)] (~ (>> $8000 (mod param1 16))))
	(return temp0)
)

(procedure (Face param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (not (> argc 3))
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
	(param1 setHeading: temp0 temp3)
)

(procedure (Fade &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
		(Palette 2 0 255 temp0) ; PalIntensity
	)
)

(procedure (SkipSceneDialog &tmp temp0 temp1)
	(= temp0 (Print new:))
	(temp0 x: 85 y: 32 margin: 0)
	((temp0 addIcon: 952 0 0 0 0) state: 0)
	((temp0 addIcon: 952 1 0 6 100) value: 1 state: 3)
	((temp0 addIcon: 952 2 0 101 100) value: 0 state: 3)
	((temp0 dialog:) mouseHiliting: 1)
	(= temp1 (temp0 init:))
)

(procedure (proc13_6 param1 param2 param3 param4 param5)
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

