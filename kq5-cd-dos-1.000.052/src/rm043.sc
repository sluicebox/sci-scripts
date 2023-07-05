;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use KQ5Room)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm043 0
)

(instance rm043 of KQ5Room
	(properties
		picture 43
		south 44
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 826 loop: -1 vol: 127 playBed:)
		(HandsOff)
		(= global103 1)
		(eagle ignoreActors: 1 init:)
		(roc cycleSpeed: 3 ignoreActors: 1 init:)
		(self setScript: rescue)
		(gEgo put: 26 43) ; Cloak
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance rescue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eagle setLoop: 2 setCycle: Fwd setMotion: MoveTo 109 41 self)
				(roc setScript: rocScript)
			)
			(1
				(eagle setMotion: MoveTo 155 47 self)
			)
			(2
				(Say 958)
				(eagle setMotion: MoveTo 161 52 self)
			)
			(3
				(eagle setLoop: 4 setMotion: MoveTo 164 37 self)
				(roc setScript: grabCapeScript)
			)
			(4
				(eagle xStep: 2 setMotion: MoveTo 180 26 self)
			)
			(5
				(eagle setLoop: 3 setMotion: MoveTo 220 15 self)
			)
			(6
				(eagle setMotion: MoveTo 330 -5 self)
			)
			(7
				(= seconds 3)
			)
			(8
				(= global103 0)
				(gCurRoom newRoom: 44)
			)
		)
	)
)

(instance rocScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roc loop: 0 setCycle: Fwd)
				(= cycles (Random 15 30))
			)
			(1
				(roc loop: 1 cel: 0 setCycle: Fwd)
				(= cycles (Random 15 30))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance grabCapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roc setLoop: 5 cel: 0 setCycle: End self)
			)
			(1
				(roc setLoop: 6 setCycle: RandCycle)
			)
		)
	)
)

(instance roc of Prop
	(properties
		x 163
		y 52
		view 608
		priority 1
		signal 16400
	)
)

(instance eagle of Actor
	(properties
		x 10
		y -5
		view 608
		loop 2
		priority 2
		signal 24592
	)
)

