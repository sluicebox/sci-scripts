;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n940)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	local0
	local1
	[local2 5]
	[local7 15]
	[local22 4]
	[local26 10] = [0 1 2 3 4 5 10 20 50 -1]
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 [temp3 4])
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local2 temp0] 1)
	)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(= [local7 temp0] (* temp0 10))
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(= [local22 temp0] (* temp0 10))
	)
	(hand eachElementDo: #dispose eachElementDo: #perform clearCode)
	(deck eachElementDo: #perform clearCode)
	(= local41 0)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(= temp1 (= temp2 0))
		(while (deck firstTrue: #perform uniqueCode temp1 temp2)
			(if global159
				(Format @temp3 720 2 temp0) ; "Card #%d"
				(= temp1
					(PrintD
						@temp3
						109
						78
						{2}
						2
						78
						{3}
						3
						78
						{4}
						4
						78
						{5}
						5
						78
						{6}
						6
						78
						{7}
						7
						78
						{8}
						8
						78
						{9}
						9
						109
						78
						{10}
						10
						78
						{Jack}
						11
						78
						{Queen}
						12
						78
						{King}
						13
						78
						{Ace}
						14
					)
				)
				(= temp2
					(PrintD
						@temp3
						109
						78
						{Clubs}
						1
						109
						78
						{Spades}
						2
						109
						78
						{Diamonds}
						3
						109
						78
						{Hearts}
						4
					)
				)
				(-- temp2)
			else
				(= temp1 (Random 2 14))
				(= temp2 (Random 0 3))
			)
		)
		((deck at: temp0) view: 722 loop: temp2 cel: temp1)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0 (hand at: param1))
	(= temp1 (deck at: local41))
	(dealSound play:)
	(temp0
		view: 722
		setLoop: (temp1 loop:)
		setCel: (temp1 cel:)
		x: (+ 55 (* param1 44))
		y: 50
		init:
	)
	(++ local41)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(++ [local7 ((hand at: temp0) cel:)])
		(++ [local22 ((hand at: temp0) loop:)])
	)
	(localproc_3)
	(switch (mod [local7 0] 10)
		(4
			(= local36 7)
		)
		(3
			(if (== (mod [local7 1] 10) 2)
				(= local36 6)
			else
				(= local36 3)
			)
		)
		(2
			(cond
				((== (mod [local7 1] 10) 2)
					(= local36 2)
				)
				((>= (/ [local7 0] 10) 11)
					(= local36 1)
				)
				(else
					(= local36 0)
				)
			)
		)
		(else
			(Sorts hand sortHand sortCode)
			(= temp1 ((sortHand at: 0) cel:))
			(= temp2 ((sortHand at: 4) cel:))
			(= temp3 ((sortHand at: 3) cel:))
			(sortHand release: dispose:)
			(if (and (== temp2 14) (== temp1 2) (== temp3 5))
				(= temp4 1)
			else
				(= temp4 (if (== (- temp2 temp1) 4) 1 else 0))
			)
			(cond
				((== (mod [local22 0] 10) 5)
					(cond
						((not temp4)
							(= local36 5)
						)
						((== temp1 10)
							(= local36 9)
						)
						(else
							(= local36 8)
						)
					)
				)
				(temp4
					(= local36 4)
				)
				(else
					(= local36 0)
				)
			)
		)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 [temp3 100])
	(for ((= temp0 0)) (< temp0 14) ((++ temp0))
		(for ((= temp1 (+ temp0 1))) (< temp1 15) ((++ temp1))
			(if (> (mod [local7 temp1] 10) (mod [local7 temp0] 10))
				(= temp2 [local7 temp0])
				(= [local7 temp0] [local7 temp1])
				(= [local7 temp1] temp2)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
			(if (> (mod [local22 temp1] 10) (mod [local22 temp0] 10))
				(= temp2 [local22 temp0])
				(= [local22 temp0] [local22 temp1])
				(= [local22 temp1] temp2)
			)
		)
	)
)

(procedure (localproc_4)
	(-= local39 local38)
	(= local40 1)
	(localproc_5)
)

(procedure (localproc_5 &tmp [temp0 50])
	(Display 720 3 dsCOORD 60 25 dsFONT gSmallFont dsCOLOR global129 dsBACKGROUND global123) ; "Win:$       Bet:$       Credits:$"
	(Display 720 4 dsRESTOREPIXELS local44)
	(Format @temp0 720 5 local37) ; "%d"
	(= local44
		(Display @temp0 dsCOORD 80 25 dsFONT gSmallFont dsCOLOR global129 dsBACKGROUND global123)
	)
	(Display 720 4 dsRESTOREPIXELS local45)
	(Format @temp0 720 6 local38) ; "%d"
	(= local45
		(Display @temp0 dsCOORD 153 25 dsFONT gSmallFont dsCOLOR global129 dsBACKGROUND global123)
	)
	(Display 720 4 dsRESTOREPIXELS local46)
	(Format @temp0 720 6 local39) ; "%d"
	(= local46
		(Display @temp0 dsCOORD 242 25 dsFONT gSmallFont dsCOLOR global129 dsBACKGROUND global123)
	)
)

(procedure (localproc_6 param1)
	(param1 setLoop: -1 play:)
	(User canInput: 0)
	(while local37
		(localproc_5)
		(if (> local37 10)
			(-= local37 10)
			(+= local39 10)
		else
			(-- local37)
			(++ local39)
		)
		(Wait 0)
		(Wait 10)
	)
	(param1 setLoop: 1)
	(User canInput: 1)
)

(instance rm720 of LLRoom
	(properties
		picture 720
		style 10
	)

	(method (init)
		(gTheIconBar disable: 3 6 7 4 0 8 6 curIcon: (gTheIconBar at: 2))
		(super init:)
		(= local0 gSpeed)
		(= gSpeed 6)
		(incBet init:)
		(decBet init:)
		(cashout init:)
		(hold1 init:)
		(hold2 init:)
		(hold3 init:)
		(hold4 init:)
		(hold5 init:)
		(deal init:)
		(deck
			add:
				cardD0
				cardD1
				cardD2
				cardD3
				cardD4
				cardD5
				cardD6
				cardD7
				cardD8
				cardD9
		)
		(hand add: cardH0 cardH1 cardH2 cardH3 cardH4)
		(if (= local39 global158)
			(= local38 1)
		)
		(localproc_5)
		(self setScript: waitASecScript self)
	)

	(method (cue)
		(self setScript: sPlayPokerScript)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(proc0_2)
		(proc0_32 gWaitCursor)
	)

	(method (doVerb theVerb &tmp [temp0 200])
		(switch theVerb
			(1
				(Format @temp0 720 0 global163) ; "Video Poker Odds  Progressive Royal Flush  $%d  Straight Flush      50 to 1  4 of a Kind        20 to 1  Full House        10 to 1  Flush           5 to 1  Straight          4 to 1  3 of a Kind        3 to 1  2 Pair           2 to 1  Pair, Jacks or Better   1 to 1"
				(proc0_28
					@temp0
					77
					{Welcome to Tramp's Casino}
					30
					global293
					64
					-1
					15
					67
					260
				)
			)
			(else
				(proc0_28 720 1)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (GameIsRestarting)
			(localproc_5)
		)
	)

	(method (dispose)
		(hand dispose:)
		(deck dispose:)
		(sortHand dispose:)
		(gTheIconBar enable: 0)
		(proc0_2)
		(= gSpeed local0)
		(super dispose:)
	)
)

(instance deck of Set
	(properties)
)

(instance hand of Set
	(properties)
)

(instance sortHand of Set
	(properties)
)

(instance sortCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (not (= temp0 (param1 cel:)))
			(= temp0 13)
		)
		(return temp0)
	)
)

(instance clearCode of Code
	(properties)

	(method (doit param1)
		(param1 view: 722 setLoop: 0 setCel: 0)
	)
)

(instance cardH0 of View
	(properties)
)

(instance cardH1 of View
	(properties)
)

(instance cardH2 of View
	(properties)
)

(instance cardH3 of View
	(properties)
)

(instance cardH4 of View
	(properties)
)

(instance cardD0 of View
	(properties)
)

(instance cardD1 of View
	(properties)
)

(instance cardD2 of View
	(properties)
)

(instance cardD3 of View
	(properties)
)

(instance cardD4 of View
	(properties)
)

(instance cardD5 of View
	(properties)
)

(instance cardD6 of View
	(properties)
)

(instance cardD7 of View
	(properties)
)

(instance cardD8 of View
	(properties)
)

(instance cardD9 of View
	(properties)
)

(instance uniqueCode of Code
	(properties)

	(method (doit param1 param2 param3)
		(return (and (== (param1 loop:) param3) (== (param1 cel:) param2)))
	)
)

(instance incBet of Prop
	(properties
		x 132
		y 176
		view 720
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (self onMe: event)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(while
					(and
						(!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(self onMe: temp0)
					)
					(= temp1 (GetTime))
					(while (< (GetTime) (+ 6 temp1))
					)
					(self doVerb: 2)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(event claimed: 1)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem &tmp [temp0 10])
		(switch theVerb
			(2
				(if local43
					(if (< local38 100)
						(cond
							(local40
								(proc0_28 720 7)
							)
							((< local38 local39)
								(buttonSound play:)
								(++ local38)
								(= local37 0)
								(localproc_5)
							)
							(else
								(proc0_28 720 8)
							)
						)
					else
						(proc0_28 720 9)
					)
				)
			)
			(1
				(Print 720 10) ; "Click the Hand here to increase your bet."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance decBet of Prop
	(properties
		x 175
		y 172
		view 720
		loop 1
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (self onMe: event)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(while
					(and
						(!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(self onMe: temp0)
					)
					(= temp1 (GetTime))
					(while (< (GetTime) (+ 6 temp1))
					)
					(self doVerb: 2)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(event claimed: 1)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem &tmp [temp0 10])
		(switch theVerb
			(2
				(if local43
					(cond
						(local40
							(proc0_28 720 7)
						)
						((> local38 1)
							(buttonSound play:)
							(if (and (not (-- local38)) gModelessDialog)
								(gModelessDialog dispose:)
							)
							(= local37 0)
							(localproc_5)
						)
						(else
							(proc0_28 720 11)
						)
					)
				)
			)
			(1
				(Print 720 12) ; "Click the Hand here to decrease your bet."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cashout of View
	(properties
		x 287
		y 151
		view 720
		loop 2
	)

	(method (doVerb theVerb invItem)
		(= global158 local39)
		(switch theVerb
			(2
				(buttonSound play:)
				(if (and local43 (proc0_6 102))
					(self setCel: 1)
					(Animate (gCast elements:) 0)
					(Animate (gCast elements:) 0)
					(if local39
						(gLongSong2 number: 723 loop: 1 flags: 1 play:)
						(Print 720 13) ; "You take your money from the tray."
					else
						(Print 720 14) ; "You leave the table empty handed."
					)
					(gCurRoom newRoom: 100)
				else
					(proc0_28 720 15)
				)
			)
			(1
				(Print 720 16) ; "Click the Hand here to stop playing this machine. Your winnings will be given to you automatically."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deal of View
	(properties
		x 29
		y 151
		sightAngle 40
		view 720
		loop 3
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(2
				(if local43
					(buttonSound play:)
					(localproc_5)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(if local38
						(if (not local40)
							(++ global163)
							(localproc_4)
						)
						(self setCel: 1)
						(= local43 0)
						(= local42 0)
						(sPlayPokerScript cue:)
					else
						(proc0_28 720 17)
					)
				)
			)
			(1
				(Print 720 18) ; "Click the Hand here to begin a new hand of poker."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold1 of View
	(properties
		x 68
		y 151
		sightAngle 40
		view 720
		loop 4
	)

	(method (onMe &tmp temp0)
		(= temp0 (hand at: 0))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject temp0)
					(gCast contains: temp0)
					(temp0 onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 0] 1)
						(self setCel: 0)
					else
						(= [local2 0] 0)
						(self setCel: 1)
					)
				)
			)
			(1
				(Print 720 19) ; "Click the Hand here to hold card #1."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold2 of View
	(properties
		x 114
		y 151
		sightAngle 40
		view 720
		loop 4
	)

	(method (onMe &tmp temp0)
		(= temp0 (hand at: 1))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject temp0)
					(gCast contains: temp0)
					(temp0 onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 1] 1)
						(self setCel: 0)
					else
						(= [local2 1] 0)
						(self setCel: 1)
					)
				)
			)
			(1
				(Print 720 20) ; "Click the Hand here to hold card #2."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold3 of View
	(properties
		x 159
		y 151
		sightAngle 40
		view 720
		loop 4
	)

	(method (onMe &tmp temp0)
		(= temp0 (hand at: 2))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject temp0)
					(gCast contains: temp0)
					(temp0 onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 2] 1)
						(self setCel: 0)
					else
						(= [local2 2] 0)
						(self setCel: 1)
					)
				)
			)
			(1
				(Print 720 21) ; "Click the Hand here to hold card #3."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold4 of View
	(properties
		x 203
		y 151
		sightAngle 40
		view 720
		loop 4
	)

	(method (onMe &tmp temp0)
		(= temp0 (hand at: 3))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject temp0)
					(gCast contains: temp0)
					(temp0 onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 3] 1)
						(self setCel: 0)
					else
						(= [local2 3] 0)
						(self setCel: 1)
					)
				)
			)
			(1
				(Print 720 22) ; "Click the Hand here to hold card #4."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold5 of View
	(properties
		x 246
		y 151
		sightAngle 40
		view 720
		loop 4
	)

	(method (onMe &tmp temp0)
		(= temp0 (hand at: 4))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject temp0)
					(gCast contains: temp0)
					(temp0 onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2
				(if local42
					(buttonSound play:)
					(if cel
						(= [local2 4] 1)
						(self setCel: 0)
					else
						(= [local2 4] 0)
						(self setCel: 1)
					)
				)
			)
			(1
				(Print 720 23) ; "Click the Hand here to hold card #5."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dealSound of Sound
	(properties
		number 721
	)
)

(instance buttonSound of Sound
	(properties
		number 722
	)
)

(instance cashOutSound of Sound ; UNUSED
	(properties
		number 723
	)
)

(instance winSound of Sound
	(properties
		number 724
		loop -1
	)
)

(instance bigWinSound of Sound ; UNUSED
	(properties
		number 724
		loop -1
	)
)

(instance loseSound of Sound
	(properties
		flags 1
		number 726
	)
)

(instance sPlayPokerScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 50])
		(switch (= state newState)
			(0
				(proc0_3)
				(= local43 1)
				(proc0_7 102)
			)
			(1
				(localproc_0)
				(proc0_8 102)
				(gTheIconBar disable: 8)
				(= cycles 2)
			)
			(2
				(localproc_1 register)
				(= cycles 4)
			)
			(3
				(if (< (++ register) 5)
					(-= state 2)
				)
				(= cycles 1)
			)
			(4
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(= local43 1)
				(= local42 1)
			)
			(5
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(if [local2 temp0]
						((hand at: temp0) dispose:)
					)
				)
				(= register 0)
				(= cycles 2)
			)
			(6
				(if [local2 register]
					(localproc_1 register)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(7
				(if (< (++ register) 5)
					(-= state 2)
				)
				(= cycles 1)
			)
			(8
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(++ local1)
				(localproc_2)
				(if (== local36 9)
					(Format @temp1 720 24 global163) ; "P R O G R E S S I V E J A C K P O T  ! !  You win %d dollars!"
					(proc0_28
						@temp1
						67
						200
						77
						{Another Lucky Winner}
						30
						gBigFont
						27
						1
					)
					(= global163 1000)
					(+= global158 1000)
					(gCurRoom newRoom: 100)
				else
					(= local37 (* local38 [local26 local36]))
					(localproc_5)
					(= cycles 5)
				)
			)
			(9
				(if local37
					(localproc_6 winSound)
				else
					(loseSound play:)
				)
				(= cycles 1)
			)
			(10
				(if (> local38 local39)
					(= local38 local39)
				)
				(localproc_5)
				(if local39
					(= local40 (= register 0))
					(self init:)
				else
					(proc0_28 720 25)
					(proc0_7 102)
					(= global158 0)
					(gCurRoom newRoom: 100)
				)
			)
		)
	)
)

(instance waitASecScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(= seconds 2)
			)
			(1
				(proc0_3)
				(proc0_31)
				(self dispose:)
			)
		)
	)
)

