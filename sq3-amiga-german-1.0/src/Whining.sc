;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use Actor)
(use System)

(public
	Whining 0
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

(instance Whining of Script
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

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(localproc_0 ScottHead 4)
				(= local2 1)
				(= local0 (Print 23 0 #at 10 25 #width 100 #font 600 #dispose)) ; "So, how do you like the game so far? Was it worth $59.95?"
				(= seconds 10)
			)
			(2
				(localproc_1 ScottHead 3)
				(= local2 0)
				(= seconds 4)
			)
			(3
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 23 1 #at 10 25 #width 100 #font 600 #dispose)) ; "Hey, we're hungry. We haven't eaten anything but jello for the last few weeks."
				(= seconds 10)
			)
			(4
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(5
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 23 2 #at 10 25 #width 100 #font 600 #dispose)) ; "I hafta go to the bathroom."
				(= seconds 10)
			)
			(6
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(7
				(localproc_0 ScottHead 3)
				(= local2 1)
				(= local0 (Print 23 3 #at 10 25 #width 100 #font 600 #dispose)) ; "Can't you make this crate go any faster?"
				(= seconds 10)
			)
			(8
				(localproc_1 ScottHead 3)
				(= local2 0)
				(= seconds 4)
			)
			(9
				(localproc_0 MarkHead 2)
				(= local1 1)
				(= local0 (Print 23 4 #at 10 25 #width 100 #font 600 #dispose)) ; "Just between you and me, I think ol' Wilco's been in space too long."
				(= seconds 10)
			)
			(10
				(localproc_1 MarkHead 1)
				(= local1 0)
				(self changeState: 0)
			)
		)
	)
)

(instance Mark of PicView
	(properties
		x 34
		y 109
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

