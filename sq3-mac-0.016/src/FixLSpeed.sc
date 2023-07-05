;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	FixLSpeed 0
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

(instance FixLSpeed of Script
	(properties)

	(method (init)
		(Load rsVIEW 212)
		(Load rsVIEW 65)
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
		(lp1 dispose: delete:)
		(lp2 dispose: delete:)
		(lp3 dispose: delete:)
		(lp4 dispose: delete:)
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
				(HandsOff)
				(= global193 1)
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 24 0 #at 10 25 #width 100 #font 600 #dispose)) ; "Man oh man! You really showed those bozos a thing or two! Now can we get something to eat?"
				(= seconds 10)
			)
			(1
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 4)
			)
			(2
				(Print 24 1) ; "You inform the Two Guys that light speed is no longer functional. They're not overly pleased by this piece of news."
				(= cycles 2)
			)
			(3
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 24 2 #at 10 25 #width 100 #font 600 #dispose)) ; "What!! Now I'll never get any food! Some rescuer you are!"
				(= seconds 8)
			)
			(4
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 2)
			)
			(5
				(Scott setCel: 3)
				(ScottHead dispose:)
				(= local0 (Print 24 3 #at 10 25 #width 100 #font 600 #dispose)) ; "Hey, what's this thing on the wall?"
				(= seconds 4)
			)
			(6
				(cls)
				(= local0 (Print 24 4 #at 10 25 #width 100 #font 600 #dispose)) ; "It sez...'light speed maintenance access panel.' Gee, maybe I can fix this bucket of plastobolts!"
				(= seconds 8)
			)
			(7
				(cls)
				(= local0 (Print 24 5 #at 10 25 #width 100 #font 600 #dispose)) ; "Yeah, this is it! This fan belt thing came off of the round thing it was on. Just a second."
				(= seconds 8)
			)
			(8
				(cls)
				(= local0 (Print 24 6 #at 10 25 #width 100 #font 600 #dispose)) ; "Ok, she's all fixed. Let's go grab a burger!"
				(= seconds 6)
			)
			(9
				(cls)
				(Scott setCel: 1)
				(ScottHead init:)
				(Print 24 7) ; "Too late you realize that you have no course laid in. The light engines kick in before you can override. You inform the Two Guys that light speed is now functional, but it's out of control. They're not overly pleased with this bit of news, either."
				(lp1 init:)
				(lp2 init:)
				(lp3 init:)
				(lp4 init:)
				(gLongSong number: 69 loop: -1 play:)
				(= seconds 2)
			)
			(10
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 24 8 #at 10 25 #width 100 #font 600 #dispose)) ; "Aaaaaaaahhhh!!!! We're gonna die!!!!!!"
				(= seconds 2)
			)
			(11
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 1)
			)
			(12
				(localproc_0 ScottHead 3)
				(= local2 1)
				(= local0 (Print 24 9 #at 10 25 #width 100 #font 600 #dispose)) ; "Oh noooooooo!!! Why did I get up this morning?!!!"
				(= seconds 2)
			)
			(13
				(localproc_1 ScottHead 3)
				(= local2 0)
				(= seconds 1)
			)
			(14
				(localproc_0 MarkHead 1)
				(= local1 1)
				(= local0 (Print 24 10 #at 10 25 #width 100 #font 600 #dispose)) ; "Mommyyyyyyyyy!!!!"
				(= seconds 2)
			)
			(15
				(localproc_1 MarkHead 1)
				(= local1 0)
				(= seconds 5)
			)
			(16
				(Print 24 11) ; "Careening blindly through space, your ship speeds toward a sizable black hole. Once within the gravitation of the black hole, there's no escape. You plunge into destiny."
				(lp1 setCycle: 0)
				(lp2 setCycle: 0)
				(lp3 setCycle: 0)
				(lp4 setCycle: 0)
				(= global258 1)
				(gLongSong fade:)
				(gCurRoom newRoom: 99)
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

(instance lp1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 0
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 2
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 1
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

(instance lp4 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setLoop: 3
			ignoreActors: 1
			posn: 160 83
			setPri: 6
			setCycle: Fwd
		)
	)
)

