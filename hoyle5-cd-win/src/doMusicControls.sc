;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use GameControls)
(use System)

(public
	doMusicControls 0
)

(local
	local0
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls musicControls)
		plane: musicWindow
		helpIconItem: 0
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconMusic theObj: iconMusic setPri: 30 selector: #doit yourself:)
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 914)
)

(instance doMusicControls of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance musicWindow of InvisibleWindow
	(properties)

	(method (init)
		(= top (/ (- gScreenHeight 163) 2))
		(= left (/ (- gScreenWidth 266) 2))
		(= bottom (+ (/ (- gScreenHeight 163) 2) 163))
		(= right (+ (/ (- gScreenWidth 266) 2) 266))
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 914 0 0 0 0 0 self)
	)
)

(instance musicControls of HoyleGameControls
	(properties)
)

(instance iconMusic of ControlIcon
	(properties
		noun 3
		modNum 914
		nsLeft 20
		nsTop 17
		x 20
		y 17
		signal 387
		mainView 914
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global121
			(1
				(= mainLoop 1)
			)
			(2
				(= mainLoop 2)
			)
			(3
				(= mainLoop 3)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global121
			(1
				(= global121 (= mainLoop 2))
				(gSong mute: 0)
			)
			(2
				(= global121 (= mainLoop 3))
				(gSong mute: 1)
			)
			(3
				(= global121 (= mainLoop 1))
				(gSong mute: 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 2
		modNum 914
		nsLeft 20
		nsTop 101
		x 20
		y 101
		signal 387
		mainView 914
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
	)
)

