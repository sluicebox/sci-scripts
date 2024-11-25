;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Interface)
(use n762)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm052 0
)

(local
	local0
	[local1 14] = [0 189 0 29 150 134 141 144 148 150 102 170 172 189]
	[local15 12] = [319 189 212 167 166 150 176 143 166 132 319 28]
	[local27 9] = [1000 236 90 4 11 24 19 23 30]
)

(instance rm052 of KQ5Room
	(properties
		picture 52
		horizon 120
		north 53
		south 51
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gGlobalSound loop: -1 number: 832 vol: 127 play:)
		(if (not (IsFlag 55))
			(= global320 281)
			(= global321 152)
			(= global325 3083)
			(self setRegions: 202) ; owl
		)
		(self setFeatures: statue path52 theCastle)
		(gEgo view: 2 normal: 1 setStep: 2 2 illegalBits: $8200 init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 159 138)
				(if (not (IsFlag 55))
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				)
			)
			(south
				(gEgo posn: 183 185)
				(if (not (IsFlag 55))
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
				else
					(HandsOn)
				)
			)
			(else
				(gEgo posn: 163 186)
			)
		)
		(if (IsFlag 35)
			(lDragon view: 668 loop: 7 posn: 109 54 init:)
			(rDragon view: 668 loop: 8 posn: 209 51 init:)
			(lDragon cel: (lDragon lastCel:))
			(rDragon cel: (rDragon lastCel:))
			(lActor
				loop: 9
				cel: 2
				posn: 107 43
				setCycle: Fwd
				cycleSpeed: 1
				setPri: 15
				init:
			)
			(rActor
				loop: 10
				posn: 212 39
				setCycle: Fwd
				cycleSpeed: 1
				setPri: 15
				init:
			)
		else
			(lDragon setCycle: Fwd init: hide:)
			(rDragon setCycle: Fwd init: hide:)
			(Load rsVIEW 668)
		)
		(poly1 points: @local1 size: 7)
		(poly2 points: @local15 size: 6)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0 temp1)
		(if (not (IsFlag 35))
			(cond
				((< (gEgo y:) 153)
					(if (not local0)
						(HandsOff)
						(self setScript: EgoBeingFried)
					)
				)
				((< (gEgo y:) 185)
					(= temp1 (/ (- 184 (gEgo y:)) 8))
					(lDragon loop: (* temp1 2) cycleSpeed: (- 3 temp1) show:)
					(rDragon
						loop: (+ (* temp1 2) 1)
						cycleSpeed: (- 3 temp1)
						show:
					)
				)
				(else
					(lDragon hide:)
					(rDragon hide:)
				)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((and (not (IsFlag 97)) (not (IsFlag 55)))
				(proc762_1 @local27 3084)
				(SetFlag 97)
			)
			((and (!= (gEgo yStep:) 1) (<= (gEgo y:) 184))
				(gEgo setStep: 2 1)
			)
			((& (gEgo onControl: 0) $0008)
				(if (not (IsFlag 55))
					((ScriptID 202 2) register: 1) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: 53)
				)
			)
			(
				(or
					(& (gEgo onControl: 0) $0400)
					(& (gEgo onControl: 0) $1000)
				)
				(self setScript: falling)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (not (IsFlag 55))
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: temp0)
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
			(
				(and
					(== (event type:) evVERB)
					(MousedOn gEgo event)
					(== (event message:) 4) ; Inventory
				)
				(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
					(21
						(if (and (gEgo has: 21) (not (IsFlag 35))) ; Crystal
							(event claimed: 1)
							(self setScript: EgoUsingCrystal)
						)
					)
					(28
						(event claimed: 0)
					)
					(else
						(Say 559)
						(event claimed: 1)
					)
				)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 70
					cel: 0
					setLoop: (if (& (gEgo onControl: 0) $0400) 0 else 1)
					setCycle: End self
				)
			)
			(1
				(EgoDead)
			)
		)
	)
)

(instance EgoBeingFried of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 35)
				((gEgo head:) hide:)
				(gGlobalSound3 number: 130 loop: -1 vol: 127 play:)
				(gEgo view: 666 loop: 10 setCycle: End self cycleSpeed: 3)
				(lDragon loop: 8 posn: 157 48 cycleSpeed: 0 show:)
				(rDragon hide:)
			)
			(1
				(gEgo loop: 11 cel: 0 setCycle: End self)
			)
			(2
				(gGlobalSound3 stop:)
				(lDragon loop: 6 posn: 117 57)
				(rDragon loop: 7 show:)
				(= cycles 1)
			)
			(3
				(lDragon cycleSpeed: (- 3 (/ (lDragon loop:) 2)))
				(rDragon cycleSpeed: (lDragon cycleSpeed:))
				(= cycles 10)
			)
			(4
				(if (lDragon loop:)
					(lDragon loop: (- (lDragon loop:) 2))
					(rDragon loop: (- (rDragon loop:) 2))
					(-= state 2)
				)
				(= cycles 1)
			)
			(5
				(lDragon hide:)
				(rDragon hide:)
				(= cycles 10)
			)
			(6
				(gGlobalSound3 stop:)
				(= global330 553)
				(EgoDead)
				(client setScript: 0)
			)
		)
	)
)

(instance EgoUsingCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(gEgo setMotion: MoveTo 160 150 self moveSpeed: 1)
				(SetFlag 22)
			)
			(1
				((gEgo head:) hide:)
				(egoTop
					posn: (gEgo x:) 130
					setCycle: End self
					cycleSpeed: 2
					init:
				)
				(gEgo view: 668 loop: 0)
			)
			(2
				(SetFlag 35)
				(gGlobalSound3 number: 130 loop: -1 vol: 127 play:)
				(lDragon view: 668 loop: 2 posn: 157 48 cycleSpeed: 0 show:)
				(rDragon hide:)
				(= seconds 3)
			)
			(3
				(gGlobalSound3 stop:)
				(lDragon loop: 11 posn: 117 57 setCycle: Fwd)
				(rDragon view: 668 posn: 213 53 loop: 12 show:)
				(crystal setCycle: Fwd init:)
				(= cycles 20)
			)
			(4
				(gGlobalSound3 number: 131 loop: 1 vol: 127 play:)
				(crystal loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(crystal loop: 5 setCycle: Fwd)
				(= cycles 20)
			)
			(6
				(gGlobalSound3 number: 791 loop: 1 vol: 127 play:)
				(lActor setMotion: MoveTo 109 54 self init:)
				(rActor setMotion: MoveTo 209 51 init:)
				(crystal loop: 3)
			)
			(7
				(lActor hide:)
				(rActor hide:)
				(lDragon
					view: 668
					loop: 7
					cel: 0
					posn: 109 54
					setCycle: End self
					cycleSpeed: 0
					show:
				)
				(rDragon
					view: 668
					loop: 8
					cel: 0
					posn: 209 51
					setCycle: End
					cycleSpeed: 0
					show:
				)
			)
			(8
				(lActor
					loop: 9
					cel: 2
					posn: 107 43
					setCycle: Fwd
					cycleSpeed: 3
					setPri: 15
					show:
				)
				(rActor
					loop: 10
					posn: 212 39
					setCycle: Fwd
					cycleSpeed: 3
					setPri: 15
					show:
				)
				(crystal hide: 3)
				(egoTop setCycle: Beg self)
			)
			(9
				(egoTop hide:)
				((gEgo head:) show:)
				(gEgo view: 2 loop: 7 cel: 3 moveSpeed: 0)
				(SetScore 5)
				(client setScript: 0)
				(ClearFlag 22)
				(HandsOn)
			)
		)
	)
)

(instance lDragon of Prop
	(properties
		x 117
		y 57
		view 666
	)

	(method (init)
		(super init:)
		(self setPri: 14)
	)
)

(instance rDragon of Prop
	(properties
		x 200
		y 52
		view 666
	)

	(method (init)
		(super init:)
		(self setPri: 14)
	)
)

(instance egoTop of Prop
	(properties
		view 668
		loop 1
	)
)

(instance crystal of Prop
	(properties
		x 160
		y 113
		view 668
		loop 3
		priority 15
		signal 16
	)
)

(instance lActor of Actor
	(properties
		x 160
		y 106
		yStep 9
		view 668
		loop 6
		signal 26624
		illegalBits 0
		xStep 12
	)

	(method (init)
		(super init:)
		(self setPri: 15)
	)
)

(instance rActor of Actor
	(properties
		x 160
		y 106
		yStep 9
		view 668
		loop 6
		signal 26624
		illegalBits 0
		xStep 12
	)

	(method (init)
		(super init:)
		(self setPri: 15)
	)
)

(instance statue of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $2000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (IsFlag 35)
						(Say 554)
					else
						(Say 555)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 556)
					(event claimed: 1)
				)
				(5 ; Talk
					(Say 561)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(21
							(if (and (gEgo has: 21) (not (IsFlag 35))) ; Crystal
								(event claimed: 1)
								(rm052 setScript: EgoUsingCrystal)
							)
						)
						(28
							(event claimed: 0)
						)
						(else
							(if (not (IsFlag 35))
								(Say 560)
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance path52 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 557)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance theCastle of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0200))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 558)
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath 159 100)
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

