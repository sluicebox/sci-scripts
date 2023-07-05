;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 653)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	theSNCode 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(finish loop: (if global275 3 else 4))
	(star loop: (if global274 5 else 6))
	((= gGameControls snakesControls)
		window: snakesWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconOK theObj: iconOK selector: #doit yourself:)
			iconHelp
			(finish theObj: finish selector: #doit yourself:)
			(star theObj: star selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance theSNCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance snakesControls of GameControls
	(properties)
)

(instance snakesWindow of InvisibleWindow
	(properties
		top 47
		left 100
		bottom 154
		right 230
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 653 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 653
		loop 2
		cel 0
		nsLeft 8
		nsTop 80
		cursor 29
		message 6
		signal 387
		helpStr {HELP BUTTON -\nThis is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for.}
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 653
		loop 1
		cel 0
		nsLeft 67
		nsTop 80
		signal 387
		helpStr {OK BUTTON -\nPressing this button will return you to whatever you were doing.}
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gSnakes_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance finish of ControlIcon
	(properties
		view 653
		cel 0
		nsLeft 8
		nsTop 25
		signal 387
		helpStr {This will allow all players to finish the game or just the first player to finish depending on how it is set.}
		highlightColor -1
	)

	(method (doit)
		(if (= global275 (- 1 global275))
			(= loop 3)
		else
			(= loop 4)
		)
		(self show:)
	)
)

(instance star of ControlIcon
	(properties
		view 653
		cel 0
		nsLeft 8
		nsTop 54
		signal 387
		helpStr {If set to ON, a Star will appear which indicates which square the player is to click on. If set to OFF, no star will appear. The player will have to count the squares to move.}
		highlightColor -1
	)

	(method (doit)
		(if (= global274 (- 1 global274))
			(= loop 5)
		else
			(= loop 6)
		)
		(self show:)
	)
)

