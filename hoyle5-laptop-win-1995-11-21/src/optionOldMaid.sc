;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionOldMaid 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls oldMaidOptions)
		plane: oldMaidWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconRemovePairs theObj: iconRemovePairs selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 290)
)

(instance optionOldMaid of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance oldMaidWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0)
		(= top (/ (- gScreenHeight 89) 2))
		(= left (/ (- gScreenWidth 335) 2))
		(= bottom (+ (/ (- gScreenHeight 89) 2) 89))
		(= right (+ (/ (- gScreenWidth 335) 2) 335))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 290 0 0 0 0 15 self)
	)

	(method (dispose)
		(super dispose:)
		((ScriptID 200 2) doit:) ; pairCode
	)
)

(instance oldMaidOptions of HoyleGameControls
	(properties)
)

(instance iconRemovePairs of ControlIcon
	(properties
		noun 1
		modNum 290
		nsLeft 20
		nsTop 17
		x 20
		y 17
		signal 387
		mainView 290
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global226
				(0 1)
				(1 2)
			)
		)
		(self setPri: 16)
		(super init: &rest)
	)

	(method (doit)
		(switch global226
			(0
				(= global226 1)
				(= mainLoop 2)
			)
			(1
				(= global226 0)
				(= mainLoop 1)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconDeck of ControlIcon ; UNUSED
	(properties
		noun 2
		modNum 290
		nsLeft 20
		nsTop 47
		x 20
		y 47
		signal 387
		mainView 290
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainLoop
			(switch global227
				(0 3)
				(1 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global227
			(0
				(= global227 1)
				(= mainLoop 4)
			)
			(1
				(= global227 0)
				(= mainLoop 3)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 3
		modNum 290
		nsLeft 20
		nsTop 47
		x 20
		y 47
		signal 387
		mainView 290
		mainLoop 3
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
		noun 4
		modNum 290
		nsLeft 171
		nsTop 47
		x 171
		y 47
		signal 387
		mainView 290
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if 1
			(gOldmaid_opt doit: 3)
		)
	)
)

