;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	coloroom 0
)

(synonyms
	(butt cigarette)
	(colonel person man)
)

(local
	local0
	local1
)

(procedure (localproc_0) ; UNUSED
	(Print &rest #at 140 150 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance Colonel of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0200)))
				(event claimed: 1)
				(DoLook {colonel})
			)
			(
				(and
					(& global207 $0200)
					(or (MousedOn self event 3) (Said 'look/colonel'))
				)
				(event claimed: 1)
				(Print 240 0) ; "Distrustfully, the Colonel keeps an eye on you from his wheelchair."
			)
		)
	)
)

(instance smoke1 of Prop
	(properties)
)

(instance smoke2 of Prop
	(properties)
)

(instance coloroom of Rgn
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(super init:)
		(= temp1 175)
		(= temp2 140)
		(switch gAct
			(1
				(= temp0 253)
				(= temp1 133)
				(= temp2 98)
			)
			(2
				(= temp0 285)
			)
			(3
				(= temp0 292)
				(= temp1 229)
				(= temp2 95)
			)
			(5
				(= temp0 374)
			)
			(6
				(= temp0 375)
			)
			(else
				(= temp0 376)
			)
		)
		(Load rsFONT 4)
		(LoadMany rsMESSAGE 243 temp0)
		(Load rsVIEW 909)
		(= global208 512)
		(= [global377 9] temp0)
		(Colonel
			view: 304
			x: temp1
			y: temp2
			init:
			stopUpd:
			setScript: colonelActions
		)
		(smoke1
			view: 304
			loop: 2
			cel: 0
			posn: (+ (Colonel x:) 6) (- (Colonel y:) 30)
			setPri: (CoordPri (Colonel y:))
			init:
			hide:
		)
		(smoke2
			view: 304
			loop: 3
			cel: 0
			posn: (+ (Colonel x:) 11) (- (Colonel y:) 24)
			setPri: (CoordPri (Colonel y:))
			init:
			hide:
		)
		(Glow posn: (+ (Colonel x:) 10) (Colonel y:) z: 29 init: hide:)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'get,move,press/wheelchair')
					(Print 240 1) ; "The Colonel wouldn't like that."
				)
				((Said 'look/butt')
					(SetFlag 13)
					(Print 240 2) ; "The Colonel smokes a small, nasty-smelling cigar."
				)
				((Said 'listen/colonel')
					(Print 240 3) ; "He's not speaking to anyone."
				)
				((Said 'get/butt')
					(Print 240 4) ; "It belongs to the Colonel!"
				)
				((and (Said 'talk>') (Said '/colonel'))
					(= global213 10)
					(switch gAct
						(7
							(switch local1
								(0
									(Say 1 240 5) ; "I'm in no mood to mess with you! Get out of here!!"
								)
								(1
									(Say 1 240 6) ; "This is an order, young lady! Leave my room NOW!!"
								)
								(else
									(Print 240 7) ; "Colonel Dijon scowls and refuses to acknowledge you any longer."
								)
							)
						)
						(else
							(switch local1
								(0
									(Say 1 240 8) ; "Quit coming in my room, young lady!"
								)
								(1
									(Say 1 240 9) ; "I ain't in the mood to talk to you!"
								)
								(2
									(Say 1 240 10) ; "I don't even know you! Why're you coming in here!"
								)
								(else
									(Print 240 11) ; "The Colonel refuses to answer you. Instead, he sits in his wheelchair and scowls."
								)
							)
						)
					)
					(++ local1)
				)
			)
		)
	)
)

(instance colonelActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: Beg self
				)
			)
			(3
				(smoke2 setCycle: Fwd show:)
				(smoke1 show: setCycle: End self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)

