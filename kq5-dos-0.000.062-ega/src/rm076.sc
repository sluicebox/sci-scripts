;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm076 0
)

(instance rm076 of Rm
	(properties
		picture 76
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 0 stop:)
		(User canInput: 0 controls: 0)
		(Load rsVIEW 771)
		(crispin init:)
		(gEgo
			view: 0
			setLoop: -1
			posn: 173 176
			normal: 1
			offset: 2
			setStep: 3 2
			init:
		)
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
				(Say 547 76 0 67 10 10 25 8) ; "Don't be wasting your time coming in here, young man! I've done all I can for you. Now it's up to you."
				(crispin cel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(crispin cel: 0 setLoop: 8 setCycle: End self)
			)
			(4
				(Say 547 76 1 67 10 10 25 8) ; "Well, anyway...I'm not going to be here for a little while. There's an emergency I have to attend to in a neighboring land."
				(RedrawCast)
				(Say 547 76 2 67 10 10 25 8) ; "I'll try to keep an eye out for you... but... this is something you and Cedric are going to have to do yourselves. I wish you the best, King Graham."
				(RedrawCast)
				(Say 160 76 3 67 90 10 25 8) ; "I appreciate all you've done, Crispin. I'll be on my way now."
				(gEgo
					setScript: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 60) self
				)
			)
			(5
				(cls)
				(User canInput: 1 controls: 1)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance crispin of Act
	(properties
		y 126
		x 141
		view 771
		cycleSpeed 2
	)
)

