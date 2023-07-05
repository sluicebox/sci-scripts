;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 692)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room692 0
)

(local
	local0
	local1
	local2
	local3
)

(instance weddingMarch of Sound
	(properties
		number 69
		loop 2
	)
)

(instance escort of Prop
	(properties)

	(method (cue)
		(self addToPic:)
	)
)

(instance Room692 of Rm
	(properties
		picture 92
		style 8
	)

	(method (init)
		(super init:)
		((View new:)
			view: 806
			loop: 0
			cel: 0
			posn: 118 104
			setPri: 6
			init:
			addToPic:
		)
		((View new:)
			view: 806
			loop: 0
			cel: 0
			posn: 111 111
			setPri: 7
			init:
			addToPic:
		)
		((View new:)
			view: 806
			loop: 0
			cel: 0
			posn: 103 119
			setPri: 8
			init:
			addToPic:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 5
			posn: 118 48
			setPri: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 3
			posn: 111 55
			setPri: 2
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 0
			posn: 103 63
			setPri: 3
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((View new:)
			view: 806
			loop: 0
			cel: 1
			posn: 205 104
			setPri: 6
			init:
			addToPic:
		)
		((View new:)
			view: 806
			loop: 0
			cel: 1
			posn: 212 110
			setPri: 7
			init:
			addToPic:
		)
		((View new:)
			view: 806
			loop: 0
			cel: 1
			posn: 221 119
			setPri: 8
			init:
			addToPic:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 3
			posn: 205 48
			setPri: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 2
			posn: 212 54
			setPri: 2
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((Prop new:)
			view: 806
			loop: 1
			cel: 0
			posn: 221 63
			setPri: 3
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 0
			posn: 59 141
			setPri: 10
			init:
			addToPic:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 0
			posn: 56 149
			setPri: 11
			init:
			addToPic:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 0
			posn: 49 158
			setPri: 12
			init:
			addToPic:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 1
			posn: 267 143
			setPri: 10
			init:
			addToPic:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 1
			posn: 271 151
			setPri: 11
			init:
			addToPic:
		)
		((View new:)
			view: 804
			loop: 4
			cel: 1
			posn: 276 159
			setPri: 12
			init:
			addToPic:
		)
		(User canControl: 0 canInput: 0)
		(= local0 (Prop new:))
		(local0 view: 807 loop: 3 cel: 0 posn: 162 93 setPri: 5 init:)
		(gEgo
			view: 808
			loop: 0
			cel: 0
			illegalBits: 0
			ignoreActors:
			posn: 10 131
			setScript: egoActions
			init:
		)
		(= local1 (Act new:))
		(local1
			view: 810
			loop: 0
			cel: 0
			posn: 175 131
			ignoreActors:
			init:
			stopUpd:
		)
		(= local3 (Prop new:))
		(local3
			view: 804
			loop: 0
			cel: 0
			ignoreActors:
			posn: 184 111
			init:
			stopUpd:
		)
		(weddingMarch play:)
	)
)

(instance egoActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo
					xStep: 2
					setMotion: MoveTo 105 132 self
					moveSpeed: 1
					cycleSpeed: 1
				)
			)
			(1
				(gEgo setLoop: 2 setMotion: MoveTo 152 132 self)
				(escort
					view: 808
					setLoop: 1
					ignoreActors:
					posn: 117 128
					setCycle: End escort
					init:
				)
			)
			(2
				(gEgo setLoop: 3 cel: 0 cycleSpeed: 0 setCycle: End self)
				(local1 setCycle: End)
			)
			(3
				(local0 cel: 0 setCycle: End self)
			)
			(4
				(local0 cel: 0 setCycle: End self)
			)
			(5
				(local3 cycleSpeed: 2 setCycle: End self)
			)
			(6
				(local3 stopUpd:)
				(= global120 (Print 692 0 #at -1 20 #dispose)) ; "...I now pronounce you man and wife! Edgar, you may kiss the bride."
				(= seconds 12)
			)
			(7
				(cls)
				(local1 hide:)
				(gEgo view: 810 setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(= local2 (Prop new:))
				(local2
					view: 810
					setLoop: 2
					ignoreActors:
					cel: 0
					setPri: 15
					posn: 175 85
					setCycle: End self
					init:
				)
			)
			(9
				(local2 dispose:)
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(10
				(= seconds 3)
			)
			(11
				(gEgo setLoop: 5)
				(local1
					setLoop: 4
					posn: 181 126
					show:
					cel: 0
					setPri: 8
					setCycle: End self
				)
			)
			(12
				(= seconds 5)
			)
			(13
				(Print 692 1 #at -1 20 #time 15) ; "Fainting isn't going to help, Rosella. There's no getting out of this one. You're stuck being Mrs. Edgar for the rest of your life."
				(cls)
				(= seconds 4)
			)
			(14
				(Print 692 2 #at -1 20 #time 15) ; "Not to mention having old Lolotte for a mother-in-law! Good luck...you're going to need it!"
				(cls)
				(User canControl: 1 canInput: 1)
				(= gDeathFlag 1)
			)
		)
	)
)

