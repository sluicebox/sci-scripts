;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm054 0
)

(local
	[local0 12] = [317 189 223 147 168 116 168 0 319 0 319 189]
	[local12 14] = [0 189 0 0 164 0 164 120 117 122 91 144 13 189]
	[local26 8] = [123 125 168 125 189 144 105 144]
)

(instance rm054 of KQ5Room
	(properties
		picture 54
		south 53
	)

	(method (init)
		(super init:)
		(Load rsSOUND 132)
		(if (not (IsFlag 55))
			(= global325
				{"Come on, Graham! This place gives me the shivers!"}
			)
			(= global320 208)
			(= global321 56)
			(self setRegions: 202) ; owl
			(if (not (IsFlag 99))
				(gEgo setScript: conversation)
			)
		)
		(self setRegions: 550 setFeatures: wall island) ; castle
		(grate init:)
		(if (== ((gInventory at: 30) owner:) 54) ; Iron_Bar
			(grate loop: 5 posn: 174 126 setCel: 8)
			(poker init:)
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
		(if (not (== (self script:) falling))
			(if (<= (gEgo y:) 139)
				(gEgo setPri: 8)
			else
				(gEgo setPri: -1)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 6)
				(SetFlag 99)
			)
			(1
				(proc0_28 75 54 0 67 10 10 25 5) ; "See? Dead end! Let's go back now!"
				(proc0_28 160 54 1 67 50 10 25 6) ; "No! I'll figure this out!"
				(= cycles 1)
			)
			(2
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
					(proc0_28 75 54 2 67 20 20 25 3) ; "No, don't...!"
				)
				(= cycles 1)
			)
			(1
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
				(= global330
					{That last step was a doozy!}
				)
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
				(gGlobalSound3 number: 132 loop: 1 play:)
				(gEgo setLoop: 2 setCycle: Fwd)
				(= cycles 17)
			)
			(3
				(gEgo setLoop: 1 cel: 3 setCycle: Beg self)
			)
			(4
				(gEgo
					view: 0
					setLoop: -1
					normal: 1
					setCycle: SyncWalk
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
					setCycle: SyncWalk
					cycleSpeed: 0
				)
				(SetScore 4)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(11
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
					(proc0_28 75 54 3 67 10 10 25 7) ; "You're crazy to go down into that dark hole; you don't know what's down there!"
					(proc0_28 160 54 4 67 50 10 25 5) ; "Well, do you have any better ideas?"
					(proc0_28 75 54 5 67 10 10 25 5) ; "No...uh, mind if I wait for you here?"
					(proc0_28 160 54 6 67 50 10 25 7) ; "No, that's a good idea, Cedric. You be the lookout out here!"
					(proc0_28 75 54 7 67 10 10 25 5) ; "Yes...I'll be the lookout. Be careful, Graham!"
				)
				(= cycles 1)
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
				(PrintDC 54 8 #at 10 10) ; "Graham tugs hard on the grate but soon finds it's rusted in place and can't be budged."
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
					setCycle: SyncWalk
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
						(PrintDC 54 9 #at 10 10) ; "The open grate in the stone platform invites Graham's entry."
					else
						(PrintDC 54 10 #at 10 10) ; "Graham notices a rusted grate imbedded into a stone platform of Mordack's castle."
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
							(PrintDC 54 11) ; "Too late! One of Mordack's henchman is coming."
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
								(PrintDC 54 12 #at 10 10) ; "The grate is already open."
							else
								(PrintDC 54 13 #at 10 10) ; "That won't help budge the grate."
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
					(PrintDC 54 14 #at 10 10) ; "The iron bar holds up the rusted grate."
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
					(PrintDC 54 15 #at 10 10) ; "Graham has found a stone platform on the west side of the strange castle."
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
					(PrintDC 54 16 #at 10 10) ; "The twisted and deformed shapes of the island's rocks seem to grow like strange weeds."
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

