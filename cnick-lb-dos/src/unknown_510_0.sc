;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use n010)
(use Interface)
(use GameControls)
(use System)

(public
	unknown_510_0 0
)

(local
	local0
	[local1 170]
	[local171 60]
	[local231 160]
	[local391 85]
	[local476 40]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(unknown_510_5 sel_3: (if global519 5 else 6))
	(unknown_510_6 sel_3: (if global536 3 else 4))
	(unknown_510_3 sel_192: (Format @local1 599 17)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(unknown_510_4 sel_192: (Format @local171 599 18)) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
	(unknown_510_5 sel_192: (Format @local231 599 19)) ; "If Lock Selection is ON, you must choose a score to go for before rolling the second roll and may not change your mind after rolling your second roll. If Lock Selection is Off, you may go for any score at any time."
	(unknown_510_6 sel_192: (Format @local391 599 20)) ; "Turns Color cycling On or Off for the PC VGA version. This button has no effect in the Amiga version."
	(Format @local476 599 21) ; "Color cycling is not supported in this version, sorry."
	((= gGameControls unknown_510_1)
		sel_32: unknown_510_2
		sel_215: unknown_510_3
		sel_210: (if (not (HaveMouse)) unknown_510_4 else 0)
		sel_118:
			unknown_510_3
			(unknown_510_4 sel_325: unknown_510_4 sel_404: 57 sel_117:)
			(unknown_510_6 sel_325: unknown_510_6 sel_404: 57 sel_117:)
			(unknown_510_5 sel_325: unknown_510_5 sel_404: 57 sel_117:)
	)
	(gGameControls sel_198:)
)

(instance unknown_510_0 of Code
	(properties
		sel_20 -1
	)

	(method (sel_57)
		(localproc_0)
	)
)

(instance unknown_510_1 of GameControls
	(properties
		sel_20 -1
	)

	(method (sel_204 param1)
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(Print 510 0) ; "Clear this dialog box by pressing the "OK" button."
			(param1 sel_37: 0)
		)
		(super sel_204: param1 &rest)
	)
)

(instance unknown_510_2 of Class_10_0
	(properties
		sel_187 50
		sel_188 81
		sel_189 153
		sel_190 247
	)

	(method (sel_183 &tmp temp0)
		(super sel_183:)
		(DrawCel 510 0 0 0 0 15)
		(Graph grUPDATE_BOX sel_187 sel_188 (+ sel_189 1) (+ sel_190 1) 1)
	)
)

(instance unknown_510_3 of ControlIcon
	(properties
		sel_20 -1
		sel_2 510
		sel_3 1
		sel_4 0
		sel_7 25
		sel_6 22
		sel_33 980
		sel_37 6
		sel_14 387
		sel_196 -1
	)
)

(instance unknown_510_4 of ControlIcon
	(properties
		sel_20 -1
		sel_2 510
		sel_3 2
		sel_4 0
		sel_7 25
		sel_6 53
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp temp0)
		(gYacht_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance unknown_510_5 of ControlIcon
	(properties
		sel_20 -1
		sel_2 510
		sel_4 0
		sel_7 73
		sel_6 22
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (> (= global519 (- 1 global519)) 1)
			(= global519 1)
		)
		(if (< global519 0)
			(= global519 0)
		)
		(self sel_3: (if global519 5 else 6))
		(self sel_198:)
	)
)

(instance unknown_510_6 of ControlIcon
	(properties
		sel_20 -1
		sel_2 510
		sel_4 0
		sel_7 73
		sel_6 53
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (> (= global536 (- 1 global536)) 1)
			(= global536 1)
		)
		(if (< global536 0)
			(= global536 0)
		)
		(self sel_3: (if global536 3 else 4))
		(self sel_198:)
		(if global294
			(Print 599 21 64 -1 160) ; "Color cycling is not supported in this version, sorry."
		)
	)
)

