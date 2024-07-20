;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1210)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	thechCode 0
)

(local
	local0
	[local1 730]
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls checkersControls)
		plane: checkersWindow
		helpIconItem: iconHelp
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		okIconItem: iconOK
		add:
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
			(drwButton theObj: drwButton selector: #doit yourself:)
			(resignButton theObj: resignButton selector: #doit yourself:)
			(regularCheckers theObj: regularCheckers selector: #doit yourself:)
			(frogsCheckers theObj: frogsCheckers selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 1210)
)

(instance thechCode of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance checkersControls of HoyleGameControls
	(properties)
)

(instance checkersWindow of InvisibleWindow
	(properties
		left 190
		top 100
		right 490
		bottom 400
	)

	(method (init &tmp temp0)
		(= priority 10)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1290 0 0 0 0 15 self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 6
		modNum 1210
		nsLeft 24
		nsTop 138
		x 24
		y 138
		signal 387
		mainView 1290
		mainLoop 5
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 5
		modNum 1210
		nsLeft 150
		nsTop 138
		x 150
		y 138
		signal 387
		mainView 1290
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(gCheckers_opt doit: 3)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance drwButton of ControlIcon
	(properties
		noun 3
		modNum 1210
		nsLeft 24
		nsTop 105
		x 24
		y 105
		signal 387
		mainView 1290
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 12])
		(= global826 1)
		(iconOK doit:)
	)
)

(instance resignButton of ControlIcon
	(properties
		noun 4
		modNum 1210
		nsLeft 150
		nsTop 105
		x 150
		y 105
		signal 387
		mainView 1290
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 12])
		(= global828 1)
		(iconOK doit:)
	)
)

(instance regularCheckers of ControlIcon
	(properties
		noun 2
		modNum 1210
		nsLeft 16
		nsTop 17
		x 16
		y 17
		signal 387
		mainView 1290
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(= global832 200)
		(gCheckers_opt doit: 3)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

(instance frogsCheckers of ControlIcon
	(properties
		noun 1
		modNum 1210
		nsLeft 143
		nsTop 17
		x 143
		y 17
		signal 387
		mainView 1290
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(= global832 250)
		(gCheckers_opt doit: 3)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

