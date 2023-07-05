;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use n824)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	HutSwimRm 0
)

(local
	local0
)

(instance HutSwimRm of Rm
	(properties
		picture 8
		horizon 120
		east 16
		south 15
		west 15
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(3 ; volleyRm
				(gEgo x: (+ (/ (gEgo x:) 8) 260))
			)
			(4 ; beachHuts1
				(if (== (gEgo loop:) 1)
					(gEgo
						x:
							(cond
								((< (gEgo y:) 104) 154)
								((< (gEgo y:) 146) 207)
								((< (gEgo y:) 200) 252)
							)
						loop: 2
					)
				else
					(gEgo x: 261 loop: 0)
				)
			)
			(5 ; beachHuts2
				(if (== (gEgo loop:) 1)
					(gEgo
						x:
							(cond
								((< (gEgo y:) 104)
									(+ (/ (gEgo y:) 2) 8)
								)
								((< (gEgo y:) 146)
									(- (gEgo y:) 30)
								)
								((< (gEgo y:) 200) 144)
							)
						loop: 2
					)
				else
					(gEgo x: 147 loop: 0)
				)
			)
			(6 ; inEgosHut
				(gEgo x: 122 loop: 2)
			)
			(7 ; endBeach
				(gEgo x: 14)
			)
		)
		(gEgo init: view: 217 setLoop: -1 y: (+ 5 horizon))
		(self setRegions: 301 300 308) ; Water, tahiti, oceanRg
		(gAddToPics
			add:
				hut1
				hut2
				hut3
				hut4
				hotelHut
				tree
				((Clone tree) x: 220 y: 89 yourself:)
				((Clone tree) x: 114 y: 87 yourself:)
				((Clone tree) x: 301 y: 94 yourself:)
			eachElementDo: #init
			eachElementDo: #priority 1
			doit:
		)
		(proc824_0)
		(pixelPerson init:)
	)

	(method (doit)
		(if (< (gEgo y:) horizon)
			(self
				newRoom:
					(cond
						((<= (gEgo x:) 55) 7)
						((<= (gEgo x:) 117) 5)
						((<= (gEgo x:) 127) 6)
						((<= (gEgo x:) 250) 4)
						(else 3)
					)
			)
		else
			(super doit:)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(switch newRoomNumber
			(7 ; endBeach
				(gEgo y: (+ (gEgo x:) 125) loop: 0)
			)
			(5 ; beachHuts2
				(cond
					((<= (gEgo x:) 76)
						(gEgo posn: 84 103 view: 200 loop: 0)
					)
					((<= (gEgo x:) 127)
						(gEgo posn: 72 137 view: 200 loop: 0)
					)
					((<= (gEgo x:) 152)
						(gEgo posn: 10 185 loop: 0)
					)
				)
			)
			(4 ; beachHuts1
				(cond
					((<= (gEgo x:) 181)
						(gEgo posn: 84 103 view: 200 loop: 0)
					)
					((<= (gEgo x:) 233)
						(gEgo posn: 72 137 view: 200 loop: 0)
					)
					((<= (gEgo x:) 250)
						(gEgo posn: 10 185 loop: 0)
					)
				)
			)
			(3 ; volleyRm
				(gEgo x: (/ (* (- (gEgo x:) 250) 32) 7))
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]>')
				(cond
					((Said '/building')
						(Print 8 0) ; "You see four beach huts on the peaceful Tahitian shore."
					)
					((Said '/hotel')
						(Print 8 1) ; "You see the beach front hotel on the beautiful Tahitian shore."
					)
					((Said '/palm')
						(Print 8 2) ; "You see many Palm trees along the shore."
					)
					((Said '/bush')
						(Print 8 3) ; "You see the dense Tahitian jungle."
					)
				)
			)
		)
	)
)

(instance hut1 of RPicView
	(properties
		y 97
		x 125
		view 8
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/building')
				(Print 8 4) ; "This is your hut, hut #6."
			)
		)
	)
)

(instance hut2 of RPicView
	(properties
		y 95
		x 74
		view 8
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/building')
				(Print 8 5) ; "This is hut #7."
			)
		)
	)
)

(instance hut3 of RPicView
	(properties
		y 98
		x 177
		view 8
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/building')
				(Print 8 6) ; "This is hut #5."
			)
		)
	)
)

(instance hut4 of RPicView
	(properties
		y 102
		x 231
		view 8
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/building')
				(Print 8 7) ; "This is hut #4."
			)
		)
	)
)

(instance hotelHut of RPicView
	(properties
		y 96
		x 310
		view 8
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/building,hotel')
				(Print 8 8) ; "This is the Hotel."
			)
		)
	)
)

(instance tree of RPicView
	(properties
		y 88
		x 56
		view 8
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/palm')
				(Print 8 9) ; "You see your average everyday generic Palm tree."
			)
		)
	)
)

(instance pixelPerson of Act
	(properties
		view 1
		loop 5
	)

	(method (init)
		(super init:)
		(self
			hide:
			setPri: 0
			setStep: 1 1
			setLoop:
			illegalBits: 0
			ignoreHorizon:
			moveSpeed: 1
			setScript: paceScript
		)
	)
)

(instance paceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(client posn: 23 90 show: setMotion: MoveTo 330 100 self)
			)
			(2
				(client hide:)
				(= seconds (Random 2 10))
			)
			(3
				(client show: setMotion: MoveTo 23 90 self)
			)
			(4
				(client hide:)
				(self init:)
			)
		)
	)
)

