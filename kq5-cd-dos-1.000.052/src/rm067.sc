;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use CodeCue)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm067 0
)

(local
	local0
	local1
	local2
	[local3 9] = [141 35 159 165 34 165 183 40 163]
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	[local20 16] = [92 149 75 159 37 156 32 120 32 0 319 0 319 168 192 151]
	[local36 12] = [319 189 0 189 0 181 260 182 302 172 319 175]
	[local48 14] = [0 105 15 153 69 167 25 178 6 171 6 177 0 177]
	[local62 9] = [1012 5 100 4 9 31 26 29 32]
	[local71 9] = [1003 116 62 4 11 25 23 31 31]
	[local80 12] = [0 1073 1 1074 0 1075 1 1076 0 1077 0 0]
)

(procedure (localproc_0)
	(= [local71 1] (Min (Max 0 (- (gEgo x:) 40)) 239))
)

(instance rm067 of KQ5Room
	(properties
		picture 67
	)

	(method (init)
		(super init:)
		(Load rsVIEW 697)
		(Load rsVIEW 695)
		(Load rsVIEW 902)
		(Load rsVIEW 882)
		(Load rsVIEW 904)
		(Load rsSOUND 97)
		(Load rsSOUND 62)
		(= global322 actor_1)
		(self setRegions: 550 setFeatures: mouseHole hole grate) ; castle
		(switch gPrevRoomNum
			(55
				(stone init: setPri: 13 stopUpd:)
				(stone cel: (stone lastCel:) forceUpd:)
				(gCurRoom setScript: enterHole)
			)
			(else
				(stone init: setPri: 5 stopUpd:)
				(self addObstacle: poly4)
				(gEgo
					init:
					hide:
					view: 882
					ignoreActors: 1
					illegalBits: 0
					setLoop: 14
					setCel: 1
					posn: 1000 1000
				)
				((gEgo head:) moveHead: 0 hide:)
				(Load rsSOUND 67)
				(proc550_17)
				(self setScript: henchCaught)
			)
		)
		(dripple setCel: 255 setPri: 5 init: hide:)
		(splash setCycle: Fwd init: hide:)
		(poly2 points: @local20 size: 8)
		(poly3 points: @local36 size: 6)
		(poly4 points: @local48 size: 7)
		(self addObstacle: poly2 poly3 poly4)
	)

	(method (doit &tmp temp0 temp1)
		(reflection
			loop: (gEgo loop:)
			cel: (gEgo cel:)
			x: (gEgo x:)
			y: (+ (gEgo y:) 1)
		)
		(if (and (& (gEgo onControl: 1) $0004) (gEgo mover:))
			(= temp0 (gEgo x:))
			(= temp1 (gEgo y:))
			(switch (gEgo loop:)
				(0
					(+= temp0 1)
				)
				(1
					(-= temp0 1)
				)
				(3
					(-= temp1 2)
				)
				(2
					(+= temp1 1)
				)
			)
			(splash cycleSpeed: (gEgo cycleSpeed:) x: temp0 y: temp1 show:)
		else
			(splash hide:)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(& (gEgo onControl: 0) $0010)
					(== (stone cel:) (stone lastCel:))
				)
				(self setScript: enteringHole)
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
			((== (event type:) evVERB)
				(switch (event message:)
					(2 ; Look
						(if (& (OnControl CONTROL (event x:) (event y:)) $0004)
							(Say 9050)
						else
							(Say 9051)
						)
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

(instance drippingWater of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (and (= temp0 (drop mover:)) (< (= temp1 (temp0 dy:)) 16))
			(temp0 dy: (* temp1 2))
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 3 10))
				(= local0 [local3 (= temp0 (* (Random 0 2) 3))])
				(= local1 [local3 (++ temp0)])
				(= local2 [local3 (++ temp0)])
			)
			(1
				(dripple
					loop: 0
					cel: 0
					posn: local0 local1
					cycleSpeed: 0
					setCycle: CT 2 1 self
					show:
				)
			)
			(2
				(drop
					posn: local0 (+ local1 4)
					yStep: 1
					setMotion: MoveTo local0 local2 self
					show:
				)
				(dripple setCycle: End)
			)
			(3
				(drop hide:)
				(gGlobalAudio number: 8098 loop: 1 play:)
				(dripple
					posn: local0 local2
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance moveStone of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (== local12 gEgo) (not (-- local15)))
			(if cycles
				(= temp0 (+ local13 (^= local14 $0001)))
				(= local15 2)
			else
				(= temp0 local13)
				(= local12 0)
			)
			((gEgo head:) loop: temp0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 40))
			)
			(1
				(if
					(or
						(== (gCurRoom script:) lookInMseHole)
						(& (gEgo onControl: 0) $0018)
						(< (gEgo x:) 55)
					)
					(= seconds 8)
					(= cycles 1)
					(= state 0)
				else
					(= cycles 1)
				)
				(gGlobalSound fade:)
			)
			(2
				(proc550_17)
				(gEgo observeControl: 8 setMotion: 0)
				(gGlobalAudio number: 7065 play:)
				(= local13 ((gEgo head:) loop:))
				(stone setPri: 5 cycleSpeed: 6 setCycle: CT 4 1 self)
			)
			(3
				(proc0_7 gEgo stone 0)
				(gGlobalSound number: 97 loop: 1 vol: 127 play:)
				(gGlobalAudio number: 8892 play:)
				(stone setPri: 13 cycleSpeed: 3 setCycle: End self)
			)
			(4
				((gEgo head:)
					cel:
						(&
							(StrAt ((gEgo head:) headCel:) (gEgo cel:))
							$000f
						)
					moveHead: 0
				)
				(stone setPri: -1 stopUpd:)
				(= seconds 3)
			)
			(5
				((gCurRoom obstacles:) delete: poly4)
				(global322
					init:
					view: 882
					setLoop: 8
					setCel: 0
					setPri: 5
					posn: 20 144
					xStep: 1
					cycleSpeed: 2
					setMotion: MoveTo 24 144 self
					show:
				)
				(prop1
					view: 882
					loop: 10
					posn: 22 136
					setCycle: Fwd
					setPri: 11
					init:
					hide:
				)
			)
			(6
				(global322 setCycle: CT 4 1 self)
			)
			(7
				(localproc_0)
				(proc762_0 @local62 @local71 @local80 self)
			)
			(8
				(global322 setCycle: End self)
				(= local14 2)
			)
			(9
				(global322 setLoop: 9 cel: 0 setCycle: End self)
			)
			(10
				(global322 setCycle: Beg self)
			)
			(11
				(if (-- local14)
					(-= state 2)
				else
					(global322 setLoop: 8)
				)
				(= cycles 1)
			)
			(12
				(global322 cel: (global322 lastCel:) setCycle: Beg self)
				(gGlobalSound fade:)
			)
			(13
				(global322 setCel: 0 setMotion: MoveTo 20 144 self)
			)
			(14
				(gGlobalSound number: 67 loop: -1 vol: 127 play:)
				(SetFlag 69)
				(SetFlag 96)
				(global322 dispose: delete:)
				((gEgo head:) moveHead: 1)
				(proc550_18)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(client setScript: 0)
			)
		)
	)
)

(instance enteringHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo
					normal: 0
					illegalBits: 0
					ignoreActors: 1
					setPri: 5
					setMotion: MoveTo 33 155 self
				)
			)
			(1
				(gEgo
					view: 882
					loop: 12
					cel: 0
					ignoreActors: 1
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(2
				(gEgo
					setLoop: 15
					cel: 0
					xStep: 1
					setCycle: KQ5SyncWalk
					moveSpeed: 1
					setMotion: MoveTo 21 155 self
				)
			)
			(3
				(proc550_18)
				(gCurRoom newRoom: 55)
			)
		)
	)
)

(instance lookInMseHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo setMotion: MoveTo 183 150 self)
			)
			(1
				(gEgo
					view: 882
					loop: 5
					cel: 0
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 1)
					normal: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
				(reflection hide:)
			)
			(2
				(if (and (not local19) (not local16))
					(global322
						view: 214
						setLoop: 0
						cel: 0
						posn: 156 144
						setPri: 14
						setStep: 6 4
						cycleSpeed: 2
						setMotion: MoveTo 119 126
						setCycle: CT 4 1 self
						init:
						show:
					)
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(3
				(User canInput: 1)
				(User canControl: 0)
				(gTheIconBar enable:)
				(= global102 0)
				(= global103 0)
				(global322 setMotion: 0 hide:)
				(prop1
					view: 882
					loop: 1
					cel: 1
					posn: (global322 x:) (+ (global322 y:) 5)
					setPri: (+ (global322 priority:) 1)
					setCycle: 0
					init:
					show:
				)
				(= cycles 2)
			)
			(4
				(Say 691)
				(if (not local16)
					(= local18 1)
					(+= state 3)
					(= seconds 5)
				else
					(= cycles 1)
				)
			)
			(5
				(proc550_17)
				(gEgo setMotion: 0 loop: 6 cel: 0 setCycle: End self)
			)
			(6
				(if (not local19)
					(cond
						(local16
							(Say 698)
							(= local16 0)
						)
						(local17
							(Say 699)
							(++ local17)
						)
						(else
							(Say 700)
							(++ local17)
						)
					)
				else
					(Say 705)
					(= local17 2)
					(SetScore 4)
					(gEgo get: 32) ; Moldy_Cheese
				)
				(gEgo setCycle: Beg self)
			)
			(7
				(proc550_17)
				(gEgo loop: 5 cel: (gEgo lastCel:) setMotion: 0)
				(= cycles 1)
			)
			(8
				(= local18 0)
				(global322 hide:)
				(prop1 hide:)
				(gEgo setCycle: Beg self)
			)
			(9
				(proc550_18)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(gEgo
					view: 0
					loop: 7
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 1)
					setCycle: KQ5SyncWalk
					normal: 1
				)
				((gEgo head:) show:)
				(proc0_7 gEgo prop1 5)
				(reflection show:)
				(client setScript: 0)
			)
		)
	)
)

(instance mouseRunning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound3 number: 62 loop: 1 play:)
				(global322
					view: 882
					setLoop: 4
					posn: 64 189
					setPri: 5
					setStep: 4 3
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 64 164 self
					init:
					show:
				)
			)
			(1
				(global322 setLoop: 3 posn: 61 159)
				(= cycles 10)
			)
			(2
				(global322 setMotion: MoveTo 119 148 self)
			)
			(3
				(= cycles 10)
			)
			(4
				(global322 setMotion: MoveTo 153 148 self)
			)
			(5
				(= cycles 10)
			)
			(6
				(global322
					setLoop: 4
					posn: 157 152
					setPri: 4
					setMotion: MoveTo 157 138 self
				)
			)
			(7
				(client setScript: 0)
			)
		)
	)
)

(instance drop of Actor
	(properties
		view 882
		loop 1
		priority 12
		signal 22544
		illegalBits 0
	)
)

(instance actor_1 of Actor
	(properties
		signal 24576
		illegalBits 0
	)
)

(instance prop1 of Prop
	(properties
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(not local18)
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 692)
					(event claimed: 1)
					(return)
				)
				(3 ; Do
					(if (< local17 2)
						(event claimed: 1)
					)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(31
							(if (gEgo has: 32) ; Moldy_Cheese
								(Say 706)
								(event claimed: 1)
							else
								(= local19 1)
								(lookInMseHole start: 2)
								(rm067 setScript: lookInMseHole)
							)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 707)
							(event claimed: 1)
						)
					)
				)
			)
			(if (event claimed:)
				((rm067 script:)
					state: (- ((rm067 script:) state:) 3)
					seconds: 0
					cycles: 1
				)
			)
		)
	)
)

(instance reflection of Prop
	(properties
		x 319
		y 189
		view 883
		signal 16384
	)
)

(instance dripple of Prop
	(properties
		view 882
		signal 16384
		detailLevel 3
	)
)

(instance stone of Prop
	(properties
		x 24
		y 176
		view 882
		loop 7
		signal 16384
		cycleSpeed 2
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
					(cond
						((== (stone cel:) (stone lastCel:))
							(Say 693)
							(event claimed: 1)
						)
						((IsFlag 96)
							(Say 694)
							(event claimed: 1)
						)
						(else
							(event claimed: 0)
						)
					)
				)
				(3 ; Do
					(cond
						((== (stone cel:) (stone lastCel:))
							(Say 701)
							(event claimed: 1)
						)
						((IsFlag 96)
							(Say 702)
							(event claimed: 1)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance splash of Prop
	(properties
		view 882
		loop 13
		signal 16384
		cycleSpeed 1
	)
)

(instance mouseHole of RFeature
	(properties
		nsTop 141
		nsLeft 151
		nsBottom 147
		nsRight 163
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
					(cond
						((gEgo has: 32) ; Moldy_Cheese
							(Say 695)
							(event claimed: 1)
						)
						((== (gCurRoom script:) lookInMseHole)
							(event claimed: 0)
						)
						(else
							(rm067 setScript: lookInMseHole)
							(event claimed: 1)
						)
					)
				)
				(3 ; Do
					(if (not (gEgo has: 32)) ; Moldy_Cheese
						(switch local17
							(0
								(= local16 1)
								(if (== (gCurRoom script:) lookInMseHole)
									(lookInMseHole start: 2)
								else
									(lookInMseHole start: 0)
								)
								(rm067 setScript: lookInMseHole)
								(event claimed: 1)
							)
							(1
								(Say 699)
								(event claimed: 1)
							)
						)
					else
						(Say 703)
						(event claimed: 1)
					)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(31
							(if (not (gEgo has: 32)) ; Moldy_Cheese
								(= local19 1)
								(if (== (gCurRoom script:) lookInMseHole)
									(lookInMseHole start: 2)
								else
									(lookInMseHole start: 0)
								)
								(rm067 setScript: lookInMseHole)
								(event claimed: 1)
							else
								(Say 703)
								(event claimed: 1)
							)
						)
						(28
							(event claimed: 0)
						)
						(else
							(Say 707)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance hole of RFeature
	(properties
		nsTop 127
		nsLeft 14
		nsBottom 146
		nsRight 26
	)

	(method (handleEvent event)
		(if
			(or
				(!= (stone cel:) (stone lastCel:))
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 696)
					(event claimed: 1)
				)
				(3 ; Do
					(proc550_17)
					(gCurRoom setScript: gotoHole)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance dieScumScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 30 60))
			)
			(1
				(proc550_17)
				(gEgo setMotion: PolyPath 90 160 self)
			)
			(2
				(Say 689)
				(= cycles 1)
			)
			(3
				((gEgo head:) hide:)
				(gEgo
					setMotion: 0
					normal: 0
					view: 264
					setLoop: 1
					setCycle: End self
				)
				(= global103 0)
			)
			(4
				(= global330 690)
				(EgoDead)
			)
		)
	)
)

(instance grate of RFeature
	(properties
		nsTop 3
		nsLeft 138
		nsBottom 24
		nsRight 184
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
					(Say 697)
					(event claimed: 1)
				)
				(3 ; Do
					(Say 704)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance ringsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (< (DoSound sndGET_POLYPHONY) 8)
					((ScriptID 550 5) setCycle: End self) ; theRings
				else
					(gGlobalAudio number: 8071 loop: 1 play: self)
					((ScriptID 550 5) setCycle: End) ; theRings
				)
			)
			(1
				(= cycles 5)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance enterHole of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(Load rsVIEW 0)
				(gGlobalSound number: 67 loop: -1 playBed:)
				(gEgo
					init:
					normal: 0
					view: 883
					posn: 33 158
					illegalBits: 0
					ignoreActors: 1
					setLoop: 4
					cel: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(1
				((gEgo head:) show:)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: KQ5SyncWalk
					posn: 31 158
					setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self
				)
			)
			(2
				(reflection setPri: 3 init:)
				(drop setScript: drippingWater init: hide:)
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance henchCaught of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gGlobalAudio number: 8018 loop: 1 play:)
				((ScriptID 550 4) ; theMagicDoor
					view: 695
					setLoop: 3
					posn: 294 161
					cycleSpeed: 3
					init:
					setPri: 4
					setCycle: End self
				)
			)
			(1
				((ScriptID 550 5) ; theRings
					init:
					posn: ((ScriptID 550 4) x:) (- ((ScriptID 550 4) y:) 34) ; theMagicDoor, theMagicDoor
					setLoop: 3
					cycleSpeed: 1
					setPri: 5
					setScript: ringsScript
				)
				((ScriptID 550 3) ; theHenchMan
					init:
					setScript: 0
					illegalBits: 0
					ignoreActors: 1
					show:
					view: 904
					posn: 334 155
					setPri: 5
					setLoop: 3
					setCel: 0
					cycleSpeed: 4
					moveSpeed: 2
					setMotion: MoveTo 295 155 self
				)
			)
			(2
				((ScriptID 550 3) setCycle: CT 3 1 self) ; theHenchMan
			)
			(3
				((ScriptID 550 3) cel: 4) ; theHenchMan
				(gEgo posn: 227 147 show: setLoop: 14 cel: 1 normal: 0)
				(= cycles 1)
			)
			(4
				((ScriptID 550 3) setCycle: End) ; theHenchMan
				(gEgo cel: 2 setCycle: End self)
			)
			(5
				(gGlobalAudio number: 8078 play:)
				(gEgo
					view: 882
					setLoop: 11
					posn: (- (gEgo x:) 13) (+ (gEgo y:) 3)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(drop setScript: drippingWater init: hide:)
				(NormalEgo)
				(gEgo view: 0 loop: 2)
				((gEgo head:) moveHead: 1 show:)
				(reflection setPri: 3 init:)
				((ScriptID 550 3) dispose:) ; theHenchMan
				(= global333 0)
				(if (== global331 5)
					(SetFlag 64)
					(if (< global353 120)
						(= global353 120)
					)
				)
				((ScriptID 550 5) dispose:) ; theRings
				(gGlobalAudio number: 8018 loop: 1 play:)
				((ScriptID 550 4) ; theMagicDoor
					view: 695
					setCel: 255
					cycleSpeed: 4
					setCycle: Beg self
				)
			)
			(7
				((ScriptID 550 4) dispose:) ; theMagicDoor
				(= seconds 2)
			)
			(8
				(if (and (not (IsFlag 96)) (== ((gInventory at: 25) owner:) 57)) ; Locket
					(stone setScript: moveStone)
				else
					(stone setScript: dieScumScript)
				)
				(gGlobalSound number: 67 loop: -1 playBed:)
				(= seconds 2)
			)
			(9
				(global322 setScript: mouseRunning)
				(= seconds 3)
			)
			(10
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance gotoHole of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setPri: (if (< (gEgo y:) 166) 5 else -1)
					setMotion: PolyPath 60 160 self
				)
			)
			(1
				(gEgo setPri: 5 setMotion: PolyPath 33 155)
				(client setScript: 0)
			)
		)
	)
)

