;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use System)

(public
	proc76_0 0
)

(procedure (proc76_0 &tmp temp0 temp1 temp2 temp3)
	(= temp3 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(= temp0 (Str format: {%d} global183))
	(if
		(OneOf
			(= temp2
				(Print
					addTitle: 10 0 4 1 0
					addText: 10 0 0 1 50 1 0 ; "Enter number of minutes between reminders:"
					addIcon: 972 0 0 0 0
					addEdit: temp0 3 160 10 temp0
					addButton: 100 10 0 2 1 50 33 0 ; "Cancel"
					addButton: 200 10 0 3 1 160 33 0 ; "Done"
					init:
				)
			)
			-1
			100
			0
		)
		(gGame setCursor: temp3)
		(DisposeScript 76)
		(return)
	)
	(if temp0
		(= temp1 (temp0 asInteger:))
	)
	(if temp1
		(= global183 temp1)
		((ScriptID 0 12) setReal: gGame 0 temp1) ; sTimer
	else
		(if (!= ((ScriptID 0 12) seconds:) -1) ; sTimer
			((ScriptID 0 12) seconds: -1 client: (ScriptID 0 12)) ; sTimer, sTimer
		)
		(= global183 0)
	)
	(gGame setCursor: temp3)
	(DisposeScript 76)
)

