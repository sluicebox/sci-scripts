;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm033 0
)

(local
	local0
	[local1 46] = [0 42 95 42 100 60 115 67 101 76 53 79 73 92 125 92 114 96 80 100 58 101 65 103 117 109 116 117 77 122 52 122 60 132 99 148 120 155 101 161 120 167 57 189 0 189]
	[local47 54] = [0 0 319 0 319 146 245 132 187 133 151 146 118 152 100 146 68 133 155 117 168 105 118 107 83 103 84 101 113 98 133 94 144 89 73 90 60 81 61 80 95 80 133 68 118 67 102 59 98 45 104 39 0 39]
	[local101 14] = [234 157 243 158 248 164 223 173 200 164 205 147 225 147]
)

(instance rm033 of KQ5Room
	(properties
		picture 33
		horizon 67
		north 32
		east 34
	)

	(method (init)
		(super init:)
		(if (== global322 100)
			(gGlobalSound2 number: 106 loop: -1 playBed:)
			(Load rsVIEW 520)
			(Load rsSOUND 83)
			(self setScript: sledRun)
		else
			(switch gPrevRoomNum
				(north
					(gEgo view: 16 posn: 116 71 loop: 4 cel: 2 init:)
					((gEgo head:) hide:)
					(HandsOff)
					(self setScript: walkFromNorth)
				)
				(else
					(gEgo
						posn: 312 165
						init:
						normal: 1
						view: 12
						setLoop: -1
						setCel: -1
						setStep: 2 2
						moveSpeed: (gGame egoMoveSpeed:)
						cycleSpeed: 0
						setCycle: KQ5SyncWalk
					)
					(sled init:)
				)
			)
		)
		(poly1 points: @local1 size: 23)
		(poly2 points: @local47 size: 27)
		(poly3 points: @local101 size: 7)
		(self
			setFeatures: crevasse path33 path33a bridge mountains
			addObstacle: poly1 poly2 poly3
		)
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
				(gCurRoom newRoom: temp0)
			)
			((& (= temp1 (gEgo onControl: 0)) $1080)
				(gEgo
					priority: (- (gEgo priority:) 2)
					signal: (| (gEgo signal:) $0010)
					loop: 1
				)
				(self setScript: falling)
			)
			((& temp1 $2000)
				(gEgo
					priority: (gEgo priority:)
					signal: (| (gEgo signal:) $0010)
					loop: 1
				)
				(self setScript: falling)
			)
			((& temp1 $0020)
				(gEgo
					priority: 8
					signal: (| (gEgo signal:) $0010)
					loop: 0
				)
				(bridge priority: 15 signal: (| (bridge signal:) $0010))
				(self setScript: falling)
			)
			((& temp1 $0004)
				(bridge cycleSpeed: 1 setCycle: End)
				(gEgo
					priority: (- (gEgo priority:) 1)
					signal: (| (gEgo signal:) $0010)
				)
				(self setScript: falling)
			)
			((& temp1 $0300)
				(gEgo
					priority:
						(cond
							((< (gEgo y:) 68) 1)
							((< (gEgo y:) 88) 2)
							(else 4)
						)
					signal: (| (gEgo signal:) $0010)
					loop: 0
				)
				(self setScript: falling)
			)
			((& temp1 $0008)
				(gEgo view: 16)
				((gEgo head:) hide:)
			)
			((& temp1 $0010)
				(gEgo view: 14)
				((gEgo head:) show:)
			)
			((& temp1 $0040)
				(gEgo view: 12)
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
)

(instance sledRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					normal: 0
					ignoreHorizon: 1
					view: 520
					loop: 0
					cel: 2
					posn: 1 39
					init:
					moveSpeed: 0
					illegalBits: 0
					setMotion: MoveTo 73 40 self
				)
				((gEgo head:) hide:)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setMotion: MoveTo 95 49 self)
			)
			(2
				(gEgo setCel: 1 posn: 95 49 setMotion: MoveTo 106 61 self)
			)
			(3
				(gEgo setCel: 2 posn: 106 61 setMotion: MoveTo 130 71 self)
			)
			(4
				(gEgo setCel: 4 posn: 130 71 setMotion: MoveTo 112 77 self)
			)
			(5
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 112 77
					setMotion: MoveTo 54 80 self
				)
			)
			(6
				(gEgo setCel: 1 posn: 54 80 setMotion: MoveTo 82 88 self)
			)
			(7
				(gEgo posn: 82 88 setMotion: MoveTo 103 91 self)
			)
			(8
				(gEgo setCel: 2 posn: 103 91 setMotion: MoveTo 137 91 self)
			)
			(9
				(gEgo setCel: 3 posn: 137 91 setMotion: MoveTo 96 100 self)
			)
			(10
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 96 100
					setMotion: MoveTo 64 103 self
				)
			)
			(11
				(gEgo setCel: 1 setMotion: MoveTo 101 108 self)
			)
			(12
				(gEgo setCel: 2 setMotion: MoveTo 143 118 self)
			)
			(13
				(gEgo setCel: 3 setMotion: MoveTo 158 119 self)
			)
			(14
				(gGlobalSound2 number: 107 loop: 1 playBed:)
				(gEgo setLoop: 4 setCel: 0 setMotion: MoveTo 179 121 self)
			)
			(15
				(gEgo setStep: 4 4 setCel: 1 setMotion: MoveTo 196 143 self)
			)
			(16
				(gEgo setCel: 2 setMotion: MoveTo 219 175 self)
			)
			(17
				(gEgo setCel: 3 setMotion: MoveTo 221 175 self)
			)
			(18
				(gEgo setLoop: 5 setCel: 0 posn: 224 157 setCycle: End self)
				(sled init:)
				(gGlobalSound2 number: 790 loop: 1 play: 60 self)
				(gGlobalSound3 number: 108 loop: 1 play:)
			)
			(19
				(= seconds 4)
			)
			(20)
			(21
				(gEgo
					posn: 226 152
					setLoop: 9
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(22
				(proc0_28 165 33 0 67 30 30 25 5) ; "Drat! My sled is broken!"
				(= cycles 1)
			)
			(23
				(HandsOn)
				(gEgo
					normal: 1
					view: 12
					setLoop: -1
					setCel: -1
					x: (+ (gEgo x:) 3)
					setStep: 2 2
					moveSpeed: (gGame egoMoveSpeed:)
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					loop: 11
					cel: 4
					illegalBits: $8000
				)
				((gEgo head:) show:)
				(sled stopUpd:)
				(client setScript: 0)
				(= global322 0)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsObject (bridge cycler:))
					(= cycles 3)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view:
						(switch (gEgo view:)
							(16 82)
							(14 80)
							(else 78)
						)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
					illegalBits: 0
				)
				(gGlobalSound3 number: 83 priority: 15 loop: 1 play:)
			)
			(2
				(gEgo
					setLoop: (gEgo loop:)
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
				(EgoDead)
			)
		)
	)
)

(instance walkFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 3) self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance path33 of RFeature
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
					(PrintDC 33 1) ; "A snowy path zigzags its way across the top of a narrow ridge toward a deep crevasse."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path33a of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0800))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 33 2) ; "From here, the path widens and continues on to the east."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance crevasse of RFeature
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
					(PrintDC 33 3) ; "A deep crevasse splits the snowy mountain ridge in two. A thin strip of ice crosses it. It looks too wide to jump across."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 33 4) ; "Graham thinks about attempting to jump across the crevasse, but wisely chooses not to."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bridge of Prop
	(properties
		x 75
		y 145
		view 516
		priority 8
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
					(PrintDC 33 3) ; "A deep crevasse splits the snowy mountain ridge in two. A thin strip of ice crosses it. It looks too wide to jump across."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 33 4) ; "Graham thinks about attempting to jump across the crevasse, but wisely chooses not to."
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(29
							(PrintDC 33 5) ; "Perhaps with some momentum Graham could use this to cross the crevasse."
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 33 6) ; "It won't help Graham cross the crevasse."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance mountains of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 33 7) ; "In the distance, snowy mountains loom above a lovely river valley."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sled of Actor
	(properties
		x 226
		y 172
		view 520
		loop 7
		priority 10
		signal 16400
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
					(PrintDC 33 8) ; "Graham's sled lies in several broken pieces on the eastern side of the icy crevasse."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local0)
						(++ local0)
						(PrintDC 33 9) ; "The broken sled is now no good to anybody."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties)
)

(instance poly2 of Polygon
	(properties)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

