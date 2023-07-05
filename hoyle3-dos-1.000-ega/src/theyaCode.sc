;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use System)

(public
	theyaCode 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(lockSelection loop: (if global519 5 else 6))
	(cycling loop: (if global536 3 else 4))
	((= gGameControls yachtControls)
		window: yachtWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
			(cycling theObj: cycling selector: #doit yourself:)
			(lockSelection theObj: lockSelection selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance theyaCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance yachtControls of GameControls
	(properties)
)

(instance yachtWindow of InvisibleWindow
	(properties
		top 50
		left 81
		bottom 153
		right 247
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 510 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 510
		loop 1
		cel 0
		nsLeft 25
		nsTop 22
		cursor 29
		message 6
		signal 387
		helpStr {HELP BUTTON -\nThis is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for.}
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 510
		loop 2
		cel 0
		nsLeft 25
		nsTop 53
		signal 387
		helpStr {OK BUTTON -\nPressing this button will return you to whatever you were doing.}
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gYacht_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance lockSelection of ControlIcon
	(properties
		view 510
		cel 0
		nsLeft 73
		nsTop 22
		signal 387
		helpStr {If Lock Selection is ON, you must choose a score to go for before rolling the second roll and may not change your mind after rolling your second roll. If Lock Selection is Off, you may go for any score at any time.}
		highlightColor -1
	)

	(method (doit)
		(if (> (= global519 (- 1 global519)) 1)
			(= global519 1)
		)
		(if (< global519 0)
			(= global519 0)
		)
		(self loop: (if global519 5 else 6))
		(self show:)
	)
)

(instance cycling of ControlIcon
	(properties
		view 510
		cel 0
		nsLeft 73
		nsTop 53
		signal 387
		helpStr {Turns Color cycling On or Off if you are playing in 256 Color mode. This button has no effect in 16 color mode.}
		highlightColor -1
	)

	(method (doit)
		(if (> (= global536 (- 1 global536)) 1)
			(= global536 1)
		)
		(if (< global536 0)
			(= global536 0)
		)
		(self loop: (if global536 3 else 4))
		(self show:)
		(if global294
			(Print 510 0 #at -1 160) ; "Color cycling is not supported in this graphics mode."
		)
	)
)

