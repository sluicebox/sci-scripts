;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 234)
(include sci.sh)
(use Main)
(use FwdCount)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	winnerScript 0
)

(local
	local0
	local1
)

(instance winnerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global527 0)
				(gGame setCursor: 999 1)
				(User controls: 1)
				(= global536 1)
				(= local1 0)
				(SetMenu 1025 112 0)
				(SetMenu 1026 112 0)
				(SetMenu 769 112 0)
				(proc0_7)
				(gTheWalker hide:)
				(proc0_1)
				(background1 setPri: (background1 priority:) init: addToPic:)
				(background2
					cel: (global302 whichBody:)
					setPri: (background2 priority:)
					init:
					addToPic:
				)
				(pedistal setPri: (pedistal priority:) init: 0)
				(proc0_1)
				(Palette palUNSET_FLAG 8 16 1)
				(Palette palUNSET_FLAG 144 255 1)
				(theWinner
					setPri: (theWinner priority:)
					view: (gTheWalker view:)
					init:
				)
				(proc0_1)
				(star1 setPri: (star1 priority:) init:)
				(star2 setPri: (star2 priority:) init:)
				(star3 setPri: (star3 priority:) init:)
				(star4 setPri: (star4 priority:) init:)
				(star5 setPri: (star5 priority:) init:)
				(star6 setPri: (star6 priority:) init:)
				(star7 setPri: (star7 priority:) init:)
				(star8 setPri: (star8 priority:) init:)
				(star9 setPri: (star9 priority:) init:)
				(star10 setPri: (star10 priority:) init:)
				(proc0_1)
				(pedistal init: 1)
				(gASoundEffect stop:)
				(gASoundEffect2 stop:)
				(gASong play: 7)
				(= cycles 10)
			)
			(1
				(= local0 (Random 0 1))
				(jonesGuy
					posn: (+ 20 (* local0 282)) 153
					setStep: 10 10
					setPri: (+ 2 (* (Random 0 1) 3))
					setLoop: (+ 2 local0)
					cel: 0
					setCycle: End jonesGuy
					setMotion: MoveTo (+ 20 (* (- 1 local0) 282)) 153 self
					init:
				)
			)
			(2
				(= local0 (Random 0 1))
				(jonesGuy
					posn: (+ 20 (* local0 282)) 153
					setPri: (+ 2 (* (Random 0 1) 3))
					setLoop: (+ 2 local0)
					cel: 0
					setCycle: End jonesGuy
					setMotion: MoveTo (+ 20 (* (- 1 local0) 282)) 153 self
				)
			)
			(4
				(jonesGuy hide:)
				(= cycles 10)
			)
			(5
				(self dispose:)
				(client script: 0)
				(= global532 1)
				(proc0_8)
				(SetMenu 1025 112 1)
				(SetMenu 1026 112 1)
				(= global536 0)
			)
			(6
				(self dispose:)
				(client script: 0)
				(= global532 1)
				(proc0_8)
				(SetMenu 1025 112 1)
				(SetMenu 1026 112 1)
				(= global536 0)
			)
		)
	)

	(method (cue)
		(if local1
			(= local1 0)
			(++ state)
		)
		(if (== state 2)
			(-- state)
		)
		(super cue:)
	)

	(method (dispose)
		(star1 dispose:)
		(star2 dispose:)
		(star3 dispose:)
		(star4 dispose:)
		(star5 dispose:)
		(star6 dispose:)
		(star7 dispose:)
		(star8 dispose:)
		(star9 dispose:)
		(star10 dispose:)
		(theWinner dispose:)
		(pedistal dispose:)
		(jonesGuy dispose:)
		(background1 dispose:)
		(background2 dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (>= state 2) (not (event claimed:)) (event type:))
			(event claimed: 1)
			(= local1 1)
		)
	)
)

(instance jonesGuy of Act
	(properties
		view 609
		priority 5
	)

	(method (cue &tmp temp0)
		(if (<= 70 x 260)
			(= temp0 (confetti new:))
			(temp0
				posn:
					(if (not local0)
						(+ x 50)
					else
						(- x 50)
					)
					y
				setLoop: (+ loop 2)
				cel: 0
				setPri: priority
				setCycle: End temp0
				init:
			)
		)
		(self setCycle: End self)
	)
)

(instance confetti of Prop
	(properties
		view 609
	)

	(method (cue)
		(self dispose:)
	)
)

(instance star1 of Prop
	(properties
		y 59
		x 129
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 5 setCycle: FwdCount)
		(super init:)
	)
)

(instance star2 of Prop
	(properties
		y 74
		x 119
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 4 setCycle: FwdCount)
		(super init:)
	)
)

(instance star3 of Prop
	(properties
		y 94
		x 114
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 6 setCycle: FwdCount)
		(super init:)
	)
)

(instance star4 of Prop
	(properties
		y 114
		x 119
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 5 setCycle: FwdCount)
		(super init:)
	)
)

(instance star5 of Prop
	(properties
		y 134
		x 124
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 4 setCycle: FwdCount)
		(super init:)
	)
)

(instance star6 of Prop
	(properties
		y 59
		x 186
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 6 setCycle: FwdCount)
		(super init:)
	)
)

(instance star7 of Prop
	(properties
		y 74
		x 196
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 5 setCycle: FwdCount)
		(super init:)
	)
)

(instance star8 of Prop
	(properties
		y 94
		x 201
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 4 setCycle: FwdCount)
		(super init:)
	)
)

(instance star9 of Prop
	(properties
		y 114
		x 196
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 6 setCycle: FwdCount)
		(super init:)
	)
)

(instance star10 of Prop
	(properties
		y 134
		x 191
		view 609
		loop 1
		priority 3
	)

	(method (init)
		(self cycleSpeed: 5 setCycle: FwdCount)
		(super init:)
	)
)

(instance pedistal of View
	(properties
		y 154
		x 160
		view 609
		priority 4
	)

	(method (init param1 &tmp temp0)
		(if (and argc param1)
			(cond
				((not global461)
					(= global461 global302)
					(= temp0 (Format @global100 234 0)) ; "WINNER"
				)
				((not global462)
					(= global462 global302)
					(= temp0 (Format @global100 234 1)) ; "2ND PLACE"
				)
				((not global463)
					(= global463 global302)
					(= temp0 (Format @global100 234 2)) ; "3RD PLACE"
				)
				((not global464)
					(= global464 global302)
					(= temp0 (Format @global100 234 3)) ; "4TH PLACE"
				)
			)
			(Display temp0 dsCOORD 137 148 dsCOLOR 0 dsBACKGROUND -1 dsFONT 10 dsALIGN alCENTER)
		else
			(super init:)
		)
	)
)

(instance theWinner of View
	(properties
		y 149
		x 160
		priority 3
	)
)

(instance background1 of View
	(properties
		y 44
		x 69
		cel 4
		priority 1
	)
)

(instance background2 of View
	(properties
		y 45
		x 70
		priority 1
	)
)

