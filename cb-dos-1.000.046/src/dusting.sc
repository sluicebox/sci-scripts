;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 267)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	dusting 0
)

(synonyms
	(fifi person woman)
)

(local
	local0
	local1
	[local2 12] = [96 145 216 143 165 155 189 104 111 104 34 92]
	local14
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 140 150 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance dusting of Rgn
	(properties)

	(method (init)
		(super init:)
		(= gFifiState 1)
		(Load rsFONT 4)
		(LoadMany rsMESSAGE 243 294)
		(LoadMany rsVIEW 470 904)
		(= global208 16)
		(= [global377 4] 294)
		(Fifi
			view: 464
			setAvoider: ((Avoid new:) offScreenOK: 1)
			init:
			setScript: fifiActions
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance fifiActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local0 3)
					(Fifi setMotion: MoveTo 177 144 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== local0 3)
					(Fifi setMotion: MoveTo 170 124 self)
				else
					(= cycles 1)
				)
			)
			(2
				(= local14 0)
				(Fifi
					view: 464
					setCycle: Walk
					ignoreActors: 0
					setMotion:
						MoveTo
						[local2 (* local0 2)]
						[local2 (+ (* local0 2) 1)]
						self
				)
			)
			(3
				(Fifi
					view: 470
					cel: 0
					loop:
						(switch local0
							(0 4)
							(1 4)
							(2 5)
							(3 1)
							(4 0)
							(5 1)
						)
					setCycle: End self
				)
			)
			(4
				(Fifi
					loop:
						(switch local0
							(0 6)
							(1 6)
							(2 7)
							(3 3)
							(4 2)
							(5 3)
						)
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(5
				(Fifi
					cel: 2
					loop:
						(switch local0
							(0 4)
							(1 4)
							(2 5)
							(3 1)
							(4 0)
							(5 1)
						)
					setCycle: Beg self
				)
			)
			(6
				(Fifi view: 464 setCycle: Walk ignoreActors: 0)
				(if (< local0 5)
					(++ local0)
					(= state -1)
				)
				(= cycles 1)
			)
			(7
				(Fifi setMotion: MoveTo -20 98 self)
			)
			(8
				(= gFifiState 2)
				(Fifi dispose:)
			)
		)
	)
)

(instance Fifi of Act
	(properties
		y 140
		x 196
	)

	(method (handleEvent event)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0010)))
				(event claimed: 1)
				(DoLook {fifi})
			)
			(
				(and
					(& global207 $0010)
					(or (MousedOn self event 3) (Said 'look/fifi'))
				)
				(event claimed: 1)
				(Print 267 0) ; "Fifi is busily dusting away!"
			)
			((and (== (event type:) evSAID) (Said '*/fifi>'))
				(cond
					((Said 'talk')
						(= global213 5)
						(switch local1
							(0
								(Say 1 267 1) ; "I must hurry and finish zee dusting, Mademoiselle!"
							)
							(1
								(Say 1 267 2) ; "Mademoiselle, s'il vous plait, do not bother me now!"
							)
							(2
								(Say 1 267 3) ; "Eet does not appear good for me to talk with you, Mademoiselle."
							)
							(3
								(Say 1 267 4) ; "Please, Mademoiselle!"
							)
							(else
								(Say 1 267 5) ; "I must not talk to you now!"
							)
						)
						(++ local1)
					)
					((Said 'listen')
						(Print 267 6) ; "She's not talking; she's too busy dusting."
					)
				)
			)
		)
	)
)

