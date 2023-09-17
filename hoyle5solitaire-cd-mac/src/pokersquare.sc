;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6027)
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
	pokersquare 0
	proc6027_1 1
	optionCode 2
	roomScript 3
	proc6027_4 4
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
	local17 = -1
	local18
	local19
)

(procedure (proc6027_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(if ((gTheHands at: temp0) size:)
		else
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(= temp2 0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(++ temp2)
			(tempList add: ((gTheHands at: (- temp2 1)) at: 0))
		)
		(KList 22 (tempList elements:) 793 1) ; Sort
		(localproc_2 tempList)
		(tempList release:)
	)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp2 temp0)
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(+= temp2 5)
			(tempList add: ((gTheHands at: (- temp2 5)) at: 0))
		)
		(KList 22 (tempList elements:) 793 1) ; Sort
		(localproc_2 tempList)
		(tempList release:)
	)
)

(procedure (localproc_2 param1)
	(if (localproc_3 param1)
		(+= global928 100)
		(return)
	)
	(if (and (localproc_4 param1) (localproc_5 param1))
		(+= global928 60)
		(return)
	)
	(if (== (= local12 (localproc_6 param1)) 1)
		(+= global928 30)
		(return)
	)
	(if (== local12 2)
		(+= global928 20)
		(return)
	)
	(if (localproc_4 param1)
		(+= global928 10)
		(return)
	)
	(if (localproc_5 param1)
		(+= global928 25)
		(return)
	)
	(if (== local12 3)
		(+= global928 15)
		(return)
	)
	(if (== local12 4)
		(+= global928 5)
		(return)
	)
	(if (== local12 5)
		(+= global928 2)
		(return)
	)
)

(procedure (localproc_3 param1)
	(if (!= ((param1 at: 1) rank:) 13)
		(return 0)
	)
	(if (and (localproc_4 param1) (localproc_5 param1))
		(return 1)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(= temp1 ((param1 at: 0) suit:))
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if (!= ((param1 at: temp0) suit:) temp1)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2)
	(if (== (= temp0 ((param1 at: 0) rank:)) 14)
		(= temp2 1)
	else
		(= temp2 0)
	)
	(for ((= temp1 1)) (< temp1 5) ((++ temp1))
		(if (and temp2 (== ((param1 at: 1) rank:) 5))
			(= temp2 0)
		else
			(= temp2 0)
			(if (!= (- temp0 1) ((param1 at: temp1) rank:))
				(return 0)
			)
		)
		(= temp0 ((param1 at: temp1) rank:))
	)
	(return 1)
)

(procedure (localproc_6 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 ((param1 at: 0) rank:))
	(= temp3 1)
	(= temp4 1)
	(for ((= temp1 1)) (< temp1 5) ((++ temp1))
		(if (== ((param1 at: temp1) rank:) temp0)
			(if (and (== temp2 1) (> temp3 1)) ; UNINIT
				(++ temp4)
			else
				(++ temp3)
				(= temp2 0)
			)
		else
			(= temp2 1)
		)
		(= temp0 ((param1 at: temp1) rank:))
	)
	(if (or (== temp3 4) (== temp4 4))
		(return 1)
	)
	(if (or (and (== temp3 3) (== temp4 2)) (and (== temp3 2) (== temp4 3)))
		(return 2)
	)
	(if (or (== temp3 3) (== temp4 3))
		(return 3)
	)
	(if (and (== temp3 2) (== temp4 2))
		(return 4)
	)
	(if (or (== temp3 2) (== temp4 2))
		(return 5)
	else
		(return 0)
	)
)

(procedure (proc6027_4 param1) ; UNUSED
	(if argc
		(= local10 param1)
	else
		(return local10)
	)
)

(procedure (localproc_7)
	(highScoreWindow init:)
)

(instance pokersquare of HoyleRoom
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
			(gSound2 play: 820)
		)
		(= local9 0)
		(= gCardGameScriptNumber 6027)
		(= local10 0)
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
		((= global929 pokrsqrs_opt) doit:)
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
		(hand19 add: owner: 0)
		(hand20 add: owner: 0)
		(hand21 add: owner: 0)
		(hand22 add: owner: 0)
		(hand23 add: owner: 0)
		(hand24 add: owner: 0)
		(hand25 add: owner: 0)
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
		(hand9 emptyView: hand9Empty)
		(hand9Empty setPri: 1 init: hide:)
		(hand10 emptyView: hand10Empty)
		(hand10Empty setPri: 1 init: hide:)
		(hand11 emptyView: hand11Empty)
		(hand11Empty setPri: 1 init: hide:)
		(hand12 emptyView: hand12Empty)
		(hand12Empty setPri: 1 init: hide:)
		(hand13 emptyView: hand13Empty)
		(hand13Empty setPri: 1 init: hide:)
		(hand14 emptyView: hand14Empty)
		(hand14Empty setPri: 1 init: hide:)
		(hand15 emptyView: hand15Empty)
		(hand15Empty setPri: 1 init: hide:)
		(hand16 emptyView: hand16Empty)
		(hand16Empty setPri: 1 init: hide:)
		(hand17 emptyView: hand17Empty)
		(hand17Empty setPri: 1 init: hide:)
		(hand18 emptyView: hand18Empty)
		(hand18Empty setPri: 1 init: hide:)
		(hand19 emptyView: hand19Empty)
		(hand19Empty setPri: 1 init: hide:)
		(hand20 emptyView: hand20Empty)
		(hand20Empty setPri: 1 init: hide:)
		(hand21 emptyView: hand21Empty)
		(hand21Empty setPri: 1 init: hide:)
		(hand22 emptyView: hand22Empty)
		(hand22Empty setPri: 1 init: hide:)
		(hand23 emptyView: hand23Empty)
		(hand23Empty setPri: 1 init: hide:)
		(hand24 emptyView: hand24Empty)
		(hand24Empty setPri: 1 init: hide:)
		(hand25 emptyView: hand25Empty)
		(hand25Empty setPri: 1 init: hide:)
		(if (== global927 0)
			((= gTheFoundations theFoundations) add: waste)
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
					hand19
					hand20
					hand21
					hand22
					hand23
					hand24
					hand25
					flip1
					waste
			)
			(waste emptyView: wasteEmpty)
			(wasteEmpty setPri: 1 init: hide:)
		else
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
					hand19
					hand20
					hand21
					hand22
					hand23
					hand24
					hand25
					flip1
			)
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 14)
		(= global419 theStock)
		(global419 client: flip1)
		(global929 doit: 3)
		(= local8 1)
		(= global928 0)
		(= local5 0)
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
			((not local10)
				(gSong setLoop: 1)
			)
		)
		(localproc_7)
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
	)

	(method (dispose &tmp temp0)
		(= local9 0)
		(= global419 0)
		(= global418 0)
		(gDelayCast release:)
		(= global458 0)
		(IconBarF dispose:)
		((KeyMouse objList:) release:)
		(gTheHands
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(theHands dispose:)
		(hand1Empty dispose:)
		(hand2Empty dispose:)
		(hand3Empty dispose:)
		(hand4Empty dispose:)
		(hand5Empty dispose:)
		(hand6Empty dispose:)
		(hand7Empty dispose:)
		(hand8Empty dispose:)
		(hand9Empty dispose:)
		(hand10Empty dispose:)
		(hand11Empty dispose:)
		(hand12Empty dispose:)
		(hand13Empty dispose:)
		(hand14Empty dispose:)
		(hand15Empty dispose:)
		(hand16Empty dispose:)
		(hand17Empty dispose:)
		(hand18Empty dispose:)
		(hand19Empty dispose:)
		(hand20Empty dispose:)
		(hand21Empty dispose:)
		(hand22Empty dispose:)
		(hand23Empty dispose:)
		(hand24Empty dispose:)
		(hand25Empty dispose:)
		(wasteEmpty dispose:)
		(handleEventList release: dispose:)
		(highScoreWindow dispose:)
		(Deck dispose:)
		(magView dispose:)
		(gameName dispose:)
		(if local18
			(tabView hide: dispose:)
		)
		(gTheIconBar disable:)
		(DisposeScript 6096)
		(DisposeScript 64941)
		(DisposeScript 9)
		(DisposeScript 6080)
		(DisposeScript 6090)
		(super dispose:)
	)
)

(instance pokrsqrs_opt of File
	(properties
		name {pokrsqrs.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0 format: {%d%d%4d} local10 global927 local13)
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
				(= local10 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local13 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local10 0)
				(= global927 0)
				(= local13 0)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 [temp7 4])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local13 0)
			(= local14 0)
			(global929 doit: 3)
			(proc6022_7 {high} highScoreWindow)
			(proc6022_6 local13 90 20 1 {high} highScoreWindow)
		)
		(if (!= global385 local19)
			(proc6022_7 {back} highScoreWindow)
			(proc0_10 990 5 global385 0 0 1 highScoreWindow {back})
			(= local19 global385)
		)
		(if (and local9 (== state 5) (not global458))
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
							
							(= temp6 ((gTheHands at: temp1) at: temp2))
							(if
								(and
									(temp6 faceUp:)
									(< (temp6 x:) gMouseX (+ (temp6 x:) 54))
									(< (temp6 y:) gMouseY (+ (temp6 y:) 77))
								)
								(magView
									init: (temp6 suit:) (- (temp6 rank:) 1)
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
		)
		(if (not local11)
			(= temp3 0)
			(for ((= temp2 0)) (< temp2 5) ((++ temp2))
				(for ((= temp1 0)) (< temp1 5) ((++ temp1))
					(++ temp3)
					(if ((gTheHands at: (- temp3 1)) size:)
						(tempList add: ((gTheHands at: (- temp3 1)) at: 0))
					)
				)
				(cond
					((== (tempList size:) 5)
						(KList 22 (tempList elements:) 793 1) ; Sort
						(localproc_2 tempList)
						(tempList release:)
					)
					((tempList size:)
						(tempList release:)
					)
				)
			)
			(for ((= temp2 0)) (< temp2 5) ((++ temp2))
				(= temp3 temp2)
				(for ((= temp1 0)) (< temp1 5) ((++ temp1))
					(+= temp3 5)
					(if ((gTheHands at: (- temp3 5)) size:)
						(tempList add: ((gTheHands at: (- temp3 5)) at: 0))
					)
				)
				(cond
					((== (tempList size:) 5)
						(KList 22 (tempList elements:) 793 1) ; Sort
						(localproc_2 tempList)
						(tempList release:)
					)
					((tempList size:)
						(tempList release:)
					)
				)
			)
			(= local16 global928)
			(= global928 0)
			(if (!= local17 local16)
				(proc6022_7 {score} highScoreWindow)
				(proc6022_6 local16 90 4 1 {score} highScoreWindow)
				(= local17 local16)
			)
		)
		(if (and (localproc_0) (not local11))
			(= local11 1)
			(handleEventList delete: undoButton)
			(localproc_1)
			(if (> global928 local13)
				(= local13 global928)
			)
			(if (> local13 local14)
				(Print
					ticks: 200
					fore: 0
					mode: 1
					addBitmap: 917 4 0
					font: gUserFont
					addText: {\n*******NEW HIGH SCORE!*******} 25 20
					init:
				)
				(= local14 local13)
				(global929 doit: 3)
				(proc6022_7 {high} highScoreWindow)
				(proc6022_6 local13 90 20 1 {high} highScoreWindow)
			)
			(if (>= global928 100)
				(= local15 1)
				(endCode doit:)
			)
		)
		(if
			(and
				(not (flip1 size:))
				local9
				(== state 5)
				(not global458)
				(not global395)
				(theStock size:)
				(not local11)
				(not global226)
			)
			(theStock getCard:)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local9 0)
				(= ticks (= ticks 1))
			)
			(1
				(= global440 0)
				(= global441 0)
				(= ticks 10)
			)
			(2
				(= ticks 10)
				(IconBar show:)
			)
			(3
				(= local9 0)
				(gTheIconBar enable:)
				(if global524
					(= global524 0)
				)
				(= ticks 10)
			)
			(4
				(Deck shuffle:)
				(= local9 0)
				(= local8 1)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= local15 0)
				(= global395 0)
				(= local2 0)
				(= global243 0)
				(= local5 0)
				(= global928 0)
				(= local16 0)
				(= local17 -1)
				(= global226 1)
				(if (== global927 1)
					(if (theFoundations size:)
						(theFoundations release:)
					)
					(= gTheFoundations 0)
				)
				(= cycles 1)
			)
			(5
				(= local9 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(flipButton setPri: 1 init: hide:)
				(= local6 0)
				(hand1Empty setPri: 1 init: show:)
				(hand2Empty setPri: 1 init: show:)
				(hand3Empty setPri: 1 init: show:)
				(hand4Empty setPri: 1 init: show:)
				(hand5Empty setPri: 1 init: show:)
				(hand6Empty setPri: 1 init: show:)
				(hand7Empty setPri: 1 init: show:)
				(hand8Empty setPri: 1 init: show:)
				(hand9Empty setPri: 1 init: show:)
				(hand10Empty setPri: 1 init: show:)
				(hand11Empty setPri: 1 init: show:)
				(hand12Empty setPri: 1 init: show:)
				(hand13Empty setPri: 1 init: show:)
				(hand14Empty setPri: 1 init: show:)
				(hand15Empty setPri: 1 init: show:)
				(hand16Empty setPri: 1 init: show:)
				(hand17Empty setPri: 1 init: show:)
				(hand18Empty setPri: 1 init: show:)
				(hand19Empty setPri: 1 init: show:)
				(hand20Empty setPri: 1 init: show:)
				(hand21Empty setPri: 1 init: show:)
				(hand22Empty setPri: 1 init: show:)
				(hand23Empty setPri: 1 init: show:)
				(hand24Empty setPri: 1 init: show:)
				(hand25Empty setPri: 1 init: show:)
				(if (== global927 0)
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
							hand19
							hand20
							hand21
							hand22
							hand23
							hand24
							hand25
							waste
					)
					(wasteEmpty setPri: 1 init: show:)
				else
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
							hand19
							hand20
							hand21
							hand22
							hand23
							hand24
							hand25
					)
				)
				(global419 init: client: flip1 active: 1 size: 52 addKeyMouse:)
				(handleEventList add: flip1)
				(handleEventList add: resignButton)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local5 1)
				(= local14 local13)
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
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(= local6 0)
		(gTheHands eachElementDo: #endHand)
		(if (== global927 0)
			(if (gTheFoundations size:)
				(gTheFoundations release:)
			)
			(gTheFoundations dispose:)
		)
		(if local18
			(= local18 0)
			(tabView hide:)
		)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(flipButton dispose:)
		(proc0_9 (gCast elements:) 0)
		(= local12 0)
		(= local11 0)
		(if (theHands size:)
			(theHands release:)
		)
		(if (== global927 0)
			((= gTheFoundations theFoundations) add: waste)
			(theHands
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
					hand19
					hand20
					hand21
					hand22
					hand23
					hand24
					hand25
					flip1
					waste
			)
		else
			(theHands
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
					hand19
					hand20
					hand21
					hand22
					hand23
					hand24
					hand25
					flip1
			)
		)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (not local15)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global513)
			(++ global221)
			(= global513 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(proc6027_1 1)
		(if local8
			((ScriptID 6080 1) doit: global928) ; scoreHand
		)
		(DisableCursor)
		((ScriptID 6096 2) init:) ; aBanner
		(gSound2 play: 3000)
		((ScriptID 6096 2) setScript: (ScriptID 6096 1)) ; aBanner, sBannerOut
	)
)

(instance theStock of Stock
	(properties
		priority 4
		offsetY 10
	)

	(method (init)
		(= x 498)
		(= y 98)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local6 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
				)
			)
			((< 4 size 9)
				(= local6 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
				)
			)
			((< 0 size 5)
				(handleEventList delete: flipButton)
				(= local6 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(handleEventList addToEnd: flipButton)
				(flipButton show:)
				(= local6 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local6 0)
				(self setLoop: 0 posn: origX origY)
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: origX origY
				)
			)
		)
	)

	(method (getCard)
		(self setCel: 1)
		(DisableCursor)
		(if (not (flip1 size:))
			(-- size)
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

(instance flipButton of TrackingView
	(properties
		x 422
		y 111
		priority 1
		view 915
		loop 7
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(cleanUp doit:)
		)
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
				(proc6027_1 1)
				(IconBarF lighten:)
				(if local8
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
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== global225 1)
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
									
									(temp2List
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (temp2List size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (temp2List at: temp1)
									)
								)
								(temp2List release:)
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
								((ScriptID 15 7) show:) ; stockBack
							)
							(resetStock doit:)
							(= temp0 -1)
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
									
									(temp2List
										add: ((temp3 previousHand:) at: temp1)
									)
								)
								((temp3 previousHand:) release:)
								(for
									((= temp1 0))
									(< temp1 (temp2List size:))
									((++ temp1))
									
									((temp3 previousHand:)
										add: (temp2List at: temp1)
									)
								)
								(temp2List release:)
								(break)
							)
							((temp3 previousHand:)
								delete:
									((temp3 previousHand:)
										at: (- ((temp3 previousHand:) size:) 1)
									)
							)
							(break)
						)
					)
				)
				(= global226 0)
				(= global928 0)
			)
		)
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
				(if (== (flip1 size:) 0)
					(= temp0 (getOne doit:))
					(UpdateScreenItem temp0)
				)
				((ScriptID 15 6) dispose:) ; littleCard
				(= global395 0)
				(= cycles 1)
			)
			(2
				(theStock setCel: 0)
				(EnableCursor)
			)
		)
	)
)

(instance getOne of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 0)
		(while (< temp1 1)
			(= temp0 (Deck getCard:))
			(if (not (temp0 inPlay:))
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
		(= local3 (Deck topCard:))
		(= local4 (theStock size:))
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

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local9))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 6005 15 128 0 (Random 1 2))
				else
					(gChar1 say: 6005 15 128 0 2)
				)
			else
				(= local8 0)
				(cleanUp doit:)
			)
			(return 1)
		)
		(return
			(if (and local6 (> (theStock size:) 0))
				(= local6 0)
				(theStock adjust:)
			)
		)
	)
)

(instance hand1 of sHand
	(properties
		x 70
		y 14
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 70
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand1Empty of View
	(properties
		x 70
		y 14
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 135
		y 14
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 135
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand2Empty of View
	(properties
		x 135
		y 14
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 200
		y 14
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand3Empty of View
	(properties
		x 200
		y 14
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 265
		y 14
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 265
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand4Empty of View
	(properties
		x 265
		y 14
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 330
		y 14
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 330
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand5Empty of View
	(properties
		x 330
		y 14
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 70
		y 94
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 70
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand6Empty of View
	(properties
		x 70
		y 94
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 135
		y 94
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 135
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand7Empty of View
	(properties
		x 135
		y 94
		priority 1
		view 915
		loop 8
	)
)

(instance hand8 of sHand
	(properties
		x 200
		y 94
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand8Empty of View
	(properties
		x 200
		y 94
		priority 1
		view 915
		loop 8
	)
)

(instance hand9 of sHand
	(properties
		x 265
		y 94
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 265
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand9Empty of View
	(properties
		x 265
		y 94
		priority 1
		view 915
		loop 8
	)
)

(instance hand10 of sHand
	(properties
		x 330
		y 94
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 330
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand10Empty of View
	(properties
		x 330
		y 94
		priority 1
		view 915
		loop 8
	)
)

(instance hand11 of sHand
	(properties
		x 70
		y 174
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 70
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand11Empty of View
	(properties
		x 70
		y 174
		priority 1
		view 915
		loop 8
	)
)

(instance hand12 of sHand
	(properties
		x 135
		y 174
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 135
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand12Empty of View
	(properties
		x 135
		y 174
		priority 1
		view 915
		loop 8
	)
)

(instance hand13 of sHand
	(properties
		x 200
		y 174
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand13Empty of View
	(properties
		x 200
		y 174
		priority 1
		view 915
		loop 8
	)
)

(instance hand14 of sHand
	(properties
		x 265
		y 174
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 265
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand14Empty of View
	(properties
		x 265
		y 174
		priority 1
		view 915
		loop 8
	)
)

(instance hand15 of sHand
	(properties
		x 330
		y 174
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 330
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand15Empty of View
	(properties
		x 330
		y 174
		priority 1
		view 915
		loop 8
	)
)

(instance hand16 of sHand
	(properties
		x 70
		y 254
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 70
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand16Empty of View
	(properties
		x 70
		y 254
		priority 1
		view 915
		loop 8
	)
)

(instance hand17 of sHand
	(properties
		x 135
		y 254
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 135
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand17Empty of View
	(properties
		x 135
		y 254
		priority 1
		view 915
		loop 8
	)
)

(instance hand18 of sHand
	(properties
		x 200
		y 254
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand18Empty of View
	(properties
		x 200
		y 254
		priority 1
		view 915
		loop 8
	)
)

(instance hand19 of sHand
	(properties
		x 265
		y 254
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 265
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand19Empty of View
	(properties
		x 265
		y 254
		priority 1
		view 915
		loop 8
	)
)

(instance hand20 of sHand
	(properties
		x 330
		y 254
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 330
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand20Empty of View
	(properties
		x 330
		y 254
		priority 1
		view 915
		loop 8
	)
)

(instance hand21 of sHand
	(properties
		x 70
		y 334
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 70
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand21Empty of View
	(properties
		x 70
		y 334
		priority 1
		view 915
		loop 8
	)
)

(instance hand22 of sHand
	(properties
		x 135
		y 334
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 135
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand22Empty of View
	(properties
		x 135
		y 334
		priority 1
		view 915
		loop 8
	)
)

(instance hand23 of sHand
	(properties
		x 200
		y 334
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 200
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand23Empty of View
	(properties
		x 200
		y 334
		priority 1
		view 915
		loop 8
	)
)

(instance hand24 of sHand
	(properties
		x 265
		y 334
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 265
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand24Empty of View
	(properties
		x 265
		y 334
		priority 1
		view 915
		loop 8
	)
)

(instance hand25 of sHand
	(properties
		x 330
		y 334
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 330
		cardLimit 1
		buildOrder 10
		startRank 3
		whereTo 2
	)
)

(instance hand25Empty of View
	(properties
		x 330
		y 334
		priority 1
		view 915
		loop 8
	)
)

(instance flip1 of sHand
	(properties
		x 422
		y 111
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 422
		whatType 2
		cardShow 1
		cardLimit 1
		canPlay 1
	)

	(method (add param1)
		(super add: param1 &rest)
		(param1 flip: 1 show: init:)
	)
)

(instance waste of sHand
	(properties
		x 464
		y 224
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 464
		whatType 1
		cardLimit 5
		buildOrder 10
		startRank 3
		whereTo 2
	)

	(method (add param1)
		(super add: param1 &rest)
		(= global928 0)
	)
)

(instance wasteEmpty of View
	(properties
		x 464
		y 224
		priority 1
		view 915
		loop 8
	)
)

(instance tempList of List
	(properties)
)

(instance temp2List of List
	(properties)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
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
		loop 19
	)
)

(instance highScoreWindow of InvisibleWindow
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
		(proc0_10 990 1 0 0 0 5 self)
		(proc6022_6 local16 90 4 1 {score} self)
		(proc6022_6 local13 90 20 1 {high} self)
	)
)

(instance tabView of View
	(properties
		view 729
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

