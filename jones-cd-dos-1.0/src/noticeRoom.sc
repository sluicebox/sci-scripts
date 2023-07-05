;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 764)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	noticeRoom 0
)

(local
	local0
	local1
	local2 = 160
	local3 = 100
)

(instance noticeRoom of Rm
	(properties
		style 1
	)

	(method (init)
		(super init: &rest)
		(DoAudio audRATE 11025)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 0
			setLoop: 13
			illegalBits: 0
			posn: 5 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= local1 0)
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (u< local0 (GetTime))
			(cond
				((< local1 local3)
					(= global567 1)
					(= global534 3)
				)
				((< local1 local2)
					(= global567 2)
					(= global534 1)
				)
				(else
					(= global567 3)
				)
			)
			(gCurRoom newRoom: 2) ; introRoom
		)
	)
)

(instance fred of Act
	(properties)
)

