;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use Actor)
(use System)

(public
	TwoGuysFirst 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 param2)
	(param1 setLoop: param2)
)

(procedure (localproc_1 param1 param2)
	(cls)
	(= local0 0)
	(param1 setCel: 0 setLoop: param2)
)

(instance TwoGuysFirst of Script
	(properties)

	(method (init)
		(Load rsVIEW 212)
		(gAddToPics add: Mark)
		(gAddToPics doit:)
		(Scott init:)
		(MarkHead init:)
		(ScottHead init:)
		(super init: &rest)
	)

	(method (dispose)
		(Scott dispose: delete:)
		(MarkHead dispose: delete:)
		(ScottHead dispose: delete:)
	)

	(method (doit)
		(if local1
			(MarkHead setCel: (Random 0 4))
		)
		(if local2
			(ScottHead setCel: (Random 0 5))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 22 0 #at 10 25 #width 100 #font 600 #dispose)) ; "Gosh Rog, we really appreciate you saving us and all."
				(= seconds 12)
			)
			(2
				(= local1 0)
				(localproc_1 MarkHead 1)
				(= seconds 4)
			)
			(3
				(localproc_0 ScottHead 3)
				(= local2 1)
				(= local0 (Print 22 1 #at 10 25 #width 100 #font 600 #dispose)) ; "Yeah, we were really scared. We didn't know what Pug was gonna do to us."
				(= seconds 12)
			)
			(4
				(= local2 0)
				(localproc_1 ScottHead 3)
				(= seconds 6)
			)
			(5
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 22 2 #at 10 25 #width 100 #font 600 #dispose)) ; "Hey, uh, don't you think we better get outta here? Pug's really sore and he probably sent some ships after us."
				(= seconds 12)
			)
			(6
				(= local1 0)
				(localproc_1 MarkHead 1)
				(gAddToPics add: Scott)
				(gAddToPics add: ScottHead)
				(gAddToPics add: MarkHead)
				(gAddToPics doit:)
				(if (> global175 15)
					(= global175 15)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance Mark of PV
	(properties
		y 109
		x 34
		view 212
		priority 15
		signal 16384
	)
)

(instance Scott of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 0
			setCel: 1
			posn: 70 101
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance MarkHead of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 1
			setCel: 0
			posn: 36 109
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

(instance ScottHead of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 212
			setLoop: 3
			setCel: 0
			posn: 72 102
			setPri: 14
			ignoreActors: 1
			setCycle: 0
		)
	)
)

