;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Rev)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm046 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 30] = [254 185 254 177 319 177 319 189 0 189 0 0 239 0 242 114 168 121 180 127 153 133 106 165 132 168 133 172 82 185]
	[local36 10] = [244 0 319 0 319 100 253 106 246 98]
	[local46 9] = [1014 116 74 4 10 30 21 24 28]
	[local55 9] = [1003 162 64 4 11 25 23 31 31]
	[local64 9] = [1014 152 74 4 10 30 21 24 28]
	[local73 9] = [1003 191 74 4 11 25 23 31 31]
)

(instance rm046 of KQ5Room
	(properties
		picture 46
		north 44
		east 47
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (not (OneOf newRoomNumber 44 45 46))
			(gGlobalSound fade:)
		)
	)

	(method (init)
		(super init:)
		(if (!= (gGlobalSound number:) 7)
			(gGlobalSound number: 7 loop: -1 playBed:)
		)
		(LoadMany rsVIEW 624 626 628)
		(Load rsSCRIPT 941)
		(= global320 100)
		(= global321 140)
		(= global325 3070)
		(self setFeatures: house beach bell setRegions: 220) ; boatRegion
		(gEgo posn: 0 500 illegalBits: $c000 init:)
		(switch gPrevRoomNum
			(112 ; hermit3
				(self setScript: cartoon2)
			)
			(east
				(if (and (not (IsFlag 54)) (not (gCurRoom script:)))
					(self setRegions: 202) ; owl
				)
			)
			(north
				(if (> (gEgo x:) 255)
					(gEgo show: posn: (gEgo x:) 125)
				else
					(gEgo show: posn: 255 125)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 135 normal: 0)
				(if (not (IsFlag 54))
					(self setRegions: 202) ; owl
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(else
				(gEgo show: posn: 255 125)
				(if (not (IsFlag 54))
					(self setRegions: 202) ; owl
				)
			)
		)
		(if (gCast contains: global322)
			(global322 setPri: 13)
		)
		(chimney init:)
		(if (== (gGame detailLevel:) 3)
			(surf1 setScript: waves)
			(chimney setCycle: Fwd cycleSpeed: 3)
		)
		(if (and (not (and (IsFlag 71) (== global361 46))) (!= gPrevRoomNum 112)) ; hermit3
			(door init: setPri: 9)
		else
			(door init: setPri: 9 hide:)
			(hermit_a view: 626 posn: 131 148 setPri: 10 cel: 2 init:)
		)
		(if (== gPrevRoomNum east)
			(gEgo illegalBits: $c000)
		else
			(gEgo init: view: 0 normal: 1)
		)
		(poly1 points: @local6 size: 15)
		(poly2 points: @local36 size: 5)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(if (and (IsFlag 71) (not local2) (== global361 46))
					(= local2 1)
				)
				(script doit:)
			)
			(local2
				(= local2 0)
				(ClearFlag 71)
				(self setScript: bringCedric)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (and (gCast contains: global322) (!= temp0 47))
					((ScriptID 202 2) register: 2) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(SetFlag 107)
					(gCurRoom newRoom: temp0)
				)
			)
			((gEgo inRect: 234 100 257 115)
				(gEgo setMotion: 0)
				(if (gCast contains: global322)
					((ScriptID 202 2) register: 1) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: 44)
				)
			)
			(
				(and
					(gCast contains: hermit_a)
					(== (hermit_a view:) 624)
					(> (gEgo distanceTo: hermit_a) 80)
				)
				(self setScript: hermitScared)
			)
			(
				(and
					(gCast contains: hermit_a)
					(== (hermit_a view:) 624)
					(< (gEgo distanceTo: hermit_a) 45)
				)
				(self setScript: hermitScared)
			)
			((and (& (gEgo onControl: 1) $2000) (!= (gEgo view:) 26))
				(gEgo view: 26)
			)
			((and (& (gEgo onControl: 1) $0001) (!= (gEgo view:) 0))
				(gEgo view: 0)
			)
			(local1
				(if
					(and
						(> local1 100)
						(== (hermit_a view:) 624)
						(gCast contains: hermit_a)
					)
					(= local1 0)
					(gCurRoom setScript: hermitScared)
				else
					(++ local1)
				)
			)
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
		(DisposeScript 969)
		(gEgo ignoreControl: 16384)
		(super dispose:)
	)
)

(instance egoHeadMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) loop: (Random 4 6))
				(-- state)
				(= cycles 5)
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (== (gGlobalSound3 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hermit_a
					view: 626
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					ignoreActors: 1
					posn: 90 148
					illegalBits: 0
					show:
					init:
				)
				(= cycles 1)
			)
			(1
				(hermit_a setMotion: MoveTo 175 148)
				(= cycles 30)
			)
			(2
				(gEgo
					view: 624
					posn: 120 148
					normal: 1
					ignoreActors: 1
					illegalBits: 0
					setPri: -1
					setCycle: End self
					setLoop: 13
					setMotion: MoveTo 130 148 self species
				)
			)
			(3
				((gEgo head:) hide:)
				(gEgo
					show:
					setCycle: SyncWalk
					setMotion: MoveTo 130 148 self
				)
			)
			(4
				((gEgo head:) show:)
				(gEgo view: 0 setLoop: 0 setMotion: MoveTo 160 160)
				(hermit_a view: 628 setLoop: 2)
				(arm_a
					view: 628
					posn: (- (hermit_a x:) 5) (- (hermit_a y:) 32)
					setPri: (+ (hermit_a priority:) 1)
					setLoop: 1
					setCycle: CT 8 1
					init:
				)
				(gGlobalSound3 number: 821 loop: 1 play:)
			)
			(5
				(arm_a setCycle: End)
				(hermit_a setLoop: 2)
				(= seconds 5)
			)
			(6
				(mermaid
					init:
					setLoop: 8
					cycleSpeed: 2
					posn: 275 155
					setCycle: End self
				)
			)
			(7
				(mermaid setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(= cycles 1)
			)
			(8
				(theMouth
					init:
					setCycle: RandCycle
					setPri: (+ (hermit_a priority:) 1)
					setLoop: (theMouth loop:)
					ignoreActors:
					cycleSpeed: 2
					posn: (+ (hermit_a x:) 3) (- (hermit_a y:) 37)
				)
				(Say 1147 self)
			)
			(9
				(theMouth setCycle: 0)
				(cls)
				(= seconds 3)
			)
			(10
				(theMouth setCycle: RandCycle)
				(Say 1148 self)
			)
			(11
				(theMouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(Say 9102 self)
			)
			(12
				((gEgo head:) setCel: 1 loop: 4 setScript: 0)
				(theMouth setCycle: RandCycle)
				(cls)
				(Say 1151 self)
			)
			(13
				(theMouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(Say 9103 self)
			)
			(14
				((gEgo head:) setCel: -1 setScript: 0)
				(cls)
				(mermaid setLoop: 10 cycleSpeed: 2 setCycle: End self)
			)
			(15
				(theMouth dispose:)
				(arm_a hide:)
				(hermit_a
					view: 626
					setCycle: Walk
					setLoop: 1
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 90 144 self
				)
			)
			(16
				(door setCycle: Beg self show:)
				(gEgo setCycle: SyncWalk setLoop: -1 view: 0)
				(NormalEgo)
			)
			(17
				(SetFlag 105)
				(gGlobalSound3 number: 124 loop: 1 play: 50)
				(gEgo setMotion: PolyPath 237 105 self)
			)
			(18
				(gCurRoom newRoom: 44)
			)
			(19
				(client setScript: 0)
			)
		)
	)
)

(instance bringCedric of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc762_1 @local46 1133)
				(= cycles 1)
			)
			(1
				(cls)
				(= local4 1)
				(client setScript: cartoon)
			)
		)
	)
)

(instance waves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(surf1
					init:
					show:
					setCycle: End self
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
				(surf2
					init:
					setCycle: RandCycle
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
			)
			(1
				(surf1 setCycle: Beg self)
				(surf2 setCycle: Beg)
			)
			(2
				(= seconds 5)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance giveShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 23) ; Shell
				(SetScore 4)
				(HandsOff)
				(gEgo
					setCycle: SyncWalk
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 186 149 self
				)
			)
			(1
				(gEgo setLoop: 1)
				(hermitHead hide:)
				(hermit_a
					view: 626
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 167 149 self
				)
			)
			(2
				(gEgo hide:)
				((gEgo head:) hide:)
				(hermit_a
					view: 624
					setLoop: 6
					cel: 0
					posn: 176 149
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(proc762_1 @local46 1127)
				(= cycles 1)
			)
			(4
				(cls)
				(gCurRoom setScript: cartoon)
			)
		)
	)
)

(instance dPush of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $0001)
				(or (== (gEgo view:) 26) (== (gEgo view:) 28))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 135 147 self illegalBits: 0)
			)
			(1
				((gEgo head:) hide:)
				(gEgo view: 628 loop: 3 cycleSpeed: 1 setCycle: Fwd)
				(gGlobalSound3 number: 828 loop: -1 play:)
				(= seconds 4)
			)
			(2
				(gGlobalSound3 stop:)
				(++ local0)
				(Say 515)
				((gEgo head:) show:)
				(gEgo
					view: 0
					cel: 1
					cycleSpeed: 0
					setCycle: SyncWalk
					ignoreActors: -32768
				)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myRotate of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322 view: 138 loop: 1 setCycle: End self)
			)
			(1
				(global322 view: 138 loop: 4 cel: 7 setCycle: Beg self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance hermitScared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(-- global362)
				(= cycles 1)
			)
			(1
				(proc762_1 @local46 1134)
				(= cycles 1)
			)
			(2
				(cls)
				(hermit_a
					view: 626
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 105 148 self
				)
			)
			(3
				(hermit_a dispose:)
				(HandsOn)
				(= cycles 3)
			)
			(4
				(if (< global362 12)
					(++ global362)
				else
					(= global362 0)
				)
				(= cycles 1)
			)
			(5
				(door startUpd: ignoreActors: 0 setCycle: Beg self)
			)
			(6
				(gGlobalSound3 number: 124 loop: 1 play: 50)
				(door stopUpd:)
				(= cycles 1)
			)
			(7
				(client setScript: 0)
			)
		)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom setRegions: 763) ; cartoonRegion
				(if local4
					(= state 5)
				)
				(= cycles 1)
			)
			(1
				(Hhead hide:)
				((gEgo head:) show:)
				(gEgo
					show:
					setCycle: Rev
					setLoop: 1
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(hermit_a
					view: 624
					setLoop: 4
					posn: (- (gEgo x:) 19) (gEgo y:)
					setCycle: End
				)
				(shell init: signal: 22 setPri: (- (hermit_a priority:) 1))
			)
			(2
				(gEgo cel: 1 setCycle: 0)
				(= cycles 5)
			)
			(3
				(proc762_1 @local64 1128)
				(= cycles 1)
			)
			(4
				(cls)
				(if (IsFlag 55)
					(proc762_1 @local73 1129)
					(= cycles 1)
				else
					(proc762_1 @local73 1130)
				)
				(= cycles 1)
			)
			(5
				(cls)
				(cond
					((IsFlag 55)
						(proc762_1 @local64 1131)
						(= state 8)
					)
					((!= global361 46)
						(proc762_1 @local64 1132)
						(= state 10)
					)
					(else
						(Say 9113)
					)
				)
				(= cycles 1)
			)
			(6
				(cls)
				(gEgo
					ignoreActors: 1
					setCycle: SyncWalk
					setLoop: -1
					normal: 0
					illegalBits: 0
					setMotion: MoveTo 260 168 self
				)
			)
			(7
				(gEgo setLoop: 1)
				(= cycles 1)
			)
			(8
				((gEgo head:) hide:)
				(gEgo
					view: 624
					loop: 1
					posn: 260 155
					setPri: 15
					normal: 0
					setCycle: End self
				)
			)
			(9
				(cls)
				(shell dispose:)
				(hermit_a
					view: 626
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 90 148
				)
				(gEgo
					setLoop: (if (IsFlag 55) -1 else 2)
					setPri: 10
					setCycle: SyncWalk
					normal: 0
					ignoreActors: 1
					setMotion: MoveTo 135 146 self
				)
			)
			(10
				(gEgo
					view: 624
					setLoop: (if (IsFlag 55) 14 else 11)
					setCycle: End self
				)
			)
			(11
				(cls)
				(if (== (hermit_a view:) 624)
					(shell dispose:)
					(hermit_a
						view: 626
						setLoop: -1
						setCycle: Walk
						cycleSpeed: 0
						ignoreActors: 1
						setMotion: MoveTo 90 148 self
					)
				else
					(gEgo setCycle: SyncWalk setMotion: MoveTo 90 148 self)
				)
			)
			(12
				(door cycleSpeed: 2 setCycle: Beg self)
			)
			(13
				(gGlobalSound3 number: 124 loop: 1 play: 50)
				(client setScript: 0)
				(cond
					((IsFlag 55)
						(gCurRoom newRoom: 112) ; hermit3
					)
					((!= global361 46)
						(NormalEgo)
						(HandsOn)
						(SetFlag 71)
						((ScriptID 763) dispose:) ; cartoonRegion
						(hermit_a dispose:)
						(= local1 0)
					)
					(else
						(gCurRoom newRoom: 111) ; hermit2
					)
				)
			)
		)
	)
)

(instance greeting of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $0001)
				(or (== (gEgo view:) 26) (== (gEgo view:) 28))
			)
			(gEgo view: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					normal: 0
					setMotion: PolyPath 185 128 self
				)
			)
			(1
				(if (or (> global362 13) (< global362 0))
					(= global362 0)
				)
				(gEgo setMotion: PolyPath 177 129 self)
			)
			(2
				(gEgo setLoop: 7 setCel: 1)
				((gEgo head:) setLoop: 4)
				(arm_a
					init:
					posn: (- (gEgo x:) 4) (- (gEgo y:) 30)
					setCycle: CT 6 1 self
				)
			)
			(3
				(arm_a setCycle: End self)
				(gGlobalSound3 number: 819 loop: 1 play:)
			)
			(4
				(arm_a dispose:)
				(= seconds (Random 2 6))
			)
			(5
				((gEgo head:) setLoop: -1 cel: 2)
				(gEgo view: 0 loop: 7 cel: 2)
				(door startUpd: ignoreActors: 1 setCycle: End self)
				(gGlobalSound3 number: 122 loop: 1 play: 75)
			)
			(6
				(gEgo stopUpd:)
				(door stopUpd:)
				(hermit_a
					view: 626
					setCycle: Walk
					setMotion: MoveTo 131 148 self
					setPri: 10
					init:
				)
				(gGlobalSound2 number: 827 loop: 1 play:)
			)
			(7
				(hermit_a cel: 2)
				(RedrawCast)
				(= cycles 1)
			)
			(8
				(switch global362
					(0
						(proc762_1 @local46 1089)
					)
					(1
						(proc762_1 @local46 1090)
					)
					(2
						(proc762_1 @local46 1091)
					)
					(3
						(proc762_1 @local46 1092)
					)
					(4
						(proc762_1 @local46 1093)
					)
					(5
						(proc762_1 @local46 1094)
					)
					(6
						(proc762_1 @local46 1095)
					)
					(7
						(proc762_1 @local46 1096)
					)
					(8
						(proc762_1 @local46 1097)
					)
					(9
						(proc762_1 @local46 1098)
					)
					(10
						(proc762_1 @local46 1099)
					)
					(11
						(proc762_1 @local46 1100)
					)
					(12
						(proc762_1 @local46 1101)
					)
				)
				(= cycles 1)
			)
			(9
				(cls)
				(HandsOn)
				(gEgo normal: 1)
				(NormalEgo)
				(++ local1)
				(= cycles 1)
			)
			(10
				(client setScript: talkHermit)
			)
		)
	)
)

(instance talkHermit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(= local1 0)
				(switch global362
					(0
						(proc762_1 @local55 1113)
					)
					(1
						(proc762_1 @local55 1114)
					)
					(2
						(proc762_1 @local55 1115)
					)
					(3
						(proc762_1 @local55 1116)
					)
					(4
						(proc762_1 @local55 1117)
					)
					(5
						(proc762_1 @local55 1118)
					)
					(6
						(proc762_1 @local55 1119)
					)
					(7
						(proc762_1 @local55 1120)
					)
					(8
						(proc762_1 @local55 1121)
					)
					(9
						(proc762_1 @local55 1122)
					)
					(10
						(proc762_1 @local55 1123)
					)
					(11
						(proc762_1 @local55 1124)
					)
					(12
						(proc762_1 @local55 1129)
					)
				)
				(= cycles 1)
			)
			(1
				(cls)
				(= cycles 1)
			)
			(2
				(switch global362
					(0
						(proc762_1 @local46 1102)
					)
					(1
						(proc762_1 @local46 1103)
					)
					(2
						(proc762_1 @local46 1104)
					)
					(3
						(proc762_1 @local46 1105)
					)
					(4
						(proc762_1 @local46 1106)
					)
					(5
						(proc762_1 @local46 1107)
					)
					(6
						(proc762_1 @local46 1108)
					)
					(7
						(proc762_1 @local46 1109)
					)
					(8
						(proc762_1 @local46 1110)
					)
					(else
						(proc762_1 @local46 1111)
					)
				)
				(= cycles 1)
			)
			(3
				(if (< global362 12)
					(++ global362)
				else
					(= global362 0)
				)
				(= cycles 1)
			)
			(4
				(HandsOff)
				(if (== global362 1)
					(proc762_1 @local46 1112)
				)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(User canControl: 0)
				(= seconds (if (gEgo has: 23) 7 else 1)) ; Shell
			)
			(6
				(HandsOff)
				(cls)
				(hermit_a
					view: 626
					illegalBits: 0
					setPri: 10
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 95 148 self
				)
			)
			(7
				(door startUpd: ignoreActors: 0 setCycle: Beg self)
				(gGlobalSound2 fade:)
			)
			(8
				(gGlobalSound3 number: 124 loop: 1 play: 100)
				(door stopUpd:)
				(HandsOn)
				(hermit_a dispose:)
				(= cycles 1)
			)
			(9
				(client setScript: 0)
			)
		)
	)
)

(instance house of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 516)
					(event claimed: 1)
				)
				(3 ; Do
					(event claimed: 0)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 517)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance beach of RFeature
	(properties
		nsTop 89
		nsLeft 242
		nsBottom 188
		nsRight 318
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $2000))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0001))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 518)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hermit_a of Actor
	(properties
		name {hermit}
		x 95
		y 148
		view 626
		signal 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (and (gCast contains: shell) (not (hermit_a mover:)))
			(switch (hermit_a cel:)
				(0
					(shell posn: (+ (hermit_a x:) 8) (- (hermit_a y:) 20))
				)
				(1
					(shell posn: (+ (hermit_a x:) 13) (- (hermit_a y:) 23))
				)
				(2
					(shell posn: (+ (hermit_a x:) 15) (- (hermit_a y:) 35))
				)
			)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 519)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(23
							(gCurRoom setScript: giveShell)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 522)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 113
		y 147
		view 625
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
					(not (MousedOn self event))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 520)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(28
							(event claimed: 0)
						)
						(else
							(Say 517)
							(event claimed: 1)
						)
					)
				)
				(3 ; Do
					(if (event claimed: 1)
						(gCurRoom setScript: dPush)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance bell of RFeature
	(properties
		x 163
		y 94
		z 32
		nsTop 88
		nsLeft 152
		nsBottom 102
		nsRight 173
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (MousedOn self event))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 521)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((gCast contains: hermit_a)
							(event claimed: 0)
						)
						((IsFlag 71)
							(event claimed: 0)
						)
						(else
							(gCurRoom setScript: greeting)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance hermitHead of Prop
	(properties
		view 628
		loop 2
		priority 15
		signal 1
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

(instance Hhead of Prop
	(properties
		view 628
		signal 16385
	)
)

(instance arm_a of Prop
	(properties
		name {arm}
		view 624
		loop 3
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

(instance surf1 of Prop
	(properties
		x 284
		y 155
		view 623
		loop 1
	)
)

(instance surf2 of Prop
	(properties
		x 261
		y 181
		view 623
		loop 2
	)
)

(instance hermit_b of Actor ; UNUSED
	(properties
		name {hermit}
		signal 1
	)
)

(instance mermaid of Actor
	(properties
		view 624
		signal 1
	)
)

(instance theMouth of Prop
	(properties
		view 624
		loop 15
	)
)

(instance arm_b of Prop ; UNUSED
	(properties
		name {arm}
		view 628
	)
)

(instance shell of View
	(properties
		view 624
		loop 5
	)
)

