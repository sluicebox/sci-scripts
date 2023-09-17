;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 991)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Str)
(use GameControls)
(use File)
(use System)

(public
	saveStats 0
)

(local
	local0
	local1 = 970
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(if (== gCardGameScriptNumber 6020)
		(= global930 bowling_sav)
	else
		(= global930 calculat_sav)
	)
	(if (not global114)
		(iconClearBestScore mainView: 970)
	)
	(if (== gCardGameScriptNumber 6020)
		(iconOne mainView: 979)
		(iconTwo mainView: 979)
		(iconThree mainView: 979)
		(iconFour mainView: 979)
		(iconOK mainView: 979)
		(if (not global114)
			(iconClearOne mainView: 979)
			(iconClearTwo mainView: 979)
			(iconClearThree mainView: 979)
			(iconClearFour mainView: 979)
		)
	else
		(iconOne mainView: 970)
		(iconTwo mainView: 970)
		(iconThree mainView: 970)
		(iconFour mainView: 970)
		(iconOK mainView: 970)
		(if (not global114)
			(iconClearOne mainView: 970)
			(iconClearTwo mainView: 970)
			(iconClearThree mainView: 970)
			(iconClearFour mainView: 970)
		)
	)
	(if (not global114)
		((= gGameControls playersControls)
			plane: gamesWindow
			helpIconItem: iconHelp
			okIconItem: 0
			curIcon: 0
			add:
				(iconOne
					theObj: iconOne
					selector: #doit
					x: 10
					y: 50
					noun: 1
					mainCel: 0
					yourself:
				)
				(iconTwo
					theObj: iconTwo
					selector: #doit
					x: 10
					y: 83
					noun: 1
					mainCel: 0
					yourself:
				)
				(iconThree
					theObj: iconThree
					selector: #doit
					x: 10
					y: 116
					noun: 1
					mainCel: 0
					yourself:
				)
				(iconFour
					theObj: iconFour
					selector: #doit
					x: 10
					y: 149
					noun: 1
					mainCel: 0
					yourself:
				)
				(iconOK
					theObj: iconOK
					selector: #doit
					x: 10
					y: 184
					mainCel: 0
					yourself:
				)
				(iconClearOne
					theObj: iconClearOne
					selector: #doit
					x: 88
					y: 50
					mainCel: 0
					yourself:
				)
				(iconClearTwo
					theObj: iconClearTwo
					selector: #doit
					x: 88
					y: 83
					mainCel: 0
					yourself:
				)
				(iconClearThree
					theObj: iconClearThree
					selector: #doit
					x: 88
					y: 116
					mainCel: 0
					yourself:
				)
				(iconClearFour
					theObj: iconClearFour
					selector: #doit
					x: 88
					y: 149
					mainCel: 0
					yourself:
				)
				iconHelp
				(iconClearBestScore
					theObj: iconClearBestScore
					selector: #doit
					x: 164
					y: 220
					mainCel: 0
					yourself:
				)
		)
	else
		((= gGameControls playersControls)
			plane: gamesWindow
			helpIconItem: iconHelp
			okIconItem: 0
			curIcon: 0
			add:
				(iconOne
					theObj: iconOne
					selector: #doit
					x: 45
					y: 50
					noun: 6
					mainCel: 0
					yourself:
				)
				(iconTwo
					theObj: iconTwo
					selector: #doit
					x: 45
					y: 83
					noun: 6
					mainCel: 0
					yourself:
				)
				(iconThree
					theObj: iconThree
					selector: #doit
					x: 45
					y: 116
					noun: 6
					mainCel: 0
					yourself:
				)
				(iconFour
					theObj: iconFour
					selector: #doit
					x: 45
					y: 149
					noun: 6
					mainCel: 0
					yourself:
				)
				(iconOK
					theObj: iconOK
					selector: #doit
					x: 10
					y: 184
					mainCel: 0
					yourself:
				)
				iconHelp
		)
	)
	(gGameControls show:)
)

(procedure (localproc_1)
	(switch gCardGameScriptNumber
		(6001
			(= local4 {calculat.sav})
		)
		(6002
			(= local4 {strategy.sav})
		)
		(6003
			(= local4 {eagle.sav})
		)
		(6004
			(= local4 {belcastl.sav})
		)
		(6005
			(= local4 {klondike.sav})
		)
		(6006
			(= local4 {canfield.sav})
		)
		(6007
			(= local4 {golf.sav})
		)
		(6008
			(= local4 {flower.sav})
		)
		(6009
			(= local4 {scorpion.sav})
		)
		(6010
			(= local4 {spider.sav})
		)
		(6011
			(= local4 {labelle.sav})
		)
		(6012
			(= local4 {fortress.sav})
		)
		(6013
			(= local4 {baker.sav})
		)
		(6014
			(= local4 {bristol.sav})
		)
		(6015
			(= local4 {eightoff.sav})
		)
		(6016
			(= local4 {shamrock.sav})
		)
		(6017
			(= local4 {yukon.sav})
		)
		(6018
			(= local4 {eliminat.sav})
		)
		(6019
			(= local4 {slide.sav})
		)
		(6020
			(= local4 {bowling.sav})
		)
		(6021
			(= local4 {nestor.sav})
		)
		(6022
			(= local4 {acesup.sav})
		)
		(6023
			(= local4 {gaps.sav})
		)
		(6024
			(= local4 {penguin.sav})
		)
		(6025
			(= local4 {pyramid.sav})
		)
		(6026
			(= local4 {triplets.sav})
		)
		(6027
			(= local4 {pokrsqrs.sav})
		)
		(6028
			(= local4 {cribsqrs.sav})
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0)
	(if (and (< argc 4) (not param1))
		(return)
	)
	(if (< param1 0)
		(= temp0 1)
		(*= param1 -1)
	else
		(= temp0 0)
	)
	(cond
		((>= param1 1000)
			(proc0_10
				680
				2
				(mod (/ param1 1000) 10)
				(+ param2 30)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				gamesWindow
				param5
			)
		)
		((>= param1 100)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				gamesWindow
				param5
			)
		)
		((>= param1 10)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				gamesWindow
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				gamesWindow
				param5
			)
		)
		((>= param1 0)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				gamesWindow
				param5
			)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((gamesWindow casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
)

(instance saveStats of Code
	(properties)

	(method (init param1 param2 param3 param4)
		(= local1 970)
		(= local2 (if (>= argc 2) param2 else -1))
		(= local3 (if (>= argc 2) param3 else -1))
		(= local20 (if (== argc 4) param4 else 0))
		(if (not global242)
			(if global114
				(= global242 5)
			else
				(= global242 1)
			)
		)
		(if (not global114)
			(if
				(or
					(== gCardGameScriptNumber 6020)
					(== gCardGameScriptNumber 6028)
					(== gCardGameScriptNumber 6019)
					(== gCardGameScriptNumber 6027)
				)
				(iconClearBestScore mainLoop: 10)
			else
				(iconClearBestScore mainLoop: 11)
			)
		)
		(cond
			((and global187 (== gCardGameScriptNumber 6020))
				((ScriptID 930 0) init: 9131 4 gCurRoomNum global242) ; yesNo
				(if (not global748)
					(-- global186)
					(++ global242)
				else
					(-- global186)
					(++ global242)
					(iconOne mainLoop: 1)
					(iconTwo mainLoop: 2)
					(iconThree mainLoop: 3)
					(iconFour mainLoop: 4)
					(iconOK mainLoop: 9)
					(if (not global114)
						(iconClearOne mainLoop: 5)
						(iconClearTwo mainLoop: 6)
						(iconClearThree mainLoop: 7)
						(iconClearFour mainLoop: 8)
					)
					(localproc_0)
				)
			)
			((and (not global187) (== gCardGameScriptNumber 6020))
				((ScriptID 930 0) init: 9131 4 gCurRoomNum global242) ; yesNo
				(if (not global748)
					(-- global186)
					(++ global242)
				else
					(-- global186)
					(++ global242)
					(iconOne mainLoop: 1)
					(iconTwo mainLoop: 2)
					(iconThree mainLoop: 3)
					(iconFour mainLoop: 4)
					(iconOK mainLoop: 9)
					(if (not global114)
						(iconClearOne mainLoop: 5)
						(iconClearTwo mainLoop: 6)
						(iconClearThree mainLoop: 7)
						(iconClearFour mainLoop: 8)
					)
					(localproc_0)
				)
			)
			(else
				(iconOne mainLoop: 1)
				(iconTwo mainLoop: 2)
				(iconThree mainLoop: 3)
				(iconFour mainLoop: 4)
				(iconOK mainLoop: 9)
				(if (not global114)
					(iconClearOne mainLoop: 5)
					(iconClearTwo mainLoop: 6)
					(iconClearThree mainLoop: 7)
					(iconClearFour mainLoop: 8)
				)
				(localproc_0)
			)
		)
	)
)

(instance gamesWindow of InvisibleWindow
	(properties)

	(method (init)
		(= top (+ (/ (- gScreenHeight 260) 2) 2))
		(= left (+ (/ (- gScreenWidth 320) 2) 1))
		(= bottom (- (+ (/ (- gScreenHeight 260) 2) 260) 2))
		(= right (+ (/ (- gScreenWidth 320) 2) 320))
		(= priority 15)
		(= inTop top)
		(= inLeft left)
		(= inBottom bottom)
		(= inRight right)
		(super init:)
		(localproc_1)
		(= local18 1)
		(global930 doit:)
		(= local18 0)
		(if (== gCardGameScriptNumber 6020)
			(proc0_10 979 0 0 -2 -2 0 self)
			(localproc_2 local9 145 58 1 {one})
			(localproc_2 local13 210 58 1 {one})
			(localproc_2 local10 145 91 1 {two})
			(localproc_2 local14 210 91 1 {two})
			(localproc_2 local11 145 124 1 {three})
			(localproc_2 local15 210 124 1 {three})
			(localproc_2 local12 145 157 1 {four})
			(localproc_2 local16 210 157 1 {four})
		else
			(proc0_10 local1 0 0 -2 -2 0 self)
			(localproc_2 local9 145 58 1 {one})
			(localproc_2 local5 210 58 1 {one})
			(localproc_2 local10 145 91 1 {two})
			(localproc_2 local6 210 91 1 {two})
			(localproc_2 local11 145 124 1 {three})
			(localproc_2 local7 210 124 1 {three})
			(localproc_2 local12 145 157 1 {four})
			(localproc_2 local8 210 157 1 {four})
		)
		(if global114
			(proc0_10 979 10 0 0 0 0 self)
		else
			(proc0_10 979 10 1 15 0 0 self)
		)
	)
)

(instance playersControls of HoyleGameControls
	(properties)
)

(instance iconOne of ControlIcon
	(properties
		modNum 991
		nsLeft 10
		nsTop 50
		x 10
		y 50
		signal 387
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 1)
			(if global114
				(= local17 1)
				(localproc_1)
				(global930 doit:)
				(if (!= gCardGameScriptNumber 6020)
					((ScriptID 6080 1) doit: 0) ; scoreHand
				)
				(iconOK doit:)
			else
				(localproc_1)
				(global930 doit: 3)
				(= local18 1)
				(global930 doit:)
				(= local18 0)
				(localproc_3 {one})
				(if (!= gCardGameScriptNumber 6020)
					(localproc_2 local9 145 58 1 {one})
					(localproc_2 local5 210 58 1 {one})
				else
					(localproc_2 local9 145 58 1 {one})
					(localproc_2 local13 210 58 1 {one})
				)
			)
		)
	)
)

(instance iconTwo of ControlIcon
	(properties
		modNum 991
		nsLeft 10
		nsTop 83
		x 10
		y 83
		signal 387
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 2)
			(if global114
				(= local17 1)
				(localproc_1)
				(global930 doit:)
				(if (!= gCardGameScriptNumber 6020)
					((ScriptID 6080 1) doit: 0) ; scoreHand
				)
				(iconOK doit:)
			else
				(localproc_1)
				(global930 doit: 3)
				(= local18 1)
				(global930 doit:)
				(= local18 0)
				(localproc_3 {two})
				(if (!= gCardGameScriptNumber 6020)
					(localproc_2 local10 145 91 1 {two})
					(localproc_2 local6 210 91 1 {two})
				else
					(localproc_2 local10 145 91 1 {two})
					(localproc_2 local14 210 91 1 {two})
				)
			)
		)
	)
)

(instance iconThree of ControlIcon
	(properties
		modNum 991
		nsLeft 10
		nsTop 116
		x 10
		y 116
		signal 387
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 3)
			(if global114
				(= local17 1)
				(localproc_1)
				(global930 doit:)
				(if (!= gCardGameScriptNumber 6020)
					((ScriptID 6080 1) doit: 0) ; scoreHand
				)
				(iconOK doit:)
			else
				(localproc_1)
				(global930 doit: 3)
				(= local18 1)
				(global930 doit:)
				(= local18 0)
				(localproc_3 {three})
				(if (!= gCardGameScriptNumber 6020)
					(localproc_2 local11 145 124 1 {three})
					(localproc_2 local7 210 124 1 {three})
				else
					(localproc_2 local11 145 124 1 {three})
					(localproc_2 local15 210 124 1 {three})
				)
			)
		)
	)
)

(instance iconFour of ControlIcon
	(properties
		modNum 991
		nsLeft 10
		nsTop 149
		x 10
		y 149
		signal 387
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 4)
			(if global114
				(= local17 1)
				(localproc_1)
				(global930 doit:)
				(if (!= gCardGameScriptNumber 6020)
					((ScriptID 6080 1) doit: 0) ; scoreHand
				)
				(iconOK doit:)
			else
				(localproc_1)
				(global930 doit: 3)
				(= local18 1)
				(global930 doit:)
				(= local18 0)
				(localproc_3 {four})
				(if (!= gCardGameScriptNumber 6020)
					(localproc_2 local12 145 157 1 {four})
					(localproc_2 local8 210 157 1 {four})
				else
					(localproc_2 local12 145 157 1 {four})
					(localproc_2 local16 210 157 1 {four})
				)
			)
		)
	)
)

(instance iconClearOne of ControlIcon
	(properties
		noun 2
		modNum 991
		nsLeft 88
		nsTop 50
		x 88
		y 50
		signal 387
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 1)
			(= global184 global113)
			(= global185 global402)
			(localproc_1)
			(= local19 1)
			(if (!= gCardGameScriptNumber 6020)
				(= global113 0)
				(= global402 0)
			)
			(global930 doit: 3)
			(= global113 global184)
			(= global402 global185)
			(= local19 0)
			(= local18 1)
			(global930 doit:)
			(= local18 0)
			(localproc_3 {one})
			(if (!= gCardGameScriptNumber 6020)
				(localproc_2 local9 145 58 1 {one})
				(localproc_2 local5 210 58 1 {one})
			else
				(localproc_2 local9 145 58 1 {one})
				(localproc_2 local13 210 58 1 {one})
			)
		)
	)
)

(instance iconClearTwo of ControlIcon
	(properties
		noun 2
		modNum 991
		nsLeft 88
		nsTop 83
		x 88
		y 83
		signal 387
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 2)
			(= global184 global113)
			(= global185 global402)
			(localproc_1)
			(= local19 1)
			(if (!= gCardGameScriptNumber 6020)
				(= global113 0)
				(= global402 0)
			)
			(global930 doit: 3)
			(= global113 global184)
			(= global402 global185)
			(= local19 0)
			(= local18 1)
			(global930 doit:)
			(= local18 0)
			(localproc_3 {two})
			(if (!= gCardGameScriptNumber 6020)
				(localproc_2 local10 145 91 1 {two})
				(localproc_2 local6 210 91 1 {two})
			else
				(localproc_2 local10 145 91 1 {two})
				(localproc_2 local14 210 91 1 {two})
			)
		)
	)
)

(instance iconClearThree of ControlIcon
	(properties
		noun 2
		modNum 991
		nsLeft 88
		nsTop 116
		x 88
		y 116
		signal 387
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 3)
			(= global184 global113)
			(= global185 global402)
			(localproc_1)
			(= local19 1)
			(if (!= gCardGameScriptNumber 6020)
				(= global113 0)
				(= global402 0)
			)
			(global930 doit: 3)
			(= global113 global184)
			(= global402 global185)
			(= local19 0)
			(= local18 1)
			(global930 doit:)
			(= local18 0)
			(localproc_3 {three})
			(if (!= gCardGameScriptNumber 6020)
				(localproc_2 local11 145 124 1 {three})
				(localproc_2 local7 210 124 1 {three})
			else
				(localproc_2 local11 145 124 1 {three})
				(localproc_2 local7 210 124 1 {three})
			)
		)
	)
)

(instance iconClearFour of ControlIcon
	(properties
		noun 2
		modNum 991
		nsLeft 88
		nsTop 149
		x 88
		y 149
		signal 387
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global112 4)
			(= global184 global113)
			(= global185 global402)
			(localproc_1)
			(= local19 1)
			(if (!= gCardGameScriptNumber 6020)
				(= global113 0)
				(= global402 0)
			)
			(global930 doit: 3)
			(= global113 global184)
			(= global402 global185)
			(= local19 0)
			(= local18 1)
			(global930 doit:)
			(= local18 0)
			(localproc_3 {four})
			(if (!= gCardGameScriptNumber 6020)
				(localproc_2 local12 145 157 1 {four})
				(localproc_2 local8 210 157 1 {four})
			else
				(localproc_2 local12 145 157 1 {four})
				(localproc_2 local8 210 157 1 {four})
			)
		)
	)
)

(instance iconClearBestScore of ControlIcon
	(properties
		noun 3
		modNum 991
		nsLeft 164
		nsTop 220
		x 164
		y 220
		signal 387
		mainLoop 10
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
		(DisposeScript 930)
		(if global748
			(= global525 1)
			(iconOK doit:)
		)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 4
		modNum 991
		nsLeft 52
		nsTop 184
		x 52
		y 184
		signal 387
		mainLoop 9
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(if global111
			(= global111 0)
			(= gGameControls local0)
			(= gNewRoomNum 975) ; chooseGame
		else
			(= gGameControls local0)
			(if local17
				(= global115 1)
				(= local17 0)
				(= global748 1)
			else
				(= global748 0)
			)
		)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 5
		modNum 991
		nsLeft 88
		nsTop 184
		x 88
		y 184
		signal 387
		mainView 979
		mainLoop 13
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance calculat_sav of File
	(properties
		name {calculat.sav}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= name local4)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(= local9 0)
		(= local10 0)
		(= local11 0)
		(= local12 0)
		(cond
			((and argc (== param1 3))
				(if (self open: 1)
					(= temp2 (Str new:))
					(self readString: temp2 5)
					(= local5 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local9 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local6 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local10 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local7 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local11 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local8 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local12 (temp2 asInteger:))
					(temp2 dispose:)
					(self close:)
				)
				(if (self open: 2)
					(= temp1 (Str new:))
					(switch global112
						(1
							(self
								writeString:
									(temp1
										format:
											{%4d%4d%4d%4d%4d%4d%4d%4d}
											global113
											global402
											local6
											local10
											local7
											local11
											local8
											local12
									)
								close:
							)
							(temp1 dispose:)
						)
						(2
							(self
								writeString:
									(temp1
										format:
											{%4d%4d%4d%4d%4d%4d%4d%4d}
											local5
											local9
											global113
											global402
											local7
											local11
											local8
											local12
									)
								close:
							)
							(temp1 dispose:)
						)
						(3
							(self
								writeString:
									(temp1
										format:
											{%4d%4d%4d%4d%4d%4d%4d%4d}
											local5
											local9
											local6
											local10
											global113
											global402
											local8
											local12
									)
								close:
							)
							(temp1 dispose:)
						)
						(4
							(self
								writeString:
									(temp1
										format:
											{%4d%4d%4d%4d%4d%4d%4d%4d}
											local5
											local9
											local6
											local10
											local7
											local11
											global113
											global402
									)
								close:
							)
							(temp1 dispose:)
						)
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp2 (Str new:))
				(if local18
					(self readString: temp2 5)
					(= local5 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local9 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local6 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local10 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local7 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local11 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local8 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local12 (temp2 asInteger:))
					(temp2 dispose:)
					(self close:)
				else
					(for ((= temp0 1)) (< temp0 global112) ((++ temp0))
						(self readString: temp2 5)
						(self readString: temp2 5)
					)
					(self readString: temp2 5)
					(= global113 (temp2 asInteger:))
					(self readString: temp2 5)
					(= global402 (temp2 asInteger:))
					(temp2 dispose:)
					(self close:)
					(return 0)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance bowling_sav of File
	(properties
		name {bowling.sav}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= name local4)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(= local9 0)
		(= local10 0)
		(= local11 0)
		(= local12 0)
		(= local13 0)
		(= local14 0)
		(= local15 0)
		(= local16 0)
		(cond
			((and argc (== param1 3))
				(if (self open: 1)
					(= temp2 (Str new:))
					(self readString: temp2 8)
					(= local5 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local9 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local13 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local6 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local10 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local14 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local7 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local11 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local15 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local8 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local12 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local16 (temp2 asInteger:))
					(temp2 dispose:)
					(self close:)
				)
				(if (self open: 2)
					(= temp1 (Str new:))
					(if (== local20 1)
						(= local21 global234)
						(= local22 global238)
						(= local23 global230)
					)
					(if (== local20 2)
						(= local21 global235)
						(= local22 global239)
						(= local23 global231)
					)
					(if (== local20 3)
						(= local21 global236)
						(= local22 global240)
						(= local23 global232)
					)
					(if (== local20 4)
						(= local21 global237)
						(= local22 global241)
						(= local23 global233)
					)
					(if local19
						(= local21 0)
						(= local22 0)
						(= local23 0)
					)
					(switch global112
						(1
							(self
								writeString:
									(temp1
										format:
											{%7d%4d%3d%7d%4d%3d%7d%4d%3d%7d%4d%3d}
											local21
											local22
											local23
											local6
											local10
											local14
											local7
											local11
											local15
											local8
											local12
											local16
									)
								close:
							)
							(temp1 dispose:)
						)
						(2
							(self
								writeString:
									(temp1
										format:
											{%7d%4d%3d%7d%4d%3d%7d%4d%3d%7d%4d%3d}
											local5
											local9
											local13
											local21
											local22
											local23
											local7
											local11
											local15
											local8
											local12
											local16
									)
								close:
							)
							(temp1 dispose:)
						)
						(3
							(self
								writeString:
									(temp1
										format:
											{%7d%4d%3d%7d%4d%3d%7d%4d%3d%7d%4d%3d}
											local5
											local9
											local13
											local6
											local10
											local14
											local21
											local22
											local23
											local8
											local12
											local16
									)
								close:
							)
							(temp1 dispose:)
						)
						(4
							(self
								writeString:
									(temp1
										format:
											{%7d%4d%3d%7d%4d%3d%7d%4d%3d%7d%4d%3d}
											local5
											local9
											local13
											local6
											local10
											local14
											local7
											local11
											local15
											local21
											local22
											local23
									)
								close:
							)
							(temp1 dispose:)
						)
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp2 (Str new:))
				(if local18
					(self readString: temp2 8)
					(= local5 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local9 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local13 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local6 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local10 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local14 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local7 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local11 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local15 (temp2 asInteger:))
					(self readString: temp2 8)
					(= local8 (temp2 asInteger:))
					(self readString: temp2 5)
					(= local12 (temp2 asInteger:))
					(self readString: temp2 4)
					(= local16 (temp2 asInteger:))
					(temp2 dispose:)
					(self close:)
				else
					(for ((= temp0 1)) (< temp0 global112) ((++ temp0))
						(self readString: temp2 8)
						(self readString: temp2 5)
						(self readString: temp2 4)
					)
					(switch local20
						(1
							(self readString: temp2 8)
							(= global234 (temp2 asInteger:))
							(self readString: temp2 5)
							(= global238 (temp2 asInteger:))
							(self readString: temp2 4)
							(= global230 (temp2 asInteger:))
						)
						(2
							(self readString: temp2 8)
							(= global235 (temp2 asInteger:))
							(self readString: temp2 5)
							(= global239 (temp2 asInteger:))
							(self readString: temp2 4)
							(= global231 (temp2 asInteger:))
						)
						(3
							(self readString: temp2 8)
							(= global236 (temp2 asInteger:))
							(self readString: temp2 5)
							(= global240 (temp2 asInteger:))
							(self readString: temp2 4)
							(= global232 (temp2 asInteger:))
						)
						(4
							(self readString: temp2 8)
							(= global237 (temp2 asInteger:))
							(self readString: temp2 5)
							(= global241 (temp2 asInteger:))
							(self readString: temp2 4)
							(= global233 (temp2 asInteger:))
						)
					)
					(temp2 dispose:)
					(self close:)
					(return 0)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

