;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use GameControls)
(use System)

(public
	setGC 0
	iconBGMusic 1
)

(local
	local0
	[local1 2]
	local3
	local4
)

(procedure (localproc_0)
	(gGame_opt doit: 3)
)

(procedure (localproc_1)
	(= local0 (DoSound sndMASTER_VOLUME))
	(if (not global921)
		(gGameControls
			plane: gGcWindow
			helpIconItem: iconHelp
			okIconItem: iconOK
			add:
				(volumeSlider theObj: gGame selector: #masterVolume yourself:)
				(iconVolumeHot theObj: iconVolumeHot selector: #doit yourself:)
				(animationSpeedSlider
					theObj: animationSpeedCode
					selector: #doit
					yourself:
				)
				(iconMagn theObj: iconMagn selector: #doit yourself:)
				(iconPaceHot theObj: iconPaceHot selector: #doit yourself:)
				(iconBGMusic theObj: iconBGMusic selector: #doit yourself:)
				(iconHelp theObj: iconHelp selector: #doit yourself:)
				(iconOK theObj: iconOK selector: #doit yourself:)
				(iconTutorial theObj: iconTutorial selector: #doit yourself:)
				(iconTimedGame theObj: iconTimedGame selector: #doit yourself:)
			okIconItem: iconOK
			curIcon: (if (not (HaveMouse)) iconOK else 0)
		)
	else
		(gGameControls plane: gGcWindow helpIconItem: iconHelp okIconItem: iconOK)
		(if (not global921)
			(gGameControls
				add:
					(volumeSlider
						theObj: gGame
						selector: #masterVolume
						yourself:
					)
					(iconVolumeHot
						theObj: iconVolumeHot
						selector: #doit
						yourself:
					)
					(iconBGMusic theObj: iconBGMusic selector: #doit yourself:)
			)
		)
		(gGameControls
			add:
				(animationSpeedSlider
					theObj: animationSpeedCode
					selector: #doit
					yourself:
				)
				(iconPaceHot theObj: iconPaceHot selector: #doit yourself:)
				(iconHelp theObj: iconHelp selector: #doit yourself:)
				(iconOK theObj: iconOK selector: #doit yourself:)
			okIconItem: iconOK
			curIcon: (if (not (HaveMouse)) iconOK else 0)
		)
	)
)

(procedure (localproc_2 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (localproc_3 param1 param2) ; UNUSED
	(if param2
		(param1 signal: (& (param1 signal:) $fffb))
	else
		(param1 signal: (| (param1 signal:) $0004))
	)
	(param1 show:)
	(UpdateScreenItem param1)
)

(instance setGC of Code
	(properties)

	(method (doit)
		(localproc_1)
	)
)

(instance volumeSlider of ControlIcon
	(properties
		noun 10
		modNum 14
		nsLeft 53
		nsTop 51
		x 53
		y 51
		signal 128
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(self setPri: 255)
		(= temp0 14)
		(= y (+ (* (- 8 (gGame masterVolume:)) temp0) 51))
		(if (> (gGame masterVolume:) 7)
			(= y 51)
		)
		(if (< (gGame masterVolume:) 1)
			(= y 167)
		)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 14)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(self y: (+ (* (- 8 (gGame masterVolume:)) temp3) 51))
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 51 temp1 167))
			(if (!= temp2 (self y:))
				(gGame masterVolume: (- 8 (/ (- (self y:) 51) temp3)))
				(gSong setVol: (* 12 (gGame masterVolume:)))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance iconBGMusic of ControlIcon
	(properties
		noun 12
		modNum 14
		nsLeft 181
		nsTop 46
		x 181
		y 46
		signal 387
		mainView 901
		mainLoop 4
		maskView 901
		maskLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global527
			(= mainCel 3)
		else
			(switch global919
				(1
					(= mainCel 0)
				)
				(0
					(= mainCel 2)
				)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (not global527)
			(switch global919
				(1
					(= mainCel 2)
					(= global919 0)
					(PlaySong play: 0)
					(gSong mute: 1)
				)
				(0
					(= mainCel 0)
					(= global919 1)
					(gSong mute: 0)
					(if (> 38 global878 30)
						(PlaySong play: (+ 50 global878))
					)
				)
			)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
		)
	)
)

(instance iconTutorial of ControlIcon
	(properties
		noun 19
		modNum 14
		nsLeft 181
		nsTop 75
		x 181
		y 75
		signal 387
		mainView 901
		mainLoop 3
		maskView 901
		maskLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global222
			(1
				(= mainCel 0)
			)
			(0
				(= mainCel 2)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global222
			(1
				(= mainCel 2)
				(= global222 0)
			)
			(0
				(= mainCel 0)
				(= global222 1)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconTimedGame of ControlIcon
	(properties
		noun 21
		modNum 14
		nsLeft 181
		nsTop 104
		x 181
		y 104
		signal 387
		mainView 901
		mainLoop 2
		maskView 901
		maskLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if
			(or
				(== gCardGameScriptNumber 6020)
				(== gCardGameScriptNumber 6028)
				(== gCardGameScriptNumber 6027)
				(== gCardGameScriptNumber 6019)
			)
			(= mainCel 3)
		else
			(switch global250
				(1
					(= mainCel 0)
				)
				(0
					(= mainCel 2)
				)
			)
		)
		(= local4 global250)
		(super init: &rest)
	)

	(method (doit)
		(if
			(and
				(!= gCardGameScriptNumber 6020)
				(!= gCardGameScriptNumber 6028)
				(!= gCardGameScriptNumber 6027)
				(!= gCardGameScriptNumber 6019)
			)
			(switch global250
				(1
					(= mainCel 2)
					(= global250 0)
				)
				(0
					(= mainCel 0)
					(= global250 1)
				)
			)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
		)
	)
)

(instance animationSpeedSlider of ControlIcon
	(properties
		noun 8
		modNum 14
		nsLeft 123
		nsTop 51
		x 123
		y 51
		signal 128
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(= temp0 7)
		(self setPri: 255)
		(self y: (+ (* global898 temp0) 51))
		(if (> global898 15)
			(self y: 167)
		)
		(self y: (localproc_2 51 (self y:) 167))
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 7)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 51 temp1 167))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(= global898 (/ (- (self y:) 51) temp3))
				(self y: (localproc_2 51 (self y:) 167))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 2
		modNum 14
		nsLeft 181
		nsTop 133
		x 181
		y 133
		signal 387
		message 0
		mainView 901
		mainLoop 5
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(= y (= nsTop 46))
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 1
		modNum 14
		nsLeft 181
		nsTop 162
		x 181
		y 162
		signal 387
		mainView 901
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(= y (= nsTop 133))
		)
		(super init: &rest)
	)

	(method (doit)
		(= local3 1)
		(if (!= local4 global250)
			(= global917 1)
			(= global459 1)
			(if (and local3 (!= local4 global250))
				(= global748 1)
			else
				((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			)
			(= global459 0)
			(DisposeScript 930)
			(if global748
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: 256)
				(gGameControls hide:)
				(= global199 1)
				(proc0_9 (gCast elements:) 0)
				(localproc_0)
			)
		)
		(gGameControls hide:)
		(localproc_0)
	)
)

(instance animationSpeedCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global898 param1)
			else
				global898
			)
		)
	)
)

(instance iconVolumeHot of ControlIcon
	(properties
		noun 10
		modNum 14
		nsLeft 27
		nsTop 19
		x 27
		y 19
		signal 387
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconPaceHot of ControlIcon
	(properties
		noun 8
		modNum 14
		nsLeft 84
		nsTop 19
		x 84
		y 19
		signal 387
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconMagn of ControlIcon
	(properties
		noun 25
		modNum 14
		nsLeft 181
		nsTop 17
		x 181
		y 17
		signal 387
		mainView 901
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if (not global109)
			(iconMagn mainCel: 0)
		else
			(iconMagn mainCel: 2)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (not global109)
			(= cel 1)
			(UpdateScreenItem self)
			(= cel 2)
			(UpdateScreenItem self)
			(= global109 1)
		else
			(= cel 3)
			(UpdateScreenItem self)
			(= cel 0)
			(UpdateScreenItem self)
			(= global109 0)
		)
	)
)

