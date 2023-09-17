;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6025)
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
(use Motion)
(use File)
(use Actor)
(use System)

(public
	pyramid 0
	proc6025_1 1
	optionCode 2
	roomScript 3
	proc6025_4 4
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
	local21
	local22
	local23
	local24
	local25
	local26
)

(procedure (proc6025_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6025_4 param1) ; UNUSED
	(if argc
		(= local14 param1)
	else
		(return local14)
	)
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(if (== ((param1 owner:) whatType:) 0)
		(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
			(= temp1 (hand1 at: temp0))
			(if (== (temp1 leftChild:) param1)
				(temp1 leftChild: 0)
			)
			(if (== (temp1 rightChild:) param1)
				(temp1 rightChild: 0)
			)
		)
	)
	(if (and (== argc 2) (== ((param2 owner:) whatType:) 0))
		(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
			(= temp1 (hand1 at: temp0))
			(if (== (temp1 leftChild:) param2)
				(temp1 leftChild: 0)
			)
			(if (== (temp1 rightChild:) param2)
				(temp1 rightChild: 0)
			)
		)
	)
)

(instance pyramid of HoyleRoom
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
			(gSound2 play: 821)
		)
		(= local13 0)
		(= gCardGameScriptNumber 6025)
		(= local14 0)
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
		((= global929 pyramid_opt) doit:)
		(= picture (+ global877 global385))
		(= local26 global385)
		(= local7 0)
		(= local8 0)
		(if (== global927 0)
			(= local2 17)
		else
			(= local2 24)
		)
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
		(hand1 emptyView: hand1Empty)
		(hand1Empty setPri: 1 init: hide:)
		(found1Hand growView: foundGrow)
		(foundGrow init: setPri: 1)
		(wasteHand emptyView: wasteEmpty)
		(found1Hand emptyView: found1Empty)
		((= gTheHands theHands)
			add:
				hand1
				found1Hand
				reserve1Hand
				reserve2Hand
				reserve3Hand
				reserve4Hand
				reserve5Hand
				reserve6Hand
				reserve7Hand
		)
		((= gTheFoundations theFoundations) add: found1Hand)
		(handleEventList add:)
		(Deck init: pCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: flipHand)
		(global929 doit: 3)
		(= local12 1)
		(= global928 0)
		(= local6 0)
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
			((not local14)
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
				local25
			)
			(event claimed: 1)
			(= local25 0)
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
		(= local13 0)
		(= global418 0)
		(gDelayCast release:)
		(= global419 0)
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
		(flipHand release: dispose:)
		(wasteHand release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local25
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theHands dispose:)
		(theFoundations dispose:)
		(handleEventList release: dispose:)
		(hand1Empty dispose:)
		(wasteEmpty dispose:)
		(foundGrow dispose:)
		(found1Empty dispose:)
		(if local20
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

(instance pyramid_opt of File
	(properties
		name {pyramid.opt}
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
									local14
									global927
									local18
									local19
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
				(= local14 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local18 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local19 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local14 0)
				(= global927 0)
				(= local18 59)
				(= local19 59)
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
			(= local18 59)
			(= local19 59)
			(global929 doit: 3)
			(if local20
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local26)
			(if local20
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local26 global385)
		)
		(if
			(and
				global250
				local13
				(== state 5)
				(not local22)
				(not global253)
				local23
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
			(= local23 1)
		)
		(if (and local13 (== state 5) (not global458))
			(cond
				(global109
					(if (not local1)
						(Load rsVIEW 985)
						(for
							((= temp1 0))
							(< temp1 (gTheHands size:))
							((++ temp1))
							
							(magList add: (gTheHands at: temp1))
						)
						(magList add: flipHand wasteHand)
						(= local1 1)
					)
					(for ((= temp1 0)) (< temp1 (magList size:)) ((++ temp1))
						(for
							((= temp2 (- ((magList at: temp1) size:) 1)))
							(> temp2 -1)
							((-- temp2))
							
							(= temp5 ((magList at: temp1) at: temp2))
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
					(magList release: dispose:)
					(magView hide:)
				)
			)
			(if (and (not global250) (!= local24 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local24 global928)
			)
			(if (== global928 52)
				(= local22 1)
				(if global250
					(= local16 global248)
					(if
						(or
							(< (= local17 global249) local18)
							(and (== local17 local18) (< local16 local19))
						)
						(= local18 local17)
						(= local19 local16)
						(= local21 1)
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

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(= local13 0)
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
				(if (== global927 0)
					(dealList
						add:
							reserve1Hand
							reserve2Hand
							reserve3Hand
							reserve4Hand
							reserve5Hand
							reserve6Hand
							reserve7Hand
							hand1
					)
				else
					(dealList add: hand1)
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
				(= local13 0)
				(= local12 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
					((Deck at: temp1) leftChild: 0)
					((Deck at: temp1) rightChild: 0)
					((Deck at: temp1) prevLeftChild: 0)
					((Deck at: temp1) prevRightChild: 0)
				)
				(if (origHand1 size:)
					(origHand1 release:)
				)
				(= global395 0)
				(Deck shuffle:)
				(= local3 0)
				(= global243 0)
				(= local6 0)
				(= global928 0)
				(= local24 -1)
				(= global226 1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local22 0)
				(= global253 0)
				(= local21 0)
				(= local23 0)
				(sDealer deal: self)
			)
			(5
				(= temp4 1)
				(for ((= temp2 1)) (< temp2 7) ((++ temp2))
					(for ((= temp3 1)) (<= temp3 temp2) ((++ temp3))
						((hand1 at: (- temp4 1))
							leftChild: (hand1 at: (- (+ temp4 temp2) 1))
						)
						((hand1 at: (- temp4 1))
							rightChild: (hand1 at: (+ temp4 temp2))
						)
						((hand1 at: (- temp4 1))
							prevLeftChild: ((hand1 at: (- temp4 1)) leftChild:)
						)
						((hand1 at: (- temp4 1))
							prevRightChild:
								((hand1 at: (- temp4 1)) rightChild:)
						)
						(++ temp4)
					)
				)
				(= local13 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local10 0)
				(wasteEmpty init: setPri: 1)
				(found1Empty init: setPri: 1)
				(handleEventList add: hand1)
				(handleEventList add: found1Hand)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(handleEventList add: flipHand wasteHand)
				(for ((= temp1 0)) (< temp1 (hand1 size:)) ((++ temp1))
					(origHand1 add: (hand1 at: temp1))
				)
				(if (== global927 0)
					(handleEventList
						add:
							reserve1Hand
							reserve2Hand
							reserve3Hand
							reserve4Hand
							reserve5Hand
							reserve6Hand
							reserve7Hand
					)
				)
				(global419
					init:
					client: flipHand
					active: 1
					size: local2
					addKeyMouse:
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local6 1)
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
			((Deck at: temp0) leftChild: 0)
			((Deck at: temp0) rightChild: 0)
		)
		(if (origHand1 size:)
			(origHand1 release:)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local20 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local25
			(= local25 0)
			(tabView hide:)
		)
		(= local10 0)
		(gTheHands eachElementDo: #endHand)
		(flipHand endHand:)
		(wasteHand endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(if (== global927 0)
			(dealList
				add:
					reserve1Hand
					reserve2Hand
					reserve3Hand
					reserve4Hand
					reserve5Hand
					reserve6Hand
					reserve7Hand
					hand1
			)
		else
			(dealList add: hand1)
		)
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
		(if (not global514)
			(++ global221)
			(= global514 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local21)
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
			(if (and (== local18 59) (== local19 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local18 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local19 92 20 1 {bestseconds} timeWindow)
			)
			(= local21 0)
		)
		(= local13 0)
		(proc6025_1 1)
		(if local12
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local12 1)
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
				(proc6025_1 1)
				(IconBarF lighten:)
				(if local12
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and (!= global928 52) (not global226) (super handleEvent: event))
			(event claimed: 1)
			(if (== global225 0)
				(Print
					ticks: 400
					fore: 0
					mode: 0
					addBitmap: 917 4 0
					font: gUserFont
					addText: {Unable to undo last move.} 10 10
					init:
				)
			else
				(= global226 1)
				(= local15 0)
				(= temp4 0)
				(= temp5 0)
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
						(= temp3 (Deck at: temp0))
						(if
							(==
								((temp3 previousHand:)
									at: (- ((temp3 previousHand:) size:) 1)
								)
								2
							)
							(temp3 fromStock: 0)
							((temp3 owner:) eliminateCard: temp3)
							(temp3 hide:)
							(temp3 inPlay: 0)
							(if (> ((temp3 previousHand:) size:) 1)
								(for
									((= temp1 0))
									(<
										temp1
										(- ((temp3 previousHand:) size:) 1)
									)
									((++ temp1))
									
									(tempList
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (tempList size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (tempList at: temp1)
									)
								)
								(tempList release:)
							else
								((temp3 previousHand:)
									delete:
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
								)
							)
							(if (< (theStock size:) 1)
								(handleEventList add: global419)
								((ScriptID 15 7) show:) ; stockBack
							)
							(resetStock doit:)
							(break)
						else
							(if
								(and
									(== ((temp3 owner:) whatType:) 1)
									(!= (temp3 rank:) 13)
								)
								(++ temp4)
							)
							(if
								(==
									((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
									)
									hand1
								)
								(temp3 leftChild: (temp3 prevLeftChild:))
								(temp3 rightChild: (temp3 prevRightChild:))
								((temp3 owner:) eliminateCard: temp3)
								(temp3 inPlay: 1)
								(for
									((= temp1 0))
									(< temp1 (found1Hand size:))
									((++ temp1))
									
									(temp2List add: (found1Hand at: temp1))
								)
								(if (found1Hand size:)
									(found1Hand release:)
								)
								(hand1 release:)
								(for
									((= temp1 0))
									(< temp1 (origHand1 size:))
									((++ temp1))
									
									(hand1 add: (origHand1 at: temp1))
								)
								(for
									((= temp1 0))
									(< temp1 (temp2List size:))
									((++ temp1))
									
									(for
										((= temp2 0))
										(< temp2 (hand1 size:))
										((++ temp2))
										
										(if
											(and
												(==
													((hand1 at: temp2) rank:)
													((temp2List at: temp1)
														rank:
													)
												)
												(==
													((hand1 at: temp2) suit:)
													((temp2List at: temp1)
														suit:
													)
												)
											)
											(hand1
												delete: (temp2List at: temp1)
											)
											(break)
										else
											((hand1 at: temp2)
												leftChild:
													((hand1 at: temp2)
														prevLeftChild:
													)
											)
											((hand1 at: temp2)
												rightChild:
													((hand1 at: temp2)
														prevRightChild:
													)
											)
										)
									)
								)
								(for
									((= temp1 0))
									(< temp1 (temp2List size:))
									((++ temp1))
									
									(found1Hand add: (temp2List at: temp1))
								)
								(if (temp2List size:)
									(temp2List release:)
								)
								(if (> ((temp3 previousHand:) size:) 1)
									(for
										((= temp1 0))
										(<
											temp1
											(- ((temp3 previousHand:) size:) 1)
										)
										((++ temp1))
										
										(tempList
											add:
												((temp3 previousHand:)
													at: temp1
												)
										)
									)
									((temp3 previousHand:) release:)
									(for
										((= temp1 0))
										(< temp1 (tempList size:))
										((++ temp1))
										
										((temp3 previousHand:)
											add: (tempList at: temp1)
										)
									)
									(tempList release:)
								else
									((temp3 previousHand:)
										delete:
											((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
									)
								)
								(if (== temp4 1)
									(= temp0 -1)
								)
							else
								((temp3 owner:) eliminateCard: temp3)
								(temp3 inPlay: 1)
								(((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
									)
									add: temp3
								)
								(if (> ((temp3 previousHand:) size:) 1)
									(for
										((= temp1 0))
										(<
											temp1
											(- ((temp3 previousHand:) size:) 1)
										)
										((++ temp1))
										
										(tempList
											add:
												((temp3 previousHand:)
													at: temp1
												)
										)
									)
									((temp3 previousHand:) release:)
									(for
										((= temp1 0))
										(< temp1 (tempList size:))
										((++ temp1))
										
										((temp3 previousHand:)
											add: (tempList at: temp1)
										)
									)
									(tempList release:)
								else
									((temp3 previousHand:)
										delete:
											((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
									)
								)
								(if (== temp4 1)
									(= temp0 -1)
								)
							)
							(if (or (not temp4) (== temp4 2))
								(break)
							)
						)
					)
				)
				(if
					(or
						(== temp4 2)
						(and (== (temp3 rank:) 13) (== (temp3 owner:) hand1))
					)
					(for ((= temp1 0)) (< temp1 (hand1 size:)) ((++ temp1))
						(if
							(not
								(hand1 contains: ((hand1 at: temp1) leftChild:))
							)
							((hand1 at: temp1) leftChild: 0)
						)
						(if
							(not
								(hand1
									contains: ((hand1 at: temp1) rightChild:)
								)
							)
							((hand1 at: temp1) rightChild: 0)
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
			(if (or (sDealer script:) (not local13))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local12 0)
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
							(== (param2 whatType:) 0)
							(or (temp0 leftChild:) (temp0 rightChild:))
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
									{This card is covered and thus\nunavailable.}
									6
									6
								init:
							)
						)
						(return 1)
					)
					(
						(and
							(== (param2 tailMove:) 0)
							(!= temp1 (- (param2 size:) 1))
							(!= (param2 whatType:) 0)
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
									{No Packed Card moves allowed.\nOnly the top card of this Reserve pile\ncan be played.}
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
				(if local15
					(cond
						((== (+ (local15 rank:) (temp0 rank:)) 13)
							(localproc_0 local15 temp0)
							((local15 owner:) eliminateCard: local15)
							((temp0 owner:) eliminateCard: temp0)
							(found1Hand add: temp0)
							(found1Hand add: local15)
							(= local15 0)
						)
						((== local15 temp0)
							(local15 loop: 0)
							(= local15 0)
						)
						(else
							(local15 loop: 0)
							(= local15 temp0)
						)
					)
				else
					(= local15 temp0)
					(local15 loop: 1)
				)
				(if (and local15 (== (local15 rank:) 13))
					(localproc_0 local15)
					((local15 owner:) eliminateCard: local15)
					(found1Hand add: local15)
					(= local15 0)
				)
			)
		)
	)
)

(instance hand1 of pHand
	(properties
		x 251
		y 31
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 251
		cardLimit 13
		buildOrder 7
		buildStep 1
		startRank 1
		canTrack 1
		canPlay 1
		cardsUp 28
	)

	(method (calcNextX)
		(return
			(cond
				((== size 0) 251)
				((== size 1) 221)
				((== size 3) 191)
				((== size 6) 161)
				((== size 10) 131)
				((== size 15) 101)
				((== size 21) 71)
				(else
					(+ ((self lastCrd:) x:) 60)
				)
			)
		)
	)

	(method (calcNextY)
		(return
			(cond
				((< size 1) 31)
				((< size 3) 61)
				((< size 6) 91)
				((< size 10) 121)
				((< size 15) 151)
				((< size 21) 181)
				(else 211)
			)
		)
	)
)

(instance hand1Empty of View
	(properties
		x 251
		y 31
		priority 1
		view 915
		loop 8
	)
)

(instance flipHand of pHand
	(properties
		x 527
		y 33
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 2
		cardShow 1
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 527
		orgY 33
	)

	(method (add param1 &tmp temp0)
		(if size
			(= temp0 (self at: 0))
			(self eliminateCard: temp0)
			(wasteHand add: temp0)
		)
		(super add: param1)
		(if local15
			(local15 loop: 0)
			(= local15 0)
		)
	)
)

(instance wasteHand of pHand
	(properties
		x 527
		y 116
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
	)
)

(instance wasteEmpty of View
	(properties
		x 527
		y 116
		priority 1
		view 915
		loop 8
	)
)

(instance reserve1Hand of pHand
	(properties
		x 65
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve2Hand of pHand
	(properties
		x 127
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve3Hand of pHand
	(properties
		x 189
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve4Hand of pHand
	(properties
		x 251
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve5Hand of pHand
	(properties
		x 313
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve6Hand of pHand
	(properties
		x 375
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance reserve7Hand of pHand
	(properties
		x 437
		y 320
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 3
		cardLimit 1
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		cardsUp 1
	)
)

(instance found1Hand of sHand
	(properties
		x 58
		y 54
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
		orgX 58
		orgY 54
		whereTo 2
	)

	(method (handleEvent event)
		(= global223 1)
		(if (and (super handleEvent: event) global222)
			(Print
				ticks: 400
				fore: 0
				mode: 0
				addBitmap: 917 4 0
				font: gUserFont
				addText:
					{You can't play cards from the\nFoundation. The Foundation is built up\nby selecting available cards whose\nranks sum to 13. Kings are sent\nright to the Foundation when selected.}
					6
					6
				init:
			)
		)
		(= global223 0)
	)
)

(instance found1Empty of View
	(properties
		x 58
		y 54
		view 915
		loop 9
	)
)

(instance foundGrow of View
	(properties
		x 58
		y 54
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

(instance magList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance origHand1 of List
	(properties)
)

(instance temp2List of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 434)
		(= y 20)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local10 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
					show:
				)
			)
			((< 4 size 9)
				(= local10 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
					show:
				)
			)
			((< 0 size 5)
				(handleEventList add: global419)
				(= local10 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
					show:
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(handleEventList delete: global419)
				(= local10 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local10 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
					show:
				)
			)
		)
	)

	(method (getCard)
		(DisableCursor)
		(= local9 0)
		(if (or (and (== local7 1) size) (and (== local7 0) size))
			(-= size (if (== local7 1) 3 else 1))
			(if (< size 0)
				(= size 0)
			)
			(++ cardsTaken)
			((ScriptID 15 6) ; littleCard
				view: (+ 54 global384)
				posn: (+ x 18) (+ y 22)
				init:
			)
			(self adjust:)
			(= global395 1)
			(if (== local7 1)
				(= local9 1)
			)
			((ScriptID 15 6) ; littleCard
				hide:
				setMotion: MoveTo (client calcNextX:) (client calcNextY:) self
			)
			(= global116 0)
		else
			(EnableCursor)
			(timesThru doit:)
		)
	)

	(method (cue)
		(self setScript: stockScript)
	)
)

(instance stockScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if local9
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local9 0)
				(UpdateScreenItem temp0)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global395 0)
				(= cycles 1)
			)
			(2
				(EnableCursor)
			)
		)
	)
)

(instance getThree of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(while (< temp1 3)
			(if (>= (Deck topCard:) 0)
				(= temp0 (Deck getCard:))
				(if (not (temp0 inPlay:))
					(++ temp1)
					(= temp2 temp0)
					(gSound play: 903)
					(temp0 flip: 1 init:)
					((theStock client:) add: temp0)
				)
			else
				(++ temp1)
			)
		)
		(return temp2)
	)
)

(instance getOne of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
				(temp0 flip: 1 show: init:)
				(temp0 fromStock: 1)
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local4 (Deck topCard:))
		(= local5 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance timesThru of Code
	(properties)

	(method (doit)
		(cond
			((== local8 0)
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 126 0 (Random 1 2))
				else
					(gChar1 say: 600 15 126 0 2)
				)
			)
			((== local8 1)
				(if (>= (++ local3) 3)
					(= global920 1)
					(if global896
						(gChar1 sayReg: 600 15 127 0 (Random 1 2))
					else
						(gChar1 say: 600 15 127 0 2)
					)
				else
					(resetStock doit:)
					(if
						(not
							(and
								(== (theStock size:) 0)
								(== ((theStock client:) size:) 0)
							)
						)
						(handleEventList add: global419)
					)
				)
			)
			(else
				(= local3 0)
				(resetStock doit:)
				(if
					(not
						(and
							(== (theStock size:) 0)
							(== ((theStock client:) size:) 0)
						)
					)
					(handleEventList add: global419)
				)
			)
		)
	)
)

(class pCard of sCard
	(properties
		leftChild 0
		rightChild 0
		prevLeftChild 0
		prevRightChild 0
	)

	(method (setNSRect &tmp temp0)
		(if (not (self owner:))
			(return)
		)
		(= temp0 ((self owner:) handDirection:))
		(cond
			((== ((self owner:) whatType:) 0)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: 77)
			)
			((== ((self owner:) lastCrd:) self)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: 77)
			)
			((== temp0 1)
				(self nsLeft: 0 nsRight: global396 nsTop: 0 nsBottom: 77)
			)
			((== temp0 2)
				(self nsLeft: 0 nsRight: 54 nsTop: 0 nsBottom: global397)
			)
		)
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
		loop 20
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
		(= local20 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local18 59) (== local19 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local18 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local19 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 730
	)

	(method (init)
		(if (== global927 0)
			(= cel 0)
		else
			(= cel 1)
		)
		(self setPri: 256)
		(= local25 1)
		(super init: &rest)
	)
)

