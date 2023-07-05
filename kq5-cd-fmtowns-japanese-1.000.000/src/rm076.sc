;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use n762)
(use KQ5Room)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm076 0
)

(local
	[local0 8] = [0 9110 0 9111 1 9100 0 0]
	[local8 9] = [1029 136 63 4 7 26 22 17 31]
	[local17 9] = [1003 157 73 4 11 25 23 31 31]
)

(instance rm076 of KQ5Room
	(properties
		picture 76
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 0 stop:)
		(User canInput: 0 controls: 0)
		(Load rsVIEW 771)
		(crispin init:)
		(gEgo view: 0 setLoop: -1 posn: 173 176 normal: 1 setStep: 3 2 init:)
		((gEgo head:) show:)
		(self setScript: enterRoom)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 173 146 self)
			)
			(1
				(proc0_7 gEgo crispin 5)
				(= cycles 15)
				((gEgo head:) cel: 5)
			)
			(2
				(proc762_1 @local8 9109)
				(crispin cel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(crispin cel: 0 setLoop: 8 setCycle: End self)
			)
			(4
				(proc762_0 @local8 @local17 @local0 self)
			)
			(5
				(gEgo
					setScript: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 60) self
				)
			)
			(6
				(cls)
				(User canInput: 1 controls: 1)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance crispin of Actor
	(properties
		x 141
		y 126
		view 771
		cycleSpeed 2
	)
)

