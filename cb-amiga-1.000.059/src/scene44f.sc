;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene44f 0
)

(local
	local0
)

(instance Lillian of Prop
	(properties)
)

(instance Eyes of Prop
	(properties)
)

(instance Head of Prop
	(properties)
)

(instance Hand of Act
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene44f of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsFONT 41)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 29 94 95 96)
		(LoadMany rsMESSAGE 406)
		(myMusic number: 27 loop: -1 play:)
		(Lillian
			view: 518
			posn: 250 110
			loop: 1
			cel: 0
			setPri: 1
			init:
			stopUpd:
		)
		(Head view: 518 posn: 248 93 loop: 0 cel: 0 setPri: 1 init: stopUpd:)
		(if (== gAct 5)
			(Hand
				view: 518
				posn: 225 118
				setLoop: 5
				cel: 0
				setPri: 2
				setScript: writing
				init:
			)
		)
		(Eyes
			view: 518
			posn: 237 73
			loop: 2
			cel: 0
			setPri: 2
			setScript: movements
			init:
			stopUpd:
		)
		(self setScript: twice)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance twice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(if (== gAct 5)
					(Print 335 0 #width 240 #dispose) ; "Lillian is writing in a book which she apparently keeps locked in her suitcase."
				else
					(Print 335 1 #width 240 #dispose) ; "Lillian is apparently resting on her bed."
				)
				(= seconds 8)
			)
			(2
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance writing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Hand setMotion: MoveTo 225 118 self)
			)
			(1
				(if (!= (Random 1 8) 1)
					(= state 0)
					(Hand
						setCel: -1
						setCycle: Fwd
						posn: (- 225 (Random 0 3)) (- 118 (Random 0 3))
					)
					(= cycles 2)
				else
					(Hand setMotion: MoveTo 225 118 self)
				)
			)
			(2
				(Hand setCel: 0 setCycle: 0 setMotion: MoveTo 228 115 self)
			)
			(3
				(= state -1)
				(= cycles (Random 5 10))
			)
		)
	)
)

(instance movements of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (Head cel:))
				(if (== (Random 1 7) 1)
					(Head cel: (^= temp0 $0001))
				)
				(Eyes cel: (^ (Eyes cel:) $0001) y: (+ 73 temp0) forceUpd:)
				(= state -1)
				(if (Eyes cel:)
					(Eyes loop: (Random 2 4))
					(= cycles 2)
				else
					(= seconds (Random 1 3))
				)
			)
		)
	)
)

