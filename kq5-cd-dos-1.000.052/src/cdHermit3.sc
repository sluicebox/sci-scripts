;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 662)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	cdHermit3 0
)

(local
	local0
)

(instance cdHermit3 of KQ5Room
	(properties
		picture 88
		style 10
	)

	(method (init)
		(super init:)
		(= local0 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 1)
		(Load rsSCRIPT 941)
		(Load rsSCRIPT 929)
		(Load rsSOUND 820)
		(Load rsVIEW 827)
		(Load rsVIEW 625)
		(Load rsVIEW 618)
		(Load rsSYNC 1142)
		(Load rsSYNC 1143)
		(Load rsSYNC 1144)
		(Load rsSYNC 1145)
		(Load rsSYNC 1146)
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
		(hermit_eyes init:)
		(chimney setCycle: Fwd init:)
		(self setScript: cartoon2)
	)

	(method (dispose)
		(gGame egoMoveSpeed: local0)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(hermit_eyes cycleSpeed: 20 setCycle: RandCycle)
				(theMouth changeMouth: 1 setCycle: MouthSync 1142 init:)
				(Say 1142 self)
			)
			(2
				(theMouth setCycle: 0 hide:)
				(= cycles 1)
			)
			(3
				(egoMouth hide:)
				(theMouth changeMouth: 0 setCycle: MouthSync 1143 show:)
				(Say 1143 self)
			)
			(4
				(theMouth setCycle: 0 hide:)
				(egoMouth show:)
				(= cycles 1)
			)
			(5
				(theMouth changeMouth: 1 setCycle: MouthSync 1144 show:)
				(Say 1144 self)
			)
			(6
				(theMouth setCycle: 0)
				(= seconds 1)
			)
			(7
				(theMouth setCycle: MouthSync 1145)
				(Say 1145 self)
			)
			(8
				(theMouth setCycle: 0)
				(= seconds 2)
			)
			(9
				(theMouth setCycle: MouthSync 1146)
				(Say 1146 self)
			)
			(10
				(theMouth setCycle: 0 hide:)
				(gGlobalSound fade:)
				(if (IsFlag 55)
					(gCurRoom newRoom: 660) ; cdHermitRoom
				else
					(gCurRoom newRoom: 661) ; cdHermit2
				)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 135
		y 104
		view 827
		loop 2
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth x: 183 y: 85 view: 827 loop: 0)
			)
			(1
				(theMouth x: 135 y: 104 view: 827 loop: 2)
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
		cycleSpeed 3
		detailLevel 3
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

