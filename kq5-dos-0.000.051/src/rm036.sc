;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use Sort)
(use RFeature)
(use Chase)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm036 0
)

(local
	[local0 16] = [120 0 126 140 130 151 85 149 73 157 37 157 0 159 0 0]
	[local16 26] = [195 148 158 161 159 165 227 169 311 175 313 189 319 189 319 0 143 0 144 139 165 140 295 140 296 147]
	local42
)

(instance rm036 of Rm
	(properties
		picture 36
		horizon 135
		north 38
		west 35
	)

	(method (init)
		(super init:)
		(self setFeatures: path36 entrance)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 149 140)
				(gGlobalSound number: 5 loop: -1 playBed:)
			)
			(else
				(gEgo posn: 15 169)
			)
		)
		(gEgo view: 10 setStep: 3 2 illegalBits: -32768 heading: 90 init:)
		(if (!= ((gInventory at: 2) owner:) 36) ; Pie
			(yeti
				moveSpeed: 1
				setCycle: Walk
				ignoreActors: 1
				setLoop: 0
				init:
				setScript: chaseEgo
			)
			(SetFlag 41)
			(gGlobalSound2 number: 110 loop: -1 vol: 127 play:)
		)
		(poly1 points: @local0 size: 8)
		(poly2 points: @local16 size: 13)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (== temp0 38)
					(gGlobalSound fade:)
				)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $2000)
				(if (gCast contains: yeti)
					(yeti setScript: 0 setMotion: 0)
				)
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
		(DisposeScript 977)
		(super dispose:)
	)
)

(instance chaseEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (HaveMouse)
					(= cycles 10)
				else
					(= seconds 3)
				)
			)
			(1
				(yeti setMotion: MoveTo 168 (yeti y:) self)
			)
			(2
				(yeti setMotion: Chase gEgo 32 self)
			)
			(3
				(HandsOff)
				(gEgo setMotion: 0)
				(yeti
					illegalBits: 0
					setPri: (+ (gEgo priority:) 2)
					setMotion:
						MoveTo
						(+ (gEgo x:) 28)
						(- (gEgo y:) 3)
						self
				)
			)
			(4
				(gCurRoom setScript: bogusScript)
				(yeti loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(5
				(if (and (>= (gEgo heading:) 0) (<= (gEgo heading:) 180))
					(= temp0 5)
				else
					(= temp0 6)
				)
				(gEgo
					normal: 0
					setPri: (+ (yeti priority:) 1)
					setLoop: temp0
					x: (- (yeti x:) 35)
					y: (- (yeti y:) 2)
					view: 542
					ignoreActors:
					cycleSpeed: 1
					setCycle: Fwd
				)
				((gEgo head:) hide:)
				(= seconds 4)
			)
			(6
				(gGlobalSound2 stop:)
				(= global330 {What an abominable situation!})
				(EgoDead 544)
			)
		)
	)
)

(instance bogusScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
		)
	)
)

(instance throwPie of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not state) (<= (yeti x:) 250))
			(= cycles 1)
		)
		(if (and (== state 2) (<= (- (yeti x:) (thePie x:)) 18))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local42 1)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 558
					x: (+ (gEgo x:) 13)
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: CT 6 1 self
				)
			)
			(2
				(gEgo setCycle: End put: 2 36) ; Pie
				(thePie
					posn: (+ (gEgo x:) 31) (- (gEgo y:) 34)
					setCycle: Walk
					setMotion: MoveTo (yeti x:) (- (yeti y:) 34)
					init:
				)
				(gGlobalSound2 stop:)
				(gGlobalSound3 number: 116 loop: 1 vol: 127 play:)
			)
			(3
				(gGlobalSound3 number: 111 loop: 1 vol: 127 play:)
				(thePie dispose:)
				(yeti
					illegalBits: 0
					setLoop: 1
					setScript: 0
					setStep: 2 1
					cycleSpeed: 4
					setCycle: End
					setMotion: MoveTo (yeti x:) 167 self
				)
				(chaseEgo client: 0 dispose:)
			)
			(4
				(yeti setLoop: 2 setCycle: Beg self)
			)
			(5
				(yeti
					setLoop: 1
					cycleSpeed: 6
					setCycle: End self
					setMotion: MoveTo (+ (yeti x:) 5) (yeti y:)
				)
			)
			(6
				(yeti setLoop: 2 cel: 0 setCycle: Beg self setStep: 4 3)
			)
			(7
				(gGlobalSound3 number: 115 loop: 1 vol: 127 play:)
				(yeti
					setLoop: 4
					cycleSpeed: 4
					setCycle: End
					setStep: 3 5
					setMotion: MoveTo (yeti x:) 240 self
				)
			)
			(8
				(gGlobalSound3 number: 0 stop:)
				(gEgo
					normal: 1
					view: 10
					x: (+ (gEgo x:) 11)
					loop: 0
					setCycle: Walk
					cycleSpeed: 0
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(9
				(SetScore 4)
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
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 76
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					illegalBits: 0
					ignoreActors: 1
				)
			)
			(1
				(gGlobalSound3 number: 115 loop: 1 vol: 127 play: self)
				(gEgo yStep: 8 setMotion: MoveTo (- (gEgo x:) 20) 230)
			)
			(2
				(= seconds 3)
			)
			(3
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance path36 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $2002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (!= ((gInventory at: 2) owner:) 36) ; Pie
						(PrintDC 36 0) ; "A snowy path runs along the front of a crystal cavern."
					else
						(PrintDC 36 1) ; "A narrow ledge ends at a vertical cliff over which the yeti fell to his terrible death."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance entrance of RFeature
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
					(PrintDC 36 2) ; "Through the yawning entrance of the cave, Graham can see many beautiful crystals sparkling and flashing from within."
					(event claimed: 1)
				)
				(5 ; Inventory
					(if (not (HaveMouse))
						(switch global69
							(2 ; Pie
								(if (> (gEgo distanceTo: yeti) 100)
									(HandsOff)
									(gCurRoom setScript: throwPie)
								else
									(PrintDC 36 3 #dispose) ; "Too late!!"
								)
								(event claimed: 1)
							)
							(28 ; Wand
								(event claimed: 0)
							)
							(else
								(PrintDC 36 4) ; "That won't help Graham fight the powerful yeti."
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance thePie of Act
	(properties
		x -20
		view 558
		loop 1
		priority 14
		signal 10256
		xStep 4
	)
)

(instance yeti of Act
	(properties
		y 149
		x 240
		yStep 3
		view 542
		signal 16384
		xStep 5
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
					(PrintDC 36 5) ; "The yeti! Run!"
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 36 6) ; "Graham could never overpower the huge yeti!"
					(event claimed: 1)
				)
				(4 ; Talk
					(gEgo setMotion: 0)
					(PrintDC 36 7 #at 20 160) ; "Excuse me! Can we talk...?"
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(2 ; Pie
							(if (> (gEgo distanceTo: yeti) 100)
								(HandsOff)
								(gCurRoom setScript: throwPie)
							else
								(PrintDC 36 3 #dispose) ; "Too late!!"
							)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 36 4) ; "That won't help Graham fight the powerful yeti."
							(event claimed: 1)
						)
					)
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

