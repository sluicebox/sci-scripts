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
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(if (or (== global194 2) (== global195 2))
		(= global244 1)
	)
	(mustJumpButton loop: (if global244 1 else 2))
	((= gGameControls checkersControls)
		window: checkersWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
			(drwButton theObj: drwButton selector: #doit yourself:)
			(resignButton theObj: resignButton selector: #doit yourself:)
			(mustJumpButton theObj: mustJumpButton selector: #doit yourself:)
			(regularCheckers theObj: regularCheckers selector: #doit yourself:)
			(frogsCheckers theObj: frogsCheckers selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance thechCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance checkersControls of GameControls
	(properties)
)

(instance checkersWindow of InvisibleWindow
	(properties
		top 40
		left 55
		bottom 166
		right 267
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 210 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 210
		loop 4
		cel 0
		nsLeft 8
		nsTop 83
		cursor 29
		message 6
		signal 387
		helpStr {HELP BUTTON -\nThis is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for.}
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 210
		loop 3
		cel 0
		nsLeft 8
		nsTop 103
		signal 387
		helpStr {OK BUTTON -\nPressing this button will return you to whatever you were doing.}
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gCheckers_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance mustJumpButton of ControlIcon
	(properties
		view 210
		loop 1
		cel 0
		nsLeft 66
		nsTop 83
		signal 387
		helpStr {This button will allow you to set whether or not a player must make a jump if there is a jump. Computer opponents always play `Must Jump On'.}
		highlightColor -1
	)

	(method (doit)
		(= global244 (- 1 global244))
		(if (and (or (== global194 2) (== global195 2)) (not global244))
			(= global244 1)
			(Print 210 0 #at -1 160) ; "The Must Jump option must stay ON since there is a computer opponent playing."
		)
		(= loop (if global244 1 else 2))
		(self show:)
	)
)

(instance drwButton of ControlIcon
	(properties
		view 210
		loop 8
		cel 0
		nsLeft 66
		nsTop 103
		signal 387
		helpStr {Select this button when you wish to request a draw from your opponent.}
		highlightColor -1
	)

	(method (doit)
		(if (Print 210 1 #button {Yes} 1 #button {No} 0 #at -1 160) ; "Request Draw?"
			(= global260 1)
			(iconOK doit:)
		)
	)
)

(instance resignButton of ControlIcon
	(properties
		view 210
		loop 9
		cel 0
		nsLeft 138
		nsTop 103
		signal 387
		helpStr {Select this button when you want to resign the current game.}
		highlightColor -1
	)

	(method (doit)
		(if (Print 210 2 #button {Yes} 1 #button {No} 0 #at -1 160) ; "Resign game?"
			(= global262 1)
			(iconOK doit:)
		)
	)
)

(instance regularCheckers of ControlIcon
	(properties
		view 210
		loop 5
		cel 0
		nsLeft 30
		nsTop 25
		signal 387
		helpStr {Regular Checkers Pieces will be used if you press this button.}
		highlightColor -1
	)

	(method (doit)
		(= global266 200)
		(gCheckers_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance frogsCheckers of ControlIcon
	(properties
		view 210
		loop 6
		cel 0
		nsLeft 123
		nsTop 25
		signal 387
		helpStr {Frog Pieces will be used if you press this button.}
		highlightColor -1
	)

	(method (doit)
		(= global266 250)
		(gCheckers_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

