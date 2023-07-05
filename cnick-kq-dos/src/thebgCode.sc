;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use System)

(public
	thebgCode 0
)

(local
	local0
	[local1 150]
	[local151 305]
	[local456 30]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(acey sel_3: (if global315 5 else 4))
	(if (or (== (global303 sel_31:) 2) (== (global304 sel_31:) 2))
		(acey sel_3: 4)
	)
	(doubl sel_3: (if global324 7 else 6))
	((= gGameControls backGamControls)
		sel_32: backGamWindow
		sel_215: iconHelp
		sel_210: (if (not (HaveMouse)) iconOK else 0)
		sel_118:
			(iconHelp sel_192: (Format @local1 399 28) sel_117:) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
			(iconOK
				sel_325: iconOK
				sel_404: 57
				sel_192: (Format @local151 399 29) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
				sel_117:
			)
			(doubl
				sel_325: doubl
				sel_404: 57
				sel_192: (Format @local456 399 32) ; "Allows using Doubling cube or not."
				sel_117:
			)
	)
	(gGameControls sel_198:)
)

(instance thebgCode of Code
	(properties
		sel_20 {thebgCode}
	)

	(method (sel_57)
		(localproc_0)
	)
)

(instance backGamControls of GameControls
	(properties
		sel_20 {backGamControls}
	)

	(method (sel_204 param1)
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(Print 310 0) ; "Clear this dialog box by pressing the "OK" button."
			(param1 sel_37: 0)
		)
		(super sel_204: param1 &rest)
	)
)

(instance backGamWindow of InvisibleWindow
	(properties
		sel_20 {backGamWindow}
		sel_187 40
		sel_188 112
		sel_189 168
		sel_190 211
	)

	(method (sel_183 &tmp temp0)
		(super sel_183:)
		(DrawCel 310 0 0 0 0 15)
		(Graph grUPDATE_BOX sel_187 sel_188 (+ sel_189 1) (+ sel_190 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		sel_20 {iconHelp}
		sel_2 310
		sel_3 1
		sel_4 0
		sel_7 9
		sel_6 77
		sel_33 980
		sel_37 6
		sel_14 387
		sel_196 -1
	)
)

(instance iconOK of ControlIcon
	(properties
		sel_20 {iconOK}
		sel_2 310
		sel_3 2
		sel_4 0
		sel_7 9
		sel_6 100
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp temp0)
		(gBackgam_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance acey of ControlIcon
	(properties
		sel_20 {acey}
		sel_2 310
		sel_4 0
		sel_7 96
		sel_6 23
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(Print 310 1) ; "This option is only available in the original Hoyles III Game. To pick up a copy of Hoyles III, call Sierra On-Line at (209) 683-4468."
	)
)

(instance altBoard of ControlIcon ; UNUSED
	(properties
		sel_20 {altBoard}
		sel_2 310
		sel_3 3
		sel_4 0
		sel_7 96
		sel_6 65
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= global317 (if (== global317 300) 350 else 300))
		(iconOK sel_57:)
	)
)

(instance doubl of ControlIcon
	(properties
		sel_20 {doubl}
		sel_2 310
		sel_4 0
		sel_7 9
		sel_6 33
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(if (< (= global324 (- 1 global324)) 0)
			(= global324 0)
		)
		(if (> global324 1)
			(= global324 1)
		)
		(doubl sel_3: (if global324 7 else 6))
		(self sel_198:)
	)
)

