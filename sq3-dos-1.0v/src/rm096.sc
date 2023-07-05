;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm096 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 (Random 1 2))
	(elmo setCel: temp0)
	(mouth setLoop: temp0 setCycle: Fwd)
	(tail init:)
)

(procedure (localproc_1)
	(if local0
		(tail dispose:)
		(RedrawCast)
		(cls)
		(= local0 0)
	)
	(elmo setCel: 0)
	(mouth setCel: 0 setLoop: 3 stopUpd:)
)

(instance rm096 of Rm
	(properties
		picture 96
	)

	(method (init &tmp [temp0 50])
		(Load rsVIEW 130)
		(super init:)
		(elmo init:)
		(mouth init:)
		(= global193 1)
		(Display 96 0 dsCOORD 116 136 dsFONT 600 dsWIDTH 180 dsCOLOR 10) ; "-- INSTRUCTIONS --"
		(Display 96 1 dsCOORD 112 144 dsFONT 600 dsWIDTH 180 dsCOLOR 14) ; "use arrow keys to"
		(Display 96 2 dsCOORD 112 151 dsFONT 600 dsWIDTH 180 dsCOLOR 14) ; "control your robot"
		(Display 96 3 dsCOORD 105 158 dsFONT 600 dsWIDTH 180 dsCOLOR 14) ; "use the J key to punch"
		(Display 96 4 dsCOORD 106 165 dsFONT 600 dsWIDTH 180 dsCOLOR 14) ; "use the M key to block"
		(Display 96 5 dsCOORD 106 173 dsFONT 600 dsWIDTH 180 dsCOLOR 10) ; "Press Any Key To Start"
		(HandsOff)
		(= global159 1)
		(self setScript: ElmoTalk)
	)

	(method (doit &tmp [temp0 50])
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (event type:)
			(if local0
				(tail dispose:)
				(RedrawCast)
				(cls)
			)
			(= global193 0)
			(gCurRoom newRoom: 120)
		)
	)
)

(instance ElmoTalk of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(localproc_0)
				(= local0 (Print 96 6 #at -1 55 #width 200 #font 600 #dispose)) ; "Ok Wilco, the name of the game is Nukem Dukem Robots.  The only rule is that there are no rules!"
				(= seconds 10)
			)
			(2
				(localproc_1)
				(= seconds 4)
			)
			(3
				(localproc_0)
				(= local0 (Print 96 7 #at -1 55 #width 200 #font 600 #dispose)) ; "You have a limited power supply. A successful blow will absorb my robot's energy and vice versa. On the other hand, a wasted movement of any kind will rapidly deplete your robot's power. Sounds like fun, huh?"
				(= seconds 15)
			)
			(4
				(localproc_1)
				(= seconds 4)
			)
			(5
				(localproc_0)
				(= local0 (Print 96 8 #at -1 55 #width 200 #font 600 #dispose)) ; "Anyway, here's the deal. If you win (snicker), you have the honor of becoming Scum Soft's new full-time janitor.  Ha! Ha! but... if I win... you'll be DEAD!!"
				(= seconds 10)
			)
			(6
				(localproc_1)
				(= seconds 4)
			)
			(7
				(localproc_0)
				(= local0 (Print 96 9 #at -1 55 #width 200 #font 600 #dispose)) ; "Oh, by the way, your friends, The Two Guys from Andromeda have joined us, as you can see below. Be careful not to STEP on them. Heh, heh, heh."
				(= seconds 10)
			)
			(8
				(localproc_1)
				(= seconds 4)
			)
			(9
				(localproc_0)
				(= local0 (Print 96 10 #at -1 55 #width 200 #font 600 #dispose)) ; "LET THE GAME BEGIN!"
				(= seconds 10)
			)
			(10
				(localproc_1)
			)
			(11
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance elmo of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 0
			setCel: 0
			posn: 163 37
			setPri: 5
			ignoreActors: 1
		)
	)
)

(instance mouth of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 3
			setCel: 0
			posn: 163 33
			setPri: 6
			ignoreActors: 1
		)
	)
)

(instance tail of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 130
			setLoop: 4
			setCel: 0
			posn: 200 44
			setPri: 15
			ignoreActors: 1
		)
	)
)

