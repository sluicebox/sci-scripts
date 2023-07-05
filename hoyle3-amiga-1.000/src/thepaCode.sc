;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use File)
(use System)

(public
	thepaCode 0
	pachisi_opt 1
)

(local
	local0
	[local1 150]
	[local151 100]
	[local251 100]
	[local351 100]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconHelp helpStr: (Format @local1 499 9)) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button is for."
	(iconOK helpStr: (Format @local151 499 10)) ; "OK BUTTON - Pressing this button will return you to whatever you were doing."
	(useShells helpStr: (Format @local251 499 11)) ; "Choose between using shells or using Dice."
	(altBoard helpStr: (Format @local351 499 12)) ; "You may select which Pachisi board that you would like to play on.."
	(useShells loop: (if global404 5 else 2))
	((= gGameControls pachisiControls)
		window: pachisiWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
			(altBoard theObj: altBoard selector: #doit yourself:)
			(useShells theObj: useShells selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance thepaCode of Code
	(properties)

	(method (doit)
		(localproc_0)
	)
)

(instance pachisiControls of GameControls
	(properties)
)

(instance pachisiWindow of InvisibleWindow
	(properties
		top 40
		left 72
		bottom 157
		right 264
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 410 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 410
		loop 1
		cel 0
		nsLeft 12
		nsTop 34
		cursor 29
		message 6
		signal 387
		highlightColor -1
	)
)

(instance iconOK of ControlIcon
	(properties
		view 410
		loop 3
		cel 0
		nsLeft 12
		nsTop 67
		signal 387
		highlightColor -1
	)

	(method (doit &tmp temp0)
		(gPachisi_opt doit: 3)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
	)
)

(instance useShells of ControlIcon
	(properties
		view 410
		loop 2
		cel 0
		nsLeft 97
		nsTop 33
		signal 387
		highlightColor -1
	)

	(method (doit)
		(if (< (= global404 (- 1 global404)) 0)
			(= global404 0)
		)
		(if (> global404 1)
			(= global404 1)
		)
		(= loop (if global404 5 else 2))
		(self show:)
	)
)

(instance altBoard of ControlIcon
	(properties
		view 410
		loop 4
		cel 0
		nsLeft 97
		nsTop 66
		signal 387
		highlightColor -1
	)

	(method (doit)
		(= global406 (if (== global406 400) 450 else 400))
		(iconOK doit:)
	)
)

(instance pachisi_opt of File
	(properties
		name {pachisi.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 8])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString: (Format @temp0 410 0 global404 global406) ; "%d%3d"
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(if (< (= global404 (ReadNumber (self readString: @temp20 2))) 0)
					(= global404 0)
				)
				(if (> global404 1)
					(= global404 1)
				)
				(if
					(and
						(!=
							(= global406
								(ReadNumber (self readString: @temp20 4))
							)
							400
						)
						(!= global406 450)
					)
					(= global406 400)
				)
				(self close:)
				(return 0)
			)
			(else
				(= global404 0)
				(= global406 400)
				(return 0)
			)
		)
	)
)

