;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use CodeCue)
(use n770)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm054 0
)

(local
	[local0 12] = [317 189 223 147 168 116 168 0 319 0 319 189]
	[local12 14] = [0 189 0 0 164 0 164 120 117 122 91 144 13 189]
	[local26 8] = [123 125 168 125 189 144 105 144]
	local34
	[local35 9] = [1000 173 8 4 11 24 19 23 30]
	[local44 9] = [1003 115 113 4 11 25 23 31 31]
	[local53 6] = [0 3086 1 7033 0 0]
	[local59 12] = [0 3087 1 7034 0 3088 1 7035 0 3089 0 0]
)

(instance rm054 of KQ5Room
	(properties
		picture 54
		south 53
	)

	(method (init)
		(super init:)
		(if (not (IsFlag 55))
			(= global325 3083)
			(= global320 208)
			(= global321 56)
			(self setRegions: 202) ; owl
			(if (not (IsFlag 99))
				(gEgo setScript: conversation)
			)
		)
		(self setRegions: 550 setFeatures: wall island) ; castle
		(grate init: stopUpd:)
		(if (== ((gInventory at: 30) owner:) 54) ; Iron_Bar
			(grate loop: 5 posn: 174 126 setCel: 8)
			(poker init: stopUpd:)
		)
		(if (not (IsFlag 55))
			(gEgo view: 0 posn: 156 186 init:)
			(self setScript: (ScriptID 202 1)) ; stdWalkIn
		else
			(gEgo view: 0 posn: 156 246 init:)
			(self setScript: enterIn)
		)
		(if (and (!= ((gInventory at: 30) owner:) 54) (not (gEgo has: 30))) ; Iron_Bar, Iron_Bar
			(= global345 163)
			(= global346 182)
			(= global347 271)
			(= global348 171)
			((ScriptID 550 3) init:) ; theHenchMan
		)
		(poly1 points: @local0 size: 6)
		(poly2 points: @local12 size: 7)
		(poly3 points: @local26 size: 4)
		(self addObstacle: poly1 poly2 poly3)
	)

	(method (doit &tmp temp0)
		(if (not (== script falling))
			(if (<= (gEgo y:) 139)
				(gEgo priority: 8 signal: (| (gEgo signal:) $0010))
			else
				(gEgo priority: -1 signal: (& (gEgo signal:) $ffef))
			)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(if (and (== temp0 53) (not (IsFlag 55)))
					((ScriptID 202 2) register: 3) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: temp0)
				)
			)
			((& (gEgo onControl: 0) $2000)
				(HandsOff)
				(self setScript: falling)
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
		(super dispose:)
	)
)

(instance enterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 156 186 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance conversation of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if local34
			(gGame setCursor: gWaitCursor)
			(User canControl: 0 canInput: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local34 1)
				(SetFlag 99)
				(= seconds 6)
			)
			(1
				(proc770_0 @local44 gEgo)
				(proc762_0 @local35 @local44 @local53 self)
			)
			(2
				(= local34 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: (ScriptID 550 3)) ; theHenchMan
					((ScriptID 550 3) setScript: 0 setMotion: 0) ; theHenchMan
				)
				(if (not (IsFlag 55))
					(proc762_1 @local35 3032 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGlobalAudio number: 7053 play:)
				(gGlobalSound3 number: 60 loop: 1 play:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 68
					setLoop: 1
					cel: 0
					setCycle: End self
					cycleSpeed: 1
					setPri: 1
					illegalBits: 0
				)
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
				(= global330 412)
				(HandsOn)
				(EgoDead)
			)
		)
	)
)

(instance liftGrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 30 54) ; Iron_Bar
				(HandsOff)
				(SetFlag 41)
				(gEgo normal: 0 setMotion: PolyPath 198 144 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					view: 672
					setLoop: 1
					posn: 198 144
					cycleSpeed: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gGlobalAudio number: 8132 loop: 1 play: self)
				(gEgo setLoop: 2 setCycle: Fwd)
			)
			(3
				(gEgo setLoop: 1 cel: 3 setCycle: Beg)
				(= seconds 4)
			)
			(4
				(gEgo
					view: 0
					setLoop: -1
					normal: 1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setMotion: MoveTo 165 145 self
				)
				((gEgo head:) show:)
			)
			(5
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 672
					posn: 162 149
					cycleSpeed: 3
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
				(grate cycleSpeed: 3 loop: 5 setCycle: End)
			)
			(7
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(8
				(poker init:)
				(grate posn: 174 126)
				(RedrawCast)
				(gEgo setLoop: 7 cel: 0 setCycle: End self)
			)
			(9
				(gEgo setLoop: 8 cel: 0 setCycle: End self)
			)
			(10
				(gEgo
					view: 0
					setLoop: -1
					normal: 1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
				)
				(SetScore 4)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(11
				(grate stopUpd:)
				(HandsOn)
				(proc0_7 gEgo grate 5)
				(client setScript: 0)
			)
		)
	)
)

(instance enterGrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 55))
					(cond
						((< (gGame detailLevel:) 3)
							(= cycles 1)
						)
						((== (global322 cel:) 0)
							(global322 setScript: 0 setCycle: CT 1 1 self)
						)
						((> (global322 cel:) 1)
							(global322 setScript: 0 setCycle: CT 1 -1 self)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
				(gEgo setMotion: PolyPath 165 145 self)
			)
			(1)
			(2
				(if (not (IsFlag 55))
					(proc770_0 @local44 gEgo)
					(proc762_0 @local35 @local44 @local59 self)
				else
					(= cycles 1)
				)
			)
			(3
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 672
					posn: 165 145
					cycleSpeed: 3
					cel: 3
					setLoop: 8
					setCycle: Beg self
				)
			)
			(4
				(gEgo setLoop: 9 cel: 0 setCycle: End self)
			)
			(5
				(HandsOn)
				(gCurRoom newRoom: 55)
			)
		)
	)
)

(instance pullGrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 169 145 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 672
					cycleSpeed: 3
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(Say 571)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					view: 0
					setLoop: -1
					normal: 1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance grate of Prop
	(properties
		x 174
		y 125
		view 672
		priority 9
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(and
					(not (MousedOn self event))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
				)
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (IsFlag 41)
						(Say 566)
					else
						(Say 567)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						(
							(and
								(gCast contains: (ScriptID 550 3)) ; theHenchMan
								(>= (((ScriptID 550 3) script:) state:) 1) ; theHenchMan
							)
							(Say 9069)
						)
						((IsFlag 41)
							(HandsOff)
							(gCurRoom setScript: enterGrate)
						)
						(else
							(HandsOff)
							(gCurRoom setScript: pullGrate)
						)
					)
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(30
							(gCurRoom setScript: liftGrate)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(if (== ((gInventory at: 30) owner:) 54) ; Iron_Bar
								(Say 572)
							else
								(Say 573)
							)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance poker of Prop
	(properties
		x 166
		y 144
		view 672
		loop 10
		priority 10
		signal 16401
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 568)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wall of RFeature
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
					(Say 569)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance island of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

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
					(Say 570)
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
	(properties)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

