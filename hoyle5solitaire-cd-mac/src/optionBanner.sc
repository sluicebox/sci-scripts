;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6096)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use Motion)
(use Actor)
(use System)

(public
	optionBanner 0
	sBannerOut 1
	aBanner 2
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls toFlickOptions)
		plane: enterWindow
		helpIconItem: 0
		okIconItem: 0
		add:
			(backButton theObj: backButton selector: #doit yourself:)
			(chanceButton theObj: chanceButton selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance aBanner of Actor
	(properties
		view 994
	)

	(method (init)
		(gSong stop:)
		(self setPri: 250 setCel: 0 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance sBannerOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(aBanner setCycle: End self)
			)
			(2
				(EnableCursor)
				(if (not global527)
					(if (!= global221 28)
						(optionBanner init:)
						(self dispose:)
					else
						(DisableCursor)
						(= seconds 4)
					)
				else
					(= global524 1)
					(= seconds 4)
				)
			)
			(3
				(if (not global527)
					(gCurRoom newRoom: 6029) ; cardflick
				else
					(aBanner hide: dispose:)
					((ScriptID gCardGameScriptNumber 3) changeState: 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance optionBanner of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance toFlickOptions of HoyleGameControls
	(properties)
)

(instance enterWindow of InvisibleWindow
	(properties)

	(method (init &tmp [temp0 2])
		(self
			top: (/ (- gScreenHeight 125) 2)
			left: (/ (- gScreenWidth 190) 2)
			bottom: (+ (/ (- gScreenHeight 125) 2) 125)
			right: (+ (/ (- gScreenWidth 190) 2) 190)
		)
		(= priority 250)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 661 6 0 0 0 5 self)
	)
)

(instance chanceButton of ControlIcon
	(properties
		nsLeft 40
		nsTop 23
		x 40
		y 23
		signal 387
		mainView 661
		mainLoop 5
		highlightColor -1
	)

	(method (doit)
		(gSong stop:)
		(= global524 0)
		(aBanner hide: dispose:)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(gCurRoom newRoom: 6029) ; cardflick
	)
)

(instance backButton of ControlIcon
	(properties
		nsLeft 40
		nsTop 73
		x 40
		y 73
		signal 387
		mainView 661
		mainLoop 4
		highlightColor -1
	)

	(method (doit)
		(= global524 1)
		(aBanner hide: dispose:)
		(if global878
			(PlaySong play: (+ 50 global878))
			(gSong setLoop: -1)
		)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		((ScriptID gCardGameScriptNumber 3) changeState: 3)
	)
)

