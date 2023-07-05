;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	Title 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(titleMusic pause: 1)
	(SetCursor gNormalCursor 1 300 172)
	(while (not temp0)
		(switch
			(Print
				{\nCamelot Game Options: }
				150
				{See the Intro   }
				2
				150
				{Start New Game}
				1
				150
				{ Restore Game   }
				3
				67
				-1
				(if (== (gCurRoom curPic:) 112) -1 else 140)
			)
			(0
				(titleMusic pause: 0)
				(SetCursor gNormalCursor 0 320 200)
				(return)
			)
			(1
				(= temp0 1)
				(gGame setSpeed: 6)
			)
			(2
				(= temp0 101)
				(gGame setSpeed: 6)
			)
			(3
				(gGame restore:)
			)
		)
	)
	(titleMusic stop:)
	(gCurRoom newRoom: temp0)
)

(instance KingArthur of PV
	(properties
		y 153
		x 106
		view 111
	)
)

(instance SearchForTheGrail of PV
	(properties
		y 163
		x 197
		view 111
		loop 1
	)
)

(instance whatDid of Prop
	(properties
		view 651
	)
)

(instance whatDid2 of Prop
	(properties
		view 651
	)
)

(instance firstName of Prop
	(properties
		view 651
	)
)

(instance lastName of Prop
	(properties
		view 651
	)
)

(instance middleName of Prop
	(properties
		view 651
	)
)

(instance sparkle of Prop
	(properties
		view 210
	)
)

(instance sparkle2 of Prop
	(properties
		view 210
	)
)

(instance grail of Prop
	(properties
		y 85
		x 240
		view 600
		loop 3
		cycleSpeed 2
	)
)

(instance leftFlash of Prop
	(properties
		y 76
		x 240
		view 600
		loop 1
		cycleSpeed 2
	)
)

(instance rightFlash of Prop
	(properties
		y 76
		x 241
		view 600
		loop 2
		cycleSpeed 2
	)
)

(instance Hand of Prop
	(properties
		y 83
		x 106
		view 600
		cel 1
	)
)

(instance titleMusic of Sound
	(properties)
)

(instance Title of Rm
	(properties
		picture 110
	)

	(method (init)
		(Load rsVIEW 600)
		(Load rsSOUND 1)
		(Load rsFONT 8)
		(Load rsFONT 0)
		(super init:)
		(HandsOff)
		(proc0_13 256)
		(gAddToPics doit:)
		(MenuBar state: 0)
		(titleMusic number: (proc0_20 1) play:)
		(self setScript: credits)
		(= local0
			(switch global103
				(0 5)
				(1 6)
				(else 7)
			)
		)
		(SetCursor gNormalCursor 0 320 200)
		(= global109 6)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(or (== (event message:) KEY_RETURN) (== (event message:) KEY_SPACE))
			)
			(event claimed: 1)
			(localproc_0)
		)
	)
)

(instance credits of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (< state 13) (== (titleMusic prevSignal:) 20))
				(= cycles (= seconds 0))
				(self changeState: 13)
			)
			((and (== state 20) (== (titleMusic prevSignal:) -1))
				(= cycles (= seconds 0))
				(self changeState: 21)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(SetCursor gNormalCursor 0 320 200)
				(sparkle loop: 0 cel: 0 posn: 186 155 init: setCycle: End)
				(= seconds 2)
			)
			(2
				(Display
					{\04 1990 Sierra On-Line, Inc.}
					dsFONT
					4
					dsCOORD
					90
					173
					dsCOLOR
					14
					dsBACKGROUND
					0
				)
				(sparkle loop: 1 cel: 0 posn: 145 128 setCycle: End)
				(= cycles 6)
			)
			(3
				(sparkle2 loop: 2 cel: 0 posn: 231 128 init: setCycle: End)
				(= cycles 14)
			)
			(4
				(sparkle loop: 1 cel: 0 posn: 283 128 setCycle: End)
				(= seconds 2)
			)
			(5
				(sparkle2 loop: 2 cel: 0 posn: 168 141 setCycle: End)
				(= cycles 16)
			)
			(6
				(sparkle loop: 0 cel: 0 posn: 42 131 setCycle: End)
				(= cycles 8)
			)
			(7
				(sparkle loop: 2 cel: 0 posn: 110 128 setCycle: End)
				(= seconds 2)
			)
			(8
				(sparkle2 loop: 0 cel: 0 posn: 184 135 setCycle: End)
				(= seconds 2)
			)
			(9
				(sparkle hide:)
				(sparkle2 hide:)
				(gCurRoom style: (if (== global103 0) 100 else 8) drawPic: 111)
				(proc0_13 258)
				(gAddToPics add: KingArthur SearchForTheGrail)
				(gAddToPics doit:)
				(grail init: setPri: 10 stopUpd:)
				(if (!= global103 0)
					(grail setCycle: Fwd)
				)
				(leftFlash init: setPri: 5 setCycle: Fwd)
				(rightFlash init: setPri: 5 setCycle: Fwd)
				(= seconds 2)
			)
			(10
				(sparkle
					loop: 0
					cel: 0
					posn: 235 49
					setPri: 14
					show:
					setCycle: End
				)
				(= seconds 2)
			)
			(11
				(sparkle loop: 1 cel: 0 posn: 237 91 setCycle: End)
				(= seconds 2)
			)
			(12
				(if (== global103 0)
					(self changeState: 14)
				else
					(sparkle loop: 0 cel: 0 posn: 268 56 setCycle: End)
					(= seconds 2)
				)
			)
			(13
				(= seconds 3)
			)
			(14
				(grail hide:)
				(leftFlash hide:)
				(rightFlash hide:)
				(sparkle hide:)
				(gCurRoom style: (if (== global103 0) 100 else 7) drawPic: 100)
				(proc0_13 258)
				(gAddToPics doit:)
				(Hand cycleSpeed: 4 init:)
				(whatDid posn: 200 40 setLoop: 1 setCel: 1 init:)
				(whatDid2 posn: 235 55 setLoop: 1 setCel: 3 init:)
				(firstName posn: 200 90 setLoop: 4 setCel: 2 init:)
				(lastName posn: 250 125 setLoop: 4 setCel: 3 init:)
				(Hand setCycle: End)
				(= seconds local0)
			)
			(15
				(whatDid posn: 225 40 setLoop: 0 setCel: 0)
				(whatDid2 hide:)
				(firstName posn: 220 80 setLoop: 2 setCel: 0)
				(lastName posn: 260 115 setLoop: 2 setCel: 1)
				(Hand setCycle: Beg)
				(= seconds local0)
			)
			(16
				(whatDid posn: 225 40 setLoop: 0 setCel: 1)
				(firstName posn: 220 80 setLoop: 2 setCel: 2)
				(lastName posn: 260 115 setLoop: 2 setCel: 3)
				(Hand setCycle: End)
				(= seconds local0)
			)
			(17
				(whatDid posn: 225 40 setLoop: 1 setCel: 2)
				(firstName posn: 220 80 setLoop: 6 setCel: 0)
				(middleName posn: 235 115 setLoop: 6 setCel: 1 init:)
				(lastName posn: 265 150 setLoop: 6 setCel: 2)
				(= seconds local0)
			)
			(18
				(middleName dispose:)
				(whatDid posn: 225 40 setLoop: 0 setCel: 2)
				(firstName posn: 210 80 setLoop: 4 setCel: 0)
				(lastName posn: 250 115 setLoop: 4 setCel: 1)
				(= seconds local0)
			)
			(19
				(whatDid posn: 225 40 setLoop: 1 setCel: 0)
				(firstName posn: 220 80 setLoop: 5 setCel: 0)
				(lastName posn: 260 115 setLoop: 5 setCel: 1)
				(= seconds local0)
			)
			(20
				(= seconds 6)
			)
			(21
				(whatDid dispose:)
				(firstName dispose:)
				(lastName dispose:)
				(Hand dispose:)
				(RedrawCast)
				(gCurRoom style: (if (== global103 0) 100 else 8) drawPic: 112)
				(while (== gCurRoomNum gNewRoomNum)
					(localproc_0)
				)
			)
		)
	)
)

