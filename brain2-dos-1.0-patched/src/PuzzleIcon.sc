;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Print)
(use IconBar)
(use System)

(public
	Say 0
	puzzleCoin 1
	puzzleOK 2
	puzzleHelp 3
	proc15_4 4
	proc15_5 5
	proc15_6 6
	proc15_7 7
	PuzzleIcon 8
)

(local
	[local0 3] = [3 10 11]
	local3
	local4
	local5
	local6
)

(procedure (Say param1 &tmp temp0)
	(gMessager say: &rest)
	(= gGameTime (+ gTickOffset (GetTime)))
	(if gFastCast
		(while gFastCast
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp0 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp0)
			)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(if param1
			(SetPort (param1 thisPort:))
		)
	)
)

(procedure (proc15_4 param1 &tmp temp0 temp1)
	(= temp1 (gTheIconBar state:))
	(gMessager sayFormat: &rest)
	(= gGameTime (+ gTickOffset (GetTime)))
	(if gFastCast
		(while gFastCast
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp0 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp0)
			)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(if param1
			(SetPort (param1 thisPort:))
		)
	)
	(gTheIconBar state: temp1)
)

(procedure (proc15_5 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 50] [temp56 20] temp76 temp77)
	(= temp76 0)
	(SetFlag param1)
	(= temp0 (+ gScore global134))
	(= temp2 (/ [global135 param3] 1000))
	(= temp3 (/ (mod [global135 param3] 1000) 100))
	(= temp4 (/ (mod [global135 param3] 100) 10))
	(= temp5 (mod [global135 param3] 10))
	(= temp77
		(-
			(+ 5 (* param2 5))
			(if (< local5 5)
				(* local5 (+ 1 param2))
			else
				(* 4 (+ 1 param2))
			)
		)
	)
	(cond
		((== param2 2)
			(cond
				((> temp3 param4) 0)
				((not temp3)
					(= temp76 1)
					(++ temp3)
					(++ global121)
					(if (or temp4 temp5)
						(++ global134)
					)
				)
				(else
					(++ temp3)
					(++ global134)
				)
			)
		)
		(param2
			(cond
				((> temp4 param4) 0)
				((not temp4)
					(= temp76 1)
					(++ temp4)
					(++ global120)
					(if (or temp3 temp5)
						(++ global134)
					)
				)
				(else
					(++ temp4)
					(++ global134)
				)
			)
		)
		((> temp5 param4) 0)
		((not temp5)
			(= temp76 1)
			(++ temp5)
			(++ global119)
			(if (or temp3 temp4)
				(++ global134)
			)
		)
		(else
			(++ temp5)
			(++ global134)
		)
	)
	(if (> temp77 temp2)
		(+= gScore (- temp77 temp2))
		(= temp2 temp77)
	)
	(= [global135 param3] (+ (* temp2 1000) (* temp3 100) (* temp4 10) temp5))
	(= local5 0)
	(if (> (+ gScore global134) temp0)
		(++ global115)
	)
	(if (< argc 5)
		(= param5 0)
	)
	(if temp76
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(= global133 param2)
			(= global132 (+ param3 1))
			((ScriptID 30 0) disposeWhenDone: 0) ; brainTalker
			(Say param5 2 9 0 4 0 20) ; "Congratulations!"
			(= global132 0)
			((ScriptID 30 0) disposeWhenDone: 1 dispose:) ; brainTalker
		else
			(Message msgGET 20 2 9 0 4 @temp6) ; "Congratulations!"
			(StrCat @temp6 { })
			(Message msgGET 20 2 9 0 (+ param2 1) @temp56)
			(StrCat @temp6 @temp56)
			(StrCat @temp6 { })
			(Message msgGET 20 3 9 0 (+ param3 1) @temp56)
			(StrCat @temp6 @temp56)
			(proc15_4 param5 3 @temp6)
		)
	else
		(Say param5 10 4 0 (Random 1 5) 0 20)
	)
	(return
		(if (> (+ gScore global134) temp0)
			(- gScore temp0)
		else
			0
		)
	)
)

(procedure (proc15_6 param1 param2 param3 param4 &tmp temp0 [temp1 10])
	(if (Message msgGET param1 param2 param3 param4 1 @temp1)
		(for ((= temp0 1)) (Message msgNEXT @temp1) ((++ temp0))
		)
		(return temp0)
	else
		(return 0)
	)
)

(procedure (proc15_7 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(procedure (localproc_0 param1 &tmp temp0) ; UNUSED
	((ScriptID 30 0) say: &rest) ; brainTalker
	(Prints {2})
	(= gGameTime (+ gTickOffset (GetTime)))
	(if gFastCast
		(while gFastCast
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp0 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp0)
			)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(if param1
			(SetPort (param1 thisPort:))
		)
	)
)

(class PuzzleIcon of CodeIcon
	(properties
		downClick 199
		upClick 200
		client 0
	)
)

(class PuzzleBar of IconBar
	(properties
		state 0
		iconHeight 22
		puzzleHeight 10
		eventX 0
		eventY 0
		hintFlag 0
		solvedFlag 0
		script 0
		inited 0
		shown 0
		noun 0
		thisPort 0
		pHandsOff 0
		msgModule 0
		personalID 0
		puzzleCast 0
		showCast 0
		puzzleStatus 0
		idleTime 180
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(= puzzleStatus 0)
		(gSystemWindow eraseOnly: 1)
		(if (& state $0008)
			(gCMusic fade: 0 10 10 1)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(= highlightedIcon (= curIcon 0))
		(|= state $0020)
		(if (and window (IsObject window))
			(window open:)
		)
		(= thisPort (GetPort))
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if (and (not (& (temp4 signal:) $0080)) (<= (temp4 nsRight:) 0))
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight:)))
			else
				(temp4 show:)
			)
		)
		(cond
			((not curIcon) 0)
			((HaveMouse)
				(gGame setCursor: gTheCursor 1)
			)
			(else
				(gGame
					setCursor:
						gTheCursor
						1
						(+
							(curIcon nsLeft:)
							(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
						)
						(- (curIcon nsBottom:) 3)
				)
			)
		)
		(proc15_7)
		(if (not (& shown (<< $0001 gDifficulty)))
			(self showHelp: 0)
			(|= shown (<< $0001 gDifficulty))
		)
		(if puzzleCast
			(puzzleCast eachElementDo: #show)
		)
		(= local3 0)
		(= local4 gGameTime)
		(self doit: hide:)
		(gSystemWindow eraseOnly: 0)
		(if (& state $0008)
			(gCMusic play: setVol: 0 fade: 127 10 10 0)
		)
		(return puzzleStatus)
	)

	(method (hide)
		(if puzzleCast
			(puzzleCast eachElementDo: #hide)
			(Animate (puzzleCast elements:) 0)
		)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(if window
			(window dispose:)
		)
		(if (& state $0020)
			(&= state $ffdf)
		)
		(= local6 1)
	)

	(method (init &tmp temp0)
		(if (not inited)
			(= inited 1)
			(= local5 (= puzzleStatus 0))
			(= local6 1)
			(if window
				(if (< (= temp0 (- (window right:) (window left:))) 90)
					(= temp0 90)
				)
				(self
					add:
						(puzzleCoin new:)
						((puzzleOK new:) nsLeft: (/ (- temp0 40) 2) yourself:)
						((puzzleHelp new:) nsLeft: (- temp0 31) yourself:)
				)
			)
			(if (not msgModule)
				(= msgModule gCurRoomNum)
			)
			(super init: &rest)
		)
	)

	(method (dispose)
		(= inited 0)
		(if puzzleCast
			(puzzleCast
				eachElementDo: #dispose
				eachElementDo: #delete
				release:
				dispose:
			)
		)
		(= puzzleCast 0)
		(if hintFlag
			(ClearFlag hintFlag)
		)
		(super dispose: &rest)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 900)
	)

	(method (add param1 &tmp temp0 temp1)
		(super add: param1 &rest)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			(if (temp1 respondsTo: #client)
				(temp1 client: self)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(Wait 1)
			(if (== temp1 256)
				(temp0 type: 4 message: 13)
			)
			(temp0 localize:)
			(MapKeyToDir temp0)
			(if pHandsOff
				(temp0 type: 0)
			)
			(breakif (self dispatchEvent: temp0))
		)
		(gGame setCursor: 900)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
			)
			(SetPort thisPort)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
		(gTheDoits doit:)
		(if script
			(script doit:)
		)
		(if gSet
			(gSet eachElementDo: #doit)
		)
		(if (or (event type:) script)
			(= local4 gGameTime)
			(= local3 0)
		else
			(if (> (Abs local4) (Abs gGameTime))
				(= temp6 (- gGameTime local4))
			else
				(= temp6 (- (Abs gGameTime) (Abs local4)))
			)
			(if (>= temp6 60)
				(= local4 gGameTime)
				(if (> (++ local3) idleTime)
					(if (not puzzleStatus)
						(Say self 1 9 0 (Random 1 16) 0 20)
					)
					(= local3 0)
				)
			)
		)
		(if gPrints
			(gPrints eachElementDo: #doit)
			(if (not gModelessDialog)
				(if (and ((= temp0 (Event new:)) type:) gPrints)
					(gPrints firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(return (= gGameTime (+ gTickOffset (GetTime))))
			)
			(SetPort thisPort)
		)
		(gSounds eachElementDo: #check)
		(self animateOnce:)
		(= eventX (event x:))
		(= eventY (event y:))
		(= temp1
			(if pHandsOff
				0
			else
				(event type:)
			)
		)
		(= temp2 (event message:))
		(= temp4 (event claimed:))
		(= temp3 (self firstTrue: #onMe event))
		(if (!= highlightedIcon temp3)
			(self highlight: temp3)
		)
		(event dispose:)
		(switch temp1
			(0
				(= temp4 0)
			)
			(1
				(if
					(and
						temp3
						(self select: temp3 1)
						(= temp4 (& (temp3 signal:) $0040))
					)
					(&= state $ffdf)
				)
			)
			(4
				(switch temp2
					(KEY_ESCAPE
						(= temp4 1)
					)
					(KEY_RETURN
						(if (IsObject temp3)
							(self select: temp3)
							(= temp4 (& (temp3 signal:) $0040))
						)
					)
					(KEY_SHIFTTAB
						(self retreat:)
					)
					(KEY_TAB
						(self advance:)
					)
					(KEY_QUESTION
						(self showHelp: 1)
					)
					(KEY_k
						(Say self 33 46 0 0 0 1) ; "|c4|KEYBOARD SUPPORT:|c|  |c4|ENTER|c| - Select |c4|Arrow keys|c| - Move the cursor up, down, left, or right |c4|ESC|c|ape - Exit puzzle |c4|?|c| - Brings up puzzle instructions |c4|k|c| - View this screen"
						(if (Message msgSIZE msgModule noun 46 0 1)
							(Say self noun 46 0 0 0 msgModule)
						)
					)
					(KEY_K
						(Say self 33 46 0 0 0 1) ; "|c4|KEYBOARD SUPPORT:|c|  |c4|ENTER|c| - Select |c4|Arrow keys|c| - Move the cursor up, down, left, or right |c4|ESC|c|ape - Exit puzzle |c4|?|c| - Brings up puzzle instructions |c4|k|c| - View this screen"
						(if (Message msgSIZE msgModule noun 46 0 1)
							(Say self noun 46 0 0 0 msgModule)
						)
					)
					(KEY_F2
						(cond
							((gGame masterVolume:)
								(gGame masterVolume: 0)
							)
							((> global106 1)
								(gGame masterVolume: 15)
							)
							(else
								(gGame masterVolume: 15)
							)
						)
					)
				)
			)
			(else
				(if (& temp1 $0040)
					(switch temp2
						(JOY_RIGHT
							(self advance:)
						)
						(JOY_LEFT
							(self retreat:)
						)
					)
				)
			)
		)
		(return temp4)
	)

	(method (highlight param1 param2 &tmp temp0)
		(if (IsObject highlightedIcon)
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (IsObject (= highlightedIcon param1))) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(pHandsOff 0)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (animateOnce)
		(if (and puzzleCast showCast)
			(Animate (puzzleCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(puzzleCast eachElementDo: #motionCue)
			)
		)
		(return 0)
	)

	(method (buyClue &tmp [temp0 4])
		(return
			(cond
				((and hintFlag (IsFlag hintFlag)) 1)
				((not global115)
					(Say self 2 1 2 1 0 1) ; "Your Hint Watch Battery has no more hint charges left."
					0
				)
				(else
					(if hintFlag
						(SetFlag hintFlag)
					)
					(++ local5)
					(if (not (-- global115))
						(Say self 2 1 3 1 0 1) ; "You use your last hint charge."
					)
					1
				)
			)
		)
	)

	(method (showHelp param1 &tmp temp0)
		(if (and (not (& state $2000)) (or param1 (not shown)))
			(Say self noun 9 0 0 0 msgModule)
		)
		(if
			(and
				(not (& state $2000))
				(Message msgGET msgModule noun [local0 gDifficulty] 0 1)
			)
			(Say self noun [local0 gDifficulty] 0 0 0 msgModule)
		)
	)

	(method (goAway)
		(&= state $ffdf)
	)

	(method (isActive)
		(return (& state $0020))
	)

	(method (solvePuzzle param1 param2 &tmp temp0 temp1)
		(gGame setCursor: 902)
		(if (== argc 2)
			(= temp1 param2)
		else
			(= temp1 3)
		)
		(= temp0
			(proc15_5
				solvedFlag
				(if argc param1 else gDifficulty)
				personalID
				temp1
				self
			)
		)
		(proc15_7)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= puzzleStatus 1)
		(return temp0)
	)

	(method (resetPuzzle))

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)
)

(instance puzzleCoin of PuzzleIcon
	(properties
		view 945
		loop 0
		nsLeft 7
		nsTop 2
		signal 385
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(client buyClue:)
		)
	)
)

(instance puzzleOK of PuzzleIcon
	(properties
		view 945
		loop 1
		nsLeft 30
		nsTop 2
		signal 193
	)

	(method (select)
		(if (super select: &rest)
			(client goAway:)
		)
	)
)

(instance puzzleHelp of PuzzleIcon
	(properties
		view 945
		loop 2
		nsLeft 70
		nsTop 2
		cursor 70
		signal 385
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(super show: &rest)
		(if local6
			(= temp3 (GetPort))
			(SetPort 0)
			(= temp0 (client window:))
			(= temp1 (temp0 left:))
			(= temp2 (temp0 right:))
			(= temp4 (+ (temp0 top:) (client iconHeight:)))
			(Graph grDRAW_LINE (- temp4 3) temp1 (- temp4 3) temp2 0 -1 -1)
			(Graph grDRAW_LINE (- temp4 2) temp1 (- temp4 2) temp2 0 -1 -1)
			(Graph grUPDATE_BOX (- temp4 3) temp1 (- temp4 1) temp2 1)
			(SetPort temp3)
			(= local6 0)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(client showHelp: 1)
		)
	)
)

