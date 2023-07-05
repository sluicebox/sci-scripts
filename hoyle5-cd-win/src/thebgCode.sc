;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1310)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	thebgCode 0
)

(local
	local0
	[local1 385]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls backGamControls)
		plane: backGamWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		okIconItem: iconOK
		add:
			(iconHelp yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
			(doubl theObj: doubl selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 1310)
)

(instance thebgCode of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance backGamControls of HoyleGameControls
	(properties)
)

(instance backGamWindow of InvisibleWindow
	(properties
		left 220
		top 200
		right 514
		bottom 394
	)

	(method (init &tmp temp0)
		(= priority 10)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1390 0 0 0 0 15 self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 3
		modNum 1310
		nsLeft 18
		nsTop 48
		x 18
		y 48
		signal 387
		mainView 1390
		mainLoop 1
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 2
		modNum 1310
		nsLeft 112
		nsTop 48
		x 112
		y 48
		signal 387
		mainView 1390
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(if 1
			(gBackgam_opt doit: 3)
		)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance acey of ControlIcon ; UNUSED
	(properties
		nsLeft 18
		nsTop 48
		x 18
		y 48
		signal 387
		mainView 1390
		mainLoop 4
		highlightColor -1
	)

	(method (init)
		(= mainLoop (if global765 5 else 4))
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(if (> (= global765 (- 1 global765)) 1)
			(= global765 1)
		)
		(if (< global765 0)
			(= global765 0)
		)
		(= mainLoop (if global765 5 else 4))
		(if (or (== (global753 type:) 2) (== (global754 type:) 2))
			(= global765 0)
			(self loop: 4)
			(self show:)
		else
			(self show:)
			(if global765 1 else 1)
		)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance altBoard of ControlIcon ; UNUSED
	(properties
		nsLeft 192
		nsTop 156
		x 192
		y 156
		signal 387
		mainView 1390
		mainLoop 3
		highlightColor -1
	)

	(method (doit)
		(= global767 (if (== global767 1300) 350 else 1300))
		(iconOK doit:)
	)
)

(instance doubl of ControlIcon
	(properties
		noun 1
		modNum 1310
		nsLeft 18
		nsTop 19
		x 18
		y 19
		signal 387
		mainView 1390
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop (if global774 7 else 6))
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(if (< (= global774 (- 1 global774)) 0)
			(= global774 0)
		)
		(if (> global774 1)
			(= global774 1)
		)
		(= mainLoop (if global774 7 else 6))
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

