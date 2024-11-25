;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm212 0
)

(local
	local0
	local1
	local2
	[local3 24] = [0 0 319 0 319 112 213 117 193 121 164 117 145 118 121 113 77 116 57 120 17 109 0 112]
)

(procedure (localproc_0)
	(gEgo setMotion: 0 setCycle: 0)
	(= global322 (++ local1))
	(gCurRoom drawPic: 212)
	(gAddToPics dispose:)
	(switch (mod global314 4)
		(0
			(gAddToPics add: cliff1 doit:)
		)
		(1
			(gAddToPics add: cliff2 doit:)
		)
		(2
			(gAddToPics add: cliff3 doit:)
		)
		(else
			(gAddToPics add: cliff4 doit:)
		)
	)
	(gEgo posn: (Abs (- (gEgo x:) 310)) (gEgo y:))
	((gEgo head:)
		x: (gEgo x:)
		y: (gEgo y:)
		z: (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
	)
	(RedrawCast)
	(gEgo edgeHit: EDGE_NONE)
	(= local0 0)
)

(instance rm212 of KQ5Room
	(properties
		picture 212
	)

	(method (init)
		(super init:)
		(self setFeatures: cliffs room)
		(switch gPrevRoomNum
			(15
				(gEgo posn: (gEgo x:) 187)
				(= local1 global322)
			)
			(14
				(= global314 1)
				(= global315 1)
				(= local1 1)
			)
			(else
				(= local1 global322)
			)
		)
		(gEgo view: 0 setPri: -1 illegalBits: $8000 setStep: 3 2 init:)
		(poly1 points: @local3 size: 12)
		(self addObstacle: poly1)
		(gGlobalSound2 number: 3 loop: -1 play: 112)
		(gGlobalSound number: 2 loop: -1 play: 112)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (== local1 5) (not local2))
				(= local2 1)
				(PrintDC 212 0) ; "The hot sun and choking sands are taking their toll on Graham. He must drink...soon!"
			)
			((> local1 6)
				(self setScript: dying)
			)
			((= temp0 (gEgo edgeHit:))
				(switch temp0
					(3
						(++ global315)
						(gCurRoom newRoom: 15)
						(= global322 local1)
					)
					(2
						(cond
							((== (-- global314) 7)
								(gCurRoom newRoom: 213)
								(gGlobalSound2 fade:)
								(gGlobalSound fade:)
							)
							((== global314 0)
								(= global314 0)
								(= global315 1)
								(gCurRoom newRoom: 14)
							)
							(else
								(localproc_0)
								(gEgo setCycle: KQ5SyncWalk)
							)
						)
					)
					(4
						(if (== (++ global314) 7)
							(gGlobalSound2 fade:)
							(gGlobalSound fade:)
							(gCurRoom newRoom: 213)
						else
							(localproc_0)
							(gEgo setCycle: KQ5SyncWalk)
						)
					)
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
		(super dispose:)
	)
)

(instance dying of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gGlobalSound2 number: 785 loop: 1 play:)
				(User canControl: 0 canInput: 0)
				(gEgo setPri: 14 setMotion: PolyPath 163 160 self)
			)
			(2
				(PrintDC 212 1 #at 20 20 #dispose) ; "Too late! Graham collapses and dies of extreme thirst in the hot desert sun. If only he could have found an oasis!"
				(gEgo view: 358 cycleSpeed: 2 normal: 0 setCycle: End self)
				((gEgo head:) hide:)
			)
			(3
				(switch (gEgo loop:)
					(0
						(= temp0 25)
					)
					(else
						(= temp0 60)
					)
				)
				(buzzard2 init: setScript: dying2)
				(buzzard
					init:
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) temp0) (gEgo y:) self
				)
			)
			(4
				(buzzard setLoop: 4 cel: 4 setCycle: Beg self)
			)
			(5
				(gGlobalSound fade:)
				(gGlobalSound2 fade:)
				(buzzard setLoop: 0 cel: 0)
				(= seconds 3)
			)
			(6
				(cls)
				(= global330
					{DYING for a drink, Graham?}
				)
				(EgoDead 264 0 End 20)
			)
		)
	)
)

(instance dying2 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(switch (gEgo loop:)
					(0
						(= temp1 60)
					)
					(else
						(= temp1 25)
					)
				)
				(buzzard2
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) temp1) (gEgo y:) self
				)
			)
			(1
				(buzzard2 setLoop: 5 cel: 4 setCycle: Beg self)
			)
			(2
				(buzzard2 setLoop: 1 cel: 0)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsTop 115
		nsBottom 200
		nsRight 320
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
					(PrintDC 212 2) ; "Looking south, the desert seems to extend forever."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cliffs of RFeature
	(properties
		nsBottom 115
		nsRight 320
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
					(PrintDC 212 3) ; "Rocky cliffs rise high above Graham's head."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 212 4) ; "The cliff is too steep. Graham could never climb it!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance buzzard of Actor
	(properties
		x -17
		y 48
		view 360
		priority 15
		signal 16
		cycleSpeed 2
		illegalBits 0
	)
)

(instance buzzard2 of Actor
	(properties
		x 337
		y 74
		view 360
		priority 15
		signal 16
		cycleSpeed 2
		illegalBits 0
	)
)

(instance cliff1 of PicView
	(properties
		x 55
		y 113
		view 351
		priority 1
	)
)

(instance cliff2 of PicView
	(properties
		x 143
		y 115
		view 351
		cel 1
		priority 1
	)
)

(instance cliff3 of PicView
	(properties
		x 220
		y 106
		view 351
		loop 1
		priority 1
	)
)

(instance cliff4 of PicView
	(properties
		x 288
		y 105
		view 351
		loop 1
		cel 1
		priority 1
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

