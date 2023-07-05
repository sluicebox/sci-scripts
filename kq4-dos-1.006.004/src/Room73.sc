;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room73 0
)

(local
	local0
)

(procedure (localproc_0 param1)
	(if param1
		((= local0 (View new:))
			view: 800
			loop: 1
			posn: 108 132
			init:
			setPri: 15
			stopUpd:
		)
	else
		(local0 dispose:)
		(= local0 0)
	)
)

(instance Room73 of Rm
	(properties
		picture 73
		style 16
	)

	(method (init)
		(Load rsVIEW 800)
		(Load rsVIEW 904)
		(Load rsVIEW 950)
		(super init:)
		(self setRegions: 605) ; regTroll
		(= gIndoors 1)
		(= south 76)
		(gEgo view: 904 xStep: 4 yStep: 1)
		(if (!= gPrevRoomNum 77)
			(gEgo posn: 138 179 init: priority: (CoordPri (gEgo y:)))
			(Notify 605 1)
		else
			(gEgo view: 950 posn: 290 163 init:)
			(if (not (proc0_20))
				(localproc_0 1)
			)
			(= gTrollChasing 0)
			(gEgo setScript: crawl)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl:) $0002)
				(< (gEgo heading:) 180)
				(!= (gEgo script:) crawl)
			)
			(gEgo setScript: crawl)
		)
		(cond
			((and local0 (proc0_20))
				(localproc_0 0)
			)
			((and (not local0) (not (proc0_20)))
				(localproc_0 1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 77)
			((ScriptID 605) keep: 0) ; regTroll
			(= global189 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'crawl,exit/cave') (Said 'crawl[/!*]'))
						(if (not (& (gEgo onControl:) $0002))
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'look,find/exit,exit')
						(Print 73 0) ; "After this dark cave, the outside world looks good."
					)
					((Said 'look<out')
						(Print 73 1) ; "Outside the cave, you see a large swamp."
					)
					((or (Said 'look/sky') (Said 'look<up[/!*]'))
						(if gNight
							(Print 73 2) ; "Outside, the night sky is lit by a full moon."
						else
							(Print 73 3) ; "Outside, the sky is very blue."
						)
					)
				)
			)
		)
	)
)

(instance crawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (> (gEgo heading:) 180)
					(self changeState: 10)
				else
					(self changeState: 20)
				)
			)
			(10
				(gEgo
					view: 950
					setLoop: 3
					xStep: 2
					setCycle: Walk
					setMotion: MoveTo 255 164 self
				)
			)
			(11
				(gEgo cel: 5 setLoop: 1 cycleSpeed: 1 setCycle: Beg self)
			)
			(12
				(gEgo
					view: 904
					setLoop: -1
					xStep: 4
					cycleSpeed: 0
					setCycle: Walk
					illegalBits: -32768
				)
				(HandsOn)
				(client setScript: 0)
				(if (proc0_20)
					(Notify 605 3)
				)
			)
			(20
				(if (proc0_20)
					(Notify 605 2)
				)
				(gEgo
					view: 950
					setLoop: 0
					cel: 255
					xStep: 2
					setCycle: End self
				)
			)
			(21
				(gEgo
					illegalBits: 0
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) 164 self
				)
			)
			(22
				(gEgo setMotion: MoveTo 296 164 self)
			)
			(23
				(gEgo illegalBits: -32768)
				(= global205 1)
				(= global204 0)
				(gCurRoom newRoom: 77)
			)
		)
	)
)

