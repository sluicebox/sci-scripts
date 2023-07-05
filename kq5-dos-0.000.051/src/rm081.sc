;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Interface)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm081 0
)

(local
	[local0 14] = [319 120 275 122 273 161 203 174 127 155 0 189 319 189]
	[local14 14] = [319 81 276 97 236 88 145 111 97 124 0 0 319 0]
)

(instance rm081 of Rm
	(properties
		picture 81
		east 24
		west 82
	)

	(method (init)
		(super init:)
		(cond
			((not (IsFlag 46))
				(gGlobalSound number: 87 loop: -1 playBed:)
			)
			((!= (gGlobalSound number:) 4)
				(gGlobalSound number: 4 loop: -1 playBed:)
			)
		)
		(proc0_24 128 792 0 468)
		(self setFeatures: hole_tree theRoom addObstacle: poly1 poly2)
		(if (== gPrevRoomNum 82)
			(HandsOff)
			(self setScript: enterFromHole)
		else
			(gEgo posn: 310 100 init: offset: 3 loop: 1 setStep: 3 2)
		)
		(if (not (IsFlag 46))
			(SetFlag 46)
			(HandsOff)
			(self setScript: wavingElf)
		)
		(poly1 points: @local0 size: 7)
		(poly2 points: @local14 size: 7)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo view: 0 illegalBits: -32768 setLoop: -1 setStep: 3 2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 1) $1000)
				(HandsOff)
				(self setScript: enterHole)
			)
		)
	)
)

(instance enterHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					view: 792
					normal: 0
					illegalBits: 0
					setLoop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo
					y: (- (gEgo y:) 10)
					setLoop: 1
					cycleSpeed: 0
					setCycle: Fwd
					moveSpeed: 0
					setMotion: MoveTo 20 129 self
				)
			)
			(2
				(gEgo moveSpeed: global289)
				(gCurRoom newRoom: (gCurRoom west:))
				(self dispose:)
			)
		)
	)
)

(instance enterFromHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					view: 792
					normal: 0
					illegalBits: 0
					setLoop: 2
					posn: 20 129
					setCycle: Fwd
					moveSpeed: 0
					setMotion: MoveTo 115 129 self
				)
				((gEgo head:) hide:)
			)
			(1
				(gEgo loop: 5 cel: 3 setCycle: Beg self)
			)
			(2
				((gEgo head:) show:)
				(gEgo
					view: 0
					setLoop: 0
					setMotion: 0
					setCycle: Walk
					moveSpeed: global289
					setStep: 3 2
					illegalBits: -32768
					normal: 1
					ignoreActors: 0
				)
				(= cycles 1)
			)
			(3
				(gEgo setLoop: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wavingElf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(elf init: cycleSpeed: 1 setCycle: Fwd)
				(= cycles 15)
			)
			(1
				(PrintDC 81 0 #at 10 10 #dispose) ; "Follow me! In here!"
				(= seconds 5)
			)
			(2
				(cls)
				(elf
					view: 468
					setLoop: 10
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 30 139 self
				)
			)
			(3
				(HandsOn)
				(elf dispose:)
				(self dispose:)
			)
		)
	)
)

(instance elf of Act
	(properties
		y 135
		x 117
		view 796
		loop 1
		signal 2048
	)
)

(instance hole_tree of RFeature
	(properties
		name {hole&tree}
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 81 1) ; "A small hole burrows in at the base of an immense tree."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance theRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 81 2) ; "Graham has entered a secluded clearing in a quieter, more pleasant area of the dark forest."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

