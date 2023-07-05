;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use System)

(public
	thechCode 0
)

(local
	local0
	[local1 150]
	[local151 100]
	[local251 150]
	[local401 100]
	[local501 230]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconHelp sel_192: (Format @local1 299 11)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(iconOK sel_192: (Format @local151 299 12)) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
	(mustJumpButton sel_192: (Format @local251 299 13)) ; "This button will allow you to set whether or not a player must make a jump if there is a jump. Computer opponents always play `Must Jump On'."
	(drwButton sel_192: (Format @local401 299 15)) ; "Select this button when you wish to request a draw from your opponent."
	(resignButton sel_192: (Format @local501 299 20)) ; "Select this button when you want to resign the current game."
	(if (or (== global194 2) (== global195 2))
		(= global244 1)
	)
	(mustJumpButton sel_3: (if global244 1 else 2))
	((= gGameControls checkersControls)
		sel_32: checkersWindow
		sel_215: iconHelp
		sel_210: (if (not (HaveMouse)) iconOK else 0)
		sel_118:
			iconHelp
			(iconOK sel_325: iconOK sel_404: 57 sel_117:)
			(drwButton sel_325: drwButton sel_404: 57 sel_117:)
			(resignButton sel_325: resignButton sel_404: 57 sel_117:)
	)
	(gGameControls sel_198:)
)

(instance thechCode of Code
	(properties
		sel_20 {thechCode}
	)

	(method (sel_57)
		(localproc_0)
	)
)

(instance checkersControls of GameControls
	(properties
		sel_20 {checkersControls}
	)

	(method (sel_204 param1)
		(if (and (== (param1 sel_31:) 4) (== (param1 sel_37:) 27))
			(Print 210 0) ; "Clear this dialog box by pressing the "OK" button."
			(param1 sel_37: 0)
		)
		(super sel_204: param1 &rest)
	)
)

(instance checkersWindow of InvisibleWindow
	(properties
		sel_20 {checkersWindow}
		sel_187 55
		sel_188 92
		sel_189 137
		sel_190 229
	)

	(method (sel_183 &tmp temp0)
		(super sel_183:)
		(DrawCel 210 0 0 0 0 15)
		(Graph grUPDATE_BOX sel_187 sel_188 (+ sel_189 1) (+ sel_190 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		sel_20 {iconHelp}
		sel_2 210
		sel_3 4
		sel_4 0
		sel_7 7
		sel_6 32
		sel_33 980
		sel_37 6
		sel_14 387
		sel_196 -1
	)
)

(instance iconOK of ControlIcon
	(properties
		sel_20 {iconOK}
		sel_2 210
		sel_3 3
		sel_4 0
		sel_7 7
		sel_6 53
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp temp0)
		(gCheckers_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance mustJumpButton of ControlIcon
	(properties
		sel_20 {mustJumpButton}
		sel_2 210
		sel_3 1
		sel_4 0
		sel_7 66
		sel_6 83
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= global244 (- 1 global244))
		(if (and (or (== global194 2) (== global195 2)) (not global244))
			(= global244 1)
			(Print 299 14 64 -1 160) ; "The Must Jump option must stay ON since there is a computer opponent playing."
		)
		(= sel_3 (if global244 1 else 2))
		(self sel_198:)
	)
)

(instance drwButton of ControlIcon
	(properties
		sel_20 {drwButton}
		sel_2 210
		sel_3 8
		sel_4 0
		sel_7 63
		sel_6 53
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp [temp0 6] [temp6 6])
		(Format @temp0 299 16) ; "Yes"
		(Format @temp6 299 17) ; "No"
		(if (Print 299 6 78 @temp0 1 78 @temp6 0 64 -1 160) ; "Request Draw?"
			(= global260 1)
			(iconOK sel_57:)
		)
	)
)

(instance resignButton of ControlIcon
	(properties
		sel_20 {resignButton}
		sel_2 210
		sel_3 9
		sel_4 0
		sel_7 63
		sel_6 32
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp [temp0 6] [temp6 6])
		(Format @temp0 299 16) ; "Yes"
		(Format @temp6 299 17) ; "No"
		(if (Print 299 5 78 @temp0 1 78 @temp6 0 64 -1 160) ; "Resign game?"
			(= global262 1)
			(iconOK sel_57:)
		)
	)
)

(instance regularCheckers of ControlIcon ; UNUSED
	(properties
		sel_20 {regularCheckers}
		sel_2 210
		sel_3 5
		sel_4 0
		sel_7 30
		sel_6 25
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= global266 200)
		(gCheckers_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(if ((gGameControls sel_32:) sel_5:)
			(UnLoad 133 ((gGameControls sel_32:) sel_5:))
		)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance frogsCheckers of ControlIcon ; UNUSED
	(properties
		sel_20 {frogsCheckers}
		sel_2 210
		sel_3 6
		sel_4 0
		sel_7 123
		sel_6 25
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(= global266 250)
		(gCheckers_opt sel_57: 3)
		(gGameControls sel_102: sel_111:)
		(proc0_1)
		(= gGameControls local0)
	)
)

