;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6019)
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
	slide 0
	proc6019_1 1
	optionCode 2
	roomScript 3
	proc6019_4 4
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
	[local9 2]
	local11
	local12
	local13
	local14
	local15 = 1
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
)

(procedure (proc6019_1 param1)
	((ScriptID 6080 0) doit: global928 (if argc param1 else 0)) ; scoreSolitaire
)

(procedure (proc6019_4 param1) ; UNUSED
	(if argc
		(= local8 param1)
	else
		(return local8)
	)
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if (!= ((gTheFoundations at: temp0) size:) 9)
			(return (gTheFoundations at: temp0))
		)
	)
	(return found1Hand)
)

(procedure (localproc_1 &tmp [temp0 5] temp5 temp6)
	(= temp6 0)
	(= global246 1)
	(if
		(and
			((gTheHands at: 0) size:)
			((gTheHands at: 6) size:)
			((gTheHands at: 12) size:)
			(==
				(((gTheHands at: 0) at: 0) rank:)
				(((gTheHands at: 6) at: 0) rank:)
			)
			(==
				(((gTheHands at: 6) at: 0) rank:)
				(((gTheHands at: 12) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 0) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 0) at: 0))
		(temp5 add: ((gTheHands at: 6) at: 0))
		(temp5 add: ((gTheHands at: 12) at: 0))
		((gTheHands at: 0) eliminateCard: ((gTheHands at: 0) at: 0))
		((gTheHands at: 6) eliminateCard: ((gTheHands at: 6) at: 0))
		((gTheHands at: 12) eliminateCard: ((gTheHands at: 12) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 6) size:)
			((gTheHands at: 12) size:)
			((gTheHands at: 18) size:)
			(==
				(((gTheHands at: 6) at: 0) rank:)
				(((gTheHands at: 12) at: 0) rank:)
			)
			(==
				(((gTheHands at: 12) at: 0) rank:)
				(((gTheHands at: 18) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 6) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 6) at: 0))
		(temp5 add: ((gTheHands at: 12) at: 0))
		(temp5 add: ((gTheHands at: 18) at: 0))
		((gTheHands at: 6) eliminateCard: ((gTheHands at: 6) at: 0))
		((gTheHands at: 12) eliminateCard: ((gTheHands at: 12) at: 0))
		((gTheHands at: 18) eliminateCard: ((gTheHands at: 18) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 1) size:)
			((gTheHands at: 7) size:)
			((gTheHands at: 13) size:)
			(==
				(((gTheHands at: 1) at: 0) rank:)
				(((gTheHands at: 7) at: 0) rank:)
			)
			(==
				(((gTheHands at: 7) at: 0) rank:)
				(((gTheHands at: 13) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 1) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 1) at: 0))
		(temp5 add: ((gTheHands at: 7) at: 0))
		(temp5 add: ((gTheHands at: 13) at: 0))
		((gTheHands at: 1) eliminateCard: ((gTheHands at: 1) at: 0))
		((gTheHands at: 7) eliminateCard: ((gTheHands at: 7) at: 0))
		((gTheHands at: 13) eliminateCard: ((gTheHands at: 13) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 7) size:)
			((gTheHands at: 13) size:)
			((gTheHands at: 19) size:)
			(==
				(((gTheHands at: 7) at: 0) rank:)
				(((gTheHands at: 13) at: 0) rank:)
			)
			(==
				(((gTheHands at: 13) at: 0) rank:)
				(((gTheHands at: 19) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 7) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 7) at: 0))
		(temp5 add: ((gTheHands at: 13) at: 0))
		(temp5 add: ((gTheHands at: 19) at: 0))
		((gTheHands at: 7) eliminateCard: ((gTheHands at: 7) at: 0))
		((gTheHands at: 13) eliminateCard: ((gTheHands at: 13) at: 0))
		((gTheHands at: 19) eliminateCard: ((gTheHands at: 19) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 2) size:)
			((gTheHands at: 8) size:)
			((gTheHands at: 14) size:)
			(==
				(((gTheHands at: 2) at: 0) rank:)
				(((gTheHands at: 8) at: 0) rank:)
			)
			(==
				(((gTheHands at: 8) at: 0) rank:)
				(((gTheHands at: 14) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 2) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 2) at: 0))
		(temp5 add: ((gTheHands at: 8) at: 0))
		(temp5 add: ((gTheHands at: 14) at: 0))
		((gTheHands at: 2) eliminateCard: ((gTheHands at: 2) at: 0))
		((gTheHands at: 8) eliminateCard: ((gTheHands at: 8) at: 0))
		((gTheHands at: 14) eliminateCard: ((gTheHands at: 14) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 8) size:)
			((gTheHands at: 14) size:)
			((gTheHands at: 20) size:)
			(==
				(((gTheHands at: 8) at: 0) rank:)
				(((gTheHands at: 14) at: 0) rank:)
			)
			(==
				(((gTheHands at: 14) at: 0) rank:)
				(((gTheHands at: 20) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 8) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 8) at: 0))
		(temp5 add: ((gTheHands at: 14) at: 0))
		(temp5 add: ((gTheHands at: 20) at: 0))
		((gTheHands at: 8) eliminateCard: ((gTheHands at: 8) at: 0))
		((gTheHands at: 14) eliminateCard: ((gTheHands at: 14) at: 0))
		((gTheHands at: 20) eliminateCard: ((gTheHands at: 20) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 3) size:)
			((gTheHands at: 9) size:)
			((gTheHands at: 15) size:)
			(==
				(((gTheHands at: 3) at: 0) rank:)
				(((gTheHands at: 9) at: 0) rank:)
			)
			(==
				(((gTheHands at: 9) at: 0) rank:)
				(((gTheHands at: 15) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 3) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 3) at: 0))
		(temp5 add: ((gTheHands at: 9) at: 0))
		(temp5 add: ((gTheHands at: 15) at: 0))
		((gTheHands at: 3) eliminateCard: ((gTheHands at: 3) at: 0))
		((gTheHands at: 9) eliminateCard: ((gTheHands at: 9) at: 0))
		((gTheHands at: 15) eliminateCard: ((gTheHands at: 15) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 9) size:)
			((gTheHands at: 15) size:)
			((gTheHands at: 21) size:)
			(==
				(((gTheHands at: 9) at: 0) rank:)
				(((gTheHands at: 15) at: 0) rank:)
			)
			(==
				(((gTheHands at: 15) at: 0) rank:)
				(((gTheHands at: 21) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 9) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 9) at: 0))
		(temp5 add: ((gTheHands at: 15) at: 0))
		(temp5 add: ((gTheHands at: 21) at: 0))
		((gTheHands at: 9) eliminateCard: ((gTheHands at: 9) at: 0))
		((gTheHands at: 15) eliminateCard: ((gTheHands at: 15) at: 0))
		((gTheHands at: 21) eliminateCard: ((gTheHands at: 21) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 4) size:)
			((gTheHands at: 10) size:)
			((gTheHands at: 16) size:)
			(==
				(((gTheHands at: 4) at: 0) rank:)
				(((gTheHands at: 10) at: 0) rank:)
			)
			(==
				(((gTheHands at: 10) at: 0) rank:)
				(((gTheHands at: 16) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 4) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 4) at: 0))
		(temp5 add: ((gTheHands at: 10) at: 0))
		(temp5 add: ((gTheHands at: 16) at: 0))
		((gTheHands at: 4) eliminateCard: ((gTheHands at: 4) at: 0))
		((gTheHands at: 10) eliminateCard: ((gTheHands at: 10) at: 0))
		((gTheHands at: 16) eliminateCard: ((gTheHands at: 16) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 10) size:)
			((gTheHands at: 16) size:)
			((gTheHands at: 22) size:)
			(==
				(((gTheHands at: 10) at: 0) rank:)
				(((gTheHands at: 16) at: 0) rank:)
			)
			(==
				(((gTheHands at: 16) at: 0) rank:)
				(((gTheHands at: 22) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 10) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 10) at: 0))
		(temp5 add: ((gTheHands at: 16) at: 0))
		(temp5 add: ((gTheHands at: 22) at: 0))
		((gTheHands at: 10) eliminateCard: ((gTheHands at: 10) at: 0))
		((gTheHands at: 16) eliminateCard: ((gTheHands at: 16) at: 0))
		((gTheHands at: 22) eliminateCard: ((gTheHands at: 22) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 5) size:)
			((gTheHands at: 11) size:)
			((gTheHands at: 17) size:)
			(==
				(((gTheHands at: 5) at: 0) rank:)
				(((gTheHands at: 11) at: 0) rank:)
			)
			(==
				(((gTheHands at: 11) at: 0) rank:)
				(((gTheHands at: 17) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 5) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 5) at: 0))
		(temp5 add: ((gTheHands at: 11) at: 0))
		(temp5 add: ((gTheHands at: 17) at: 0))
		((gTheHands at: 5) eliminateCard: ((gTheHands at: 5) at: 0))
		((gTheHands at: 11) eliminateCard: ((gTheHands at: 11) at: 0))
		((gTheHands at: 17) eliminateCard: ((gTheHands at: 17) at: 0))
	)
	(+= global928 temp6)
	(= temp6 0)
	(if
		(and
			((gTheHands at: 11) size:)
			((gTheHands at: 17) size:)
			((gTheHands at: 23) size:)
			(==
				(((gTheHands at: 11) at: 0) rank:)
				(((gTheHands at: 17) at: 0) rank:)
			)
			(==
				(((gTheHands at: 17) at: 0) rank:)
				(((gTheHands at: 23) at: 0) rank:)
			)
		)
		(= temp6 (* (((gTheHands at: 11) at: 0) rank:) local15))
		(if (< local15 13)
			(++ local15)
		)
		(= temp5 (localproc_0))
		(temp5 add: ((gTheHands at: 11) at: 0))
		(temp5 add: ((gTheHands at: 17) at: 0))
		(temp5 add: ((gTheHands at: 23) at: 0))
		((gTheHands at: 11) eliminateCard: ((gTheHands at: 11) at: 0))
		((gTheHands at: 17) eliminateCard: ((gTheHands at: 17) at: 0))
		((gTheHands at: 23) eliminateCard: ((gTheHands at: 23) at: 0))
	)
	(= global246 0)
	(+= global928 temp6)
)

(procedure (localproc_2)
	(highScoreWindow init:)
)

(instance slide of HoyleRoom
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
			(gSound2 play: 824)
		)
		(= local7 0)
		(= gCardGameScriptNumber 6019)
		(= local8 0)
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
		((= global929 slide_opt) doit:)
		(= picture (+ global877 global385))
		(= local24 global385)
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
		(wasteHand emptyView: wasteEmpty)
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
				flip1
		)
		((= gTheFoundations theFoundations)
			add: found1Hand found2Hand found3Hand found4Hand found5Hand
		)
		(handleEventList add:)
		(Deck init: sCard)
		(Deck rankAces: 1)
		(= global419 theStock)
		(global419 client: flip1)
		(global929 doit: 3)
		(= local6 1)
		(= global928 0)
		(= local13 0)
		(= global246 0)
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
			((not local8)
				(gSong setLoop: 1)
			)
		)
		(localproc_2)
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
		(= local7 0)
		(= global419 0)
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
		(flip1 release: dispose:)
		(if (magList size:)
			(magList release:)
		)
		(if local22
			(tabView hide: dispose:)
		)
		(magList dispose:)
		(theFoundations dispose:)
		(theHands dispose:)
		(wasteHand release: dispose:)
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
		(wasteEmpty dispose:)
		(resignButton dispose:)
		(right1Button dispose:)
		(right2Button dispose:)
		(right3Button dispose:)
		(right4Button dispose:)
		(left1Button dispose:)
		(left2Button dispose:)
		(left3Button dispose:)
		(left4Button dispose:)
		(handleEventList release: dispose:)
		(highScoreWindow dispose:)
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

(instance slide_opt of File
	(properties
		name {slide.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0 format: {%d%d%4d} local8 global927 local17)
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
				(= local8 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global927 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local17 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local8 0)
				(= global927 0)
				(= local17 0)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 3])
		(super doit: &rest)
		(if global525
			(= global525 0)
			(= local17 0)
			(= local18 0)
			(global929 doit: 3)
			(proc6022_7 {high} highScoreWindow)
			(proc6022_6 local17 90 20 1 {high} highScoreWindow)
		)
		(if (!= global385 local24)
			(proc6022_7 {back} highScoreWindow)
			(proc0_10 990 5 global385 0 0 1 highScoreWindow {back})
			(= local24 global385)
		)
		(if (and local7 (== state 5) (not global458))
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
						(magList
							add:
								wasteHand
								found5Hand
								found4Hand
								found3Hand
								found2Hand
								found1Hand
						)
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
			(= local16 0)
			(if
				(and
					(not global395)
					(not (flip1 size:))
					(not global226)
					(theStock size:)
				)
				(= local16 1)
				(theStock getCard:)
			)
			(if (and (not global395) (not (flip1 size:)) (not (theStock size:)))
				(handleEventList
					delete:
						right1Button
						right2Button
						right3Button
						right4Button
						left1Button
						left2Button
						left3Button
						left4Button
				)
			)
			(if
				(and
					(not local19)
					(not global226)
					(not local16)
					(not global247)
				)
				(if (== global225 0)
					(= global226 1)
				)
				(localproc_1)
				(if (== global225 0)
					(= global226 0)
				)
			)
			(if (!= local21 global928)
				(proc6022_7 {score} highScoreWindow)
				(proc6022_6 global928 90 4 1 {score} highScoreWindow)
				(= local21 global928)
			)
			(if
				(and
					(not local19)
					(not (theStock size:))
					(not (flip1 size:))
					(not global395)
				)
				(= global247 0)
				(localproc_1)
				(if (!= local21 global928)
					(proc6022_7 {score} highScoreWindow)
					(proc6022_6 global928 90 4 1 {score} highScoreWindow)
					(= local21 global928)
				)
				(if (> global928 local17)
					(= local17 global928)
				)
				(if (> local17 local18)
					(Print
						ticks: 200
						fore: 0
						mode: 1
						addBitmap: 917 4 0
						font: gUserFont
						addText: {\n*******NEW HIGH SCORE!*******} 25 20
						init:
					)
					(global929 doit: 3)
					(= local18 local17)
					(proc6022_7 {high} highScoreWindow)
					(proc6022_6 local17 90 20 1 {high} highScoreWindow)
				)
				(cond
					((and (= local19 1) (>= global928 300))
						(= local20 1)
						(endCode doit:)
					)
					(local19
						(= local19 0)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local7 0)
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
						hand19
						hand20
						hand21
						hand22
						hand23
						hand24
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
				(= local7 0)
				(for ((= temp1 0)) (< temp1 (Deck size:)) ((++ temp1))
					((Deck at: temp1) tailList: 0)
					((Deck at: temp1) whenPlayed: 0)
					((Deck at: temp1) previousHand: 0)
					((Deck at: temp1) inPlay: 0)
				)
				(= global226 1)
				(= local6 1)
				(= local20 0)
				(= global928 0)
				(= local21 -1)
				(= global395 0)
				(= local23 0)
				(Deck shuffle:)
				(for ((= temp1 0)) (< temp1 52) ((++ temp1))
					(tempDeck add: (Deck at: temp1))
				)
				(= local3 0)
				(= global243 0)
				(sDealer deal: self)
			)
			(5
				(= local7 1)
				(EnableCursor)
				(resignButton setPri: 1 init:)
				(right1Button setPri: 1 init:)
				(right2Button setPri: 1 init:)
				(right3Button setPri: 1 init:)
				(right4Button setPri: 1 init:)
				(left1Button setPri: 1 init:)
				(left2Button setPri: 1 init:)
				(left3Button setPri: 1 init:)
				(left4Button setPri: 1 init:)
				((KeyMouse objList:) add: resignButton)
				(wasteEmpty setPri: 1 init:)
				(undoButton setPri: 1 init:)
				((KeyMouse objList:) add: undoButton)
				(= local4 0)
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
				)
				(global419 init: client: flip1 active: 1 size: 28 addKeyMouse:)
				(handleEventList add: flip1)
				(handleEventList add: resignButton)
				(handleEventList
					add:
						right1Button
						right2Button
						right3Button
						right4Button
						left1Button
						left2Button
						left3Button
						left4Button
				)
				(handleEventList add: undoButton)
				(for ((= temp1 0)) (< temp1 (gTheHands size:)) ((++ temp1))
					((gTheHands at: temp1) partner: 0)
				)
				(= global225 0)
				(= global226 0)
				(= local13 1)
				(= global247 0)
				(= local19 0)
				(= local18 local17)
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
		(Deck release:)
		(for ((= temp0 0)) (< temp0 52) ((++ temp0))
			(Deck add: (tempDeck at: temp0))
		)
		(tempDeck release:)
		(if local22
			(= local22 0)
			(tabView hide:)
		)
		(resignButton dispose:)
		(undoButton dispose:)
		(right1Button dispose:)
		(right2Button dispose:)
		(right3Button dispose:)
		(right4Button dispose:)
		(left1Button dispose:)
		(left2Button dispose:)
		(left3Button dispose:)
		(left4Button dispose:)
		(= local4 0)
		(= local15 1)
		(gTheHands eachElementDo: #endHand)
		(gTheFoundations eachElementDo: #endHand)
		(flip1 endHand:)
		(wasteHand endHand:)
		((KeyMouse objList:) release:)
		(global419 endHand:)
		(handleEventList release:)
		(global419 dispose:)
		(proc0_9 (gCast elements:) 0)
		(dealList release: dispose:)
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
				hand19
				hand20
				hand21
				hand22
				hand23
				hand24
		)
		(sDealer init: dealList)
		(if global265
			(Deck sameDeck: 1)
			(= global265 0)
		)
		(if (not local20)
			(roomScript changeState: 3)
		)
	)
)

(instance endCode of Code
	(properties)

	(method (doit)
		(if (not global517)
			(++ global221)
			(= global517 1)
			(gGame_opt doit: 3)
		)
		(cleanUp doit:)
		(proc6019_1 1)
		(if local6
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
		(= x 535)
		(= y 237)
		(super init:)
		(= loop 0)
	)

	(method (validPlay)
		(return 1)
	)

	(method (adjust)
		(cond
			((< 8 size 13)
				(= local4 0)
				(self setLoop: 1 posn: (+ origX 8) (+ origY 7))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 8) (+ origY 7)
				)
			)
			((< 4 size 9)
				(= local4 0)
				(self setLoop: 2 posn: (+ origX 10) (+ origY 9))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 10) (+ origY 9)
				)
			)
			((< 0 size 5)
				(handleEventList add: global419)
				(= local4 0)
				(self setLoop: 3 posn: (+ origX 12) (+ origY 11))
				((ScriptID 15 7) ; stockBack
					view: (+ 54 global384)
					setLoop: 0
					posn: (+ origX 12) (+ origY 11)
				)
			)
			((== size 0)
				(self setLoop: 4 posn: (+ origX 14) (+ origY 13))
				(handleEventList delete: global419)
				(= local4 1)
				((ScriptID 15 7) hide:) ; stockBack
			)
			(else
				(= local4 0)
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
		(DisableCursor)
		(if (not (flip1 size:))
			(if size
				(-= size 1)
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
				((ScriptID 15 6) hide: setMotion: MoveTo 475 250 self) ; littleCard
				(= global116 0)
			else
				(EnableCursor)
			)
		else
			(EnableCursor)
		)
	)

	(method (cue)
		(self setScript: stockScript)
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
				(proc6019_1 1)
				(IconBarF lighten:)
				(if local6
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (and (not global226) (super handleEvent: event))
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
				(= temp11 0)
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
							(!= (((Deck at: temp0) owner:) whatType:) 1)
						)
						(++ temp11)
					)
				)
				(= temp8 0)
				(= temp10 0)
				(= temp12 0)
				(= temp6 0)
				(= global226 1)
				(= temp4 global225)
				(= temp5 0)
				(= temp13 0)
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
						(cond
							(
								(and
									(!= temp11 1)
									(==
										((temp3 previousHand:)
											at:
												(-
													((temp3 previousHand:)
														size:
													)
													1
												)
										)
										2
									)
								)
								(++ temp8)
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
								(if (< (theStock size:) 1)
									(handleEventList add: global419)
									((ScriptID 15 7) show:) ; stockBack
								)
								(resetStock doit:)
								(= temp5 1)
								(= global225 temp4)
								(= temp0 -1)
							)
							((== temp11 1)
								(cond
									(
										(==
											((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
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
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
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
										(if (< (theStock size:) 1)
											(handleEventList add: global419)
											((ScriptID 15 7) show:) ; stockBack
										)
										(resetStock doit:)
										(= temp5 1)
										(= temp0 -1)
									)
									((!= ((temp3 owner:) whatType:) 1)
										((temp3 owner:) eliminateCard: temp3)
										(temp3 inPlay: 1)
										(((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
											add: temp3
										)
										(if (> ((temp3 previousHand:) size:) 1)
											(for
												((= temp1 0))
												(<
													temp1
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
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
											(break)
										)
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
										(break)
									)
									(else
										(= temp10 1)
										(-- local15)
										(= temp9
											(-=
												global928
												(* local15 (temp3 rank:))
											)
										)
										(++ temp6)
										((temp3 owner:) eliminateCard: temp3)
										(temp3 inPlay: 1)
										(((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
											add: temp3
										)
										(if (> ((temp3 previousHand:) size:) 1)
											(for
												((= temp1 0))
												(<
													temp1
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
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
										(for
											((= temp0 0))
											(< temp0 (Deck size:))
											((++ temp0))
											
											(if
												(and
													((Deck at: temp0)
														whenPlayed:
													)
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
																owner:
															)
															whatType:
														)
														1
													)
												)
												(= temp3 (Deck at: temp0))
												((temp3 owner:)
													eliminateCard: temp3
												)
												(temp3 inPlay: 1)
												(((temp3 previousHand:)
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
													add: temp3
												)
												(if
													(>
														((temp3 previousHand:)
															size:
														)
														1
													)
													(for
														((= temp1 0))
														(<
															temp1
															(-
																((temp3
																		previousHand:
																	)
																	size:
																)
																1
															)
														)
														((++ temp1))
														
														(tempList
															add:
																((temp3
																		previousHand:
																	)
																	at: temp1
																)
														)
													)
													((temp3 previousHand:)
														release:
													)
													(for
														((= temp1 0))
														(<
															temp1
															(tempList size:)
														)
														((++ temp1))
														
														((temp3 previousHand:)
															add:
																(tempList
																	at: temp1
																)
														)
													)
													(tempList release:)
												else
													((temp3 previousHand:)
														delete:
															((temp3
																	previousHand:
																)
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
												(if (== (++ temp6) 3)
													(break)
												else
													(= temp0 -1)
												)
											)
										)
										(= local14 5)
										(for
											((= temp1 0))
											(< temp1 (gTheFoundations size:))
											((++ temp1))
											
											(for
												((= temp2 0))
												(<
													temp2
													((gTheFoundations at: temp1)
														size:
													)
												)
												((++ temp2))
												
												(((gTheFoundations at: temp1)
														at: temp2
													)
													priority: (++ local14)
												)
												(UpdateScreenItem
													((gTheFoundations at: temp1)
														at: temp2
													)
												)
											)
										)
										(= temp4 global225)
										(if (== global225 0)
											(break)
										else
											(= temp0 -1)
										)
									)
								)
							)
							((== ((temp3 owner:) whatType:) 1)
								(for
									((= temp2 0))
									(< temp2 ((temp3 owner:) size:))
									((++ temp2))
									
									(((temp3 owner:) at: temp2) setPri: local14)
									(++ local14)
								)
								(= temp10 1)
								(-- local15)
								(= temp9
									(-= global928 (* local15 (temp3 rank:)))
								)
								(++ temp6)
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
								(for
									((= temp0 0))
									(< temp0 (Deck size:))
									((++ temp0))
									
									(if
										(and
											((Deck at: temp0) whenPlayed:)
											(==
												(((Deck at: temp0) whenPlayed:)
													at:
														(-
															(((Deck at: temp0)
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
												(((Deck at: temp0) owner:)
													whatType:
												)
												1
											)
										)
										(= temp3 (Deck at: temp0))
										((temp3 owner:) eliminateCard: temp3)
										(temp3 inPlay: 1)
										(((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
											add: temp3
										)
										(if (> ((temp3 previousHand:) size:) 1)
											(for
												((= temp1 0))
												(<
													temp1
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
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
										(if (== (++ temp6) 3)
											(break)
										else
											(= temp0 -1)
										)
									)
								)
								(= temp4 global225)
								(if (== global225 0)
									(break)
								else
									(= temp0 -1)
								)
							)
							(
								(or
									(not temp5)
									(>
										(((temp3 previousHand:)
												at:
													(-
														((temp3 previousHand:)
															size:
														)
														1
													)
											)
											size:
										)
										0
									)
								)
								(if
									(and
										(not (theStock size:))
										(not (flip1 size:))
										(not temp12)
									)
									(= temp5 1)
									(= temp0 -1)
									(= temp12 1)
								)
							)
							(else
								(if
									(and
										(==
											(((temp3 previousHand:)
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
												whatType:
											)
											0
										)
										(!= (temp3 owner:) flip1)
										(not (temp3 inPlay:))
									)
									(theStock size: (- (theStock size:) 1))
									(theStock adjust:)
									(temp3 setWhenPlayed: 1)
									(temp3 show: flip: 1)
								else
									((temp3 owner:) eliminateCard: temp3)
								)
								(++ temp8)
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
								(= temp0 -1)
								(= global225 temp4)
								(if (== temp8 8)
									(break)
								)
							)
						)
					)
				)
				(if
					(and
						(flip1 size:)
						(not (handleEventList contains: right1Button))
					)
					(handleEventList
						add:
							right1Button
							right2Button
							right3Button
							right4Button
							left1Button
							left2Button
							left3Button
							left4Button
					)
				)
				(if (== global225 temp4)
					(-- global225)
				)
				(if temp10
					(= global928 temp9)
					(= temp10 0)
				)
				(= global226 0)
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
				(= temp0 (getOne doit:))
				(= global395 0)
				(= cycles 1)
			)
			(2
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
				(if (== global225 0)
					(temp0 fromStock: 0)
					(= global226 1)
				)
				((theStock client:) add: temp0)
				(= global226 0)
				(++ temp1)
			)
			(temp0 inPlay: 1)
		)
		(= local16 0)
		(= global247 0)
		(return temp0)
	)
)

(instance optionCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (== param1 1)
			(if (or (sDealer script:) (not local7))
				(= global920 1)
				(if global896
					(gChar1 sayReg: 6005 15 128 0 (Random 1 2))
				else
					(gChar1 say: 6005 15 128 0 2)
				)
			else
				(= local6 0)
				(cleanUp doit:)
			)
			(return 1)
		)
		(return
			(if (and local4 (> (theStock size:) 0))
				(= local4 0)
				(theStock adjust:)
			)
		)
	)
)

(instance right1Button of TrackingView
	(properties
		x 55
		y 11
		view 971
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(= global247 1)
			(event claimed: 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 0)) (< temp0 5) ((++ temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (> temp1 -1) ((-- temp1))
						(if (== temp1 0)
							(hand1 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (- temp1 1)) at: 0)
							)
							((gTheHands at: (- temp1 1))
								eliminateCard:
									((gTheHands at: (- temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand6 size:)
					(= temp3 (hand6 at: 0))
					(= temp4 (temp3 rank:))
					(hand6 eliminateCard: temp3)
					(temp3 hide:)
					(for ((= temp0 0)) (< temp0 5) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
				)
				(for ((= temp1 5)) (> temp1 0) ((-- temp1))
					(if ((gTheHands at: (- temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (- temp1 1)) at: 0)
						)
						((gTheHands at: (- temp1 1))
							eliminateCard: ((gTheHands at: (- temp1 1)) at: 0)
						)
					)
				)
				(hand1 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance right2Button of TrackingView
	(properties
		x 55
		y 91
		view 971
		cel 1
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 6)) (< temp0 11) ((++ temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (> temp1 5) ((-- temp1))
						(if (== temp1 6)
							(hand7 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (- temp1 1)) at: 0)
							)
							((gTheHands at: (- temp1 1))
								eliminateCard:
									((gTheHands at: (- temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand12 size:)
					(= temp3 (hand12 at: 0))
					(= temp4 (temp3 rank:))
					(hand12 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 6)) (< temp0 11) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
				)
				(for ((= temp1 11)) (> temp1 6) ((-- temp1))
					(if ((gTheHands at: (- temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (- temp1 1)) at: 0)
						)
						((gTheHands at: (- temp1 1))
							eliminateCard: ((gTheHands at: (- temp1 1)) at: 0)
						)
					)
				)
				(hand7 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance right3Button of TrackingView
	(properties
		x 55
		y 171
		view 971
		cel 2
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 12)) (< temp0 17) ((++ temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (> temp1 11) ((-- temp1))
						(if (== temp1 12)
							(hand13 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (- temp1 1)) at: 0)
							)
							((gTheHands at: (- temp1 1))
								eliminateCard:
									((gTheHands at: (- temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand18 size:)
					(= temp3 (hand18 at: 0))
					(= temp4 (temp3 rank:))
					(hand18 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 12)) (< temp0 17) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
				)
				(for ((= temp1 17)) (> temp1 12) ((-- temp1))
					(if ((gTheHands at: (- temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (- temp1 1)) at: 0)
						)
						((gTheHands at: (- temp1 1))
							eliminateCard: ((gTheHands at: (- temp1 1)) at: 0)
						)
					)
				)
				(hand13 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance right4Button of TrackingView
	(properties
		x 55
		y 251
		view 971
		cel 3
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 18)) (< temp0 23) ((++ temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (> temp1 17) ((-- temp1))
						(if (== temp1 18)
							(hand19 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (- temp1 1)) at: 0)
							)
							((gTheHands at: (- temp1 1))
								eliminateCard:
									((gTheHands at: (- temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand24 size:)
					(= temp3 (hand24 at: 0))
					(= temp4 (temp3 rank:))
					(hand24 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 18)) (< temp0 23) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
							(break)
						)
					)
				)
				(for ((= temp1 23)) (> temp1 18) ((-- temp1))
					(if ((gTheHands at: (- temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (- temp1 1)) at: 0)
						)
						((gTheHands at: (- temp1 1))
							eliminateCard: ((gTheHands at: (- temp1 1)) at: 0)
						)
					)
				)
				(hand19 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance left1Button of TrackingView
	(properties
		x 436
		y 11
		view 971
		loop 1
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 5)) (> temp0 0) ((-- temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (< temp1 6) ((++ temp1))
						(if (== temp1 5)
							(hand6 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (+ temp1 1)) at: 0)
							)
							((gTheHands at: (+ temp1 1))
								eliminateCard:
									((gTheHands at: (+ temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand1 size:)
					(= temp3 (hand1 at: 0))
					(= temp4 (temp3 rank:))
					(hand1 eliminateCard: temp3)
					(temp3 hide:)
					(for ((= temp0 1)) (< temp0 6) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
				)
				(for ((= temp1 0)) (< temp1 5) ((++ temp1))
					(if ((gTheHands at: (+ temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (+ temp1 1)) at: 0)
						)
						((gTheHands at: (+ temp1 1))
							eliminateCard: ((gTheHands at: (+ temp1 1)) at: 0)
						)
					)
				)
				(hand6 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance left2Button of TrackingView
	(properties
		x 436
		y 91
		view 971
		loop 1
		cel 1
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 11)) (> temp0 6) ((-- temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (< temp1 12) ((++ temp1))
						(if (== temp1 11)
							(hand12 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (+ temp1 1)) at: 0)
							)
							((gTheHands at: (+ temp1 1))
								eliminateCard:
									((gTheHands at: (+ temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand7 size:)
					(= temp3 (hand7 at: 0))
					(= temp4 (temp3 rank:))
					(hand7 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 7)) (< temp0 12) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
				)
				(for ((= temp1 6)) (< temp1 11) ((++ temp1))
					(if ((gTheHands at: (+ temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (+ temp1 1)) at: 0)
						)
						((gTheHands at: (+ temp1 1))
							eliminateCard: ((gTheHands at: (+ temp1 1)) at: 0)
						)
					)
				)
				(hand12 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance left3Button of TrackingView
	(properties
		x 436
		y 171
		view 971
		loop 1
		cel 2
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 17)) (> temp0 12) ((-- temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (< temp1 18) ((++ temp1))
						(if (== temp1 17)
							(hand18 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (+ temp1 1)) at: 0)
							)
							((gTheHands at: (+ temp1 1))
								eliminateCard:
									((gTheHands at: (+ temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand13 size:)
					(= temp3 (hand13 at: 0))
					(= temp4 (temp3 rank:))
					(hand13 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 13)) (< temp0 18) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
				)
				(for ((= temp1 12)) (< temp1 17) ((++ temp1))
					(if ((gTheHands at: (+ temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (+ temp1 1)) at: 0)
						)
						((gTheHands at: (+ temp1 1))
							eliminateCard: ((gTheHands at: (+ temp1 1)) at: 0)
						)
					)
				)
				(hand18 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance left4Button of TrackingView
	(properties
		x 436
		y 251
		view 971
		loop 1
		cel 3
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= global247 1)
			(= temp3 0)
			(= temp4 0)
			(= temp2 0)
			(++ global225)
			(for ((= temp0 23)) (> temp0 18) ((-- temp0))
				(if (not ((gTheHands at: temp0) size:))
					(for ((= temp1 temp0)) (< temp1 24) ((++ temp1))
						(if (== temp1 23)
							(hand24 add: (flip1 at: 0))
							(flip1 eliminateCard: (flip1 at: 0))
						else
							((gTheHands at: temp1)
								add: ((gTheHands at: (+ temp1 1)) at: 0)
							)
							((gTheHands at: (+ temp1 1))
								eliminateCard:
									((gTheHands at: (+ temp1 1)) at: 0)
							)
						)
					)
					(= temp2 1)
					(break)
				)
			)
			(if (not temp2)
				(if (hand19 size:)
					(= temp3 (hand19 at: 0))
					(= temp4 (temp3 rank:))
					(hand19 eliminateCard: temp3)
					(temp3 hide:)
					(if (== temp4 ((flip1 at: 0) rank:))
						(temp3 inPlay: 0)
					)
					(for ((= temp0 19)) (< temp0 24) ((++ temp0))
						(if
							(and
								((gTheHands at: temp0) size:)
								(== temp4 (((gTheHands at: temp0) at: 0) rank:))
							)
							(temp3 inPlay: 0)
						)
					)
				)
				(for ((= temp1 18)) (< temp1 23) ((++ temp1))
					(if ((gTheHands at: (+ temp1 1)) size:)
						((gTheHands at: temp1)
							add: ((gTheHands at: (+ temp1 1)) at: 0)
						)
						((gTheHands at: (+ temp1 1))
							eliminateCard: ((gTheHands at: (+ temp1 1)) at: 0)
						)
					)
				)
				(hand24 add: (flip1 at: 0))
				(flip1 eliminateCard: (flip1 at: 0))
				(if temp3
					(cond
						((== global927 1)
							(temp3 inPlay: 1)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						((temp3 inPlay:)
							(wasteHand add: temp3)
							(temp3 show:)
						)
						(else
							(temp3 setWhenPlayed: setPreviousHand:)
							(Deck delete: temp3)
							(Deck addToFront: temp3)
							(resetStock doit:)
						)
					)
				)
			)
		)
	)
)

(instance resetStock of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= local11 (Deck topCard:))
		(= local12 (theStock size:))
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

(instance hand1 of sHand
	(properties
		x 78
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 78
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand1Empty of View
	(properties
		x 78
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand2 of sHand
	(properties
		x 137
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 137
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand2Empty of View
	(properties
		x 137
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand3 of sHand
	(properties
		x 197
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 197
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand3Empty of View
	(properties
		x 197
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand4 of sHand
	(properties
		x 257
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 257
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand4Empty of View
	(properties
		x 257
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand5 of sHand
	(properties
		x 317
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 317
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand5Empty of View
	(properties
		x 317
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand6 of sHand
	(properties
		x 377
		y 11
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 377
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand6Empty of View
	(properties
		x 377
		y 11
		priority 1
		view 915
		loop 8
	)
)

(instance hand7 of sHand
	(properties
		x 78
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 78
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand7Empty of View
	(properties
		x 78
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand8 of sHand
	(properties
		x 137
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 137
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand8Empty of View
	(properties
		x 137
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand9 of sHand
	(properties
		x 197
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 197
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand9Empty of View
	(properties
		x 197
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand10 of sHand
	(properties
		x 257
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 257
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand10Empty of View
	(properties
		x 257
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand11 of sHand
	(properties
		x 317
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 317
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand11Empty of View
	(properties
		x 317
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand12 of sHand
	(properties
		x 377
		y 91
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 377
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand12Empty of View
	(properties
		x 377
		y 91
		priority 1
		view 915
		loop 8
	)
)

(instance hand13 of sHand
	(properties
		x 78
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 78
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand13Empty of View
	(properties
		x 78
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand14 of sHand
	(properties
		x 137
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 137
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand14Empty of View
	(properties
		x 137
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand15 of sHand
	(properties
		x 197
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 197
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand15Empty of View
	(properties
		x 197
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand16 of sHand
	(properties
		x 257
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 257
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand16Empty of View
	(properties
		x 257
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand17 of sHand
	(properties
		x 317
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 317
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand17Empty of View
	(properties
		x 317
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand18 of sHand
	(properties
		x 377
		y 171
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 377
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand18Empty of View
	(properties
		x 377
		y 171
		priority 1
		view 915
		loop 8
	)
)

(instance hand19 of sHand
	(properties
		x 78
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 78
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand19Empty of View
	(properties
		x 78
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance hand20 of sHand
	(properties
		x 137
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 137
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand20Empty of View
	(properties
		x 137
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance hand21 of sHand
	(properties
		x 197
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 197
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand21Empty of View
	(properties
		x 197
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance hand22 of sHand
	(properties
		x 257
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 257
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand22Empty of View
	(properties
		x 257
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance hand23 of sHand
	(properties
		x 317
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 317
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand23Empty of View
	(properties
		x 317
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance hand24 of sHand
	(properties
		x 377
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 377
		cardLimit 1
		buildOrder 10
		startRank 3
		canPlay 1
		cardsUp 1
		whereTo 1
	)

	(method (add param1)
		(if argc
			(if (and (not global226) (not global247))
				(= global247 1)
				(++ global225)
				(super add: param1 &rest)
			else
				(super add: param1 &rest)
			)
		else
			(super add: &rest)
		)
	)
)

(instance hand24Empty of View
	(properties
		x 377
		y 250
		priority 1
		view 915
		loop 8
	)
)

(instance found1Hand of sHand
	(properties
		x 475
		y 11
		faceUp 1
		autoSorting 0
		whatType 1
		cardLimit 9
		buildStep 1
		wrapping 1
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(= temp0 global928)
		(super add: param1 &rest)
		(= global928 temp0)
	)
)

(instance found2Hand of sHand
	(properties
		x 475
		y 31
		faceUp 1
		autoSorting 0
		whatType 1
		cardLimit 9
		buildStep 1
		wrapping 1
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(if (not size)
			(= local14 ((found1Hand at: 8) priority:))
		)
		(= temp0 global928)
		(super add: param1 &rest)
		(= global928 temp0)
		(param1 priority: local14)
		(++ local14)
	)
)

(instance found3Hand of sHand
	(properties
		x 475
		y 51
		faceUp 1
		autoSorting 0
		whatType 1
		cardLimit 9
		buildStep 1
		wrapping 1
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(if (not size)
			(= local14 ((found2Hand at: 8) priority:))
		)
		(= temp0 global928)
		(super add: param1 &rest)
		(= global928 temp0)
		(param1 priority: local14)
		(++ local14)
	)
)

(instance found4Hand of sHand
	(properties
		x 475
		y 71
		faceUp 1
		autoSorting 0
		whatType 1
		cardLimit 9
		buildStep 1
		wrapping 1
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(if (not size)
			(= local14 ((found3Hand at: 8) priority:))
		)
		(= temp0 global928)
		(super add: param1 &rest)
		(= global928 temp0)
		(param1 priority: local14)
		(++ local14)
	)
)

(instance found5Hand of sHand
	(properties
		x 475
		y 91
		faceUp 1
		autoSorting 0
		whatType 1
		cardLimit 9
		buildStep 1
		wrapping 1
		whereTo 2
	)

	(method (add param1 &tmp temp0)
		(if (not size)
			(= local14 ((found4Hand at: 8) priority:))
		)
		(= temp0 global928)
		(super add: param1 &rest)
		(= global928 temp0)
		(param1 priority: local14)
		(++ local14)
	)
)

(instance flip1 of sHand
	(properties
		x 475
		y 250
		handDirection 2
		faceUp 1
		autoSorting 0
		centerX 475
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

(instance wasteHand of sHand
	(properties
		x 67
		y 331
		faceUp 1
		autoSorting 0
		whatType 4
		cardLimit 52
		buildOrder 10
		buildStep 1
		startRank 3
		wrapping 1
		whereTo 2
	)
)

(instance wasteEmpty of View
	(properties
		x 67
		y 331
		priority 1
		view 915
		loop 8
	)
)

(instance dealList of List
	(properties)
)

(instance theHands of List
	(properties)
)

(instance theFoundations of List
	(properties)
)

(instance magList of List
	(properties)
)

(instance tempList of List
	(properties)
)

(instance tempDeck of Set
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
		loop 23
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
		(proc6022_6 global928 90 4 1 {score} self)
		(proc6022_6 local17 90 20 1 {high} self)
	)
)

(instance tabView of View
	(properties
		view 733
	)

	(method (init)
		(self setPri: 256)
		(= local22 1)
		(super init: &rest)
	)
)

