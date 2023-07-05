;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro 0
)

(instance intro of Rm
	(properties
		picture 925
		style 10
	)

	(method (init &tmp temp0)
		(super init:)
		(gSong play: 800 setPri: 1 setLoop: -1)
		(= global107 0)
		(while ((= temp0 (Event new:)) type:)
			(temp0 type: evNULL)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(if (not (HaveMouse))
			(gGame setCursor: gTheCursor 1 319 199)
		)
		(self setScript: introScript)
		(gTheIconBar enable:)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(return)
		)
		(if (and (not (event claimed:)) (event type:))
			(event claimed: 1)
			(if
				(and
					(or (& (event type:) evMOUSEBUTTON) (& (event type:) evKEYBOARD))
					(> (event y:) 0)
				)
				(proc0_1)
				(gCurRoom newRoom: 975) ; chooseGame
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: palScript)
				(= ticks 1)
			)
			(1
				(executiveProducer init:)
				(creativeDirector init:)
				(producer init: stopUpd:)
				(gameDesigner init: stopUpd:)
				(artDesigner init: stopUpd:)
				(leadProgrammer init: stopUpd:)
				(composer init: stopUpd:)
				(= ticks 308)
			)
			(2
				(Graph grFILL_BOX 37 57 164 257 1 global370 1)
				(Graph grUPDATE_BOX 37 57 164 257 1)
				(= ticks 1)
			)
			(3
				(executiveProducer setMotion: MoveTo 160 114 self)
			)
			(4
				(= ticks 90)
			)
			(5
				(executiveProducer setMotion: MoveTo 160 10 self)
				(creativeDirector setMotion: MoveTo 160 114)
			)
			(6
				(executiveProducer stopUpd:)
				(creativeDirector setMotion: MoveTo 160 10 self)
				(producer setMotion: MoveTo 160 114)
			)
			(7
				(creativeDirector stopUpd:)
				(producer setMotion: MoveTo 160 10 self)
				(gameDesigner setMotion: MoveTo 160 114)
			)
			(8
				(producer stopUpd:)
				(gameDesigner setMotion: MoveTo 160 10 self)
				(artDesigner setMotion: MoveTo 160 114)
			)
			(9
				(gameDesigner stopUpd:)
				(artDesigner setMotion: MoveTo 160 10 self)
				(leadProgrammer setMotion: MoveTo 160 114)
			)
			(10
				(artDesigner stopUpd:)
				(leadProgrammer setMotion: MoveTo 160 10 self)
				(composer setMotion: MoveTo 160 114)
			)
			(11
				(leadProgrammer stopUpd:)
				(composer setMotion: MoveTo 160 10 self)
			)
			(12
				(= cycles 100)
				(gCurRoom newRoom: 975) ; chooseGame
			)
		)
	)
)

(instance palScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 75)
			)
			(1
				(Palette palANIMATE 80 84 1)
				(= ticks 75)
			)
			(2
				(-= state 2)
				(= ticks 1)
			)
		)
	)
)

(instance executiveProducer of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 0
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance creativeDirector of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 1
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance producer of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 3
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance gameDesigner of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 4
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance artDesigner of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 5
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance leadProgrammer of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 6
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

(instance composer of Actor
	(properties)

	(method (init)
		(self
			view: 950
			setLoop: 7
			posn: 160 190
			setPri: 1
			setStep: 1 1
			moveSpeed: 3
			ignoreActors:
		)
		(super init: &rest)
	)
)

