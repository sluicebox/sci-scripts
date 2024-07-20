;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 912)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	useStndrd 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(iconUseStandard loop: (- 2 global462))
	((= gGameControls useStandardControls)
		plane: useStandardWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconUseStandard theObj: iconUseStandard selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls init:)
	(gGameControls show:)
	(DisposeScript 912)
)

(instance useStndrd of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance useStandardWindow of InvisibleWindow
	(properties
		left 53
		top 72
		right 267
		bottom 127
	)

	(method (init)
		(super init:)
		(= priority 15)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(proc0_10 912 0 0 0 0 8 self)
	)
)

(instance useStandardControls of HoyleGameControls
	(properties)
)

(instance iconUseStandard of ControlIcon
	(properties
		noun 3
		modNum 912
		nsLeft 12
		nsTop 10
		x 12
		y 10
		signal 387
		mainView 912
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(= global462 (if global462 0 else 1))
		(= mainLoop (- 2 global462))
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 2
		modNum 912
		nsLeft 12
		nsTop 28
		x 12
		y 28
		signal 387
		mainView 912
		mainLoop 3
		cursorView 995
		highlightColor -1
		helpVerb 4
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 1
		modNum 912
		nsLeft 104
		nsTop 28
		x 104
		y 28
		signal 387
		mainView 912
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
	)
)

