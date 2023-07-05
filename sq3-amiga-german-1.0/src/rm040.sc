;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm040 0
)

(local
	[local0 2]
)

(instance rm040 of Rm
	(properties
		picture 40
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(= global159 1)
		(gTheMenuBar hide: state: 0)
		(SL disable:)
		(Load rsVIEW 61)
		(Load rsVIEW 62)
		(Load rsSOUND 58)
		(super init:)
		(arnsBod init: addToPic:)
		(arnsLegs init: addToPic:)
		(arnsHead init: stopUpd:)
		(arnsArm init: stopUpd:)
		(topHatch init:)
		(midHatch init:)
		(bottomHatch init:)
		(self setScript: rmScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look[/area]')
			(Print 40 0) ; "You are somewhere."
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(termMusic play:)
				(if (== global124 0)
					(= cycles 5)
				)
			)
			(1
				(topHatch setCycle: End)
				(midHatch setCycle: End)
				(bottomHatch setCycle: End self)
			)
			(2
				(topHatch dispose:)
				(midHatch dispose:)
				(bottomHatch dispose:)
			)
			(3
				(arnsHead setCycle: End self)
			)
			(4
				(if (== global124 0)
					(= cycles 2)
				else
					(= cycles 14)
				)
			)
			(5
				(arnsArm setCycle: End self)
			)
			(6
				(if (== global124 0)
					(= cycles 2)
				else
					(= cycles 23)
				)
			)
			(7
				(arnsHead setCycle: Beg)
				(arnsArm setCycle: Beg self)
			)
			(8
				(if (== global124 0)
					(= cycles 2)
				else
					(= cycles 13)
				)
			)
			(9
				(gCurRoom drawPic: 40 8)
				(arnsHead dispose:)
				(arnsArm dispose:)
			)
			(10
				(firstSteps cel: 0 init:)
			)
			(11
				(firstSteps cel: 1 addToPic:)
			)
			(12
				(step1 addToPic:)
			)
			(13
				(step2 addToPic:)
			)
			(14
				(step3 addToPic:)
			)
			(15
				(step4 addToPic:)
			)
			(16
				(gLongSong fade:)
				(= global159 0)
				(HandsOn)
				(gTheMenuBar draw: state: 1)
				(SL enable:)
				(gCurRoom newRoom: 49)
			)
		)
	)

	(method (doit)
		(cond
			((and (== (termMusic prevSignal:) 10) (== (self state:) 0))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 20) (== (self state:) 2))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 30) (== (self state:) 9))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 40) (== (self state:) 10))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 50) (== (self state:) 11))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 60) (== (self state:) 12))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 70) (== (self state:) 13))
				(self cue:)
			)
			((and (== (termMusic prevSignal:) 80) (== (self state:) 14))
				(self cue:)
			)
			(
				(or
					(== (termMusic prevSignal:) 90)
					(== (termMusic prevSignal:) -1)
				)
				(if (== global124 0)
					(gLongSong fade:)
					(= global159 0)
					(HandsOn)
					(gTheMenuBar draw: state: 1)
					(SL enable:)
					(gCurRoom newRoom: 49)
				else
					(self cue:)
				)
			)
		)
		(super doit:)
	)
)

(instance topHatch of Prop
	(properties)

	(method (init)
		(self
			view: 62
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			posn: 113 60
			setPri: 5
			cycleSpeed: 1
		)
		(super init:)
	)
)

(instance midHatch of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 62
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			posn: 199 113
			setPri: 5
			cycleSpeed: 1
		)
	)
)

(instance bottomHatch of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 62
			setLoop: 2
			setCel: 0
			ignoreActors: 1
			posn: 113 175
			setPri: 5
			cycleSpeed: 1
		)
	)
)

(instance arnsHead of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 61
			setLoop: 2
			setCel: 0
			ignoreActors: 1
			posn: 155 17
			setPri: 4
			cycleSpeed: (if (== global124 0) 0 else 1)
		)
	)
)

(instance arnsArm of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 61
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			posn: 116 64
			setPri: 4
			cycleSpeed: (if (== global124 0) 0 else 1)
		)
	)
)

(instance arnsBod of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 61
			setLoop: 0
			setCel: 0
			ignoreActors: 1
			posn: 157 94
			setPri: 4
		)
	)
)

(instance arnsLegs of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 61
			setLoop: 0
			setCel: 1
			ignoreActors: 1
			posn: 154 166
			setPri: 4
		)
	)
)

(instance firstSteps of View
	(properties
		view 853
	)

	(method (init)
		(super init:)
		(self loop: 0 posn: 131 187)
	)
)

(instance step1 of View
	(properties
		view 853
	)

	(method (init)
		(super init:)
		(self loop: 1 cel: 1 posn: 205 181)
	)
)

(instance step2 of View
	(properties
		view 853
	)

	(method (init)
		(super init:)
		(self loop: 1 cel: 0 posn: 237 187)
	)
)

(instance step3 of View
	(properties
		view 853
	)

	(method (init)
		(super init:)
		(self loop: 1 cel: 1 posn: 268 181)
	)
)

(instance step4 of View
	(properties
		view 853
	)

	(method (init)
		(super init:)
		(self loop: 1 cel: 0 posn: 300 187)
	)
)

(instance termMusic of Sound
	(properties
		number 58
		priority 5
	)
)

