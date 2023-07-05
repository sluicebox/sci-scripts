;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6090)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	optionKlondike 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(= local1 global927)
	(if (== global927 0)
		(iconDifficulty mainCel: 0)
	else
		(iconDifficulty mainCel: 2)
	)
	(= local0 gGameControls)
	((= gGameControls klondikeOptions)
		plane: klondikeWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconAbandon theObj: iconAbandon selector: #doit yourself:)
			(iconSameDeck theObj: iconSameDeck selector: #doit yourself:)
			(iconDifficulty theObj: iconDifficulty selector: #doit yourself:)
			(iconSave theObj: iconSave selector: #doit yourself:)
			(iconRestore theObj: iconRestore selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 690)
)

(instance optionKlondike of Code
	(properties)

	(method (init)
		(Load rsVIEW 690)
		(localproc_0)
	)
)

(instance klondikeWindow of InvisibleWindow
	(properties)

	(method (init &tmp temp0)
		(= top (/ (- gScreenHeight 199) 2))
		(= left (/ (- gScreenWidth 329) 2))
		(= bottom (+ (/ (- gScreenHeight 199) 2) 199))
		(= right (+ (/ (- gScreenWidth 329) 2) 329))
		(= priority 5)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local2 0)
		(= local4 0)
		(super init:)
		(proc0_10 690 0 0 0 0 8 self)
	)

	(method (dispose)
		(super dispose:)
		((ScriptID gCardGameScriptNumber 2) doit: local2)
	)
)

(instance klondikeOptions of HoyleGameControls
	(properties)
)

(instance iconAbandon of ControlIcon
	(properties
		noun 5
		modNum 6090
		nsLeft 166
		nsTop 52
		x 166
		y 52
		signal 387
		mainView 690
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(if global748
			(= local2 1)
			(iconOK doit:)
		)
	)
)

(instance iconSameDeck of ControlIcon
	(properties
		noun 7
		modNum 6090
		nsLeft 18
		nsTop 52
		x 18
		y 52
		signal 387
		mainView 690
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(if global748
			(= local2 1)
			(= global265 1)
			(iconOK doit:)
		)
	)
)

(instance iconDifficulty of ControlIcon
	(properties
		noun 11
		modNum 6090
		nsLeft 18
		nsTop 90
		x 18
		y 90
		signal 387
		mainView 690
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(if (== global927 0)
			(= cel 1)
			(UpdateScreenItem self)
			(= cel 2)
			(UpdateScreenItem self)
			(= global927 1)
		else
			(= cel 3)
			(UpdateScreenItem self)
			(= cel 0)
			(UpdateScreenItem self)
			(= global927 0)
		)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 8
		modNum 6090
		nsLeft 18
		nsTop 128
		x 18
		y 128
		signal 387
		mainView 690
		mainLoop 6
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
		noun 9
		modNum 6090
		nsLeft 166
		nsTop 128
		x 166
		y 128
		signal 387
		mainView 690
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(if global187
			(= global187 0)
		)
		(if (or (!= global927 local1) local4)
			(= global917 1)
			(= gNewRoomNum gCurRoomNum)
			(= gCurRoomNum 0)
			(gCurRoom style: 256)
			(gGameControls hide:)
			(= global199 1)
			(proc0_9 (gCast elements:) 0)
		)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(if 1
			(global929 doit: 3)
		)
	)
)

(instance iconSave of ControlIcon
	(properties
		noun 12
		modNum 6090
		nsLeft 18
		nsTop 14
		x 18
		y 14
		priority 150
		signal 387
		mainView 690
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 150)
		(super init: &rest)
	)

	(method (doit)
		(= global114 0)
		(= global187 1)
		(= local3 global186)
		((ScriptID 991 0) init: 975 3 gCurRoomNum 1) ; saveStats
		(if (== gCardGameScriptNumber 6020)
			(if global186
				((ScriptID 991 0) init: 975 3 gCurRoomNum 2) ; saveStats
				(if global186
					((ScriptID 991 0) init: 975 3 gCurRoomNum 3) ; saveStats
					(if global186
						((ScriptID 991 0) init: 975 3 gCurRoomNum 4) ; saveStats
					)
				)
			)
			(= global242 0)
			(= global186 local3)
		)
		(= global187 0)
		(DisposeScript 991)
		(iconOK doit:)
	)
)

(instance iconRestore of ControlIcon
	(properties
		noun 13
		modNum 6090
		nsLeft 166
		nsTop 14
		x 166
		y 14
		priority 150
		signal 387
		mainView 690
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 150)
		(super init: &rest)
	)

	(method (doit)
		(= global114 1)
		(= local3 global186)
		((ScriptID 991 0) init: 975 3 gCurRoomNum 1) ; saveStats
		(if (== gCardGameScriptNumber 6020)
			(if global186
				((ScriptID 991 0) init: 975 3 gCurRoomNum 2) ; saveStats
				(if global186
					((ScriptID 991 0) init: 975 3 gCurRoomNum 3) ; saveStats
					(if global186
						((ScriptID 991 0) init: 975 3 gCurRoomNum 4) ; saveStats
					)
				)
			)
			(= global242 0)
			(= global186 local3)
		)
		(= global114 0)
		(if global115
			(= local4 1)
		)
		(DisposeScript 991)
		(iconOK doit:)
	)
)

