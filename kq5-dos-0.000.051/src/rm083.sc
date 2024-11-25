;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm083 0
)

(local
	[local0 38] = [306 118 255 131 255 147 268 147 267 136 313 125 312 144 271 144 271 153 319 153 319 5 181 5 123 132 229 129 240 123 249 123 274 46 255 123 299 112]
	[local38 16] = [319 168 62 168 18 128 84 126 39 0 0 0 0 189 319 189]
)

(instance rm083 of Rm
	(properties
		picture 83
	)

	(method (init)
		(super init:)
		(Load rsVIEW 796)
		(HandsOff)
		(self
			setFeatures: ladder hole shoeWorkArea chasm otherWorkArea room
			addObstacle: poly1 poly2
		)
		(if (or (== ((gInventory at: 33) owner:) 83) (== gPrevRoomNum 84)) ; Elf_Shoes
			(if (!= (gGlobalSound number:) 90)
				(gGlobalSound number: 90 loop: -1 vol: 127 playBed:)
			)
			(workers setLoop: 2 init:)
			(worker2 setLoop: 3 cycleSpeed: 2 setCycle: Fwd init:)
			(elf setLoop: 1 posn: 48 87 init:)
		else
			(gGlobalSound number: 149 loop: -1 vol: 127 play:)
		)
		(switch gPrevRoomNum
			(82
				(gEgo
					view: 796
					setLoop: 8
					cel: 2
					ignoreActors: 1
					illegalBits: 0
					setStep: 1 2
					posn: 280 24
					normal: 0
					init:
				)
				((gEgo head:) hide:)
				(self setScript: enterRoom)
			)
			(84
				(gEgo view: 2 setLoop: -1 posn: 65 128 normal: 1 init:)
				((gEgo head:) show:)
				(elf posn: 44 130 setLoop: 7 cel: 0)
				(HandsOff)
				(self setScript: exitRoom)
			)
			(else
				(gEgo
					init:
					view: 796
					setLoop: 15
					setStep: 1 2
					setCel: 5
					normal: 0
					x: 278
					y: 147
				)
				((gEgo head:) hide:)
				(HandsOff)
				(self setScript: enterFromHole)
			)
		)
		(poly1 points: @local0 size: 19)
		(poly2 points: @local38 size: 8)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 1) $2000)
				(HandsOff)
				(self setScript: dying)
			)
			((& (gEgo onControl: 1) $4000)
				(HandsOff)
				(self setScript: crawlThroughHole)
			)
			((& (gEgo onControl: 1) $1000)
				(HandsOff)
				(self setScript: climbUpLadder)
			)
		)
	)

	(method (dispose)
		(DisposeScript 751)
		(super dispose:)
	)
)

(instance elfComesDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elf cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 30)
			)
			(1
				(elf
					setLoop: 4
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 40 93 self
				)
			)
			(2
				(elf cel: 0 posn: 40 100 setLoop: 5 setCycle: End self)
			)
			(3
				(elf posn: 49 127 setLoop: 6 cel: 0 setCycle: End self)
			)
			(4
				(elf cel: 0 setLoop: 7)
			)
			(5
				(gEgo get: 33) ; Elf_Shoes
				(SetScore 2)
				(elf setCycle: End self)
			)
			(6
				(= cycles 10)
			)
			(7
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 796 setLoop: 0 setCycle: End self)
			)
			(8
				(gCurRoom newRoom: 84)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo view: 796 normal: 0 setLoop: 0)
				(gEgo cel: (- (NumCels gEgo) 1))
				(= cycles 15)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				((gEgo head:) show:)
				(gEgo view: 2 normal: 1 setLoop: 1)
				(elf loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(elf view: 797 loop: 3 cel: 0 cycleSpeed: 8 setCycle: RandCycle)
				(PrintDC 83 0 #at 112 8 #dispose) ; "Follow that passage. That's the way out of the Dark Forest."
				(= seconds 6)
			)
			(4
				(cls)
				(elf loop: 5 cel: 0 setCycle: Beg)
				(gEgo
					normal: 0
					view: 797
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: RandCycle
				)
				((gEgo head:) hide:)
				(talkingHead
					init:
					x: (gEgo x:)
					y: (- (gEgo y:) 26)
					cycleSpeed: 8
					setCycle: RandCycle
				)
				(PrintDC 83 1 #at 113 96 #dispose) ; "Thank you very much for all your help. And I'm sure I will be able to find a use for these fine shoes."
				(= seconds 10)
			)
			(5
				(cls)
				(gEgo
					normal: 1
					view: 2
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 259 147 self
				)
				(talkingHead dispose:)
				((gEgo head:) show:)
			)
			(6
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 796
					loop: 11
					cel: 1
					setCycle: CT 4 1 self
				)
			)
			(7
				(gEgo loop: 12 cel: 0 setCycle: End self)
			)
			(8
				(gEgo loop: 13 cycleSpeed: 2 setCycle: End self)
			)
			(9
				(elf cycleSpeed: 5 setCycle: End self)
				(gEgo setCycle: Fwd)
			)
			(10
				(gEgo loop: 12 cel: 2 cycleSpeed: -1 setCycle: Beg self)
			)
			(11
				(elf setCycle: Beg self)
				(gEgo loop: 11 cel: 4 setCycle: CT 1 -1 self)
			)
			(12)
			(13
				(crawlThroughHole start: 1)
				(self setScript: crawlThroughHole)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gEgo setMotion: MoveTo 271 51 self)
			)
			(2
				(gEgo setMotion: MoveTo 253 107 self)
			)
			(3
				(gEgo setLoop: 9 posn: 251 124 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 2
					setStep: 2 2
					setCycle: Walk
					offset: 1
					normal: 1
					setLoop: -1
					setMotion: MoveTo (- (gEgo x:) 4) (- (gEgo y:) 0) self
				)
				((gEgo head:) show:)
			)
			(5
				(if (!= ((gInventory at: 33) owner:) 83) ; Elf_Shoes
					(HandsOn)
					(gEgo
						illegalBits: $8000
						setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
					)
				else
					(PrintDC 83 2 #at 8 157 #dispose) ; "Over here! I've got something for you."
					(elf setScript: elfComesDown)
					(= seconds 5)
				)
			)
			(6
				(if (!= ((gInventory at: 33) owner:) 83) ; Elf_Shoes
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 232 133 self)
				)
			)
			(7
				(cls)
				(gEgo setMotion: MoveTo 65 128 self)
			)
			(8
				(elfComesDown cue:)
			)
		)
	)
)

(instance dying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 797
					cycleSpeed: 2
					normal: 0
					cel: 0
					setLoop: 0
					setMotion: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
				(gGlobalSound3 number: 83 loop: 1 priority: 15 vol: 127 play:)
			)
			(1
				(gEgo dispose:)
				(= seconds 3)
			)
			(2
				(= global330 {Gotta watch those drop-offs, Graham!})
				(EgoDead 248)
			)
		)
	)
)

(instance crawlThroughHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCel: -1 setMotion: PolyPath 259 147 self)
			)
			(1
				(cls)
				(gEgo
					normal: 0
					view: 796
					setLoop: 14
					cel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
				((gEgo head:) hide:)
			)
			(2
				(gEgo x: (+ (gEgo x:) 3) setCel: 5)
				(= cycles 4)
			)
			(3
				(gEgo x: (+ (gEgo x:) 3) setCel: 4)
				(= cycles 3)
			)
			(4
				(gEgo x: (+ (gEgo x:) 3) setCel: 5)
				(= cycles 4)
			)
			(5
				(gEgo cycleSpeed: 0)
				(gGlobalSound fade:)
				(gCurRoom newRoom: 215)
			)
		)
	)
)

(instance climbUpLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 251 124 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					view: 796
					posn: 253 107
					setLoop: 8
					cel: 1
					setCycle: Fwd
					cycleSpeed: 2
					moveSpeed: 2
					setStep: 1 2
					setMotion: MoveTo 271 51 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 278 28 self)
			)
			(3
				(gEgo setMotion: MoveTo 288 25 self)
			)
			(4
				(gEgo moveSpeed: global289 cycleSpeed: 0)
				(gGlobalSound fade:)
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance enterFromHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCel: 4 x: (- (gEgo x:) 3))
				(= cycles 2)
			)
			(1
				(gEgo setCel: 5 x: (- (gEgo x:) 3))
				(= cycles 2)
			)
			(2
				(gEgo setCel: 4 x: (- (gEgo x:) 3))
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 2 x: (- (gEgo x:) 8))
				(NormalEgo 1 2)
				((gEgo head:) show:)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance workers of Prop
	(properties
		y 82
		x 97
		view 796
		cycleSpeed 1
	)

	(method (doit)
		(super doit:)
		(if (== (gGlobalSound prevSignal:) 10)
			(gGlobalSound prevSignal: 0)
			(self cel: 0 setCycle: End)
		)
	)
)

(instance worker2 of Prop
	(properties
		y 81
		x 125
		view 796
	)
)

(instance elf of Act
	(properties
		y 93
		x 40
		view 796
		priority 9
		signal 16400
	)
)

(instance ladder of RFeature
	(properties
		nsTop 40
		nsLeft 244
		nsBottom 118
		nsRight 279
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
					(PrintDC 83 3) ; "A long wooden ladder reaches up toward the entrance of an underground tunnel."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: climbUpLadder)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hole of RFeature
	(properties
		nsTop 123
		nsLeft 267
		nsBottom 149
		nsRight 276
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
					(PrintDC 83 4) ; "A lower hole leads into a second underground tunnel."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: crawlThroughHole)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shoeWorkArea of RFeature
	(properties
		nsTop 55
		nsLeft 14
		nsBottom 80
		nsRight 72
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
					(PrintDC 83 5) ; "The little shoemaker elf has left and is nowhere in sight."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 83 6) ; "The elf has left and taken everything with him. There's nothing here of interest."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance chasm of RFeature
	(properties
		nsTop 117
		nsLeft 69
		nsBottom 122
		nsRight 155
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
					(PrintDC 83 7) ; "Disappointingly, a deep chasm cuts through the underground cavern cutting off further exploration."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance otherWorkArea of RFeature
	(properties
		nsTop 59
		nsLeft 91
		nsBottom 81
		nsRight 156
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
					(PrintDC 83 8) ; "Graham can see no sign of the little elves previously working in the cavern's far reaches."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 83 9) ; "The elves have left and taken everything with them."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance room of RFeature
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
					(PrintDC 83 10) ; "The huge underground cavern seems to be a work area for a community of elves who have abandoned it."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance talkingHead of Prop
	(properties
		view 797
		loop 2
		priority 15
		signal 16
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

