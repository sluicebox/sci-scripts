;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6018)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use ManualSort)
(use TrackingView)
(use h5Messager)
(use sHand)
(use acesup)
(use Str)
(use Print)
(use IconBar)
(use File)
(use Actor)
(use System)

(public
	eliminator 0
	proc6018_1 1
	optionCode 2
	roomScript 3
	proc6018_4 4
	timeWindow 8
)

(local
	local0 = 1
	local1
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
)

(procedure (proc6018_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6018_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0 &tmp temp0)
	(if (== global927 1)
		(= temp0 9)
	else
		(= temp0 3)
	)
	(found1 buildOrder: temp0)
	(found2 buildOrder: temp0)
	(found3 buildOrder: temp0)
	(found4 buildOrder: temp0)
	(found5 buildOrder: temp0)
	(found6 buildOrder: temp0)
	(found7 buildOrder: temp0)
	(found8 buildOrder: temp0)
)

(instance eliminator of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(DisableCursor)
		(if global921
			(= global896 0)
			(= global916 1)
		)
		(if (and (== gPrevRoomNum 975) (not global527)) ; chooseGame
			(gSound2 play: 811)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6018)
		(= local7 0)
		(gChar1 active: 1)
		(gChar2 active: 0)
		(gChar3 active: 0)
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(gTheKeyMouseList release:)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		((= global929 eliminat_opt) doit:)
		(= picture (+ global877 global385))
		(= local19 global385)
		(super init:)
		(gChar1 view: 0 active: 1 setLoop: 2)
		(if global921
			((gChar1 face:) view: 0 loop: 4 cel: 0)
			(gChar1 x: -50 y: -50)
		else
			((gChar1 face:) view: 0)
			(gChar1 posn: -50 -50)
		)
		(if global921
			(gChar1 view: 0 loop: 4 cel: 0)
		)
		(gChar1 show: init:)
		(Characters init:)
		(= global394 0)
		(= global265 0)
		(hand1 add: owner: 0)
		(hand2 add: owner: 0)
		(hand3 add: owner: 0)
		(hand4 add: owner: 0)
		(found1 emptyView: found1Empty)
		(found2 emptyView: found2Empty)
		(found3 emptyView: found3Empty)
		(found4 emptyView: found4Empty)
		(found5 emptyView: found5Empty)
		(found6 emptyView: found6Empty)
		(found7 emptyView: found7Empty)
		(found8 emptyView: found8Empty)
		(if (== global927 1)
			((= gTheHands theHands)
				add:
					hand1
					hand2
					hand3
					hand4
					found1
					found2
					found3
					found4
					found5
					found6
					found7
					found8
					hardFound
			)
			(hardFound emptyView: hardFoundEmpty)
		else
			((= gTheHands theHands)
				add:
					hand1
					hand2
					hand3
					hand4
					found1
					found2
					found3
					found4
					found5
					found6
					found7
					found8
			)
		)
		((= gTheFoundations theFoundations)
			add: found1 found2 found3 found4 found5 found6 found7 found8
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(global929 doit: 3)
		(= local5 1)
		(= global928 0)
		(IconBarF init:)
		(if (not global115)
			(if (== gPrevRoomNum 6029) ; cardflick
				(= global113 global184)
				(= global402 global185)
			else
				(= global113 0)
				(= global402 0)
			)
		else
			(= global115 0)
		)
		(gameName init: setPri: 35)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 50 global878))
		)
		(cond
			((> 38 global878 30)
				(gSong setLoop: -1)
			)
			((not local7)
				(gSong setLoop: 1)
			)
		)
		(if global250
			(timeWindow init:)
		else
			(currentScoreWindow init:)
		)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
				local18
			)
			(event claimed: 1)
			(= local18 0)
			(tabView hide:)
		)
		(if
			(and
				(not (event claimed:))
				(== evKEYBOARD (event type:))
				(== (event message:) KEY_TAB)
			)
			(event claimed: 1)
			(tabView init: show:)
			(UpdateScreenItem tabView)
		)
		(super handleEvent: event)
		(if (handleEventList handleEvent: event)
			(event claimed: 1)
		)
	)

	(method (doit)
		(super doit:)
		(sDealer doit:)
	)

	(method (dispose &tmp temp0)
		(= local6 0)
		(= global418 0)
		(gDelayCast release:)
		(= global458 0)
		(IconBarF dispose:)
		(sDealer dispose:)
		((KeyMouse objList:) release:)
		(dealList release: dispose:)
		(gTheHands
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(gTheFoundations
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(theHands dispose:)
		(theFoundations dispose:)
		(if local18
			(tabView hide: dispose:)
		)
		(handleEventList release: dispose:)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(found5Empty dispose:)
		(found6Empty dispose:)
		(found7Empty dispose:)
		(found8Empty dispose:)
		(hardFoundEmpty dispose:)
		(if local12
			(timeWindow dispose:)
		else
			(currentScoreWindow dispose:)
		)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance eliminat_opt of File
	(properties
		name {eliminat.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0
								format:
									{%d%d%2d%2d}
									local7
									global927
									local10
									local11
							)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp1 (Str new:))
				(self readString: temp1 2)
				(= local7 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local10 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local11 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local10 59)
				(= local11 59)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 4])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local10 59)
			(= local11 59)
			(global929 doit: 3)
			(if local12
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local19)
			(if local12
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local19 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local14)
				(not global253)
				local15
			)
			(= global251 (GetTime 1)) ; SysTime12
			(if (!= global252 global251)
				(= global252 global251)
				(if (== (++ global248) 60)
					(= global248 0)
				)
				(if (and (== global249 59) (== global248 0))
					(= global253 1)
				else
					(proc6022_7 {seconds} timeWindow)
					(proc6022_6 global248 92 5 1 {seconds} timeWindow)
					(if (== global248 0)
						(++ global249)
						(proc6022_7 {minutes} timeWindow)
						(proc6022_6 global249 70 5 1 {minutes} timeWindow)
					)
				)
			)
		else
			(= local15 1)
		)
		(if (and local6 (== state 5) (not global458))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(= local1 1)
					)
					(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
						(for
							((= temp2 (- ((gTheHands at: temp1) size:) 1)))
							(> temp2 -1)
							((-- temp2))
							
							(= temp5 ((gTheHands at: temp1) at: temp2))
							(if
								(and
									(temp5 faceUp:)
									(< (temp5 x:) gMouseX (+ (temp5 x:) 54))
									(< (temp5 y:) gMouseY (+ (temp5 y:) 77))
								)
								(magView
									init: (temp5 suit:) (- (temp5 rank:) 1)
								)
								(magView setPri: 100 show:)
								(= local0 1)
								(break)
							else
								(magView hide:)
							)
						)
						(if local0
							(= local0 0)
							(break)
						)
					)
				)
				(local1
					(UnLoad 128 985)
					(= local1 0)
					(magView hide:)
				)
			)
			(if (and (not global250) (!= local17 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local17 global928)
			)
			(if (== global928 52)
				(= local14 1)
				(if global250
					(= local8 global248)
					(if
						(or
							(< (= local9 global249) local10)
							(and (== local9 local10) (< local8 local11))
						)
						(= local10 local9)
						(= local11 local8)
						(= local13 1)
						(global929 doit: 3)
					)
				else
					(proc6022_7 {score} currentScoreWindow)
					(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				)
				(endCode doit:)
				(= local16 1)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local6 0)
				(= ticks (= ticks 1))
			)
			(1
				(if (== gPrevRoomNum 975) ; chooseGame
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList add: hand1 hand2 hand3 hand4)
				(sDealer init: dealList)
			)
			(3
				(gTheIconBar enable:)
				(if global524
					(= global524 0)
				)
				(= ticks 10)
			)
			(4
				(= local6 0)
				(= local5 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) wasFaceDown: 0)
				)
				(= local16 0)
				(= global395 0)
				(= global226 1)
				(Deck shuffle:)
				(localproc_0)
				(= local2 0)
				(= global243 0)
				(= global928 0)
				(= local17 -1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local14 0)
				(= global253 0)
				(= local13 0)
				(= local15 0)
				(sDealer deal: self)
			)
			(5
				(= local6 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local3 0)
				(found1Empty init: setPri: 1)
				(found2Empty init: setPri: 1)
				(found3Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
				(found5Empty init: setPri: 1)
				(found6Empty init: setPri: 1)
				(found7Empty init: setPri: 1)
				(found8Empty init: setPri: 1)
				(if (== global927 1)
					(handleEventList add: hand1 hand2 hand3 hand4 hardFound)
					(hardFoundEmpty init: setPri: 1)
				else
					(handleEventList add: hand1 hand2 hand3 hand4)
				)
				(handleEventList
					add: found1 found2 found3 found4 found5 found6 found7 found8
				)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
			)
		)
	)
)

(instance cleanUp of Code
	(properties)

	(method (doit &tmp temp0)
		(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
			(if ((Deck at: temp0) whenPlayed:)
				(((Deck at: temp0) whenPlayed:) release:)
				(((Deck at: temp0) whenPlayed:) dispose:)
			)
			(if ((Deck at: temp0) previousHand:)
				(((Deck at: temp0) previousHand:) release:)
				(((Deck at: temp0) previousHand:) dispose:)
			)
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) wasFaceDown: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(= local3 0)
		(if (and local12 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local18
			(= local18 0)
			(tabView hide:)
		)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(found5Empty dispose:)
		(found6Empty dispose:)
		(found7Empty dispose:)
		(found8Empty dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(theHands release:)
		(if (== global927 1)
			(theHands
				add:
					hand1
					hand2
					hand3
					hand4
					found1
					found2
					found3
					found4
					found5
					found6
					found7
					found8
					hardFound
			)
		else
			(theHands
				add:
					hand1
					hand2
					hand3
					hand4
					found1
					found2
					found3
					found4
					found5
					found6
					found7
					found8
			)
		)
		(dealList add: hand1 hand2 hand3 hand4)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (!= global928 52)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global504)
			(++ global221)
			(= global504 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local13)
			(Print
				ticks: 200
				fore: 0
				mode: 1
				addBitmap: 917 4 0
				font: gUserFont
				addText: {\n*******NEW BEST TIME!*******} 25 20
				init:
			)
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
			(proc6022_7 {bestminutes} timeWindow)
			(proc6022_7 {bestseconds} timeWindow)
			(if (and (== local10 59) (== local11 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local10 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local11 92 20 1 {bestseconds} timeWindow)
			)
			(= local13 0)
		)
		(= local6 0)
		(proc6018_1 1)
		(if local5
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local5 1)
		(DisableCursor)
		((ScriptID 6096 2) init:) ; aBanner
		(gSound2 play: 3000)
		((ScriptID 6096 2) setScript: (ScriptID 6096 1)) ; aBanner, sBannerOut
	)
)

(instance resignButton of TrackingView
	(properties
		x 596
		y 346
		view 915
		loop 10
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6018_1 1)
				(IconBarF lighten:)
				(if local5
					((ScriptID 6080 1) doit: global928) ; scoreHand
				)
				(cleanUp doit:)
			)
		)
	)
)

(instance undoButton of TrackingView
	(properties
		x 4
		y 346
		view 915
		loop 14
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== global225 0)
				(Print
					ticks: 400
					fore: 0
					mode: 1
					addBitmap: 917 4 0
					font: gUserFont
					addText: {Unable to undo last move.} 10 10
					init:
				)
			else
				(= global226 1)
				(for ((= temp0 0)) (< temp0 (Deck size:)) ((++ temp0))
					(if
						(and
							((Deck at: temp0) whenPlayed:)
							(==
								(((Deck at: temp0) whenPlayed:)
									at:
										(-
											(((Deck at: temp0) whenPlayed:)
												size:
											)
											1
										)
								)
								global225
							)
						)
						(= temp2 (Deck at: temp0))
						((temp2 owner:) eliminateCard: temp2)
						(temp2 inPlay: 1)
						(((temp2 previousHand:)
								at: (- ((temp2 previousHand:) size:) 1)
							)
							add: temp2
						)
						(if (> ((temp2 previousHand:) size:) 1)
							(for
								((= temp1 0))
								(< temp1 (- ((temp2 previousHand:) size:) 1))
								((++ temp1))
								
								(tempList
									add: ((temp2 previousHand:) at: temp1)
								)
							)
							((temp2 previousHand:) release:)
							(for
								((= temp1 0))
								(< temp1 (tempList size:))
								((++ temp1))
								
								((temp2 previousHand:)
									add: (tempList at: temp1)
								)
							)
							(tempList release:)
						else
							((temp2 previousHand:)
								delete:
									((temp2 previousHand:)
										at: (- ((temp2 previousHand:) size:) 1)
									)
							)
						)
						(break)
					)
				)
				(= global226 0)
			)
		)
	)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local6))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local5 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance dealList of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance hand1 of sHand
	(properties
		x 86
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 86
		cardLimit 13
		canPlay 1
		cardsUp 13
		whereTo 1
	)
)

(instance hand2 of sHand
	(properties
		x 157
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 157
		cardLimit 13
		canPlay 1
		cardsUp 13
		whereTo 1
	)
)

(instance hand3 of sHand
	(properties
		x 228
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 228
		cardLimit 13
		canPlay 1
		cardsUp 13
		whereTo 1
	)
)

(instance hand4 of sHand
	(properties
		x 299
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 299
		cardLimit 13
		canPlay 1
		cardsUp 13
		whereTo 1
	)
)

(instance found1 of sHand
	(properties
		x 419
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 419
		orgY 40
		whereTo 2
	)
)

(instance found2 of sHand
	(properties
		x 495
		y 40
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 495
		orgY 40
		whereTo 2
	)
)

(instance found3 of sHand
	(properties
		x 419
		y 125
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 419
		orgY 125
		whereTo 2
	)
)

(instance found4 of sHand
	(properties
		x 495
		y 125
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 495
		orgY 125
		whereTo 2
	)
)

(instance found5 of sHand
	(properties
		x 419
		y 210
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 419
		orgY 210
		whereTo 2
	)
)

(instance found6 of sHand
	(properties
		x 495
		y 210
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 495
		orgY 210
		whereTo 2
	)
)

(instance found7 of sHand
	(properties
		x 419
		y 295
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 419
		orgY 295
		whereTo 2
	)
)

(instance found8 of sHand
	(properties
		x 495
		y 295
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 3
		buildStep 1
		startRank 3
		wrapping 1
		orgX 495
		orgY 295
		whereTo 2
	)
)

(instance hardFound of sHand
	(properties
		x 191
		y 295
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 191
		orgY 295
		whereTo 1
	)

	(method (add param1)
		(super add: param1 &rest)
		(-- global928)
	)

	(method (eliminateCard param1)
		(super eliminateCard: param1 &rest)
		(++ global928)
	)

	(method (handleEvent event)
		(if (not size)
			(= global223 1)
			(if (and (super handleEvent: event) global222)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText:
						{Any available card from a Column\ncan be played to this Reserve, but cards\nfrom here can only be played to the\nFoundations.}
						6
						6
					init:
				)
			)
			(= global223 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance found1Empty of View
	(properties
		x 419
		y 40
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 495
		y 40
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 419
		y 125
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 495
		y 125
		view 915
		loop 9
	)
)

(instance found5Empty of View
	(properties
		x 419
		y 210
		view 915
		loop 9
	)
)

(instance found6Empty of View
	(properties
		x 495
		y 210
		view 915
		loop 9
	)
)

(instance found7Empty of View
	(properties
		x 419
		y 295
		view 915
		loop 9
	)
)

(instance found8Empty of View
	(properties
		x 495
		y 295
		view 915
		loop 9
	)
)

(instance hardFoundEmpty of View
	(properties
		x 191
		y 295
		view 915
		loop 9
	)
)

(instance theHands of Set
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance magView of View
	(properties)

	(method (init param1 param2)
		(= view 985)
		(= loop param1)
		(= cel param2)
		(= x 99)
		(= y 448)
		(super init: &rest)
	)
)

(instance gameName of View
	(properties
		x 220
		y 446
		priority 35
		view 977
		loop 10
	)
)

(instance currentScoreWindow of InvisibleWindow
	(properties
		left 421
		top 446
		right 577
		bottom 477
	)

	(method (init &tmp [temp0 2])
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 2 0 0 0 5 self)
		(proc6022_6 global928 86 11 1 {score} self)
	)
)

(instance timeWindow of InvisibleWindow
	(properties
		left 421
		top 446
		right 577
		bottom 477
	)

	(method (init &tmp [temp0 2])
		(= priority 4)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(= local12 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local10 59) (== local11 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local10 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local11 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 720
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 256)
		(= local18 1)
		(super init: &rest)
	)
)

