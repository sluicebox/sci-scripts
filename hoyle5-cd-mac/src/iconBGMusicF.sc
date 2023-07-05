;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1115)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Print)
(use IconBar)
(use GameControls)
(use System)

(public
	iconBGMusicF 0
	proc1115_1 1
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc1115_1)
	(= local3 0)
	(IconBarF darken:)
	(localproc_0)
	(IconBarF lighten:)
	(return local3)
)

(procedure (localproc_0)
	(gSong stop:)
	(if global878
		(PlaySong play: (+ 60 global878))
	else
		(PlaySong play: 61)
	)
	(= local0 (DoSound sndMASTER_VOLUME))
	(EnableCursor)
	(= local2 gGameControls)
	(if global921
		((= gGameControls fakeControl)
			plane: fakeControlWindow
			helpIconItem: iconHelpF
			okIconItem: iconOKF
		)
		(if (not global921)
			(gGameControls
				add:
					(volumeSliderF
						theObj: gGame
						selector: #masterVolume
						yourself:
					)
					(iconVolumeHotF
						theObj: iconVolumeHotF
						selector: #doit
						yourself:
					)
					(iconAttitudeHotF
						theObj: iconAttitudeHotF
						selector: #doit
						yourself:
					)
					(iconBGMusicF
						theObj: iconBGMusicF
						selector: #doit
						yourself:
					)
			)
		)
		(gGameControls
			add:
				(playerSpeedSliderF
					theObj: playerSpeedCode
					selector: #doit
					yourself:
				)
				(animationSpeedSliderF
					theObj: animationSpeedCode
					selector: #doit
					yourself:
				)
				(attitudeSliderF
					theObj: attitudeSliderF
					selector: #doit
					yourself:
				)
				(iconResponseHotF
					theObj: iconResponseHotF
					selector: #doit
					yourself:
				)
				(iconPaceHotF theObj: iconPaceHotF selector: #doit yourself:)
		)
		(if (not (or global916 global921))
			(gGameControls
				add:
					(iconNoFrillsF
						theObj: iconNoFrillsF
						selector: #doit
						yourself:
					)
					(iconCharactersF
						theObj: iconCharactersF
						selector: #doit
						yourself:
					)
			)
		)
		(gGameControls
			add:
				(iconReplayF theObj: iconReplayF selector: #doit yourself:)
				(iconTimeF theObj: iconTimeF selector: #doit yourself:)
				(iconHelpF theObj: iconHelpF selector: #doit yourself:)
				(iconOKF theObj: iconOKF selector: #doit yourself:)
				(iconAttitudeF theObj: iconAttitudeF selector: #doit yourself:)
			okIconItem: iconOKF
			curIcon: (if (not (HaveMouse)) iconOKF else 0)
		)
	else
		((= gGameControls fakeControl)
			plane: fakeControlWindow
			helpIconItem: iconHelpF
			okIconItem: iconOKF
			add:
				(volumeSliderF
					theObj: gGame
					selector: #masterVolume
					yourself:
				)
				(playerSpeedSliderF
					theObj: playerSpeedCode
					selector: #doit
					yourself:
				)
				(animationSpeedSliderF
					theObj: animationSpeedCode
					selector: #doit
					yourself:
				)
				(attitudeSliderF
					theObj: attitudeSliderF
					selector: #doit
					yourself:
				)
				(iconVolumeHotF
					theObj: iconVolumeHotF
					selector: #doit
					yourself:
				)
				(iconResponseHotF
					theObj: iconResponseHotF
					selector: #doit
					yourself:
				)
				(iconPaceHotF theObj: iconPaceHotF selector: #doit yourself:)
				(iconAttitudeHotF
					theObj: iconAttitudeHotF
					selector: #doit
					yourself:
				)
		)
		(if (not (or global916 global921))
			(gGameControls
				add:
					(iconNoFrillsF
						theObj: iconNoFrillsF
						selector: #doit
						yourself:
					)
					(iconCharactersF
						theObj: iconCharactersF
						selector: #doit
						yourself:
					)
			)
		)
		(gGameControls
			add:
				(iconBGMusicF theObj: iconBGMusicF selector: #doit yourself:)
				(iconReplayF theObj: iconReplayF selector: #doit yourself:)
				(iconTimeF theObj: iconTimeF selector: #doit yourself:)
				(iconHelpF theObj: iconHelpF selector: #doit yourself:)
				(iconOKF theObj: iconOKF selector: #doit yourself:)
				(iconAttitudeF theObj: iconAttitudeF selector: #doit yourself:)
			okIconItem: iconOKF
			curIcon: (if (not (HaveMouse)) iconOKF else 0)
		)
	)
	(gGameControls show:)
	(= gGameControls local2)
)

(procedure (localproc_1 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (localproc_2 param1)
	(return (>> param1 $000c))
)

(procedure (localproc_3 param1)
	(return (& (>> param1 $0006) $003f))
)

(procedure (localproc_4 param1)
	(return (+ 80 (>> param1 $0009)))
)

(procedure (localproc_5 param1)
	(return (& (>> param1 $0005) $000f))
)

(procedure (localproc_6 param1)
	(return (& param1 $001f))
)

(procedure (localproc_7 param1 param2)
	(if param2
		(param1 signal: (& (param1 signal:) $fffb))
	else
		(param1 signal: (| (param1 signal:) $0004))
	)
	(param1 show:)
	(UpdateScreenItem param1)
)

(instance fakeControlWindow of InvisibleWindow
	(properties
		left 100
		top 100
		right 500
		bottom 400
	)

	(method (init &tmp temp0)
		(= top 52)
		(= left 160)
		(= bottom 400)
		(= right 500)
		(if global921
			(= left 130)
			(= top 111)
			(= bottom 459)
		)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= priority 5)
		(super init:)
		(proc0_10 901 0 0 0 0 5 fakeControlWindow)
	)
)

(instance fakeControl of HoyleGameControls
	(properties)
)

(instance volumeSliderF of ControlIcon
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
			(self y: (localproc_1 51 temp1 167))
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

(instance iconBGMusicF of ControlIcon
	(properties
		noun 12
		modNum 14
		nsLeft 212
		nsTop 95
		x 212
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

(instance playerSpeedSliderF of ControlIcon
	(properties
		noun 13
		modNum 14
		nsLeft 157
		nsTop 51
		x 157
		y 51
		signal 128
		mainView 901
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(= temp0 8)
		(self setPri: 255)
		(= y (+ (* global899 temp0) 51))
		(if (== global899 1)
			(self y: 51)
		)
		(self y: (localproc_1 51 (self y:) 167))
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
			(self y: (localproc_1 51 temp1 167))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(= global899 (+ 1 (/ (- (self y:) 51) temp3)))
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

(instance animationSpeedSliderF of ControlIcon
	(properties
		noun 8
		modNum 14
		nsLeft 102
		nsTop 51
		x 102
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
		(self y: (localproc_1 51 (self y:) 167))
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
			(self y: (localproc_1 51 temp1 167))
			(if (!= temp2 (self y:))
				(= temp2 (self y:))
				(= global898 (/ (- (self y:) 51) temp3))
				(self y: (localproc_1 51 (self y:) 167))
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

(instance attitudeSliderF of ControlIcon
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
			(self x: (localproc_1 16 temp1 186))
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

(class iconNoFrillsF of ControlIcon
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
		maskLoop 9
		maskCel 1
		highlightColor -1
		helpVerb 4
		status 0
	)

	(method (init)
		(super init: &rest)
		(if (or (== gAttitudeSetting 0) global916)
			(localproc_7 iconNoFrillsF 0)
		else
			(localproc_7 iconNoFrillsF 1)
		)
	)

	(method (doit)
		(if gAttitudeSetting
			(= gAttitudeSetting 0)
			(localproc_7 attitudeSliderF 0)
			(localproc_7 iconAttitudeF 0)
			(localproc_7 iconNoFrillsF 0)
			(localproc_7 iconCharactersF 1)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
			(cond
				(
					(or
						(== gCardGameScriptNumber 1300)
						(== gCardGameScriptNumber 400)
						(== gCardGameScriptNumber 500)
						(== gCardGameScriptNumber 1200)
					)
					(gChar1 setLoop: 4)
					(UpdateScreenItem gChar1)
				)
				((!= gCardGameScriptNumber 600)
					(gChar1 setLoop: 4)
					(gChar2 setLoop: 4)
					(gChar3 setLoop: 4)
					(UpdateScreenItem gChar1)
					(UpdateScreenItem gChar2)
					(UpdateScreenItem gChar3)
				)
			)
			(FrameOut)
		)
	)
)

(class iconCharactersF of ControlIcon
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
		maskLoop 8
		maskCel 1
		highlightColor -1
		helpVerb 4
		status 0
	)

	(method (init)
		(super init: &rest)
		(if (or global916 (!= gAttitudeSetting 0))
			(localproc_7 iconCharactersF 0)
		else
			(localproc_7 iconCharactersF 1)
		)
	)

	(method (doit)
		(if (== gAttitudeSetting 0)
			(= gAttitudeSetting 1)
			(attitudeSliderF x: 16)
			(localproc_7 iconAttitudeF 1)
			(localproc_7 attitudeSliderF 1)
			(localproc_7 iconCharactersF 0)
			(localproc_7 iconNoFrillsF 1)
			(if (!= gCardGameScriptNumber 600)
				(gChar1 setLoop: 0)
				(UpdateScreenItem gChar1)
				(if (gChar2 active:)
					(gChar2 setLoop: 0)
					(gChar3 setLoop: 1)
					(UpdateScreenItem gChar2)
					(UpdateScreenItem gChar3)
				)
				(FrameOut)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconRestartF of ControlIcon ; UNUSED
	(properties
		noun 7
		modNum 14
		nsLeft 212
		nsTop 8
		x 212
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
		(PlaySong play: 0)
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
				(gGame_opt doit: 3)
				(gGameControls hide:)
			)
			(else
				((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
				(DisposeScript 930)
				(if global748
					(EnableCursor)
					(= gNewRoomNum 975) ; chooseGame
					(= global107 1)
					(gGame_opt doit: 3)
					(gGameControls hide:)
				)
			)
		)
	)
)

(instance iconQuitF of ControlIcon ; UNUSED
	(properties
		noun 6
		modNum 14
		nsLeft 212
		nsTop 95
		x 212
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
			(gGame_opt doit: 3)
		)
	)
)

(instance iconAttitudeF of ControlIcon
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
			(localproc_7 iconAttitudeF 0)
		else
			(localproc_7 attitudeSliderF 1)
			(localproc_7 iconAttitudeF 1)
		)
	)
)

(instance iconReplayF of ControlIcon
	(properties
		noun 5
		modNum 14
		nsLeft 212
		nsTop 37
		x 212
		y 37
		signal 387
		mainView 901
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 21])
		(PlaySong play: 0)
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
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom style: 256)
				(gGameControls hide:)
				(= global199 1)
				(proc0_9 (gCast elements:) 0)
				(gGame_opt doit: 3)
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

(instance iconTimeF of ControlIcon
	(properties
		noun 4
		modNum 14
		nsLeft 212
		nsTop 66
		x 212
		y 66
		signal 387
		mainView 901
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp5 (GetTime 1)) ; SysTime12
		(= temp6 (GetTime 3)) ; SysDate
		(= temp0 (localproc_2 temp5))
		(= temp1 (localproc_3 temp5))
		(for ((= temp2 (localproc_4 temp6))) (> temp2 99) ((-= temp2 100))
		)
		(= temp3 (localproc_5 temp6))
		(= temp4 (localproc_6 temp6))
		((ScriptID 911 0) init: temp0 temp1 temp3 temp4 temp2) ; MISSING SCRIPT
		(DisposeScript 911)
	)
)

(instance iconHelpF of ControlIcon
	(properties
		noun 2
		modNum 14
		nsLeft 212
		nsTop 124
		x 212
		y 124
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
			(= y (= nsTop 95))
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOKF of ControlIcon
	(properties
		noun 1
		modNum 14
		nsLeft 212
		nsTop 153
		x 212
		y 153
		signal 387
		mainView 901
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(= y (= nsTop 124))
		)
		(super init: &rest)
	)

	(method (doit)
		(gGameControls hide:)
		(cond
			((== gAttitudeSetting 0)
				(cond
					(
						(or
							(== gCardGameScriptNumber 1300)
							(== gCardGameScriptNumber 400)
							(== gCardGameScriptNumber 500)
							(== gCardGameScriptNumber 1200)
						)
						(gChar1 setLoop: 4)
					)
					((!= gCardGameScriptNumber 600)
						(gChar1 setLoop: 4)
						(gChar2 setLoop: 4)
						(gChar3 setLoop: 4)
					)
				)
			)
			((!= gCardGameScriptNumber 600)
				(gChar1 setLoop: 0)
				(if (gChar2 active:)
					(gChar2 setLoop: 0)
					(gChar3 setLoop: 1)
				)
			)
		)
		(gGame_opt doit: 3)
		(= local3 1)
		(PlaySong play: 0)
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

(instance iconVolumeHotF of ControlIcon
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

(instance iconPaceHotF of ControlIcon
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

(instance iconResponseHotF of ControlIcon
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

(instance iconAttitudeHotF of ControlIcon
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

