;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use castle)
(use KQ5Room)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rm096 0
)

(local
	local0
)

(instance rm096 of KQ5Room
	(properties
		picture 96
	)

	(method (init)
		(super init:)
		(self setRegions: 550) ; castle
		(Load rsVIEW 860)
		(gEgo init: hide:)
		((gEgo head:) hide:)
		(hisEyes init: setCel: 0 setScript: boyBlinkScript)
		(cassimaEyes init:)
		(cassimaLips init:)
		(egoFace init:)
		(locket init: setScript: locketScript)
		(gCurRoom setScript: cartoon)
	)
)

(instance kingScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoFace setCel: (Random 0 5))
				(= cycles (Random 1 4))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance girlBlinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cassimaEyes setLoop: 1 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 1 4))
			)
			(2
				(cassimaEyes setCycle: Beg self)
			)
			(3
				(= seconds (Random 1 3))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance boyBlinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hisEyes setLoop: 5 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 1 4))
			)
			(2
				(hisEyes setCycle: Beg self)
			)
			(3
				(= seconds (Random 3 9))
			)
			(4
				(self init:)
			)
		)
	)
)

(instance locketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(locket
					setCycle: Fwd
					setLoop: (Random 3 4)
					cycleSpeed: (Random 1 3)
				)
				(= seconds (Random 1 3))
			)
			(1
				(locket setLoop: 4 setCel: 255)
				(= seconds (Random 2 6))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance cassimaEyes of Prop
	(properties
		x 117
		y 75
		view 860
		loop 1
	)
)

(instance hisEyes of Prop
	(properties
		x 201
		y 53
		view 860
		loop 5
	)
)

(instance cassimaLips of Prop
	(properties
		x 91
		y 95
		view 1036
		loop 1
		cel 4
	)
)

(instance egoFace of Prop
	(properties
		x 216
		y 76
		view 860
		loop 2
	)
)

(instance locket of Prop
	(properties
		x 148
		y 89
		view 860
		loop 4
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(= seconds 2)
			)
			(1
				(cassimaEyes
					setPri: (+ (cassimaLips priority:) 1)
					setScript: girlBlinkScript
				)
				(cassimaLips cycleSpeed: 2)
				(cassimaLips setCycle: MouthSync 1078)
				(Say 1078 self)
			)
			(2
				(cassimaLips setCycle: 0 setCel: 4)
				(egoFace setCycle: MouthSync 1079)
				(Say 1079 self)
			)
			(3
				(egoFace setCycle: 0 setCel: 0)
				(cassimaLips setCycle: MouthSync 1080)
				(Say 1080 self)
			)
			(4
				(cls)
				(= seconds 2)
				(cassimaLips setCycle: 0 setCel: 4)
			)
			(5
				(cassimaLips setCycle: MouthSync 1081)
				(Say 1081 self)
			)
			(6
				(cls)
				(= cycles 1)
				(cassimaLips setCycle: 0 setCel: 4)
			)
			(7
				(cassimaLips setCycle: MouthSync 1082)
				(Say 1082 self)
			)
			(8
				(cls)
				(cassimaLips setCycle: 0 setCel: 4)
				(= seconds 1)
			)
			(9
				(gCurRoom newRoom: 57)
			)
		)
	)
)

