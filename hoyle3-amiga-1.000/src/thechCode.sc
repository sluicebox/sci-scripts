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
	[local501 90]
	[local591 70]
	[local661 70]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconHelp helpStr: (Format @local1 299 11)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(iconOK helpStr: (Format @local151 299 12)) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
	(mustJumpButton helpStr: (Format @local251 299 13)) ; "This button will allow you to set whether or not a player must make a jump if there is a jump. Computer opponents always play `Must Jump On'."
	(drwButton helpStr: (Format @local401 299 15)) ; "Select this button when you wish to request a draw from your opponent."
	(resignButton helpStr: (Format @local501 299 20)) ; "Select this button when you want to resign the current game."
	(regularCheckers helpStr: (Format @local591 299 21)) ; "Regular Checkers Pieces will be used if you press this button."
	(frogsCheckers helpStr: (Format @local661 299 22)) ; "Frog Pieces will be used if you press this button."
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
		highlightColor -1
	)

	(method (doit)
		(= global244 (- 1 global244))
		(if (and (or (== global194 2) (== global195 2)) (not global244))
			(= global244 1)
			(Print 299 14) ; "The Must Jump option must stay ON since there is a computer opponent playing."
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
		highlightColor -1
	)

	(method (doit &tmp [temp0 6] [temp6 6])
		(Format @temp0 299 16) ; "Yes"
		(Format @temp6 299 17) ; "No"
		(if (Print 299 6 #button @temp0 1 #button @temp6 0) ; "Request Draw?"
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
		highlightColor -1
	)

	(method (doit &tmp [temp0 6] [temp6 6])
		(Format @temp0 299 16) ; "Yes"
		(Format @temp6 299 17) ; "No"
		(if (Print 299 5 #button @temp0 1 #button @temp6 0) ; "Resign game?"
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

