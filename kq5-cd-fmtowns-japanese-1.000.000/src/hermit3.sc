;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	hermit3 0
)

(instance hermit3 of KQ5Room
	(properties
		picture 88
		style 30
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 941)
		(if (!= (gGlobalSound number:) 820)
			(gGlobalSound number: 820 loop: -1 vol: 127 playBed:)
		)
		(if (== global361 46)
			(sailBoat
				init:
				y: (if (== gCurRoomNum 44) 153 else 173)
				stopUpd:
				ignoreActors:
			)
			(sail
				posn: (+ (sailBoat x:) 7) (sailBoat y:)
				setPri: (sailBoat priority:)
				init:
			)
		)
		(egoMouth init:)
		(hermitMouth init:)
		(hermit_eyes init:)
		(chimney init: setCycle: Fwd cycleSpeed: 3)
		(if (!= (gGame detailLevel:) 3)
			(chimney setCycle: 0)
		)
		(self setScript: cartoon setRegions: 763) ; cartoonRegion
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(hermitMouth cycleSpeed: 2)
				(hermit_eyes cycleSpeed: 20 setCycle: RandCycle)
				(hermitMouth setCycle: MouthSync 1142)
				(Say 1142 self)
			)
			(2
				(cls)
				(hermitMouth setCycle: 0)
				(egoMouth cycleSpeed: 2)
				(egoMouth setCycle: MouthSync 1143)
				(Say 1143 self)
			)
			(3
				(egoMouth setCycle: 0)
				(cls)
				(hermitMouth setCycle: MouthSync 1144)
				(Say 1144 self)
			)
			(4
				(hermitMouth setCycle: 0)
				(cls)
				(= seconds 1)
			)
			(5
				(hermitMouth setCycle: MouthSync 1145)
				(Say 1145 self)
			)
			(6
				(hermitMouth setCycle: 0)
				(cls)
				(= seconds 2)
			)
			(7
				(hermitMouth setCycle: MouthSync 1146)
				(Say 1146 self)
			)
			(8
				(hermitMouth setCycle: 0)
				(if (IsFlag 55)
					(gGlobalSound fade:)
					(if (!= global361 46)
						(gCurRoom newRoom: 46)
					else
						(gCurRoom newRoom: 110) ; hermitRoom
					)
				else
					(gCurRoom newRoom: 111) ; hermit2
				)
			)
		)
	)
)

(instance egoMouth of Prop
	(properties
		x 183
		y 85
		view 827
	)
)

(instance hermitMouth of Prop
	(properties
		x 135
		y 104
		view 827
		loop 2
	)
)

(instance hermit_eyes of Prop
	(properties
		x 144
		y 83
		view 827
		loop 3
	)
)

(instance chimney of Prop
	(properties
		x 18
		y 70
		z 20
		view 625
		loop 2
	)
)

(instance sailBoat of Actor
	(properties
		x 280
		y 173
		view 618
		cel 1
		priority -1
		signal 16385
	)
)

(instance sail of Actor
	(properties
		z 15
		view 618
		loop 2
		signal 16385
	)
)

