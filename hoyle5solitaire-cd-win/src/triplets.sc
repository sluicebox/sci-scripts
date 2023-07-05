;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6026)
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
	triplets 0
	proc6026_1 1
	optionCode 2
	roomScript 3
	proc6026_4 4
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
	local20
)

(procedure (proc6026_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6026_4 param1) ; UNUSED
	(if argc
		(= local7 param1)
	else
		(return local7)
	)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp0 (param1 rank:))
	(= temp1 (param2 rank:))
	(= temp2 (param3 rank:))
	(if (or (== temp0 temp1) (== temp0 temp2) (== temp1 temp2))
		(return 0)
	)
	(if
		(and
			(== global927 1)
			(or
				(== (param1 suit:) (param2 suit:))
				(== (param1 suit:) (param3 suit:))
				(== (param2 suit:) (param3 suit:))
			)
		)
		(return 0)
	)
	(if
		(or
			(and
				(or (== temp0 12) (== temp1 12) (== temp2 12))
				(or (== temp0 13) (== temp1 13) (== temp2 13))
				(or (== temp0 1) (== temp1 1) (== temp2 1))
			)
			(and
				(or (== temp0 13) (== temp1 13) (== temp2 13))
				(or (== temp0 1) (== temp1 1) (== temp2 1))
				(or (== temp0 2) (== temp1 2) (== temp2 2))
			)
		)
		(return 1)
	)
	(if
		(and
			(or
				(== temp0 (+ temp1 1))
				(== temp0 (- temp1 1))
				(== temp0 (+ temp2 1))
				(== temp0 (- temp2 1))
			)
			(or
				(== temp1 (+ temp2 1))
				(== temp1 (- temp2 1))
				(== temp1 (+ temp0 1))
				(== temp1 (- temp0 1))
			)
			(or
				(== temp2 (+ temp0 1))
				(== temp2 (- temp0 1))
				(== temp2 (+ temp1 1))
				(== temp2 (- temp1 1))
			)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (- (gTheHands size:) 1)) ((++ temp0))
		(if
			(and
				((gTheHands at: temp0) size:)
				(== (((gTheHands at: temp0) at: 0) rank:) 13)
			)
			(return 1)
		)
	)
	(return 0)
)

(instance triplets of HoyleRoom
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
			(gSound2 play: 827)
		)
		(= local6 0)
		(= gCardGameScriptNumber 6026)
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
		((= global929 triplets_opt) doit:)
		(= picture (+ global877 global385))
		(= local20 global385)
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
		(hand5 add: owner: 0)
		(hand6 add: owner: 0)
		(hand7 add: owner: 0)
		(hand8 add: owner: 0)
		(hand9 add: owner: 0)
		(hand10 add: owner: 0)
		(hand11 add: owner: 0)
		(hand12 add: owner: 0)
		(hand13 add: owner: 0)
		(hand14 add: owner: 0)
		(hand15 add: owner: 0)
		(hand16 add: owner: 0)
		(hand17 add: owner: 0)
		(hand18 add: owner: 0)
		(found1Hand emptyView: found1Empty)
		(found1Hand growView: found1Grow)
		(found1Grow init: setPri: 1)
		((= gTheHands theHands)
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				hand11
				hand12
				hand13
				hand14
				hand15
				hand16
				hand17
				hand18
				found1Hand
		)
		((= gTheFoundations theFoundations) add: found1Hand)
		(handleEventList add:)
		(Deck init: pCard)
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
				local19
			)
			(event claimed: 1)
			(= local19 0)
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
		(handleEventList release: dispose:)
		(found1Empty dispose:)
		(found1Grow dispose:)
		(if local19
			(tabView hide: dispose:)
		)
		(if local14
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

(instance triplets_opt of File
	(properties
		name {triplets.opt}
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
									local12
									local13
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
				(= local12 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local13 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local7 0)
				(= global927 0)
				(= local12 59)
				(= local13 59)
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
			(= local12 59)
			(= local13 59)
			(global929 doit: 3)
			(if local14
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local20)
			(if local14
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local20 global385)
		)
		(if
			(and
				global250
				local6
				(== state 5)
				(not local16)
				(not global253)
				local17
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
			(= local17 1)
		)
		(if (and local6 (== state 5))
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
			(if (and (not global250) (!= local18 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local18 global928)
			)
			(if (== global928 51)
				(= global928 52)
				(if (localproc_1)
					(*= global928 3)
				)
				(= local16 1)
				(if global250
					(= local10 global248)
					(if
						(or
							(< (= local11 global249) local12)
							(and (== local11 local12) (< local10 local13))
						)
						(= local12 local11)
						(= local13 local10)
						(= local15 1)
						(global929 doit: 3)
					)
				else
					(proc6022_7 {score} currentScoreWindow)
					(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				)
				(endCode doit:)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 [temp2 2])
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
				(dealList
					add:
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
						hand8
						hand9
						hand10
						hand11
						hand12
						hand13
						hand14
						hand15
						hand16
						hand17
						hand18
				)
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
				(= global226 1)
				(= global395 0)
				(Deck shuffle:)
				(= local2 0)
				(= global243 0)
				(= global928 0)
				(= local18 -1)
				(= local8 0)
				(= local9 0)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local16 0)
				(= global253 0)
				(= local15 0)
				(= local17 0)
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
				(handleEventList
					add:
						hand1
						hand2
						hand3
						hand4
						hand5
						hand6
						hand7
						hand8
						hand9
						hand10
						hand11
						hand12
						hand13
						hand14
						hand15
						hand16
						hand17
						hand18
				)
				(handleEventList add: found1Hand)
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
		(if (and local14 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local19
			(= local19 0)
			(tabView hide:)
		)
		(= local3 0)
		(gTheHands eachElementDo: #endHand)
		((KeyMouse objList:) release:)
		(handleEventList release:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(dealList
			add:
				hand1
				hand2
				hand3
				hand4
				hand5
				hand6
				hand7
				hand8
				hand9
				hand10
				hand11
				hand12
				hand13
				hand14
				hand15
				hand16
				hand17
				hand18
		)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (< global928 52)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global520)
			(++ global221)
			(= global520 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local15)
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
			(if (and (== local12 59) (== local13 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local12 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local13 92 20 1 {bestseconds} timeWindow)
			)
			(= local15 0)
		)
		(= local6 0)
		(proc6026_1 1)
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
		(if (and (!= global928 52) (super handleEvent: event))
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(handleEventList delete: self)
				(IconBarF darken:)
				(proc6026_1 1)
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (and (!= global928 52) (super handleEvent: event))
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
				(= temp3 0)
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
						(= temp0 -1)
						(if (== (++ temp3) 3)
							(break)
						)
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

(class pHand of sHand
	(properties)

	(method (handleCard param1 param2 &tmp temp0 temp1 [temp2 4] temp6 temp7 temp8)
		(return
			(if
				(and
					(not (param1 claimed:))
					(not global395)
					(= temp0 (param2 reverseFirstTrue: 165 param1))
				)
				(= temp1 (param2 indexOf: temp0))
				(cond
					(
						(and
							(== (param2 tailMove:) 0)
							(!= temp1 (- (param2 size:) 1))
						)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{No Packed Card moves allowed.\nOnly the top card of a Column\nis playable.}
									6
									6
								init:
							)
						)
						(return 1)
					)
					(
						(and
							(or
								(== (param2 tailMove:) 1)
								(== (param2 tailMove:) 2)
							)
							(!= temp1 (- (param2 size:) 1))
							(not (param2 pBuild: temp0))
						)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{Not a complete set of Packed Cards.}
									6
									6
								init:
							)
						)
						(return 1)
					)
					((== (param2 whereTo:) 2)
						(= global920 1)
						(gChar1 sayReg: 600 15 130 0 (Random 1 2))
						(if global222
							(Print
								ticks: 400
								fore: 0
								mode: 0
								addBitmap: 917 4 0
								font: gUserFont
								addText:
									{You can't play cards from the\nFoundation.}
									6
									6
								init:
							)
						)
						(return 1)
					)
				)
				(= global399 0)
				(if (= temp1 (param2 indexOf: temp0))
					((= global399 (param2 at: (- temp1 1))) setLoop: 0)
				)
				(if (not (temp0 faceUp:))
					(temp0 flip: 1)
				)
				(if
					(and
						(== (= temp7 (temp0 processEvent: param1 global399)) 1)
						(& (param1 modifiers:) $0003)
					)
					(= temp6 2)
				else
					(= temp6 temp7)
				)
				(cond
					(
						(and
							local8
							local9
							(!= local8 temp0)
							(!= local9 temp0)
							(localproc_0 local8 local9 temp0)
						)
						((local8 owner:) eliminateCard: local8)
						((local9 owner:) eliminateCard: local9)
						((temp0 owner:) eliminateCard: temp0)
						(found1Hand add: local8)
						(found1Hand add: local9)
						(found1Hand add: temp0)
						(= local8 0)
						(= local9 0)
					)
					((== local8 temp0)
						(local8 loop: 0)
						(= local8 0)
					)
					((== local9 temp0)
						(local9 loop: 0)
						(= local9 0)
					)
					((and local8 (== local9 0))
						(= local9 temp0)
						(local9 loop: 1)
					)
					((and local9 (== local8 0))
						(= local8 temp0)
						(local8 loop: 1)
					)
					((and (== local8 0) (== local9 0))
						(= local8 temp0)
						(local8 loop: 1)
					)
					(else
						(local8 loop: 0)
						(local9 loop: 0)
						(= local8 temp0)
						(= local9 0)
					)
				)
			)
		)
	)
)

(instance hand1 of pHand
	(properties
		x 80
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 80
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand2 of pHand
	(properties
		x 147
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 147
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand3 of pHand
	(properties
		x 214
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 214
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand4 of pHand
	(properties
		x 281
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 281
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand5 of pHand
	(properties
		x 348
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 348
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand6 of pHand
	(properties
		x 415
		y 43
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 415
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand7 of pHand
	(properties
		x 80
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 80
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand8 of pHand
	(properties
		x 147
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 147
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand9 of pHand
	(properties
		x 214
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 214
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand10 of pHand
	(properties
		x 281
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 281
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand11 of pHand
	(properties
		x 348
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 348
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand12 of pHand
	(properties
		x 415
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 415
		cardLimit 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 2
		whereTo 1
	)
)

(instance hand13 of pHand
	(properties
		x 80
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 80
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand14 of pHand
	(properties
		x 147
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 147
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand15 of pHand
	(properties
		x 214
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 214
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand16 of pHand
	(properties
		x 281
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 281
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand17 of pHand
	(properties
		x 348
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 348
		cardLimit 3
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
		whereTo 1
	)
)

(instance hand18 of pHand
	(properties
		x 415
		y 265
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 415
		cardLimit 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 2
		whereTo 1
	)
)

(instance found1Hand of sHand
	(properties
		x 508
		y 154
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 508
		orgY 154
		whereTo 2
	)
)

(instance found1Empty of View
	(properties
		x 508
		y 154
		view 915
		loop 9
	)
)

(instance found1Grow of View
	(properties
		x 508
		y 154
		view 915
		loop 4
	)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance dealList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(class pCard of sCard
	(properties
		leftChild 0
		rightChild 0
	)

	(method (track &tmp temp0)
		(self loop: 1)
		(gAniList release:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 0)
		(if (not (event claimed:))
			(= temp1 (+ y nsTop))
			(= temp2 (+ x nsLeft))
			(if owner
				(if (== (owner whatType:) 0)
					(= temp5 self)
				else
					(= temp5 (== (owner indexOf: self) (- (owner size:) 1)))
				)
				(if (or (== global394 5) (== global394 6))
					(= temp5 1)
				)
				(switch (owner handDirection:)
					(1
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x nsLeft (- global396 1)))
						)
					)
					(2
						(if temp5
							(= temp3 (+ y (- nsBottom 1)))
							(= temp4 (+ x (- nsRight 1)))
						else
							(= temp3 (+ y nsTop (- global397 1)))
							(= temp4 (+ x (- nsRight 1)))
						)
					)
				)
				(if
					(and
						(<= temp2 (event x:) temp4)
						(<= temp1 (event y:) temp3)
					)
					(cond
						((proc0_2 event)
							(event claimed: 1)
							(= temp0 1)
						)
						((& (event type:) evMOUSEBUTTON)
							(event claimed: 1)
							(= temp0 1)
						)
					)
				)
			)
		)
		(if temp0 self else 0)
	)
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
		loop 26
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
		(= local14 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local12 59) (== local13 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local12 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local13 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 736
	)

	(method (init)
		(self setPri: 256)
		(= local19 1)
		(super init: &rest)
	)
)

