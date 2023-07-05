;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 334)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene48f 0
)

(local
	local0
)

(instance Clarence of Prop
	(properties)
)

(instance Eye of Prop
	(properties)
)

(instance Hand of Act
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene48f of Rm
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
		(Clarence
			view: 411
			posn: 126 104
			loop: 2
			cel: 0
			setPri: 2
			ignoreActors: 1
			init:
		)
		(Hand
			view: 411
			posn: 92 109
			setLoop: 3
			cel: 0
			setPri: 1
			setScript: writing
			init:
		)
		(Eye
			view: 411
			posn: 102 75
			setLoop: 4
			cel: 1
			setPri: 3
			setScript: movements
			init:
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
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
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
				(Print 334 0 #dispose) ; "Clarence is writing at his desk."
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
				(Hand setMotion: MoveTo 90 120 self)
			)
			(1
				(if (!= (Random 1 8) 1)
					(= state 0)
					(Hand posn: (- 90 (Random 0 2)) (- 120 (Random 0 3)))
					(= cycles 2)
				else
					(Hand setMotion: MoveTo 90 120 self)
				)
			)
			(2
				(Hand setMotion: MoveTo 92 109 self)
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Random 1 5) 1)
					(Eye hide:)
					(Clarence cel: 1)
					(= cycles (Random 4 10))
				else
					(= cycles 1)
				)
			)
			(1
				(if (Clarence cel:)
					(Clarence cel: 0)
				)
				(Eye show: cel: (Random 0 1))
				(= state -1)
				(= cycles (Random 4 15))
			)
		)
	)
)

