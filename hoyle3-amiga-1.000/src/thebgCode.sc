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
	[local151 60]
	[local211 50]
	[local261 95]
	[local356 30]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(acey loop: (if global315 5 else 4))
	(if (or (== (global303 type:) 2) (== (global304 type:) 2))
		(acey loop: 4)
	)
	(doubl loop: (if global324 7 else 6))
	((= gGameControls backGamControls)
		window: backGamWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconHelp helpStr: (Format @local1 399 28) yourself:) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
			(iconOK
				theObj: iconOK
				selector: #doit
				helpStr: (Format @local151 399 29) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
				yourself:
			)
			(altBoard
				theObj: altBoard
				selector: #doit
				helpStr: (Format @local211 399 31) ; "You may select which Backgammon board that you want to play on."
				yourself:
			)
			(acey
				theObj: acey
				selector: #doit
				helpStr: (Format @local261 399 30) ; "If this button is set to the ON position, two human Players may play Acey Deucey. Computer opponents do not play Acey Deucey."
				yourself:
			)
			(doubl
				theObj: doubl
				selector: #doit
				helpStr: (Format @local356 399 32) ; "Allows using Doubling cube or not."
				yourself:
			)
	)
	(gGameControls show:)
)

(instance thebgCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance backGamControls of GameControls
	(properties)
)

(instance backGamWindow of InvisibleWindow
	(properties
		top 40
		left 72
		bottom 152
		right 259
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 310 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 310
		loop 1
		cel 0
		nsLeft 11
		nsTop 65
		cursor 29
		message 6
		signal 387
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 310
		loop 2
		cel 0
		nsLeft 11
		nsTop 85
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gBackgam_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance acey of ControlIcon
	(properties
		view 310
		cel 0
		nsLeft 96
		nsTop 23
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (> (= global315 (- 1 global315)) 1)
			(= global315 1)
		)
		(if (< global315 0)
			(= global315 0)
		)
		(self loop: (if global315 5 else 4))
		(if (or (== (global303 type:) 2) (== (global304 type:) 2))
			(= global315 0)
			(self loop: 4)
			(self show:)
			(Print 399 33) ; "Acey Deucey may not be played with computer opponents playing."
		else
			(self show:)
			(if global315
				(Print 399 34) ; "Acey Deucey rules will take effect at the beginning of the next game."
			else
				(Print 399 35) ; "Backgammon rules will take effect at the beginning of the next game."
			)
		)
	)
)

(instance altBoard of ControlIcon
	(properties
		view 310
		loop 3
		cel 0
		nsLeft 96
		nsTop 65
		signal 387
		highlightColor -1
	)

	(method (doit)
		(= global317 (if (== global317 300) 350 else 300))
		(iconOK doit:)
	)
)

(instance doubl of ControlIcon
	(properties
		view 310
		cel 0
		nsLeft 11
		nsTop 23
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (< (= global324 (- 1 global324)) 0)
			(= global324 0)
		)
		(if (> global324 1)
			(= global324 1)
		)
		(doubl loop: (if global324 7 else 6))
		(self show:)
	)
)

