;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 821)
(include sci.sh)
(use Main)
(use Interface)

(public
	EgoDead 0
)

(procedure (EgoDead param1 param2 param3 &tmp [temp0 80] temp80 temp81 temp82)
	(switch global101
		(1
			((ScriptID 371) dispose:) ; tahitiInv
		)
		(2
			((ScriptID 372) dispose:) ; subInv
		)
		(3
			((ScriptID 374) dispose:) ; tunaInv
		)
	)
	(= temp80 (if (>= argc 1) param1 else 7))
	(= temp81 (if (>= argc 2) param2))
	(= temp82 (if (>= argc 3) param3))
	(if (> argc 3)
		(Format @temp0 &rest)
	else
		(Format @temp0 821 0) ; "Thanks for playing Code Name: ICEMAN. As usual, you've been a real hoot."
	)
	(gIceGlobalSound number: (proc0_5 71) loop: 1 play:)
	(repeat
		(switch
			(Print
				@temp0
				#icon
				temp80
				temp81
				temp82
				#mode
				1
				#title
				{Restart? Restore?... At least once more!!!}
				#button
				{Restore}
				1
				#button
				{Restart}
				2
				#button
				{    Quit    }
				3
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

