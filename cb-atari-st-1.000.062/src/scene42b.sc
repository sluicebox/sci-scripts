;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 352)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene42b 0
)

(local
	[local0 3]
	local3
)

(instance Hand of Act
	(properties)
)

(instance Smoke of Act
	(properties)
)

(instance Colonel of Prop
	(properties)
)

(instance coloFace of Prop
	(properties)
)

(instance coloMouth of Prop
	(properties)
)

(instance coloEyes of Prop
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene42b of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Colonel
			view: 311
			posn: 101 105
			loop: 1
			cel: 0
			setPri: 1
			init:
			stopUpd:
		)
		(coloFace
			view: 311
			posn: 114 88
			loop: 0
			cel: 0
			setPri: 2
			init:
			stopUpd:
		)
		(coloEyes
			view: 311
			posn: 114 (- (coloFace y:) 15)
			loop: 2
			cel: 0
			setPri: 3
			setScript: ColoEyes
			init:
			stopUpd:
		)
		(coloMouth
			view: 311
			posn: 114 88
			loop: 4
			cel: 0
			setPri: 2
			cycleSpeed: 1
			init:
			hide:
		)
		(Hand
			view: 311
			posn: 128 136
			setLoop: 1
			setCel: 1
			setPri: 3
			moveSpeed: 1
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(Smoke
			view: 311
			setLoop: 3
			setCycle: Walk
			setPri: 3
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
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

(instance ColoEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state -1)
				(if (^= local3 $0001)
					(coloEyes hide:)
					(= seconds (Random 2 3))
				else
					(coloEyes cel: (/ (Random 1 29999) 10000) forceUpd: show:)
					(= cycles 3)
				)
			)
		)
	)
)

(instance twice of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== (Smoke cel:) (- (NumCels Smoke) 1)))
			(Smoke hide:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 352 0 #dispose) ; "You see the Colonel sitting in his room."
				(= cycles 1)
			)
			(1
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y:) 15) forceUpd:)
				(Hand show: setMotion: MoveTo 116 116 self)
			)
			(2
				(Hand stopUpd:)
				(coloMouth show: setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(coloMouth setCycle: End)
				(Hand setMotion: MoveTo 128 136 self)
			)
			(4
				(Hand hide:)
				(coloFace cel: 1 forceUpd:)
				(coloMouth hide:)
				(coloEyes y: (- (coloFace y:) 16) forceUpd:)
				(Smoke show: cel: 0 posn: 116 81 setMotion: MoveTo 128 101 self)
			)
			(5
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

