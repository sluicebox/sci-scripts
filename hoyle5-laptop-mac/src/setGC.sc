;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Print)
(use GameControls)
(use System)

(public
	setGC 0
	iconBGMusic 1
)

(local
	local0
	local1
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
				(playerSpeedSlider
					theObj: playerSpeedCode
					selector: #doit
					yourself:
				)
				(iconResponseHot
					theObj: iconResponseHot
					selector: #doit
					yourself:
				)
				(iconPaceHot theObj: iconPaceHot selector: #doit yourself:)
				(attitudeSlider
					theObj: attitudeSlider
					selector: #doit
					yourself:
				)
				(iconAttitudeHot
					theObj: iconAttitudeHot
					selector: #doit
					yourself:
				)
				(iconNoFrills theObj: iconNoFrills selector: #doit yourself:)
				(iconCharacters
					theObj: iconCharacters
					selector: #doit
					yourself:
				)
				(iconBGMusic theObj: iconBGMusic selector: #doit yourself:)
				(iconReplay theObj: iconReplay selector: #doit yourself:)
				(iconTime theObj: iconTime selector: #doit yourself:)
				(iconHelp theObj: iconHelp selector: #doit yourself:)
				(iconOK theObj: iconOK selector: #doit yourself:)
				(iconAttitude theObj: iconAttitude selector: #doit yourself:)
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
					(iconAttitudeHot
						theObj: iconAttitudeHot
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
				(playerSpeedSlider
					theObj: playerSpeedCode
					selector: #doit
					yourself:
				)
				(iconResponseHot
					theObj: iconResponseHot
					selector: #doit
					yourself:
				)
				(iconPaceHot theObj: iconPaceHot selector: #doit yourself:)
				(attitudeSlider
					theObj: attitudeSlider
					selector: #doit
					yourself:
				)
				(iconNoFrills theObj: iconNoFrills selector: #doit yourself:)
				(iconCharacters
					theObj: iconCharacters
					selector: #doit
					yourself:
				)
				(iconReplay theObj: iconReplay selector: #doit yourself:)
				(iconTime theObj: iconTime selector: #doit yourself:)
				(iconHelp theObj: iconHelp selector: #doit yourself:)
				(iconOK theObj: iconOK selector: #doit yourself:)
				(iconAttitude theObj: iconAttitude selector: #doit yourself:)
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

(procedure (localproc_3 param1)
	(return (>> param1 $000c))
)

(procedure (localproc_4 param1)
	(return (& (>> param1 $0006) $003f))
)

(procedure (localproc_5 param1)
	(return (+ 80 (>> param1 $0009)))
)

(procedure (localproc_6 param1)
	(return (& (>> param1 $0005) $000f))
)

(procedure (localproc_7 param1)
	(return (& param1 $001f))
)

(procedure (localproc_8 param1 param2)
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
		nsLeft 47
		nsTop 51
		x 47
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
				(gSong setVol: (* 16 (gGame masterVolume:)))
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
		nsLeft 215
		nsTop 95
		x 215
		y 95
		signal 387
		mainView 901
		mainLoop 4
		maskView 901
		maskLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(= signal 4)
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
				(if global878
					(PlaySong play: (+ 60 global878))
				else
					(PlaySong play: 61)
				)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance playerSpeedSlider of ControlIcon
	(properties
		noun 13
		modNum 14
		nsLeft 158
		nsTop 53
		x 158
		y 53
		signal 128
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(= temp0 8)
		(self setPri: 255)
		(= y (+ (* global899 temp0) 53))
		(if (== global899 1)
			(self y: 53)
		)
		(self y: (localproc_2 53 (self y:) 167))
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 8)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_2 53 temp1 167))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(= global899 (+ 1 (/ (- (self y:) 53) temp3)))
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

(instance animationSpeedSlider of ControlIcon
	(properties
		noun 8
		modNum 14
		nsLeft 102
		nsTop 53
		x 102
		y 53
		signal 128
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(= temp0 7)
		(self setPri: 255)
		(self y: (+ (* global898 temp0) 53))
		(if (> global898 15)
			(self y: 167)
		)
		(self y: (localproc_2 53 (self y:) 167))
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
			(self y: (localproc_2 53 temp1 167))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(= global898 (/ (- (self y:) 53) temp3))
				(self y: (localproc_2 53 (self y:) 167))
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

(instance attitudeSlider of ControlIcon
	(properties
		noun 14
		modNum 14
		nsLeft 16
		nsTop 220
		x 16
		y 220
		signal 128
		mainView 901
		mainLoop 7
		maskView 901
		maskLoop 11
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 255)
		(switch gAttitudeSetting
			(0
				(self signal: (| (self signal:) $0004))
			)
			(1
				(= x 16)
			)
			(2
				(= x 101)
			)
			(3
				(= x 186)
			)
		)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 58)
		(= temp4 143)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 x:))
			(self x: (localproc_2 16 temp1 186))
			(if (!= temp2 (self x:))
				(= temp2 (self x:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(cond
					((<= x temp3)
						(self x: 16)
						(= gAttitudeSetting 1)
					)
					(
						(or
							(and (> x temp3) (< x 101))
							(and (>= x 101) (< x temp4))
						)
						(self x: 101)
						(= gAttitudeSetting 2)
					)
					((and (>= x temp4) (<= x 186))
						(self x: 186)
						(= gAttitudeSetting 3)
					)
				)
				(UpdateScreenItem self)
				(FrameOut)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(class iconNoFrills of ControlIcon
	(properties
		noun 16
		modNum 14
		nsLeft 260
		nsTop 204
		x 260
		y 204
		signal 387
		mainView 901
		mainLoop 9
		maskView 901
		maskLoop 11
		highlightColor -1
		helpVerb 4
		status 0
	)

	(method (init)
		(super init: &rest)
		(if (or global916 (== gCardGameScriptNumber 200) global921)
			(localproc_8 iconNoFrills 0)
		else
			(if (== gAttitudeSetting 0)
				(= mainCel 1)
			else
				(= mainCel 0)
			)
			(localproc_8 iconNoFrills 1)
		)
	)

	(method (doit)
		(if (!= gCardGameScriptNumber 600)
			(gChar1 setLoop: 4)
			(UpdateScreenItem gChar1)
			(if
				(or
					(== gCardGameScriptNumber 700)
					(== gCardGameScriptNumber 1100)
					(== gCardGameScriptNumber 300)
					(== gCardGameScriptNumber 100)
				)
				(gChar2 setLoop: 4)
				(UpdateScreenItem gChar2)
				(gChar3 setLoop: 4)
				(UpdateScreenItem gChar3)
			)
		)
		(cond
			((== gCardGameScriptNumber 200)
				(Print ticks: 400 fore: 0 mode: 1 addBitmap: 916 0 0 init:)
			)
			(gAttitudeSetting
				(= gAttitudeSetting 0)
				(localproc_8 attitudeSlider 0)
				(localproc_8 iconAttitude 0)
				(= mainCel 1)
				(iconCharacters setCel: 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)

	(method (setCel param1)
		(= mainCel param1)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(class iconCharacters of ControlIcon
	(properties
		noun 15
		modNum 14
		nsLeft 217
		nsTop 204
		x 217
		y 204
		signal 387
		mainView 901
		mainLoop 8
		maskView 901
		maskLoop 11
		highlightColor -1
		helpVerb 4
		status 0
	)

	(method (init)
		(super init: &rest)
		(if (or global916 global921)
			(localproc_8 iconCharacters 0)
		else
			(if gAttitudeSetting
				(= mainCel 1)
			else
				(= mainCel 0)
			)
			(localproc_8 iconCharacters 1)
		)
	)

	(method (doit)
		(if (!= gCardGameScriptNumber 600)
			(gChar1 setLoop: 0)
			(UpdateScreenItem gChar1)
		)
		(if
			(or
				(== gCardGameScriptNumber 700)
				(== gCardGameScriptNumber 1100)
				(== gCardGameScriptNumber 300)
				(== gCardGameScriptNumber 100)
			)
			(gChar2 setLoop: 0)
			(UpdateScreenItem gChar2)
			(gChar3 setLoop: 1)
			(UpdateScreenItem gChar3)
		)
		(if (== gAttitudeSetting 0)
			(= gAttitudeSetting 1)
			(attitudeSlider x: 16)
			(localproc_8 iconAttitude 1)
			(localproc_8 attitudeSlider 1)
			(= mainCel 1)
			(iconNoFrills setCel: 0)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)

	(method (setCel param1)
		(= mainCel param1)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconRestart of ControlIcon ; UNUSED
	(properties
		noun 7
		modNum 14
		nsLeft 215
		nsTop 8
		x 215
		y 8
		priority 150
		signal 387
		mainView 901
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(self setPri: 150)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 21])
		(= global917 1)
		(cond
			((== gCurRoomNum 975) ; chooseGame
				(Print
					addText: {You pressed the reset buttom in Choose Room}
					init:
				)
			)
			(
				(or
					(== gCurRoomNum 3) ; selectPlayers
					(== gCurRoomNum 2) ; intro
					(== gCurRoomNum 21)
					(== gCurRoomNum 19) ; credits
				)
				(= gNewRoomNum 975) ; chooseGame
				(= global107 1)
				(localproc_0)
				(gGameControls hide:)
			)
			(else
				((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
				(DisposeScript 930)
				(if global748
					(EnableCursor)
					(= gNewRoomNum 975) ; chooseGame
					(= global107 1)
					(localproc_0)
					(gGameControls hide:)
				)
			)
		)
	)
)

(instance iconQuit of ControlIcon ; UNUSED
	(properties
		noun 6
		modNum 14
		nsLeft 215
		nsTop 95
		x 215
		y 95
		signal 387
		mainView 901
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(= global917 1)
		((ScriptID 930 0) init: 913 0 900) ; yesNo
		(DisposeScript 930)
		(if global748
			(gGame quitGame:)
			(gGameControls hide:)
			(proc0_8 0)
			(localproc_0)
		)
	)
)

(instance iconAttitude of ControlIcon
	(properties
		modNum 14
		signal 387
		mainView 901
		mainLoop 10
		maskView 901
		maskLoop 11
	)

	(method (init)
		(self setPri: 16)
		(super init: &rest)
		(if (== gAttitudeSetting 0)
			(localproc_8 iconAttitude 0)
		else
			(localproc_8 attitudeSlider 1)
			(localproc_8 iconAttitude 1)
		)
	)
)

(instance iconReplay of ControlIcon
	(properties
		noun 5
		modNum 14
		nsLeft 215
		nsTop 40
		x 215
		y 40
		signal 387
		mainView 901
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 21])
		(= global917 1)
		(if
			(or
				(== gCurRoomNum 100) ; crazy8s
				(== gCurRoomNum 200) ; oldMaid
				(== gCurRoomNum 300) ; heartsGame
				(== gCurRoomNum 400) ; ginRummy
				(== gCurRoomNum 500) ; cribbage
				(== gCurRoomNum 600) ; klondike
				(== gCurRoomNum 700) ; bridge
				(== gCurRoomNum 1100) ; pokerRoom
				(== gCurRoomNum 1300) ; backgam
				(== gCurRoomNum 1200) ; checkers
			)
			((ScriptID 930 0) init: 913 1 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(if
					(and
						(== gAttitudeSetting 0)
						(or
							(== gCardGameScriptNumber 1300)
							(== gCardGameScriptNumber 400)
							(== gCardGameScriptNumber 500)
							(== gCardGameScriptNumber 1200)
						)
					)
					(gChar1 setLoop: 4)
				)
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: 256)
				(gGameControls hide:)
				(= global199 1)
				(proc0_9 (gCast elements:) 0)
				(localproc_0)
			)
		else
			(Print
				addText:
					{you pressed the replay buttom and there is no game to replay}
				init:
			)
		)
	)
)

(instance iconTime of ControlIcon
	(properties
		noun 4
		modNum 14
		nsLeft 215
		nsTop 71
		x 215
		y 71
		signal 387
		mainView 901
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp5 (GetTime 1)) ; SysTime12
		(= temp6 (GetTime 3)) ; SysDate
		(= temp0 (localproc_3 temp5))
		(= temp1 (localproc_4 temp5))
		(for ((= temp2 (localproc_5 temp6))) (> temp2 99) ((-= temp2 100))
		)
		(= temp3 (localproc_6 temp6))
		(= temp4 (localproc_7 temp6))
		((ScriptID 911 0) init: temp0 temp1 temp3 temp4 temp2) ; giveTimeCode
		(DisposeScript 911)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 2
		modNum 14
		nsLeft 215
		nsTop 101
		x 215
		y 101
		signal 387
		message 0
		mainView 901
		mainLoop 5
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (init)
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
		nsLeft 215
		nsTop 131
		x 215
		y 131
		signal 387
		mainView 901
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
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

(instance playerSpeedCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global899 param1)
			else
				global899
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
		mainLoop 12
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
		mainLoop 12
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconResponseHot of ControlIcon
	(properties
		noun 13
		modNum 14
		nsLeft 130
		nsTop 19
		x 130
		y 19
		signal 387
		mainView 901
		mainLoop 12
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconAttitudeHot of ControlIcon
	(properties
		noun 14
		modNum 14
		nsLeft 7
		nsTop 187
		x 7
		y 187
		signal 387
		mainView 901
		mainLoop 12
		mainCel 1
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

