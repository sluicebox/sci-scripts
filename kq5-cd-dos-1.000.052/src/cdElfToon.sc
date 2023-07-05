;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 681)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RandCycle)
(use PolyPath)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	cdElfToon 0
)

(local
	local0
	local1
)

(instance cdElfToon of KQ5Room
	(properties
		picture 83
	)

	(method (init)
		(super init:)
		(Load rsPIC 84)
		(Load rsSCRIPT 941)
		(Load rsSCRIPT 929)
		(Load rsSCRIPT 969)
		(Load rsSOUND 90)
		(Load rsVIEW 796)
		(Load rsVIEW 797)
		(Load rsVIEW 2)
		(Load rsVIEW 1032)
		(Load rsVIEW 780)
		(Load rsSYNC 5099)
		(= local1 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 1)
		(self setScript: enterRoom)
	)

	(method (dispose)
		(gGame egoMoveSpeed: local1)
		(DisposeScript 941)
		(DisposeScript 969)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elf hide:)
				(workers hide:)
				(worker2 hide:)
				(gEgo hide:)
				((gEgo head:) hide:)
				(DrawPic 84)
				(theMouth init:)
				(arms init:)
				(theEyes init:)
				(= seconds 3)
			)
			(1
				(theMouth setCycle: MouthSync 5099)
				(Say 5099 self)
			)
			(2
				(cls)
				(theMouth setCycle: 0)
				(= seconds 2)
			)
			(3
				(arms cycleSpeed: 1 setCycle: End)
				(= local0 1)
				(= seconds 2)
			)
			(4
				(gCurRoom setScript: exitRoom)
				(theMouth hide:)
				(arms dispose:)
				(theEyes dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theMouth of Prop
	(properties
		x 105
		y 72
		view 1032
		cel 4
		priority 10
		signal 2064
		cycleSpeed 2
	)
)

(instance theEyes of Prop
	(properties
		x 119
		y 60
		view 780
		loop 1
		priority 10
		signal 2064
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (Random 1 40) 1) (not cycler) (not local0))
			(self setCycle: End)
		)
	)
)

(instance arms of Prop
	(properties
		x 128
		y 93
		view 780
		loop 2
		priority 10
		signal 2064
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 83)
				(if (!= (gGlobalSound number:) 90)
					(gGlobalSound number: 90 loop: -1 vol: 127 playBed:)
				)
				(workers setLoop: 2 init:)
				(worker2 setLoop: 3 cycleSpeed: 2 setCycle: Fwd init:)
				(elf setLoop: 1 posn: 48 87 init:)
				(gEgo
					init:
					view: 796
					setLoop: 8
					cel: 2
					ignoreActors: 1
					illegalBits: 0
					setStep: 2 1
					posn: 280 24
					normal: 0
				)
				((gEgo head:) hide:)
				(= cycles 15)
			)
			(1
				(gEgo
					setCycle: Rev
					setMotion: MoveTo 271 51 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(2
				(gEgo
					setMotion: MoveTo 253 107 self
					cycleSpeed: 1
					moveSpeed: 1
				)
			)
			(3
				(gEgo
					setLoop: 9
					posn: 251 124
					cel: 0
					setCycle: End self
					cycleSpeed: 2
				)
			)
			(4
				(gEgo
					view: 2
					setStep: 2 1
					setCycle: KQ5SyncWalk
					normal: 1
					setLoop: -1
					setMotion: MoveTo (- (gEgo x:) 4) (- (gEgo y:) 0) self
				)
				((gEgo head:) show:)
			)
			(5
				(Say 5096 self)
				(elf setScript: elfComesDown)
			)
			(6
				(gEgo setMotion: MoveTo 232 133 self)
			)
			(7
				(cls)
				(gEgo setMotion: MoveTo 65 128 self)
			)
			(8
				(elfComesDown cue:)
				(self dispose:)
			)
		)
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
				(gEgo
					normal: 0
					view: 796
					setLoop: 0
					setCel: 0
					setCycle: CT 4 1 self
					cycleSpeed: 3
				)
			)
			(8
				(gCurRoom setScript: cartoon)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 83)
				(workers show:)
				(worker2 show:)
				(elf show:)
				((gEgo head:) hide:)
				(gEgo view: 796 normal: 0 setLoop: 0 show:)
				(gEgo cel: 4)
				(= cycles 15)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo view: 2 normal: 1 setLoop: 1)
				((gEgo head:) show:)
				(elf loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(elf view: 797 loop: 3 cel: 0 cycleSpeed: 8 setCycle: RandCycle)
				(Say 5097 self)
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
				(Say 5098 self)
			)
			(5
				(cls)
				(gEgo
					normal: 1
					view: 2
					setLoop: -1
					setCycle: KQ5SyncWalk
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
				(gEgo loop: 13 setCycle: End self)
			)
			(9
				(elf cycleSpeed: 5 setCycle: End self)
				(gEgo cycleSpeed: 3 setCycle: Fwd)
			)
			(10
				(gEgo
					loop: 12
					cel: 2
					cycleSpeed: (gGame egoMoveSpeed:)
					setCycle: Beg self
				)
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
				(gGlobalSound fade:)
				(gCurRoom newRoom: 215)
			)
		)
	)
)

(instance workers of Prop
	(properties
		x 97
		y 82
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
		x 125
		y 81
		view 796
	)
)

(instance elf of Actor
	(properties
		x 40
		y 93
		view 796
		priority 9
		signal 16400
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

