;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use Rev)
(use RFeature)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 10] = [0 0 78 0 78 122 20 132 0 142]
	[local20 10] = [281 117 298 128 282 138 248 139 227 117]
	[local30 10] = [204 0 319 0 319 122 277 112 204 112]
	[local40 12] = [223 152 242 152 262 159 264 189 206 189 205 158]
	[local52 8] = [42 150 107 136 75 189 42 189]
	[local60 8] = [54 55 56 57 55 60 58 59]
)

(instance rm031 of KQ5Room
	(properties
		picture 31
		east 32
	)

	(method (newRoom)
		(gEgo illegalBits: -32768)
		(super newRoom: &rest)
	)

	(method (init)
		(super init:)
		(= global320 238)
		(= global321 146)
		(if (not (IsFlag 34))
			(self setRegions: 202) ; owl
			(= global325 {"There must be another way!"})
		)
		(self
			setFeatures:
				step1
				step2
				step3
				path31a
				path31b
				path31c
				log
				rope
				waterFall
		)
		(switch gPrevRoomNum
			(30
				(gEgo normal: 0 view: 478 posn: 55 213 setLoop: 0 init:)
				((gEgo head:) hide:)
				(= local0 0)
				(HandsOff)
				(self setScript: climbIn)
				(gGlobalSound2 number: 54 loop: 1 play: 100)
			)
			(else
				(gEgo view: 10 posn: 312 156 illegalBits: 0 init: setPri: 11)
				(= local0 8)
				(gGlobalSound2 number: 59 loop: 1 play:)
			)
		)
		(step4 init:)
		(step5 init:)
		(step6 init:)
		(poly1 points: @local10 size: 5)
		(poly2 points: @local20 size: 5)
		(poly3 points: @local30 size: 5)
		(poly4 points: @local40 size: 6)
		(poly5 points: @local52 size: 4)
		(self addObstacle: poly1 poly2 poly3 poly4 poly5)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(if (not (IsFlag 34))
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: temp0)
				)
			)
			((& (= temp1 (gEgo onControl: 1)) $2000)
				(HandsOff)
				(if (not (IsFlag 34))
					(proc0_28 75 31 0 67 10 10 25 5) ; "No! Stay away from the edge...!"
				)
				(self setScript: falling)
			)
			((& temp1 $4000)
				(self setScript: walkNorth)
			)
			((gEgo inRect: 231 114 253 119)
				(self setScript: walkSouth)
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
		(DisposeScript 969)
		(DisposeScript 991)
		(gEgo setPri: -1)
		(super dispose:)
	)
)

(instance walkNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 494
					normal: 0
					illegalBits: 0
					setLoop: 5
					cel: 0
					cycleSpeed: 1
					setPri: 8
					setCycle: End self
					setMotion: JumpTo 271 123 self
				)
				((gEgo head:) hide:)
			)
			(1)
			(2
				(gEgo
					view: 10
					normal: 1
					setLoop: -1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setMotion: MoveTo 242 111 self
				)
				((gEgo head:) show:)
			)
			(3
				(gEgo
					view: 494
					normal: 0
					setLoop: 5
					cel: 0
					setPri: -1
					cycleSpeed: 1
					setCycle: End self
					setMotion: JumpTo 226 115 self
				)
				((gEgo head:) hide:)
			)
			(4)
			(5
				(gEgo
					view: 10
					normal: 1
					setLoop: -1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					illegalBits: 0
					setPri: 7
				)
				((gEgo head:) show:)
				(= local0 7)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 494
					normal: 0
					illegalBits: 0
					cel: 0
					setLoop: 2
					cycleSpeed: 1
					setPri: 8
					setCycle: End self
					setMotion: JumpTo 242 111 self
				)
				((gEgo head:) hide:)
			)
			(1)
			(2
				(gEgo
					normal: 1
					view: 10
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					illegalBits: 0
					setMotion: MoveTo 271 123 self
				)
				((gEgo head:) show:)
			)
			(3
				(gEgo
					view: 494
					normal: 0
					setLoop: 2
					cel: 0
					setPri: -1
					cycleSpeed: 1
					setCycle: End self
					setMotion: JumpTo 284 152 self
				)
				((gEgo head:) hide:)
			)
			(4)
			(5
				(gEgo
					view: 10
					normal: 1
					setPri: 11
					setLoop: -1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					illegalBits: -32768
				)
				((gEgo head:) show:)
				(= local0 8)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 78
					setLoop: (if (gEgo inRect: 207 117 233 123) 1 else 0)
					cel: 0
					setCycle: End self
					illegalBits: 0
				)
				(if (<= (gEgo y:) 138)
					(gEgo setPri: 5)
				else
					(gEgo setPri: 10)
				)
				(PrintDC 31 1 #at 20 20 #dispose) ; "Aaaaiiiieeeeeeee!!"
				(gGlobalSound2 number: 83 loop: 1 play: self)
			)
			(2
				(gEgo
					yStep: 8
					setMotion: MoveTo (- (gEgo x:) 20) 230 self
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(cls)
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance jumping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((== local0 0)
						(gEgo illegalBits: 0 setMotion: MoveTo 89 132 self)
					)
					((== local0 7)
						(gEgo setPri: -1 setMotion: MoveTo 217 116 self)
					)
					(else
						(= cycles 3)
					)
				)
			)
			(1
				(if (and (not (IsFlag 34)) (not local5))
					(proc0_28 75 31 2 67 10 10 25 5) ; "Do be careful, Graham!"
					(++ local5)
				)
				(cond
					((== local1 7)
						(= local6 0)
					)
					((== local1 0)
						(= local6 1)
					)
					((and (< local0 4) (> local1 3))
						(if (< (gEgo x:) local2)
							(= local6 2)
						else
							(= local6 3)
						)
					)
					((and (< local1 4) (> local0 3))
						(if (< (gEgo x:) local2)
							(= local6 4)
						else
							(= local6 5)
						)
					)
					((< (gEgo x:) local2)
						(= local6 0)
					)
					(else
						(= local6 1)
					)
				)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 494
					looper: 0
					cycleSpeed: 0
					setLoop: local6
					cel: 0
					setCycle: End self
					setMotion: JumpTo local2 local3 self
					illegalBits: 0
				)
			)
			(2)
			(3
				(cls)
				(if (or local9 (== local1 100))
					(++ state)
					(++ state)
					(= seconds 1)
				else
					(= local0 local1)
					(gGlobalSound3 number: [local60 local1] loop: -1 play: 100)
					(gEgo
						setLoop: (+ (gEgo loop:) 6)
						cel: 0
						setCycle: End self
						cycleSpeed: 2
					)
				)
			)
			(4
				(gGlobalSound3 fade:)
				(gEgo
					normal: 1
					view: 10
					setLoop: -1
					loop: (if (mod (gEgo loop:) 2) 1 else 0)
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					illegalBits: -32768
				)
				(if (== local0 7)
					(gEgo setPri: 7)
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
			(6
				(PrintDC 31 1 #at 20 20 #dispose) ; "Aaaaiiiieeeeeeee!!"
				(gGlobalSound3 number: 790 loop: 1 play: 80 self)
				(if (!= local1 100)
					(local7
						view: 497
						setLoop: local8
						cel: 0
						setCycle: End
						yStep: 8
						setMotion: MoveTo (local7 x:) (+ (local7 y:) 100) self
					)
				else
					(= cycles 5)
				)
				(gEgo
					view: 497
					cel: 0
					setLoop: (if (mod (gEgo loop:) 2) 5 else 4)
					setCycle: End
					yStep: 8
					setPri: 9
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 100) self
				)
			)
			(7
				(gGlobalSound2 number: 83 loop: 1 play: self)
			)
			(8)
			(9)
			(10
				(= global330 {Whoops! That was a fatal step!})
				(cls)
				(EgoDead)
			)
		)
	)
)

(instance climbIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322 view: 138 loop: 2 cel: 0 cycleSpeed: 3 setCycle: End)
				(gEgo cycleSpeed: 1 setMotion: MoveTo (gEgo x:) 189 self)
			)
			(1
				(global322 setScript: (ScriptID 202 3)) ; rotate
				(gEgo setLoop: 2 setCycle: 0 cel: 0 posn: 49 181)
				(= cycles 3)
			)
			(2
				(gEgo cel: 1 posn: 55 180)
				(= cycles 3)
			)
			(3
				(gEgo cel: 2 posn: 48 171)
				(= cycles 3)
			)
			(4
				(gEgo setLoop: 1 cel: 0 posn: 38 163 setCycle: End self)
			)
			(5
				(gEgo
					normal: 1
					view: 10
					cycleSpeed: 0
					setLoop: -1
					setCycle: KQ5SyncWalk
					setMotion: MoveTo 25 138 self
				)
				((gEgo head:) show:)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance climbDownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 38 163 self)
			)
			(1
				(gEgo setLoop: 0)
				(= cycles 1)
			)
			(2
				(gEgo setLoop: 3)
				(= cycles 1)
			)
			(3
				(gEgo
					normal: 0
					view: 478
					setLoop: 1
					setCel: 16
					setCycle: Beg self
				)
				((gEgo head:) hide:)
			)
			(4
				(gEgo setLoop: 2 setCycle: 0 cel: 2 posn: 48 171)
				(= cycles 3)
			)
			(5
				(gEgo cel: 1 posn: 55 180)
				(= cycles 3)
			)
			(6
				(gEgo cel: 0 posn: 49 181)
				(= cycles 3)
			)
			(7
				(global322 view: 138 loop: 8 cel: 0 cycleSpeed: 3 setCycle: End)
				(gEgo
					setLoop: 0
					posn: 56 189
					cycleSpeed: 1
					setCycle: Rev
					setMotion: MoveTo 56 213 self
				)
			)
			(8
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance path31a of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 3) ; "As with the path below, the now-frozen waterfall has also washed away parts of this upper trail which skirts the mountain edge and then heads off to the east."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 1) (== local0 4))
						(= local2 86)
						(= local3 128)
						(= local1 0)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance path31b of RFeature
	(properties)

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
					(PrintDC 31 3) ; "As with the path below, the now-frozen waterfall has also washed away parts of this upper trail which skirts the mountain edge and then heads off to the east."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 6) (== local0 5) (== local0 4))
						(= local2 177)
						(= local3 134)
						(= local1 100)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance path31c of RFeature
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
					(PrintDC 31 3) ; "As with the path below, the now-frozen waterfall has also washed away parts of this upper trail which skirts the mountain edge and then heads off to the east."
					(event claimed: 1)
				)
				(3 ; Do
					(if (== local0 6)
						(if (not (IsFlag 78))
							(SetFlag 78)
							(SetScore 2)
						)
						(= local2 218)
						(= local3 114)
						(= local1 7)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step1 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 0) (== local0 2) (== local0 4))
						(= local2 112)
						(= local3 114)
						(= local1 1)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step2 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0080))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if
						(or
							(== local0 1)
							(== local0 3)
							(== local0 4)
							(== local0 5)
						)
						(= local2 143)
						(= local3 110)
						(= local1 2)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step3 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0100))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 2) (== local0 6) (== local0 5))
						(= local2 173)
						(= local3 108)
						(= local1 3)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step4 of Actor
	(properties
		x 131
		y 124
		view 497
		priority 6
		signal 16401
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
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 1) (== local0 2) (== local0 5))
						(= local2 135)
						(= local3 118)
						(= local1 4)
						(= local7 self)
						(= local8 1)
						(if (< (Random 1 100) 50)
							(= local9 1)
						)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step5 of Actor
	(properties
		x 162
		y 136
		view 497
		cel 1
		priority 6
		signal 16401
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
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if
						(or
							(== local0 6)
							(== local0 2)
							(== local0 3)
							(== local0 4)
						)
						(= local2 161)
						(= local3 119)
						(= local9 1)
						(= local7 self)
						(= local8 2)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance step6 of Actor
	(properties
		x 189
		y 134
		view 497
		cel 2
		priority 6
		signal 16401
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
					(PrintDC 31 4) ; "Graham can see tempting rock outcroppings protruding from the frozen waterfall."
					(event claimed: 1)
				)
				(3 ; Do
					(if (or (== local0 7) (== local0 3) (== local0 5))
						(= local2 189)
						(= local3 116)
						(= local7 self)
						(= local8 3)
						(if (IsFlag 34)
							(= local9 1)
						)
						(= local1 6)
						(gCurRoom setScript: jumping)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance log of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 5) ; "An old log has fallen precariously across a washed-out portion of the narrow trail."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance waterFall of RFeature
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
					(PrintDC 31 3) ; "As with the path below, the now-frozen waterfall has also washed away parts of this upper trail which skirts the mountain edge and then heads off to the east."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rope of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 31 6) ; "Graham's rope dangles from a rocky overhang down to the path below."
					(event claimed: 1)
				)
				(3 ; Do
					(if (== local0 0)
						(HandsOff)
						(gCurRoom setScript: climbDownScript)
					else
						(PrintDC 31 7) ; "Graham can't reach the rope from here."
					)
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

(instance poly5 of Polygon
	(properties
		type PTotalAccess
	)
)

