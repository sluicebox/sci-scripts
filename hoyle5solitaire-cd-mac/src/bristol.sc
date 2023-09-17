;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6014)
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
	bristol 0
	proc6014_1 1
	optionCode 2
	roomScript 3
	proc6014_4 4
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
)

(procedure (proc6014_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6014_4 param1) ; UNUSED
	(if argc
		(= local12 param1)
	else
		(return local12)
	)
)

(procedure (localproc_0)
	(if (== global927 0)
		(found1Hand buildOrder: 1)
		(found2Hand buildOrder: 1)
		(found3Hand buildOrder: 1)
		(found4Hand buildOrder: 1)
		(hand1 startRank: 0)
		(hand2 startRank: 0)
		(hand3 startRank: 0)
		(hand4 startRank: 0)
		(hand5 startRank: 0)
		(hand6 startRank: 0)
		(hand7 startRank: 0)
		(hand8 startRank: 0)
	else
		(found1Hand buildOrder: 4)
		(found2Hand buildOrder: 4)
		(found3Hand buildOrder: 4)
		(found4Hand buildOrder: 4)
		(hand1 startRank: 1)
		(hand2 startRank: 1)
		(hand3 startRank: 1)
		(hand4 startRank: 1)
		(hand5 startRank: 1)
		(hand6 startRank: 1)
		(hand7 startRank: 1)
		(hand8 startRank: 1)
	)
)

(instance bristol of HoyleRoom
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
			(gSound2 play: 805)
		)
		(= local11 0)
		(= gCardGameScriptNumber 6014)
		(= local12 0)
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
		((= global929 bristol_opt) doit:)
		(= picture (+ global877 global385))
		(= local23 global385)
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
		(if (== global927 1)
			(hand1 emptyView: hand1Empty)
			(hand1Empty setPri: 1 init: hide:)
			(hand2 emptyView: hand2Empty)
			(hand2Empty setPri: 1 init: hide:)
			(hand3 emptyView: hand3Empty)
			(hand3Empty setPri: 1 init: hide:)
			(hand4 emptyView: hand4Empty)
			(hand4Empty setPri: 1 init: hide:)
			(hand5 emptyView: hand5Empty)
			(hand5Empty setPri: 1 init: hide:)
			(hand6 emptyView: hand6Empty)
			(hand6Empty setPri: 1 init: hide:)
			(hand7 emptyView: hand7Empty)
			(hand7Empty setPri: 1 init: hide:)
			(hand8 emptyView: hand8Empty)
			(hand8Empty setPri: 1 init: hide:)
		)
		(found1Hand emptyView: found1Empty)
		(found2Hand emptyView: found2Empty)
		(found3Hand emptyView: found3Empty)
		(found4Hand emptyView: found4Empty)
		(waste1Hand growView: waste1Grow)
		(waste2Hand growView: waste2Grow)
		(waste3Hand growView: waste3Grow)
		(waste1Grow init:)
		(waste2Grow init:)
		(waste3Grow init:)
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
				found1Hand
				found2Hand
				found3Hand
				found4Hand
		)
		((= gTheFoundations theFoundations)
			add: found1Hand found2Hand found3Hand found4Hand
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: waste1Hand)
		(global929 doit: 3)
		(= local10 1)
		(= global928 0)
		(= local7 0)
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
			((not local12)
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
				local22
			)
			(event claimed: 1)
			(= local22 0)
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
		(= local11 0)
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
		(waste1Hand release: dispose:)
		(waste2Hand release: dispose:)
		(waste3Hand release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local22
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theHands dispose:)
		(theFoundations dispose:)
		(handleEventList release: dispose:)
		(if (== global927 1)
			(hand1Empty dispose:)
			(hand2Empty dispose:)
			(hand3Empty dispose:)
			(hand4Empty dispose:)
			(hand5Empty dispose:)
			(hand6Empty dispose:)
			(hand7Empty dispose:)
			(hand8Empty dispose:)
		)
		(found1Empty dispose:)
		(found2Empty dispose:)
		(found3Empty dispose:)
		(found4Empty dispose:)
		(waste1Grow dispose:)
		(waste2Grow dispose:)
		(waste3Grow dispose:)
		(if local17
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

(instance bristol_opt of File
	(properties
		name {bristol.opt}
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
									local12
									global927
									local15
									local16
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
				(= local12 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local15 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local16 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local12 0)
				(= global927 0)
				(= local15 59)
				(= local16 59)
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
			(= local15 59)
			(= local16 59)
			(global929 doit: 3)
			(if local17
				(proc6022_7 {bestminutes} timeWindow)
				(proc6022_7 {bestseconds} timeWindow)
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			)
		)
		(if (!= global385 local23)
			(if local17
				(proc6022_7 {back} timeWindow)
				(proc0_10 990 5 global385 0 0 1 timeWindow {back})
			else
				(proc6022_7 {back} currentScoreWindow)
				(proc0_10 990 5 global385 0 0 1 currentScoreWindow {back})
			)
			(= local23 global385)
		)
		(if
			(and
				global250
				local11
				(== state 5)
				(not local19)
				(not global253)
				local20
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
			(= local20 1)
		)
		(if (and local11 (== state 5))
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
						(magList add: waste1Hand waste2Hand waste3Hand)
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
			(if (and (not global250) (!= local21 global928))
				(proc6022_7 {score} currentScoreWindow)
				(proc6022_6 global928 86 11 1 {score} currentScoreWindow)
				(= local21 global928)
			)
			(if (== global928 52)
				(= local19 1)
				(if global250
					(= local13 global248)
					(if
						(or
							(< (= local14 global249) local15)
							(and (== local14 local15) (< local13 local16))
						)
						(= local15 local14)
						(= local16 local13)
						(= local18 1)
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local11 0)
				(= ticks (= ticks 1))
			)
			(1
				(= ticks 1)
			)
			(2
				(= ticks 10)
				(IconBar show:)
				(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 hand8)
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
				(= local11 0)
				(= local10 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) inPlay: 0)
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) numFromStock: 0)
				)
				(= global395 0)
				(Deck shuffle:)
				(localproc_0)
				(= local2 0)
				(= global243 0)
				(= local7 0)
				(= global928 0)
				(= local21 -1)
				(= global226 1)
				(= global252 -1)
				(= global248 0)
				(= global249 0)
				(= local19 0)
				(= global253 0)
				(= local18 0)
				(= local20 0)
				(sDealer deal: self)
			)
			(5
				(= local11 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local8 0)
				(found1Empty init: setPri: 1)
				(found2Empty init: setPri: 1)
				(found3Empty init: setPri: 1)
				(found4Empty init: setPri: 1)
				(handleEventList
					add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 hand8
				)
				(handleEventList
					add: found1Hand found2Hand found3Hand found4Hand
				)
				(handleEventList add: global419)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(handleEventList add: waste1Hand waste2Hand waste3Hand)
				(global419
					init:
					client: waste1Hand
					active: 1
					size: 28
					addKeyMouse:
				)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local7 1)
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
			(if ((Deck at: temp0) numFromStock:)
				(((Deck at: temp0) numFromStock:) release:)
				(((Deck at: temp0) numFromStock:) dispose:)
			)
			(if ((Deck at: temp0) tailList:)
				(((Deck at: temp0) tailList:) release:)
			)
			((Deck at: temp0) tailList: 0)
			((Deck at: temp0) whenPlayed: 0)
			((Deck at: temp0) previousHand: 0)
			((Deck at: temp0) numFromStock: 0)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(if (and local17 (!= global928 52))
			(proc6022_7 {seconds} timeWindow)
			(proc6022_7 {minutes} timeWindow)
		)
		(if local22
			(= local22 0)
			(tabView hide:)
		)
		(= local8 0)
		(gTheHands eachElementDo: #endHand)
		(waste1Hand endHand:)
		(waste2Hand endHand:)
		(waste3Hand endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release:)
		(dealList add: hand1 hand2 hand3 hand4 hand5 hand6 hand7 hand8)
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
		(if (not global498)
			(++ global221)
			(= global498 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(if (and global250 local18)
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
			(if (and (== local15 59) (== local16 59))
				(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
			else
				(proc6022_6 local15 70 20 1 {bestminutes} timeWindow)
				(proc6022_6 local16 92 20 1 {bestseconds} timeWindow)
			)
			(= local18 0)
		)
		(= local11 0)
		(proc6014_1 1)
		(if local10
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(= local10 1)
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
				(proc6014_1 1)
				(IconBarF lighten:)
				(if local10
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
					mode: 0
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
							(if
								(>
									((temp3 numFromStock:)
										at: (- ((temp3 numFromStock:) size:) 1)
									)
									1
								)
								(temp3 setNumFromStock: 0 1)
								(for ((= temp1 1)) (< temp1 3) ((++ temp1))
									(for
										((= temp0 0))
										(< temp0 (Deck size:))
										((++ temp0))
										
										(if
											(and
												((Deck at: temp0) whenPlayed:)
												(==
													(((Deck at: temp0)
															whenPlayed:
														)
														at:
															(-
																(((Deck
																			at:
																				temp0
																		)
																		whenPlayed:
																	)
																	size:
																)
																1
															)
													)
													global225
												)
												(==
													(((Deck at: temp0)
															previousHand:
														)
														at:
															(-
																(((Deck
																			at:
																				temp0
																		)
																		previousHand:
																	)
																	size:
																)
																1
															)
													)
													2
												)
											)
											(= temp3 (Deck at: temp0))
											(temp3 fromStock: 0)
											((temp3 owner:)
												eliminateCard: temp3
											)
											(temp3 hide:)
											(temp3 inPlay: 0)
											(if
												(>
													((temp3 previousHand:)
														size:
													)
													1
												)
												(for
													((= temp2 0))
													(<
														temp2
														(-
															((temp3
																	previousHand:
																)
																size:
															)
															1
														)
													)
													((++ temp2))
													
													(tempList
														add:
															((temp3
																	previousHand:
																)
																at: temp2
															)
													)
												)
												((temp3 previousHand:) release:)
												(for
													((= temp2 0))
													(< temp2 (tempList size:))
													((++ temp2))
													
													((temp3 previousHand:)
														add:
															(tempList at: temp2)
													)
												)
												(tempList release:)
											else
												((temp3 previousHand:)
													delete:
														((temp3 previousHand:)
															at:
																(-
																	((temp3
																			previousHand:
																		)
																		size:
																	)
																	1
																)
														)
												)
											)
											(resetStock doit:)
											(break)
										)
									)
									(if
										(==
											((temp3 numFromStock:)
												at:
													(-
														((temp3 numFromStock:)
															size:
														)
														1
													)
											)
											1
										)
										(temp3 setNumFromStock: 0 1)
										(break)
									else
										(temp3 setNumFromStock: 0 1)
									)
								)
								(break)
							)
							(temp3 setNumFromStock: 0 1)
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
								(break)
							)
							((temp3 previousHand:)
								delete:
									((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
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
			(if (or (sDealer script:) (not local11))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 600 15 128 0 (Random 1 2))
				else
					(gChar1 say: 600 15 128 0 2)
				)
			else
				(= local10 0)
				(cleanUp doit:)
			)
			(return 1)
		)
	)
)

(instance hand1 of sHand
	(properties
		x 60
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 60
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand1Empty of View
	(properties
		x 60
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 118
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 118
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand2Empty of View
	(properties
		x 118
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 176
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 176
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand3Empty of View
	(properties
		x 176
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 234
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 234
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand4Empty of View
	(properties
		x 234
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 293
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 293
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand5Empty of View
	(properties
		x 293
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 351
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 351
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand6Empty of View
	(properties
		x 351
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 410
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 410
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand7Empty of View
	(properties
		x 410
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance hand8 of sHand
	(properties
		x 468
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 468
		cardLimit 15
		buildOrder 2
		buildStep 1
		canTrack 1
		canPlay 1
		cardsUp 3
	)
)

(instance hand8Empty of View
	(properties
		x 468
		y 22
		priority 1
		view 915
		loop 8
	)
)

(instance waste1Hand of sHand
	(properties
		x 213
		y 318
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 213
		orgY 318
	)
)

(instance waste1Grow of View
	(properties
		x 213
		y 318
		priority 1
		view 915
		loop 4
	)
)

(instance waste2Hand of sHand
	(properties
		x 284
		y 318
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 284
		orgY 318
	)
)

(instance waste2Grow of View
	(properties
		x 284
		y 318
		priority 1
		view 915
		loop 4
	)
)

(instance waste3Hand of sHand
	(properties
		x 358
		y 318
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 4
		cardShow 1
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		canPlay 1
		orgX 358
		orgY 318
	)
)

(instance waste3Grow of View
	(properties
		x 358
		y 318
		priority 1
		view 915
		loop 4
	)
)

(instance found1Hand of sHand
	(properties
		x 528
		y 22
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		whereTo 2
	)
)

(instance found2Hand of sHand
	(properties
		x 528
		y 123
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		whereTo 2
	)
)

(instance found3Hand of sHand
	(properties
		x 528
		y 222
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		whereTo 2
	)
)

(instance found4Hand of sHand
	(properties
		x 528
		y 323
		handDirection 2
		faceUp 1
		autoSorting 0
		whatType 1
		cardShow 1
		cardLimit 13
		buildOrder 1
		buildStep 1
		startRank 2
		whereTo 2
	)
)

(instance found1Empty of View
	(properties
		x 528
		y 22
		view 915
		loop 9
	)
)

(instance found2Empty of View
	(properties
		x 528
		y 123
		view 915
		loop 9
	)
)

(instance found3Empty of View
	(properties
		x 528
		y 222
		view 915
		loop 9
	)
)

(instance found4Empty of View
	(properties
		x 528
		y 323
		view 915
		loop 9
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

(instance handleEventList of EventHandler
	(properties)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 72)
		(= y 308)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local8 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
					show:
				)
			)
			((< 4 size 9)
				(= local8 0)
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
				(= local8 0)
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
				(= local8 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local8 0)
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
		(= local6 0)
		(if (or (and (== (= local5 1) 1) size) (and (== local5 0) size))
			(-= size (if (> size 1) 3 else 1))
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
			(if (== local5 1)
				(= local6 1)
			)
			((ScriptID 15 6) ; littleCard
				hide:
				setMotion: MoveTo (client calcNextX:) (client calcNextY:) self
			)
			(= global116 0)
		else
			(EnableCursor)
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
				(if local6
					(= temp0 (getThree doit:))
				else
					(= temp0 (getOne doit:))
				)
				(= local6 0)
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

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local3 (Deck topCard:))
		(= local4 (theStock size:))
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 52) ((++ temp1))
			(if (not ((Deck at: temp1) inPlay:))
				(++ temp0)
			)
		)
		(theStock size: temp0)
		(theStock adjust:)
		(Deck topCard: 51)
	)
)

(instance getThree of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 0)
		(if (> (theStock size:) 0)
			(while (< temp1 3)
				(if (>= (Deck topCard:) 0)
					(= temp0 (Deck getCard:))
					(if (not (temp0 inPlay:))
						(++ temp1)
						(= temp2 temp0)
						(gSound play: 903)
						(temp0 flip: 1 init:)
						(temp0 fromStock: 1 setNumFromStock: temp1)
						(switch temp1
							(1
								((theStock client:) add: temp0)
								(theStock client: waste2Hand)
							)
							(2
								((theStock client:) add: temp0)
								(theStock client: waste3Hand)
							)
							(3
								((theStock client:) add: temp0)
								(theStock client: waste1Hand)
							)
						)
					)
				else
					(++ temp1)
				)
			)
		else
			(while (< temp1 1)
				(if (>= (Deck topCard:) 0)
					(= temp0 (Deck getCard:))
					(if (not (temp0 inPlay:))
						(++ temp1)
						(= temp2 temp0)
						(gSound play: 903)
						(temp0 flip: 1 init:)
						(temp0 fromStock: 1 setNumFromStock: 1)
						((theStock client:) add: temp0)
					)
				else
					(++ temp1)
				)
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
				((theStock client:) add: temp0)
				(++ temp1)
			)
		)
		(return temp0)
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
		loop 4
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
		(= local17 1)
		(super init:)
		(proc0_10 990 5 global385 0 0 1 self {back})
		(proc0_10 990 0 0 0 0 2 self)
		(proc0_10 979 12 11 131 5 15 self)
		(proc0_10 979 12 11 131 20 15 self)
		(proc6022_6 0 92 5 1 {seconds} timeWindow)
		(if (and (== local15 59) (== local16 59))
			(proc6022_6 0 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 0 92 20 1 {bestseconds} timeWindow)
		else
			(proc6022_6 local15 70 20 1 {bestminutes} timeWindow)
			(proc6022_6 local16 92 20 1 {bestseconds} timeWindow)
		)
	)
)

(instance tabView of View
	(properties
		view 714
	)

	(method (init)
		(self setPri: 255)
		(= local22 1)
		(super init: &rest)
	)
)

