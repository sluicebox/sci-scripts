;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	proc76_0 0
)

(procedure (proc76_0 &tmp [temp0 4] temp4 temp5 temp6)
	(= temp6 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(Platform 0 4 3 -1)
	(SetCursor 237 65)
	(Format @temp0 {%d} global183)
	(if
		(OneOf
			(= temp5
				(Print
					addTitle: 10 0 4 1 0
					addText: 10 0 0 1 30 0 0 ; "Enter number of minutes between reminders:"
					addIcon: 972 0 0 0 0
					addEdit: @temp0 3 152 10 @temp0
					addButton: 200 10 0 3 1 150 30 0 ; "Done"
					addButton: 100 10 0 2 1 32 30 0 ; "Cancel"
					init:
				)
			)
			-1
			100
			0
		)
		(Platform 0 4 2 -1)
		(gGame setCursor: temp6)
		(DisposeScript 76)
		(return)
	)
	(if temp0
		(= temp4 (ReadNumber @temp0))
	)
	(if temp4
		(= global183 temp4)
		((ScriptID 0 12) setReal: gGame 0 temp4) ; saveTimer
	else
		(if (!= ((ScriptID 0 12) seconds:) -1) ; saveTimer
			((ScriptID 0 12) seconds: -1 client: (ScriptID 0 12)) ; saveTimer, saveTimer
		)
		(= global183 0)
	)
	(Platform 0 4 2 -1)
	(gGame setCursor: temp6)
	(DisposeScript 76)
)

